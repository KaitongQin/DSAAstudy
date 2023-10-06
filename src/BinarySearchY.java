public class BinarySearchY{
    public static int binarySearchY (int[] a,int target){//找大于target的最小值
        int l = 0;
        int r = a.length - 1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(a[mid] <= target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l;//注意：这里返回的是大的l值，因为当l>r,跳出while循环
    }

    public static void main(String[] args){
        int[] a = {1,2,3,3,3,4,5,5,5,6,7};
        int target = 5;
        int i = binarySearchY(a,target);
        System.out.println("索引值: " + i);
    }
}
