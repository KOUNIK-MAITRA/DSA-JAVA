import java.io.*;
import java.util.*;
class ValidSudoku {
    static boolean isValidSudoku(char[][] board) {
        HashSet < String > set = new HashSet < > ();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];

                if (number != '.') {
                    if (!set.add(number + " present in row " + i) ||
                    !set.add(number + " present in col " + j) ||
                    !set.add(number + " present in box " + (i / 3) + '/' + (j / 3)))

                        return false;
                }
            }
        }

        return true;
    }

    public static void main(String args[]){
        char board[][]= 
            {{'8','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));
    }
}