package DataStructure;

import java.util.Arrays;
import java.util.Scanner;

enum Result {
    WIN,
    DRAW,
    NONE
}

public class TicTacToe {
    private final int[][] board = new int[3][3];
    private final int EMPTY = 0, X = 1, O = -1;

    private int player;

    public TicTacToe() {
        clearBoard();
        initializePlayer();
    }

    private void initializePlayer() {
        this.player = X;
    }

    public void clearBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = this.EMPTY;
            }
        }
    }

    public int[] getPlace() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println(("Please enter Row and Col in format of Row,Col. Example: 1,2"));
            String input = scan.next();
            String[] markPlace = input.split(",");
            System.out.println(Arrays.toString(markPlace));
            int[] parsedMarkPlace = new int[]{Integer.parseInt(markPlace[0]), Integer.parseInt(markPlace[1])};
            if (parsedMarkPlace[0] >= 0 && parsedMarkPlace[1] >= 0 && parsedMarkPlace[0] < 3 && parsedMarkPlace[1] < 3)
                return parsedMarkPlace;
            else {
                System.out.println(("Incorrect place entered. Please re-enter"));
            }
        }
    }

    public void changePlayer() {
        this.player = -this.player;
    }

    public void placeMark(int row, int col) {
        board[row][col] = player;
    }

    public boolean isValidPlace(int row, int col) {
        return board[row][col] == this.EMPTY;
    }

    public void playTurn() {
        System.out.printf("Player %d turn%n", this.player);
        int[] place = getPlace();
        int row = place[0];
        int col = place[1];
        while (!isValidPlace(row, col)) {
            place = getPlace();
            row = place[0];
            col = place[1];
        }
        placeMark(row, col);
        Result result = checkResult(this.player);
        System.out.println("Result" + result);
        if(result.equals(Result.WIN)){
            System.out.printf("Player %d won", this.player);
        } else if(result.equals(Result.DRAW)){
            System.out.println("DRAW!");
        } else {
            changePlayer();
            playTurn();
        }
    }

    public boolean isWin(int mark) {
        return ((board[0][0] + board[0][1] + board[0][2] == mark * 3)
                || (board[1][0] + board[1][1] + board[1][2] == mark * 3)
                || (board[2][0] + board[2][1] + board[2][2] == mark * 3)
                || (board[0][0] + board[1][0] + board[2][0] == mark * 3)
                || (board[0][1] + board[1][1] + board[2][1] == mark * 3)
                || (board[0][2] + board[1][2] + board[2][2] == mark * 3)
                || (board[0][0] + board[1][1] + board[2][2] == mark * 3)
                || (board[2][0] + board[1][1] + board[0][2] == mark * 3));
    }

    public boolean isDraw() {
        for (int[] row : this.board) {
            for (int ele : row) {
                if (ele == this.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public Result checkResult(int mark) {
        if (isWin(mark)) {
            return Result.WIN;
        } else if (isDraw()) return Result.DRAW;
        else return Result.NONE;
    }
}
