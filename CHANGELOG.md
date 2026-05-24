# Changelog

All notable changes to this project will be documented in this file.

## [Unreleased]

### Added
- Null-parameter validation on `Excite.run()` — throws `IllegalArgumentException` for null arguments
- Directory existence validation in `FileSystemService` — throws `ExciteException` for invalid paths
- Dependency-injection constructor on `ExciteFacadeImpl` and `Excite.facadeWith()` factory for testing
- Default no-predicate overload on `IFileSystemService.getFilesInDirectory()`
- SLF4J logging throughout the pipeline (DEBUG/INFO/WARN/ERROR)
- Comprehensive Spock test suite covering all pipeline components
- Atomic write strategy in `OverwriteFileOutputCommand` (write-temp-then-rename)
- `.github/dependabot.yml` for weekly Maven dependency updates
- `ExciteCLIRunner` now accepts `<directory> [console|file]` arguments
- `CHANGELOG.md`

### Changed
- `MarkupTransformer` serialization simplified — removed redundant `StreamingMarkupBuilder` wrapper
- `ChildNodeHasValueValidation` now correctly handles null nodes and uses `.text()` for comparison
- `FilePredicate.isXmlFile` is now case-insensitive (matches `.XML`, `.Xml`, etc.)
- `FileParser` now reads files with explicit UTF-8 encoding

### Removed
- Unused `commons-lang3` dependency
- Stale `<revision>` property in parent POM
- Hardcoded developer file path in `ExciteCLIRunner`

## [1.0.2] - 2021-01-01

### Changed
- Dependency updates

## [1.0.1] - 2020-06-01

### Changed
- Refactored strategy interfaces (`ITransformationAlgorithm`, `IValidationAlgorithm`, `IOutputCommand`) from closures to proper Groovy interfaces
- Added `ExciteException` for domain-specific error handling

## [1.0.0] - 2020-01-01

### Added
- Initial release of `excite-core` and `excite-commandline`
- XML file scanning, validation, transformation, and output pipeline
- `RenameChildNodeTransformation`, `DeleteChildNodeByNameTransformation`
- `AcceptAllValidation`, `ChildNodeHasValueValidation`
- `OverwriteFileOutputCommand`, `ConsoleOutputCommand`
