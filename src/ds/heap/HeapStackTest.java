package ds.heap;

import ds.heap.service.HeapStack;

import java.util.Arrays;

public class HeapStackTest {
    public static void main(String[] args) {
        defaultTest();
    }

    private static void defaultTest() {
        HeapStack heapStack = new HeapStack();
        heapStack.push("1st");
        heapStack.push("2nd");
        heapStack.push("3rd");
        heapStack.push("4th");
        heapStack.push("5th");
        heapStack.push("6th");

        System.out.println(heapStack.get());

        System.out.println(heapStack.pop());
        System.out.println(Arrays.asList(heapStack.getElements()));
        System.out.println(heapStack.pop());
        System.out.println(Arrays.asList(heapStack.getElements()));
    }
}
