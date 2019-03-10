import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThreadHandler extends Thread{
	private Socket socket;
	private ServerThread serverThread;
	private PrintWriter printWriter;
	public ServerThreadHandler(Socket socket, ServerThread serverThread) {
		this.serverThread = serverThread;
		this.socket = socket;
	}
	public void run(){
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.printWriter = new PrintWriter(socket.getOutputStream(), true);
			while(true) serverThread.sendMessage(bufferedReader.readLine());
		} catch (IOException e) {
			serverThread.getServerThreads().remove(this);
		}
	}
	
	public PrintWriter getPrintWriter() {
		return printWriter;
	}

}
