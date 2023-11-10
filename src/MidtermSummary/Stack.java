package MidtermSummary;

public class Stack{
    static class Node{
        int value;
        Node next;
        Node prev;
        public Node(int value) {
            this.value = value;
            next = null;
            prev = null;
        }
    }

    Node head;
    Node curr;
    public Stack() {
        head = new Node(-1);
        head.next = null;
        curr = head;
    }
    public void push(int value) {
        curr.next = new Node(value);
        curr.next.prev = curr;
        curr = curr.next;
    }
    public void pop() {
        curr = curr.prev;
        curr.next = null;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Node curr = stack.head.next;
        while(curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println(

        );
        stack.pop();
        stack.pop();
        curr = stack.head.next;
        while(curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
    }
}
