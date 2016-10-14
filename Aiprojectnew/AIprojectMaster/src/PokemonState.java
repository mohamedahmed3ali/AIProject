
public class PokemonState extends State {
	Cell cell;
	String orientation;
	int moves;
	int pokemonscollected;

	public PokemonState(Cell cell, String orientation, int moves,
			int pokemonscollected) {
		
		this.cell = cell;
		this.orientation = orientation;
		this.moves = moves;
		this.pokemonscollected = pokemonscollected;
	}

}
