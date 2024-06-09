package utilities;

import java.util.Comparator;

/**
 * This class implements the bubble sort
 * algorithm for sorting an array of objects.
 */
public class BubbleSort {
    /**
     * Sorts the specified array of objects
     * using the given comparator.
     *
     * @param array     The array to sort
     * @param comp      The comparator to use for sorting
     */
    public static <T> void sort(T[] array, Comparator<? super T> comp) {
        var n = array.length - 1;
        for (var i = 0; i < n; i++)
            for (var j = 0; j < n - i; j++)
                if (comp.compare(array[j], array[j + 1]) > 0) {
                    var temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }
}
