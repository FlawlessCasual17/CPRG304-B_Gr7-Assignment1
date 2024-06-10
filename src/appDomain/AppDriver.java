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

                1. Running with Gradle

                gradle execJar "--args= -f<file_name> -t<compare_type> -s<shape_type>"


                2. Running with `java`

                java -jar 'build/libs/Sort.jar' -f<file_name> -t<compare_type> -s<shape_type>

                3. Or using the **run** scripts

                ./run -f<file_name> -t<compare_type> -s<shape_type>

                .\\run.bat -f<file_name> -t<compare_type> -s<shape_type>

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
