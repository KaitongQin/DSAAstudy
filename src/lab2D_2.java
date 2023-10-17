import java.util.Scanner;

public class lab2D_2{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long[] array = new long[n];
        for(int i = 0; i < n; i++) {
            array[i] = in.nextLong();
        }
        sort(array);
        if(n == 1) {
            System.out.println(array[0]);
        } else {
            System.out.println(array[k]);
        }
    }
    public static void sort(long[] array) {
        long[] tmp = new long[array.length];
        merge(array, tmp, 0, array.length - 1);
    }
    public static void merge(long[] array, long[] tmp, int left, int right) {
        if(left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        merge(array, tmp, left, mid);
        merge(array, tmp, mid + 1, right);
        merge_sort(array, tmp, left, mid, right);
    }
    public static void merge_sort(long[] array, long[] tmp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        while(i <= mid && j <= right) {
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
