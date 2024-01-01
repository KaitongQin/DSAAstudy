import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class lab9C{
    static class edge{
        int u;
        int v;
        long w;
        boolean selected;
        public edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
            selected = false;
        }
    }
    public static void main(String[] args) {
        QReader in = new QReader();
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        ArrayList<edge> edges = new ArrayList <>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                edges.add(new edge(i * m + j + 1 , i * m + j + 2, (long) grid[i][j] * grid[i][j + 1]));
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                edges.add(new edge(j * m + i + 1, (j + 1) * m + i + 1, (long) grid[j][i] * grid[j + 1][i]));
            }
        }
        int[] father = new int[n * m + 1];
        for (int i = 0; i < n * m + 1; i++) {
            father[i] = i;
        }
        edge[] e = new edge[edges.size()];
        for (int i = 0; i < edges.size(); i++) {
            e[i] = edges.get(i);
        }
        merge_sort(e);
        int cnt = 0;
        long ans = 0;
        for (int i = e.length - 1; i >= 0; i--) {
            int u = e[i].u;
            int v = e[i].v;
            int fu = findFa(u, father);
            int fv = findFa(v, father);
            if (fu == fv) {
                continue;
            }
            father[fu] = fv;
            ans += e[i].w;
            cnt++;
            if (cnt == n * m - 1) {
                break;
            }
        }
        System.out.println(ans);
    }
    public static int findFa(int x, int[] father) {
        if (x == father[x]) {
            return father[x];
        } else {
            return findFa(father[x], father);
        }
    }
    public static void merge_sort(edge[] edges) {
        edge[] tmp = new edge[edges.length];
        merge(edges, tmp, 0, edges.length - 1);
    }

    public static void merge(edge[] edges, edge[] tmp, int l, int r) {
        if(l >= r) return;
        int mid = (l + r) / 2;
        merge(edges, tmp, l, mid);
        merge(edges, tmp, mid + 1, r);
        mergesort(edges, tmp, l, mid, r);
    }
    public static void mergesort(edge[] edges, edge[] tmp, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int k = l;
        while(i <= mid && j <= r) {
            if(edges[i].w < edges[j].w) {
                tmp[k] = edges[i];
                k++;
                i++;
            } else {
                tmp[k] = edges[j];
                k++;
                j++;
            }
        }
        while(i <= mid) {
            tmp[k] = edges[i];
            k++;
            i++;
        }
        while(j <= r) {
            tmp[k] = edges[j];
            k++;
            j++;
        }
        while(l <= r) {
            edges[l] = tmp[l];
            l++;
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
}
