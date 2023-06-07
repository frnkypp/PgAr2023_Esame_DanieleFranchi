import java.util.ArrayList;

public class NodeManager {
	private ArrayList<Node> nodes;
	private ArrayList<Node> visitedNodes;
	private Node currentNode;
	
	public NodeManager() {}
	public NodeManager(ArrayList<Node>nodes) {
		this.nodes=nodes;
		Node start = this.getStartNode();
		visitedNodes.add(start);
	}
	
	public Node getStartNode() {
		for(Node n: nodes)
			if(n.getNodeType()==Node.nodeType.START)
				return n;
		
		return null;
	}
	
	public Node getFinishNode() {
		for(Node n: nodes)
			if(n.getNodeType()==Node.nodeType.FINISH)
				return n;
		
		return null;
	}
	
	public Node getNodeById(int id) {
		for(Node n: nodes)
			if(n.getId() == id)
				return n;
		
		return null;
	}
	
	public ArrayList<Node> getNextNodes() {
		ArrayList<Node> nextNodes = new ArrayList<Node>();
		if(currentNode.getLinkedNodes().isEmpty() )
			return null;
		else for(Node n : currentNode.getLinkedNodes())
				if( !visitedNodes.contains(n) )
					nextNodes.add(n);
		
		return nextNodes;
	}
	
	public void goToNode(Node n) {
		if(getNextNodes().contains(n)) {
			visitedNodes.add(currentNode);
			currentNode = n;
		}
	}
	
	public String toString() {
		StringBuffer description = new StringBuffer();
		for(Node n: nodes) {
			description.append(n.toString());
			}
		
		return description.toString();
	}
	
	/**
	 * Genera un grafo per il caso base
	 * 
	 * 	  b
	 * S-a d-e-F
	 *    c
	 * @return
	 */
	public ArrayList<Node> generateBasicGraph() {
		nodes = new ArrayList<Node>();
		Node start = new Node(Node.nodeType.START);
		Node finish = new Node(Node.nodeType.FINISH);
		nodes.add(start);
		nodes.add(finish);
		Node a = new Node(Node.nodeType.COMMON);
		Node b = new Node(Node.nodeType.COMMON);
		Node c = new Node(Node.nodeType.COMMON);
		Node d = new Node(Node.nodeType.COMMON);
		Node e = new Node(Node.nodeType.COMMON);
		
		nodes.add(a);
		nodes.add(b);
		nodes.add(c);
		nodes.add(d);
		nodes.add(e);
		
		start.linkNode(a);
		a.linkNode(b);
		a.linkNode(c);
		b.linkNode(d);
		c.linkNode(d);
		d.linkNode(e);
		e.linkNode(finish);
		
		return nodes;
	}
}
