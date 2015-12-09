import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.*;

public class DateServerLauncher {
	
	public static final String DATE_SERVER_NAME = "date.server";
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
			// Bind the service
			registry.rebind(DATE_SERVER_NAME, new DateServer());
		} catch (IOException ex) {
			ex.printStackTrace();
		}		
	}
}