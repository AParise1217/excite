# EXCITE
*Extensible XML-based Content and Information Transformation Engine*

## Inputs

### Parent Directory
A String representation of some directory path on the file 
    system local to where EXCITE is being executed. This will recursively crawl 
    all directories below the given directory. 
    Any File found will first be validated against the Validation Algorithm.
    If it is found to be valid, then each file, one at a time, will 
    be processed by the given Transformation Algorithm.

### Validation Algorithm
A Predicate that takes in a GPathResult. The GPathResult that is passed
    in is a parsed out version of the current file found in the Parent Directory.
    If this Predicate yields true, then the file will continue on and be processed by the
    Transformation Algorithm. Otherwise, it is skipped.

### Transformation Algorithm
A Closure to perform the work needed in the Transformation. 
    This will execute once for each XML File found in the 
    provided Parent Directory.

#### Params
*StreamingMarkupBuilder* context. This is 
    populated with the present state of the component prior
    to execution.

*GPathResult*. This is the parsed, present state of the given 
    XML Document.
    
### Output Method
A Closure that defines how the resultant transformed component is to be handled. 
    This can be writing to the console logs, overwriting the input file, etc.

#### Params
*Initial File*. This is the original component prior to the transformation.

*Transformed Content*. A String representation of the content in it's transformed state.

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