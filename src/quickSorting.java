public class quickSorting{
    public static void main (String[] args){
        int a[] = {1,2,5,4,4,5,6,8,7,10};
        int k = 7;
        int t = QuickSort(0,a.length-1,k,a);
        System.out.println(t);
    }
    public static int QuickSort(int l, int r, int k,int[] a){
        if(l>=r)
            return a[l];
        int i = l;
        int j = r;
        int t = a[(i+j)/2];
        while(i<j){
            do {
                i++;
            } while(a[i]<t);
            do {
                j--;
            }while(a[j]>t);
            if(i<=j){
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        if(j-l+1>=k)
            return QuickSort(l,j,k,a);
        else
            return QuickSort(j+1,r,k-(j-l+1),a);
    }
}
