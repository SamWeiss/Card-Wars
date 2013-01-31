
public class Spell extends Card {
	//1. Cerebral Bloodstorm => +1 damage, all attack during turn, discarded at end of turn, costs 4-5 mana
	//2. Reclaim landscape => unfloops land, costs 5 mana
	//3. Oblivian Ring => 3 mana, returns creature to opponents hand
	//4. Lava Hammer => 2 mana, +2 damage
	int type;
	String description;
	boolean target;
	int MC;
	public Spell(boolean t, int ct, boolean tgt) {
		super(t, 0);
		type = ct;
		if(type == 1 ){
			MC = 4;
		}else if(type == 2){
			MC = 5;
		}else if(type == 3){
			MC = 3;
		}else{
			MC = 2;
		}
		setManaCost(MC);
		target = tgt;
	}

}
