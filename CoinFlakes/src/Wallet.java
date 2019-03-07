import java.util.Random;
import java.util.Scanner;

public class Wallet {
	private static String ID;
	private static int Balance;
	
	public Wallet(String ID, int Balance){
		Wallet.ID = ID;
		Wallet.Balance = Balance;
		System.out.println(ID + "Your Balance is: " + "" + Balance);
	}
	public Wallet(){
		System.out.println("Enter your ID: ");
		Scanner sc = new Scanner(System.in);
		String ID = sc.next();
		Wallet.ID = ID;
		Random rand = new Random();
		Balance = rand.nextInt(500);
		System.out.println("Your ID: " + ID + " Your Balance is: " + "" + Balance);
	}
	public Wallet(String dummyVariable){
		
	}
	
	public void setID(String ID){
		Wallet.ID = ID;
	}
	public void setBalance(int Balance){
		Wallet.Balance = Balance;
	}
	public String getID(){
		return Wallet.ID;
	}
	public int getBalance(){
		return Balance;
	}
}
