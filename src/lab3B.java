import java.io.*;
import java.util.StringTokenizer;

public class lab3B{
    static class Node{
        char c;
        Node next;
        Node previous;
        public Node(Node next, Node previous, char c){
            this.next = next;
            this.previous = previous;
            this.c = c;
        }
    }

    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        int T = in.nextInt();
        for(int i = 0; i < T; i++) {
            int n = in.nextInt();
            String s = in.next();
            Node head = new Node(null, null,' ');
            Node curr = head;
            int j = 0;
            while(j < n) {
                switch (s.charAt(j)) {
                    case 'r' : {
                        if(curr.next != null) {
                            if(j != n - 1){
                                curr.next.c = s.charAt(j + 1);
                            }
                        } else {
                            if(j != n - 1){
                                curr.next = new Node(null, curr, s.charAt(j + 1));
                            }
                        }
                        j += 2;
                        break;
                    }
                    case 'I' : {
                        curr = head;
                        j++;
                        break;
                    }
                    case 'H' : {
                        if (curr != head) {
                            curr = curr.previous;
                        }
                        j++;
                        break;
                    }
                    case 'L' : {
                        if (curr.next != null) {
                            curr = curr.next;
                        }
                        j++;
                        break;
                    }
                    case 'x' : {
                        if (curr.next != null) {
                            Node tmp = curr.next.next;
                            curr.next = tmp;
                            if(tmp != null) {
                                tmp.previous = curr;
                            }
                        }
                        j++;
                        break;
                    }
                    default : {
                        if (curr == head) {
                            Node tmp = curr.next;
                            curr.next = new Node(tmp, curr, s.charAt(j));
                            if(tmp != null)
                                tmp.previous = curr.next;
                            curr = curr.next;
                        } else {
                            if(curr.next == null) {
                                curr.next = new Node(null, curr, s.charAt(j));
                                curr = curr.next;
                            } else {
                                Node tmp = curr.next;
                                curr.next = new Node(tmp, curr, s.charAt(j));
                                tmp.previous = curr.next;
                                curr = curr.next;
                            }
                        }
                        j++;
                        break;
                    }
                }
            }
            curr = head.next;
            while(curr != null) {
                out.print(curr.c);
                curr = curr.next;
            }
            out.print("\n");
        }
        out.close();
    }

    static class QReader{
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
    static class QWriter implements Closeable{
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
