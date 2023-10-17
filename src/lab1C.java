import java.util.Scanner;

public class lab1C{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();
        int[] a = new int[N];
        for(int i = 0;i<N;i++){
            a[i]=in.nextInt();
        }
        int[][] b = new int[Q][2];
        for(int i = 0;i<Q;i++){
            b[i][0]=in.nextInt();
            b[i][1]=in.nextInt();
        }
        for(int i = 0;i<Q;i++){
            if(b[i][0]>=b[i][1]||b[i][0]>a[N-1]||b[i][1]<a[0]){
                System.out.println("NO");
            }else{
                int x = BinarySearchX(a,b[i][0]);
                int y = BinarySearchY(a,b[i][1]);
                if(y-x==1){
                    System.out.println("NO");
                }else{
                    System.out.println("YES"+" "+(y-x-1));
                }
            }
        }
    }
    public static int BinarySearchX(int[] a,int b){
        int l = 0;int r = a.length-1;
        if(b<a[0]){
            return -1;
        }else{
            while(l<r){
                int mid = l+(r-l+1)/2;
                if(a[mid]>b){
                    r =mid-1;
                }else{
                    l=mid;
                }
            }
            return r;
        }
    }
    public static int BinarySearchY(int[] a,int b){
        int l = 0;int r = a.length-1;
        if(b>a[a.length-1]){
            return a.length;
        }else{
            while(l<r){
                int mid = l+(r-l)/2;
                if(a[mid]<b){
                    l=mid+1;
                }else{
                    r=mid;
                }
            }
            return l;
        }
    }
}
