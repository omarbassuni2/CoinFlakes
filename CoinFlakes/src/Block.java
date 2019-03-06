
public class Block {
	private String Hash; 
	private String PrevHash;
	private Transaction Data;
	private long timestamp;
	
	public Block(Transaction Data){
		this.Data = new Transaction(Data);
	}
	public String computeHash(){

        MessageDigest md = MessageDigest.getInstance("SHA-256"); 

        byte[] messageDigest = md.digest(input.getBytes()); 

        BigInteger no = new BigInteger(1, messageDigest); 

        String HashValue = no.toString(16); 

        while (HashValue.length() < 32) { 
            HashValue = "0" + HashValue; 
        } 
		return HashValue;
	}
}
