
public class ArnaldoVerse {
	public static void main(String args[]) {
		System.out.println("Test");
		
		
		
		Modifier m = new Modifier(Modifier.modifierType.ATTACK,-5,5);
		System.out.println(m);
		
		World w1= new World(30);
		Player p1 = new Player("tizio");
		w1.play(p1);
	}
}
