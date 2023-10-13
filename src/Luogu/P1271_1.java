package Luogu;

import java.util.Arrays;
import java.util.Scanner;

public class P1271_1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[m];
        for(int i = 0; i < m; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        for(int i = 0; i < m; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
