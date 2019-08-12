# EXCITE
[![Maven Central](https://img.shields.io/maven-central/v/com.parisesoftware/excite-core.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%com.parisesoftware.excite-core%22) [![GitHub license](https://img.shields.io/badge/license-MIT%20License%202.0-blue.svg?style=flat)](http://https://opensource.org/licenses/MIT)

*Extensible XML-based Content and Information Transformation Engine*

## XML Transformations made *groovy*!

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