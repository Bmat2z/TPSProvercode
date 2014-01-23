package student.provided;

public class CartesianPoint extends OrderedPair<Integer> {
	public CartesianPoint(int x, int y) {
		super(x, y);
	}

	@Override
	public int hashCode() {
		return x * y;
	}

	@Override
	public boolean equals(Object obj) {
		CartesianPoint other = null;
		try {
			other = (CartesianPoint) obj;
		} catch (ClassCastException e) {
			System.err.println("Class cast!");
			return false;
		}

		return other.x == this.x && other.y == this.y;
	}

	public CartesianPoint up() {
		return new CartesianPoint(x, y + 1);
	}

	public CartesianPoint down() {
		return new CartesianPoint(x, y - 1);
	}

	public CartesianPoint left() {
		return new CartesianPoint(x - 1, y);
	}

	public CartesianPoint right() {
		return new CartesianPoint(x + 1, y);
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
