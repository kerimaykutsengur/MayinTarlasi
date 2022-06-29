import java.util.Random;
import java.util.Scanner;


public class MineSweeper {
    int rowNumber;
    int colNumber;
    int[][] map;
    int[][] board;

    boolean game = true;

    int size;
    Random rand = new Random();
    Scanner input = new Scanner(System.in);

    MineSweeper(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
        this.size = rowNumber * colNumber;
    }

    public void run() {
        int row, col, success = 0;
        preGame();
        print(map);
        System.out.println("Oyun Başladı !");
        while (game) {
            print(board);
            System.out.print("Satır :");
            row = input.nextInt();
            System.out.print("Sütun :");
            col = input.nextInt();
            if (row < 0 || row >= rowNumber) {
                System.out.println("Geçersiz koordinat girdiniz !");
            }
            if (col < 0 || col >= colNumber) {
                System.out.println("Geçersiz koordinat girdiniz !");
            }

            if (map[row][col] != -1) {
                checkMine(row, col);
                success++;
                if (success == (size - (size / 4))) {
                    System.out.println("Başardınız !");
                    break;
                }
            } else {
                game = false;
                System.out.println("Game Over !");
            }


        }
    }

    public void checkMine(int r, int c) {
        if (map[r][c] == 0) {
            if ((c < colNumber - 1) && (map[r][c + 1] == -1)) {
                board[r][c]++;
            }
            if ((r < rowNumber - 3) && (map[r + 1][c] == -1)) {
                board[r][c]++;
            }
            if ((r > 0) && (map[r - 1][c] == -1)) {
                board[r][c]++;
            }
            if ((c > 0) && (map[r][c - 1] == -1)) {
                board[r][c]++;
            }
            if (board[r][c] == 0) {
                board[r][c] = -2;
            }
        }

    }

    public void preGame() {
        int randRow, randCol, count = 0;
        while (count != (size / 4)) {
            randRow = rand.nextInt(rowNumber);
            randCol = rand.nextInt(colNumber);
            if (map[randRow][randRow] != -1) {
                map[randRow][randCol] = -1;
                count++;
            }
        }
    }

    public void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }

}
