import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Set;

public class ServerThread extends Thread{
	private ServerSocket serverSocket;
	private Set<ServerThreadHandler> serverThreads = new HashSet<ServerThreadHandler>();
	public ServerThread(String portNumber) {
		try {
			serverSocket = new ServerSocket(Integer.valueOf(portNumber));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run(){
		while(true){
			ServerThreadHandler serverHandlerThread;
			try {
				serverHandlerThread = new ServerThreadHandler(serverSocket.accept(), this);
				serverThreads.add(serverHandlerThread);
				serverHandlerThread.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void sendMessage(String message){
		serverThreads.forEach(obj -> obj.getPrintWriter().println(message));
	}
	public Set<ServerThreadHandler> getServerThreads() {
		return serverThreads;
	}
}
