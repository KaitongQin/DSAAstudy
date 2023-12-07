import java.util.concurrent.ThreadLocalRandom;

public class Ddata{
    public static void main(String[] args){
        int n = 10;
        System.out.println(n);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(1,5);
            System.out.print(array[i] + " ");
        }
    }
}
