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
 * This example hashes a set of integers, creates an accumulator, and generates a witness for one of the integers.  
 * @author Matteo Loporchio
 */
public class Example {
    /**
     * The maximum number of elements that can be inserted into the accumulator.
     * This value should be set according to the specific use case and security requirements.
     */
    public static final int maxElements = 1024;

    public static void main(String[] args) {
        BilinearGroup bilinearGroup = new BarretoNaehrigBilinearGroup(100);
        Zn zp = bilinearGroup.getZn();
        HashIntoZn hash = new HashIntoZn(zp);

        List<BigInteger> values = new ArrayList<>();
        values.add(BigInteger.valueOf(1));
        values.add(BigInteger.valueOf(2));
        values.add(BigInteger.valueOf(5));

        List<Zn.ZnElement> hashedValues = new ArrayList<>();
        for (BigInteger v : values) hashedValues.add(hash.hash(v.toByteArray()));

        NguyenAccumulatorScheme scheme = NguyenAccumulatorScheme.setup(bilinearGroup, maxElements);
        NguyenDigest digest = scheme.createDigest(hashedValues);
        System.out.println("Accumulator value: " + digest.getRepresentation().toString());

        NguyenWitness witness = scheme.createWitness(digest, hashedValues, hash.hash(BigInteger.valueOf(2).toByteArray()));
        System.out.println("Witness for 2: " + witness.getRepresentation().toString());
    }
}
