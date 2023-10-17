import java.util.Scanner;

public class lab0F_1{
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
            int findThree=0;
            for(int j = 0;j<9;j++){
                if(W[i][j]>=2){
                    W[i][j]-=2;
                    int c = findKeZi(W[i],findThree);
                    if(TianHu(c)){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    int d = findKeZi(B[i],c);
                    if(TianHu(d)){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    int e = findKeZi(S[i],d);
                    if(TianHu(e)){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    int f = findZi(Z[i],e);
                    if(TianHu(f)){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    W[i][j]+=2;
                }
            }
            for(int j = 0;j<9;j++){
                if(B[i][j]>=2){
                    B[i][j]-=2;
                    int c = findKeZi(W[i],findThree);
                    if(TianHu(c)){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    int d = findKeZi(B[i],c);
                    if(TianHu(d)){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    int e = findKeZi(S[i],d);
                    if(TianHu(e)){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    int f = findZi(Z[i],e);
                    if(TianHu(f)){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    B[i][j]+=2;
                }
            }
            for(int j = 0;j<9;j++){
                if(S[i][j]>=2){
                    S[i][j]-=2;
                    int c = findKeZi(W[i],findThree);
                    if(TianHu(c)){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    int d = findKeZi(B[i],c);
                    if(TianHu(d)){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    int e = findKeZi(S[i],d);
                    if(TianHu(e)){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    int f = findZi(Z[i],e);
                    if(TianHu(f)){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    S[i][j]+=2;
                }
            }
            for(int j = 0;j<7;j++){
                if(Z[i][j]>=2){
                    Z[i][j]-=2;
                    int c = findKeZi(W[i],findThree);
                    if(TianHu(c)){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    int d = findKeZi(B[i],c);
                    if(TianHu(d)){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    int e = findKeZi(S[i],d);
                    if(TianHu(e)){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    int f = findZi(Z[i],e);
                    if(TianHu(f)){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }
                    Z[i][j]+=2;
                }
            }
            System.out.println("Bad luck");
        }

    }

    public static int findKeZi(int[] a,int findThree){
        int count=0;
        for(int i = 0;i<9;i++){
            if(a[i]>0){
                a[i]-=1;
                count++;
               if(count==3){
                   findThree++;
                   if(!TianHu(findThree)){
                       findKeZi(a,findThree);
                   }else{
                       System.out.println("Blessing of Heaven");
                   }
                   a[i]+=1;
                   a[i-1]+=1;
                   a[i-2]+=1;
               }
            }else if(a[i]==0){
                count=0;
            }
            if(a[i]>=3){
                findThree++;
                a[i]-=3;
                if(!TianHu(findThree)){
                    findKeZi(a,findThree);
                }
                a[i]+=3;
            }
        }
        return findThree;
    }
    public static int findZi(int[] a, int findThree){
        for(int i = 0;i<7;i++){
            if(a[i]>=3){
                findThree++;
            }
        }
        return findThree;
    }
    public static boolean TianHu(int findThree){
        if(findThree==4){
            return true;
        }
        return false;
    }
}
