package Sort;

import java.io.*;
import java.util.StringTokenizer;

public class lab2D{
    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int k = in.nextInt();
        long[] array = new long[n];
        for(int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        long ans = sortSection(array, 0, n - 1, k);
        out.println(ans);
        out.close();
    }
    public static long sortSection(long[] array, int l, int r, int k) {
        if(l >= r) return array[l];
        int p = partition(array, l, r);
        if(p - l + 1 >= k) {
            return sortSection(array, l, p - 1, k);
        } else {
            return sortSection(array, p + 1, r, k - (p - l + 1));
        }
    }
    public static int partition(long[] array, int l, int r) {
        long pivot = array[r];
        int c = l - 1;
        for(int i = l; i <= r - 1; i++) {
            if(array[i] < pivot) {
                c++;
                long tmp = array[c];
                array[c] = array[i];
                array[i] = tmp;
            }
        }
        array[r] = array[c+1];
        array[c+1] = pivot;
        return c+1;
    }
    static class QReader{
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
    static class QWriter implements Closeable{
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
}
