
import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.Scanner;

public class testLab1_6_2 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("test_input.txt");
            Scanner in = new Scanner(inputFile);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                // 在这里调用你的main函数，传入line作为参数
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
