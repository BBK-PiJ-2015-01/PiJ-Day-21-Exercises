import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.*;
import java.util.*;

public class DateClient {

	public static void main(String[] args) {

		new DateClient().launcher();
	}

	private void launcher() {

		try {
			Registry registry = LocateRegistry.getRegistry("localhost");
			DateService dateService = (DateService) registry.lookup(DateServerLauncher.DATE_SERVER_NAME);
			Date receivedDate = dateService.date();
			System.out.println("Date over there is : " + receivedDate);
		} catch (IOException | NotBoundException ex) {
			ex.printStackTrace();
		}
	}
}