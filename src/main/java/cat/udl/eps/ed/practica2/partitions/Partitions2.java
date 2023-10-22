package cat.udl.eps.ed.practica2.partitions;

import cat.udl.eps.ed.practica2.stack.LinkedStack;

public class Partitions2 {

    /**
     * Returns the number of partitions of n using a recursive algorithm.
     *
     * @param n the number to be partitioned
     * @return the number of partitions of n
     */
    public static int partitionsRec(int n) {
        assert n > 0;
        // all terms in any partition are >= 1
        return partitionsRec(n, 1);
    }

    private static int partitionsRec(int n, int minAddend) {
        // numPartitions where min term is >= minAddend
        assert n > 0 && minAddend > 0;
        if (minAddend > n) {
            return 0;
        } else if (minAddend == n) {
            return 1;
        } else {
            return partitionsRec(n - minAddend, minAddend)     // Min term is = minAddend
                    + partitionsRec(n, minAddend + 1); // Min term is > minAddend
        }
    }

    /**
     * Returns the number of partitions of n using an iterative algorithm.
     * <p>
     * The algorithm uses a stack to simulate the recursive calls and is the
     * result of applying the transformation to the recursive one.
     *
     * @param n the number to be partitioned
     * @return the number of partitions of n
     */
    public static int partitionsIter(int n) {
        assert n > 0;
        return partitionsIter(n, 1);
    }

    private static int partitionsIter(int n, int minAddend) {
        assert n > 0 && minAddend > 0;
        throw new UnsupportedOperationException("Not implemented");
    }
}
