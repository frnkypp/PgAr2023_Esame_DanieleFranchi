import java.util.ArrayList;

public class Node {
	public enum nodeType{START,FINISH,COMMON};
	private int id;
	private nodeType type;
	private Node previousNode;
	private ArrayList<Node> linkedNodes=new ArrayList<Node>();
	
	private static int idCounter=0;
	
	
	public int getId() {return id;}
	public nodeType getNodeType() { return type;}
	public Node getPreviousNode() {return previousNode;}
	public ArrayList<Node> getLinkedNodes() {return linkedNodes;}
	
	public Node() {}
	
	public Node(nodeType type) {
		this.id=idCounter;
		idCounter++;
		this.type = type;
		
		if(type == nodeType.START)
			previousNode = null;
	}
	
	public void linkNode(Node node) {
		if( !(node.getLinkedNodes().contains(this) || this.getLinkedNodes().contains(node)) ) { // nodi non ancora collegati
			this.linkedNodes.add(node);
			node.linkedNodes.add(this);
		}
	}
	
	public String toString() {
		StringBuffer description = new StringBuffer();
		description.append("Node ID:" + id + "\n");
		description.append("Type: " + type.toString() + "\n");
		
		if(previousNode != null)
			description.append("previousNode: " + previousNode.getId() + "\n");
		
		description.append("Nodes: \n");
		for(Node n: linkedNodes) {
			description.append(n.getId() + " ");
		}
		
		description.append("\n----------------\n");
		
		return description.toString();
	}
}
