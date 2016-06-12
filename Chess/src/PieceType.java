import java.util.HashSet;
import java.util.Set;

public enum PieceType {
	PAWN("p", 1), ROOK("r", 5), KNIGHT("n", 3), BISHOP("b", 3), KING("k", Integer.MAX_VALUE), QUEEN("q", 9);
	
	public final String str;
	public final int val;
	
	PieceType(String s, int v) {
		str = s;
		val = v;
	}
	
	public String toString() {
		return str;
	}
	
	public Set<Position> movementRange(Position pos) {
		Set<Position> range = new HashSet<Position>();
		switch (this) {
			case PAWN: 
				break;
			case ROOK:
				break;
			case KNIGHT:
				break;
			case BISHOP:
				break;
			case KING:
				break;
			case QUEEN:
				break;
			default:
				range = null;
				break;
		}
		return range;
	}
}
