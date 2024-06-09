package utilities;

import java.util.Comparator;

public class QuickSort {
    public static <T> void sort(T[] array, Comparator<? super T> comparator) {
        quickSort(array, 0, array.length - 1, comparator);
    }

    private static <T> void quickSort(T[] array, int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            var pivotIndex = partition(array, low, high, comparator);
            quickSort(array, low, pivotIndex - 1, comparator);
            quickSort(array, pivotIndex + 1, high, comparator);
        }
    }

    private static <T> int partition(T[] array, int low, int high, Comparator<? super T> comparator) {
        var pivot = array[high];
        var i = low - 1;
        for (var j = low; j < high; j++)
            if (comparator.compare(array[j], pivot) <= 0) {
                i++; swap(array, i, j);
            }

        swap(array, i + 1, high);
        return i + 1;
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
