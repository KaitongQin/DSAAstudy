import java.io.*;
import java.util.*;

public class lab3_6 {
    public static void main(String[] args) {
        QReader6 in = new QReader6();
        QWriter6 out = new QWriter6();
        int n = in.nextInt();
        int p = in.nextInt();
        long pn = 1;
        for(int i = 0; i < p; i++) {
            pn *= 2;
        }
        int q = in.nextInt();
        long[] h = new long[n];
        long[] s = new long[n];
        long[] h_s = new long[n];
        long sumS = 0;
        for(int i = 0; i < n; i++) {
            h[i] = in.nextLong();
            s[i] = in.nextLong();
            h_s[i] = h[i] - s[i];
            sumS += s[i];
        }
        if(q == 0) {
            out.print(sumS);
            out.close();
        }
        long[] h1 = new long[n];
        long[] s1 = new long[n];
        long[] h1_s1 = new long[n];
        int q1 = q;
        merge(h, h1, s, s1, h_s, h1_s1, 0, n-1);
        long min;
        if(h_s[n - 1] > 0)
            min = h_s[n - 1];
        else
            min = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(q > 0 && h_s[i] > 0) {
                sumS += h_s[i];
                min = h_s[i];
                q--;
            }
        }
        long[] ans = new long[n];
        long[] ans1 = new long[n];
        for(int i = n - 1; i >= 0; i--) {
            long sumS1;
            if(q1 > 0 && h_s[i] > 0) {
                sumS1 = sumS - h_s[i] + h[i] * pn - s[i];
                ans[i] = sumS1;
                q1--;
            } else if(q1 <= 0) {
                if(h[i] * pn - s[i] > min) {
                    sumS1 = sumS - min + h[i] * pn - s[i];
                    ans[i] = sumS1;
                }
            } else {
                if(h[i] * pn - s[i] > 0){
                    sumS1 = sumS + h[i] * pn - s[i];
                    ans[i] = sumS1;
                } else {
                    ans[i] = sumS;
                }
            }
        }
        merge(ans, ans1, 0, n-1);
        out.print(ans[n-1]);
        out.close();
    }
    private static void merge(long[] array, long[] tmp, int left, int right) {
        if(left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        merge(array, tmp, left, middle);
        merge(array, tmp, middle+1, right);
        merge_sort(array, tmp, left, middle, right);

    }
    private static void merge_sort(long[] array, long[] tmp, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = left;
        while(i <= middle && j <= right) {
            if(array[i] < array[j]) {
                tmp[k] = array[i];
                i++;
                k++;
            } else {
                tmp[k] = array[j];
                j++;
                k++;
            }
        }
        while(i <= middle) {
            tmp[k] = array[i];
            i++;
            k++;
        }
        while(j <= right) {
            tmp[k] = array[j];
            j++;
            k++;
        }
        while(left <= right) {
            array[left] = tmp[left];
            left++;
        }
    }
    private static void merge(long[] array1, long[] tmp1, long[] array2, long[] tmp2, long[] array3, long[] tmp3, int left, int right) {
        if(left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        merge(array1, tmp1, array2, tmp2, array3, tmp3, left, middle);
        merge(array1, tmp1, array2, tmp2, array3, tmp3, middle + 1, right);
        merge_sort(array1, tmp1, array2, tmp2, array3, tmp3, left, middle, right);
    }
    private static void merge_sort(long[] array1, long[] tmp1, long[] array2, long[] tmp2, long[] array3, long[] tmp3, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = left;
        while(i <= middle && j <= right) {
            if(array3[i] < array3[j]) {
                tmp1[k] = array1[i];
                tmp2[k] = array2[i];
                tmp3[k] = array3[i];
                i++;
                k++;
            } else {
                tmp1[k] = array1[j];
                tmp2[k] = array2[j];
                tmp3[k] = array3[j];
                j++;
                k++;
            }
        }
        while(i <= middle) {
            tmp1[k] = array1[i];
            tmp2[k] = array2[i];
            tmp3[k] = array3[i];
            i++;
            k++;
        }
        while(j <= right) {
            tmp1[k] = array1[j];
            tmp2[k] = array2[j];
            tmp3[k] = array3[j];
            j++;
            k++;
        }
        while(left <= right){
            array1[left] = tmp1[left];
            array2[left] = tmp2[left];
            array3[left] = tmp3[left];
            left++;
        }
    }
}

class QReader6 {
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

class QWriter6 implements Closeable {
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
