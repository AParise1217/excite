# EXCITE
[![Maven Central](https://img.shields.io/maven-central/v/com.parisesoftware/excite-core.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%com.parisesoftware.excite-core%22) [![GitHub license](https://img.shields.io/badge/license-MIT%20License%202.0-blue.svg?style=flat)](http://https://opensource.org/licenses/MIT)

*Extensible XML-based Content and Information Transformation Engine*

## XML Transformations made *groovy*!

___
## Dependency

```xml
<dependency>
    <groupId>com.parisesoftware</groupId>
    <artifactId>excite-core</artifactId>
    <version>1.0.2</version>
</dependency>
```

## Built-in Implementations

| Interface | Implementation | Behavior |
|---|---|---|
| `ITransformationAlgorithm` | `RenameChildNodeTransformation` | Renames all child nodes matching a given name |
| `ITransformationAlgorithm` | `DeleteChildNodeByNameTransformation` | Deletes all child nodes matching a given name |
| `IValidationAlgorithm` | `AcceptAllValidation` | Passes all non-null nodes |
| `IValidationAlgorithm` | `ChildNodeHasValueValidation` | Passes nodes where a named child matches a value |
| `IOutputCommand` | `OverwriteFileOutputCommand` | Atomically overwrites the source file with transformed content |
| `IOutputCommand` | `ConsoleOutputCommand` | Prints transformed content to stdout |

## Usage

```groovy
import com.parisesoftware.excite.core.Excite
import com.parisesoftware.excite.core.internal.transformer.RenameChildNodeTransformation
import com.parisesoftware.excite.core.internal.validation.ChildNodeHasValueValidation
import com.parisesoftware.excite.core.internal.output.OverwriteFileOutputCommand

Excite.run(
    '/path/to/xml/directory',
    new RenameChildNodeTransformation('description', 'description_html'),
    new ChildNodeHasValueValidation('content-type', '/component/article'),
    new OverwriteFileOutputCommand()
)
```

This will recursively scan the directory for XML files, pass each one through the validation algorithm, apply the transformation to those that pass, and write the result back using the output command.

> **Note on XML namespaces:** Groovy's `XmlSlurper` strips namespace prefixes by default. Validation and transformation operate on local element names only; namespace-qualified files are supported but namespace URIs are not accessible via the standard implementations.

___
# Releasing to Maven Central
## Performing a Release Deployment
*Note: This must occur prior to the Release Deployment!*

Make sure the "release-sign-artifacts" and "ossrh" 
    Maven profiles are active.

1) `mvn clean`
2) `mvn release:prepare -Possrh,release-sign-artifacts`
3) `mvn release:perform -Possrh,release-sign-artifacts`

* await the release process to finish *

4) `git push --tags`
5) `git push origin master`

## Updating the Release Version
1) `mvn versions:set -DnewVersion=1.2.3`