package autotapper;

public class Response {
	
	private boolean isCastable;
	private Board board;

	public Response(boolean isCastable, Board board) {
		this.isCastable = isCastable;
		this.board = board;
	}
	
	@Override
	public String toString() {
		return "Can Cast: "+ isCastable +" " + board;
	}
}
