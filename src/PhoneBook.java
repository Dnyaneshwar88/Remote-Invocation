import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PhoneBook extends Remote {
    public String GetphoneNum(String str) throws RemoteException;
}
