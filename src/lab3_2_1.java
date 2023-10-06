import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class lab3_2_1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        if(n%2==0){
            System.out.println(a[n/2]+a[n/2-1]);
        }else{
            System.out.println(2*a[n/2]);
        }
    }
}
