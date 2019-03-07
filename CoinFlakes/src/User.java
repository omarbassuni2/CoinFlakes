import java.util.Scanner;

public class User {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Wallet newWalletUser = new Wallet();
		BlockChain chainsViewer = new BlockChain("DummyObject");
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("1)Send Coins\n2)Check your blockchains\n3)Check all blockchains\n4)Exist");
			int choice = scanner.nextInt();
			if(choice == 1){
				WalletServices useSendFunc = new WalletServices();
				useSendFunc.send();
			}
			if(choice == 2){
				chainsViewer.displayChain();
			}
			if(choice == 3){
				chainsViewer.displayAllChains();
			}
			if(choice == 4){
				break;
			}
		}
		scanner.close();
	}

}
