package Luogu;

import java.util.Scanner;

public class P1271{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] count = new int[n+1];
        for(int i = 0; i < m; i++) {
            int c = in.nextInt();
            count[c]++;
        }
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                for(int j = 0; j < count[i]; j++){
                    System.out.print(i + " ");
                }
            }
        }
    }
}
