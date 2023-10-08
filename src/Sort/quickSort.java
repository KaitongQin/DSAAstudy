package Sort;

public class quickSort{
    public static void main(String[] args) {
        int[] array = {1,1,1,1,1,1,1,1,1,1,1,1};
        int p = partition(array,0, 11);
        System.out.println(p);
    }
    public static void Sort (int[] array) {
        sortSection(array, 0, array.length - 1);
    }
    private static void sortSection (int[] array, int start, int end) {
        if(start >= end) return;
        int p = partition(array, start, end);
        sortSection(array, start,p - 1);
        sortSection(array, p + 1, end);
    }
    private static int partition (int[] array, int start, int end) {
        int pivot = array[end];
        int b_s = start - 1;
        int tmp;
        for(int i = start; i <= end - 1; i++) {
            if(array[i] <= pivot){
                b_s++;
                tmp = array[b_s];
                array[b_s] = array[i];
                array[i] = tmp;
            }
        }
        array[start] = array[b_s + 1];
        array[b_s + 1] = pivot;
        return b_s + 1;
    }
    private static void PrintArray(int[] array) {
        for(int a: array){
            System.out.print(a + " ");
        }
    }
}
