package utilities;

import shapes.ThreeDShape;

import java.util.Arrays;

/**
 * This class implements the counting sort
 * algorithm for sorting an array of 3D shapes.
 */
public class CountingSort {
    /**
     * Sorts the elements of an array by counting the number
     * of each unique element occurrence in the array.
     *
     * @param array     The array to sort
     */
    public static void sort(ThreeDShape[] array) {
        if (array.length == 0) return;

        // Find the maximum height
        var maxHeight = array[0].getHeight();

        // Compare the elements in the array
        for (var shape : array)
            if (shape.getHeight() > maxHeight)
                maxHeight = shape.getHeight();

        // Use the height of the maximum element as the key for counting sort
        var max = (int)maxHeight;
        var output = new ThreeDShape[array.length];

        // Initialize a count array
        var count = new int[max + 1];
        for (var i = 0; i <= max; ++i)
            count[i] = 0;

        // Store the count of each element
        Arrays.stream(array)
            .forEach(shape -> count[(int)shape.getHeight()]++);

        // Modify a count array
        for (var i = 1; i <= max; ++i)
            count[i] += count[i - 1];

        // Build the output array
        for (var i = array.length - 1; i >= 0; i--) {
            var shape = array[i];
            output[count[(int)shape.getHeight()] - 1] = shape;
            count[(int)shape.getHeight()]--;
        }

        // Copy the output array to the original array
        System.arraycopy(output, 0, array, 0, array.length);
    }
}
