package Luogu;

import java.util.Scanner;

public class P1059{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        int[] count = new int[1005];
        for(int i = 0; i < n; i++) {
            array[i] = in.nextInt();
            count[array[i]] ++;
        }
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 1)
                n -= count[i] - 1;
        }
        System.out.println(n);
        for(int i = 0; i < count.length; i++) {
            if(count[i] >= 1)
                System.out.print(i + " ");
        }
    }

}
