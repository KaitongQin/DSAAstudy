import java.io.*;
import java.util.*;

public class lab2B_2{
    public static void main(String[] args) {
        QReader8 in = new QReader8();
        QWriter8 out = new QWriter8();
        int n = in.nextInt();
        long[] a = new long[n];
        for(int i = 0;i<n;i++){
            a[i] = in.nextInt();
        }
        sort(a);
        if(n % 2 == 0) {
            out.println(a[n/2] + a[n/2 - 1]);
        } else {
            out.println(a[n/2]*2);
        }
        out.close();
    }
    public static void sort(long[] array) {
        long[] tmp = new long[array.length];
        merge(array, tmp, 0, array.length - 1);
    }
    public static void merge(long[] array, long[] tmp, int left, int right) {
        if(left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        merge(array, tmp, left, mid);
        merge(array, tmp, mid + 1, right);
        merge_sort(array, tmp, left, mid, right);
    }
    public static void merge_sort(long[] array, long[] tmp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        while(i <= mid && j <= right) {
            if(array[i] < array[j]) {
                tmp[k] = array[i];
                i++;
                k++;
            } else {
                tmp[k] = array[j];
                j++;
                k++;
            }
        }
        while(i <= mid) {
            tmp[k] = array[i];
            i++;
            k++;
        }
        while(j <= right) {
            tmp[k] = array[j];
            j++;
            k++;
        }
        while(left <= right) {
            array[left] = tmp[left];
            left++;
        }
    }
}
class QWriter8 implements Closeable{
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
class QReader8{
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


