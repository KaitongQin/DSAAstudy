import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab7A{
    static class Queue{
        int[] array;
        int front;
        int rear;
        public Queue(int n) {
            array = new int[n];
            front = -1;
            rear = -1;
        }
        public void enQueue(int value) {
            rear++;
            array[rear] = value;
        }
        public void deQueue() {
            front++;
        }
        public int getTop() {
            int tmp = front + 1;
            return array[tmp];
        }
        public boolean isEmpty() {
            return rear == front;
        }
    }

    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        int T = in.nextInt();
        label:
        for(int c = 1; c <= T; c++) {
            int n = in.nextInt();
            int[] value = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                value[i] = in.nextInt();
            }
            ArrayList[] arrayLists = new ArrayList[n + 1];
            for(int i = 1; i <= n; i++) {
                arrayLists[i] = new ArrayList<>();
            }
            boolean[] hasFa = new boolean[n + 1];
            for(int i = 1; i < n; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                hasFa[v] = true;
                arrayLists[u].add(v);
            }
            if(n == 1) {
                out.print("Case #" + c + ": YES");
                continue label;
            }
            int root = 0;
            for(int i = 1; i <= n; i++) {
                if(!hasFa[i]) {
                    root = i;
                    break;
                }
            }
            int[] id = new int[n + 1];
            int index = 1;
            Queue queue = new Queue(n + 1);
            queue.enQueue(root);
            while(!queue.isEmpty()) {
                int head = queue.getTop();
                id[index] = head;
                index++;
                for(int i = 0; i < arrayLists[head].size(); i++) {
                    queue.enQueue((Integer) arrayLists[head].get(i));
                }
                queue.deQueue();
            }
            boolean ans = true;
            if(value[(Integer) arrayLists[id[1]].get(0)] <= value[id[1]]) {
                for(int i = 1; i <= (n - 1) / 2; i++) {
                    if(!(arrayLists[id[i]].size() == 2 && value[(Integer) arrayLists[id[i]].get(0)] <= value[id[i]] && value[(Integer) arrayLists[id[i]].get(1)] <= value[id[i]])) {
                        ans = false;
                        break;
                    }
                }
                if(n % 2 == 0) {
                    if(!(arrayLists[id[n / 2]].size() == 1 && value[(Integer) arrayLists[id[n / 2]].get(0)] <= value[id[n / 2]]))
                        ans = false;
                }
            } else {
                for(int i = 1; i <= (n - 1) / 2; i++) {
                    if(!(arrayLists[id[i]].size() == 2 && value[(Integer) arrayLists[id[i]].get(0)] >= value[id[i]] && value[(Integer) arrayLists[id[i]].get(1)] >= value[id[i]])) {
                        ans = false;
                        break;
                    }
                }
                if(n % 2 == 0) {
                    if(!(arrayLists[id[n / 2]].size() == 1 && value[(Integer) arrayLists[id[n / 2]].get(0)] >= value[id[n / 2]]))
                        ans = false;
                }
            }
            if(ans) {
                out.print("Case #" + c + ": YES");
            } else {
                out.print("Case #" + c + ": NO");
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
