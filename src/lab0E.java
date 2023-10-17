import java.util.Scanner;

public class lab0E{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][3];
        int[][] b = new int[n][2];
        for(int i = 0;i<n;i++){
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
            a[i][2] = in.nextInt();
            b[i][0] = 2*a[i][1]+2*a[i][0]+1;
            b[i][1] = 2*a[i][1]+2*a[i][2]+1;
        }
        String[] s = {".","+","-","/","|"};
        for(int i = 0;i<n;i++){
            int[][] c = new int[b[i][1]][b[i][0]];
            int j=0;
            int t1 = 2*a[i][1];
            while(j<t1){
                for(int k = t1-j;k<b[i][0];k++){
                    if(k%2==0)
                        c[j][k]=2;
                    else
                        c[j][k]=3;
                }
                j+=2;
            }
            while(j<b[i][1]-2*a[i][1]){
                for(int k = 0;k <b[i][0];k++){
                    if(k%2==0)
                        c[j][k]=2;
                    else
                        c[j][k]=3;
                }
                j+=2;
            }
            int p = 2;
            while(j<b[i][1]){
                for(int k = b[i][0]-1-p;k>=0;k--){
                    if(k%2==0)
                        c[j][k]=2;
                    else
                        c[j][k]=3;
                }
                j+=2;
                p+=2;
            }
            j=1;
            while(j<t1){
                for(int k = t1-j;k<b[i][0];k++){
                    if(k%2==1)
                        c[j][k]=4;
                }
                j+=2;
            }
            j=2*a[i][1]+1;
            while(j<b[i][1]){
                for(int k = 0;k<2*a[i][0]+2;k++){
                    if(k%2==0)
                        c[j][k]=5;
                }
                j+=2;
            }
            int k = 2*a[i][0]+1;
            int l = 2*a[i][1]+1;
            int count;
            int count1 = 0;
            while(k<b[i][0]){
                count = 0;
                for(;l<b[i][1];l+=2){
                    if(count<a[i][2]){
                        c[l][k]=4;
                    }
                    count++;
                }
                count1++;
                l = 2*a[i][1]+1;
                k+=2;
                l-=2*count1;
            }
            int k1 = 2*a[i][0]+2;
            int l1 = 2*a[i][1]-1;
            int count10;
            int count11 = 0;
            while(k1<b[i][0]){
                count10= 0;
                for(;l1<b[i][1];l1+=2){
                    if(count10<a[i][2]){
                        c[l1][k1]=5;
                    }
                    count10++;
                }
                count11++;
                l1 = 2*a[i][1]-1;
                k1+=2;
                l1-=2*count11;
            }
            int k2 = 2*a[i][0]+1;
            int l2 = 2*a[i][1];
            int count20;
            int count21 = 0;
            while(k2<b[i][0]){
                count20= 0;
                for(;l2<b[i][1];l2+=2){
                    if(count20<a[i][2]){
                        c[l2][k2]=0;
                    }
                    count20++;
                }
                count21++;
                l2 = 2*a[i][1];
                k2+=2;
                l2-=2*count21;
            }
            for(int g = b[i][1]-1;g>2*a[i][2]+1;g--){
                for(int d = b[i][0]-1;g+d>=2*(a[i][0]+a[i][1]+a[i][2])+1;d--){
                    c[g][d]=0;
                }
            }

            for(int e = 0;e<b[i][1];e++){
                for(int f = 0;f<b[i][0];f++){
                    if(c[e][f]==2)
                        System.out.print("+");
                    else if(c[e][f]==3)
                        System.out.print("-");
                    else if(c[e][f]==4)
                        System.out.print("/");
                    else if(c[e][f]==5)
                        System.out.print("|");
                    else
                        System.out.print(".");
                }
                System.out.println();
            }
        }
    }
}
