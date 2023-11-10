import java.util.Scanner;

public class lab5A{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            String s = in.next();
            int sl = s.length();
            System.out.println(sl*(sl+1)/2);
        }
    }
}
