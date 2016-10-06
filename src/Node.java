
public abstract class Node {
	State state;
	Node parent;
	String operator;
	int depth;
	int pathcost;
	boolean expanded;
public Node(State state, Node parent, String operator, int depth,
			int pathcost) {
		super();
		this.state = state;
		this.parent = parent;
		this.operator = operator;
		this.depth = depth;
		this.pathcost = pathcost;
		this.expanded=false;
	}



}