import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab8F{
    static class node {
        int value;
        int a;
        int b;
        int degree;
        ArrayList<node> sons;
        public node(int value) {
            this.value = value;
            sons = new ArrayList<>();
            degree = 0;
        }
    }
    static class Queue{
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
        public int getTop() {
            int tmp = head + 1;
            return array[tmp];
        }
    }
    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        int mod = (int) (1e9 + 7);
        int T = in.nextInt();
        for (int c = 0; c < T; c++) {
            int n = in.nextInt();
            int m = in.nextInt();
            node[] nodes = new node[n + 1];
            for (int i = 1; i <= n; i++) {
                nodes[i] = new node(i);
                nodes[i].a = in.nextInt();
                nodes[i].b = in.nextInt();
            }
            for (int i = 1; i <= m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                nodes[u].sons.add(nodes[v]);
                nodes[v].degree++;
            }
            Queue queue = new Queue(n + 1);
            for (int i = 1; i <= n; i++) {
                if (nodes[i].degree == 0) {
                    queue.enQueue(i);
                }
            }
            long ans = 0;
            while (! queue.isEmpty()) {
                int head = queue.getTop();
                for (int i = 0; i < nodes[head].sons.size(); i++) {
                    int tmp = nodes[head].a + nodes[head].sons.get(i).a;
                    tmp %= mod;
                    nodes[head].sons.get(i).a = tmp;
                    ans += (long) nodes[head].a * nodes[head].sons.get(i).b;
                    ans %= mod;
                    nodes[head].sons.get(i).degree--;
                    if (nodes[head].sons.get(i).degree == 0) {
                        queue.enQueue(nodes[head].sons.get(i).value);
                    }
                }
                queue.deQueue();
            }
            out.println(ans % mod);
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
