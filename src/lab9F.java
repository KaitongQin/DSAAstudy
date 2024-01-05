import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class lab9F{
    static class node{
        int value;
        long dis;
        ArrayList <edge> edges;
        public node(int value) {
            this.value = value;
            edges = new ArrayList<>();
        }
    }

    static class edge{
        node u;
        node v;
        long w;
        public edge(long w, node u, node v){
            this.w = w;
            this.u = u;
            this.v = v;
        }
    }
    public static void main(String[] args){
        QReader in = new QReader();
        int n = in.nextInt();
        int m = in.nextInt();
        int p = in.nextInt();
        int k = in.nextInt();
        node[][] nodes = new node[n + 1][k + 1];
        for (int i = 0; i < n ;i++) {
            for (int j = 0; j <= k; j++) {
                nodes[i][j] = new node(i);
                nodes[i][j].dis = Long.MAX_VALUE;
            }
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            for (int j = 0; j <= k; j++) {
                nodes[u][j].edges.add(new edge(w, nodes[u][j], nodes[v][j]));
            }
        }
        for (int i = 0; i < p; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            for (int j = 1; j <= k; j++) {
                nodes[u][j - 1].edges.add(new edge(0, nodes[u][j - 1], nodes[v][j]));
            }
        }
        int S = in.nextInt();
        int T = in.nextInt();
        edge[] heap = new edge[m + 1];
        heap[0] = new edge(0, null,null);
        for (int i = 1; i <= m; i++) {
            heap[i] = new edge(Long.MAX_VALUE, null, null);
        }
        nodes[S][0].dis = 0;
        for (int i = 0; i < nodes[S][0].edges.size(); i++) {
            enHeap(heap, nodes[S][0].edges.get(i));
            heap[0].w += 1;
            nodes[S][0].edges.get(i).v.dis = nodes[S][0].edges.get(i).w;
        }
        while (heap[0].w != 0) {
            edge tmp = deHeap(heap);
            heap[0].w -= 1;
            for (int i = 0; i < tmp.v.edges.size(); i++) {
                if (tmp.v.edges.get(i).w + tmp.v.dis < tmp.v.edges.get(i).v.dis) {
                    tmp.v.edges.get(i).v.dis = tmp.v.edges.get(i).w + tmp.v.dis;
                    enHeap(heap, tmp.v.edges.get(i));
                    heap[0].w += 1;
                }
            }
        }

    }
    public static void enHeap(edge[] edges, edge newEdge) {
        int k = (int) edges[0].w + 1;
        edges[k] = new edge(newEdge.w, newEdge.u, newEdge.v);
        while (k > 1) {
            if (edges[k].w < edges[k / 2].w) {
                edge tmp = edges[k];
                edges[k] = edges[k / 2];
                edges[k / 2] = tmp;
                k /=2;
            } else {
                break;
            }
        }
    }
    public static edge deHeap(edge[] edges) {
        edge tmp = edges[1];
        edges[1] = edges[(int) edges[0].w];
        edges[(int) edges[0].w] = new edge(Long.MAX_VALUE, null, null);
        int i = 1;
        while (i * 2L < edges[0].w) {
            if (i * 2L < edges[0].w - 1) {
                if (edges[i].w > edges[i * 2].w) {
                    edge t = edges[i];
                    edges[i] = edges[i * 2];
                    edges[i * 2] = t;
                }
                break;
            }
            if(edges[i].w > Math.min(edges[i * 2].w, edges[i * 2 + 1].w))  {
                if(edges[i * 2].w == Math.min(edges[i * 2].w, edges[i * 2 + 1].w)) {
                    edge t = edges[i];
                    edges[i] = edges[i * 2];
                    edges[i * 2] = t;
                    i *= 2;
                } else {
                    edge t = edges[i];
                    edges[i] = edges[i * 2 + 1];
                    edges[i * 2 + 1] = t;
                    i = i * 2 + 1;
                }
            } else {
                break;
            }
        }
        return tmp;
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
