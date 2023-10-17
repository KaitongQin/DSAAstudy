import java.util.Scanner;

public class lab1A{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = in.nextInt();
        }
        int T = in.nextInt();
        int[] b = new int[T];
        for(int i = 0;i<T;i++){
            b[i] = in.nextInt();
        }
        for(int i = 0;i<T;i++){
            boolean c = BinarySearch(b[i],a);
            if(c)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    public static boolean BinarySearch(int a,int[] b){
        int l = 0;int r = b.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(b[mid]==a){
                return true;
            }else if(b[mid]>a){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return false;
    }
}
