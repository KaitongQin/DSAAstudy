import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab6F{
    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        node[] tree = new node[n + 1];
        for(int i = 1; i <= n; i++) {
            tree[i] = new node(i);
        }
        for(int i = 1; i <= n; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            tree[u].sons.add(tree[v]);
            tree[v].sons.add(tree[u]);
        }
        int[] p = new int[n + 1];
        int max = 0;
        for(int i = 1; i <= n; i++) {
            p[i] = in.nextInt();
            if(p[i] > p[max]) {
                max = i;
            }
        }

    }
    static class node{
        boolean invited;
        int key;
        ArrayList<node> sons;
        public node(int key) {
            this.key = key;
            invited = false;
            sons = new ArrayList<>();
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
