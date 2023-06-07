import java.util.ArrayList;

import it.kibo.fp.lib.InputData;
import it.kibo.fp.lib.RandomDraws;

public class World {
	private int id;
	private NodeManager nodeManager;
	private boolean completed=false;
	private int award;
	
	private static int idCounter;
	
	public World(int award) {
		id = idCounter;
		idCounter++;
		
		nodeManager = new NodeManager();
		nodeManager.generateBasicGraph();
		this.award = award;
	}
	
	public int getId() {
		return id;
	}
	
	public NodeManager getNodeManager() {
		return nodeManager;
	}
	
	public int getAward() {
		return award;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	
	public Node selectNode(ArrayList<Node> nodes) {
		System.out.println("Now on " + nodeManager.getCurrentNode().getId());
		System.out.println("Scegli la tua strada [1-" + nodes.size() + "]" );
		int selection = InputData.readIntegerBetween("Inserisci il nodo da raggiungere: ", 1, nodes.size());
		return nodes.get(selection-1);
	}
	
	public void foundModifier(Player player) {
		System.out.println("Loot");
		ArrayList<Modifier> modifiers = new ArrayList<Modifier>();
		modifiers.add(new Modifier(Modifier.modifierType.HEALTH,-5,10));
		modifiers.add(new Modifier(Modifier.modifierType.ATTACK,-3,3));
		
		player.applyModifiers(modifiers);
	}
	
	public void foundMonster(Player player) {
		System.out.println("Mostro");
		ArrayList<Modifier> modifiers = new ArrayList<Modifier>();
		modifiers.add(new Modifier(Modifier.modifierType.HEALTH,-5,5));
		modifiers.add(new Modifier(Modifier.modifierType.ATTACK,-2,2));
		
		Monster monster = new Monster(modifiers);
		Fight fight = new Fight(player,monster);
		fight.fight();
	}
	
	public void bossFight(Player player) {
		ArrayList<Modifier> modifiers = new ArrayList<Modifier>();
		modifiers.add(new Modifier(Modifier.modifierType.HEALTH,-5,5));
		modifiers.add(new Modifier(Modifier.modifierType.ATTACK,-2,2));
		
		Boss boss = new Boss(modifiers);
		Fight fight = new Fight(player,boss);
		fight.fight();
		if(!player.isDead())
			completed=true;
	}
	
	public void onNode(Player player) {
		System.out.println("Current node: " + nodeManager.getCurrentNode());
		if(nodeManager.onStartingNode())
			return;
		
		if(nodeManager.onFinalNode()) {
			bossFight(player);
			return;
		}
		
		double rand = RandomDraws.drawDouble(0, 1);
		if(rand<0.5) {
			foundModifier(player);
		}else foundMonster(player);
			
	}
	
	public void play(Player player) {
		while(true) {
			onNode(player);
			if(player.isDead()) {
				System.out.println("Il giocatore " + player.getName() + " è morto!");
				player.lifeLost();
				break;
			}else if(completed) {
				System.out.println("Il giocatore " + player.getName() + " ha battuto il boss!");
				player.addPoints(award);
				System.out.println("Il giocatore " + player.getName() + " riceve " + award + " punti");
				break;
			}else {
				nodeManager.goToNode( selectNode(nodeManager.getNextNodes()) );
			}
				
		}
	}
	
	public String toString() {
		return "World " + id + "\tcompleted: " + completed;
	}
	
	
}
