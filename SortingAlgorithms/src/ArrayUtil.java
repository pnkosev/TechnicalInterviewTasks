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

    public static int[] selectionSort(int[] arr) {
        int[] sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);

        int unsortedIndex = 0;

        do {

            int currentMinimum = sortedArr[unsortedIndex];
            int index = -1;

            for (int i = unsortedIndex + 1; i < sortedArr.length; i++) {
                int currentItemToCompare = sortedArr[i];
                if (currentItemToCompare < currentMinimum) {
                    currentMinimum = currentItemToCompare;
                    index = i;
                }
            }

            if (index != -1) {
                int firstUnsortedItem = sortedArr[unsortedIndex];
                sortedArr[unsortedIndex] = currentMinimum;
                sortedArr[index] = firstUnsortedItem;
            }

            unsortedIndex++;

        } while (unsortedIndex < sortedArr.length);

        return sortedArr;
    }

    public static int[] insertionSort(int[] arr) {
        int[] sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);

        int lastSortedIndex = 0;
        int unsortedIndex = lastSortedIndex + 1;

        do {
            int itemToSort = sortedArr[unsortedIndex++];

            for (int i = lastSortedIndex; i >= 0; i--) {
                int sortedItem = sortedArr[i];
                if (sortedItem > itemToSort) {
                    sortedArr[i] = itemToSort;
                    sortedArr[i + 1] = sortedItem;
                }
            }

            lastSortedIndex++;
        } while (unsortedIndex < sortedArr.length);

        return sortedArr;
    }
}























