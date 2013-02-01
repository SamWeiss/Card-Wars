public class Creature extends Card {
	int type;
	int ManaCost;
	String Name;
	String Description;
	int toughness;
	int attack;
	public Creature(int t) {
		super(true, 0);
		type = t;
		if(type == 1){
			ManaCost = 2;
			attack = 1;
			toughness = 1;
			Name = "Pig";
			Description ="This is a Pig, it has 1 attack and 1 toughness. It has the ability 'Floop to disable Corn'.";
		} else if(type == 2){
			ManaCost = 2;
			attack = 1;
			toughness = 1;
			Name = "Goat";
			Description ="This is a Goat, it has 1 attack and 1 toughness. It has the ability 'Floop to disable Mountains'.";
		} else if(type == 3){
			ManaCost = 2;
			attack = 1;
			toughness = 1;
			Name = "Cow";
			Description ="This is a Cow, it has 1 attack and 1 toughness. It has the ability 'Floop to disable Mud'.";
		} else if(type == 4){
			ManaCost = 3;
			attack = 2;
			toughness = 3;
			Name = "Husker Knight";
			Description ="This is a Husker Knight, it has 2 attack and 3 toughness.";
		} else if(type == 5){
			ManaCost = 3;
			attack = 3;
			toughness = 2;
			Name = "Archer Dan";
			Description ="This is an Archer Dan, it has 3 attack and 2 toughness. It has the ability 'Can attack from Caves, but at a cost" +
					" of -1/0'.";
		} else if(type == 6){
			ManaCost = 4;
			attack = 1;
			toughness = 1;
			Name = "Ancient Scholar";
			Description ="This is an Ancient Scholar, it has (base) 1 attack and 4 toughness. It has the ability 'Floop, with 3 Mana and" +
					" a Library to gain +1/0 permanently'";
		} else if(type == 7){
			ManaCost = 5;
			attack = 1;
			toughness = 1;
			Name = "Dragon";
			Description ="This is a Dragon, it has 4 attack and 4 toughness. It has the ability 'Is not blocked by Castles'";
		} 
		super.setManaCost(ManaCost);
	}
}
