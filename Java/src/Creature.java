import java.util.ArrayList;
public class Creature extends Card {
	int cardNum;
	String Name;
	String Description;
	ArrayList Abilities = new ArrayList();

	public Creature(boolean t) {
		super(t);
	}

}
