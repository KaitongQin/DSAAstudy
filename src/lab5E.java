import java.util.Arrays;
import java.util.Scanner;

public class lab5E{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        int min = Math.min(s1.length(), s2.length());
        int k = binarySearchX(0, min, s1, s2);
        System.out.println(k);
    }
    public static int binarySearchX(int left, int right, String s1, String s2) {
        int l = left;
        int r = right;
        while(l <= r) {
            int mid = (r - l) / 2 + l;
            if(check(mid, s1, s2)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
    public static boolean check(int mid, String s1, String s2) {
        long p = 139;
        long[] ints1 = new long[s1.length() - mid + 1];
        long[] ints2 = new long[s2.length() - mid + 1];
        long p0 = 1;
        for(int i = mid - 1; i >= 0; i--) {
            ints1[0] += (long) s1.charAt(i) * p0;
            ints2[0] += (long) s2.charAt(i) * p0;
            p0 *= p;
        }
        for(int i = mid; i < s1.length(); i++) {
            ints1[i - mid + 1] = (ints1[i - mid]) * p - (long) s1.charAt(i - mid) * p0 + s1.charAt(i);
        }
        for(int i = mid; i < s2.length(); i++) {
            ints2[i - mid + 1] = (ints2[i - mid]) * p - (long) s2.charAt(i - mid) * p0 + s2.charAt(i);
        }
        if(s1.length() < s2.length()) {
            mergesort(ints2);
            for(long j : ints1){
                boolean ans = binarySearch(ints2 , j);
                if (ans) {
                    return true;
                }
            }
        } else {
            mergesort(ints1);
            for(long j : ints2){
                boolean ans = binarySearch(ints1 , j);
                if (ans) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean binarySearch(long[] array, long k) {
        int l = 0;
        int r = array.length - 1;
        while(l <= r) {
            int mid = (r - l) / 2 + l;
            if(array[mid] > k) {
                r = mid - 1;
            } else if(array[mid] < k) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
    public static void mergesort(long[] array) {
        long[] tmp = new long[array.length];
        merge(array, tmp, 0, array.length - 1);
    }
    public static void merge(long[] array, long[] tmp, int low, int high) {
        if(low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        merge(array, tmp, low, mid);
        merge(array, tmp, mid + 1, high);
        merge_sort(array, tmp, low, mid, high);
    }
    public static void merge_sort(long[] array, long[] tmp, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;
        while(i <= mid && j <= high) {
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
        while(j <= high) {
            tmp[k] = array[j];
            k++;
            j++;
        }
        while(low <= high) {
            array[low] = tmp[low];
            low++;
        }
    }
}
