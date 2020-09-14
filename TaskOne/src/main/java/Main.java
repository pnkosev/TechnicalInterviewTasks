import service.MathService;
import service.MathServiceImpl;

public class Main {
    private static final long PERFECT_SQUARE_FOUR_DIGIT_NUMBER = 1296;
    private static final long NON_PERFECT_SQUARE_FOUR_DIGIT_NUMBER = 3333;
    private static final long PERFECT_SQUARE_SIX_DIGIT_NUMBER = 255025;
    private static final long NON_PERFECT_SQUARE_SIX_DIGIT_NUMBER = 753951;
    private static final long PERFECT_SQUARE_EIGHT_DIGIT_NUMBER = 60481729;
    private static final long NON_PERFECT_SQUARE_EIGHT_DIGIT_NUMBER = 86542971;
    private static final long PERFECT_SQUARE_TEN_DIGIT_NUMBER = 1111088889;
    private static final long NON_PERFECT_SQUARE_TEN_DIGIT_NUMBER = 1111111111;
    private static final long PERFECT_SQUARE_TWELVE_DIGIT_NUMBER = 620608357369L;
    private static final long NON_PERFECT_SQUARE_TWELVE_DIGIT_NUMBER = 564792498315L;

    public static void main(String[] args) {

        MathService math = new MathServiceImpl();

        // perfect square four-digit number
        calcAndPrintComparison(math, PERFECT_SQUARE_FOUR_DIGIT_NUMBER);

        // non-perfect square four-digit number
        calcAndPrintComparison(math, NON_PERFECT_SQUARE_FOUR_DIGIT_NUMBER);

        // perfect square six-digit number
        calcAndPrintComparison(math, PERFECT_SQUARE_SIX_DIGIT_NUMBER);

        // non-perfect square six-digit number
        calcAndPrintComparison(math, NON_PERFECT_SQUARE_SIX_DIGIT_NUMBER);

        // perfect square eight-digit number
        calcAndPrintComparison(math, PERFECT_SQUARE_EIGHT_DIGIT_NUMBER);

        // non-perfect square eight-digit number
        calcAndPrintComparison(math, NON_PERFECT_SQUARE_EIGHT_DIGIT_NUMBER);

        // perfect square ten-digit number
        calcAndPrintComparison(math, PERFECT_SQUARE_TEN_DIGIT_NUMBER);

        // non-perfect square ten-digit number
        calcAndPrintComparison(math, NON_PERFECT_SQUARE_TEN_DIGIT_NUMBER);

        // perfect square twelve-digit number
        calcAndPrintComparison(math, PERFECT_SQUARE_TWELVE_DIGIT_NUMBER);

        // non-perfect square twelve-digit number
        calcAndPrintComparison(math, NON_PERFECT_SQUARE_TWELVE_DIGIT_NUMBER);
    }

    private static void calcAndPrintComparison(MathService math, long number) {
        printExecutionTimeResults(
                number,
                getExecutionTime(() -> math.sqrt(number)),
                getExecutionTime(() -> Math.sqrt(number))
        );
    }

    private static long getExecutionTime(Runnable runnable) {
        long startTime = System.currentTimeMillis();
        runnable.run();
        return System.currentTimeMillis() - startTime;
    }

    private static void printExecutionTimeResults(long number, long custom, long buildIn) {
        System.out.println(
                String.format(
                        "calculating sqrt(%d) and took %d millis, while build-in math took %d millis.",
                        number,
                        custom,
                        buildIn)
        );
    }
}
