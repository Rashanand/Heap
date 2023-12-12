package ds.heap.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HeapService {
    private static final int DEFAULT_INITIAL_CAPACITY = 5;
    private final static List<String> TYPES = Arrays.asList("MAX", "MIN");
    private Heap heap;

    private class Heap {
        Integer[] dataArr;
        String type;
        int size;

        public Heap(String type, int capacity) {
            this.type = type;
            if (TYPES.contains(type)) {
                this.dataArr = new Integer[capacity];
                this.size = 0;
            }
        }
    }

    public HeapService() throws IllegalArgumentException{
        this("MAX");
    }

    public HeapService(String type) throws IllegalArgumentException {
        this(type, DEFAULT_INITIAL_CAPACITY);
    }

    public HeapService(String type, int capacity) throws IllegalArgumentException {
        if (!TYPES.contains(type)) {
            throw new IllegalArgumentException("Invalid Heap param - type");
        } if(capacity < 1) {
            throw new IllegalArgumentException("Invalid Heap param - capacity");
        }
        this.heap = new Heap(type, capacity);
    }

    public void add(int data) {
        //Add the ele in last position
        checkAndIncreaseDataArrCapacity();
        this.heap.dataArr[heap.size] = data;
        this.heap.size++;
        perculateUp(heap.size - 1);
    }

    private void perculateUp(int index) {
        //Perculate Up
        if (heap.size > 1) {
            int heapIndex = index;
            while (true) {
                int parentIndex = getParentIndex(heapIndex);
                if("MAX".equals(heap.type)) {
                    if (heap.dataArr[heapIndex] > heap.dataArr[parentIndex]) {
                        int temp = heap.dataArr[heapIndex];
                        heap.dataArr[heapIndex] = heap.dataArr[parentIndex];
                        heap.dataArr[parentIndex] = temp;
                        heapIndex = parentIndex;
                    } else {
                        break;
                    }
                } else if("MIN".equals(heap.type)){
                    if (heap.dataArr[heapIndex] < heap.dataArr[parentIndex]) {
                        int temp = heap.dataArr[heapIndex];
                        heap.dataArr[heapIndex] = heap.dataArr[parentIndex];
                        heap.dataArr[parentIndex] = temp;
                        heapIndex = parentIndex;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public Integer delete() {
        //Add last element to root
        //Perculate down
        if (heap.size > 0) {
            int root = heap.dataArr[0];
            heap.dataArr[0] = heap.dataArr[heap.size - 1];
            heap.dataArr[heap.size - 1] = null;
            heap.size--;
            if (heap.size > 1) {
                perculateDown(0);
            }
            return root;
        }
        return null;
    }

    private void perculateDown(int index) {
        //Check children, swap with the highest child
        //if children are null, or both children are less
        switch (heap.type) {
            case "MAX": perculateDownMax(index); break;
            case "MIN": perculateDownMin(index); break;
            default:
                System.out.println("Invalid heap type argument");
        }
    }

    private void perculateDownMax(int index) {
        int heapIndex = index;
        while (true) {
            int parIndex = heapIndex;
            int[] childs = getChilds(heapIndex);
            Integer ch1 = null;
            if (childs[0] < heap.size)
                ch1 = heap.dataArr[childs[0]];
            Integer ch2 = null;
            if (childs[1] < heap.size)
                ch2 = heap.dataArr[childs[1]];
            Integer temp = null;
            if (ch1 != null && ch2 != null) {
                if (ch1 < ch2) {
                    heapIndex = childs[1];
                    temp = ch2;
                } else {
                    heapIndex = childs[0];
                    temp = ch1;
                }
            } else if (ch1 != null) {
                heapIndex = childs[0];
                temp = ch1;
            } else if (ch2 != null) {
                heapIndex = childs[1];
                temp = ch2;
            } else {
                break;
            }
            if (heap.dataArr[parIndex] < heap.dataArr[heapIndex]) {
                heap.dataArr[heapIndex] = heap.dataArr[parIndex];
                heap.dataArr[parIndex] = temp;
            } else {
                break;
            }
        }
    }

    private void perculateDownMin(int index) {
        int heapIndex = index;
        while (true) {
            int parIndex = heapIndex;
            int[] childs = getChilds(heapIndex);
            Integer ch1 = null;
            if (childs[0] < heap.size)
                ch1 = heap.dataArr[childs[0]];
            Integer ch2 = null;
            if (childs[1] < heap.size)
                ch2 = heap.dataArr[childs[1]];
            Integer temp = null;
            if (ch1 != null && ch2 != null) {
                if (ch1 > ch2) {
                    heapIndex = childs[1];
                    temp = ch2;
                } else {
                    heapIndex = childs[0];
                    temp = ch1;
                }
            } else if (ch1 != null) {
                heapIndex = childs[0];
                temp = ch1;
            } else if (ch2 != null) {
                heapIndex = childs[1];
                temp = ch2;
            } else {
                break;
            }
            if (heap.dataArr[parIndex] > heap.dataArr[heapIndex]) {
                heap.dataArr[heapIndex] = heap.dataArr[parIndex];
                heap.dataArr[parIndex] = temp;
            } else {
                break;
            }
        }
    }

    private int[] getChilds(int index) {
        int arr[] = new int[]{(index * 2 + 1), (index * 2 + 2)};
        return new int[]{(index * 2 + 1), (index * 2 + 2)};
    }

    public List<Integer> getHeap() {
        return Arrays.stream(heap.dataArr).filter(i -> i != null).collect(Collectors.toList());
    }

    private void checkAndIncreaseDataArrCapacity() {
        if (this.heap.dataArr.length == (this.heap.size + 1)) {
            Integer[] arr = new Integer[this.heap.dataArr.length * 2];
            IntStream.range(0, heap.size).forEach(index -> arr[index] = heap.dataArr[index]);
            heap.dataArr = arr;
        }
    }

    public Integer[] heapifyArray(Integer[] inputArr) {
        if (inputArr != null && inputArr.length > 0) {
            heap.size = inputArr.length;
            for(int i = 0; i < inputArr.length; i++) {
                heap.dataArr[i] = inputArr[i];
            }
            int parentIndex = getParentIndex(heap.size - 1);
            while (parentIndex >= 0) {
                perculateDown(parentIndex--);
            }
        }
        return heap.dataArr;
    }

    public Integer[] heapSort(Integer[] input) {
        if(input != null && input.length > 0) {
            heapifyArray(input);
            while(heap.size > 0) {
                heap.size--;
                int temp = heap.dataArr[0];
                heap.dataArr[0] = heap.dataArr[heap.size];
                heap.dataArr[heap.size] = temp;

                perculateDown(0);
            }
        }
        return heap.dataArr;
    }

    public Integer deleteIndex(int index) {
        if(index > heap.size)
            return null;

        Integer ele = heap.dataArr[index];
        heap.dataArr[index] = heap.dataArr[heap.size - 1];
        heap.dataArr[heap.size - 1] = null;
        heap.size--;
        perculateDown(index);
        return ele;
    }

    public Integer delete(Integer element) {
        int index = -1;
        for(int i = 0; i < heap.size; i++) {
            if(element == heap.dataArr[i]) {
                index = i;
                break;
            }
        }
        return deleteIndex(index);
    }

    public Integer getMinForMaxHeap() {
        Integer min = null;
        if(heap.size > 0) {
            int firstParentIndex = (heap.size - 1)/2;
            min = heap.dataArr[firstParentIndex + 1];
            for(int i = firstParentIndex + 1; i < heap.size; i++) {
                if(heap.dataArr[i] < min)
                    min = heap.dataArr[i];
            }
        }
        return min;
    }

    public Integer getMaxForMinHeap() {
        Integer max = null;
        if(heap.size > 0) {
            int firstParentIndex = (heap.size - 1)/2;
            max = heap.dataArr[firstParentIndex + 1];
            for(int i = firstParentIndex + 1; i < heap.size; i++) {
                if(heap.dataArr[i] > max)
                    max = heap.dataArr[i];
            }
        }
        return max;
    }

    public Integer[] getAllLess(int k) {
        if("MIN".equals(heap.type))
            return performSearchLessForMinHeap(k, 0, new Integer[heap.size], 0);
        else if("MAX".equals(heap.type))
            return null;
        else
            return null;
    }

    private Integer[] performSearchLessForMinHeap(int k, int index, Integer[] eles, Integer heapEle) {
        if(heap.dataArr[heapEle] != null && heap.dataArr[heapEle] < k) {
            eles[index] = heap.dataArr[heapEle];
            int childs [] = getChilds(heapEle);
            performSearchLessForMinHeap(k, ++index, eles, childs[0]);
            performSearchLessForMinHeap(k, ++index, eles, childs[1]);
        }
        return eles;
    }

    public Integer[] mergeTwoHeaps(Integer[] h1, Integer[] h2) {
        if(h1 == null || h2 == null) {
            System.out.println("Null Array found.");
            return null;
        }

        Integer[] result = new Integer[h1.length + h2.length];

        for(int i = 0; i < h1.length; i++) {
            result[i] = h1[i];
        }

        for(int i = h1.length; i < result.length; i++) {
            result[i] = h2[i - h1.length];
        }

        this.heap.dataArr = result;
        this.heap.size = result.length;

        for(int i = result.length - 1; i >= 0 ; i--) {
            this.perculateDown(i);
        }

        return heap.dataArr;
    }

    public Integer[] mergeTwoHeapsImproved(Integer[] h1, Integer[] h2) {
        if(h1 == null || h2 == null) {
            System.out.println("Null Array found.");
            return null;
        }

        Integer[] result = new Integer[h1.length + h2.length];

        for(int i = 0; i < h1.length; i++) {
            result[i] = h1[i];
        }

        for(int i = h1.length; i < result.length; i++) {
            result[i] = h2[i - h1.length];
        }

        this.heap.dataArr = result;
        this.heap.size = result.length;

        int firstNonLeafNode = (heap.size - 1)/2;
        for(int i = firstNonLeafNode; i >= 0; i--) {
            perculateDown(i);
        }

        return heap.dataArr;
    }
}
