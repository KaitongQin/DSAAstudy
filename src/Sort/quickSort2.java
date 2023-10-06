package Sort;

import java.util.Random;

public class quickSort2{
    public static void Sort(int[] array) {
        QuickSort2(0,array.length - 1, array);
    }
    private static void QuickSort(int l, int r, int[] a) {
        if(l >= r) return;
        int i = l - 1;
        int j = r + 1;
        int t = a[(i + j) / 2];
        while(i < j) {
            do i++; while(a[i] < t);
            do j--; while(a[j] > t);
            if(i <= j){
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        QuickSort(l, j, a);
        QuickSort(j+1, r, a);
    }
    private static void QuickSort2(int left, int right, int[] array) {
        if(left >= right) return;
        int i = left - 1;
        int j = right + 1;
        int k = (left + right) / 2;
        while(i < j) {
            do i++; while (array[i] < array[k]);
            do j--; while (array[j] > array[k]);
            if(i <= j) {
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
            }
        }
        QuickSort2(left, i, array);
        QuickSort2(i + 1, right, array);
    }
}
