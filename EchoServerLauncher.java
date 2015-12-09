import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.*;

public class EchoServerLauncher {
	
	public static void main(String[] args) {
		
		System.out.println("Starting EchoServer...");
		
		// if there is no security manager, start one
		if (System.getSecurityManager() == null) {
			System.out.println("Create security manager...");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			System.out.println("Get registry...");
			// create the registry if there is not one
			Registry registry = LocateRegistry.getRegistry();
			// create the server object
			System.out.println("Create server object...");
			EchoServer server = new EchoServer();
			// register (bind) the server object on the registry
			// The registry may be on a different machine
			System.out.println("Bind server object...");
			registry.rebind("Echo", server);
		} catch (IOException ex) {
			ex.printStackTrace();
		}		
	}
}