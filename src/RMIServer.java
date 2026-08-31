import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            // Start RMI registry programmatically on port 1099
            LocateRegistry.createRegistry(1099);
            CalculatorImpl calc = new CalculatorImpl();
            Naming.rebind("CalculatorService", calc);
            System.out.println("RMI Server is running. CalculatorService bound.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
