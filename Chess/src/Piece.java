import java.util.*;

public class Piece {
	public final Color color;
	public final PieceType type;
	public Position pos;
	public Set<Position> reachablePos;
	
	public Piece(Color c, PieceType t, Position p) {
		color = c;
		type = t;
		pos = p;
	}
	
	public Set<Position> movementRange() {
		Set<Position> range = new HashSet<Position>();
		return range;
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
	
	public double value() {
		return pieceValue() + mobilityValue();
	}
	
	private double pieceValue() {
		return type.val;
	}
	
	// Todo: more mobile pieces get higher value
	public double mobilityValue() {
		double mobilityFactor = 0; //TODO: calc factor in range [0, 1]
		return mobilityFactor * 1.0/5 * pieceValue();
	}
}
