package pkg_RMI;

import java.rmi.Naming;
import java.util.Scanner;

public class RMI_Client {

    public static void main(String[] args) {
        try {
            RMI_interface remoteObject = (RMI_interface) Naming.lookup("rmi://localhost:1878/hello");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a number to calculate its square root: ");
            double number = sc.nextDouble();

            double result = remoteObject.calculateSquareRoot(number);

           
        } catch (Exception e) {
            System.out.println("The RMI APP is Not running...");
            e.printStackTrace();
        }
    }
}
