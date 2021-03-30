package com.zuoshen4;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        RotateMatrix rotateMatrix = new RotateMatrix();
        rotateMatrix.rotate(matrix);
        rotateMatrix.printMatrix(matrix);
    }


    public void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateMatrix(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public void rotateMatrix(int[][] matrix,int tRow,int tColunm,int lRow,int lColum){
        int temp = 0;
        int times = lRow - tRow;
        for (int i = 0; i < times; i++) {
            temp = matrix[tRow][tColunm + i];
            matrix[tRow][tColunm+i] = matrix[tRow + i][lColum];
            matrix[tRow + i][lColum] = matrix[lRow][lColum - i];
            matrix[lRow][lColum-i] = matrix[lRow-i][tColunm];
            matrix[lRow-i][tColunm] = temp;
        }
    }
}
