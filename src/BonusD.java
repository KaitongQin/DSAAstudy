import java.io.*;
import java.util.StringTokenizer;

public class BonusD{
    private static class Stack {
        int[] array;
        int top;
        public Stack(int n) {
            array = new int[n];
            top = -1;
        }
        public void push(int element) {
            if(top != array.length - 1) {
                top++;
                array[top] = element;
            }
        }
        public void pop() {
            if(top != -1) {
                top--;
            }
        }
        public int getTop() {
            return array[top];
        }
        public boolean isEmpty() {
            return top == -1;
        }
    }
    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        int T = in.nextInt();
        for (int c = 0; c < T; c++) {
            int n = in.nextInt();
            int[] array = new int[n];
            int[] days = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }
            int q = in.nextInt();
            int[] ans = new int[q];
            for (int i = 0; i < q; i++) {
                ans[i] = in.nextInt();
            }
            Stack stack = new Stack(n);
            for (int i = 0; i < n; i++) {
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty()) {
                        if (array[stack.getTop()] < array[i]) {
                            days[stack.getTop()] = i - stack.getTop();
                            stack.pop();
                        } else {
                            break;
                        }
                    }
                    stack.push(i);
                }
            }
            while (!stack.isEmpty()) {
                days[stack.getTop()] = - 1;
                stack.pop();
            }
            for (int i = 0; i < q; i++) {
                if (ans[i] >= n) {
                    out.println(-1);
                } else {
                    out.println(days[ans[i] - 1]);
                }
            }
        }
        out.close();
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
