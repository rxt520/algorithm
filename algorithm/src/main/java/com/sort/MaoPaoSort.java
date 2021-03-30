package com.sort;

import java.util.Arrays;

public class MaoPaoSort {
    public static void main(String[] args) {
        MaoPaoSort maoPaoSort = new MaoPaoSort();
        int[] list =  new int[]{5,3,4,9,2,1,10,7};
        maoPaoSort.sort(list);
        Arrays.stream(list).forEach(e ->{
            System.out.println(e);
        });
    }

    private void sort(int[] list){
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j]>list[j+1]){
                    switchLocation(list,j,j+1);
                }
            }
        }
    }

    private void switchLocation(int[] list, int i, int j) {
       Integer temp = list[i];
       list[i] = list[j];
       list[j] = temp;
    }

}
