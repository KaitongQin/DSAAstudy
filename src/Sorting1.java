import java.util.Arrays;

public class Sorting1{
    public static void main(String[] args){
        int[] a = {1,3,12,24,1,2,5,6,7,98,96,56,43};
        arraySort(a);
        for(int a1: a){
            System.out.print(a1+" ");
        }
    }
    public static void arraySort(int[] a){
        for(int i = 1;i<a.length;i++){ //冒泡排序
            for(int j = 0;j<a.length-i;j++){
                if(a[j]>a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }
}
