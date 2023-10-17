package Luogu;

import java.util.Scanner;

public class P1459{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        int[] array1 = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = in.nextInt();
            array1[i] = array[i];
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j] < array[j-1]) {
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    count += 1;
                } else {
                    break;
                }
            }
        }
        int count1 = 0;
        int k;
        for(int i = 0; i < n-1; i++) {
            k = i;
            for(int j = i+1; j < n; j++) {
                if(array1[j] < array1[k])
                    k = j;
            }
            if(k != i) {
                int tmp = array1[i];
                array1[i] = array1[k];
                array1[k] = tmp;
                count1 += 1;
            }
        }
        System.out.println(Math.min(count1, count));
    }
}
