public class ArrayUtil {

    private ArrayUtil() {
    }

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

    public static int[] mergeSort(int[] arr) {
        int[] sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);

        int step = 2;

        do {
            for (int i = 0; i < sortedArr.length - 1; i += step) {

                int[] copyArr;

                if (i + step >= sortedArr.length) {
                    copyArr = new int[step - (i + step - sortedArr.length)];
                } else {
                    copyArr = new int[step];
                }

                int leftHeadIndex = 0;
                int rightHeadIndex = copyArr.length % 2 == 0 ? copyArr.length / 2 : copyArr.length / 2 + 1;

                for (int j = 0; j < copyArr.length; j++) {

                    if (leftHeadIndex >= step / 2) {
                        if (rightHeadIndex >= copyArr.length) {
                            continue;
                        }
                        copyArr[j] = sortedArr[i + rightHeadIndex];
                        rightHeadIndex++;
                        continue;
                    } else if (rightHeadIndex >= copyArr.length) {
                        copyArr[j] = sortedArr[i + leftHeadIndex];
                        leftHeadIndex++;
                        continue;
                    }

                    if (sortedArr[i + leftHeadIndex] < sortedArr[i + rightHeadIndex]) {
                        copyArr[j] = sortedArr[i + leftHeadIndex];
                        leftHeadIndex++;
                    } else {
                        copyArr[j] = sortedArr[i + rightHeadIndex];
                        rightHeadIndex++;
                    }
                }

                for (int k = 0; k < copyArr.length; k++) {
                    sortedArr[i + k] = copyArr[k];
                }
            }

            step *= 2;
        } while (step < sortedArr.length + 1);

        return sortedArr;
    }
}























