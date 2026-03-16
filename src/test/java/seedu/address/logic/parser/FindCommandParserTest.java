package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_CONTAINS_NON_ALPHANUMERIC_CHARACTER;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.TagContainsKeywordsPredicate;

public class FindCommandParserTest {

    private FindCommandParser parser = new FindCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validNameArgs_returnsFindCommand() throws CommandException {
        FindCommand expectedFindCommand =
                new FindCommand(new NameContainsKeywordsPredicate(Arrays.asList("Alice", "Bob")));
        assertParseSuccess(parser, "name Alice Bob", expectedFindCommand);

        assertParseSuccess(parser, " \n name \n \t Alice  \t Bob \t", expectedFindCommand);
    }

    @Test
    public void parse_validTagArgs_returnsFindCommand() throws CommandException {
        FindCommand expectedFindCommand =
                new FindCommand(new TagContainsKeywordsPredicate(Arrays.asList("friend", "classmate")));
        assertParseSuccess(parser, "tag friend classmate", expectedFindCommand);

        assertParseSuccess(parser, " \n tag \n \t friend  \t classmate \t", expectedFindCommand);
    }

    @Test
    public void parse_modeOnly_returnsFindCommandWithNoKeywords() throws CommandException {
        FindCommand expectedNameCommand =
                new FindCommand(new NameContainsKeywordsPredicate(Collections.emptyList()));
        FindCommand expectedTagCommand =
                new FindCommand(new TagContainsKeywordsPredicate(Collections.emptyList()));

        assertParseSuccess(parser, "name", expectedNameCommand);
        assertParseSuccess(parser, "tag", expectedTagCommand);
    }

    @Test
    public void parse_unknownSearchMode_throwsParseException() {
        assertParseFailure(parser, "phone Alice",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidKeyword_throwsCommandException() {
        assertParseFailure(parser, "name Alice Bob!", MESSAGE_CONTAINS_NON_ALPHANUMERIC_CHARACTER);
        assertParseFailure(parser, "tag friend!", MESSAGE_CONTAINS_NON_ALPHANUMERIC_CHARACTER);
    }
}
