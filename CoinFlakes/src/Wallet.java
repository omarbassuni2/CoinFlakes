import java.util.Random;
import java.util.Scanner;

public class Wallet {
	private static String ID;
	private String portNumber;
	private static int Balance;
	public Wallet(){
		
	}
	public Wallet(String ID, String portNumber){
		Wallet.ID = ID;
		this.portNumber = portNumber;
		Random rand = new Random();
		Balance = rand.nextInt(10000);
		System.out.println(ID + "Your Balance is: " + "" + Balance);
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
	public static int getBalance(){
		return Balance;
	}
	public void setPortNumber(String portNumber){
		this.portNumber = portNumber;
	}
	public String getPortNumber(){
		return portNumber;
	}
	public int add(int amountReceived) {
		Balance += amountReceived;
		return Balance;
	}
}
