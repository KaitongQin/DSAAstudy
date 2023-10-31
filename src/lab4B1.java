import java.io.*;
import java.util.StringTokenizer;

public class lab4B1{
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
        int n = in.nextInt();
        int p = in.nextInt();
        int q = in.nextInt();
        Node[] nodesP = new Node[n+1];
        Node headP = new Node(-1);
        Node currP = headP;
        Node[] nodesQ = new Node[n+1];
        Node headQ = new Node(-1);
        Node currQ = headQ;
        for(int i = 0; i < p; i++) {
            int value = in.nextInt();
            nodesP[value] = new Node(value);
            nodesP[value].prev = currP;
            currP.next = nodesP[value];
            currP = currP.next;
        }
        for(int i = 0; i < q; i++) {
            int value = in.nextInt();
            nodesQ[value] = new Node(value);
            nodesQ[value].prev = currQ;
            currQ.next = nodesQ[value];
            currQ = currQ.next;
        }
        int[] ans = new int[n];
        int j = 1;
        int k = 1;
        currP = headP.next;
        currQ = headQ.next;
        while(currP != null && currQ != null) {
            ans[currP.value - 1] = j;
            if(nodesQ[currP.value] != null) {
                deleteNode(nodesQ[currP.value], headQ);
            }
            j++;
            ans[currQ.value - 1] = k;
            if(nodesP[currQ.value] != null) {
                deleteNode(nodesP[currQ.value], headP);
            }
            k++;
            currQ = currQ.next;
            currP = currP.next;
        }
        while(currP != null) {
            ans[currP.value - 1] = j;
            currP = currP.next;
            j++;
        }
        while(currQ != null) {
            ans[currQ.value - 1] = k;
            currQ = currQ.next;
            k++;
        }
        for(int i = 0; i < n; i++) {
            out.print(ans[i] + " ");
        }
        out.close();
    }
    private static void deleteNode(Node node, Node head) {
        if(node == head.next) {
            if(node.next == null) {
                head.next = null;
            } else {
                head.next = node.next;
                node.next = head;
            }
        } else if(node.next== null){
            node.prev.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
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


