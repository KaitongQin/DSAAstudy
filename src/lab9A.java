import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab9A{
    static class node{
        int value;
        long dis;
        boolean visited;
        ArrayList<edge> edges;
        public node(int value) {
            this.value = value;
            dis = Long.MAX_VALUE;
            visited = false;
            edges = new ArrayList<>();
        }
    }

    static class edge{
        node v;
        int w;
        public edge(int w, node v){
            this.w = w;
            this.v = v;
        }
    }
    public static void main(String[] args){
        QReader in = new QReader();
        int n = in.nextInt();
        int m = in.nextInt();
        node[] nodes = new node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new node(i);

        }
        for (int i = 1; i <= m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            nodes[u].edges.add(new edge(w, nodes[v]));
            nodes[v].edges.add(new edge(w, nodes[w]));
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
