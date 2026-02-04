package kyu4;

import java.util.Map;

public class MatrixDeterminant {


    public static void main (String[] args) {
        int[][] matrix1 = {{1}};            // 1
        int[][] matrix2 = {{1, 3}, {2,5}};  // -1
        int[][] matrix3 = {{2,5,3}, {1,-2,-1}, {1, 3, 4}};  // -20

        //printGrid( matrix1 );

        System.out.println(determinant(matrix3));
    }

    public static int determinant(int[][] m) {
        if (m.length == 1)
            return m[0][0];

        if (m.length == 2)
            return m[0][0] * m[1][1] - m[0][1] * m[1][0];

        int totalDet = 0;

        for (int i = 0; i < m.length; i++) {
            int[][] subM = new int[m.length - 1][m.length - 1];

            for (int j = 1; j < m.length; j++) {
                int p = 0;
                for (int k = 0; k < m.length; k++)
                    if (k != i) {
                        subM[j-1][p] = m[j][k];
                        p++;
                    }
            }

            if (i % 2 == 0)
                totalDet += m[0][i] * determinant(subM);
            else
                totalDet -= m[0][i] * determinant(subM);
        }

        return totalDet;
    }



    public static void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (i % 3 == 0 && i != 0)
                System.out.println("------+-------+------");

            for (int j = 0; j < grid[i].length; j++) {
                if (j % 3 == 0 && j != 0)
                    System.out.print("| ");

                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
