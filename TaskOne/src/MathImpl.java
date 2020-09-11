public class MathImpl implements Math {

    @Override
    public int mult(int a, int b) {
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
    public int div(int a, int b) {
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
