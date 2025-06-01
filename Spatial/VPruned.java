/**
* This kind of verification object is generated during the visit of a
* pruned internal node.
*
* @author Matteo Loporchio
*/
public class VPruned implements VObject {

  /**
  * This is the bounding rectangle of the pruned node.
  */
  private Rectangle MBR;

  /**
  * This is the digest of the pruned node.
  */
  private byte[] hash;

  /**
  * This constructor builds a new pruned verification object.
  * @param MBR the bounding rectangle of the pruned node
  * @param hash the digest of the pruned node
  */
  public VPruned(Rectangle MBR, byte[] hash) {
    this.MBR = MBR;
    this.hash = hash;
  }

  /**
  * Returns the bounding rectangle associated to the pruned verification object.
  * @return the bounding rectangle of the verification object
  */
  public Rectangle getMBR() {
    return MBR;
  }

  /**
  * Returns the digest of the pruned verification object.
  * @return the hash value of the pruned verification object
  */
  public byte[] getHash() {
    return hash;
  }
}
