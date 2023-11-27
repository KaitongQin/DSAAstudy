import java.io.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class lab6E{
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
        int n = in.nextInt();
        ArrayList[] arrayLists = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for(int i = 1; i < n; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            arrayLists[u].add(v);
            arrayLists[v].add(u);
        }
        int m = in.nextInt();
        int[] ans = new int[m];
        for(int i = 0; i < m; i++) {
            int tmp = in.nextInt();
            ans[i] = tmp;
        }
        Queue queue = new Queue(n);
        boolean[] booleans = new boolean[n + 1];
        int[] len = new int[n + 1];
        queue.enQueue(1);
        booleans[1] = true;
        while(!queue.isEmpty()) {
            int head = queue.getTop();
            for(int i = 0; i < arrayLists[head].size(); i++) {
                if(booleans[(Integer) arrayLists[head].get(i)])
                    continue;
                int value = (Integer) arrayLists[head].get(i);
                booleans[value] = true;
                queue.enQueue(value);
                len[value] = len[head] + 1;
            }
            queue.deQueue();
        }
        for(int i = 0; i < m; i++) {
            int tmp = len[ans[i]];
            ans[i] = tmp;
        }
        mergeSort(ans);
        if(n == 2){
            out.println(ans[m - 1]);
        } else {
            for(int i = 1; i < m; i++) {
                if(ans[i] == 1)
                    continue;
                ans[i] = Math.max(ans[i], ans[i - 1] + 1);
            }
            out.println(ans[m - 1]);
        }
        out.close();
    }
    public static void mergeSort(int[] array) {
        int[] tmp = new int[array.length];
        merge(array, tmp, 0, array.length - 1);
    }
    public static void merge(int[] array, int[] tmp, int l, int r) {
        if(l >= r) {
            return;
        }
        int mid = (r + l) / 2;
        merge(array, tmp, l, mid);
        merge(array, tmp, mid + 1, r);
        merge_sort(array, tmp, l, mid, r);
    }
    public static void merge_sort(int[] array, int[] tmp, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int k = l;
        while(i <= mid && j <= r) {
            if(array[i] <= array[j]) {
                tmp[k] = array[i];
                k++;
                i++;
            } else {
                tmp[k] = array[j];
                k++;
                j++;
            }
        }
        while(i <= mid) {
            tmp[k] = array[i];
            k++;
            i++;
        }
        while(j <= r) {
            tmp[k] = array[j];
            k++;
            j++;
        }
        while(l <= r) {
            array[l] = tmp[l];
            l++;
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