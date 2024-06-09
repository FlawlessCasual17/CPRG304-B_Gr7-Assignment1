package utilities;

import shapes.ThreeDShape;
import java.util.Comparator;

public class CountingSort {
    public static void sort(ThreeDShape[] array, Comparator<? super ThreeDShape> comparator) {
        if (array.length == 0) return;

        // Find the maximum height
        double maxHeight = array[0].getHeight();
        for (ThreeDShape shape : array) {
            if (shape.getHeight() > maxHeight) {
                maxHeight = shape.getHeight();
            }
        }

        // Use the height as the key for counting sort
        int max = (int) maxHeight;
        ThreeDShape[] output = new ThreeDShape[array.length];
        int[] count = new int[max + 1];

        // Initialize count array
        for (int i = 0; i <= max; ++i) {
            count[i] = 0;
        }

        // Store the count of each element
        for (ThreeDShape shape : array) {
            count[(int) shape.getHeight()]++;
        }

        // Modify count array
        for (int i = 1; i <= max; ++i) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = array.length - 1; i >= 0; i--) {
            ThreeDShape shape = array[i];
            output[count[(int) shape.getHeight()] - 1] = shape;
            count[(int) shape.getHeight()]--;
        }

        // Copy the output array to the original array
        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }
}
