import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class testLab2_5 {
    public static void main(String[] args) {
        int L = generateRandomNumber(1, 1000000000);
        int n = generateRandomNumber(0, 500000);
        int m = generateRandomNumber(1, n + 1);

        List<Integer> numbers = generateRandomNumbers(L, n);

        System.out.println(L + " " + n + " " + m + " " + numbers);
    }

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    private static List<Integer> generateRandomNumbers(int L, int n) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            int number = random.nextInt(L - 1);
            numbers.add(number);
        }
        return numbers;
    }
}
