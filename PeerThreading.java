import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
public class PeerThreading extends Thread{
	private BufferedReader bufferedReader;
	private ServerThread serverThread;
	public PeerThreading(Socket socket){
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run(){
		String string = null;
		try {
			while((string = bufferedReader.readLine())!=null){
						if(string.equals("request: display_blockchain")){
							Peer.sendBlockChain();
						}
						else if(string.startsWith("addblock")){
							String blk = string.substring(8);
							Peer.revertBlock(blk);
						}
						else if(string.startsWith("getcoins")){
							String amountReceived = string.substring(8);
							int newBalance = Peer.addCoins(Integer.valueOf(amountReceived));
							System.out.println("Your balance now: " + newBalance);
						}
						else{
							System.out.println("not a query: " + string);
						}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
