package ds.heap.service;

public class HeapProblems {
    /*
    * Merge sort..
    * To use in merging list of sorted arrays*/
    public static void mergeSort(int arr[]) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int arr[], int l, int r) {
        if(l < r) {
            int m = (l + r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);

            merge(arr, l, m, r);
        }
    }

    private static void merge(int arr[], int l, int m, int r) {
        int i, j, k;
        int n1 = (m - l) + 1;
        int n2 = r -m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (i = 0; i < n1; i++)
            L[i] = arr[l+i];

        for (i = 0; i < n2; i++)
            R[i] = arr[m+i+1];

        i = 0; j =0; k = l;
        while(i < n1 && j < n2) {
            if(L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }else  {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static int[] mergeSortedListsOneByOne(int [][] sortedLists) {
        if(sortedLists == null || sortedLists.length == 0) {
            System.out.println("Null/Empty list provided!!!");
            return null;
        }
        int [] mergedLists = sortedLists[0];

        for(int i = 1; i < sortedLists.length; i++) {
            int [] secondList = sortedLists[i];
            int [] firstList = mergedLists;
            mergedLists = new int[firstList.length + secondList.length];
            int p = 0; int q = 0; int r = 0;
            while (p < firstList.length && q < secondList.length) {
                if(firstList[p] <= secondList[q]) {
                    mergedLists[r] = firstList[p];
                    p++;
                } else {
                    mergedLists[r] = secondList[q];
                    q++;
                }
                r++;
            }
            while (p < firstList.length) {
                mergedLists[r] = firstList[p];
                p++;
                r++;
            }
            while (q < secondList.length) {
                mergedLists[r] = secondList[q];
                q++;
                r++;
            }
        }
        return mergedLists;
    }

    public static int [] mergeSortedListsPair(int [][] sortedLists) {
        if(sortedLists == null || sortedLists.length == 0) {
            System.out.println("Null/Empty list provided!!!");
            return null;
        }
        int [][] sortedPairs = sortedLists;
        int k = sortedLists.length;
        while (k/2 > 0) {
            sortedPairs = new int[k/2][sortedPairs[0].length * 2];
            for(int i = 0; i < k/2; i++) {
                int p = 0; int q = 0; int r = 0;
                while (p < sortedLists[i * 2].length && q < sortedLists[i * 2 + 1].length) {
                    if(sortedLists[i * 2][p] <= sortedLists[i * 2 + 1][q]) {
                        sortedPairs[i][r] = sortedLists[i * 2][p];
                        p++;
                    } else {
                        sortedPairs[i][r] = sortedLists[i * 2 + 1][q];
                        q++;
                    }
                    r++;
                }
                while (p < sortedLists[i * 2].length) {
                    sortedPairs[i][r] = sortedLists[i * 2][p];
                    p++;
                    r++;
                }
                while (q < sortedLists[i * 2 + 1].length) {
                    sortedPairs[i][r] = sortedLists[i * 2 + 1][q];
                    q++;
                    r++;
                }
            }
            sortedLists = sortedPairs;
            k = k/2;
        }

        if(sortedPairs == null) {
            return null;
        } else {
            return sortedPairs[0];
        }
    }

    public static int[] mergeSortedListsHeap(int[][] sortedLists) {
        if(sortedLists == null ||
                sortedLists.length == 0 ||
                sortedLists[0] == null ||
                sortedLists[0].length == 0) {
            return null;
        }
        int [] result = new int[sortedLists.length * sortedLists[0].length];
        int [][] arrsIndex = new int[2][sortedLists.length];
        for (int i = 0; i < sortedLists.length; i++) {
            arrsIndex[0][i] = i;
            arrsIndex[1][i] = 0;
        }


        return result;
    }

    private void heapifyArr(int [][] arrsIndex, int [][] sortedList) {
        int parent = (arrsIndex.length - 1) / 2;

        while(parent >= 0) {
            int [] childs = {parent * 2 + 1, parent * 2 + 2};
            int larger = -1;//sortedList[arrsIndex[parent][0]][arrsIndex[parent][1]];

            if(sortedList[arrsIndex[childs[0]][0]][arrsIndex[childs[0]][1]] > larger) {
                //capture index
            }

            if(sortedList[arrsIndex[childs[1]][0]][arrsIndex[childs[1]][1]] > larger) {
                //capture index
            }

            //swap if larger> -1 else break return
        }
    }
}
