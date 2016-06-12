import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class ChessGame {
	public static void main(String[] args) {
		BoardManager board = new BoardManager();
		 
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
			String input;
			String currColorStr = "WHITE";
			Color currColor = Color.WHITE;
			boolean currColorWhite = true;
			int move = 1;
			board.printBoard();
			println("Move " + move + ", " + currColorStr + "'s turn to move.");
			println("Move format: pos1-pos2 (lowercase character for column, number for row, e.g. e2-e4).");
			while((input=br.readLine()) != null && !board.isCheckmateOn(currColor)){
				if (movePiece(input, board)) {
					println(move + (currColorWhite ? "." : "...") + input + "\n");
					currColorWhite = !currColorWhite;
					currColor = currColorWhite ? Color.WHITE : Color.BLACK;
					if (currColorWhite) {
						move++;
					}
					currColorStr = currColorWhite ? "WHITE" : "BLACK";
					board.printBoard();
					println("Move " + move + ", " + currColorStr + "'s turn to move.");
				} else {
					println(input + " is an invalid move!\n");
				}
			}
				
		} catch(IOException io) {
			io.printStackTrace();
		}	
	}
	
	// Returns true iff move was successful
	public static boolean movePiece(String input, BoardManager board) {
		String[] positions;
		// a1-e8 format
		if (Pattern.matches("^[a-h][1-9]-[a-h][1-9]$", input)) {
			positions = input.split("-");
			int srcRow = mapToRow(positions[0].charAt(1));
			int srcCol = mapToCol(positions[0].charAt(0));
			int destRow = mapToRow(positions[1].charAt(1));
			int destCol = mapToCol(positions[1].charAt(0));
			Position src = board.positions[srcRow][srcCol];
			Position dest = board.positions[destRow][destCol];
			if (board.validMove(src, dest)) {
				board.movePiece(src, dest);
				return true; //successful move
			}
		}
		return false; //bad move
	}
	
	public static int mapToCol(char c) {
		int col = c - 97; //'a' == 97
		if (0<=col && col<8) {
			return col;
		}
		return -1;
	}
	
	//1 -> 7, ..., 8->0
	public static int mapToRow(char c) {
		int row = c - 49; //'1' == 49, 1 -> 0
		row = Math.abs(7-row); // 0 -> 7
		if (0<=row && row<8) {
			return row; 
		}
		return -1;
	}
	
	private void promotePawn(BoardManager b, Color c, PieceType t, Position p) {
		Piece promoted = new Piece(c, t, p);
		if (b.replacePieceAt(promoted, p) == null) {
			throw new IllegalArgumentException();
		}
	}
	
	private static void println(String s) {
		System.out.println(s);
	}
	
	private static void print(String s) {
		System.out.print(s);
	}
}
