package BinarySearch;

public class functionA{
    public static void main(String[] args){

    }
    public static int search(int[] array, int k) {
        int min = 0; int max = array.length;
        int mid;
        while(min < max) {
            mid = min + (max - min) / 2;
            if(array[mid] < k) {
                min = mid;
            }else{
                max = mid - 1;
            }
        }
        if(array[max] == k) {
            return max;
        }else{
            return  -1;
        }
    }
}
