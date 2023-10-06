package Sort;

public class selectionSort{
    //选择排序主要是遍历i+1 -> n找到一个最小值，和i进行交换
    public static void selection_sort(int[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            int k = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[k]){
                    k = j;
                }
            }
            int tmp = array[i];
            array[i] = array[k];
            array[k] = tmp;
        }
    }
    private static void selection_sort_1(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int k = i;
            for(int j = i; j < array.length; j++) {
                if(array[j] < array[k])
                    k = j;
            }
            int tmp = array[k];
            array[k] = array[i];
            array[i] = tmp;
        }
    }
}
