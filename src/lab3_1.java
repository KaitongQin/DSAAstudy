import java.util.Scanner;

public class lab3_1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 0;i<T;i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] an = new int[n];
            int[] am = new int[m];
            for(int j = 0;j<n;j++){
                an[j] = in.nextInt();
            }
            for(int j = 0;j<m;j++){
                am[j] = in.nextInt();
            }
            int[] amn = new int[m+n];
            int j = 0;
            int k = 0;
            while(j+k<m+n){
                if(j<n&&an[j]<=am[k]){
                    amn[j+k] = an[j];
                    j++;
                }else if(k<m){
                    amn[j+k] = am[k];
                    k++;
                }
            }
            amn[n+m-1] = Math.max(an[n-1],am[m-1]);
            for(int i1 = 0;i1<m+n;i1++){
                System.out.print(amn[i1]+" ");
            }
        }
    }
}
