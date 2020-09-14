public class StackImpl<T> implements Stack<T> {
    private T[] array;
    private int currentIndex = 0;

    public StackImpl(int size) {
        this.array = (T[]) new Object[size];
    }

    @Override
    public void push(T o) {
        if (this.size() == this.array.length) {
            // to do whatever the specs say
        }

        this.array[currentIndex++] = o;
    }

    @Override
    public T pull() {
        if (this.size() < 1) {
            return null;
        }

        T pulledItem = this.array[--this.currentIndex];

        this.array[this.currentIndex] = null;

        return pulledItem;
    }

    @Override
    public int size() {
        return this.currentIndex;
    }
}
