import java.io.*;
import java.util.*;

public class lab3_4{
    public static void main(String[] args) {
        QReader3 in = new QReader3();
        QWriter3 out = new QWriter3();
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = in.nextInt();
        }
        if(n == 1) {
            out.println(a[0]);
        } else {
            int ak = QuickSort(0,n-1,k,a);
            out.print(ak);
        }
        out.close();
    }
    public static int QuickSort(int l, int r, int k,int[] a){
        if(l>=r)
            return a[l];
        int i = l;
        int j = r;
        int t = a[(i+j)/2];
        while(i<j){
            do {
                i++;
            } while(a[i]<t);
            do {
                j--;
            }while(a[j]>t);
            if(i<=j){
                int tmp = a[i];
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

class QReader3 {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }

    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }

    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}

class QWriter3 implements Closeable {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) {
        try {
            writer.write(object.toString());
        } catch (IOException e) {
            return;
        }
    }

    public void println(Object object) {
        try {
            writer.write(object.toString());
            writer.write("\n");
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            return;
        }
    }
}
