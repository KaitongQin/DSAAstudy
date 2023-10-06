package Sort;

public class insertionSort{
    //插入排序
    public static void insertion_sort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j-1] > array[j]) {
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                }
            }
        }
    }
    public static void insertion_sort_1(int[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j-1] > array[j]) {
                    int tmp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = tmp;
                } else {
                    break;
                }
            }
        }
    }
}
