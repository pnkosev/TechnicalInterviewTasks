public class ArrayUtil {

    private ArrayUtil() {}

    public static int[] bubbleSort(int[] arr) {
        int[] sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);

        boolean isSorted;

        do {
            isSorted = true;

            for (int i = 0; i < sortedArr.length - 1; i++) {
                int currentValue = sortedArr[i];
                int nextValue = sortedArr[i + 1];

                if (currentValue > nextValue) {
                    sortedArr[i] = nextValue;
                    sortedArr[i + 1] = currentValue;
                    isSorted = false;
                }
            }

        } while (!isSorted);

        return sortedArr;
    }
}
