import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row;
        int column;
        System.out.println("Mayın Tarlasına Hoşgeldiniz !");
        System.out.println("Lütfen  oynamak istediğiniz boyutları giriniz !");
        System.out.print("Satır Sayısı :");
        row = input.nextInt();
        System.out.print("Sütun Sayısı :");
        column = input.nextInt();

        MineSweeper mine = new MineSweeper(row,column);
        mine.run();


    }


}
