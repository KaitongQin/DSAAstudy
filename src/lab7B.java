import java.util.Scanner;

public class lab7B{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] heap = new int[n + 1];
        int[] ans = new int[n + 1];
        for(int i = 1; i < n + 1; i++) {
            heap[i] = in.nextInt();
            int tmp = i;
            while(tmp > 1) {
                if(heap[tmp] > heap[tmp / 2]) {
                    int t = heap[tmp];
                    heap[tmp] = heap[tmp / 2];
                    heap[tmp / 2] = t;
                    tmp = tmp / 2;
                    ans[i] ++;
                } else {
                    break;
                }
            }
        }
        for(int i = 1; i < n + 1; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
