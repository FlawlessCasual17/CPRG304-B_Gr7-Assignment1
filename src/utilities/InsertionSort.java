package utilities;

import java.util.Comparator;

public class InsertionSort {
    public static <T> void sort(T[] array, Comparator<? super T> comparator) {
        for (var i = 1; i < array.length; i++) {
            var key = array[i];
            var j = i - 1;
            while (j >= 0 && comparator.compare(array[j], key) > 0) {
                array[j + 1] = array[j]; j--;
            }
            array[j + 1] = key;
        }
    }
}
