import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new StackImpl<>(10);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.size());

        Integer pulled = stack.pull();

        System.out.println(pulled);
        System.out.println(stack.size());

        stack.push(5);
        System.out.println(stack.size());

        Integer pulled2 = stack.pull();
        System.out.println(pulled2);
        System.out.println(stack.size());

        stack.pull();
        stack.pull();
        stack.pull();
        System.out.println(stack.size());
    }
}
