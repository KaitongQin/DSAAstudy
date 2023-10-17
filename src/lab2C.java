import java.io.*;
import java.util.*;

public class lab2C{
    public static void main(String[] args) {
        QReader5 in = new QReader5();
        QWriter5 out = new QWriter5();
        int T = in.nextInt();
        for(int i = 0; i < T; i++){
            int n = in.nextInt();
            int[] a = new int[n];
            int[] tmp = new int[n];
            for(int j = 0; j < n; j++){
                a[j] = in.nextInt();
            }
            long ans = 0;
            ans = merge(a,tmp,0,n-1,ans);
            out.println(ans);
        }
        out.close();
    }
    public static long merge(int[] a, int[] tmp, int left, int right,long ans){
        if(left>=right){
            return 0;
        }
        int mid = (left + right) / 2;
        return merge(a,tmp,left,mid,ans)
                +merge(a,tmp,mid+1,right,ans)
                +merge_sort(a,tmp,left,mid,right,ans);
    }
    public static long merge_sort(int[] a, int[] tmp, int left, int mid, int right,long ans){
        int left1 = left;
        int right1 = mid + 1;
        int left2 = left;
        while(left1 <= mid && right1 <= right){
            if(a[left1] <= a[right1]){
                tmp[left2] = a[left1];
                left1++;
                left2++;
            }else{
                tmp[left2] = a[right1];
                right1++;
                left2++;
                ans+= mid -left1 + 1;
            }
        }
        while(left1 <= mid){
            tmp[left2] = a[left1];
            left1++;
            left2++;
        }
        while(right1 <= right){
            tmp[left2] = a[right1];
            right1++;
            left2++;
        }
        while(left <= right){
            a[left] = tmp[left];
            left++;
        }
        return ans;
    }
}

class QReader5 {
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

class QWriter5 implements Closeable {
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
