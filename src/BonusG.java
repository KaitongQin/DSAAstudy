import java.util.ArrayList;
import java.util.Scanner;

public class BonusG{
    static class node {
        int value;
        node next;
        node prev;
        public node (int value) {
            this.value = value;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        node[] nodes = new node[n * m];
        int k = in.nextInt();
        int x = in.nextInt();
        for (int i = 0; i < n; i++) {
            node tmp = new node(-1);
            for (int j = 0; j < m; j++) {
                tmp.next = new node(i * m + j);
                nodes[i * m + j] = tmp.next;
                nodes[i * m + j].prev = tmp;
                tmp = tmp.next;
            }
            nodes[i * m].prev = null;
        }
        for (int i = 0; i < k; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            if (nodes[u].next == null && nodes[v].prev == null) {
                nodes[u].next = nodes[v];
                nodes[v].prev = nodes[u];
            } else if (nodes[u].next == null) {
                nodes[v].prev.next = null;
                nodes[v].prev = nodes[u];
                nodes[u].next = nodes[v];
            } else if (nodes[v].prev == null) {
                nodes[u].next.prev = null;
                nodes[u].next = nodes[v];
                nodes[v].prev = nodes[u];
            } else {
                node tmp = nodes[u].next;
                nodes[u].next = nodes[v];
                nodes[v].prev.next = tmp;
                tmp.prev = nodes[v].prev;
                nodes[v].prev = nodes[u];
            }
        }
        node curr = nodes[x];
        while (curr.prev != null) {
            curr = curr.prev;
        }
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
    }
}
