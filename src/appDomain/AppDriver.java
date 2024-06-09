package appDomain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

import shapes.*;
import comparators.*;
import utilities.*;

import java.util.Arrays;

/**
 * This class represents the main driver for the shape sorting application.
 * It parses command-line arguments, reads shapes from a file, sorts them,
 * and prints the sorted shapes.
 */
public class AppDriver {
    /**
     * The main entry point for the application.
     *
     * @param args      Command-line arguments
     */
    public static void main(String[] args) {
        String fileName = null, compareType = null, sortAlgorithm = null;

        // Parse command-line arguments
        for (var arg : args)
            switch (arg.substring(0, 2)) { // A switch statement is faster
                case "-f", "-F" ->
                    fileName = arg.substring(2);
                case "-t", "-T" ->
                    compareType = arg.substring(2);
                case "-s", "-S" ->
                    sortAlgorithm = arg.substring(2);
            }

        // Check if all required arguments are present
        if (fileName == null || compareType == null || sortAlgorithm == null) {
            System.out.println("""
                USAGE

                java -jar Sort.jar -f<file_name> -t<comparison type> -s<sorting algorithm>
                """
            );
            return;
        }

        // Read shapes from file
        var shapes = readShapesFromFile(fileName);
        if (shapes == null) return;

        // Create a comparator based on the specified comparison type
        Comparator<ThreeDShape> comp;
        switch (compareType.toLowerCase()) {
            case "h":
                comp = Comparator.comparingDouble(ThreeDShape::getHeight).reversed();
                break;
            case "v":
                comp = new VolumeComparator().reversed();
                break;
            case "a":
                comp = new BaseAreaComparator().reversed();
                break;
            default:
                System.out.println("Unknown compare type: " + compareType);
                return;
        }

        // Sort the shapes using the specified sorting algorithm
        sortShapes(shapes, comp, sortAlgorithm);

        // Print the sorted shapes
        printSortedShapes(shapes);
    }

    /**
     * Reads 3D shapes from the specified file.
     *
     * @param fileName      The name of the file to read
     * @return              An array of 3D shapes, or null if an error occurs
     */
    private static ThreeDShape[] readShapesFromFile(String fileName) {
        try (var br = new BufferedReader(new FileReader(fileName))) {
            var numShapes = Integer.parseInt(br.readLine().trim());
            var shapes = new ThreeDShape[numShapes];

            for (var i = 0; i < numShapes; i++) {
                var tokens = br.readLine().split(" ");
                var shapeType = tokens[0];
                var height = Double.parseDouble(tokens[1]);
                var dimension = Double.parseDouble(tokens[2]);

                switch (shapeType) {
                    case "Cylinder":
                        shapes[i] = new Cylinder(dimension, height);
                        break;
                    case "Cone":
                        shapes[i] = new Cone(dimension, height);
                        break;
                    case "Pyramid":
                        shapes[i] = new Pyramid(dimension, height);
                        break;
                    case "SquarePrism", "OctagonalPrism":
                    case "TriangularPrism", "PentagonalPrism":
                        shapes[i] = new SquarePrism(dimension, height);
                        break;
                    default:
                        System.out.println("Unknown shape type: " + shapeType);
                        return null;
                }
            }
            return shapes;
        }
        catch (IOException e) {
            System.out.print(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    /**
     * Sorts the specified shapes using the given comparator and sorting algorithm.
     *
     * @param shapes            The shapes to sort
     * @param comp              The comparator to use for sorting
     * @param sortAlgorithm     The sorting algorithm to use
     */
    private static void sortShapes(ThreeDShape[] shapes, Comparator<ThreeDShape> comp, String sortAlgorithm) {
        var startTime = System.currentTimeMillis();
        switch (sortAlgorithm.toLowerCase()) {
            case "b":
                BubbleSort.sort(shapes, comp);
                break;
            case "s":
                SelectionSort.sort(shapes, comp);
                break;
            case "i":
                InsertionSort.sort(shapes, comp);
                break;
            case "m":
                MergeSort.sort(shapes, comp);
                break;
            case "q":
                QuickSort.sort(shapes, comp);
                break;
            case "c":
                CountingSort.sort(shapes, comp);
                break;
            default:
                System.out.println("Unknown sorting algorithm: " + sortAlgorithm);
                return;
        }
        var endTime = System.currentTimeMillis();
        System.out.printf("\nSorting time: %d milliseconds%n\n", endTime - startTime);
    }

    /**
     * Prints the sorted shapes to the console.
     *
     * @param shapes the sorted shapes
     */
    private static void printSortedShapes(ThreeDShape[] shapes) {
        var length = shapes.length;
        System.out.println("First sorted shape: " + shapes[0]);
        if (length > 1000)
            for (var i = 1000; i < length; i += 1000)
                System.out.printf("\nShape at position %d: %s%n", i, shapes[i]);


        System.out.println("Last sorted shape: " + shapes[length - 1]);
    }
}
