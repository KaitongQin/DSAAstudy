import java.util.Scanner;

public class lab7D{
    private static class node{
        long value;
        int index;
        node next;
        node prev;
        boolean deleted;
        public node (long value) {
            this.value = value;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        node[] heap = new node[n + 1];
        node head = new node(0);
        node curr = head;
        for (int i = 1; i <= n; i++) {
            long value = in.nextLong();
            curr.next = new node(value);
            curr.next.prev = curr;
            curr.next.index = i;
            curr = curr.next;
        }
        curr = head.next;
        heap[0] = new node(0);
        for (int i = 1; i <= n; i++) {
            enHeap(heap, curr);
            heap[0].value ++;
            curr = curr.next;
        }
        for (int i = 1; i <= n - 1; i++) {
            node tmp;
            do {
                tmp = deHeap(heap);
                heap[0].value--;
            } while (tmp.deleted);
            if (tmp.next == null) {
                long tmp1 = (tmp.value ^ tmp.prev.value) + 1;
                tmp.prev.deleted = true;
                node newNode = new node(tmp1);
                newNode.index = tmp.index;
                newNode.prev = tmp.prev.prev;
                tmp.prev.prev.next = newNode;
                enHeap(heap, newNode);
                heap[0].value ++;
                continue;
            }
            if (tmp.prev == head) {
                long tmp1 = (tmp.value ^ tmp.next.value) + 1;
                tmp.next.deleted = true;
                node newNode = new node(tmp1);
                newNode.index = tmp.index;
                newNode.prev = head;
                head.next = newNode;
                if (tmp.next.next == null) {
                    newNode.next = null;
                } else {
                    tmp.next.next.prev = newNode;
                    newNode.next = tmp.next.next;
                }
                enHeap(heap, newNode);
                heap[0].value ++;
                continue;
            }
            long tmp1 = (tmp.next.value ^ tmp.value) + 1;
            long tmp2 = (tmp.value ^ tmp.prev.value) + 1;
            if (tmp1 > tmp2) {
                tmp.next.deleted = true;
                node a = tmp.prev;
                a.next = tmp.next;
                tmp.next.prev = a;
                node newNode = new node(tmp1);
                newNode.index = tmp.index;
                a.next = newNode;
                newNode.prev = a;
                if (tmp.next.next == null) {
                    newNode.next = null;
                } else {
                    newNode.next = tmp.next.next;
                    tmp.next.next.prev = newNode;
                }
                enHeap(heap, newNode);
                heap[0].value ++;
            } else {
                tmp.prev.deleted = true;
                node a = tmp.next;
                tmp.prev.next = a;
                a.prev = tmp.prev;
                node newNode = new node(tmp2);
                newNode.index = tmp.index;
                newNode.next = a;
                a.prev = newNode;
                newNode.prev = tmp.prev.prev;
                tmp.prev.prev.next = newNode;
                enHeap(heap, newNode);
                heap[0].value ++;
            }
        }
        curr = head.next;
        System.out.println(curr.value);
    }
    private static void enHeap(node[] heap, node curr) {
        int k = (int) heap[0].value + 1;
        heap[k] = curr;
        while (k > 1) {
            if (heap[k].value < heap[k / 2].value) {
                node tmp = heap[k];
                heap[k] = heap[k / 2];
                heap[k / 2] = tmp;
                k /= 2;
            } else if (heap[k].value == heap[k / 2].value) {
                if (heap[k].index < heap[k / 2].index) {
                    node tmp = heap[k];
                    heap[k] = heap[k / 2];
                    heap[k / 2] = tmp;
                    k /= 2;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }
    private static node deHeap(node[] heap) {
        node tmp = heap[1];
        heap[1] = heap[(int) heap[0].value];
        heap[(int) heap[0].value] = null;
        int i = 1;
        while (i * 2 < (int) heap[0].value) {
            if (i * 2 == (int) heap[0].value - 1) {
                if (heap[i].value > heap[i * 2].value
                        || (heap[i].value == heap[i * 2].value && heap[i].index > heap[i * 2].index)) {
                    node t = heap[i];
                    heap[i] = heap[i * 2];
                    heap[i * 2] = t;
                }
                break;
            }
            if (heap[i].value > Math.min(heap[i * 2].value, heap[i * 2 + 1].value))  {
                if (heap[i * 2].value < heap[i * 2 + 1].value) {
                    node t = heap[i];
                    heap[i] = heap[i * 2];
                    heap[i * 2] = t;
                    i *= 2;
                } else if (heap[i * 2 + 1].value < heap[i * 2].value){
                    node t = heap[i];
                    heap[i] = heap[i * 2 + 1];
                    heap[i * 2 + 1] = t;
                    i = i * 2 + 1;
                } else {
                    if (heap[i * 2].index < heap[i * 2 + 1].index) {
                        node t = heap[i];
                        heap[i] = heap[i * 2];
                        heap[i * 2] = t;
                        i *= 2;
                    } else {
                        node t = heap[i];
                        heap[i] = heap[i * 2 + 1];
                        heap[i * 2 + 1] = t;
                        i = i * 2 + 1;
                    }
                }
            } else if (heap[i].value == Math.min(heap[i * 2].value, heap[i * 2 + 1].value)) {
                if (heap[i * 2].value < heap[i * 2 + 1].value) {
                    node t = heap[i];
                    heap[i] = heap[i * 2];
                    heap[i * 2] = t;
                    i *= 2;
                } else if (heap[i * 2 + 1].value < heap[i * 2].value){
                    node t = heap[i];
                    heap[i] = heap[i * 2 + 1];
                    heap[i * 2 + 1] = t;
                    i = i * 2 + 1;
                } else {
                    if (heap[i * 2].index < Math.min(heap[i].index, heap[i * 2 + 1].index)) {
                        node t = heap[i];
                        heap[i] = heap[i * 2];
                        heap[i * 2] = t;
                        i *= 2;
                    } else if (heap[i * 2 + 1].index < Math.min(heap[i * 2].index, heap[i].index)) {
                        node t = heap[i];
                        heap[i] = heap[i * 2 + 1];
                        heap[i * 2 + 1] = t;
                        i = i * 2 + 1;
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return tmp;
    }
}
