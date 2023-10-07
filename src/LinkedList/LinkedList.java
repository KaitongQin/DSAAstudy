package LinkedList;

public class LinkedList{
    public Node head;

    public LinkedList() {};
    public LinkedList(Node head) {
        this.head = head;
    }
    public LinkedList(int value) {
        this.head = new Node(value);
    }

    @Override
    public String toString() {
        if(head == null) {
            return "";
        }
        var sb = new StringBuilder();
        sb.append(head.value);
        var curr = head.next;
        while(curr != null) {
            sb.append(" -> ").append(curr.value);
            curr = curr.next;
        }
        return sb.toString();
    }
}
