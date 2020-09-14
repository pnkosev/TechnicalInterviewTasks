import java.util.ArrayList;
import java.util.Arrays;

public class StackImpl<T> implements Stack<T> {
    private T[] array;
    private int currentIndex = 0;

    public StackImpl(int size) {
        this.array = (T[]) new Object[size];
    }

    @Override
    public void push(T o) {
        if (this.size() == this.array.length) {
            throw new StackOverflowError();
        }

        this.array[currentIndex++] = o;
    }

    @Override
    public T pull() {
        // Copying the array without the pulled item and reassigning it to this.array
//        T[] copyArr = (T[]) new Object[this.array.length];
//        System.arraycopy(this.array, 0, copyArr, 0, this.currentIndex - 1);
//        T pulledItem = this.array[--this.currentIndex];
//        this.array = copyArr;

        if (this.size() < 1) {
            return null;
        }

        ArrayList<T> list = new ArrayList<>(Arrays.asList(this.array));
        T pulledItem = list.remove(--this.currentIndex);

        this.array = (T[]) list.toArray();

        return pulledItem;
    }

    @Override
    public int size() {
        return this.currentIndex;
    }
}
