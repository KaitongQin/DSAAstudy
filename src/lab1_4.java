import java.sql.Array;
import java.util.Scanner;

public class lab1_4{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][200000];
        int[] mn = new int[n];
        for(int i = 0;i<n;i++){
            int m = in.nextInt();
            mn[i]=m;
            for(int j = 0;j<m;j++){
                a[i][j]=in.nextInt();
            }
        }
        int Max= 0;
        int[] M = new int[n];
        for(int i = 0;i<n;i++){
            int[] max = new int[mn[i]];
            Max = a[i][0];
           for(int j = 0;j<mn[i]-1;j++){
               if(a[i][j]>=Max){
                   Max = a[i][j];
                   max[j+1]=Max-a[i][j+1];
               }else{
                  max[j+1]=Max-a[i][j+1];
               }
           }
           M[i]=max[1];
           for(int k = 1;k<mn[i];k++){
               if(max[k]>M[i])
                   M[i]=max[k];
           }
        }
        for(int m:M){
            System.out.println(m);
        }

    }
}
