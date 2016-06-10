import java.util.*;

public class Piece {
	public final Color color;
	public final PieceType type;
	public final Position pos;
	public Set<Position> reachablePos;
	
	public Piece(Color c, PieceType t, Position p) {
		color = c;
		type = t;
		pos = p;
	}
	
	public Set<Position> reachablePos() {
		new HashSet<Position>();
		return null;
	}
	
	public String toString() {
		String str;
		if (color == Color.BLACK) {
			str = type.toString().toLowerCase();
		} else {
			str = type.toString().toUpperCase();
		}
		return str;
	}
}
