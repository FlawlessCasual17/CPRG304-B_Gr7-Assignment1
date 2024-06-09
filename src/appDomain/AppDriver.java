package appDomain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

import shapes.*;
import comparators.*;
import utilities.*;

import java.util.Arrays;

public class AppDriver {

    public static void main(String[] args) {
        String fileName = null;
        String compareType = null;
        String sortAlgorithm = null;

        for (String arg : args) {
            if (arg.startsWith("-f") || arg.startsWith("-F")) {
                fileName = arg.substring(2);
            } else if (arg.startsWith("-t") || arg.startsWith("-T")) {
                compareType = arg.substring(2);
            } else if (arg.startsWith("-s") || arg.startsWith("-S")) {
                sortAlgorithm = arg.substring(2);
            }
        }

        if (fileName == null || compareType == null || sortAlgorithm == null) {
            System.out.println("Usage: java -jar Sort.jar -f<file_name> -t<comparison type> -s<sorting algorithm>");
            return;
        }

        ThreeDShape[] shapes = readShapesFromFile(fileName);
        if (shapes == null) {
            return;
        }

        Comparator<ThreeDShape> comparator;
        switch (compareType.toLowerCase()) {
            case "h":
                comparator = Comparator.comparingDouble(ThreeDShape::getHeight).reversed();
                break;
            case "v":
                comparator = new VolumeComparator().reversed();
                break;
            case "a":
                comparator = new BaseAreaComparator().reversed();
                break;
            default:
                System.out.println("Unknown compare type: " + compareType);
                return;
        }

        sortShapes(shapes, comparator, sortAlgorithm);

        printSortedShapes(shapes);
    }

    private static ThreeDShape[] readShapesFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int numShapes = Integer.parseInt(br.readLine().trim());
            ThreeDShape[] shapes = new ThreeDShape[numShapes];

            for (int i = 0; i < numShapes; i++) {
                String[] tokens = br.readLine().split(" ");
                String shapeType = tokens[0];
                double height = Double.parseDouble(tokens[1]);
                double dimension = Double.parseDouble(tokens[2]);

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
                        shapes[i] = new SquarePrism(dimension, height);
                        break;
                    case "TriangularPrism":
                        shapes[i] = new SquarePrism(dimension, height);
                        break;
                    case "PentagonalPrism":
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
            e.printStackTrace();
            return null;
        }
    }

    private static void sortShapes(ThreeDShape[] shapes, Comparator<ThreeDShape> comparator, String sortAlgorithm) {
        long startTime = System.currentTimeMillis();
        switch (sortAlgorithm.toLowerCase()) {
            case "b":
                BubbleSort.sort(shapes, comparator);
                break;
            case "s":
                SelectionSort.sort(shapes, comparator);
                break;
            case "i":
                InsertionSort.sort(shapes, comparator);
                break;
            case "m":
                MergeSort.sort(shapes, comparator);
                break;
            case "q":
                QuickSort.sort(shapes, comparator);
                break;
            case "c":
                CountingSort.sort(shapes, comparator);
                break;
            default:
                System.out.println("Unknown sorting algorithm: " + sortAlgorithm);
                return;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Sorting time: " + (endTime - startTime) + " milliseconds");
    }

    private static void printSortedShapes(ThreeDShape[] shapes) {
        int length = shapes.length;
        System.out.println("First sorted shape: " + shapes[0]);
        if (length > 1000) {
            for (int i = 1000; i < length; i += 1000) {
                System.out.println("Shape at position " + i + ": " + shapes[i]);
            }
        }
        System.out.println("Last sorted shape: " + shapes[length - 1]);
    }
}
