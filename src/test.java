public class test{
    public static void main(String[] args){
        int[][] c = new int[2][4];
        c[0][0]=1;
        c[1][0]=2;
        for(int i = 0;i<2;i++){
            for(int j = 0;j<4;j++){
                System.out.print(c[i][j]);
            }
            System.out.println();
        }
    }
}
