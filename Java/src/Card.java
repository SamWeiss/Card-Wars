
public class Card {
	
	//this is the base class for all Cards, it will contain information about the card, it's playability, but advanced
	//information will be stored in its children classes
	private boolean floop;
	public Card(boolean t){
		floop = t;
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

}
