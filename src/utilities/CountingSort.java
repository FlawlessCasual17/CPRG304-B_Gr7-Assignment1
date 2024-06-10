package utilities;

import shapes.ThreeDShape;

import java.util.Comparator;

/**
 * This class implements the counting sort algorithm for sorting an array of 3D shapes.
 */
public class CountingSort {
    /**
     * Sorts the specified array of 3D shapes using the given comparator.
     *
     * @param array     The array to sort
     * @param comp      The comparator to use for sorting
     */
    public static void sort(ThreeDShape[] array, Comparator<? super ThreeDShape> comp) {
        if (array.length == 0) return;

        // Compare the elements in the array
        var max = array[0];
        for (var shape : array)
            if (comp.compare(shape, max) > 0)
                max = shape;

        // Use the height of the maximum element as the key for counting sort
        var maxHeight = max.getHeight();

        // Initialize a count array
        var count = new int[(int)(maxHeight + 1)];
        for (var i = 0; i <= maxHeight; ++i)
            count[i] = 0;

        // Store the count of each element
        for (var shape : array)
            count[(int)shape.getHeight()]++;

        // Modify a count array
        for (var i = 1; i <= maxHeight; ++i)
            count[i] += count[i - 1];

        // Build the output array
        var output = new ThreeDShape[array.length];
        for (var i = array.length - 1; i >= 0; i--) {
            var shape = array[i];
            output[count[(int)shape.getHeight()] - 1] = shape;
            count[(int)shape.getHeight()]--;
        }

        // Copy the output array to the original array
        //noinspection ManualArrayCopy
        for (var i = 0; i < array.length; i++)
            array[i] = output[i];
        // We could alternatively use this:
        // System.arraycopy(output, 0, array, 0, array.length);
        // ↗ This should be faster since it
        // directly accesses the API of the JVM.
    }
}
