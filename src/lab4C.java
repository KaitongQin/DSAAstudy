import java.io.*;
import java.util.StringTokenizer;

public class lab4C{
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
    }
    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        String s = in.nextLine();
        Stack stack = new Stack(s.length());
        int count = 0;
        int[] ans = new int[s.length() + 1];
        while(count < s.length()) {
            if(s.charAt(count) == '(') {
                stack.push(0);
            } else {
                if(ans[stack.top + 1] == 0) {
                    ans[stack.top] += 1;
                    ans[stack.top] %= 514329;
                    stack.pop();
                } else {
                    ans[stack.top]  = ans[stack.top] + 2 * ans[stack.top + 1];
                    ans[stack.top] %= 514329;
                    ans[stack.top + 1] = 0;
                    stack.pop();
                }
            }
            count++;
        }
        out.println(ans[0]);
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


