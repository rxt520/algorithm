package com.sort;

import java.util.Arrays;

/**
 * @author COM-RXT
 * @date 2021-1-11
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] list =  new int[]{5,3,4,9,2,7,10,7,7,546,1,78,9,2,4,3,5,8,7,4,1,6,2,85,75,1,5,3,4,5};
        HeapSort heapSort = new HeapSort();
//        quickSort.sortLessAndLarger(list,0,list.length-1);
//        quickSort.sortLessEqualLarge(list,0,list.length-1);
//        quickSort.normalQuickSort(list,0,list.length-1);
        heapSort.heapSort(list);
        System.out.println(Arrays.toString(list));
    }

    public void heapSort(int[] list){
        heapInsert(list);
        int heapSize = list.length;
        swap(list,0,--heapSize);
        while (heapSize > 1){
            heapify(list,0,heapSize);
            swap(list,0,--heapSize);
        }
    }

    public void heapInsert(int[] list){
        for (int i = 0; i < list.length; i++) {
            int index = i;
            while (list[index] > list[(index-1)/2]){
                swap(list,(index-1)/2,index);
                index = (index-1)/2;
            }
        }
    }

    public void heapify(int[] list,int index,int heapSize){
        int left = index * 2 + 1;
        while (left < heapSize){
            int largest = left + 1 < heapSize && list [ left + 1] > list [left]?left + 1 : left;
            if (list[index] >= list[largest]){
                return;
            }
            swap(list,largest,index);
            index = largest;
            left = index * 2 + 1;
        }
    }


    public void swap(int[] list,int from,int to){
        int temp = list[from];
        list[from] = list[to];
        list[to] = temp;
    }
}
