package Luogu;

import java.io.*;
import java.util.StringTokenizer;

public class P1090{
    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        if(n == 1) {
            out.println(0);
        } else if(n == 2) {
            out.println(array[1] + array[0]);
        }
        mergeSort(array);
        array[1] += array[0];
        int ans = array[1];
        for(int i = 1; i < n - 1; i++) {
            for(int j = i; j < n - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
            array[i + 1] += array[i];
            ans += array[i + 1];
        }
        out.println(ans);
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
