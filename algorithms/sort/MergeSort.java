package algorithms.sort;

import java.util.Arrays;

public class MergeSort {
    public MergeSort(){
    }

    public static int[] mergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid + 1, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int idx = 0, i = 0, j = 0; idx < result.length; idx++) {
            if (i >= left.length) {
                result[idx] = right[j++];
            } else if (j >= right.length) {
                result[idx] = left[i++];
            } else if (left[i] > right[j]) {
                result[idx] = right[j];
            } else {
                result[idx] = left[i++];
            }
        }
        return result;
    }
}