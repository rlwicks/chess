import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BoardManager {
	public Position[][] positions;
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
	//Indexed: 0=white, 1=black
	public List<Piece> kings;
	public List<Set<Piece>> pieces;
	
	/*
	 * Things to keep synced:
	 * board Piece[][]
	 * kings List<Piece>
	 * pieces List<Set<Piece>>
	 * indiv piece Position w/ index of position in board
	 */
	
	public BoardManager() {
		positions = new Position[][]{
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
				new Piece(Color.BLACK, PieceType.ROOK, positions[0][0]),
				new Piece(Color.BLACK, PieceType.KNIGHT, positions[0][1]),
				new Piece(Color.BLACK, PieceType.BISHOP, positions[0][2]),
				new Piece(Color.BLACK, PieceType.QUEEN, positions[0][3]),
				new Piece(Color.BLACK, PieceType.KING, positions[0][4]),
				new Piece(Color.BLACK, PieceType.BISHOP, positions[0][5]),
				new Piece(Color.BLACK, PieceType.KNIGHT, positions[0][6]),
				new Piece(Color.BLACK, PieceType.ROOK, positions[0][7]),
			},
			//Second top row black
			{
				new Piece(Color.BLACK, PieceType.PAWN, positions[1][0]),
				new Piece(Color.BLACK, PieceType.PAWN, positions[1][1]),
				new Piece(Color.BLACK, PieceType.PAWN, positions[1][2]),
				new Piece(Color.BLACK, PieceType.PAWN, positions[1][3]),
				new Piece(Color.BLACK, PieceType.PAWN, positions[1][4]),
				new Piece(Color.BLACK, PieceType.PAWN, positions[1][5]),
				new Piece(Color.BLACK, PieceType.PAWN, positions[1][6]),
				new Piece(Color.BLACK, PieceType.PAWN, positions[1][7]),
			},
			{null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null, null},
			//Second bot row white
			{
				new Piece(Color.WHITE, PieceType.PAWN, positions[6][0]),
				new Piece(Color.WHITE, PieceType.PAWN, positions[6][1]),
				new Piece(Color.WHITE, PieceType.PAWN, positions[6][2]),
				new Piece(Color.WHITE, PieceType.PAWN, positions[6][3]),
				new Piece(Color.WHITE, PieceType.PAWN, positions[6][4]),
				new Piece(Color.WHITE, PieceType.PAWN, positions[6][5]),
				new Piece(Color.WHITE, PieceType.PAWN, positions[6][6]),
				new Piece(Color.WHITE, PieceType.PAWN, positions[6][7]),
			},
			//Bot row white
			{
				new Piece(Color.WHITE, PieceType.ROOK, positions[7][0]), //bottom left corner
				new Piece(Color.WHITE, PieceType.KNIGHT, positions[7][1]),
				new Piece(Color.WHITE, PieceType.BISHOP, positions[7][2]),
				new Piece(Color.WHITE, PieceType.QUEEN, positions[7][3]),
				new Piece(Color.WHITE, PieceType.KING, positions[7][4]),
				new Piece(Color.WHITE, PieceType.BISHOP, positions[7][5]),
				new Piece(Color.WHITE, PieceType.KNIGHT, positions[7][6]),
				new Piece(Color.WHITE, PieceType.ROOK, positions[7][7]),
			},
		};
		kings = new ArrayList<Piece>(2);
		kings.add(board[7][4]);
		kings.add(board[0][4]);
		pieces = new ArrayList<Set<Piece>>();
		pieces.add(new HashSet<Piece>());
		for(int i=7; i>=6; i--) {
			for (int j=0; j<8; j++) {
				pieces.get(Color.WHITE.index).add(board[i][j]);
			}
		}
		pieces.add(new HashSet<Piece>());
		for(int i=0; i<=1; i++) {
			for (int j=0; j<8; j++) {
				pieces.get(Color.BLACK.index).add(board[i][j]);
			}
		}
	}

	// Returns the pieces attacking the king of color c
	public Set<Piece> kingAttackers(Color c) {
		Piece king = kings.get(c.index);
		return null;
	}
	
	// Checks if the given color's king is checkmated
	public boolean isCheckmateOn(Color color) {
		return false;
	}
	
//	public boolean validMove(String move) {
//		return true;
//	}
	
	public boolean validMove(Position src, Position dest) {
		return true;
	}
	
	// Moves the piece at src to dest, returns what used to be at dest (was taken)
	// Pre: this move is valid
	public Piece movePiece(Position src, Position dest) {
		//TODO: special case promotion
		Piece moved = removePieceAt(src);
		if (moved == null) {
			throw new IllegalArgumentException();
		}
		return replacePieceAt(moved, dest);
	}
	
	// Puts piece at dest, returns what used to be at dest (was taken)
	// Returns true if we replaced a piece, false if put on empty square
	public Piece replacePieceAt(Piece newPiece, Position dest) {
		Piece oldPiece = removePieceAt(dest);
		placePieceAt(newPiece, dest);
		return oldPiece;
	}
	
	// Returns the piece that used to be at src
	public Piece removePieceAt(Position src) {
		Piece removed = board[src.row][src.col];
		if (removed != null) {
			board[src.row][src.col] = null;
			pieces.get(removed.color.index).remove(removed);
			removed.pos = null;
			if (removed.type == PieceType.KING) {
				kings.set(removed.color.index, null);
			}
		}
		return removed;
	}
	
	// Places the given piece 
	// Pre: dest is empty pos
	public void placePieceAt(Piece piece, Position dest) {
		board[dest.row][dest.col] = piece;
		pieces.get(piece.color.index).add(piece);
		piece.pos = positions[dest.row][dest.col];
		if (piece.type == PieceType.KING) {
			kings.set(piece.color.index, piece);
		}
	}
	
	// A piece's valid moves relative to movement clauses and blocking check and color
	public Set<Position> validMovesFrom(Position p, Color c) {
		return null;
	}
	
	// A color's valid moves (also taking checks into account)
	public Set<Position> validMoves(Color c) {
		return null;
	}
	
	// Pos = white winning
	// Neg = black winning
	public double utility() {
		if (isCheckmateOn(Color.BLACK)) {
			return Double.MIN_VALUE;
		} else if(isCheckmateOn(Color.WHITE)) {
			return Double.MAX_VALUE;
		}
		return pieceValueOf(Color.WHITE) - pieceValueOf(Color.BLACK);
	}
	
	// Total piece value for the given color
	private double pieceValueOf(Color c) {
		double val = 0;
		for (Piece p : pieces.get(c.index)) {
			val += p.value();
		}
		return val;
	}
	
	public String toString() {
		String horizSpace = " ";
		String border = "----------";
		String s = horizSpace + "  BLACK  \n";
		s += horizSpace + border + "\n";
		for(int i=0; i<8; i++) {
			s += Math.abs(8-i) + "|";
			for(int j=0; j<8; j++) {
				if (board[i][j] == null) {
					s += " ";
				} else {
					s += board[i][j];
				}
				//s+="|";
			}
			s += "|\n";
		}
		s += horizSpace + border + "\n";
		s += horizSpace + " abcdefgh\n";
		s += horizSpace + "  WHITE  \n";
		return s;
	}
	
	public void printBoard() {
		print(toString() + "\n");
	}
	
	private static void print(String s) {
		System.out.print(s);
	}
}
