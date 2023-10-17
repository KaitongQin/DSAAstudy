import java.util.Scanner;

public class lab1B{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = in.nextInt();
        }
        long[] ai = new long[1000001];
        long[] sumai = new long[1000001];
        long sum = 0;
        for(int i = 0;i<1000001;i++){
            ai[i] = (long) (i+1)*(i+2)/2;
            sum+=ai[i];
            sumai[i] = sum;
        }
        for(int i = 0;i<n;i++){
            System.out.println(sumai[a[i]-1]);
        }
    }

}
