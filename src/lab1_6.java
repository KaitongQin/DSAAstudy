import java.util.Scanner;

public class lab1_6{
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
            int findThree = 0;
            int count = 0;
            for(int j = 0;j<9;j++){
                if(W[i][j]>=2){
                    W[i][j]-=2;
                    for(int k = 0;k<9;k++){
                        if(W[i][k]==1){
                            count++;
                            if(count==3){
                                findThree++;
                                count=0;
                            }
                        }else if(W[i][k]==3){
                            findThree++;
                        }else if(W[i][k]==2){
                            count++;
                            if(count==3){
                                findThree++;
                                if(k>1&&W[i][k-1]==2){
                                    count=2;
                                }else{
                                    count=1;
                                }
                            }
                        }else if(W[i][k]==0){
                            count = 0;
                        }
                    }

                    count=0;
                    for(int k = 0;k<9;k++){
                        if(B[i][k]==1){
                            count++;
                            if(count==3){
                                findThree++;
                                count=0;
                            }
                        }else if(B[i][k]==3){
                            findThree++;
                        }else if(B[i][k]==2){
                            count++;
                            if(count==3){
                                findThree++;
                                if(k>1&&B[i][k-1]==2){
                                    count=2;
                                }else{
                                    count=1;
                                }
                            }
                        }
                        if(B[i][k]==0){
                            count = 0;
                        }
                    }
                    count=0;
                    for(int k = 0;k<9;k++){
                        if(S[i][k]==1){
                            count++;
                            if(count==3){
                                findThree++;
                                count=0;
                            }
                        }else if(S[i][k]==3){
                            findThree++;
                        }else if(S[i][k]==2){
                            count++;
                            if(count==3){
                                findThree++;
                                if(k>1&&S[i][k-1]==2){
                                    count=2;
                                }else{
                                    count=1;
                                }
                            }
                        }
                        if(S[i][k]==0){
                            count = 0;
                        }
                    }
                    count=0;
                    for(int k = 0;k<7;k++){
                        if(Z[i][k]==1){
                            count++;
                            if(count==3){
                                findThree++;
                                count=0;
                            }
                        }else if(Z[i][k]==3){
                            findThree++;
                        }else if(Z[i][k]==2){
                            count++;
                            if(count==3){
                                findThree++;
                                if(k>1&&Z[i][k-1]==2){
                                    count=2;
                                }else{
                                    count=1;
                                }
                            }
                        }
                        if(Z[i][k]==0){
                            count = 0;
                        }
                    }
                    count=0;
                    if(findThree == 4){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }else{
                        W[i][j]+=2;
                        findThree=0;
                    }
                }

            }
            for(int j = 0;j<9;j++){
                boolean sp=false;
                if(B[i][j]>=2){
                    B[i][j]-=2;
                    for(int k = 0;k<9;k++){
                        if(W[i][k]==1){
                            count++;
                            if(count==3){
                                findThree++;
                                count=0;
                            }
                        }else if(W[i][k]==3){
                            findThree++;
                        }else if(W[i][k]==2){
                            count++;
                            if(count==3){
                                findThree++;
                                if(k>1&&W[i][k-1]==2){
                                    count=2;
                                }else{
                                    count=1;
                                }
                            }
                        }
                        if(W[i][k]==0){
                            count = 0;
                        }
                    }
                    count = 0;
                    for(int k = 0;k<9;k++){
                        if(B[i][k]==1){
                            count++;
                            if(count==3){
                                findThree++;
                                count=0;
                            }
                        }else if(B[i][k]==3){
                            findThree++;
                        }else if(B[i][k]==2){
                            count++;
                            if(count==3){
                                findThree++;
                                if(k>1&&B[i][k-1]==2){
                                    count=2;
                                }else{
                                    count=1;
                                }
                            }
                        }
                        if(B[i][k]==0){
                            count = 0;
                        }
                    }
                    count = 0;
                    for(int k = 0;k<9;k++){
                        if(S[i][k]==1){
                            count++;
                            if(count==3){
                                findThree++;
                                count=0;
                            }
                        }else if(S[i][k]==3){
                            findThree++;
                        }else if(S[i][k]==2){
                            count++;
                            if(count==3){
                                findThree++;
                                if(k>1&&S[i][k-1]==2){
                                    count=2;
                                }else{
                                    count=1;
                                }
                            }
                        }
                        if(S[i][k]==0){
                            count = 0;
                        }
                    }
                    count=0;
                    for(int k = 0;k<7;k++){
                        if(Z[i][k]==1){
                            count++;
                            if(count==3){
                                findThree++;
                                count=0;
                            }
                        }else if(Z[i][k]==3){
                            findThree++;
                        }else if(Z[i][k]==2){
                            count++;
                            if(count==3){
                                findThree++;
                                if(k>1&&Z[i][k-1]==2){
                                    count=2;
                                }else{
                                    count=1;
                                }
                            }
                        }
                        if(Z[i][k]==0){
                            count = 0;
                        }
                    }
                    count=0;
                    if(findThree == 4){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }else{
                        B[i][j]+=2;
                        findThree=0;
                    }
                }

            }
            for(int j = 0;j<9;j++){
                if(S[i][j]>=2){
                    S[i][j]-=2;
                    for(int k = 0;k<9;k++){
                        if(W[i][k]==1){
                            count++;
                            if(count==3){
                                findThree++;
                                count=0;
                            }
                        }else if(W[i][k]==3){
                            findThree++;
                        }else if(W[i][k]==2){
                            count++;
                            if(count==3){
                                findThree++;
                                if(k>1&&W[i][k-1]==2){
                                    count=2;
                                }else{
                                    count=1;
                                }
                            }
                        }
                        if(W[i][k]==0){
                            count = 0;
                        }
                    }
                    count = 0;
                    for(int k = 0;k<9;k++){
                        if(B[i][k]==1){
                            count++;
                            if(count==3){
                                findThree++;
                                count=0;
                            }
                        }else if(B[i][k]==3){
                            findThree++;
                        }else if(B[i][k]==2){
                            count++;
                            if(count==3){
                                findThree++;
                                if(k>1&&B[i][k-1]==2){
                                    count=2;
                                }else{
                                    count=1;
                                }
                            }
                        }
                        if(B[i][k]==0){
                            count = 0;
                        }
                    }
                    count = 0;
                    for(int k = 0;k<9;k++){
                        if(S[i][k]==1){
                            count++;
                            if(count==3){
                                findThree++;
                                count=0;
                            }
                        }else if(S[i][k]==3){
                            findThree++;
                        }else if(S[i][k]==2){
                            count++;
                            if(count==3){
                                findThree++;
                                if(k>1&&S[i][k-1]==2){
                                    count=2;
                                }else{
                                    count=1;
                                }
                            }
                        }
                        if(S[i][k]==0){
                            count = 0;
                        }
                    }
                    count=0;
                    for(int k = 0;k<7;k++){
                        if(Z[i][k]==1){
                            count++;
                            if(count==3){
                                findThree++;
                                count=0;
                            }
                        }else if(Z[i][k]==3){
                            findThree++;
                        }else if(Z[i][k]==2){
                            count++;
                            if(count==3){
                                findThree++;
                                if(k>1&&Z[i][k-1]==2){
                                    count=2;
                                }else{
                                    count=1;
                                }
                            }
                        }
                        if(Z[i][k]==0){
                            count = 0;
                        }
                    }
                    count=0;
                    if(findThree == 4){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }else{
                        S[i][j]+=2;
                        findThree=0;
                    }
                }

            }
            for(int j = 0;j<7;j++){
                if(Z[i][j]>=2){
                    Z[i][j]-=2;
                    for(int k = 0;k<9;k++){
                        if(W[i][k]==1){
                            count++;
                            if(count==3){
                                findThree++;
                                count=0;
                            }
                        }else if(W[i][k]==3){
                            findThree++;
                        }else if(W[i][k]==2){
                            count++;
                            if(count==3){
                                findThree++;
                                if(k>1&&W[i][k-1]==2){
                                    count=2;
                                }else{
                                    count=1;
                                }

                            }
                        }
                        if(W[i][k]==0){
                            count = 0;
                        }
                    }
                    count=0;
                    for(int k = 0;k<9;k++){
                        if(B[i][k]==1){
                            count++;
                            if(count==3){
                                findThree++;
                                count=0;
                            }
                        }else if(B[i][k]==3){
                            findThree++;
                        }else if(B[i][k]==2){
                            count++;
                            if(count==3){
                                findThree++;
                                if(k>1&&B[i][k-1]==2){
                                    count=2;
                                }else{
                                    count=1;
                                }
                            }
                        }
                        if(B[i][k]==0){
                            count = 0;
                        }
                    }
                    count=0;
                    for(int k = 0;k<9;k++){
                        if(S[i][k]==1){
                            count++;
                            if(count==3){
                                findThree++;
                                count=0;
                            }
                        }else if(S[i][k]==3){
                            findThree++;
                        }else if(S[i][k]==2){
                            count++;
                            if(count==3){
                                findThree++;
                                if(k>1&&S[i][k-1]==2){
                                    count=2;
                                }else{
                                    count=1;
                                }
                            }
                        }
                        if(S[i][k]==0){
                            count = 0;
                        }
                    }
                    count=0;
                    for(int k = 0;k<7;k++){
                        if(Z[i][k]==1){
                            count++;
                            if(count==3){
                                findThree++;
                                count=0;
                            }
                        }else if(Z[i][k]==3){
                            findThree++;
                        }else if(Z[i][k]==2){
                            count++;
                            if(count==3){
                                findThree++;
                                if(k>1&&Z[i][k-1]==2){
                                    count=2;
                                }else {
                                    count=1;
                                }

                            }
                        }
                        if(Z[i][k]==0){
                            count = 0;
                        }
                    }
                    count=0;
                    if(findThree == 4){
                        System.out.println("Blessing of Heaven");
                        continue label;
                    }else{
                        Z[i][j]+=2;
                        findThree=0;
                    }
                }

            }
            System.out.println("Bad luck");
        }



    }
}

