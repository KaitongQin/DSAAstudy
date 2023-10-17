import java.io.*;
import java.util.*;

public class lab2B_3{
    public static void main(String[] args) {
        QReader4 in = new QReader4();
        QWriter4 out = new QWriter4();
        int n = in.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        for(int i = 0;i<n;i++){
            a[i] = in.nextInt();
        }
        for(int i = 0;i<n;i++){
            b[i] = a[i];
        }
        if(n%2==0){
            long ak = QuickSort(0,n-1,n/2+1,a);
            long ak2 = QuickSort(0,n-1,n/2,b);
            out.println(ak+ak2);
        }else{
            long ak1 = QuickSort(0,n-1,n/2+1,a);
            out.println(2*ak1);
        }
        out.close();
    }
    public static long QuickSort(int l, int r, int k,long[] a){
        if(l>=r)
            return a[l];
        int i = l-1;
        int j = r+1;
        long t = a[(i+j)/2];
        while(i<j){
            do {
                i++;
            } while(a[i]<t);
            do {
                j--;
            }while(a[j]>t);
            if(i<=j){
                long tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        if(j-l+1>=k)
            return QuickSort(l,j,k,a);
        else
            return QuickSort(j+1,r,k-(j-l+1),a);
    }
}
class QWriter4 implements Closeable{
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object){
        try {
            writer.write(object.toString());
        } catch (IOException e) {
            return;
        }
    }

    public void println(Object object){
        try {
            writer.write(object.toString());
            writer.write("\n");
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void close( ){
        try {
            writer.close();
        } catch (IOException e) {
            return;
        }
    }
}
class QReader4{
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    private String innerNextLine( ){
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean hasNext( ){
        while (! tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }

    public String nextLine( ){
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }

    public String next( ){
        hasNext();
        return tokenizer.nextToken();
    }

    public int nextInt( ){
        return Integer.parseInt(next());
    }

    public long nextLong( ){
        return Long.parseLong(next());
    }
}

