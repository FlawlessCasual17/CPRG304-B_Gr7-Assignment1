package appDomain;

import java.util.Comparator;

import shapes.*;
import comparators.*;

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
        var shapes = Helpers.readShapesFromFile(fileName);
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
        Helpers.sortShapes(shapes, comp, sortAlgorithm);

        // Print the sorted shapes
        Helpers.printSortedShapes(shapes);
    }
}
