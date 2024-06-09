package utilities;

import java.util.Comparator;

public class SelectionSort {
    public static <T> void sort(T[] array, Comparator<? super T> comparator) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(array[j], array[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            T temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }
    }
}
