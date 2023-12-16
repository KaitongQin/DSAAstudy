import java.util.concurrent.ThreadLocalRandom;

public class testAVL{
    public static void main(String[] args){
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(1, 10);
        }
        int[] index = new int[7];
        for (int i = 0; i < 7; i++) {
            index[i] = ThreadLocalRandom.current().nextInt(1, 4);
        }
        System.out.println(10 + " " + 4);
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < 7; i++) {
            System.out.print(index[i] + " ");
        }
    }
}
