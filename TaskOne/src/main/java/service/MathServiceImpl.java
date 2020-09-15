package service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathServiceImpl implements MathService {

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
    public double sqrtBinary(long a) {
        double left = 0;
        double right = a;

        double mid = 0;
        for (int i = 0; i < 100; i++) {
            mid = left + (right - left) / 2;

            if (mid * mid == a) {
                return mid;
            } else if (mid * mid < a) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return mid;
    }

    @Override
    public double sqrt(long a) {
//        long iterationCount = 0;

        if (a == 0 || a == 1) {
            return a;
        }

        double result = 0;

        for (double i = 1; i < a; i += 0.1) {
//            iterationCount++;
            if (i * i >= a - 0.2) {
                result = i;
                break;
            }
        }

//        System.out.print(String.format("My math made %d iterations ", iterationCount));
        return new BigDecimal(result).setScale(5, RoundingMode.HALF_DOWN).doubleValue();
    }

    @Override
    public double sqrtWentTooFar(long number) {
        if (number == 0 || number == 1) {
            return number;
        }

        String numberAsString = String.valueOf(number);
        double startingNumber = getMinimumInitialNumber(numberAsString.length());
        startingNumber = increaseNumberAccordingToFirstDigit(startingNumber, numberAsString.substring(0, 1));
        startingNumber = increaseNumber(startingNumber, number);

        double result = 0;

        for (double i = startingNumber; i < number; i += 0.1) {
            if (i * i >= number - 0.1) {
                result = i;
                break;
            }
        }

        return new BigDecimal(result).setScale(5, RoundingMode.HALF_DOWN).doubleValue();
    }

    /*
        1 000 000 -> 1000
        2 000 000 -> 1414 414 41%
        3 000 000 -> 1732 318 23%
        4 000 000 -> 2000 268 15.5%
        5 000 000 -> 2236 236 11.5%
        6 000 000 -> 2449 213  9.5%
        7 000 000 -> 2645 196  7.9%
        8 000 000 -> 2828 183  6.6%
        9 000 000 -> 3000 172  5.6%
       10 000 000 -> 3162
     */

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
