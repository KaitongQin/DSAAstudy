import java.util.Scanner;

public class lab2_4{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int S = in.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = in.nextInt();
        }
        long count = 0;
        for(int i = 0;i<n-2;i++){
            for(int j = i+1;j<n-1;j++){
                int ak = S-a[i]-a[j];
                int l = BinarySearchL(a,j,ak);
                int r = BinarySearchR(a,j,ak);
                count+=r-l;
            }
        }
        System.out.println(count);
    }
    public static int BinarySearchR(int[] a,int j, int ak){
        int l = j+1; int r = a.length-1;
        if(a[l]>ak){
            return l-1;
        }
        while(l<r){
            int mid = l+(r-l+1)/2;
            if(a[mid]>ak){
                r = mid-1;
            }else{
                l = mid;
            }
        }
        return r;
    }
    public static int BinarySearchL(int[] a,int j,int ak){
        int l = j+1;int r = a.length-1;
        if(a[j+1]>=ak){
            return j;
        }
        while(l<r){
            int mid = l+(r-l+1)/2;
            if(a[mid]>=ak){
                r = mid-1;
            }else{
                l = mid;
            }
        }
        return l;
    }
}
