import java.util.Arrays;
import java.util.Scanner;

public class lab1E{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            int L = in.nextInt();
            int n = in.nextInt();
            int m = in.nextInt();
            if(n==0&&L%m==0){
                System.out.println(L/m );
            }else if(n==0&&L%m!=0){
                System.out.println(L/m+1);
            }else{
                int[] a = new int[n];
                for(int i = 0;i<n;i++){
                    a[i]=in.nextInt();
                }
                Arrays.sort(a);
                int c = BinarySearch(a,L,m);
                System.out.println(c);
            }
        }
    }


    public static int BinarySearch(int[] a,int L,int m){
        int l = 0; int r = L;
        while(l <= r){
            int mid  = l + (r - l) / 2;
            if(check(a,mid,L,m)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    public static boolean check(int[] a,int mid,int L,int m){
        int count = 0;
        int x = 0;
        while(x + mid < L){
            int c = BinarySearchX(a,x+mid);
            if(c == x){
                return false;
            }else{
                x = c;
                count++;
            }
        }
        count++;
        return count <= m;
    }
    public static int BinarySearchX(int[] a,int b){
        int l = 0;int r = a.length-1;
        while(l <= r){
            int mid = (r + l) / 2;
            if(a[mid] > b){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        if(r <= 0){
            return a[0];
        }else{
            return a[r];
        }
    }
}
