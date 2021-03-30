package com.sort;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class QuickSort {
    public static void main(String[] args) {
        int[] list =  new int[]{5,3,4,9,2,7,10,7,7};
        QuickSort quickSort = new QuickSort();
//        quickSort.sortLessAndLarger(list,0,list.length-1);
//        quickSort.sortLessEqualLarge(list,0,list.length-1);
//        quickSort.normalQuickSort(list,0,list.length-1);
        quickSort.quickSortPlus(list,0,list.length-1);
        System.out.println(Arrays.toString(list));

    }

    /**
     * @param list
     * @param left
     * @param right
     */
    public void quickSortPlus(int[] list,int left,int right){
        if (left >= right){
            return ;
        }
        int leftBound = left - 1;
        int rightBound = right + 1;
        int index = left;
        int num = list[left + (int)(Math.random())*(right-left+1)];
        while (index < rightBound){
            if (list[index] < num){
                swap(list,index++,++leftBound);
            }else if (list[index] == num){
                index ++;
            }else {
                swap(list,index,--rightBound);
            }
        }

        quickSortPlus(list,left,leftBound);
        quickSortPlus(list,rightBound,right);
    }

    public void normalQuickSort(int[] list,int left,int right){
        if (left >= right){
            return ;
        }
        int leftBound = left-1;
        int num = list[right];
        for (int i = left; i <= right; i++) {
            if (list[i] <= num){
                swap(list,i,++leftBound);
            }
        }
        normalQuickSort(list,left,leftBound-1);
        normalQuickSort(list,leftBound+1,right);
    }


    /**
     * 将小于等于最后一个数的排在左边，将大于最后一个数的排在右边
     */
    public void sortLessAndLarger(int[] list,int left,int right){
        int current= left-1;
        int num = list[right];
        for (int i = 0; i <= right; i++) {
            if (list[i]<= num){
                swap(list,++current,i);
            }
        }
    }

    /**
     * 将小于等于最后一个数的排在左边，将大于最后一个数的排在右边,等于这个数的放在中间
     */
    public void sortLessEqualLarge(int[] list,int left,int right){
        int current= left-1;
        int num = list[right];
        int index = left;
        while (index<right){
            if (list[index] < num){
                swap(list,++current,index++);
            }else if (list[index] == num){
                index ++;
            }else{
                swap(list,index,right--);
            }
        }
    }

    public void swap(int[] list,int from,int to){
        int temp = list[from];
        list[from] = list[to];
        list[to] = temp;
    }
}
