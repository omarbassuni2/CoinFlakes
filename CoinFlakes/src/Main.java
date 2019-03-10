import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String ID = "localhost";
		System.out.println("Enter your portNumber: ");
		String port = bufferedReader.readLine();
		Peer peer = new Peer(ID, port);
		@SuppressWarnings("unused")
		Wallet newWalletUser = new Wallet(ID, port);
		BlockChain chainsViewer = new BlockChain();
		while(true){
			System.out.println("1)Check your blockchains\n2)use the network\n3)check your Balance\nExit");
			int choice = sc.nextInt();
			if(choice == 1){
				BlockChain.displayMyChain();
			}
			if(choice == 2){
				peer.communicate(bufferedReader);
			}
			if(choice == 3){
				Wallet.getBalance();
			}
			if(choice == 4){
				break;
			}
		}
	}

}