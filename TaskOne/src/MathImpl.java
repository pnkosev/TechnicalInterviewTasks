public class MathImpl implements Math {

    @Override
    public int mult(int a, int b) {
        int result = 0;
        int smallerNumber = a < b ? a : b;
        int biggerNumber = smallerNumber == a ? b : a;

        for (int i = 0; i < smallerNumber; i++) {
            result += biggerNumber;
        }

        return (a < 0 || b < 0) ? -result : result;
    }

    @Override
    public int div(int a, int b) {
        int result = 0;

        while (a > b && (a -= b) > 0) {
            result++;
        }

        return result;
    }
}
