import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
public class Peer {
    private String ID;
    private String portNumber;
    private static ServerThread serverThread;
    private ArrayList<String> peerPortNumbers = new ArrayList<String>();
    public Peer(String ID, String portNumber) throws IOException{
    	this.ID = ID;
    	this.portNumber = portNumber;
    	BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
    	serverThread = new ServerThread(portNumber);
    	serverThread.start();
    	updateContactList(bufferReader);
    }
    private void updateContactList(BufferedReader bufferedReader) {
    	System.out.println("Enter the ID:portNumber of your peers: ");
    	try {
			String[] input = bufferedReader.readLine().split(" ");
			for(int i = 0;i < input.length;i++){
				String[] address = input[i].split(":");
				Socket socket = null;
				socket = new Socket(address[0], Integer.valueOf(address[1]));
				peerPortNumbers.add(address[1]);
				new PeerThreading(socket).start();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public static void sendBlockChain(){
    	serverThread.sendMessage(BlockChain.sendMyChain());
    }
    public void communicate(BufferedReader bufferedReader){
    	boolean flag = true;
    	Scanner sc = new Scanner(System.in);
    	while(flag){
    		String message = "Nothing yet!";
			try {
				message = bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
    		if(message.equals("request: add_peer")){
    			updateContactList(bufferedReader);
    		}
    		else if(message.equals("request: send_coins")){
    			WalletServices useSend = new WalletServices();
    			message = "getcoins" + useSend.send(portNumber, peerPortNumbers.get(0));
    			serverThread.sendMessage(message);
    			message = BlockChain.convertBlock();
    			serverThread.sendMessage("addblock" + message);
    		}
    		else if(message.equals("request: longest_chain")){
    				message = "longestchain" + BlockChain.convertChain();
    				
    		}
    		else if(message.equals("E")){
    			flag = false;
    			break;
    		}
    		else if(message.equals("request: add_last_block")){
    			message = BlockChain.convertBlock();
    			serverThread.sendMessage("addblock" + message);
    		}
    		else{
    			serverThread.sendMessage(message);
    		}
    		System.out.println("Enter a query!\nrequest: send_coins\nrequest: display_blockchain\nrequest: add_last_block\nrequest: add_peer\nrequest: longest_chain\nE to Exit");
    	}
    }
	public static void revertBlock(String blk) {
		BlockChain.revertBlock(blk);
    	serverThread.sendMessage("done!");
		
	}
	public static int addCoins(int amountReceived) {
		// TODO Auto-generated method stub
		Wallet walletOfCoins = new Wallet();
		int newBalance = walletOfCoins.add(amountReceived);
		return newBalance;
	}
	public static String callConvertBlockChain(){
		String myBlockChainString =BlockChain.convertChain();
		return myBlockChainString;
	}
	public static String callRevertBlockChain(String revertString){
		BlockChain.revertChain(revertString);
		return "BlockChain updated successfully!";
	}
	
}
