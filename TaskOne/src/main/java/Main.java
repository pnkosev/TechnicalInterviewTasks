import service.MathService;
import service.MathServiceImpl;

public class Main {
    public static void main(String[] args) {

        MathService math = new MathServiceImpl();

        System.out.println(math.sqrt(620608357369L));
    }
}
