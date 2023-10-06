package Sort;

public class quickSort{
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
        int pivot = array[start];
        int b_s = start;
        int tmp;
        for(int i = start + 1; i <= end; i++) {
            if(array[i] <= pivot){
                b_s++;
                tmp = array[b_s];
                array[b_s] = array[i];
                array[i] = tmp;
            }
        }
        array[start] = array[b_s];
        array[b_s] = pivot;
        return b_s;
    }
}
