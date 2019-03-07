import java.util.ArrayList;

public class BlockChain {
	
	private static ArrayList<Block> Chain;
	private static ArrayList<BlockChain> allChains = new ArrayList<BlockChain>();
	public BlockChain(){
		Chain = new ArrayList<Block>();
		allChains.add(this);
	}
	public BlockChain(Block blk){
		Chain = new ArrayList<Block>();
		addBlock(blk);
		allChains.add(this);
	}
	public BlockChain(String dummyParameter){
		
	}
	public void addBlock(Block blk){
		if(BlockChain.Chain.size() == 0){
			blk.setPrevHash("NULL");
			blk.setIndex(Chain.size());
			Chain.add(blk);
		}
		else{
			Block getPreHashBlock = Chain.get(Chain.size()-1);
			blk.setPrevHash(getPreHashBlock.getHash());
			blk.setIndex(Chain.size());
			Chain.add(blk);			
		}	
	}
	public void displayChain(){
		for(int i = 0;i < Chain.size(); i++){
			System.out.println("Block: " + i);
			Chain.get(i).getData().displayInfo();
			System.out.println("Hash: " + Chain.get(i).getHash());
			System.out.println("PrevHash: " + Chain.get(i).getPrevHash());
		}
	}
	
	public void setChains(ArrayList<BlockChain> chains){
		BlockChain.allChains = chains;
	}
	public ArrayList<BlockChain> getChains(){
		return allChains;
	}
	public void displayAllChains(){
		for(int i = 0;i < allChains.size();i++){
			allChains.get(i).displayChain();
		}
	}	
}
