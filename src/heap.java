import java.util.Scanner;

public class heap{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            h[i] = in.nextInt();
        }

    }
    public static void Insert(int[] heap, int i) {
        while(i > 1) {
            if(heap[i] > heap[i / 2]) {
                int t = heap[i];
                heap[i] = heap[i + 1];
                heap[i + 1] = t;
                i = i / 2;
            } else {
                break;
            }
        }
    }
    public static void Delete(int[] heap, int i) {

    }
}
