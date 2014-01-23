package student.provided;

public class OrderedPair<T> {
	public T x, y;

	public OrderedPair(T x, T y) {
		this.x = x;
		this.y = y;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		OrderedPair<T> other = null;
		try {
			other = (OrderedPair<T>) obj;
		} catch (ClassCastException e) {
			System.err.println("Class cast!");
			return false;
		}

		return other.x == this.x && other.y == this.y;
	}
}