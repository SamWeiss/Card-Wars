
public class Card {
	
	//this is the base class for all Cards, it will contain information about the card, it's playability, but advanced
	//information will be stored in its children classes
	private boolean floop;
	private int ManaCost;
	public Card(boolean t, int MC){
		floop = t;
		ManaCost = MC;
	}
	public boolean Floop(){
		//basic floop method, returns boolean value of floop success
		if(floop){
			return false;
		}else{
			floop = true;
			return true;
		}
	}
	public boolean unFloop(){
		//basic unfloop method, returns boolean value of unfloop success
		if(!floop){
			return false;
		}else{
			floop = false;
			return true;
		}
	}
	public int getManaCost(){
		return ManaCost;
	}
	public boolean setManaCost(int nmc){
		if (nmc == ManaCost){
			return false;
		}else{ ManaCost = nmc; return true;}
	}

}
