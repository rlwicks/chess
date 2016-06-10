
public enum PieceType {
	PAWN("p"), ROOK("r"), KNIGHT("k"), BISHOP("b"), KING("k"), QUEEN("q");
	
	private final String toStr;
	PieceType(String s) {
		toStr = s;
	}
	
	public String toString() {
		return toStr;
	}
}
