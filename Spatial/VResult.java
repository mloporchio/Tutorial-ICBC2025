import java.util.List;

/**
* This class represents the output of the spatial verification algorithm.
* This object contains the result set of the query, the minimum bounding
* rectangle of the root of the Merkle R-tree index and the digest of the node,
* all reconstructed from the verification object.
*
* @author Matteo Loporchio
*/
public class VResult {
  /**
  * This is the result set of the query.
  */
  private List<Point> content;

  /**
  * This is the minimum bounding rectangle of the reconstructed root node.
  */
  private Rectangle MBR;

  /**
  * This is the hash value of the reconstructed root node.
  */
  private byte[] hash;

  /**
  * This constructor builds an empty <code>VResult</code> object.
  */
  public VResult() {
    this.content = null;
    this.MBR = null;
    this.hash = null;
  }

  /**
  * This is the default constructor for the <code>VResult</code> class.
  * @param content the result set
  * @param MBR the bounding rectangle of the root
  * @param hash the digest of the root
  */
  public VResult(List<Point> content, Rectangle MBR, byte[] hash) {
    this.content = content;
    this.MBR = MBR;
    this.hash = hash;
  }

  /**
  * Returns the reconstructed result set.
  * @return the reconstructed result set
  */
  public List<Point> getContent() {
    return content;
  }

  /**
  * Returns the reconstructed bounding rectangle for the Merkle R-tree root.
  * @return the minimum bounding rectangle for the reconstructed root
  */
  public Rectangle getMBR() {
    return MBR;
  }

  /**
  * Returns the reconstructed digest for the Merkle R-tree root.
  * @return the hash value of the reconstructed Merkle R-tree root node
  */
  public byte[] getHash() {
    return hash;
  }
}
