import java.util.Scanner;

public class lab1_1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i]=in.nextInt();
        }
        int T = in.nextInt();
        int[] b = new int[T];
        for(int i = 0;i<T;i++){
            b[i]=in.nextInt();
        }
        int k=0;
        while(k<T){
            int c = 0;
            for(int i=0;i<n;i++){
                if(b[k]==a[i])
                    System.out.println("yes");
                if(b[k]!=a[i]){
                    c++;
                }
                if(c==n){
                    System.out.println("no");
                }
            }
            k++;
        }
    }

    Package lab0;
}
