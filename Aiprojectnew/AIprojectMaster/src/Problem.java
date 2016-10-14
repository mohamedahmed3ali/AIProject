import java.util.ArrayList;

/**
 * Created by ASUS PC on 9/26/2016.
 */
public abstract class Problem {
    String[] operators;
    State initialState;
    int pathCost;
    PokemonState GoalState; // this state will be initialized by Genmaze();
    public Problem(){

    }
    public  Problem(String[] operators, State initialState, int pathCost , PokemonState GoalState){
        this.initialState = initialState;
        this.operators = operators;
        this.pathCost = pathCost;
        this.GoalState= GoalState;
    }
    public boolean GoalTest(PokemonState current , PokemonState GoalState){
        //	if(current.cell.row==GoalState.cell.row && current.cell.col==GoalState.cell.col &&
        	//		current.moves==GoalState.moves && current.pokemonscollected==GoalState.pokemonscollected)
        	if(current.equals(GoalState))
        		return true;
        	return false;
        }
    public int Heuristic1(PokemonState currentstate , Problem p){
    	int Manhattan1=Math.abs((p.GoalState.cell.row-currentstate.cell.row)
    			+Math.abs(p.GoalState.cell.col-currentstate.cell.col));
    	return Manhattan1;
    	
    }
    //pass the 2 arrays for pokemon locations here//
    public int Heuristic2(PokemonState currentstate, Problem p, int[]Pokemonxlocations, int[]Pokemonylocations){
    	int Manhattan2=Math.abs((Pokemonxlocations[0]-currentstate.cell.row)
    			+Math.abs(Pokemonylocations[0]-currentstate.cell.col));
    	for(int i=1;i<Pokemonxlocations.length;i++){
    		if((Math.abs((Pokemonxlocations[i]-currentstate.cell.row)
    			+Math.abs(Pokemonylocations[i]-currentstate.cell.col))<Manhattan2))
    			Manhattan2=Math.abs((Pokemonxlocations[i]-currentstate.cell.row)
    	    			+Math.abs(Pokemonylocations[i]-currentstate.cell.col));
    	}
    	return Manhattan2+Heuristic1(currentstate,p);
    }
    public int Heuristic3(PokemonState currentstate, Problem p ){
    	int timeunitsleft=p.GoalState.moves-currentstate.moves;
    	return Heuristic1(currentstate,p)+timeunitsleft;
    }
    public void Qingfun(ArrayList<PokemonNode>Nodes,String Strategy,PokemonNode currentnode , Problem p){
    	//loops on all the operators of the problem p
    	for(int i = 0; i <= p.operators.length; i++){
    		//it  expands the current state of the node with one of the operators
    		if(currentnode.getchild(p.operators[i],((PokemonState)currentnode.state))!=null){
    			//if there is a possible next state using this operator it creates a node
    			// of it setting the parent of it to be the expanded node, the operator to generate it , it sets the value
    			// of depth and path cost to be equal to the parent node's value+1
    			//it also sets the boolean expanded of the parent node to be true
    	
    		PokemonState nextstate=currentnode.getchild(p.operators[i],((PokemonState)currentnode.state));
    		currentnode.expanded=true;
    		PokemonNode child= new PokemonNode(nextstate,currentnode,p.operators[i],currentnode.depth+1,currentnode.pathcost+1);
    		// if the search strategy is breadth first it adds the new node to the end of the queue
    		if(Strategy=="BF")
    			Nodes.add(Nodes.size()-1, child);
    		// if the search strategy is depth first it adds the new node to the begining of the queue
    		if(Strategy=="DF")
    			Nodes.add(0, child);
    		// if the search strategy is iterative deepining it loops from depth 0 to infinity
    		//it only adds the node if the value of the depth is greater or equal to the depth 
    		//of its children...it also adds the node at the begining of the queue
    		if(Strategy=="ID"){
    			int depth=0;
    			while(true){
    				if(depth==child.depth)
    					Nodes.add(0, child);
    				else{
    					depth++;
    				}
    			}
    		}
    		// if the search strategy is uniform cost it loops on the whole queue and
    		//compares the path cost of the node to the path cost of the nodes in the queue
    		// it places the new node somewhere in the queue where all the nodes after this point are 
    		// of greater path cost , and it switches those nodes one step to the right
    		if(Strategy=="UC"){
    			for(int j=0;j<Nodes.size();j++){
    				if(Nodes.get(j).pathcost>child.pathcost){
    					for(int z=Nodes.size()-1;z>j;z--)
    						Nodes.add(z+1,Nodes.get(z));
    					Nodes.add(j,child);
    										
    				}
    			}
    		}
    		if(Strategy=="GR1"){
    			for(int j=0;j<Nodes.size();j++){
    				if((Heuristic1((PokemonState)Nodes.get(j).state,this))
    						>(Heuristic1((PokemonState)child.state,this))){
    					for(int z=Nodes.size()-1;z>j;z--)
    						Nodes.add(z+1,Nodes.get(z));
    					Nodes.add(j,child);
    										
    				}
    			}
    			
    		}
    		if(Strategy=="GR2"){
    			for(int j=0;j<Nodes.size();j++){
    				if((Heuristic2((PokemonState)Nodes.get(j).state))//pass pokemon locations here//
    						>(Heuristic2((PokemonState)child.state))){//pass pokemon locations here//
    					for(int z=Nodes.size()-1;z>j;z--)
    						Nodes.add(z+1,Nodes.get(z));
    					Nodes.add(j,child);
    										
    				}
    			}
    			
    		}
    		if(Strategy=="GR3"){
    			for(int j=0;j<Nodes.size();j++){
    				if((Heuristic3((PokemonState)Nodes.get(j).state,p))
    						>(Heuristic3((PokemonState)child.state,p))){
    					for(int z=Nodes.size()-1;z>j;z--)
    						Nodes.add(z+1,Nodes.get(z));
    					Nodes.add(j,child);
    										
    				}
    			}
    			
    		}
    			
    	
    
    	if(Strategy=="AS1"){
			for(int j=0;j<Nodes.size();j++){
				if((Heuristic1((PokemonState)Nodes.get(j).state,this)+Nodes.get(j).pathcost)
						>(Heuristic1((PokemonState)child.state,this))+child.pathcost){
					for(int z=Nodes.size()-1;z>j;z--)
						Nodes.add(z+1,Nodes.get(z));
					Nodes.add(j,child);
										
				}
			}
			
		}
		if(Strategy=="AS2"){
			for(int j=0;j<Nodes.size();j++){
				if((Heuristic2((PokemonState)Nodes.get(j).state)+Nodes.get(j).pathcost)//pass pokemon locations here//
						>(Heuristic2((PokemonState)child.state))+child.pathcost){//pass pokemon locations here//
					for(int z=Nodes.size()-1;z>j;z--)
						Nodes.add(z+1,Nodes.get(z));
					Nodes.add(j,child);
										
				}
			}
			
		}
		if(Strategy=="AS3"){
			for(int j=0;j<Nodes.size();j++){
				if((Heuristic3((PokemonState)Nodes.get(j).state,p)+Nodes.get(j).pathcost)
						>(Heuristic3((PokemonState)child.state,p))+child.pathcost){
					for(int z=Nodes.size()-1;z>j;z--)
						Nodes.add(z+1,Nodes.get(z));
					Nodes.add(j,child);
										
				}
			}
			
		}
    		}
    	}
			
	}

    
    public Node GeneralSearch(Problem p,String Strategy){
    	
    	ArrayList<PokemonNode>  Nodes = new ArrayList();
    	//set the root node to a node with an  initial state of the problem(which will be set by genmaze)
    	// a parent of null ,no operator leading to this node  and depth and path cost to be zero
    	PokemonNode initial = new PokemonNode((PokemonState)(p.initialState),null,"",0,0);
    	Nodes.add(initial);
    	while(true){
    	if(Nodes.isEmpty())
    		return null;
    	// save the node at front before removing
    	PokemonNode currentnode = (PokemonNode)(Nodes.get(0));
    	Nodes.remove(0);
    	//if the state  of the current node satisfies the goal test return the node
    	if(p.GoalTest((PokemonState)currentnode.state , p.GoalState))
    		return currentnode;
    	//calls qingfun 
    	else
    		Qingfun(Nodes,Strategy,currentnode,p);
    	}
    }
    
}