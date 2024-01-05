import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class lab9D{
    static class node{
        int i;
        int color;
        ArrayList<node> sons;
        boolean inQueue;
        public node(int i) {
            this.i = i;
            sons = new ArrayList <>();
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
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int c = in.nextInt();
        node[] nodes = new node[n + 1];
        int[][] colors = new int[n + 1][k + 1];
        boolean[][] inqueue = new boolean[n + 1][k + 1];
        int[] cnt = new int[k + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new node(i);
            nodes[i].color = in.nextInt();
            cnt[nodes[i].color]++;
            Arrays.fill(colors[i], Integer.MAX_VALUE);
            colors[i][nodes[i].color] = 0;
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            nodes[u].sons.add(nodes[v]);
            nodes[v].sons.add(nodes[u]);
        }
        for (int i = 1; i <= k; i++) {
            Queue queue = new Queue(n + 1);
            for (int j = 1; j <= n; j++) {
                if (nodes[j].color == i) {
                    queue.enQueue(j);
                    inqueue[j][i] = true;
                }
            }
            while (!queue.isEmpty()) {
                int tmp = queue.getTop();
                queue.deQueue();
                for(int s = 0; s < nodes[tmp].sons.size(); s++){
                    if (colors[tmp][i] + 1 < colors[nodes[tmp].sons.get(s).i][i]) {
                        colors[nodes[tmp].sons.get(s).i][i] = colors[tmp][i] + 1;
                        if (!inqueue[nodes[tmp].sons.get(s).i][i]) {
                            queue.enQueue(nodes[tmp].sons.get(s).i);
                            inqueue[nodes[tmp].sons.get(s).i][i] = true;
                        }
                    }

                }
            }
        }

        long[] ans = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            int[] tmp = new int[k + 1];
            merge(colors[i], tmp, 1, k);
            for (int j = c; j >= 1; j--) {
                ans[i] += colors[i][j];
            }
            Arrays.fill(tmp, 0);
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
    public static void merge(int[] array, int[] tmp, int start, int end) {
        if(start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        merge(array, tmp, start, mid);
        merge(array, tmp, mid+1, end);
        merge_sort(array, tmp, start, mid, end);
    }
    public static void merge_sort(int[] array, int[] tmp, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;
        while(i <= mid && j <= end) {
            if(array[i] > array[j]) {
                tmp[k] = array[j];
                j++;
                k++;
            } else {
                tmp[k] = array[i];
                i++;
                k++;
            }
        }
        while(i <= mid) {
            tmp[k] = array[i];
            i++;
            k++;
        }
        while(j <= end) {
            tmp[k] = array[j];
            j++;
            k++;
        }
        while(start <= end) {
            array[start] = tmp[start];
            start++;
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
