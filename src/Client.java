import java.lang.invoke.MethodHandles;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String text = s.nextLine();
        try {
            Registry r = LocateRegistry.getRegistry(12314);
            PhoneBook pb = (PhoneBook) r.lookup("phoneNum");
            String phone = pb.GetphoneNum(text);
            System.out.println("********************************************");
            System.out.println("Name: " + text);
            System.out.println("Phone: " + phone);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
    }
}
