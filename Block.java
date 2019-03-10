import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Block {
	private int index = -1;
	private String Hash; 
	private String PrevHash;
	private Transaction Data;
	private String timestamp= new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());;
	private int nonce = 0;
	public Block(Transaction Data){
		this.Data = Data;
		Hash = computeHash();
	}
	public Block(String Hash, String preHash, String Data, int index, String timeStamp){
		this.Hash = Hash;
		this.PrevHash = preHash;
		this.Data = Transaction.revertDataString(Data);
		this.index = index;
		this.timestamp = timeStamp;
	}
	public String computeHash(){
		String input = "" + this.index + this.timestamp + this.PrevHash + Data.getID() + Data.getTransactionReceiver() + Integer.toString(this.nonce);
		try { 
            MessageDigest md = MessageDigest.getInstance("SHA-256");  
            byte[] messageDigest = md.digest(input.getBytes()); 
            BigInteger no = new BigInteger(1, messageDigest);  
            String hashtext = no.toString(16); 
  
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
  
            return hashtext; 
        } 

        catch (NoSuchAlgorithmException e) { 
            System.out.println("Exception thrown"
                               + " for incorrect algorithm: " + e); 
  
            return null; 
        } 
	}
	public void proofOfWork(int difficulty){
		String diff = "";
		for(int i = 0;i < difficulty;i++){
			diff += "0";
		}
		while(!this.Hash.substring(0, difficulty).equals(diff)){
			this.nonce++;
			this.Hash = computeHash();
		}
		
	}
	
	
	
	
	public void setPrevHash(String prevHash) {
		this.PrevHash = prevHash;
	}
	public void setHash(String Hash){
		this.Hash = Hash;
	}
	public void setIndex(int index){
		this.index  = index;
	}
	public String getPrevHash() {
		return this.PrevHash;
	}
	public String getTimeStamp(){
		return this.timestamp;
	}
	public String getHash(){
		return this.Hash;
	}
	public int getIndex(){
		return this.index;
	}
	public Transaction getData(){
		return this.Data;
	}
	public String getDataString(){
		return Data.getDataString();
	}
	
}
