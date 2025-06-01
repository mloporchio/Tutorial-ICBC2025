/**
* This class represents a 2D point, our basic geometric entity.
* The point is characterized by its x and y coordinates.
*
* @author Matteo Loporchio
*/
public class Point implements Comparable<Point> {
	/**
	*	The x-coordinate of the point.
	*/
	public final long x;

	/**
	*	The y-coordinate of the point.
	*/
	public final long y;

	/**
	*	Constructs a new point given its coordinates.
	*	@param x the x-coordinate of the point
	*	@param y the y-coordinate of the point
	*/
	public Point(long x, long y) {
		this.x = x;
		this.y = y;
	}

	/**
	*	Comparison function.
	*	@param p the point to be compared with the current one
	*	@return an integer representing the result of the comparison
	*/
	public int compareTo(Point p) {
		int s = Long.compare(this.x, p.x);
		return ((s != 0) ? s : Long.compare(this.y, p.y));
	}

	/**
	*	Prints a human-readable string representing the point.
	*	@return a string representing the point
	*/
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
}
