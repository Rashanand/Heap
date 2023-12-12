package ds.heap;

import ds.heap.service.HeapService;

import java.sql.SQLOutput;
import java.util.Arrays;

public class HeapTest {
    public static void main(String[] args) {
        //testMaxHeap();
        //testMaxHeapArr();
        //testHeapSortAsc();
        //testMinHeap();
        //testAllLessK();
        testMergeHeaps();
    }

    private static void testAllLessK() {
        HeapService service = new HeapService("MIN");
        service.add(31);
        service.add(28);
        service.add(29);
        service.add(17);
        service.add(23);
        service.add(22);
        service.add(25);
        service.add(24);
        service.add(16);
        service.add(30);
        service.add(45);
        service.add(27);
        System.out.println(service.getHeap());
        Arrays.stream(service.getAllLess(29)).forEach(ele -> System.out.print(ele + ", "));
    }

    private static void testMinHeap() {
        HeapService service = new HeapService("MIN");
        service.add(31);
        service.add(28);
        service.add(29);
        service.add(17);
        service.add(23);
        service.add(22);
        service.add(25);
        service.add(24);
        service.add(16);
        service.add(30);
        service.add(45);
        service.add(27);
        System.out.println(service.getHeap());
        System.out.println("Get max --> "+ service.getMaxForMinHeap());
        System.out.println(service.delete());
        System.out.println(service.getHeap());
        System.out.println("Delete element --> "+ service.delete(29));
        System.out.println(service.getHeap());
    }

    private static void testMaxHeap() {
        HeapService service = new HeapService("MAX");
        service.add(31);
        service.add(28);
        service.add(29);
        service.add(17);
        service.add(23);
        service.add(22);
        service.add(25);
        service.add(24);
        service.add(16);
        service.add(30);
        service.add(45);
        service.add(27);
        System.out.println(service.getHeap());
        System.out.println("Get min --> "+ service.getMinForMaxHeap());
        System.out.println("Delete element --> "+ service.delete(29));
        System.out.println(service.getHeap());
        System.out.println("Delete element --> "+ service.deleteIndex(7));
        System.out.println(service.getHeap());
        System.out.println(service.delete());
        System.out.println(service.getHeap());
        System.out.println(service.delete());
        System.out.println(service.getHeap());
        System.out.println(service.delete());
        System.out.println(service.getHeap());
        System.out.println(service.delete());
        System.out.println(service.getHeap());
        System.out.println(service.delete());
        System.out.println(service.getHeap());
        System.out.println(service.delete());
        System.out.println(service.delete());
        System.out.println(service.getHeap());
    }

    private static void testMaxHeapArr() {
        Integer[] arr = {45, 31, 29, 24, 30, 27, 25, 17, 16, 23, 28, 22};//{8, 12, 16, 4, 11, 15, 20, 3, 25};
        HeapService service = new HeapService("MAX", arr.length);
        arr = service.heapifyArray(arr);
        Arrays.stream(arr).forEach(ele -> System.out.print(ele + ", "));
    }

    private static void testHeapSortAsc() {
        Integer[] arr = {8, 12, 16, 4, 11, 15, 20, 3, 25};
        HeapService service = new HeapService("MAX", arr.length);
        arr = service.heapSort(arr);
        System.out.println();
        Arrays.stream(arr).forEach(ele -> System.out.print(ele + ", "));
    }

    private static void testMergeHeaps() {
        Integer[] h1 = {16, 14, 12, 6, 13, 11, 10, 4, 5, 2};
        Integer[] h2 = {25, 15, 24, 13, 12, 22, 21, 6, 5, 4, 3, 17, 16};
        HeapService service = new HeapService("MAX");
        Integer[] res = service.mergeTwoHeaps(h1, h2);

        Arrays.stream(res).forEach(ele -> System.out.print(ele + " "));
        System.out.println("Improved below..");
        Integer[] res1 = service.mergeTwoHeapsImproved(h1, h2);

        Arrays.stream(res1).forEach(ele -> System.out.print(ele + " "));
        System.out.println();
    }

}
