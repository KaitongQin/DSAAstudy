import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab7C{
    static class node{
        long value;
        int i;
        int j;
        public node(long value) {
            this.value = value;
        }
    }
    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        long[] a = new long[n + 1];
        long[] b = new long[m + 1];
        ArrayList<Long> ans = new ArrayList <>();
        node[] heap = new node[m + 1];
        heap[0] = new node(0);
        for(int i = 1; i <= n; i++) {
            a[i] = in.nextLong();
        }
        mergeSort(a);
        for(int i = 1; i <= m; i++) {
            b[i] = in.nextLong();
            long t = a[1] * b[i];
            heap[i] = new node(t);
            heap[i].i = 1;
            heap[i].j = i;
            heap[0].value ++;
        }
        mergeSort(heap);
        for(int i = 0; i < k; i++) {
            node tmp = deQueue(heap);
            heap[0].value -= 1;
            ans.add(tmp.value);
            if(tmp.i != n) {
                long t = a[tmp.i + 1] * b[tmp.j];
                enQueue(heap, t, tmp.i + 1, tmp.j);
                heap[0].value ++;
            }
        }
        for(int i = 0; i < ans.size(); i++) {
            out.print(ans.get(i) + " ");
        }
        out.close();
    }
    public static void enQueue(node[] heap, long value, int i, int j) {
        int k = (int) heap[0].value + 1;
        heap[k] = new node(value);
        heap[k].i = i;
        heap[k].j = j;
        while(k > 1) {
            if(heap[k].value < heap[k / 2].value) {
                node tmp = heap[k];
                heap[k] = heap[k / 2];
                heap[k / 2] = tmp;
                k /= 2;
            } else {
                break;
            }
        }
    }
    public static node deQueue(node[] heap) {
        node tmp = heap[1];
        heap[1] = heap[(int) heap[0].value];
        heap[(int) heap[0].value] = null;
        int i = 1;
        while(i * 2 < (int) heap[0].value) {
            if(i * 2 == (int) heap[0].value - 1) {
                if(heap[i].value > heap[i * 2].value) {
                    node t = heap[i];
                    heap[i] = heap[i * 2];
                    heap[i * 2] = t;
                }
                break;
            }
            if(heap[i].value > Math.min(heap[i * 2].value, heap[i * 2 + 1].value))  {
                if(heap[i * 2].value == Math.min(heap[i * 2].value, heap[i * 2 + 1].value)) {
                    node t = heap[i];
                    heap[i] = heap[i * 2];
                    heap[i * 2] = t;
                    i *= 2;
                } else {
                    node t = heap[i];
                    heap[i] = heap[i * 2 + 1];
                    heap[i * 2 + 1] = t;
                    i = i * 2 + 1;
                }
            } else {
                break;
            }
        }
        return tmp;
    }
    public static void mergeSort(long[] array) {
        long[] tmp = new long[array.length];
        merge(array, tmp, 0, array.length - 1);
    }
    public static void merge(long[] array, long[] tmp, int l, int r) {
        if(l >= r) {
            return;
        }
        int mid = (r + l) / 2;
        merge(array, tmp, l, mid);
        merge(array, tmp, mid + 1, r);
        merge_sort(array, tmp, l, mid, r);
    }
    public static void merge_sort(long[] array, long[] tmp, int l, int mid, int r) {
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
    public static void mergeSort(node[] nodes) {
        node[] tmp = new node[nodes.length];
        merge(nodes, tmp, 1, nodes.length - 1);
    }
    public static void merge(node[] nodes, node[] tmp, int l, int r) {
        if(l >= r) return;
        int mid = (l + r) / 2;
        merge(nodes, tmp, l, mid);
        merge(nodes, tmp, mid + 1, r);
        sort(nodes, tmp, l, mid, r);
    }
    public static void sort(node[] nodes, node[] tmp, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int k = l;
        while(i <= mid && j <= r) {
            if(nodes[i].value < nodes[j].value) {
                tmp[k] = nodes[i];
                k++;
                i++;
            } else {
                tmp[k] = nodes[j];
                k++;
                j++;
            }
        }
        while(i <= mid) {
            tmp[k] = nodes[i];
            k++;
            i++;
        }
        while(j <= r) {
            tmp[k] = nodes[j];
            k++;
            j++;
        }
        while(l <= r) {
            nodes[l] = tmp[l];
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
