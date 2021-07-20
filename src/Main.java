public class Main {

    // 测试使用q运行opCount个enqueue和dequeue操作使用的时间， 单位秒
    private static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        for (int i = 0; i < opCount; i++) {
            q.enqueue(i);
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) * 1.0e-9;
    }
    public static void main(String[] args) {

        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        System.out.printf("arrayQueue: %fs\n", testQueue(arrayQueue, opCount));
        System.out.printf("arrayQueue: %fs\n", testQueue(loopQueue, opCount));


    }
}
