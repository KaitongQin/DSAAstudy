import java.sql.Array;
import java.util.Scanner;

public class BinarySearch{
    public static void main(String[] args){
        int target = 13;
        int[] a = {1,13,14,17,19,20,30,49};
        int i=0,j=a.length-1;
        int m=-1;
        while(i<=j){
            m = (i+j)/2;
            if(a[m]>target){
                j=m-1;
            }else if(target>a[m]){
                i=m+1;
            }
            System.out.println(m);
        }

    }
    public int BinarySearchIdea(int target, int[] array){
        int left = 0;int right = array.length-1;
        while(left<=right){
            int middle = (left+right)/2;
            if(array[middle]==target){
                return middle;
            }else if(array[middle]>target){
                right = middle;
            }else{
                left = middle;
            }
        }
        return -1;
    }
    
}
