import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

/**
* An implementation of the echo service.
*/
public interface DateService extends Remote {
	/**
	* Returns the same string passed as parameter
	*
	* @param s a string
	* @return the same string passed as parameter
	* @throws RemoteException (in case anything goes wrong with
	the network connectivity)
	*/
	Date date() throws RemoteException;
}
