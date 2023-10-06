package Sort;

public class bubbleSort{
    //未进行优化的冒泡排序
    public static void bubble_sort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
    //优化后的冒泡排序
    public static void bubble_sort_1(int[] array) {
        for(int i = 1; i < array.length; i++) {
            for(int j = 0; j < array.length - i; j++) {
                if(array[j + 1] < array[j]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}
