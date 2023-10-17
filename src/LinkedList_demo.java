public class LinkedList_demo{
    public static void main(String[] args){
        Node1 head = new Node1(null, 0);
        Node1 curr = head;
        int[] a = {1,2,34,42,55};
        for(int i = 0; i < 5; i++) {
            curr.next = new Node1(null, a[i]);
            curr = curr.next;
        }
        int x = 42;
        curr = head.next;
        while(curr != null) {
            if(curr.data == x) {
                break;
            }
            curr = curr.next;
        }
        for(curr = head.next; curr != null; curr = curr.next) {
            if(curr.data == x) {
                break;
            }
        }
        Node1 node1 = new Node1(head.next, 42);
        curr.next = node1;//在已知节点后插入新节点；应该先将新节点的下一个指向当前的下一个；再将当前的下一个指向新节点
        Node1 prev = null;
        while(curr != null) {
            if(curr.data == x) {
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        //delete node
        curr.next = curr.next.next;
    }
}
class Node1{
    Node1 next;
    int data;
    public Node1(Node1 next, int data) {
        this.next = next;
        this.data = data;
    }
}
