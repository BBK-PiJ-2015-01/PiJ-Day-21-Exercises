import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class DateServer extends UnicastRemoteObject implements DateService {
	
	
	public DateServer() throws RemoteException {
		// nothing to initialise for this server
		// (must have a constructor that throws RemoteException)
	}

	@Override
	public Date date() throws RemoteException {

		return new Date(System.currentTimeMillis());
	}
}
