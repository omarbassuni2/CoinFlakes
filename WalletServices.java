import java.util.Scanner;
public class WalletServices extends Wallet{

	public int send(String myPortNumber, String peerPortID) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount: ");
		int amount = sc.nextInt();
		while(amount > super.getBalance()){
			System.out.println("Your balance doesn't have the funds! \nEnter another amount: ");
			amount = sc.nextInt();	
		}
		//always sends to first peer
		Transaction newTransactionObj = new Transaction(myPortNumber, peerPortID, amount);
		Block CreateNewBlock  = new Block(newTransactionObj);
		BlockChain.addBlock(CreateNewBlock);
		super.setBalance(getBalance() - amount); 
		System.out.println("New Balance: " + super.getBalance());
		return amount;
	}
	
}
