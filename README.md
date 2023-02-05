# The math API tests

This repository contains recruitment challenge for QAA position.

* Create 5 test cases for [api.mathjs.org](http://api.mathjs.org/) with GET and POST requests
* Use boundary values and equivalence partitioning test design techniques
* Use Java + Gradle + JUnit5
* Limit yourself with the following libraries
  * Async http client
  * AssertJ
  * Gson
* Mark each test or group of tests with the unique `@Tag` annotation  
* All tests should be built to a Jar file and if there is a parameter, in a run command — run all tests with this key,
if there is no parameter — run all tests


## Run tests

* Build jar
```shell
./gradlew clean jar
```
* Run all tests 
```shell
java -jar build/libs/math-api-tests-1.0.jar
```
* Run tests by tag
```shell
java -jar build/libs/math-api-tests-1.0.jar positive
```


## Troubleshooting

* The `main` and `test` directories are marked as modules in Intellij IDEA — add the `resolveModulePerSourceSet` option
to the `.idea/gradle.xml` file:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project version="4">
  ...
  <GradleProjectSettings>
    <option name="resolveModulePerSourceSet" value="false" />
  </GradleProjectSettings>
  ...
</project>
```