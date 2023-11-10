import java.io.*;
import java.util.StringTokenizer;

public class lab5D{
    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        int T = in.nextInt();
        for(int i = 0; i < T; i++) {
            String s = in.nextLine();
            int n = s.length();
            int[] next = new int[n];
            findNext(s, next);
            int k = n - next[n - 1];
            if(n % k == 0 && k != n) {
                out.println(0);
            } else if(k == n) {
                out.println(n);
            } else {
                out.println((n / k + 1) * k - n);
            }
        }
        out.close();
    }
    public static void findNext (String s, int[] next) {
        next[0] = 0;
        int k = 0;
        int j = k;
        for(int i = 1; i < s.length(); i++) {
            while(k > 0 && s.charAt(i) != s.charAt(k)) {
                j = next[k - 1];
                k = j;
            }
            if(s.charAt(i) == s.charAt(k)) {
                k++;
                j++;
            }
            next[i] = k;
        }
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
