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
	ArrayList<Spell> Oring1 = new ArrayList<Spell>();
	ArrayList<Spell> Oring2 = new ArrayList<Spell>();
	ArrayList<Creature> ActiveCreatures1 = new ArrayList<Creature>();
	ArrayList<Creature> ActiveCreatures2 = new ArrayList<Creature>();
	Card ActiveCard; Land dLand = new Land(0); Creature dCreature = new Creature(0);
	Spell dSpell = new Spell(false,0, false); Building dBuilding = new Building(false,0);
	int Player1Health = 20; int Player2Health = 20;
	int Player1Mana = 0; int Player2Mana = 0;
	private final int decksize;
	public Field(int d){
		decksize = d;
	}
	public boolean deckCheck(){
		if(Deck1.size() > decksize || Deck2.size() > decksize){
			return true;
		}else{return false;}
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
					//if()
				}
				Deck1.remove(index);
				return true;
			}
		}else if(player == 2){
			
		}else{return false;}
		return true;
	}
	public boolean deckGen(int L, int C, int S, int B){
		System.out.println("Not Complete Yet!");
		if(L+C+S+B != decksize){
			System.out.println("invalid deckGen parameters, aborting generation");
			return false;
		}else{
			int color1; int color2;
			if(Math.random()>=.50000000){
				color1 = 1;
				color2 = 2;
			}else{ color1 = 2; color2 = 1;}
			for(int i = 0; i < L; i++){
				Deck1.add(new Land(color1));
				Deck2.add(new Land(color2));
			}
		}
	return true;	
	}
	public void shuffle(int deck){
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

}
