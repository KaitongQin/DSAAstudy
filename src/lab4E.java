import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class lab4E{
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
        int m = in.nextInt();
        int[] array = new int[2000005];
        int c = 0;
        while (true) {
            int tmp = in.nextInt();
            if (tmp == -1) break;
            array[c] = tmp;
            c++;
        }
        Queue queue = new Queue(c);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            if(queue.isEmpty()) {
                queue.enQueue(i);
            } else {
                if(array[i] <= array[queue.array[queue.tail]] && queue.tail - queue.head < m) {
                    queue.enQueue(i);
                } else if(queue.tail - queue.head == m) {
                    queue.deQueue();
                    while(queue.tail > queue.head) {
                        if(array[queue.array[queue.tail]] > array[i]) break;
                        queue.pop();
                    }
                    queue.enQueue(i);
                } else {
                    while(queue.tail > queue.head && array[queue.array[queue.tail]] < array[i]) {
                        queue.pop();
                    }
                    queue.enQueue(i);
                }
            }
            if(queue.array[queue.head + 1] == i - m) {
                queue.deQueue();
            }
            if (i >= m - 1) {
                ans.add(array[queue.array[queue.head + 1]]);
            }
        }
        int answer = 0;
        if(ans.size() == 1) {
            out.println(answer ^ ans.get(0));
        } else {
            for(int i = 0; i < ans.size(); i++) {
                answer ^= ans.get(i);
            }
            out.println(answer);
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
