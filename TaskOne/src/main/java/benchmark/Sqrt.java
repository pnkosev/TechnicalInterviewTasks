package benchmark;

import org.openjdk.jmh.annotations.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 5, time = 1)
@OutputTimeUnit(TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1)
public class Sqrt {

    @Param({
            "1296", "255025", "60481729", "1111088889", "620608357369", // perfect square numbers
            "3333", "753951", "86542971", "1111111111", "564792498315" // non-perfect square numbers
    })
    long value;

    @Benchmark
    public double mathUtilSqrt() {
        return Math.sqrt(value);
    }

    @Benchmark
    public double customSqrt() {
        return sqrt(value);
    }

    private double sqrt(long a) {
        if (a == 0 || a == 1) {
            return a;
        }

        double result = 0;

        for (double i = 1; i < a; i += 0.00001) {
            if (i * i >= a - 0.00002) {
                result = i;
                break;
            }
        }

        return new BigDecimal(result).setScale(5, RoundingMode.HALF_DOWN).doubleValue();
    }
}
