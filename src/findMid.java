public class findMid{
    public static void main(String[] args){
        int[] arrayA = {1,3,4,5};
        int[] arrayB = {2,6,7,8};
        int c = find_mid(arrayA, arrayA.length , arrayB, arrayB.length);
        System.out.println(c);
    }
    public static int find_mid(int[] arrayA, int n, int[] arrayB, int m) {
        int la = 0, ra = n - 1;
        int lb = 0, rb = m - 1;
        int mid;
        if((n + m) % 2 == 0) {
            mid = (n + m) / 2;
        } else {
            mid = (n + m) / 2 + 1;
        }
        while(la < ra && lb < rb) {
            int midA = (la + ra) / 2;
            int midB = (lb + rb) / 2;
            if(midA + midB + 2 > mid) {
                if(arrayA[midA] < arrayB[midB]) {
                    rb = midB - 1;
                } else {
                    ra = midA - 1;
                }
            } else  if(midA + midB + 2 < mid){
                if(arrayA[midA] < arrayB[midB]) {
                    la = midA + 1;
                } else {
                    lb = midB + 1;
                }
            } else {
                return Math.max(arrayA[midA] , arrayB[midB]);
            }
        }
        return 0;
    }

}
