package utilities;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {
    public static <T> void sort(T[] array, Comparator<? super T> comparator) {
        if (array.length > 1) {
            int mid = array.length / 2;
            T[] left = Arrays.copyOfRange(array, 0, mid);
            T[] right = Arrays.copyOfRange(array, mid, array.length);

            sort(left, comparator);
            sort(right, comparator);

            merge(array, left, right, comparator);
        }
    }

    private static <T> void merge(T[] result, T[] left, T[] right, Comparator<? super T> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) <= 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }
}