import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is a test for the Merkle R-tree implementation.
 * It reads points from a file, builds a Merkle R-tree, performs a query,
 * and verifies the results.
 * 
 * Usage: java Test <inputFile>
 * where <inputFile> is the path to the input file containing point data.
 * 
 * @author Matteo Loporchio
 */
public class Test {
    public static final String inputFile = "";
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.printf("Usage: java %s <inputFile>\n", Test.class.getName());
            System.exit(1);
        }
        final String inputFile = args[0];
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line = br.readLine(); // Read the header line

            // Read the points from the file and insert them into a list.
            List<Point> points = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                long px = Long.parseLong(parts[5]);
                long py = Long.parseLong(parts[6]);
                Point p = new Point(px, py);
                points.add(p);
            }

            // Build a Merkle R-tree from the points.
            MRTreeNode root = MRTree.buildPacked(points, MRTree.DEFAULT_CAPACITY);
            // Print the root of the Merkle R-tree.
            System.out.println("Root of the Merkle R-tree: " + Hash.bytesToHex(root.getHash()));
            System.out.println("MBR of the Merkle R-tree: " + root.getMBR());

            // Query the Merkle R-tree and obtain the corresponding VO.
            VObject vo = Query.treeSearch(root, new Rectangle(132541507, 166069862, 132564546, 167823416));
            
            // Verify the results of the query.
            VResult vr = Query.verify(vo);

            // Print the number of records returned and the reconstructed root hash.
            System.out.println("Returned records: " + vr.getContent().size());
            System.out.println("Reconstructed hash: " + Hash.bytesToHex(vr.getHash()));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
