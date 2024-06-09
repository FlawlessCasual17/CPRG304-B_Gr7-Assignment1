package utilities;

import java.util.Comparator;

public class SelectionSort {
    public static <T> void sort(T[] array, Comparator<? super T> comp) {
        for (var i = 0; i < array.length - 1; i++) {
            var minIdx = i;
            for (var j = i + 1; j < array.length; j++)
                if (comp.compare(array[j], array[minIdx]) < 0)
                    minIdx = j;

            var temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }
    }
}
