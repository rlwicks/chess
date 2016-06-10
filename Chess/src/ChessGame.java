
public class ChessGame {
	public static void main(String[] args) {
		BoardManager b = new BoardManager();
		b.printBoard();
	
	}
	
	private void promotePawn(BoardManager b, Color c, PieceType t, Position p) {
		Piece promoted = new Piece(c, t, p);
		if (!b.placePieceAtPosition(promoted, p)) {
			throw new IllegalArgumentException();
		}
	}
}
