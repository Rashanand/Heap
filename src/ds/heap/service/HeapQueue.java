package ds.heap.service;

import java.util.Arrays;

public class HeapQueue {
    private class Element {
        String data;
        int priority;

        public Element(String data, int priority) {
            this.data = data;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "data='" + data + '\'' +
                    ", priority=" + priority +
                    '}';
        }
    }
    private static int DEFAULT_CAPACITY = 5;
    private Element[] elements;
    private int count;

    public HeapQueue() {
        this(DEFAULT_CAPACITY);
    }

    public HeapQueue(int capacity) {
        elements = new Element[capacity];
        count = 0;
    }

    public void enque(String data) {
        if(count >= elements.length) {
            System.out.println("Queue is full!! Couldn't add data :"+ data);
            return;
        }
        int priority = count == 0 ? count : elements[count-1].priority + 1;
        Element element = new Element(data, priority);
        elements[count] = element;
        count++;
    }

    public String deque() {
        if(count == 0) {
            System.out.println("Queue is empty!!");
            return null;
        }
        String data = elements[0].data;
        elements[0] = elements[count-1];
        elements[count-1] = null;
        count--;
        perculateDown(0);
        return data;
    }

    private void perculateDown(int index) {
        int heapIndex = index;
        int[] childIndeces = {index*2 + 1, index*2 + 2};
        int smallChild = -1;

        if(childIndeces[1] < count) {
            smallChild = elements[childIndeces[0]].priority < elements[childIndeces[1]].priority ?
                    childIndeces[0]:childIndeces[1];
        } else if(childIndeces[0] < count) {
            smallChild = childIndeces[0];
        } else {
            return;
        }

        if(elements[smallChild].priority < elements[heapIndex].priority) {
            Element temp = elements[smallChild];
            elements[smallChild] = elements[heapIndex];
            elements[heapIndex] = temp;
            perculateDown(smallChild);
        } else {
            return;
        }
    }

    @Override
    public String toString() {
        return "HeapQueue{" +
                "elements=" + Arrays.asList(elements) +
                ", count=" + count +
                '}';
    }
}
