public class Main {
    public static void main(String[] args) {

        Math math = new MathImpl();

        System.out.println(math.sqrt(600000));
        System.out.println(math.sqrt(6000000));
        System.out.println(math.sqrt(60000000));
        System.out.println(math.sqrt(600000000));
        System.out.println(math.sqrt(1000000000));
    }
}
