import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int X1 = scanner.nextInt();
        int Y1 = scanner.nextInt();
        int X2 = scanner.nextInt();
        int Y2 = scanner.nextInt();
        
        // Create Point objects for the two coordinates
        Point p1 = new Point(X1, Y1);
        Point p2 = new Point(X2, Y2);

        // Call the findDistance method and print the result
        double distance = findDistance(p1, p2);

        System.out.printf("%.3f", distance);
        
        scanner.close();
    }

    // Method to find distance between two points
    public static double findDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    // Point class representing a 2D coordinate
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
/*

2. Find distance between 2D coordinates

Consider two dimension system with X and Y coordinates.

Write a program to find distance between two points, say X1,Y1 and X2,Y2.

Display the answer rounded to three digits after decimal.

The input will be provided as four numbers separated by space.

E.g. 4 4 7 8

Here, X1 will be 4, Y1 will be 4, X2 will be 7 and Y2 will be 8.

Assume that input numbers will not have any decimal values.

The output with these values will be 5.000

 */