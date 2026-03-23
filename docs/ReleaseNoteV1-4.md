# Release Notes

## [v1.4] - 2026-03-26


<!-- use this header format and name it appropriately, lets not use feature 1/2/3 -->
### Changes from MVP to Alpha Release - Addition Of `Busy` Command
- Added `busy` command to mark contacts as unavailable for specific periods.
- Implemented strict date validation for all date-related inputs.
- Enhanced the UI to display busy periods on contact cards.
- Made contact fields, including busy periods, copyable by clicking.

### Changes from MVP to Alpha Release - Optional Fields for Contacts
- Modified the `add` command so that `Role`, `Phone`, `Email`, and `Address` are completely optional fields (only `Name` remains strictly required).
- Adjusted the `PersonCard` contact user interface to dynamically collapse and hide missing fields, creating a cleaner viewing layout for concise profiles.
- Streamlined success command message formats to elegantly omit fields that were not provided.
- Persisted data safely handling missing fields through improved JSON mapping logic using `java.util.Optional`.

### Changes from MVP to Alpha Release - ABC bla bla bla


#### Product UI


### Improvements



### Bug Fixes


### Documentation
- Updated the User Guide.
- Updated the Developer Guide.

---
Done by: CS2103T-W13-3

