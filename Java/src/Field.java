import java.util.*;
public class Field {
	
	//This class will store the location information of all Card objects, but I'm not sure how it will manage actual
	//rules and gameplay
	ArrayList<Card> Deck1 = new ArrayList<Card>();
	ArrayList<Card> Deck2 = new ArrayList<Card>();
	ArrayList<Card> Hand1 = new ArrayList<Card>();
	ArrayList<Card> Hand2 = new ArrayList<Card>();
	ArrayList<Card> Discard1 = new ArrayList<Card>();
	ArrayList<Card> Discard2 = new ArrayList<Card>();
	ArrayList<Land> Land1 = new ArrayList<Land>();
	ArrayList<Land> Land2 = new ArrayList<Land>();
	ArrayList<Building> Building1 = new ArrayList<Building>();
	ArrayList<Building> Building2 = new ArrayList<Building>();
	ArrayList<Spell> Spell1 = new ArrayList<Spell>();
	ArrayList<Spell> Spell2 = new ArrayList<Spell>();
	ArrayList<Creature> ActiveCreatures1 = new ArrayList<Creature>();
	ArrayList<Creature> ActiveCreatures2 = new ArrayList<Creature>();
	ArrayList<Creature> AttackingCreatures1 = new ArrayList<Creature>();
	ArrayList<Creature> AttackingCreatures2 = new ArrayList<Creature>();
	Card ActiveCard; Land dLand = new Land(0); Creature dCreature = new Creature(0);
	Spell dSpell = new Spell(false,0, false); Building dBuilding = new Building(0);
	int Player1Health = 20; int Player2Health = 20;
	int Player1Mana = 0; int Player2Mana = 0;
	boolean noGrassland = false; boolean noHills = false;
	private final int decksize;
	public Field(int d){
		decksize = d;
	}
	public boolean deckCheck(){
		if(Deck1.size() > decksize || Deck2.size() > decksize){
			return true;
		}else{return false;}
	}
	public int FloopLand(int player){
		if(player == 1){
			for(int i = 0; i< Land1.size();i++){
				if(Land1.get(i).getType() == 2 && noHills){
					System.out.println("Hills disabled!");
				}else if(Land1.get(i).getType() == 3 && noGrassland){
					System.out.println("Grasslands disabled!");
				}else{
					Player1Mana +=Land1.get(i).landFloop();	
				}
			}
			return Player1Mana;
		}else{
			for(int i = 0; i< Land2.size();i++){
				if(Land2.get(i).getType() == 2 && noHills){
					System.out.println("Hills disabled!");
				}else if(Land2.get(i).getType() == 3 && noGrassland){
					System.out.println("Grasslands disabled!");
				}else{
					Player2Mana +=Land2.get(i).landFloop();	
				}
			}
			return Player2Mana;
		}
	}
	public boolean FloopCreature(int player, int index, boolean s){
		if(player == 1){
			if(index >= ActiveCreatures1.size()){
				System.out.println("Attempted to Floop an invalid card!");
				return false;
			}else if(ActiveCreatures1.get(index).getType() == 1){
				if(ActiveCreatures1.get(index).Floop()){
					AttackingCreatures1.add(ActiveCreatures1.get(index));
					noGrassland = true;
					return true;
				} else {return false;}
			}else if(ActiveCreatures1.get(index).getType() == 2){
				if(ActiveCreatures1.get(index).Floop()){
					AttackingCreatures1.add(ActiveCreatures1.get(index));
					noHills = true;
					return true;
				} else {return false;}
			}else if(ActiveCreatures1.get(index).getType() == 3 ||ActiveCreatures1.get(index).getType() == 4
					|| ActiveCreatures1.get(index).getType() == 7 || ActiveCreatures1.get(index).getType() == 5){
				if(ActiveCreatures1.get(index).Floop()){
					AttackingCreatures1.add(ActiveCreatures1.get(index));
					return true;
				} else {return false;}
			}else if(ActiveCreatures1.get(index).getType() == 6){
				if(s){
					boolean Library = false;
					for(int i = 0; i < Building1.size();i++){
						if(Building1.get(i).getType() == 3){Library = true;}
					}
					if(Player1Mana >= 3 && Library && ActiveCreatures1.get(index).Floop()){
						Player1Mana -=3;
						ActiveCreatures1.get(index).addAttack(1);
						return true;
					}else{
						System.out.println("Invalid! either not enough Mana, or no Library, or already Flooped");
						return false;
					}
				}else{
					if(ActiveCreatures1.get(index).Floop()){
						AttackingCreatures1.add(ActiveCreatures1.get(index));
						return true;
					} else {return false;}
				}
			}
		}else{
			if(index >= ActiveCreatures2.size()){
				System.out.println("Attempted to Floop an invalid card!");
				return false;
			}else if(ActiveCreatures2.get(index).getType() == 1){
				if(ActiveCreatures2.get(index).Floop()){
					AttackingCreatures2.add(ActiveCreatures2.get(index));
					noGrassland = true;
					return true;
				} else {return false;}
			}else if(ActiveCreatures2.get(index).getType() == 2){
				if(ActiveCreatures2.get(index).Floop()){
					AttackingCreatures2.add(ActiveCreatures2.get(index));
					noHills = true;
					return true;
				} else {return false;}
			}else if(ActiveCreatures2.get(index).getType() == 3 ||ActiveCreatures2.get(index).getType() == 4
					|| ActiveCreatures2.get(index).getType() == 7 || ActiveCreatures2.get(index).getType() == 5){
				if(ActiveCreatures2.get(index).Floop()){
					AttackingCreatures2.add(ActiveCreatures2.get(index));
					return true;
				} else {return false;}
			}else if(ActiveCreatures2.get(index).getType() == 6){
				if(s){
					boolean Library = false;
					for(int i = 0; i < Building2.size();i++){
						if(Building2.get(i).getType() == 3){Library = true;}
					}
					if(Player2Mana >= 3 && Library && ActiveCreatures2.get(index).Floop()){
						Player2Mana -=3;
						ActiveCreatures2.get(index).addAttack(1);
						return true;
					}else{
						System.out.println("Invalid! either not enough Mana, or no Library, or already Flooped");
						return false;
					}
				}else{
					if(ActiveCreatures2.get(index).Floop()){
						AttackingCreatures2.add(ActiveCreatures2.get(index));
						return true;
					} else {return false;}
				}
			}
		}
		return false;
	}
	public boolean FloopSpell(int player, int index){
		//not complete
		return false;
	}
	public boolean FloopBuilding(int player, int index){
		return false;
	}
	public void unfloopAll(int player){
		if(player == 1){
			for(int i = 0; i< Land1.size();i++){
				Land1.get(i).unFloop();
			}
			for(int i = 0; i< Building1.size();i++){
				Building1.get(i).unFloop();
			}
			for(int i = 0; i< ActiveCreatures1.size();i++){
				ActiveCreatures1.get(i).unFloop();
			}
			for(int i = 0; i< Spell1.size();i++){
				if(Spell1.get(i).unFloop()){
					Spell1.remove(i);
					i--;
				}
			}
		}else{
			for(int i = 0; i< Land2.size();i++){
				Land2.get(i).unFloop();
			}
			for(int i = 0; i< Building2.size();i++){
				Building2.get(i).unFloop();
			}
			for(int i = 0; i< ActiveCreatures2.size();i++){
				ActiveCreatures2.get(i).unFloop();
			}
			for(int i = 0; i< Spell2.size();i++){
				if(Spell2.get(i).unFloop()){
					Spell2.remove(i);
					i--;
				}
			}
		}
		
	}
	public boolean play(int player, int index){
		if(player == 1){
			if(index >= Deck1.size()){
				return false;
			}else{
				if(Deck1.get(index).equals(dLand)){
					Land1.add((Land)Deck1.get(index));
				} else if(Player1Mana < ((Deck1.get(index))).getManaCost()){
					return false;				
				} else if(Deck1.get(index).equals(dCreature)){
					Player1Mana -= ((Deck1.get(index))).getManaCost();
					ActiveCreatures1.add(((Creature)(Deck1.get(index))));
				} else if(Deck1.get(index).equals(dBuilding)){
					Player1Mana -= ((Deck1.get(index))).getManaCost();
					Building1.add((Building)Deck1.get(index));
				} else if(Deck1.get(index).equals(dSpell)){
					Player1Mana -= ((Deck1.get(index))).getManaCost();
					Spell1.add((Spell)(Deck1.get(index)));
				}
				Deck1.remove(index);
				return true;
			}
		}else if(player == 2){
			if(index >= Deck2.size()){
				return false;
			}else{
				if(Deck2.get(index).equals(dLand)){
					Land1.add((Land)Deck2.get(index));
				} else if(Player1Mana < ((Deck2.get(index))).getManaCost()){
					return false;				
				} else if(Deck2.get(index).equals(dCreature)){
					Player2Mana -= ((Deck2.get(index))).getManaCost();
					ActiveCreatures2.add(((Creature)(Deck2.get(index))));
				} else if(Deck2.get(index).equals(dBuilding)){
					Player2Mana -= ((Deck2.get(index))).getManaCost();
					Building2.add((Building)Deck2.get(index));
				} else if(Deck2.get(index).equals(dSpell)){
					Player2Mana -= ((Deck2.get(index))).getManaCost();
					Spell2.add((Spell)(Deck2.get(index)));
				}
				Deck2.remove(index);
				return true;
			}
		}else{return false;}
	}
	public boolean deckGen(int L, int C, int S, int B){
		System.out.println("Not Complete Yet!");
		//not complete at all, but now that the cards are more finished I can wrap it up
		if(L+C+S+B != decksize){
			System.out.println("invalid deckGen parameters, aborting generation");
			return false;
		}else{
			for(int i = 0; i< L; i+=3){
				Deck1.add(makeDirt());
				if(Deck1.size()<L){Deck1.add(makeHills());}
				if(Deck1.size()<L){Deck1.add(makeGrasslands());}
				Deck2.add(makeDirt());
				if(Deck2.size()<L){Deck2.add(makeHills());}
				if(Deck2.size()<L){Deck2.add(makeGrasslands());}
			}
			if(Deck1.size()-L <S){Deck1.add(makeReclaimLandscape());Deck2.add(makeReclaimLandscape());}
			for(int i = 0; i < (S-1); i+=3){
				if(Deck1.size() - L < S){
					Deck1.add(makeCerebralBloodstorm());
					Deck2.add(makeCerebralBloodstorm());
				}
				if(Deck1.size() - L < S){
					Deck1.add(makeOblivionRing());
					Deck2.add(makeOblivionRing());
				}
				if(Deck1.size() - L < S){
					Deck1.add(makeLavaHammer());
					Deck2.add(makeLavaHammer());
				}
			}
			if(C>=1){Deck1.add(makeAncientScholar());Deck2.add(makeAncientScholar());}
			if(C>=2){Deck1.add(makeDragon());Deck2.add(makeDragon());}
			if(C>=3){Deck1.add(makeCow());Deck2.add(makeCow());}
			if(C>=4){Deck1.add(makeGoat());Deck2.add(makeGoat());}
			if(C>=5){Deck1.add(makePig());Deck2.add(makePig());}
			for(int i = 0; i < (C-1); i +=2){
				if(Deck1.size()-L-S < C){
					Deck1.add(makeArcherDan());
					Deck2.add(makeArcherDan());
				}
				if(Deck1.size()-L-S < C){
					Deck1.add(makeHuskerKnight());
					Deck2.add(makeHuskerKnight());
				}
			}
			if(B>=1){Deck1.add(makeLibrary());Deck2.add(makeLibrary());}
			if(B>=2){Deck1.add(makeVolcano());Deck2.add(makeVolcano());}
			if(B>=3){Deck1.add(makeLibrary());Deck2.add(makeLibrary());}
			if(B>=4){Deck1.add(makeSpiritTower());Deck2.add(makeSpiritTower());}
			if(B>=5){Deck1.add(makeSiloofTruth());Deck2.add(makeSiloofTruth());}
			for(int i = 0; i < (B-5);i++){
				Deck1.add(makeCastle());
				Deck2.add(makeCastle());
			}
		}
	return true;	
	}
	public void shuffle(int deck){
		//Pretty much complete, could be more efficient
		ArrayList<Integer> shuffler = new ArrayList<Integer>();
		int num;
		while(shuffler.size()<decksize){
			num = (int)(Math.random()*(double)(decksize));
			boolean inYet = false;
			for(int i = 0; i < shuffler.size();i++){
				if(num == shuffler.get(i)){
					inYet = true;
				}
			}
			if(!inYet){
				shuffler.add(num);
			}
		}
		ArrayList<Card> tempArray = new ArrayList<Card>();
		if(deck == 1){
		for(int i = 0; i < decksize; i++){
			tempArray.add(Deck1.get(shuffler.get(i)));
		}
		Deck1 = tempArray;
		}else{
			for(int i = 0; i < decksize; i++){
				tempArray.add(Deck2.get(shuffler.get(i)));
			}
			Deck2 = tempArray;
		}
	}
	public Land makeDirt(){
		return new Land(1);
	}
	public Land makeHills(){
		return new Land(2);
	}
	public Land makeGrasslands(){
		return new Land(3);
	}
	public Spell makeCerebralBloodstorm(){
		return new Spell(false, 1, true);
	}
	public Spell makeReclaimLandscape(){
		return new Spell(false, 2, false);
	}
	public Spell makeOblivionRing(){
		return new Spell(false, 3, true);
	}
	public Spell makeLavaHammer(){
		return new Spell(false, 4, true);
	}
	public Creature makePig(){
		return new Creature(1);
	}
	public Creature makeGoat(){
		return new Creature(2);
	}
	public Creature makeCow(){
		return new Creature(3);
	}
	public Creature makeHuskerKnight(){
		return new Creature(4);
	}
	public Creature makeArcherDan(){
		return new Creature(5);
	}
	public Creature makeAncientScholar(){
		return new Creature(6);
	}
	public Creature makeDragon(){
		return new Creature(7);
	}
	public Building makeCave(){
		return new Building(1);
	}
	public Building makeCastle(){
		return new Building(2);
	}
	public Building makeLibrary(){
		return new Building(3);
	}
	public Building makeVolcano(){
		return new Building(4);
	}
	public Building makeSpiritTower(){
		return new Building(5);
	}
	public Building makeSiloofTruth(){
		return new Building(6);
	}
}
