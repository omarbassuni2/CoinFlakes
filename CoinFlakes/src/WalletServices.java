import java.util.Scanner;

public class WalletServices extends Wallet{
	
	public void send(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID of receiver: ");
		String ID = sc.next();
		System.out.println("Enter the amount: ");
		int amount = sc.nextInt(); //might have an error
		Transaction newTransactionObj = new Transaction(getID(), ID, amount);
		
		
		
		
	}
	
}
