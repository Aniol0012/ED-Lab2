package cat.udl.eps.ed.practica2.partitions;

import cat.udl.eps.ed.practica2.stack.LinkedStack;

public class Partitions2 {
    private static class Context {
        final int n;
        int minAddend;
        int f1;
        int f2;
        EntryPoint entryPoint;

        public Context(int n, int minAddend) {
            this.n = n;
            this.f1 = 0;
            this.f2 = 0;
            this.minAddend = minAddend;
            this.entryPoint = EntryPoint.CALL;
        }
    }

    private enum EntryPoint {
        CALL, RESUME1, RESUME2
    }

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

    @SuppressWarnings("all")
    private static int partitionsIter(int n, int minAddend) {
        assert n > 0 && minAddend > 0;
        int return_ = 0;
        var stack = new LinkedStack<Context>();
        stack.push(new Context(n, minAddend));
        while (!stack.isEmpty()) {
            var context = stack.top();
            switch (context.entryPoint) {
                case CALL -> {
                    if (context.n == context.minAddend) {
                        return_ = 1;
                        stack.pop();
                    } else if (context.n < context.minAddend) {
                        return_ = 0;
                        stack.pop();
                    } else {
                        context.entryPoint = EntryPoint.RESUME1;
                        stack.push(new Context(context.n - context.minAddend, context.minAddend));
                    }
                }
                case RESUME1 -> {
                    context.f1 = return_;
                    context.entryPoint = EntryPoint.RESUME2;
                    stack.push(new Context(context.n, context.minAddend + 1));
                }
                case RESUME2 -> {
                    context.f2 = return_;
                    return_ = context.f1 + context.f2;
                    stack.pop();
                }
            }
        }
        return return_;
    }
}