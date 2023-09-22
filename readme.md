# IntelliMapLab Hackathon

## Context and Problem Statement
The task involves addressing a practical issue concerning recommendation services for navigation.
You are given a list of countries with their names and border information in the form of coordinate lists.
Additionally, there is a list of airports with their coordinates.
Each airport is associated only with one country, but in each country could be many airports.
In your implementation, you need to take care of the validity and efficiency of your solution.
The main idea is to find the nearest airport to the given coordinates within the country.
There is already an implemented [Polygon] class that could help you with checking if the point is inside the country.

## Task statement
* Create your branch
* Read existing codebase
* Implement methods in [Airport finder]
* Cover your solution with unit tests
* Commit and push your changes
* Create pull request

## Restrictions
You should not change signature of existing methods, but you could introduce yours.

[Polygon]: src/main/java/com/intellias/hackathon/Polygon.java
[Airport finder]: src/main/java/com/intellias/hackathon/AirportFinder.java