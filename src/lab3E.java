import java.io.*;
import java.util.StringTokenizer;

public class lab3E{
    private static class Node{
        int value;
        Node prev;
        Node next;
        Node prev_sorted;
        Node next_sorted;
        private Node( int value) {
            this.value = value;
        }
    }
    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        Node[] nodes = new Node[n];
        Node head1 = new Node(0);
        Node curr = head1;
        int[] ans = new int[n - 1];
        for(int i = 0; i < n; i++) {
            int val = in.nextInt();
            curr.next = new Node(val);
            nodes[i] = curr.next;
            nodes[i].prev = curr;
            curr = curr.next;
        }
        merge_sort(nodes);
        Node head2 = new Node(0);
        Node tmp = head2;
        for(int i = 0; i < n; i++) {
            tmp.next_sorted = nodes[i];
            nodes[i].prev_sorted = tmp;
            tmp = nodes[i];
        }
        curr = head1.next;
        int i = 0;
        while(curr != null && i < n - 1) {
            ans[i] = getAns(curr, head2);
            deleteNode(curr, head2);
            curr = curr.next;
            i++;
        }
        for(int j = 0; j < ans.length; j++) {
            out.print(ans[j] + " ");
        }
        out.close();
    }
    public static void deleteNode(Node node, Node head) {
        if(node == head.next_sorted) {
            if(node.next_sorted == null) {
                head.next_sorted = null;
            } else {
                head.next_sorted = node.next_sorted;
                node.next_sorted.prev_sorted = head;
            }
        } else if(node.next_sorted == null){
            node.prev_sorted.next_sorted = null;
        } else {
            node.prev_sorted.next_sorted = node.next_sorted;
            node.next_sorted.prev_sorted = node.prev_sorted;
        }
    }

    public static int getAns(Node node, Node head) {
        if(node.next_sorted == null) {
            return Math.abs(node.prev_sorted.value - node.value);
        } else if(node.prev_sorted == head) {
            return Math.abs(node.value - node.next_sorted.value);
        } else {
            return Math.min(Math.abs(node.prev_sorted.value - node.value), Math.abs(node.value - node.next_sorted.value));
        }
    }

    public static void merge_sort(Node[] nodes) {
        Node[] tmp = new Node[nodes.length];
        merge(nodes, tmp, 0, nodes.length - 1);
    }

    public static void merge(Node[] nodes, Node[] tmp, int l, int r) {
        if(l >= r) return;
        int mid = (l + r) / 2;
        merge(nodes, tmp, l, mid);
        merge(nodes, tmp, mid + 1, r);
        mergesort(nodes, tmp, l, mid, r);
    }
    public static void mergesort(Node[] nodes, Node[] tmp, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int k = l;
        while(i <= mid && j <= r) {
            if(nodes[i].value < nodes[j].value) {
                tmp[k] = nodes[i];
                k++;
                i++;
            } else {
                tmp[k] = nodes[j];
                k++;
                j++;
            }
        }
        while(i <= mid) {
            tmp[k] = nodes[i];
            k++;
            i++;
        }
        while(j <= r) {
            tmp[k] = nodes[j];
            k++;
            j++;
        }
        while(l <= r) {
            nodes[l] = tmp[l];
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


