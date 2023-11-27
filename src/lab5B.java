import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class lab5B{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int[] next = new int[s.length()];
        next[0] = 0;
        int k = 0;
        int j = k;

        for(int i = 1; i < s.length(); i++) {
            while(k > 0 && s.charAt(i) != s.charAt(k)) {
                j = next[k - 1];
                k = j;
            }
            if(s.charAt(i) == s.charAt(k)) {
                k++;
                j++;
            }
            next[i] = k;
        }
        for(int i = 0; i < s.length(); i++) {
            System.out.println(next[i]);
        }
    }
}
