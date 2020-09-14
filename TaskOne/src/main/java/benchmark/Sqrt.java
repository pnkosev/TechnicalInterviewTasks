package benchmark;

import org.openjdk.jmh.annotations.*;
import service.MathService;
import service.MathServiceImpl;

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

    MathService mathService = new MathServiceImpl();

    @Benchmark
    public double mathUtilSqrt() {
        return Math.sqrt(value);
    }

    @Benchmark
    public double customSqrt() { return mathService.sqrt(value); }

    @Benchmark
    public double customSqrtWentTooFar() {
        return mathService.sqrtWentTooFar(value);
    }
}
