import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.cryptimeleon.math.structures.groups.GroupElement;
import org.cryptimeleon.math.structures.groups.elliptic.*;
import org.cryptimeleon.math.structures.groups.elliptic.type3.bn.BarretoNaehrigBilinearGroup;

import org.cryptimeleon.craco.accumulator.nguyen.*;

import org.cryptimeleon.math.structures.rings.zn.*;

public class Example {
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
