
public class Transaction {
	private String ID;
	private String TransactionReceiver;
	private int AmountTransfered;
	
	public Transaction(String ID, String TransactionReceiver, AmountTransfered){
		this.ID = ID;
		this.TransactionReceiver = TransactionReceiver;
		this.AmountTransfered = AmountTransfered;
		Block CreateNewBlock  = new Block(this);
	}
	public void setID(String ID){
		this.ID;
	}
	public void setTransactionReceiver(String TransactionReceiver){
		this.TransactionReceiver = TransactionReceiver;
	}
	public void setAmountTransfered(int AmountTransfered){
		this.AmountTransfered = AmountTransfered;
	}
	public String getID(){
		return ID;
	}
	public String getTransactionReceiver(){
		return TransactionReceiver;
	}
	public int getAmountTransfered(){
		return AmountTransfered;
	}
	
	
}
