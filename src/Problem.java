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
    public  Problem(String[] operators, State initialState, int pathCost , PokemonState GoalTest){
        this.initialState = initialState;
        this.operators = operators;
        this.pathCost = pathCost;
        this.GoalState= GoalTest;
    }
    
}