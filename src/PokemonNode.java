import java.util.ArrayList;


public class PokemonNode extends Node{
	public PokemonNode(PokemonState state, PokemonNode parent, String operator, int depth,
			int pathcost) {
		super(state, parent, operator, depth, pathcost);
		
	}
	//a method that generates the next state of a state based on the operator;
	//it return null if for this state and operator there is no next state
	public PokemonState getchild(String operator , PokemonState state){
		switch(operator){
		case("Forward"):{
			// if the operator is Forward and orientation is North and there is
			//no wall above the cell a new state will be returned with an incremented row number and 
			//moves made by the agent
			//if this particular cell has a pokemon and this cell wasn't visited 
			//before by the agent in the new state the number 
			//of pokemons collected by the agent will be incremented.
			//we should add a value  that doesn't let the agent go outside
			//the grid
			if(state.orientation.equals("North")&&state.cell.wallUp==false){
				
				if(state.cell.hasPokemon&&!state.cell.visited){
				state.cell.row++;
				state.moves++;
				state.pokemonscollected++;
				return state;
				}
				if(!state.cell.hasPokemon){
					state.cell.row++;
					state.moves++;
					return state;
				
					}
					
								
			}
			//if however there's a wall above the cell where the agent is 
			//standing the agent cannot move forward and therefore there is no next state
			//so the method returns null.
			if(state.orientation.equals("North")&&state.cell.wallUp==true){
				return null;
			}
			// if the operator is Forward and orientation is North and there is
			//no wall below the cell a new state will be returned with a decremented row number and 
			//incremented number of moves made by the agent
			//if this particular cell has a pokemon and this cell wasn't visited 
			//before by the agent in the new state the number 
			//of pokemons collected by the agent will be incremented.
            if(state.orientation.equals("South")&&state.cell.wallDown==false){
            	if(state.cell.hasPokemon&&!state.cell.visited){
    				state.cell.row--;
    				state.moves++;
    				state.pokemonscollected++;
    				return state;
    				}
    				if(!state.cell.hasPokemon){
    					state.cell.row--;
    					state.moves++;
    					return state;
    				
    					}
    					
    								
    			}
          //if however there's a wall below the cell where the agent is 
			//standing the agent cannot move forward and therefore there is no next state
			//so the method returns null.
    			if(state.orientation.equals("South")&&state.cell.wallDown==true){
    				return null;
    			}
				
    			// if the operator is Forward and orientation is East and there is
    			//no wall on the right of the cell a new state will be returned with a incremented column number and 
    			//incremented number of moves made by the agent
    			//if this particular cell has a pokemon and this cell wasn't visited 
    			//before by the agent in the new state the number 
    			//of pokemons collected by the agent will be incremented.
            if(state.orientation.equals("East")&&state.cell.wallRight==false){
            	if(state.cell.hasPokemon){
    				state.cell.col++;
    				state.moves++;
    				state.pokemonscollected++;
    				return state;
    				}
    				if(!state.cell.hasPokemon){
    					state.cell.col++;
    					state.moves++;
    					return state;
    				
    					}
    					
    								
    			}
            //if however there's a wall on the right of the cell where the agent is 
			//standing the agent cannot move forward and therefore there is no next state
			//so the method returns null.
    			if(state.orientation.equals("East")&&state.cell.wallRight==true){
    				return null;
    			}
	
    			// if the operator is Forward and orientation is West and there is
    			//no wall below the cell a new state will be returned with a decremented column number and 
    			//incremented number of moves made by the agent
    			//if this particular cell has a pokemon and this cell wasn't visited 
    			//before by the agent in the new state the number 
    			//of pokemons collected by the agent will be incremented.
            if(state.orientation.equals("West")&&state.cell.wallLeft==false){
            	if(state.cell.hasPokemon){
    				state.cell.col--;
    				state.moves++;
    				state.pokemonscollected++;
    				return state;
    				}
    				if(!state.cell.hasPokemon){
    					state.cell.col--;
    					state.moves++;
    					return state;
    				
    					}
    					
    								
    			}
            //if however there's a wall on the left of the cell where the agent is 
			//standing the agent cannot move forward and therefore there is no next state
			//so the method returns null.
    			if(state.orientation.equals("West")&&state.cell.wallLeft==true){
    				return null;
    			}
		}
		//if the operator is rotate right the next state will
		//contain the new orientation of the agent based on its current orientation
		case("RotateRight"):{
			if(state.orientation.equals("North"))
				state.orientation="East";
			if(state.orientation.equals("South"))
				state.orientation="West";
			if(state.orientation.equals("East"))
				state.orientation="South";
			if(state.orientation.equals("West"))
				state.orientation="North";
			return state;
			
		}
		//if the operator is rotate left the next state will
				//contain the new orientation of the agent based on its current orientation
		case("RotateLeft"):{
			if(state.orientation.equals("North"))
				state.orientation="West";
			if(state.orientation.equals("South"))
				state.orientation="East";
			if(state.orientation.equals("East"))
				state.orientation="North";
			if(state.orientation.equals("West"))
				state.orientation="South";
			return state;
			
		}
            }
		return null;
			
		}
		
}


