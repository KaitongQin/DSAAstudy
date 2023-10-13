import java.io.*;
import java.util.*;

public class lab3_5{
    public static void main(String[] args) {
        QReader7 in = new QReader7();
        QWriter7 out = new QWriter7();
        int n = in.nextInt();
        int[] array = new int[n];
        int[] tmp = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        merge(array, tmp, 0, n - 1);
        int k = array[n/3];//1 2 2 3 3 3; 1 1 1 2 2 3 3
        out.println(k);
        int[] arr = new int[n];
        int j = 0;
        int l = n / 3;// 1 2 2 1 3 3 3
        int l1 = 0;
        for(int i = 0; i < n; i++) {
            if(array[i] == k && i <= n / 3) {
                l1 = i;
                l = i;
                break;
            }
        }
        for(int i = 0; i < n; i++) {
            if(j < l1) {
                if((i + 1) % 3 == 1) {
                    arr[i] = array[j];
                    j++;
                } else {
                    arr[i] = array[l];
                    l++;
                }
            } else {
                arr[i] = array[i];
            }
        }
        for(int a: arr) {
            out.print(a + " ");
        }
        out.close();
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
}

class QReader7 {
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

class QWriter7 implements Closeable {
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
