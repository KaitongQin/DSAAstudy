import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab6A{
    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        ArrayList[] arrayLists = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for(int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            arrayLists[u].add(v);
            arrayLists[v].add(u);
        }
        for(int i = 1; i <= n; i++) {
            if(arrayLists[i].size() == 1) {
                out.print(i + " ");
            }
        }
        out.close();
    }

    private static class QReader{
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
    private static class QWriter implements Closeable{
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

