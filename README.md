
# refactoring-exercise-java

Version: 0.9.1

## Status
A basic "low-level" refactoring and a second "high-level" refactoring has been completed.

## Known Issues
- Fictitious domain model.
- No actual application.
- Low unit test coverage.
- Low end-to-end test coverage.

Because this is a candidate test, the issues above aren't really issues, but they would be if this would be an actual project at a company.

## Description
This project is a "refactoring test" part of the recruiting process at eTraveli.

The task is to refactor a code base according to "how I would like to see the code". The code doesn't contain any actual application, just a few classes and a single unit test.

Given it's a fictitious business, the domain model itself is also fictitious. Thus, instead of talking to stakeholders to map out the domain model, I've had to assume this.

The approach to this task was basically:

1. Analyze the code, figure out entities and how they relate. Also derive use cases (which turned out to be a single one - "create rental record statement").
2. Do a basic refactoring (according to general coding principles). This involved:
    - Separating functions that had multiple responsibilities out into new methods with single responsibilities.
    - Create classes from concepts hidden in the code (like e.g. MovieCost).
    - Replace hard coded values with enums.
    - Refactor the unit tests into the battle tested [xUnit](https://en.wikipedia.org/wiki/XUnit) model. This involved creating a base test class and use the Java implementation of xUnit ([JUnit](https://junit.org/junit5/)).
    - Create a README with a structure allowing for more members to join the team of the code base (this file), and also describe current status and known issues to enable a quick overview of the project.
    - Add some files to gitignore.
    - Configure gradle (update gradle.build file), to output differences in failing equality assertions of the tests, and to display text written to standard out to ease debugging.
    - The project had a single "master" branch, so I prepared the project for multiple developers by porting the branching model to the [GitFlow](https://nvie.com/posts/a-successful-git-branching-model/) model. This simply meant creating a "develop" branch and started working on "feature" branches.
    - Add comments, where needed.
3. After the basic refactoring, I had something that was easier to work with for "Refactoring number 2". In this refactoring I focused on the code base at a "higher level". I transformed the code base into a layered architecture ([Hexagonal Architecture](https://fideloper.com/hexagonal-architecture)). This involved:
    - Moving business logic into the entity models. 
    - Move calculation logic that didn't fit in any entity to a new domain service class (RecordService).
    - Break out the hard-coded movies database into a MockMovieRepository class.
    - Refactor the package (and folder) structure to reflect the (now refined) domain model.

## Testing

To run the tests:

```bash
$ cd <root>
$ gradle test
```

## Build
To build the project:

``` bash
$ cd <root>
$ gradle build
```

## Run
This project is a candidate refactoring test, so there's no application to be run.

## Clean
To clean the project:

``` bash
$ cd <root>
$ gradle clean
```