import java.util.Scanner;

public class lab1_6_2{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[][] s = new String[n][14];
        int[][] W = new int[n][9];
        int[][] B = new int[n][9];
        int[][] S = new int[n][9];
        int[][] Z = new int[n][7];
        for(int i = 0;i<n;i++){
            String s1 = in.next();
            for(int j = 0;j<14;j++){
                s[i][j]=s1.substring(2*j,2*j+2);
                if(s[i][j].charAt(1)=='w')
                    W[i][Integer.parseInt(String.valueOf(s[i][j].charAt(0)))-1]++;
                else if(s[i][j].charAt(1)=='b')
                    B[i][Integer.parseInt(String.valueOf(s[i][j].charAt(0)))-1]++;
                else if(s[i][j].charAt(1)=='s')
                    S[i][Integer.parseInt(String.valueOf(s[i][j].charAt(0)))-1]++;
                else if(s[i][j].charAt(1)=='z')
                    Z[i][Integer.parseInt(String.valueOf(s[i][j].charAt(0)))-1]++;
            }
        }

        label:
        for(int i = 0;i<n;i++){
            for(int j = 0;j<9;j++){
                if (W[i][j] >= 2) {
                    W[i][j] -= 2;
                    int c = ExamTianhu1(W[i],B[i],S[i],Z[i]);
                    if (c == 4) {
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    int d = ExamTianhu2(W[i],B[i],S[i],Z[i]);
                    if (d == 4) {
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    if(W[i][j]>=3){
                        W[i][j]-=3;
                        int e = ExamTianhu2(W[i],B[i],S[i],Z[i]);
                        if(e==3){
                            System.out.println("Blessing of Heaven");
                            continue label;
                        }
                        W[i][j]+=3;
                    }
                    W[i][j] += 2;
                }
            }

            for(int j = 0;j<9;j++){
                if (B[i][j] >= 2) {
                    B[i][j] -= 2;
                    int c = ExamTianhu1(W[i],B[i],S[i],Z[i]);
                    if (c == 4) {
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    int d = ExamTianhu2(W[i],B[i],S[i],Z[i]);
                    if (d == 4) {
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    if(B[i][j]>=3){
                        B[i][j]-=3;
                        int e = ExamTianhu2(W[i],B[i],S[i],Z[i]);
                        if(e==3){
                            System.out.println("Blessing of Heaven");
                            continue label;
                        }
                        B[i][j]+=3;
                    }
                    B[i][j] += 2;
                }
            }

            for(int j = 0;j<9;j++){
                if (S[i][j] >= 2) {
                    S[i][j] -= 2;
                    int c = ExamTianhu1(W[i],B[i],S[i],Z[i]);
                    if (c == 4) {
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    int d = ExamTianhu2(W[i],B[i],S[i],Z[i]);
                    if (d == 4) {
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    if(S[i][j]>=3){
                        S[i][j]-=3;
                        int e = ExamTianhu2(W[i],B[i],S[i],Z[i]);
                        if(e==3){
                            System.out.println("Blessing of Heaven");
                            continue label;
                        }
                        S[i][j]+=3;
                    }
                    S[i][j] += 2;
                }
            }
            for(int j = 0;j<7;j++){
                if (Z[i][j] >= 2) {
                    Z[i][j] -= 2;
                    int c = ExamTianhu1(W[i],B[i],S[i],Z[i]);

                    if (c == 4) {
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    int d = ExamTianhu2(W[i],B[i],S[i],Z[i]);
                    if (d == 4) {
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    if(Z[i][j]>=3){
                        Z[i][j]-=3;
                        int e = ExamTianhu2(W[i],B[i],S[i],Z[i]);
                        if(e==3){
                            System.out.println("Blessing of Heaven");
                            continue label;
                        }
                        Z[i][j]+=3;
                    }
                    Z[i][j] += 2;
                }
            }
            System.out.println("Bad luck");
        }
    }
    public static int findShunzi(int[] a,int findshunzi){
        for(int i = 0;i<=a.length-3;i++){
            if(a[i]>0&&a[i+1]>0&&a[i+2]>0){
                findshunzi++;
                a[i]-=1;a[i+1]-=1;a[i+2]-=1;
                return findShunzi(a,findshunzi);
            }
        }
        return findshunzi;
    }
    public static int findKezi(int[] a,int findkezi){
        for(int i = 0;i<a.length;i++){
            if(a[i]>=3){
                findkezi++;
                a[i]-=3;
                return findKezi(a,findkezi);
            }
        }
        return findkezi;
    }
    public static int[] copyArray(int[] a){
        int[] b = new int[a.length];
        System.arraycopy(a , 0 , b , 0 , a.length);
        return b;
    }
    public static int ExamTianhu1(int[] W,int[] B,int[] S,int[] Z){
        int findkezi = 0;
        int findshunzi = 0;
        int[] w1 = copyArray(W);
        int d = findKezi(w1 , findkezi);
        int c = findShunzi(w1 , findshunzi);
        int[] b1 = copyArray(B);
        int f = findKezi(b1 , d);
        int e = findShunzi(b1 , c);
        int[] s1 = copyArray(S);
        int m = findKezi(s1 , f);
        int l = findShunzi(s1 , e);
        int[] z1 = copyArray(Z);
        int k = findKezi(z1 , m);
        return l+k;
    }
    public static int ExamTianhu2(int[] W,int[] B,int[] S,int[] Z){
        int findshunzi = 0;
        int findkezi = 0;
        int[] w1 = copyArray(W);
        int c = findShunzi(w1 , findshunzi);
        int d = findKezi(w1 , findkezi);
        int[] b1 = copyArray(B);
        int f = findShunzi(b1 , c);
        int h = findKezi(b1 , d);
        int[] s1 = copyArray(S);
        int m = findShunzi(s1 , f);
        int o = findKezi(s1 , h);
        int[] z1 = copyArray(Z);
        int k = findKezi(z1 , o);
        return m+k;
    }
}