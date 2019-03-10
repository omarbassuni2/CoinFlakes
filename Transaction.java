public class Transaction {
	private String ID;
	private String TransactionReceiver;
	private int AmountTransfered;
	
	public Transaction(String ID, String TransactionReceiver, int AmountTransfered){
		this.ID = ID;
		this.TransactionReceiver = TransactionReceiver;
		this.AmountTransfered = AmountTransfered;
	}
	public void setID(String ID){
		this.ID = ID;
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
	public void displayInfo(){
		System.out.println("ID: " + this.ID + " Receiver: " + this.TransactionReceiver + " AmountTransfered: " + this.AmountTransfered);
	}
	public String createInfoString(){
		String returnThisString = "" + "ID: " + ID + " Receiver: " + TransactionReceiver + " AmountTransfered: " + AmountTransfered;
		return returnThisString;
	}
	public String getDataString(){
		return ID + "-" +TransactionReceiver + "-" + AmountTransfered;
	}
	public static Transaction revertDataString(String data){
		String[] values = data.split("-");
		Transaction transData = new Transaction(values[0], values[1], Integer.valueOf(values[2]));
		return transData;
	}
}
