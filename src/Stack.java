//定义一个栈类
public class Stack {
    //定义一个数组来存储元素
    private int[] array;
    //定义一个变量来记录栈的大小
    private int size;
    //定义一个常量来表示数组的初始容量
    private static final int INITIAL_CAPACITY = 10;

    //构造一个空栈
    public Stack() {
        //初始化数组和大小
        array = new int[INITIAL_CAPACITY];
        size = 0;
    }

    //判断栈是否为空
    public boolean isEmpty() {
        //如果大小为0，返回true，否则返回false
        return size == 0;
    }

    //返回栈的大小
    public int size() {
        //返回大小
        return size;
    }

    //入栈操作
    public void push(int element) {
        //如果数组已满，扩容两倍
        if (size == array.length) {
            resize(array.length * 2);
        }
        //将元素放在数组的末尾，即栈顶
        array[size] = element;
        //大小加一
        size++;
    }

    //出栈操作
    public int pop() {
        //如果栈为空，抛出异常
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        //获取数组的末尾元素，即栈顶元素
        int element = array[size - 1];
        //将数组的末尾元素置为0，方便垃圾回收
        array[size - 1] = 0;
        //大小减一
        size--;
        //如果数组太大，缩容一半
        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }
        //返回出栈元素
        return element;
    }

    //查看栈顶元素
    public int peek() {
        //如果栈为空，抛出异常
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        //返回数组的末尾元素，即栈顶元素
        return array[size - 1];
    }

    //调整数组的大小
    private void resize(int newCapacity) {
        //创建一个新的数组，容量为参数指定的值
        int[] newArray = new int[newCapacity];
        //将原数组的元素复制到新数组中
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        //将新数组赋值给原数组
        array = newArray;
    }
}
