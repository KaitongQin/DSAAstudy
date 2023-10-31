import java.io.*;
import java.util.StringTokenizer;

public class lab3C{
    private static class Node{
        int value;
        Node next;
        Node prev;
        private Node( int value) {
            this.value = value;
        }
    }
    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        int T = in.nextInt();
        for(int c = 0; c < T; c++) {
            int n = in.nextInt();
            int m = in.nextInt();
            Node[] nodes = new Node[n];
            Node head = new Node(-1);
            Node curr = head;
            for(int i = 0; i < n; i++) {
                int tmp = in.nextInt();
                curr.next = new Node(tmp);
                nodes[tmp] = curr.next;
                nodes[tmp].prev = curr;
                curr = curr.next;
            }
            curr.next = new Node(0);
            curr = head;
            int[] x1 = new int[m];
            int[] y1 = new int[m];
            int[] x2 = new int[m];
            int[] y2 = new int[m];
            for(int i = 0; i < m; i++) {
                x1[i] = in.nextInt();
                y1[i] = in.nextInt();
                x2[i] = in.nextInt();
                y2[i] = in.nextInt();
            }
            for(int i = 0; i < m; i++) {
                swapLinkedList(x1[i], y1[i], x2[i], y2[i], nodes);
            }
            curr = head.next;
            while(curr.next != null) {
                out.print(curr.value + " ");
                curr = curr.next;
            }
            out.print("\n");
        }
        out.close();
    }
    public static void swapLinkedList(int x1, int y1, int x2, int y2, Node[] node) {
        if(node[y1].next == node[x2]) {
            Node tmp = node[y2].next;
            Node tmp1 = node[x1].prev;
            tmp1.next = node[x2];
            node[x2].prev = tmp1;
            node[y2].next = node[x1];
            node[x1].prev = node[y2];
            node[y1].next = tmp;
            tmp.prev = node[y1];
        } else {
            Node tmp1 = node[y2].next;
            Node tmp2 = node[x2].prev;
            node[x1].prev.next = node[x2];
            node[x2].prev = node[x1].prev;
            node[y2].next = node[x1];
            node[x1].prev = node[y2];
            tmp2.next = tmp1;
            tmp1.prev = tmp2;

            Node tmp3 = node[y1].next;
            node[y2].next = tmp3;
            tmp3.prev = node[y2];
            tmp2.next = node[x1];
            node[x1].prev = tmp2;
            node[y1].next = tmp1;
            tmp1.prev = node[y1];
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


