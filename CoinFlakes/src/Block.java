import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block {
	private int index = -1;
	private String Hash; 
	private String PrevHash;
	private Transaction Data;
	private Date timestamp;
	
	public Block(Transaction Data){
		this.Data = Data;
		Hash = computeHash();
	}
	
	public String computeHash(){
		String input = "" + this.index + this.timestamp + this.PrevHash + Data.getID() + Data.getTransactionReceiver() + Data.getAmountTransfered();
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
	public String getHash(){
		return this.Hash;
	}
	public int getIndex(){
		return this.index;
	}
	public Transaction getData(){
		return this.Data;
	}
	
	
}
