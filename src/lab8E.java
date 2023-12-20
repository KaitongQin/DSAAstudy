import java.util.ArrayList;
import java.util.Scanner;

public class lab8E{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int c = 0; c < T; c++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] array = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    array[i][j] = in.nextInt();
                }
            }
            int up = 1;
            for (int i = 1; i <= m; i++) {
                up *= 2;
            }
            ArrayList<String> state = new ArrayList<>();
            for (int i = 0; i < up; i++) {
                if ((i & (i << 1)) == 0) {
                    state.add(String.format("%" + m + "s", Integer.toBinaryString(i)).replace(' ', '0'));
                }
            }
            long[][] ans = new long[n][state.size()];
            for (int i = 0; i < state.size(); i++) {
                for (int j = 0; j < m; j++) {
                    if (state.get(i).charAt(j) == '1') {
                        ans[0][i] += array[0][j];
                    }
                }
            }
            long tmp = 0;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < state.size(); j++) {
                    tmp = 0;
                    for (int k = 0; k < m; k++) {
                        if (state.get(j).charAt(k) == '1') {
                            tmp += array[i][k];
                        }
                    }
                    label:
                    for (int k = 0; k < state.size(); k++) {
                        String curr = state.get(j);
                        String last = state.get(k);
                        for (int l = 0; l < m; l++) {
                            if (l == 0) {
                                if (curr.charAt(l) == '1' && (last.charAt(l + 1) == '1' || last.charAt(l) == '1')) {
                                    continue label;
                                }
                            } else if (l == m - 1) {
                                if (curr.charAt(l) == '1' && (last.charAt(l - 1) == '1' || last.charAt(l) == '1')) {
                                    continue label;
                                }
                            } else {
                                if (m > 2) {
                                    if (curr.charAt(l) == '1' && (last.charAt(l - 1) == '1' || last.charAt(l) == '1' || last.charAt(l + 1) == '1')) {
                                        continue label;
                                    }
                                }
                            }
                        }
                        ans[i][j] = Math.max(ans[i - 1][k] + tmp, ans[i][j]);
                    }
                }
            }
            long answer = 0;
            for (int i = 0; i < state.size(); i++) {
                answer = Math.max(ans[n - 1][i], answer);
            }
            System.out.println(answer);
        }
    }
}
