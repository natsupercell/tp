# Release Notes

## [v1.4] - 2026-03-26


<!-- use this header format and name it appropriately, lets not use feature 1/2/3 -->
### Changes from MVP to Alpha Release - Addition Of `Busy` Command
- Added `busy` command to mark contacts as unavailable for specific periods.
- Implemented strict date validation for all date-related inputs.
- Enhanced the UI to display busy periods on contact cards.
- Made contact fields, including busy periods, copyable by clicking.

#### Product UI
<img src="images/ProductUI_V1-4_busy.png" width="500px">

### Changes from MVP to Alpha Release - Addition of `BusyFilter` Command
- Introduced the `busyfilter` command, allowing users to filter contacts based on whether they are busy during a specified date range.
- Implemented overlap logic to accurately determine if a contact's busy periods intersect with the specified range.
- Updated parser and command infrastructure to support input validation and seamless integration with existing contact list filtering.

### Changes from MVP to Alpha Release - ABC bla bla bla


### Improvements
- Helps users avoid scheduling meetings during contacts' peak busy periods.

### Bug Fixes


### Documentation
- Updated the User Guide.
- Updated the Developer Guide.

---
Done by: CS2103T-W13-3

