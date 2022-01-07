package Lab;

import java.util.Scanner;

public class Lab6 {
    static Scanner sc;
    static int N, i, j;

    public static void printBoard(int board[][]) {
        for(i = 0; i < N; i++) {
            for (j = 0; j < N; j++)
                if(board[i][j] == 1) {
                    System.out.print("Q\t");
                } else {
                    System.out.print("_\t");
                }
            System.out.println("\n");
        }
    }
    public static boolean isSafe(int board[][], int row, int col) {
        int i, j;
        //Xét vị trí theo hàng từ bên trái sang
        for (i = 0; i < col; i++) {
            if(board[row][i] == 1)
                return false;
        }
        //Xét vị trí theo đường chéo trái phía trên
        for (i = row, j = col; i >=0 && j>= 0; i--, j--){
            if(board[i][j] == 1)
                return false;
        }
        //Xét vị trí theo đường chéo trái dưới
        for (i = row, j = col; i < N && j>= 0; i++, j--){
            if(board[i][j] == 1)
                return false;
        }
        //cho phép đặt
        return true;
    }

    //Hàm
    public static boolean setQueen(int board[][], int col) {
        if(col >= N)
            return true;
        for (int i = 0; i<N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1; //Đặt hậu
                if (setQueen(board, col +1)) //Xét vị trí kế tiep
                    return true;
                board[i][col] = 0; //rút lui
            }
        }
        return false;
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("State the value of N in this program");
        N = sc.nextInt();
        int[][] board = new int[N][N];
        if(!setQueen(board, 0)) {
            System.out.println("No result");
        }
        printBoard(board);
    }
}
