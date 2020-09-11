public class Main {
    public static void main(String[] args) {

        Math math = new MathImpl();

        System.out.println(math.mult(2, 3));
        System.out.println(math.mult(-2, 3));
        System.out.println(math.mult(2, -3));
        System.out.println(math.mult(-2, -3));
        System.out.println(math.mult(-2, 0));
        System.out.println(math.mult(0, 3));

        System.out.println(math.div(31, 3));
        System.out.println(math.div(-31, 3));
        System.out.println(math.div(-31, -3));
        System.out.println(math.div(0, 3));
        System.out.println(math.div(0, -3));
        System.out.println(math.div(31, 0));
    }
}
