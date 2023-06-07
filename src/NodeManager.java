import java.util.ArrayList;

public class NodeManager {
	private ArrayList<Node> nodes= new ArrayList<Node>();
	private ArrayList<Node> visitedNodes= new ArrayList<Node>();
	private Node currentNode;
	
	public NodeManager() {}
	public NodeManager(ArrayList<Node>nodes) {
		this.nodes=nodes;
		Node start = this.getStartNode();
		visitedNodes.add(start);
	}
	public Node getCurrentNode() {
		return currentNode;
	}
	
	public Node getStartNode() {
		for(Node n: nodes)
			if(n.getNodeType()==Node.nodeType.START)
				return n;
		
		return null;
	}
	
	public boolean onStartingNode() {
		if(currentNode.getNodeType()==Node.nodeType.START)
			return true;
		else return false;
	}
	
	public Node getFinishNode() {
		for(Node n: nodes)
			if(n.getNodeType()==Node.nodeType.FINISH)
				return n;
		
		return null;
	}
	
	public boolean onFinalNode() {
		if(currentNode.getNodeType()==Node.nodeType.FINISH)
			return true;
		else return false;
	}
	
	public Node getNodeById(int id) {
		for(Node n: nodes)
			if(n.getId() == id)
				return n;
		
		return null;
	}
	
	
//	public boolean availablePath(Node pivot, ArrayList<Node>oldVirtualVisitedNodes) {
//		System.out.println("Pivot : " + pivot.getId());
//		ArrayList<Node> availableNodes= new ArrayList<Node>();
//		for(Node n : pivot.getLinkedNodes()) {
//			if(! oldVirtualVisitedNodes.contains(n)) {
//				availableNodes.add(n);
//				System.out.println("Node " + n.getId() + " available");
//			}
//		}
//		
//		System.out.println("\n");
//		
//		if(availableNodes.isEmpty())
//			return false;
//		
//		boolean pathFound=false;
//		for(Node n : availableNodes) {
//			if(n.getNodeType()==Node.nodeType.FINISH) {
//				System.out.println("Path available");
//				pathFound=true;
//			}
//			else {
//				System.out.println("Check for " + n.getId());
//				ArrayList<Node>virtualVisitedNodes = (ArrayList<Node>)oldVirtualVisitedNodes.clone();
//				virtualVisitedNodes.add(pivot);
//				if(availablePath(n, virtualVisitedNodes))
//					return true;
//				}
//			}
//		return pathFound;
//	}
//
//	public boolean availablePath2(Node pivot, ArrayList<Node>visitedNodes) {
//		Node finish=getFinishNode();
//		ArrayList<Node>availableNodes = (ArrayList<Node>)nodes.clone();
//		
//		for(Node n : visitedNodes) {
//			if(visitedNodes.contains(n))
//				availableNodes.remove(n);
//		}
//		
//		ArrayList<Node>consideredNodes= new ArrayList<Node>();
//		for(Node p : pivot.getLinkedNodes())
//			if(availableNodes.contains(p))
//				if(p.getNodeType()==Node.nodeType.FINISH)
//					return true;
//				else consideredNodes.add(p);
//		
//		for(consideredNodes.clone())
//		
//		return false;
//	}
	
	public ArrayList<Node> getNextNodes() {
		ArrayList<Node> nextNodes = new ArrayList<Node>();
		if(currentNode.getLinkedNodes().isEmpty() )
			return null;
		else for(Node n : currentNode.getLinkedNodes())
				if( (!visitedNodes.contains(n)))
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
		
		currentNode=start;
		visitedNodes.add(start);
		
		return nodes;
	}
	
	public ArrayList<Node> generateGraph(){
		return null;
	}
}
