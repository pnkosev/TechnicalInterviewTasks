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
            throw new IndexOutOfBoundsException();
        }

        this.array[currentIndex++] = o;
    }

    @Override
    public T pull() {
        // if we care to delete the item
//        T[] copyArr = (T[]) new Object[this.size()];
//        System.arraycopy(this.array, 0, copyArr, currentIndex, this.size());
//        System.arraycopy(this.array, currentIndex + 1, copyArr, currentIndex, this.size());

        if (this.size() < 1) {
            throw new IndexOutOfBoundsException();
        }

        return this.array[--currentIndex];
    }

    @Override
    public int size() {
        return this.currentIndex;
    }
}
