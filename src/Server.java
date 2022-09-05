import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements PhoneBook {
    Registry r;
    String address;
    String []phone = new String[]{"+91 78743 34967","+91 43756 23234","+91 37458 2345"};
    String []name = new String[]{"Ravi Kumar","Ram Patil","Nisha Singh"};
    int flag = 0;
    public Server() throws RemoteException {
        try {
            address = InetAddress.getLocalHost().toString();
            r = LocateRegistry.createRegistry(12314);
            r.rebind("phoneNum",this);
            System.out.println("Server started at " + address);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String GetphoneNum(String str) throws RemoteException {
        for(int i = 0 ; i < 3; i++)
        {
            if(str.equals(name[i]))
            {
                flag = 1;
                return phone[i];
            }
        }
        return "No Record Found";
    }

    public static void main(String[] args) throws RemoteException {
        new Server();
    }
}
