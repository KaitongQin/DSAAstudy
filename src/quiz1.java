import java.util.Scanner;

public class quiz1{
    public static void main(String[] args) {
        int[] array = new int[10];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            array[i] = in.nextInt();
        }
        boolean is_ascending = isAscending(array, 0);
        System.out.println(is_ascending);//31 97 14 35 65 86 73 69 45 55
        //14 31 35 45 55 65 69 73 86 97
    }
    public static int Search(int[] array1, int[] array2) {
        int count = 0;
        for(int i = 0; i < array1.length; i++) {
            int j = binarySearch(array1[i], array2);
            count += j;
        }
        return count;
    }
    public static int binarySearch(int a, int[] array) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if(array[middle] > a)

                left = middle + 1;
            else if(array[middle] < a)
                right = middle - 1;
            else
                return array.length - middle - 1;
        }
        return array.length - left;
    }
    public static boolean isAscending (int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }
    public static boolean isAscending (int[] array, int i) {
        if (i < array.length - 1 && array[i] > array[i+1]) {
            return false;
        } else if (i < array.length - 1) {
            return isAscending(array, i + 1);
        }
        return true;
    }
}
