import java.util.ArrayList;
import java.util.Scanner;

public class lab9B{
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
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        edge[] edges = new edge[m];
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            edges[i] = new edge(u, v, w);
        }
        int[] father = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
        merge_sort(edges);
        int count = 0;
        for (int i = 0; i < m; i++) {
            int u = edges[i].u;
            int v = edges[i].v;
            int fu = findFa(u, father);
            int fv = findFa(v, father);
            if (fu == fv) {
                continue;
            }
            edges[i].selected = true;
            father[fu] = fv;
            count++;
            if (count == n-1) {
                break;
            }
        }
        long ans = 0;
        for (int i = 0; i < m; i++) {
            if (!edges[i].selected && edges[i].w > 0) {
                ans += edges[i].w;
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
}
