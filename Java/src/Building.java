
public class Building extends Card {
	int type;
	int ManaCost;
	String Name;
	String Description;
	//1. caves => +2 defense, 3 mana
	//2. castles => +5 HP, 4 mana
	//3. Libraries => 2 mana
	//4. Volcano => 5 mana play, 7 mana floop => clears board ends turn
	//5. Spirit Tower => takes control of one creature, 2 mana play, 4 mana floop
	//6. Silo of Truth => 2 mana play, 5 mana floop, reveals opponents hand
	public Building(int t) {
		super(true, 0);
		if(type == 1){
			ManaCost = 3;
			Name = "Caves";
			Description = "Grants +2/0 to those inside of it, but those inside can't attack";
		}else if(type == 2){
			ManaCost = 4;
			Name = "Castle";
			Description = "Grants +5 Health to the player, but this is not factored into a Win/Loss";
		}else if(type == 3){
			ManaCost = 2;
			Name = "Library";
			Description = "A place of learning, required to floop Ancient Scholar";
		}else if (type == 4){
			ManaCost = 5;
			Name = "Volcano";
			Description = "When flooped, for 7 Mana, the field is wiped and the player's turn is ended";
		}else if(type == 5){
			ManaCost = 2;
			Name = "Spirit Tower";
			Description = "When flooped, for 4 Mana, the player gains control of one of the opponant's creatures";
		}else if(type == 6){
			ManaCost = 2;
			Name = "Silo of Tuth";
			Description = "When flooped, for 5 Mana, the opponant reveals their hand";
		}
		super.setManaCost(ManaCost);
	}
	public int getType(){
		return type;
	}


}
