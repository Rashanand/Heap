package ds.heap;

import ds.heap.service.HeapQueue;

public class HeapQueueTest {
    public static void main(String[] args) {
        defaultTest();
    }

    private static void defaultTest() {
        HeapQueue queue = new HeapQueue();
        queue.enque("1st");
        queue.enque("2nd");
        queue.enque("3rd");
        queue.enque("4th");
        queue.enque("5th");

        System.out.println(queue);
        queue.enque("6th");

        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue);
        queue.enque("11st");
        queue.enque("12nd");
        queue.enque("13rd");
        queue.enque("14th");
        System.out.println(queue);
    }
}
