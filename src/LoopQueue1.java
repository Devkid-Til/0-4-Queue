public class LoopQueue1<E> implements Queue{

    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue1(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;

    }
    public LoopQueue1() {
        this(10);
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    @Override
    public void enqueue(Object e) {

        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        data[tail] = (E) e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from a empty queue.");
        }

        // 出队列时，先出队列在判断队列的capacity

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if(size == getCapacity() / 4 && getCapacity() / 2 !=0) {
            resize(getCapacity() / 2);
        }
        return ret;

    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot get front from a empty queue.");
        }

        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i ++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString()  {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d  capacity = %d\n",getSize(), getCapacity()));
        res.append("top [");
        int p = front;
        for (int i = 0; i < size; i ++) {
            res.append(data[(p++) % data.length]);

            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();

    }

    public static void main(String[] args) {
        LoopQueue1<Integer> loopQueue1 = new LoopQueue1<>();
        for (int i = 0; i < 20; i++) {
            loopQueue1.enqueue(i);
            System.out.println(loopQueue1.toString());

//            if (i % 3 == 2) {
//                loopQueue1.dequeue();
//                System.out.println(loopQueue1.toString());
//            }
        }
        for (int i = 0; i < 16; i++){
            loopQueue1.dequeue();
            System.out.println(loopQueue1.toString());
        }

    }

}
