package tdd;

public class main_tdd {
    public static void main(String[] args) {
        Board board = new Board();
        board.add("G");
		board.add("R");
		String cardManaCost = "1G";

        System.out.println(Autotapper.tapper(board, cardManaCost));
    }
}
