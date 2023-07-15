# Flight and Airspace

### Objective
Given you have a **Flight** instance and **Airspace** instances
1. **Problem #1** - Enhance the Flight class to allow its user to determine where it is located.
2. **Problem #2** - Given an instance of a Flight, and an instance of an Airspace, enhance the code to allow users to determine if the flight is within the airspace

### Source Code Location

1. All source codes are located at **src/main/java/com/tuhin/examples/techtest/**
2. Test class can be found at **src/test/java/com/tuhin/examples/techtest/FindFlightTest.java**
3. Test resource can be found at **src/test/resources/techtest**

### How it has been implemented
1. I have enhanced given **Flight** class and added a new member called **currentCoordinate** (instance of Coordinate class)
2. I have created a **FlightPositionFinder** class which determines flight is in which airspace.
   1. it takes an instance of flight and list of airspaces to locate the flight
   2. it compares whether flight's X axis is within X axis range for an Airspace's bottom left and top right Coordinates
   3. it also compares whether flight's Y axis is within Y axis range for an Airspace's bottom left and top right Coordinates
   4. As soon as above two condition satisfies, it returns that airspace which is eventually a known airspace where flight is located
   5. If condition fails, that means, flight is current at **unknown** airspace

### Test Note (FindFlightTest.java)
1. Please refer, **Aerospace Usecase.xlsx** file which depicts an **airspace map**, I plotted for understanding of the use case
2. Refer to **red dot** in the diagram, which is a flight's Coordinate
3. For Problem 1, test just sets a Coordinate of a flight and tells the flight's Coordinate. This just explain the functionality how it enhanced the **Flight** class
4. For Problem 2 and 3, test tells flight is currently at which airspace.
   1. I have created an **airspace.json** to list some of the airspaces like London, Dubai, Kolkata etc.
   2. Using object mapper, I am generating a list of airspaces from the json.
   3. I had to **create a default constructor** and hence I modified the given Airspace and Coordinate classes slightly
   4. We can keep existing classes and in that case we just need to uncomment the airspace instance creation code in test

### Build Note
1. This code is built on Java 11
2. If you need library for junit5 and jackson, please download from **lib** folder