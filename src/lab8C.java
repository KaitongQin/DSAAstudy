import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab8C{
    static class node {
        int color;
        int value;
        boolean visited;
        ArrayList<node> sons;
        public node (int value) {
            this.value = value;
            color = 0;
            visited = false;
            sons = new ArrayList<>();
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
    public static void main (String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int T = in.nextInt();
        for (int c = 0; c < T; c++) {
            int n = in.nextInt();
            int m = in.nextInt();
            node[] nodes = new node[n + 1];
            for (int i = 1; i <= n; i++) {
                nodes[i] = new node(i);
            }
            for (int i = 1; i <= m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                nodes[u].sons.add(nodes[v]);
                nodes[v].sons.add(nodes[u]);
            }
            int h = 1;
            for (int i = 1; i <= n; i++) {
                if (nodes[i].sons.size() > nodes[h].sons.size()) {
                    h = i;
                }
            }
            nodes[h].color = 1;
            Queue queue = new Queue(n + 1);
            queue.enQueue(h);
            ArrayList<Integer> ans1 = new ArrayList<>();
            ArrayList<Integer> ans2 = new ArrayList<>();
            while (!queue.isEmpty()) {
                int head = queue.getTop();
                nodes[head].visited = true;
                for (int i = 0; i < nodes[head].sons.size(); i++) {
                    if (nodes[head].sons.get(i).visited) continue;
                    nodes[head].sons.get(i).visited = true;
                    nodes[head].sons.get(i).color = 1 - nodes[head].color;
                    queue.enQueue(nodes[head].sons.get(i).value);
                }
                if (nodes[head].color == 1) {
                    ans1.add(head);
                } else {
                    ans2.add(head);
                }
                queue.deQueue();
            }
            if (ans1.size() < ans2.size()) {
                out.println(ans1.size());
                for (int i = 0; i < ans1.size(); i++) {
                    out.print(ans1.get(i) + " ");
                }
            } else {
                out.println(ans2.size());
                for (int i = 0; i < ans2.size(); i++) {
                    out.print(ans2.get(i) + " ");
                }
            }
            out.print("\n");
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
