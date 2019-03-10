import java.util.ArrayList;

public class BlockChain {
	
	private static ArrayList<Block> myChain;
	private static ArrayList<Block> networkChain = new ArrayList<Block>();
	private static int difficulty = 1;
	public BlockChain(){
		myChain = new ArrayList<Block>();
	}
	public BlockChain(Block blk){
		myChain = new ArrayList<Block>();
		addBlock(blk);
	}
	public static void addBlock(Block blk){
		if(BlockChain.myChain.size() == 0){
			blk.setPrevHash(null);
		}
		else{
			Block getPreHashBlock = myChain.get(myChain.size()-1);
			blk.setPrevHash(getPreHashBlock.getHash());
			blk.setIndex(myChain.size());	
		}
//		blk.proofOfWork(difficulty);
		myChain.add(blk);
	}
	public static void addSentBlock(Block blk, boolean verified){
		if(verified){
			myChain.add(blk);
		}
	}
	public static void displayMyChain(){
		for(int i = 0;i < myChain.size(); i++){
			System.out.println("Block: " + (i + 1));
			myChain.get(i).getData().displayInfo();
			System.out.println("Hash: " + myChain.get(i).getHash());
			System.out.println("PrevHash: " + myChain.get(i).getPrevHash());
		}
	}
	public static String sendMyChain(){
		String myChainString = "";
		for(int i = 0;i < myChain.size(); i++){
			myChainString += "Block: " + i + 1;
			myChainString += "" + myChain.get(i).getData().createInfoString();
			myChainString += "Hash: " + myChain.get(i).getHash();
			myChainString += "PrevHash: " + myChain.get(i).getPrevHash();
		}
		return myChainString;
	}
	
	public static ArrayList<Block> getMyChains(){
		return myChain;
	}
	public void setMyChains(ArrayList<Block> myChain){
		BlockChain.myChain = myChain;
	}
	
	public void setChains(ArrayList<Block> chains){
		BlockChain.networkChain = chains;
	}
	public ArrayList<Block> getNetworkChain(){
		return networkChain;
	}
	public static String convertBlock(){
		String lastBlockString = "";
		lastBlockString += myChain.get(myChain.size()-1).getHash() + ":" + 
				myChain.get(myChain.size()-1).getPrevHash() + ":" + 
				myChain.get(myChain.size()-1).getDataString() + ":" +
				myChain.get(myChain.size()-1).getIndex() + ":" +
				myChain.get(myChain.size()-1).getTimeStamp();
		return lastBlockString;
	}
	public static void revertBlock(String addblk){
		String[] values = addblk.split(":");
		Block addBlock = new Block(values[0], values[1], values[2], Integer.valueOf(values[3]), values[4]);
		addSentBlock(addBlock, true);
	}
	
}
