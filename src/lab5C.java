import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class lab5C{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        QWriter out = new QWriter();
        String s = in.next();
        int m = s.length();
        int[][] tran = new int[m][26];
        int x = 0;
        for(int i = 0; i < 26; i++) {
            if(s.charAt(0) - 97 == i) {
                tran[0][i] = 1;
            } else {
                tran[0][i] = 0;
            }
        }
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < 26; j++) {
                if((s.charAt(i) - 97) == j) {
                    tran[i][j] = i + 1;
                } else {
                    tran[i][j] = tran[x][j];
                }
            }
            x = tran[x][s.charAt(i) - 97];
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < 26; j++) {
                out.print(tran[i][j] + " ");
            }
            out.print("\n");
        }
        out.close();
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
