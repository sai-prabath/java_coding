import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Point p1 = new Point(scanner.nextDouble(), scanner.nextDouble());
        Point p2 = new Point(scanner.nextDouble(), scanner.nextDouble());
        Point p3 = new Point(scanner.nextDouble(), scanner.nextDouble());

        // Getting the point with the highest distance from origin
        Point highestDistancePoint = pointWithHighestOriginDistance(p1, p2, p3);

        // Printing the point with the highest distance from origin
        System.out.println(highestDistancePoint.x);
        System.out.println(highestDistancePoint.y);

        scanner.close();
    }

    // Method to calculate the distance of a point from the origin (0, 0)
    public static double distanceFromOrigin(Point p) {
        return Math.sqrt(Math.pow(p.x, 2) + Math.pow(p.y, 2));
    }

    // Method to find the point with the highest distance from the origin
    public static Point pointWithHighestOriginDistance(Point p1, Point p2, Point p3) {
        double distance1 = distanceFromOrigin(p1);
        double distance2 = distanceFromOrigin(p2);
        double distance3 = distanceFromOrigin(p3);

        // Comparing distances and returning the point with the highest distance
        if (distance1 >= distance2 && distance1 >= distance3) {
            return p1;
        } else if (distance2 >= distance1 && distance2 >= distance3) {
            return p2;
        } else {
            return p3;
        }
    }

    // Class representing a 2D point
    static class Point {
        double x;
        double y;

        // Constructor for Point class
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}



/*

Question 1:

1. Compare 2D points for distance from origin

Write a program to check distance of 2D points from origin and print the point with highest distance

Create class Point with attributes as below:
double x
double y

In Solution class, define main method to read values for three point objects.

Next, create below method in Solution class which will take three point objects as input parameters and return the point with highest distance from origin.
public static Point pointWithHighestOriginDistance(Point p1, Point p2, Point p3)

Consider sample input as below to read values for six point objects

input:
2
2
3
3
-4
-4

Output:
-4.0
-4.0

 */