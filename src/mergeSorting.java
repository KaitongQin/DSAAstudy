public class mergeSorting{
    public static void merge(int[] a,int[] tmp, int l, int r){
        if(l>=r){
            return;
        }
        int mid = (l + r) / 2;
        merge(a, tmp, 0, mid);
        merge(a, tmp, mid+1, r);
        merge_sort(a, tmp, l, r, mid);
    }
    public static void merge_sort(int[] a, int[] tmp, int left, int right, int mid){
        int left1 = left;
        int right1 = mid + 1;
        int left2 = left;
        while(left1 <= mid && right1 <= right){
            if(a[left1] < a[right1]){
                tmp[left2] = a[left1];
                left1++;
                left2++;
            }else{
                tmp[left2] = a[right1];
                right1++;
                left2++;
            }
        }
        while(left1 <= mid){
            tmp[left2] = a[left1];
            left1++;
            left2++;
        }
        while(right1 <= right){
            tmp[left2] = a[right1];
            right1++;
            left2++;
        }
        while(left <= right){
            a[left] = tmp[left];
            left++;
        }
    }

    public static void main(String[] args){
        int[] a = {1,3,5,7,9,2,4,5,7,8,11,13};
        int[] tmp = new int[a.length];
        for(int i = 0;i<a.length;i++){
            tmp[i] = a[i];
        }
        merge(a,tmp,0,a.length-1);
        for(int i = 0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
