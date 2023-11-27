import java.io.*;
import java.util.StringTokenizer;

public class lab6C{
    static class treeNode{
        int id;
        treeNode leftSon;
        treeNode rightSon;
        public treeNode(int id) {
            this.id = id;
            leftSon = null;
            rightSon = null;
        }
    }
    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        int T = in.nextInt();
        for(int c = 0; c < T; c++) {
            int n = in.nextInt();
            int[] pre_order = new int[n];
            int[] in_order = new int[n];
            for(int i = 0; i < n; i++) {
                pre_order[i] = in.nextInt();
            }
            for(int i = 0; i < n; i++) {
                in_order[i] = in.nextInt();
            }
            if(n == 1) {
                out.println(pre_order[0]);
            } else if(n == 2) {
                out.println(pre_order[1] + " " + pre_order[0]);
            } else {
                post_order(pre_order, in_order, 0, n - 1, 0, n - 1, out);
                out.print("\n");
            }
        }
        out.close();
    }
    public static void post_order(int[] array1, int[] array2, int l1, int r1, int l2, int r2, QWriter out) {
        if(l1 > r1) return;
        int p = l2;
        for(int i = l2; i <= r2; i++) {
            if(array2[i] == array1[l1]) {
                p = i;
                break;
            }
        }
        post_order(array1, array2, l1 + 1, l1 + p - l2, l2, p - 1, out);
        post_order(array1, array2, r1 - r2 + p + 1, r1, p + 1, r2, out);
        out.print(array2[p] + " ");
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
