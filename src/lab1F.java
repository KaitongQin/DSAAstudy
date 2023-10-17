import java.util.Scanner;

public class lab1F {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long x1 = in.nextLong();
        long y1 = in.nextLong();
        long x2 = in.nextLong();
        long y2 = in.nextLong();
        long N = in.nextLong();
        String s = in.next();
        long a = binarySearch(x1,x2,y1,y2,N,s);
        System.out.println(a);
    }
    public static long binarySearch(long x1,long x2,long y1,long y2,long N,String s){
        long l = 0;
        long r = (long) 1e17;
        while(l<=r){
            long mid = (l + r) / 2;
            if(check(mid,x1,x2,y1,y2,N,s)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        if(l>=(long)1e17||r<0){
            return -1;
        }else{
            return l;
        }
    }
    public static boolean check(long mid,long x1,long x2,long y1,long y2,long N,String s){
        long vertical = 0;
        long horizon = 0;
        for(int i = 0;i<N;i++){
            if(s.charAt(i)=='U')
                vertical++;
            else if(s.charAt(i)=='D')
                vertical--;
            else if(s.charAt(i)=='R')
                horizon++;
            else
                horizon--;
        }
        y2 += (mid/N)*vertical;
        x2 += (mid/N)*horizon;
        if(mid%N!=0){
            for(int i = 0;i<mid%N;i++){
                if(s.charAt(i)=='U')
                    y2++;
                else if(s.charAt(i)=='D')
                    y2--;
                else if(s.charAt(i)=='R')
                    x2++;
                else
                    x2--;
            }
        }
        long c = Math.abs(y2-y1)+Math.abs(x2-x1);
        return c <= mid;
    }
}
