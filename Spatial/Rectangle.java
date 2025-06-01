/**
* This class represents a rectangle, a 2D element which
* is characterized by its lower-left and upper-right vertices.
*
* @author Matteo Loporchio
*/
public class Rectangle implements Comparable<Rectangle> {
	/**
	* The x-coordinate of the lower-left vertex.
	*/
	public final long lx;

	/**
	* The y-coordinate of the lower-left vertex.
	*/
	public final long ly;

	/**
	* The x-coordinate of the upper-right vertex.
	*/
	public final long ux;

	/**
	*	The y-coordinate of the upper-right vertex.
	*/
	public final long uy;

	/**
	*	The default rectangle constructor.
	*	@param lx x-coordinate of the lower-left vertex
	*	@param ly y-coordinate of the lower-left vertex
	*	@param ux x-coordinate of the upper-right vertex
	*	@param uy y-coordinate of the upper-right vertex
	*/
	public Rectangle(long lx, long ly, long ux, long uy) {
		this.lx = lx;
		this.ly = ly;
		this.ux = ux;
		this.uy = uy;
	}

	/**
	*	Computes the width of the rectangle.
	*	@return the rectangle width
	*/
	public double getWidth() {
		return ux-lx;
	}

	/**
	*	Computes the height of the rectangle.
	*	@return the rectangle height
	*/
	public double getHeight() {
		return uy-ly;
	}

	/**
	*	Computes the area of the rectangle.
	* @return the rectangle area
	*/
	public double getArea() {
		return (ux-lx)*(uy-ly);
	}

	/**
	*	Comparison function for rectangles.
	*	To compare two rectangles, we just compare their lower-left vertices.
	* @param r rectangle to be compared with the current one
	* @return an integer
	*/
	public int compareTo(Rectangle r) {
		int s = Long.compare(this.lx, r.lx);
		return ((s != 0) ? s : Long.compare(this.ly, r.ly));
	}

	/**
	*	Prints a human-readable string representing the rectangle.
	* @return a string representing the rectangle
	*/
	public String toString() {
		return "(" + this.lx + "," + this.ly + "," + this.ux + "," + this.uy + ")";
	}
}
