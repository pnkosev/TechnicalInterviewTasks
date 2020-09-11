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

        for (double i = 1; i < a; i += 0.00001) {
            if (i * i >= a - 0.00002) {
                result = i;
                break;
            }
        }

        return new BigDecimal(result).setScale(5, RoundingMode.HALF_DOWN).doubleValue();
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
