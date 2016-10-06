import java.util.ArrayList;

public class MazeGen {
    Cell[][] maze;
    ArrayList<Cell> cellsList;
    ArrayList<Integer> wallsList;
//    0 for Up, 1 for Down, 2 for right, 3 for left
    Cell startingCell;
    int m;
    int n;

    public MazeGen(){
        m = (int)(Math.random()* 5) + 3;
        n = (int)(Math.random()* 5) + 3;
        System.out.println( m + ", " + n);
        this.maze = new Cell[m][n];
        this.cellsList = new ArrayList<Cell>();
        this.wallsList = new ArrayList<Integer>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = new Cell(i, j);
            }
        }

        int row = (int)(Math.random()* m);
        int col = (int)(Math.random()* n);
        System.out.println("StartingPoint: "+  row + ", " + col);
        startingCell = maze[row][col];
        Cell currentCell =  maze[row][col];
        currentCell.visited = true;

        do {
            row = currentCell.row;
            col = currentCell.col;

            if(row != 0){
                if(!maze[row - 1][col].visited){
                    cellsList.add(currentCell);
                    wallsList.add(1);
                }
            }

            if(row != m - 1){
                if(!maze[row + 1][col].visited){
                    cellsList.add(currentCell);
                    wallsList.add(0);
                }
            }

            if(col != 0){
                if(!maze[row][col - 1].visited){
                    cellsList.add(currentCell);
                    wallsList.add(3);
                }
            }

            if(col != n - 1){
                if(!maze[row][col + 1].visited){
                    cellsList.add(currentCell);
                    wallsList.add(2);
                }
            }
            System.out.print("Before: ");
            for (int i = 0; i < wallsList.size(); i++) {
                System.out.print(wallsList.get(i));
            }
            System.out.println();

            int random =(int) (Math.random() * (wallsList.size()));

            if (wallsList.get(random) == 0){
                Cell newCell = cellsList.get(random);
                if(!maze[newCell.row + 1][newCell.col].visited) {
                    newCell.wallUp = false;
                    currentCell = maze[newCell.row + 1][newCell.col];
                    currentCell.wallDown = false;
                    currentCell.visited = true;
                }
                wallsList.remove(random);
                cellsList.remove(random);
            }else{

                if (wallsList.get(random) == 1){
                    Cell newCell = cellsList.get(random);
                    if(!maze[newCell.row - 1][newCell.col].visited) {
                        newCell.wallDown = false;
                        currentCell = maze[newCell.row - 1][newCell.col];
                        currentCell.wallUp = false;
                        currentCell.visited = true;
                    }
                    wallsList.remove(random);
                    cellsList.remove(random);
                }else{

                    if (wallsList.get(random) == 2){
                        Cell newCell = cellsList.get(random);
                        if(!maze[newCell.row][newCell.col + 1].visited) {
                            newCell.wallRight = false;
                            currentCell = maze[newCell.row][newCell.col + 1];
                            currentCell.wallLeft = false;
                            currentCell.visited = true;
                        }
                        wallsList.remove(random);
                        cellsList.remove(random);
                    }else{

                        if (wallsList.get(random) == 3){
                            Cell newCell = cellsList.get(random);
                            if(!maze[newCell.row][newCell.col - 1].visited) {
                                newCell.wallLeft = false;
                                currentCell = maze[newCell.row][newCell.col - 1];
                                currentCell.wallRight = false;
                                currentCell.visited = true;
                            }
                            wallsList.remove(random);
                            cellsList.remove(random);
                        }
                    }
                }
            }
            System.out.print("After " + random +": ");
            for (int i = 0; i < wallsList.size(); i++) {
                System.out.print(wallsList.get(i));
            }
            System.out.println();
        }while (!cellsList.isEmpty());


    }

    public static void main(String[]args){
        MazeGen maze = new MazeGen();
        for (int i = 0; i < maze.m; i++) {
            System.out.println();System.out.println();
            for (int j = 0; j < maze.n; j++) {
                Cell m = maze.maze[i][j];
                System.out.print(m.row + ", " + m.col + ", " + m.wallUp + ", " + m.wallDown + ", " + m.wallRight + ", " + m.wallLeft + ",...... " + m.visited);
                System.out.println();
            }
        }

    }

}
