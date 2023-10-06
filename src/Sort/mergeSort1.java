package Sort;

public class mergeSort1{
    public static void merge_sort_1(long[] array, long[] array1) {
        long[] tmp = new long[array1.length];
        long[] tmp1 = new long[array1.length];
        long[] array2 = new long[array1.length];
        long[] tmp2 = new long[array1.length];
        for(int i = 0; i < array1.length; i++) {
            array2[i] = array[i] - array1[i];
        }
        merge(array, tmp, array1, tmp1, array2,tmp2, 0, array.length - 1);
    }
    private static void merge(long[] array1, long[] tmp1, long[] array2, long[] tmp2, long[] array3, long[] tmp3, int left, int right) {
        if(left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        merge(array1, tmp1, array2, tmp2, array3, tmp3, left, middle);
        merge(array1, tmp1, array2, tmp2, array3, tmp3, middle + 1, right);
        merge_sort(array1, tmp1, array2, tmp2, array3, tmp3, left, middle, right);
    }
    private static void merge_sort(long[] array1, long[] tmp1, long[] array2, long[] tmp2, long[] array3, long[] tmp3, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = left;
        while(i <= middle && j <= right) {
            if(array3[i] < array3[j]) {
                tmp1[k] = array1[i];
                tmp2[k] = array2[i];
                tmp3[k] = array3[i];
                i++;
                k++;
            } else {
                tmp1[k] = array1[j];
                tmp2[k] = array2[j];
                tmp3[k] = array3[j];
                j++;
                k++;
            }
        }
        while(i <= middle) {
            tmp1[k] = array1[i];
            tmp2[k] = array2[i];
            tmp3[k] = array3[i];
            i++;
            k++;
        }
        while(j <= right) {
            tmp1[k] = array1[j];
            tmp2[k] = array2[j];
            tmp3[k] = array3[j];
            j++;
            k++;
        }
        while(left <= right){
            array1[left] = tmp1[left];
            array2[left] = tmp2[left];
            array3[left] = tmp3[left];
            left++;
        }
    }
}
