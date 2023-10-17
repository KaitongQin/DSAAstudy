import java.util.Scanner;

public class lab0C{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[][] s = new String[n][34];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<13;j++){
                s[i][j] = in.next();
            }
        }
        String a = "";
        int[][] sn = new int[n][34];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<13;j++){
                a = s[i][j];
                if(a.equals("W1")){
                    sn[i][0]++;
                }else if(a.equals("W2")){
                    sn[i][1]++;
                }else if(a.equals("W3")){
                    sn[i][2]++;
                }else if(a.equals("W4")){
                    sn[i][3]++;
                }else if(a.equals("W5")){
                    sn[i][4]++;
                }else if(a.equals("W6")){
                    sn[i][5]++;
                }else if(a.equals("W7")){
                    sn[i][6]++;
                }else if(a.equals("W8")){
                    sn[i][7]++;
                }else if(a.equals("W9")){
                    sn[i][8]++;
                }else if(a.equals("T1")){
                    sn[i][9]++;
                }else if(a.equals("T2")){
                    sn[i][10]++;
                }else if(a.equals("T3")){
                    sn[i][11]++;
                }else if(a.equals("T4")){
                    sn[i][12]++;
                }else if(a.equals("T5")){
                    sn[i][13]++;
                }else if(a.equals("T6")){
                    sn[i][14]++;
                }else if(a.equals("T7")){
                    sn[i][15]++;
                }else if(a.equals("T8")){
                    sn[i][16]++;
                }else if(a.equals("T9")){
                    sn[i][17]++;
                }else if(a.equals("Y1")){
                    sn[i][18]++;
                }else if(a.equals("Y2")){
                    sn[i][19]++;
                }else if(a.equals("Y3")){
                    sn[i][20]++;
                }else if(a.equals("Y4")){
                    sn[i][21]++;
                }else if(a.equals("Y5")){
                    sn[i][22]++;
                }else if(a.equals("Y6")){
                    sn[i][23]++;
                }else if(a.equals("Y7")){
                    sn[i][24]++;
                }else if(a.equals("Y8")){
                    sn[i][25]++;
                }else if(a.equals("Y9")){
                    sn[i][26]++;
                }else if(a.equals("E")){
                    sn[i][27]++;
                }else if(a.equals("S")){
                    sn[i][28]++;
                }else if(a.equals("W")){
                    sn[i][29]++;
                }else if(a.equals("N")){
                    sn[i][30]++;
                }else if(a.equals("B")){
                    sn[i][31]++;
                }else if(a.equals("F")){
                    sn[i][32]++;
                }else if(a.equals("Z")){
                    sn[i][33]++;
                }
            }

        }
        String[] sp ={"W1","W2","W3","W4","W5","W6","W7","W8","W9","T1","T2","T3","T4","T5","T6","T7","T8","T9","Y1","Y2","Y3","Y4","Y5","Y6","Y7","Y8","Y9","E","S","W","N","B","F","Z"};
        for(int i = 0;i<n;i++){
            for(int j = 0;j<34;j++){
                if(sn[i][j]!=0){
                    for(int k = 0;k<sn[i][j];k++){
                        System.out.print(sp[j]+" ");
                    }
                }
            }
            if(i!=n-1){
                System.out.println();
            }
        }
    }
}
