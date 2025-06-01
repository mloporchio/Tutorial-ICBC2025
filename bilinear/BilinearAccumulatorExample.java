import java.io.BufferedReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.cryptimeleon.math.structures.groups.GroupElement;
import org.cryptimeleon.math.structures.groups.elliptic.*;
import org.cryptimeleon.math.structures.groups.elliptic.type3.bn.BarretoNaehrigBilinearGroup;
import org.cryptimeleon.craco.accumulator.nguyen.*;
import org.cryptimeleon.math.structures.rings.zn.*;

/**
 * This example demonstrates the use of the Nguyen Accumulator Scheme with a Barreto-Naehrig bilinear group.
 * This example creates an accumulator from a given set of integers and generates a witness for one of the integers.  
 * @author Matteo Loporchio
 */
public class BilinearAccumulatorExample {
    /**
     * The maximum number of elements that can be inserted into the accumulator.
     * This value should be set according to the specific use case and security requirements.
     */
    public static final int maxElements = 1024;

    /**
     * Path of the input file containing values to be inserted into the accumulator.
     */
    public static final String inputFile = "data/values.txt";

    public static void main(String[] args) {
        /**
         * Initialize the Barreto-Naehrig bilinear group and the Zn ring.
         * The group is used for the cryptographic operations in the Nguyen Accumulator Scheme.
         *
         * A security parameter of 100 means the adversary has no more than a 2^(-100) chance 
         * of breaking the accumulator security.
         */
        BilinearGroup bilinearGroup = new BarretoNaehrigBilinearGroup(100);

        /**
         * This initializes the Zn ring (ring of integers modulo n)
         * where n is chosen to be the order of the pairing source group G1.
         * The values to be inserted in the accumulator are hashed into this ring.
         */
        Zn zp = bilinearGroup.getZn();
        HashIntoZn hash = new HashIntoZn(zp);

        /**
         * Read the list of integers from file and insert them into the accumulator.
         * These integers are hashed into the Zn ring before being added to the accumulator.
         */
        List<Zn.ZnElement> hashedValues = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                BigInteger v = new BigInteger(line.trim());
                hashedValues.add(hash.hash(v.toByteArray()));
            }
        } catch (Exception e) {
            System.err.println("Error reading input file: " + e.getMessage());
            System.exit(1);
        }

        /**
         * Create the Nguyen Accumulator Scheme with the specified bilinear group and maximum number of elements.
         * The scheme is initialized with the hashed values.
         */
        NguyenAccumulatorScheme scheme = NguyenAccumulatorScheme.setup(bilinearGroup, maxElements);
        NguyenDigest digest = scheme.createDigest(hashedValues);
        System.out.println("Accumulator value: " + digest.getRepresentation().toString());

        /**
         * Generate a witness for the integer 24006.
         * The witness is created using the digest and the hashed values.
         * The witness allows verification that 24006 is indeed part of the accumulator.
         */
        NguyenWitness witness = scheme.createWitness(digest, hashedValues, hash.hash(BigInteger.valueOf(24006).toByteArray()));
        System.out.println("Witness for 24006: " + witness.getRepresentation().toString());
    }
}
