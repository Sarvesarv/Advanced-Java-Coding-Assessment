import java.rmi.Naming;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Calculator calc = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");
            int result = calc.add(10, 20);
            System.out.println("Addition result: " + result);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
