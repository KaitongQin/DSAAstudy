import java.io.*;
import java.util.*;

public class lab2A_1 {
    public static void main(String[] args) {
        QReader1 in = new QReader1();
        QWriter1 out = new QWriter1();
        int T = in.nextInt();
        for(int i = 0;i<T;i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] an = new int[n];
            int[] am = new int[m];
            for(int j = 0;j<n;j++){
                an[j] = in.nextInt();
            }
            for(int j = 0;j<m;j++){
                am[j] = in.nextInt();
            }
            int[] amn = new int[m+n];
            int j = 0;
            int k = 0;
            while(j<n&&k<m){
                if(an[j]<=am[k]){
                    amn[j+k] = an[j];
                    j++;
                }else{
                    amn[j+k] = am[k];
                    k++;
                }
            }
            while(j<n){
                amn[j+k] = an[j];
                j++;
            }
            while(k<m){
                amn[j+k] = am[k];
                k++;
            }
            for(int i1 = 0;i1<m+n-1;i1++){
                out.print(amn[i1]+" ");
            }
            out.print(amn[m+n-1]);
            out.print('\n');
        }
        out.close();
    }
}

class QReader1 {
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

class QWriter1 implements Closeable {
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
