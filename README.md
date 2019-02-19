# refactoring-exercise-java

Version: 0.9.0

## Status
The refactoring is done.

## Known Issues
- No domain model.
- No application.
- Low unit test coverage.
- Low end-to-end test coverage.

Given the existing code base was a refactoring test (and thus not a *real* application with worked out domain model and an actual existing application), it was unfeasible to create a better package structure (modeled according to a layered architecture). All classes are thus contained in the base ```com.etraveli.rental``` package.

## Description
This is a candidate test project part of the recruiting process at eTraveli. The task was to fork [the original project](https://github.com/greatersum/refactoring-exercise-java/) and refactor it according to "how I wished the code looked like".

What I've focused on is basically:

-  Separate code in functions so that every function has a single responsibility.
- Refactor the unit test into a classical "xUnit" test by making the xUnit model apparent in the test and also adding a base test class.
- Break out concepts in code into classes. Also replace hard-coded values with enums.
- Add files to .gitignore.
- Create README with focus on describing the status of the project, a description of it and how to build and test the code.
- Created *develop* and *feature* branch (for this refactoring task) to the single *master* branch of the repository.
- Add comments to the code, where needed.

Note that normally I model the application by some kind of layered architecture, e.g. the *Hexagonal Architecture* pattern. In this project however, it's not possible due to the lack of domain model and application. Thus, there are anemic domain models (lacking business logic in the classes).

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