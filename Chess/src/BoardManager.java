import java.util.Set;

public class BoardManager {
	public Position[][] pos;
	public Piece[][] board;
	//indices of all of these are [col][row] when looking at a chess board as:
	/* 			col
	 *   0 1 2 3 4 5 6 7
	 * 0
	 * 1
	 * 2
	 * 3
	 * 4
	 * 5
	 * 6
	 * 7
	 * row
	 */
	public Piece[] kings; //0=white, 1=black
	
	
	public BoardManager() {
		pos = new Position[][]{
			{new Position(0,0),new Position(0,1),new Position(0,2),new Position(0,3),new Position(0,4),new Position(0,5),new Position(0,6),new Position(0,7)},
			{new Position(1,0),new Position(1,1),new Position(1,2),new Position(1,3),new Position(1,4),new Position(1,5),new Position(1,6),new Position(1,7)},
			{new Position(2,0),new Position(2,1),new Position(2,2),new Position(2,3),new Position(2,4),new Position(2,5),new Position(2,6),new Position(2,7)},
			{new Position(3,0),new Position(3,1),new Position(3,2),new Position(3,3),new Position(3,4),new Position(3,5),new Position(3,6),new Position(3,7)},
			{new Position(4,0),new Position(4,1),new Position(4,2),new Position(4,3),new Position(4,4),new Position(4,5),new Position(4,6),new Position(4,7)},
			{new Position(5,0),new Position(5,1),new Position(5,2),new Position(5,3),new Position(5,4),new Position(5,5),new Position(5,6),new Position(5,7)},
			{new Position(6,0),new Position(6,1),new Position(6,2),new Position(6,3),new Position(6,4),new Position(6,5),new Position(6,6),new Position(6,7)},
			{new Position(7,0),new Position(7,1),new Position(7,2),new Position(7,3),new Position(7,4),new Position(7,5),new Position(7,6),new Position(7,7)},
		};
		board = new Piece[][]{
			//Top row black
			{
				new Piece(Color.BLACK, PieceType.ROOK, pos[0][0]),
				new Piece(Color.BLACK, PieceType.KNIGHT, pos[0][1]),
				new Piece(Color.BLACK, PieceType.BISHOP, pos[0][2]),
				new Piece(Color.BLACK, PieceType.QUEEN, pos[0][3]),
				new Piece(Color.BLACK, PieceType.KING, pos[0][4]),
				new Piece(Color.BLACK, PieceType.BISHOP, pos[0][5]),
				new Piece(Color.BLACK, PieceType.KNIGHT, pos[0][6]),
				new Piece(Color.BLACK, PieceType.ROOK, pos[0][7]),
			},
			//Second top row black
			{
				new Piece(Color.BLACK, PieceType.PAWN, pos[1][0]),
				new Piece(Color.BLACK, PieceType.PAWN, pos[1][1]),
				new Piece(Color.BLACK, PieceType.PAWN, pos[1][2]),
				new Piece(Color.BLACK, PieceType.PAWN, pos[1][3]),
				new Piece(Color.BLACK, PieceType.PAWN, pos[1][4]),
				new Piece(Color.BLACK, PieceType.PAWN, pos[1][5]),
				new Piece(Color.BLACK, PieceType.PAWN, pos[1][6]),
				new Piece(Color.BLACK, PieceType.PAWN, pos[1][7]),
			},
			{null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null},
			//Second top row white
			{
				new Piece(Color.WHITE, PieceType.PAWN, pos[6][0]),
				new Piece(Color.WHITE, PieceType.PAWN, pos[6][1]),
				new Piece(Color.WHITE, PieceType.PAWN, pos[6][2]),
				new Piece(Color.WHITE, PieceType.PAWN, pos[6][3]),
				new Piece(Color.WHITE, PieceType.PAWN, pos[6][4]),
				new Piece(Color.WHITE, PieceType.PAWN, pos[6][5]),
				new Piece(Color.WHITE, PieceType.PAWN, pos[6][6]),
				new Piece(Color.WHITE, PieceType.PAWN, pos[6][7]),
			},
			//Top row white
			{
				new Piece(Color.WHITE, PieceType.ROOK, pos[7][0]), //bottom left corner
				new Piece(Color.WHITE, PieceType.KNIGHT, pos[7][1]),
				new Piece(Color.WHITE, PieceType.BISHOP, pos[7][2]),
				new Piece(Color.WHITE, PieceType.QUEEN, pos[7][3]),
				new Piece(Color.WHITE, PieceType.KING, pos[7][4]),
				new Piece(Color.WHITE, PieceType.BISHOP, pos[7][5]),
				new Piece(Color.WHITE, PieceType.KNIGHT, pos[7][6]),
				new Piece(Color.WHITE, PieceType.ROOK, pos[7][7]),
			},
		};
		kings = new Piece[]{
			board[7][4], //white king
			board[0][4] //black king
		};
	}

	// Returns the pieces attacking the king of color c
	public Set<Piece> kingAttackers(Color c) {
		Piece king = kings[c.index];
		return null;
	}
	
	// Checks if the given color's king is checkmated
	public boolean isCheckmateOn(Color color) {
		return false;
	}
	
	// Returns true if we replaced a piece, false if put on empty square
	public boolean placePieceAtPosition(Piece piece, Position pos) {
		boolean squareNonEmpty = board[pos.row][pos.col]!=null;
		board[pos.row][pos.col] = piece;
		return squareNonEmpty;
	}
	
	// A piece's valid moves relative to movement clauses and blocking check and color
	public Set<Position> validMovesFrom(Position p, Color c) {
		return null;
	}
	
	// A color's valid moves (also taking checks into account)
	public Set<Position> validMoves(Color c) {
		return null;
	}
	
	public String toString() {
		String s = "  BLACK  \n";
		s += "---------\n";
		for(int i=0; i<8; i++) {
			s += "|";
			for(int j=0; j<8; j++) {
				if (board[i][j] == null) {
					s += " ";
				} else {
					s += board[i][j];
				}
				//s+="|";
			}
			s = s.substring(0, s.length() - 1);
			s += "|\n";
		}
		s += "---------\n";
		s += "  WHITE  \n";
		return s;
	}
	
	public void printBoard() {
		print(toString() + "\n");
	}
	
	private static void print(String s) {
		System.out.print(s);
	}
}
