//
//public class Color {
//	public static final int WHITE = 0;
//	public static final int BLACK = 1;
//}

public enum Color {
	WHITE(0), BLACK(1);
	
	public final int index;
	Color(int i) {
		index = i;
	}
}
