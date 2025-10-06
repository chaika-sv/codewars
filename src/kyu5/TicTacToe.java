package kyu5;

public class TicTacToe {

    public static void main(String[] args) {

        int[][] board = {
                {1, 2, 1},
                {2, 1, 2},
                {2, 1, 2}
        };

        System.out.println( isSolved(board) );
    }

    public static int isSolved(int[][] board) {

        // Replace 1 -> 3 and 2 -> 7
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (board[i][j] == 1)
                    board[i][j] = 3;
                else if (board[i][j] == 2)
                    board[i][j] = 7;

        int[] rowSums = new int[3];
        int[] colSums = new int[3];

        int zeroesCnt = 0;

        // Calc sums by rows and cols
        // Also calc zeros
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                rowSums[i] += board[i][j];
                colSums[j] += board[i][j];

                if (board[i][j] == 0)
                    zeroesCnt++;
            }

        // Check sums
        for (int i = 0; i < 3; i++) {
            if (rowSums[i] == 9 || colSums[i] == 9)
                return 1;
            if (rowSums[i] == 21 || colSums[i] == 21)
                return 2;
        }


        int d1 = 0;
        int d2 = 0;

        // Calc sums in diagonals
        for (int i = 0; i < 3; i++) {
            d1 += board[i][i];
            d2 += board[i][3 - 1 - i];
        }

        // Check diagonals
        if (d1 == 9 || d2 == 9)
            return 1;

        if (d1 == 21 || d2 == 21)
            return 2;


        if (zeroesCnt == 0)
            return 0;
        else
            return -1;

    }


}
