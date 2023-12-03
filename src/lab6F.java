import java.util.ArrayList;
import java.util.Scanner;

public class lab6F{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        node[] nodes = new node[n + 1];
        for(int i = 1; i <= n; i++){
            nodes[i] = new node();
            nodes[i].index = i;
        }
        for(int i = 0; i < n - 1; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            nodes[u].son.add(nodes[v]);
            nodes[v].son.add(nodes[u]);
        }
        int max = 1;
        for(int i = 1; i <= n; i++){
            nodes[i].p = in.nextInt();
            if (nodes[i].p > nodes[max].p) {
                max = i;
            }
        }
        dfs(nodes[max]);
        for(int i = 1; i <= n; i++){
            nodes[i].visited = false;
        }
        nodes[max].visited = true;
        ArrayList<Integer> ans = new ArrayList <>();
        long answer = 0;
        for(int c = 0; c < nodes[max].son.size(); c++){
            Queue queue = new Queue(n + 1);
            nodes[max].son.get(c).visited = true;
            queue.enQueue(nodes[max].son.get(c).index);
            ArrayList <node> leaves = new ArrayList <>();
            while (! queue.isEmpty()) {
                int head = queue.getTop();
                nodes[head].visited = true;
                int pHead = nodes[head].p;
                ArrayList <node> sonNode = new ArrayList <>();
                for(int i = 0; i < nodes[head].son.size(); i++){
                    if (nodes[head].son.get(i).visited) continue;
                    int index = nodes[head].son.get(i).index;
                    queue.enQueue(index);
                    sonNode.add(nodes[head].son.get(i));
                }
                if (! sonNode.isEmpty()) {
                    int maxi = sonNode.get(0).index;
                    for(lab6F.node node : sonNode){
                        if (node.p >= nodes[maxi].p) {
                            maxi = node.index;
                        }
                    }
                    nodes[maxi].p = pHead;
                } else {
                    leaves.add(nodes[head]);
                    answer += nodes[head].p;
                }
                queue.deQueue();
            }
            int maxP = leaves.get(0).index;
            for(node leaf : leaves){
                if (leaf.p > nodes[maxP].p) {
                    maxP = leaf.index;
                }
            }
            ans.add(maxP);
        }
        int[] a = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            a[i] = nodes[ans.get(i)].p;
        }
        mergeSort(a);
        if(nodes[max].son.size() == 1) {
            answer = answer + nodes[max].p * 2L - a[a.length - 1];
        } else {
            answer = answer + nodes[max].p * 2L - a[a.length - 1] - a[a.length - 2];
        }
        System.out.println(answer);
    }
    public static void dfs(node head) {
        head.visited = true;
        for(int i = 0; i < head.son.size(); i++) {
            if(head.son.get(i).visited) continue;
            dfs(head.son.get(i));
            if(head.son.get(i).p > head.p) {
                head.p = head.son.get(i).p;
            }
        }
    }

    public static void mergeSort(int[] array) {
        int[] tmp = new int[array.length];
        merge(array, tmp, 0, array.length - 1);
    }

    public static void merge(int[] array, int[] tmp, int l, int r) {
        if(l >= r) {
            return;
        }
        int mid = (r + l) / 2;
        merge(array, tmp, l, mid);
        merge(array, tmp, mid + 1, r);
        merge_sort(array, tmp, l, mid, r);
    }

    public static void merge_sort(int[] array, int[] tmp, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int k = l;
        while(i <= mid && j <= r) {
            if(array[i] <= array[j]) {
                tmp[k] = array[i];
                k++;
                i++;
            } else {
                tmp[k] = array[j];
                k++;
                j++;
            }
        }
        while(i <= mid) {
            tmp[k] = array[i];
            k++;
            i++;
        }
        while(j <= r) {
            tmp[k] = array[j];
            k++;
            j++;
        }
        while(l <= r) {
            array[l] = tmp[l];
            l++;
        }
    }

    private static class node{
        int index;
        int p;
        boolean visited;
        ArrayList<node> son = new ArrayList <>();
    }

    static class Queue{
        int[] array;
        int front;
        int rear;
        public Queue(int n) {
            array = new int[n];
            front = -1;
            rear = -1;
        }
        public void enQueue(int value) {
            rear++;
            array[rear] = value;
        }
        public void deQueue() {
            front++;
        }
        public int getTop() {
            int tmp = front + 1;
            return array[tmp];
        }
        public boolean isEmpty() {
            return rear == front;
        }
    }
}
