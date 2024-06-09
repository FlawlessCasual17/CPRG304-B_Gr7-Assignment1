package appDomain;

import shapes.*;
import utilities.*;

import java.io.*;
import java.util.*;

public class Helpers {
    /**
     * Reads 3D shapes from the specified file.
     *
     * @param fileName
     *     The name of the file to read
     *
     * @return An array of 3D shapes, or null if an error occurs
     */
    public static ThreeDShape[] readShapesFromFile(String fileName) {
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
                    case "SquarePrism":
                        shapes[i] = new SquarePrism(dimension, height);
                        break;
                    case "OctagonalPrism":
                        shapes[i] = new OctagonalPrism(dimension, height);
                        break;
                    case "TriangularPrism":
                        shapes[i] = new TriangularPrism(dimension, height);
                        break;
                    case "PentagonalPrism":
                        shapes[i] = new PentagonalPrism(dimension, height);
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
     * @param shapes
     *     The shapes to sort
     * @param comp
     *     The comparator to use for sorting
     * @param sortAlgorithm
     *     The sorting algorithm to use
     */
    public static void sortShapes(ThreeDShape[] shapes, Comparator<ThreeDShape> comp, String sortAlgorithm) {
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
     * @param shapes
     *     the sorted shapes
     */
    public static void printSortedShapes(ThreeDShape[] shapes) {
        var length = shapes.length;
        System.out.println("First sorted shape: " + shapes[0]);
        if (length > 1000) for (var i = 1000; i < length; i += 1000) {
            System.out.printf("\nShape at position %d: %s%n", i, shapes[i]);
        }


        System.out.println("Last sorted shape: " + shapes[length - 1]);
    }
}
