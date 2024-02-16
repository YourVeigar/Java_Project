package dop;

public class Main {
    public static void main(String[] args) {
        MyData myData = new MyData();

        Board board = new Board(myData);
        board.printData();
    }
}
