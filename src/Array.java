public class Array<E> {
    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 无参数构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中元素的个数
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     * @return data.length
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return true;false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     * @param e
     * @throws IllegalAccessException
     */
    public void addLast(E e) {
        add(size, e);
    }
    public void addFirst(E e) {
        add(0, e);
    }
    /**
     * 向数组中第index位置插入一个新元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add Failed. Require index >= 0 and index <= size");
        }
        if (size == data.length) {
            resize(2* data.length);
        }
        for (int i = size - 1; i >= index; i --) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    /**
     * 获取index索引位置的元素
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get Failed. Index is illegal.");
        }
        return data[index];
    }
    public E getFirst() {
        return get(0);
    }
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 判断Array中是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i ++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找Array中元素e所在的索引，如果不存在，则返回-1
     * @param e
     * @return
     */
    public int find(E e)  {
        for (int i = 0; i < size; i ++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除index位置元素，返回删除的元素
     * @param index
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove Failed. Index is illegal.");
        }
        E res = data[index];
        for(int i = index; i < size - 1; i ++) {
            data[i] = data[i+1];
        }
        size --;
        // TODO
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0)  {
            resize(data.length / 2);
        }
        return res;
    }

    /**
     * 删除数组中第一个元素
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组中最后一个元素
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     * @param e
     */
    public void  removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }

    }
    /**
     * 修改index索引位置元素为e
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get Failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * Array类的toString父类方法实现
     * @return
     */
    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size: %d, capacity: %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i ++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");

        return res.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i< size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }

}



