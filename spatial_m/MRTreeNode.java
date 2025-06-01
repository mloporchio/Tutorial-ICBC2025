import java.util.*;

/**
*	This class implements a generic Merkle R-tree node, which can be
*	either a leaf or an internal node. Leaf nodes contain a set of records
*	while internal nodes contain a list of children.
*
* @author Matteo Loporchio
*/
public class MRTreeNode implements Comparable<MRTreeNode> {
	/**
	*	This is the minimum bounding rectangle of the node.
	*	It is obtained as the minimum bounding union of the rectangles of
	*	the children, or, in the case of a leaf, as the bounding rectangle
	*	of all points contained in the current node.
	*/
	private Rectangle MBR;

	/**
	* This is the digest of the node.
	*/
	private byte[] hash;

	/**
	*	This is a reference to the list of points contained in the node.
	*/
	private List<Point> data;

	/**
	*	This is the list of children for the current node.
	*/
	private List<MRTreeNode> children;

	/**
	*	This is the default constructor for the MRTreeNode class.
	*	@param MBR the minimum bounding rectangle of the node
	*	@param hash the digest of the node
	* @param data the list of points contained in the node (if it is a leaf)
	*	@param children the list of child nodes for the current node
	*	(in the case of an internal node)
	*/
	public MRTreeNode(Rectangle MBR, byte[] hash, List<Point> data,
	List<MRTreeNode> children) {
		this.MBR = MBR;
		this.hash = hash;
		this.data = data;
		this.children = children;
	}

	/**
	*	Returns the minimum bouding rectangle of the node.
	*	@return MBR of the node
	*/
	public Rectangle getMBR() {
		return MBR;
	}

	/**
	*	Returns the hash value of the node.
	*	@return hash value of the node
	*/
	public byte[] getHash() {
		return hash;
	}

	/**
	*	Returns the list of records contained in the node.
	* @return list of points in the node
	*/
	public List<Point> getData() {
		return data;
	}

	/**
	*	Returns the list of children of the node.
	*	@return list of children of the node
	*/
	public List<MRTreeNode> getChildren() {
		return children;
	}

	/**
	*	Determines whether the current node is a leaf or an internal one.
	*	@return true if and only if the current node is a leaf
	*/
	public boolean isLeaf() {
		return (data != null && children == null);
	}

	/**
	*	Comparison function.
	*	@param n node to be compared with the current one
	*	@return an integer
	*/
	public int compareTo(MRTreeNode n) {
		return MBR.compareTo(n.MBR);
	}

	/**
	*	Creates a new leaf node from a list of points.
	*	@param pts the list of points
	*	@return a leaf Merkle R-tree node
	*/
	public static MRTreeNode nodeFromPoints(List<Point> pts) {
		return new MRTreeNode(Geometry.MBR(pts), Hash.hashPoints(pts),
		pts, null);
	}

	/**
	*	Creates a new internal node from a list of child nodes.
	*	The new node is the parent of all these children.
	*	@param children the list of child nodes
	*	@return an internal Merkle R-tree node
	*/
	public static MRTreeNode nodeFromChildren(List<MRTreeNode> children) {
		// Take all the bounding rectangles of the children.
		List<Rectangle> rects = new ArrayList<Rectangle>();
		children.forEach((c) -> rects.add(c.getMBR()));
		return new MRTreeNode(Geometry.enlarge(rects), Hash.hashNode(children),
		null, children);
	}

}
