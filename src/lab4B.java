import java.io.*;
import java.util.StringTokenizer;

public class lab4B{
    private static class Node{
        int value;
        Node next;
        private Node( int value) {
            this.value = value;
        }
    }
    private static class Queue{
        private Node head;
        private Node tail;
        private int size;
        public Queue() {
            head = null;
            tail = null;
            size = 0;
        }
        public void enQueue(int value) {
            Node node = new Node(value);
            if(size == 0) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            size++;
        }
        public void deQueue() {
            if(size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
            size--;
        }
    }
    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int p = in.nextInt();
        int q = in.nextInt();
        Queue queue1 = new Queue();
        int[] count = new int[n+1];
        Queue queue2 = new Queue();
        for(int i = 0; i < p; i++) {
            int value = in.nextInt();
            queue1.enQueue(value);
            count[value]++;
        }
        for(int i = 0; i < q; i++) {
            int value = in.nextInt();
            queue2.enQueue(value);
            if(count[value] == 0) {
                count[value]++;
            }
        }
        int[] ans = new int[n];
        int j = 1;
        int k = 1;
        while(queue1.size != 0 && queue2.size != 0) {
            if(count[queue1.head.value] != 0) {
                ans[queue1.head.value - 1] = j;
                count[queue1.head.value] = 0;
                queue1.deQueue();
                j++;
            } else {
                queue1.deQueue();
            }
            if(count[queue2.head.value] != 0) {
                ans[queue2.head.value - 1] = k;
                count[queue2.head.value] = 0;
                queue2.deQueue();
                k++;
            } else {
                queue2.deQueue();
            }
        }
        while(queue1.size != 0) {
            if(count[queue1.head.value] != 0) {
                ans[queue1.head.value - 1] = j;
                count[queue1.head.value] = 0;
                queue1.deQueue();
                j++;
            } else {
                queue1.deQueue();
            }
        }
        while(queue2.size != 0) {
            if(count[queue2.head.value] != 0) {
                ans[queue2.head.value - 1] = k;
                count[queue2.head.value] = 0;
                queue2.deQueue();
                k++;
            } else {
                queue2.deQueue();
            }
        }
        for(int i = 0; i < n; i++) {
            out.print(ans[i] +" ");
        }
        out.close();
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


