package BinarySearch;

public class binarySearch{
    public static int binary_search(int[] array, int num) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if(array[middle] == num) {
                return middle;
            } else if(array[middle] > num) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
    public static int binary_search_X(int[] array, int num) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if(array[middle] < num) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return right;
    }
    public static int binary_search_Y(int[] array, int num) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if(array[middle] > num){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
