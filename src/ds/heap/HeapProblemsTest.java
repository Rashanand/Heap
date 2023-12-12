package ds.heap;

import ds.heap.service.HeapProblems;

public class HeapProblemsTest {
    public static void main(String[] args) {
        mergeSortTest();
        mergeKsortedLists();
        mergeKsortedListsByPair();
    }

    private static void mergeSortTest() {
        int arr[] = {25, 15, 24, 13, 12, 22, 21, 6, 5, 4, 3, 17, 16};
        HeapProblems.mergeSort(arr);
        for (int i:arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    private static void mergeKsortedLists() {
        int arr[][] = {{5, 7, 15, 18}, {12, 50, 65, 70}, {3, 9, 12, 15}, {6, 18, 30, 42}};
        int l[] = HeapProblems.mergeSortedListsOneByOne(arr);

        for (int i:l) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    private static void mergeKsortedListsByPair() {
        int arr[][] = {{5, 7, 15, 18}, {12, 50, 65, 70}, {3, 9, 12, 15}, {6, 18, 30, 42}};
        int l[] = HeapProblems.mergeSortedListsPair(arr);

        for (int i:l) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
