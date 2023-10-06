package BinarySearch;

public class Main{
    public static void main(String[] args) {
        int[] array = {1,3,4,6,9,11,15,16,20,70,99,100,100,1000};
        int num = 1000;
        int index = binarySearch.binary_search_Y(array, num);
        System.out.println(index);
    }
}
