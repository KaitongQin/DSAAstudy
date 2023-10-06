import java.io.*;
import java.util.*;

public class lab1_2 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int[] a = new int[n];
        int[] c = new int[100001];
        int[] d = new int[100001];
        for(int i = 0;i<n;i++){
            a[i]=in.nextInt();
            c[a[i]]++;
        }
        int T = in.nextInt();
        int[] b = new int[T];
        boolean[] B = new boolean[T];
        for(int j = 0;j < T;j++){
            b[j] = in.nextInt();
            d[b[j]]++;
            if(c[b[j]]>0)
                B[j]=true;
        }
        for(int i = 0;i<T;i++){
            if(B[i]){
                out.println("yes");
            }else{
                out.println("no");
            }
        }
        out.close();
    }
}

class QReader {
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

class QWriter implements Closeable {
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
