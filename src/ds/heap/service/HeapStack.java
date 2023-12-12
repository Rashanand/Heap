package ds.heap.service;

import java.util.Arrays;

public class HeapStack {
    private class Element {
        int priority;
        String data;

        public Element(int priority, String data) {
            this.priority = priority;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "priority=" + priority +
                    ", data='" + data + '\'' +
                    '}';
        }
    }

    private static int DEFAULT_CAP = 5;
    private int count;
    private Element[] elements;

    public HeapStack(int capacity) {
        count = 0;
        elements = new Element[capacity];
    }

    public HeapStack() {
        this(DEFAULT_CAP);
    }

    public void push(String data) {
        if(count >= elements.length) {
            System.out.println("Stack is full!! Unable to push data : "+ data);
            return;
        }

        Element element = new Element(count, data);
        elements[count] = element;
        perculateUp(count);
        count++;
    }

    private void perculateUp(int index) {
        int heapIndex = index;
        while(true) {
            int parentIndex = (heapIndex - 1)/2;
            if(elements[parentIndex].priority < elements[heapIndex].priority) {
                Element temp = elements[parentIndex];
                elements[parentIndex] = elements[heapIndex];
                elements[heapIndex] = temp;
                heapIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    public String pop() {
        if(elements == null || elements.length == 0) {
            System.out.println("Stack is empty!!");
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
        while(true) {
            int[] childsIndeces = {heapIndex*2 + 1, heapIndex*2 + 2};
            int largerChild = -1;
            if(elements[childsIndeces[1]] != null) {
                largerChild = elements[childsIndeces[0]].priority > elements[childsIndeces[1]].priority ?
                        childsIndeces[0]:childsIndeces[1];
            } else if(elements[childsIndeces[0]] != null) {
                largerChild = childsIndeces[0];
            } else {
                break;
            }

            if(largerChild < count && (elements[largerChild].priority > elements[heapIndex].priority)) {
                Element temp = elements[largerChild];
                elements[largerChild] = elements[heapIndex];
                elements[heapIndex] = temp;
                heapIndex = largerChild;
            } else {
                break;
            }
        }
    }

    public String get() {
        return elements[0].data;
    }
    public int size() {
        return count;
    }
    public boolean contains(String data) {
        return Arrays.stream(elements).anyMatch(ele -> data == ele.data || data.equals(ele.data));
    }

    public Element[] getElements() {
        return elements;
    }
}
