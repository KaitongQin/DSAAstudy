package BinarySearch;

public class Main{
    public static void main(String[] args) {
        long[] array = {1,3,4,6,9,11,15,16,20,70,99,100,100,1000};
        int num = -1;
        int index = binarySearchY(array, num);
        System.out.println(index);
    }
    private static int binarySearchY(long[] array, int a) {
        int l = 0;
        int r = array.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(array[mid] > a) {
                r = mid - 1;
            } else if(array[mid] < a){
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return r;
    }
}
