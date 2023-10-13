package Luogu;

import java.util.Scanner;

public class P1177{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        for(int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        mergesort(a);
        for(int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
    public static void mergesort(long[] array) {
        long[] tmp = new long[array.length];
        merge(array, tmp, 0, array.length - 1);
    }
    private static void merge(long[] array, long[] tmp, int left, int right) {
        if(left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        merge(array, tmp, left, middle);
        merge(array, tmp, middle + 1, right);
        merge_sort(array, tmp, left, right, middle);
    }
    private static void merge_sort(long[] array, long[] tmp, int left, int right, int middle) {
        int i = left;
        int j = middle + 1;
        int k = left;
        while(i <= middle && j <= right) {
            if(array[i] <= array[j]) {
                tmp[k] = array[i];
                i++;
                k++;
            } else {
                tmp[k] = array[j];
                j++;
                k++;
            }
        }
        while(i <= middle) {
            tmp[k] = array[i];
            i++;
            k++;
        }
        while(j <= right) {
            tmp[k] = array[j];
            j++;
            k++;
        }
        while(left <= right) {
            array[left] = tmp[left];
            left++;
        }
    }
}
