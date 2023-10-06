public class BinarySearchX{
    public static int binarySearchX (int[] a,int target) {//找target左边最大的值也就是<target的最大值
        int l = 0;
        int r = a.length-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(a[mid] >= target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return r;//既然我们要找小于target的值，那么我们就返回较小的r值
    }
    public static void main(String[] args){
        int[] a = {1,2,3,3,3,4,5,5,5,6,7};
        int target = 0;
        int i = binarySearchX(a,target);
        System.out.println("索引值: " + i);
    }
}
