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

    public double sqrt(long number) {
        if (number == 0 || number == 1) {
            return number;
        }

        String numberAsString = String.valueOf(number);
        double startingNumber = getMinimumInitialNumber(numberAsString.length());
        startingNumber = increaseNumberAccordingToFirstDigit(startingNumber, numberAsString.substring(0, 1));
        startingNumber = increaseNumber(startingNumber, number);

        double result = 0;

        for (double i = startingNumber; i < number; i += 0.00001) {
            if (i * i >= number - 0.00001) {
                result = i;
                break;
            }
        }

        return new BigDecimal(result).setScale(5, RoundingMode.HALF_DOWN).doubleValue();
    }

    private double increaseNumberAccordingToFirstDigit(double number, String firstDigit) {
        switch (firstDigit) {
            case "2":
                return number * 1.41;
            case "3":
                return number * 1.73;
            case "4":
                return number * 2;
            case "5":
                return number * 2.23;
            case "6":
                return number * 2.44;
            case "7":
                return number * 2.64;
            case "8":
                return number * 2.82;
            case "9":
                return number * 3;
            default:
                return number;
        }
    }

    private double increaseNumber(double number, long target) {
        number *= 1.00001;

        if (number * number > target) {
            return number * 0.99999;
        }

        return increaseNumber(number, target);
    }

    private double getMinimumInitialNumber(int length) {
        if (length == 1 || length == 2) {
            return 1;
        }

        double oddResult = 10;
        double evenResult = 31.62277660168379;

        if (length % 2 == 1) {
            for (int i = (length - 3) / 2; i > 0; i--) {
                oddResult *= 10;
            }
            return oddResult;
        } else {
            for (int i = (length - 4) / 2; i > 0; i--) {
                evenResult *= 10;
            }
            return evenResult;
        }
    }
}
