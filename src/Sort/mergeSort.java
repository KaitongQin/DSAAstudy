package Sort;

public class mergeSort{
    public static void mergesort(int[] array) {
        int[] tmp = new int[array.length];
        merge(array, tmp, 0, array.length - 1);
    }
    //时间复杂度为T(n) = 2*T(n/2) + O(n)
    //根据master theorem,a = 2, b = 2, log b(a) = 1;T(n) = O(nlogn);

    private static void merge(int[] array, int[] tmp, int left, int right) {
        //每次merge操作把n->n/2，时间复杂度为T(n) = T(n/2)*2
        if(left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        merge(array, tmp, left, middle);
        merge(array, tmp, middle + 1, right);
        merge_sort(array, tmp, left, right, middle);
    }
    private static void merge_sort(int[] array, int[] tmp, int left, int right, int middle) {
        //每次merge_sort的时间是O(n)
        int i = left;
        int j = middle + 1;
        int k = left;
        while(i <= middle && j <= right) {
            if(array[i] <= array[j]) {
                tmp[k] = array[i];
                i++;
                k++;
            } else {
                tmp[k] = array[j];
                j++;
                k++;
            }
        }
        while(i <= middle) {
            tmp[k] = array[i];
            i++;
            k++;
        }
        while(j <= right) {
            tmp[k] = array[j];
            j++;
            k++;
        }
        while(left <= right) {
            array[left] = tmp[left];
            left++;
        }
    }
}
