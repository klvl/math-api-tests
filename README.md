# The math API tests

This repository contains recruitment challenge for QAA position.

## Recruitment challenge description

* Create 5 test cases for [api.mathjs.org](http://api.mathjs.org/) with GET and POST requests
* Use boundary values and equivalence partitioning test design techniques
* Use Java + Gradle + JUnit5
* Limit yourself with the following libraries
  * Async http client
  * AssertJ
  * Gson


## Troubleshooting

**The main and test directory are marked as modules in Intellij IDEA:** put the following line in the `.idea/gradle.xml`:
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