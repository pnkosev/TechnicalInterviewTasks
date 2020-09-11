public class Main {
    public static void main(String[] args) {
        Math math = new MathImpl();

        int resultMult = math.mult(2, 3);
        System.out.println(resultMult);

        int resultDiv = math.div(31, 3);
        System.out.println(resultDiv);
    }
}
