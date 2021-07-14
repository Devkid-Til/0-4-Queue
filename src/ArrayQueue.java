public class ArrayQueue<E> implements Queue {

    private Array<E> array;
    public ArrayQueue(int capacity) { array = new Array<E>(capacity); }
    public ArrayQueue() { array = new Array<>();}

    @Override
    public void enqueue(Object o) {
        array.addLast((E) o);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue:");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(",");
            }

        }
        res.append("] Tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue.toString());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.toString());
        System.out.println(queue.toString());
        System.out.println(queue.toString());
        System.out.println(queue.toString());
        System.out.println(queue.toString());
    }
}
