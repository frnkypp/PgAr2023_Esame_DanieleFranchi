import it.kibo.fp.lib.RandomDraws;

public class Modifier {
	public enum modifierType{ATTACK,HEALTH};
	
	modifierType type;
	private double value;
	
	public Modifier(modifierType type, double range_min, double range_max) {
		this.type = type;
		value = (double) Math.round(RandomDraws.drawDouble(range_min, range_max));
	}
	
	public modifierType getType() {return type;}
	
	public double getValue() {
		return value;
	}
	
	public String toString() {
		StringBuffer description = new StringBuffer();
		description.append("--Modifier : ");
		description.append(type.toString() + " : " + value + "\n");
		return description.toString();
	}
	
}
