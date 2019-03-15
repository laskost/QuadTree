# QuadTree
This is my Quadtree implementation in Java. 

Poin Class:
creates a Point object (x,y)
methods which compute distances between two points distance(point p1, point p2) and distance(point p1,double x, double y)

Boundry Class:
creates a rectangle boundry (xMin,yMin,xMax,yMax)
inRange method(x,y) returns true if (x,y) is in the boundry
contains method(Point) checks if a point is within the boundry (same as inRange)
intersects method(Boundry1, Boundry2) retruns true if there is an intersection between thes two boundries.

MyQtree Class:
creates a Quadtree. Constructor(boundry,level).
insert method(Point). Inserts a point into Quadtree.
subdivide method. Subdivides the tree if points surpass capacity of a leaf.
printQtree method prints the quadtree.
query method(x,y,range,listOfPoints) returns a list of Points that are close to a given point within a given range.
In main method i run a simple range query. 
