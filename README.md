# AVAJ Launcher

A small airport logistics simulation used to analyze runway bottlenecks at Frankfurt
airport.

## Project overview

The chief designer produced a high-level design and asked the development team to
implement a simulator in Java. The simulator should be extensible and follow classic
object-oriented practices and design patterns so it can be adapted to future needs.

### Provided by the architect

- A UML class diagram describing the initial domain model
- A set of required Object-Oriented design patterns to incorporate (see below)

### Goals

- Simulate multiple scenarios (weather, traffic, runway availability)
- Provide a clear model using design patterns for maintainability and extensibility
- Produce output that helps detect and analyze runway bottlenecks

## Required knowledge

- Reading and interpreting UML class diagrams (the architect's primary communication)
- Java and its core syntax/features
- The following design patterns: Observer, Singleton, Factory

These patterns are used to make the simulator modular and easy to extend.

## Files in this repository

- `scenario.txt` — example or input scenarios
- `global.puml` — PlantUML diagram source
