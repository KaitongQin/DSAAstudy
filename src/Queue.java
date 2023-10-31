//定义一个队列类
public class Queue {
    //定义一个节点类，用于存储链表中的元素和指向下一个节点的引用
    static class Node {
        //定义一个变量来存储元素
        int element;
        //定义一个变量来存储下一个节点的引用
        Node next;
        //构造一个节点，传入元素和下一个节点的引用
        public Node(int element, Node next) {
            //初始化变量
            this.element = element;
            this.next = next;
        }
    }
    //定义两个变量来记录队首和队尾节点的引用
    private Node head;
    private Node tail;
    //定义一个变量来记录队列的大小
    private int size;

    //构造一个空队列
    public Queue() {
        //初始化变量
        head = null;
        tail = null;
        size = 0;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        //如果大小为0，返回true，否则返回false
        return size == 0;
    }

    //返回队列的大小
    public int size() {
        //返回大小
        return size;
    }

    //入队操作
    public void enqueue(int element) {
        //创建一个新的节点，传入元素和null作为下一个节点的引用
        Node newNode = new Node(element, null);
        //如果队列为空，将新节点赋值给队首和队尾节点的引用
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            //否则，将新节点赋值给原队尾节点的下一个节点的引用，并将新节点赋值给队尾节点的引用
            tail.next = newNode;
            tail = newNode;
        }
        //大小加一
        size++;
    }

    //出队操作
    public int dequeue() {
        //如果队列为空，抛出异常
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        //获取队首节点的元素
        int element = head.element;
        //将原队首节点的下一个节点赋值给队首节点的引用，方便垃圾回收
        head = head.next;
        //如果出队后队列为空，将队尾节点的引用置为null
        if (head == null) {
            tail = null;
        }
        //大小减一
        size--;
        //返回出队元素
        return element;
    }

    //查看队首元素
    public int peek() {
        //如果队列为空，抛出异常
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        //返回队首节点的元素
        return head.element;
    }
}
