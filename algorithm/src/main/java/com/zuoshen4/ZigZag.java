package com.zuoshen4;

public class ZigZag {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3, 4, 5},

                {6, 7, 8, 9, 10},

                {11,12,13,14,15},

                {16,17,18,19,20}
        };
        ZigZag zigZag = new ZigZag();
        zigZag.printMatrixZigZag(arr);
    }

    public void printMatrixZigZag(int[][] arr){
        int cEnd = arr[0].length-1;
        int rEnd = arr.length - 1;
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;

        boolean fromUp = false;
        while (bC!=arr[0].length){
            printLevel(arr,aR,aC,bR,bC,fromUp);
            fromUp = !fromUp;
            aR = aC==cEnd?aR+1:aR;
            aC = aC==cEnd?aC:aC+1;
            bC = bR==rEnd?bC+1:bC;
            bR = bR==rEnd?bR:bR+1;
            System.out.println();
        }
    }

    private void printLevel(int[][] arr, int aR, int aC, int bR, int bC, boolean fromUp) {
        if (fromUp){
            while (aR != bR+1){
                System.out.print(arr[aR++][aC--] + " ");
            }
        }else {
            while (bC != aC + 1){
                System.out.print(arr[bR--][bC++] + " ");
            }
        }
    }
}
