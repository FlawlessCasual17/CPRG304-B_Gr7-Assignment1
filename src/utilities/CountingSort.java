package utilities;

import shapes.ThreeDShape;

import java.util.Comparator;

public class CountingSort {
    public static void sort(ThreeDShape[] array, Comparator<? super ThreeDShape> comparator) {
        if (array.length == 0) return;

        // Find the maximum height
        var maxHeight = array[0].getHeight();
        for (var shape : array)
            if (shape.getHeight() > maxHeight)
                maxHeight = shape.getHeight();

        // Use the height as the key for counting sort
        var max = (int)maxHeight;
        var output = new ThreeDShape[array.length];
        var count = new int[max + 1];

        // Initialize a count array
        for (var i = 0; i <= max; ++i) count[i] = 0;

        // Store the count of each element
        for (var shape : array)
            count[(int)shape.getHeight()]++;

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
        //noinspection ManualArrayCopy
        for (var i = 0; i < array.length; i++)
            array[i] = output[i];
        // We could alternatively use this:
        // System.arraycopy(output, 0, array, 0, array.length);
        // ↗️ This should be faster since it
        // directly accesses the API of the JVM.
    }
}
