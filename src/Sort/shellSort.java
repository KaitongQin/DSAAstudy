package Sort;

public class shellSort{
    public static void shell_sort(int[] array) {
        for(int step = array.length / 2; step > 0; step /= 2) {
            for(int i = step; i < array.length; i++) {
                int j = i;
                int tmp = array[j];
                while(j - step >= 0 && array[j - step] > tmp) {
                    array[j] = array[j - step];
                    j = j - step;
                }
                array[j] = tmp;
            }
            PrintArray(array);
        }
    }
    public static void PrintArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
