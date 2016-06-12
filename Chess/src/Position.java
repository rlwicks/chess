
public class Position {
	public final int col;
	public final int row;
	
	// Of the form 0-7, 0-7
	public Position(int r, int c) {
		row = r;
		col = c;
	}
	
	// Of the form a1-e8
	public Position(String s) {
		col = s.charAt(0) - 97; //map a-e to 0-7
		row = s.charAt(1) - 1; //map 1-8 to 0-7
	}
	
	public String toString() {
		return col + " " + row;
	}
}
