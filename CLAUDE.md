# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

EXCITE (Extensible XML-based Content and Information Transformation Engine) is a Groovy/Maven library that batch-transforms XML files in a directory. It scans a directory for XML files, filters them through a validation algorithm, applies a transformation algorithm to each passing file, and routes the result through an output command.

## Build & Test Commands

```bash
# Build all modules
mvn clean install

# Run tests only
mvn test

# Run a single test class
mvn test -pl excite-core -Dtest=AcceptAllValidationTest

# Build without tests
mvn clean install -DskipTests

# Release to Maven Central (requires ossrh + GPG profiles active)
mvn release:prepare -Possrh,release-sign-artifacts
mvn release:perform -Possrh,release-sign-artifacts

# Update version
mvn versions:set -DnewVersion=1.2.3
```

## Architecture

The project has two Maven modules:

- **`excite-core`** — the library; all logic lives here
- **`excite-commandline`** — a thin demo runner (`ExciteCLIRunner`) that wires up core components and calls `Excite.run()`

### Core execution flow

`Excite.run(directory, transformation, validation, output)` → `ExciteFacadeImpl` →
1. `FileSystemService` scans the directory for XML files (filtered by `FilePredicate.isXmlFile`)
2. `FileParser` parses each file into a `GPathResult` (Groovy XML slurper)
3. `IValidationAlgorithm.validate(GPathResult)` — skip the file if false
4. `MarkupTransformer.transform(GPathResult, ITransformationAlgorithm)` — mutates the node in-place via `ITransformationAlgorithm.execute()`, then re-serializes with `StreamingMarkupBuilder` + `XmlUtil`
5. `IOutputCommand.execute(File, String)` — writes or prints the result

### Extension points (Strategy pattern)

All three are interfaces in `com.parisesoftware.excite.core.api`:

| Interface | Purpose | Built-in implementations |
|---|---|---|
| `ITransformationAlgorithm` | Mutates a `GPathResult` in-place | `RenameChildNodeTransformation`, `DeleteChildNodeByNameTransformation` |
| `IValidationAlgorithm` | Returns true/false for a `GPathResult` | `AcceptAllValidation`, `ChildNodeHasValueValidation` |
| `IOutputCommand` | Handles the serialized output string | `ConsoleOutputCommand`, `OverwriteFileOutputCommand` |

`ValidationMethod` and `OutputMethod` are convenience classes that expose the built-in implementations as static `Predicate`/`Closure` constants.

### Testing

Tests are written with **Spock** (Groovy 5 / Spock 2.4). Test sources live in `src/test/groovy`. The GMavenPlus plugin compiles both production and test Groovy sources; there are no separate Java sources.
