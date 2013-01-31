
public class Land extends Card {

	//this is the class for Land Cards, they extend the Card class as they are cards, they will contain floop information
	//as well as land type and special attributes
	int type = 0;
	String description;
	public Land(int t){
		super(false, 0);
		type = t;
		if(type == 1){description = "This card is a Dirt Card. Floop for 1 Mana";
		}else if (type == 2){ description = "This card is a Hills Card. Floop for 1 Mana, and +2/0 for Dragons";
		}else if (type == 3){ description = "This card is a Grasslands Card. Floop for 1 Mana and +2/0 for Husker Knights";}
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
	public int getType(){
		return type;
	}
	public String getDescription(){
		return description;
	}
	public boolean forceType(int newval){
		if(type == newval){
			return false;
		}else{
			type = newval;
			return true;
		}
	}
	
}
