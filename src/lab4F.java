import java.io.*;
import java.util.StringTokenizer;

public class lab4F{
    static class Queue {
        int head;
        int tail;
        int[] array;
        public Queue (int m) {
            array = new int[m];
            head = -1;
            tail = -1;
        }
        public void enQueue (int element) {
            tail++;
            array[tail] = element;
        }
        public void deQueue () {
            head++;
        }
        public void pop () {
            tail--;
        }
        public boolean isEmpty () {
            return head == tail;
        }
    }

    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        int k = in.nextInt();
        int n = in.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        Queue queueMax = new Queue(array.length);
        Queue queueMin = new Queue(array.length);
        int ans = 0;
        int left = 0;
        for(int i = 0; i < array.length; i++) {
            if(queueMin.isEmpty()) {
                queueMin.enQueue(i);
            } else {
                while(! queueMin.isEmpty() && array[queueMin.array[queueMin.tail]] > array[i]) {
                    queueMin.pop();
                }
                queueMin.enQueue(i);
            }
            if(queueMax.isEmpty()) {
                queueMax.enQueue(i);
            } else {
                while(! queueMax.isEmpty() && array[queueMax.array[queueMax.tail]] < array[i]) {
                    queueMax.pop();
                }
                queueMax.enQueue(i);
            }
            while(array[queueMax.array[queueMax.head + 1]] - array[queueMin.array[queueMin.head + 1]] > k) {
                if(queueMin.array[queueMin.head + 1] < queueMax.array[queueMax.head + 1]) {
                    left = queueMin.array[queueMin.head + 1] + 1;
                    queueMin.deQueue();
                } else {
                    left = queueMax.array[queueMax.head + 1] + 1;
                    queueMax.deQueue();
                }
            }
            ans = Math.max(ans, i - left + 1);
        }
        out.println(ans);
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
