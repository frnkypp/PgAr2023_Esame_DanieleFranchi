import java.util.ArrayList;

public class Boss extends Entity {
	public Boss(ArrayList<Modifier> modifiers) {
		super(18,4);
		this.applyModifiers(modifiers);
	}
}
