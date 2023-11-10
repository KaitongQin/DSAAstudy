package MidtermSummary;

import java.util.concurrent.ThreadLocalRandom;

public class sort{
    public static void main(String[] args){
//        int[] array = new int[8];
//        for(int i = 0; i < array.length; i++) {
//            array[i] = ThreadLocalRandom.current().nextInt(0,100);
//        }
        int[] array = {1, 6, 8, 3, 7, 2, 5, 4};
        printArray(array);
//        int count = bubbleSort(array);
//        System.out.println(count);
//        selectionSort(array);
        quickSort(array, 0, array.length - 1);
        printArray(array);
    }
    public static int bubbleSort (int[] array) {
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                count++;
                if (array[j + 1] < array[j]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
            printArray(array);
        }
        return count;
    }
    public static void selectionSort (int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[k]) {
                    k = j;
                }
            }
            int tmp = array[i];
            array[i] = array[k];
            array[k] = tmp;
            printArray(array);
        }
    }
    public static void insertionSort (int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >= 1; j--) {
                if(array[j - 1] > array[j]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
            printArray(array);
        }
    }
    public static void printArray (int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void mergeSort(int[] array) {
        int[] tmp = new int[array.length];
        merge(array, tmp, 0, array.length - 1);
    }
    public static void merge(int[] array, int[] tmp, int l, int r) {
        if(l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        merge(array, tmp, l, mid);
        merge(array, tmp, mid + 1, r);
        merge_sort(array, tmp, l, mid, r);
    }
    public static void merge_sort(int[] array, int[] tmp, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int k = l;
        while(i <= mid && j <= r) {
            if(array[i] < array[j]) {
                tmp[k] = array[i];
                i++;
                k++;
            } else {
                tmp[k] = array[j];
                j++;
                k++;
            }
        }
        while(i <= mid) {
            tmp[k] = array[i];
            k++;
            i++;
        }
        while(j <= r) {
            tmp[k] = array[j];
            k++;
            j++;
        }
        while(l <= r) {
            array[l] = tmp[l];
            l++;
        }
    }
    public static void quickSort(int[] array, int l, int r) {
        if(l >= r) return;
        int p = partition(array, l, r);
        printArray(array);
        quickSort(array, l, p - 1);
        quickSort(array, p + 1, r);
    }
    public static int partition(int[] array, int l, int r) {
        int pivot = array[r];
        int c = l - 1;
        for(int i = l; i <= r - 1; i++) {
            if(array[i] < pivot) {
                c++;
                int tmp = array[c];
                array[c] = array[i];
                array[i] = tmp;
            }
        }
        array[r] = array[c+1];
        array[c+1] = pivot;
        return c+1;
    }
}
