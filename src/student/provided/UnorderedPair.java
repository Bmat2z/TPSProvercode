package student.provided;

public class UnorderedPair<T> {
	private T one, another;
	
	public UnorderedPair(T one, T another) {
		this.one = one;
		this.another = another;
	}
	
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		UnorderedPair<T> other = null;
		try {
			other = (UnorderedPair<T>) obj;
		} catch (ClassCastException e) {
			return false;
		}
		
		return (one.equals(other.one) && another.equals(other.another)) || (another.equals(other.one) && one.equals(other.another));
	};
	
	@Override
	public int hashCode() {
		return one.hashCode() * another.hashCode();
	}
	
	@Override
	public String toString() {
		return "{" + one + ", " + another + "}";
	}
}
