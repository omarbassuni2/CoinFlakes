import java.util.Scanner;

public class WalletServices extends Wallet{
	private static BlockChain creatingUserChain = new BlockChain();
		
	WalletServices(){
		super("DummyConstructorCalling");
	}
	public void send(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID of receiver: ");
		String ID = sc.next();
		System.out.println("Enter the amount: ");
		int amount = sc.nextInt();
		while(amount > super.getBalance()){
			System.out.println("Your balance doesn't have the funds! \nEnter another amount: ");
			amount = sc.nextInt();	
		}
		Transaction newTransactionObj = new Transaction(getID(), ID, amount);
		Block CreateNewBlock  = new Block(newTransactionObj);
		creatingUserChain.addBlock(CreateNewBlock);
		super.setBalance(getBalance() - amount); 
		System.out.println("New Balance: " + super.getBalance());
	}
	
}
