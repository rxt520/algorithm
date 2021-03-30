package com.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] list =  new int[]{5,3,4,9,2,1,10,7};
        insertSort.sort(list);
        Arrays.stream(list).forEach(e ->{
            System.out.println(e);
        });
    }

    private void sort(int[] list){

    }

    private void switchLocation(int[] list, int i, int j) {
        if (i==j){
            return;
        }
        Integer temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
