import java.io.*;
import java.util.StringTokenizer;

public class lab3F {
    private static class Node{
        int value;
        Node prev;
        Node next;
        private Node( int value) {
            this.value = value;
        }
    }
    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        int T = in.nextInt();
        for(int c = 0; c < T; c++){
            int n = in.nextInt();
            Node head = new Node(-1);
            Node curr = head;
            for(int i = 0; i < n; i++){
                int val = in.nextInt();
                curr.next = new Node(val);
                curr = curr.next;
            }
            curr.next = new Node(-1);
            curr = head.next;
            while(curr.next != null) {
                
            }
        }
        out.close();
    }
    public static void deleteNode(Node node, Node head) {
        if(node == head.next) {
            if(node.next == null) {
                head.next = null;
            } else {
                head.next = node.next;
                node.next.prev = head;
            }
        } else if(node.next == null){
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


