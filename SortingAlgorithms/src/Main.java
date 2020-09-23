import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //, 33, 84, 74
        int[] arr = { 100, 55, 5, 4, 2, 95, 78, 66, 33, 84, 74};

        System.out.println(Arrays.toString(ArrayUtil.bubbleSort(arr)));
        System.out.println(Arrays.toString(ArrayUtil.selectionSort(arr)));
        System.out.println(Arrays.toString(ArrayUtil.insertionSort(arr)));
        System.out.println(Arrays.toString(ArrayUtil.mergeSort(arr)));
    }
}
