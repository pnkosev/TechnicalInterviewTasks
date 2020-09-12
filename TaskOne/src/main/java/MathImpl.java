import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathImpl implements Math {

    @Override
    public int multiply(int a, int b) {
        if (isZero(a) || isZero(b)) {
            return 0;
        }

        boolean isResultNegative = isResultNegative(a, b);

        a = a > 0 ? a : makePositiveOutOfNegativeInt(a);
        b = b > 0 ? b : makePositiveOutOfNegativeInt(b);

        int result = 0;
        int smallerNumber = a < b ? a : b;
        int biggerNumber = smallerNumber == a ? b : a;

        for (int i = 0; i < smallerNumber; i++) {
            result += biggerNumber;
        }

        return isResultNegative ? -result : result;
    }

    @Override
    public int divide(int a, int b) {
        if (isZero(a)) {
            return 0;
        }

        if (b == 0) {
            throw new ArithmeticException();
        }

        boolean isResultNegative = isResultNegative(a, b);

        a = a > 0 ? a : makePositiveOutOfNegativeInt(a);
        b = b > 0 ? b : makePositiveOutOfNegativeInt(b);

        int result = 0;

        while (a > b && (a -= b) > 0) {
            result++;
        }

        return isResultNegative ? -result : result;
    }

    @Override
    public double sqrt(int a) {
        if (a == 0 || a == 1) {
            return a;
        }

        double result = 0;

        double startingNumber = getMinimumInitialNumber(String.valueOf(a).length());
        startingNumber = increaseNumber(startingNumber, a);

        for (double i = startingNumber; i < a; i += 0.00001) {
            if (i * i >= a - 0.00002) {
                result = i;
                break;
            }
        }

        return new BigDecimal(result).setScale(5, RoundingMode.HALF_DOWN).doubleValue();
    }

    private double increaseNumber(double number, int target) {
        number *= 1.1;

        if (number * number > target) {
            return number * 0.9;
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

    private boolean isZero(int num) {
        return num == 0;
    }

    private boolean isResultNegative(int a, int b) {
        return (a < 0 && b > 0) || (a > 0 && b < 0);
    }

    private int makePositiveOutOfNegativeInt(int negative) {
        return -negative;
    }
}
