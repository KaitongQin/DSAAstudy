import java.io.*;
import java.util.StringTokenizer;

public class lab4A{
    static class Stack{
        private int[] array;
        private int top;
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
    }
    public static void main (String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int T = in.nextInt();
        label:
        for(int c = 0; c < T; c++) {
            int n = in.nextInt();
            Stack stack = new Stack(n);
            String s = in.next();
            int[] array = new int[n];
            for(int i = 0; i < n; i++) {
                switch (s.charAt(i)) {
                    case '{': array[i] = -3; break;
                    case '[': array[i] = -2; break;
                    case '(': array[i] = -1; break;
                    case ')': array[i] = 1; break;
                    case ']': array[i] = 2; break;
                    case '}': array[i] = 3; break;
                }
                if(array[i] < 0) {
                    stack.push(array[i]);
                } else {
                    if(stack.top == -1) {
                        out.println("NO");
                        continue label;
                    }
                    if(stack.array[stack.top] + array[i] == 0) {
                        stack.pop();
                    }
                }
            }
            if(stack.top == -1) {
                out.println("YES");
            } else {
                out.println("NO");
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
