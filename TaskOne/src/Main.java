public class Main {
    public static void main(String[] args) {

        Math math = new MathImpl();

        System.out.println(math.sqrt(9));
        System.out.println(java.lang.Math.sqrt(9));
    }
}
