package util;

import model.Palavra;

public class Quicksort {

    public void quickSort(Palavra[] vetor) {
        quickSort(vetor, 0, vetor.length - 1);
    }

    private static void swap(Palavra[] array, int i, int j) {
        Palavra tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static int partition(Palavra arr[], int left, int right) {
        Palavra pivot = arr[(left + right) / 2];

        while (left <= right) {

            while (arr[left].getQntBuscas() < pivot.getQntBuscas()) {
                left++;
            }

            while (arr[right].getQntBuscas() > pivot.getQntBuscas()) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void quickSort(Palavra arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }
}
