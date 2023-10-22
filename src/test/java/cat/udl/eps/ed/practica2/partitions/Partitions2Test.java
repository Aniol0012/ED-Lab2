package cat.udl.eps.ed.practica2.partitions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Partitions2Test {

    @ParameterizedTest(name = "partitionsRec({0}) should be {1}")
    @CsvSource(value = {"1,1", "2,2", "3,3", "4,5", "5,7", "6,11"})
    void simplePartitionsRec(int n, int expected) {
        assertEquals(expected, Partitions2.partitionsRec(n));
    }


    @ParameterizedTest(name = "partitionsIter({0}) should be {1}")
    @CsvSource(value = {"1,1", "2,2", "3,3", "4,5", "5,7", "6,11"})
    void simplePartitionsIter(int n, int expected) {
        assertEquals(expected, Partitions2.partitionsIter(n));
    }

    @Test
    void golden() {
        var errorFormat = "partitionsRec(%d) != partitionsIter(%d)";
        for (int sum = 1; sum <= 20; sum++) {
            var rec = Partitions2.partitionsRec(sum);
            var ite = Partitions2.partitionsIter(sum);
            assertEquals(rec, ite, errorFormat.formatted(rec, ite));
        }
    }

}
