import java.io.*;
import java.util.StringTokenizer;

public class lab3A{
    static class Node{
        long coefficient;
        long exponent;
        Node next;
        public Node(Node next, long coefficient, long exponent) {
            this.next = next;
            this.exponent = exponent;
            this.coefficient = coefficient;
        }
    }
    public static void main(String[] args){
        QReader4_1 in = new QReader4_1();
        QWriter4_1 out = new QWriter4_1();
        int n = in.nextInt();
        int m = in.nextInt();
        Node headN = new Node(null, 0,0);
        Node headM = new Node(null, 0, 0);
        Node currN = headN;
        Node currM = headM;
        for(int i = 0; i < n; i++) {
            long coef = in.nextLong();
            long expo = in.nextLong();
            currN.next = new Node(null, coef, expo);
            currN = currN.next;
        }
        for(int i = 0; i < m; i++) {
            long coef = in.nextLong();
            long expo = in.nextLong();
            currM.next = new Node(null, coef, expo);
            currM = currM.next;
        }
        currN = headN.next;
        currM = headM.next;
        Node headAns = new Node(null, 0, 0);
        Node currAns = headAns;
        int ans = n + m;
        while(currN != null && currM != null) {
            if(currN.exponent > currM.exponent) {
                currAns.next = new Node(null, currN.coefficient, currN.exponent);
                currAns = currAns.next;
                currN = currN.next;
            } else if (currN.exponent < currM.exponent) {
                currAns.next = new Node(null, currM.coefficient, currM.exponent);
                currAns = currAns.next;
                currM = currM.next;
            } else {
                ans -= 1;
                long coef = currM.coefficient + currN.coefficient;
                if(coef != 0) {
                    currAns.next = new Node(null, coef, currN.exponent);
                    currAns = currAns.next;
                }
                currN = currN.next;
                currM = currM.next;
            }
        }
        while(currN != null) {
            currAns.next = new Node(null, currN.coefficient, currN.exponent);
            currAns = currAns.next;
            currN = currN.next;
        }
        while(currM != null) {
            currAns.next = new Node(null, currM.coefficient, currM.exponent);
            currAns = currAns.next;
            currM = currM.next;
        }
        out.println(ans);
        currAns = headAns.next;
        for(int i = 0; i < ans; i++) {
            out.println(currAns.coefficient + " " + currAns.exponent);
            currAns = currAns.next;
            if(currAns == null) {
                break;
            }
        }
        out.close();
    }
    static class QReader4_1 {
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
    static class QWriter4_1 implements Closeable{
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


