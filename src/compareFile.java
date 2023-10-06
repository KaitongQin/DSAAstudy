import java.util.Random;
import java.util.Scanner;

public class compareFile {
    public static void main(String[] args) {
        // 生成一个随机数作为n的值
        int n = new Random().nextInt(5 * 10 * 6) + 1;
        System.out.println(n);

        // 读取n个随机整数
        int[] numbers = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            numbers[i] = random.nextInt(2147483647);
            System.out.print(numbers[i]+" ");
        }
    }
}

