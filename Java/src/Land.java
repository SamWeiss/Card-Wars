
public class Land extends Card {

	//this is the class for Land Cards, they extend the Card class as they are cards, they will contain floop information
	//as well as land type and special attributes
	int color = 0;
	String description;
	public Land(int t){
		super(false);
		if(color == 1){
			description = "this is a description of type 1";
		}else{ description = "this is a description of type 2";}
	}
	public int landFloop(){
		boolean floopSuccess;
		floopSuccess = super.Floop();
		if (floopSuccess){		
			return 1;
		}else{
			return 0;
		}
	}
	public int getColor(){
		return color;
	}
	public boolean forceColor(int newval){
		if(color == newval){
			return false;
		}else{
			color = newval;
			return true;
		}
	}
	
}
