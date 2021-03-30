package com.zuoshen4;

public class MatrixSpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        MatrixSpiralOrder matrixSpiralOrder = new MatrixSpiralOrder();
        matrixSpiralOrder.spiralOrderPrint(matrix);
    }

    public void spiralOrderPrint(int[][] matrix){
        int tRow = 0;
        int tColunm = 0;
        int lRow = matrix.length - 1;
        int lColunm = matrix[0].length - 1;
        while (tRow <= lRow && tColunm <= lColunm){
            rotateEdge(matrix,tRow++,tColunm++,lRow--,lColunm--);
        }
    }

    public void rotateEdge(int[][] matrix,int tRow,int tColunm,int lRow,int lColum){
        if (tRow == lRow){
            for (int i = tColunm; i < lColum; i++) {
                System.out.println(matrix[tRow][i] + " ");
            }
        } else if (tColunm == lColum){
            for (int i = tRow; i < lRow; i++) {
                System.out.println(matrix[i][tColunm] + " ");
            }
        } else {
            int curRow = tRow;
            int curColunm = tColunm;
            while (curColunm != lColum){
                System.out.println(matrix[curRow][curColunm++] + " ");
            }
            while (curRow != lRow){
                System.out.println(matrix[curRow++][curColunm] + " ");
            }
            while (curColunm != tColunm){
                System.out.println(matrix[curRow][curColunm--] + " ");
            }
            while (curRow != tRow){
                System.out.println(matrix[curRow--][curColunm] + " ");
            }
        }
    }

}
