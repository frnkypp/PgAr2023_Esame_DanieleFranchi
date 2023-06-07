import java.util.ArrayList;

public class Monster extends Entity{
	
	public Monster(ArrayList<Modifier> modifiers) {
		super(12,3);
		this.applyModifiers(modifiers);
	}
}
