
public class Cell {
	int row;
	int col;
	boolean visited;
	boolean hasPokemon;
	boolean wallUp;
	boolean wallDown;
	boolean wallLeft;
	boolean wallRight;
public Cell(int row, int col) {
		
		this.row = row;
		this.col = col;
		this.visited = false;
		this.hasPokemon = false;
		this.wallUp = true;
		this.wallDown = true;
		this.wallLeft = true;
		this.wallRight = true;
	}

}
