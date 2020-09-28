import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //System.out.println(new Customer(1, 0.5));
        System.out.println(new ArriveEvent(new Customer(1, 0.5), Arrays.asList(new Server(1, true, false, 0))));
    }
}