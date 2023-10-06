package Sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main{
    public static void main(String[] args){
        int[] array = new int[7];
        for(int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(0,100);
        }
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        insertionSort.insertion_sort_1(array);
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
