package com.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] list =  new int[]{5,3,4,9,2,1,10,7};
        selectSort.sort(list);
        Arrays.stream(list).forEach(e ->{
            System.out.println(e);
        });
    }

    private void sort(int[] list){
        for (int i = 0; i < list.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j]<list[i]){
                    index = j;
                }
            }
            switchLocation(list,i,index);
        }
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
