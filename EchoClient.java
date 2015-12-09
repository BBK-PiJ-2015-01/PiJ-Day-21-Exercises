import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.*;

public class EchoClient {

	public static void main(String[] args) {

		new EchoClient().launcher(args[0]);
	}

	private void launcher(String msg) {

		try {
			Registry registry = LocateRegistry.getRegistry("localhost");
			EchoService echoService = (EchoService) registry.lookup("Echo");
			String receivedEcho = echoService.echo(msg);
			System.out.println("Got: " + receivedEcho);
		} catch (IOException | NotBoundException ex) {
			ex.printStackTrace();
		}
	}
}