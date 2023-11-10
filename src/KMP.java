import java.util.Scanner;

public class KMP {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String pattern = in.next();
        String text = in.next();
        int[] next = new int[pattern.length()];
        int j = 0;
        for (int i = 0; i < pattern.length(); i++) {
        }
    }
    public static void findNext (String pattern, int[] next) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (pattern.charAt(j) == pattern.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
    }
}
