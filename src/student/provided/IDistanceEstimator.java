package student.provided;

/**
 * An interface for a type that can estimate the distance between two points in
 * some space.
 * 
 * For example, an <tt>IDistanceEstimator</tt> for <tt>String</tt> might report
 * the edit distance between the two strings, whereas an
 * <tt>IDistanceEstimator</tt> for some kind of cartesian coordinates could
 * report the euclidean or manhattan distance between them.
 * 
 * This interface is used by the Graph class to estimate unknown distances in
 * the graph during A*.
 * 
 * @param <PointType>
 *            The type of points between which the implementing class is able to
 *            estimate distances.
 */
public interface IDistanceEstimator<PointType> {
	/**
	 * Estimate the distance between two points.
	 * 
	 * @param a
	 *            One point
	 * @param b
	 *            Another point.
	 * @return The distance between the two points.
	 */
	public double estimateDistance(PointType a, PointType b);
}