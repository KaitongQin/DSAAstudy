import java.util.Scanner;

public class binarySearch1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = in.nextInt();
        }
        int X = in.nextInt();
        int c = FindBinarySearch(a,X);
        System.out.println(c+1);
    }
    public static int FindBinarySearch(int[] a, int X){
        int l = 0;
        int r = a.length-1;
        while(l<=r){
            int mid = l + (r - l) / 2;
            if(a[mid]>X){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}
