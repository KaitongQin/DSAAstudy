import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab9E{
    static class node{
        int value;
        ArrayList<node> sons;
        ArrayList<node> revSons;
        boolean inStack = false;
        boolean revInStack = false;
        int fa;
        public node(int value) {
            this.value = value;
            this.sons = new ArrayList <>();
            this.revSons = new ArrayList <>();
        }
    }
    static class edge{
        int u;
        int v;
        public edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
    public static void main(String[] args){
        QReader in = new QReader();
        int n = in.nextInt();
        int m = in.nextInt();
        int S = in.nextInt();
        node[] nodes = new node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new node(i);
        }
        edge[] edges = new edge[m];
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            nodes[u].sons.add(nodes[v]);
            nodes[v].revSons.add(nodes[u]);
            edges[i] = new edge(u, v);
        }
        ArrayList<Integer> visit = new ArrayList <>();
        for (int i = 1; i <= n; i++) {
            if (!nodes[i].inStack) {
                dfs(nodes[i], visit);
            }
        }
        ArrayList<ArrayList<Integer>> point = new ArrayList<>();
        for (int i = visit.size() - 1; i >= 0; i--) {
            if (!nodes[visit.get(i)].revInStack) {
                ArrayList<Integer> tmp = new ArrayList <>();
                dfsRev(nodes[visit.get(i)], tmp);
                point.add(tmp);
            }
        }
        for (int i = 0; i < point.size(); i++) {
            for (int j = 0; j < point.get(i).size(); j++) {
                nodes[point.get(i).get(j)].fa = i;
            }
        }
        boolean[] indegree = new boolean[point.size()];
        for (int i = 0; i < m; i++) {
            int u = edges[i].u;
            int v = edges[i].v;
            if (nodes[u].fa != nodes[v].fa) {
                indegree[nodes[v].fa] = true;
            }
        }
        int ans = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (!indegree[i]) {
                ans++;
            }
        }
        if (!indegree[nodes[S].fa]) {
            System.out.println(ans - 1);
        } else {
            System.out.println(ans);
        }
//        int ans = 0;
//        for (int i = 0; i < booleans.length; i++) {
//            if (!booleans[i]) {
//                ans++;
//            }
//        }
//        System.out.println(ans);
//        for(int i = 0; i< point.size();i++){
//            for (int j = 0; j < point.get(i).size(); j++) {
//                System.out.println(point.get(i).get(j) + ": " + (nodes[point.get(i).get(j)].fa));
//            }
//        }
    }

    public static void dfs(node node, ArrayList<Integer> visit) {
        node.inStack = true;
        for (int i = 0; i < node.sons.size(); i++) {
            if (!node.sons.get(i).inStack) {
                dfs(node.sons.get(i), visit);
            }
        }
        visit.add(node.value);
    }
    public static void dfsRev(node node, ArrayList<Integer> tmp) {
        node.revInStack = true;
        tmp.add(node.value);
        for (int i = 0; i < node.revSons.size(); i++) {
            if (!node.revSons.get(i).revInStack) {
                dfsRev(node.revSons.get(i), tmp);
            }
        }
    }
    private static class QReader{
        private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokenizer = new StringTokenizer("");

        private String innerNextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String nextLine = innerNextLine();
                if (nextLine == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(nextLine);
            }
            return true;
        }

        public String nextLine() {
            tokenizer = new StringTokenizer("");
            return innerNextLine();
        }

        public String next() {
            hasNext();
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
