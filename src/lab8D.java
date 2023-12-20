import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab8D{
    static class node {
        int value;
        ArrayList<node> sons;
        int depth;
        boolean isParent;
        public node(int value) {
            this.value = value;
            sons = new ArrayList<>();
            depth = 0;
            isParent = false;
        }
    }
    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        int T = in.nextInt();
        for (int c = 0; c < T; c++) {
            int n = in.nextInt();
            int m = in.nextInt();
            boolean[] children = new boolean[n + 1];
            node[] nodes = new node[n + 1];
            for (int i = 1; i <= n; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                nodes[y].sons.add(nodes[x]);
                nodes[y].isParent = true;
                children[x] = true;
            }
            for (int i = 1; i <= n; i++) {
                if (children[i]) continue;
                dfs(nodes[i]);
            }
        }
    }
    public static void dfs(node node) {
        int d = node.depth;
        for (int i = 0; i < node.sons.size(); i++) {

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
