import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab6B{
    static class Queue {
        int front;
        int rear;
        int[] array;
        int[] weight;
        public Queue(int n) {
            array = new int[n];
            weight = new int[n];
            front = -1;
            rear = -1;
        }
        public void enQueue(int value, int w) {
            rear++;
            array[rear] = value;
            weight[rear] = w;
        }
        public void deQueue() {
            front++;
        }
        public int getTop() {
            int tmp = front + 1;
            return array[tmp];
        }
        public int getTopWeight() {
            int tmp = front + 1;
            return weight[tmp];
        }
        public boolean isEmpty() {
            return front == rear;
        }
    }
    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int num = in.nextInt();
        ArrayList[] arrayLists = new ArrayList[n + 1];
        ArrayList[] weights = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            arrayLists[i] = new ArrayList<>();
            weights[i] = new ArrayList<>();
        }
        for(int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            arrayLists[u].add(v);
            arrayLists[v].add(u);
            weights[u].add(w);
            weights[v].add(w);
        }
        Queue queue = new Queue(n + 2);
        boolean[] booleans = new boolean[n + 1];
        int ans = 0;
        queue.enQueue(1, 0);
        while(!queue.isEmpty()) {
            int head = queue.getTop();
            int headWeight = queue.getTopWeight();
            booleans[head] = true;
            for(int i = 0; i < arrayLists[head].size(); i++) {
                if(booleans[(Integer) arrayLists[head].get(i)]) {
                    continue;
                }
                booleans[(Integer) arrayLists[head].get(i)] = true;
                int tmp = (Integer) arrayLists[head].get(i);
                int tmpWeight = (Integer) weights[head].get(i);
                tmpWeight += headWeight;
                if(tmpWeight == num && arrayLists[tmp].size() == 1) {
                    ans++;
                }
                queue.enQueue(tmp, tmpWeight);
            }
            queue.deQueue();
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
