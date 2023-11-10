import java.util.Scanner;

public class lab5F{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long[] encrypted = new long[26];
        for(int i = 0; i < 26; i++) {
            String tmp = in.next();
            encrypted[i] = tmp.charAt(0);
        }
        String s = in.next();
        int ans = (s.length() + 1) / 2;
        long p = 1333;
        long p0 = 1;
        long[] array1 = new long[s.length() - ans];
        long[] array0 = new long[s.length() - ans];
        for(int i = s.length() - 1; i >= ans; i--) {
            array1[0] += encrypted[s.charAt(i) - 97] * p0;
            array0[0] += s.charAt(i - ans) * p0;
            p0 *= p;
        }
        int count = 0;
        long p1 = 1;
        while(ans < s.length() - 1) {
            if(array1[count] == array0[count]) {
                break;
            }
            count++;
            array0[count] = array0[count - 1] - s.charAt(s.length() - 1 - ans) * p1;
            array1[count] = array1[count - 1] * p - encrypted[s.charAt(ans) - 97] * p0;
            p1 *= p;
            ans++;
        }
        if(ans == s.length() - 1) {
            if(s.charAt(0) != encrypted[s.charAt(s.length() - 1) - 97])
                ans++;
        }
        System.out.println(ans);
    }
}
