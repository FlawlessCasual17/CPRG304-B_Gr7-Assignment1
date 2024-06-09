package utilities;

import java.util.Comparator;

public class BubbleSort {
    public static <T> void sort(T[] array, Comparator<? super T> comparator) {
        var n = array.length - 1;
        for (var i = 0; i < n; i++)
            for (var j = 0; j < n - i; j++)
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    var temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }
}
