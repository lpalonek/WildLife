package pl.agh.edu.miss.world;

import pl.agh.edu.miss.graphics.WorldMap;

public class World {
	private static int sizeY = 200;
	private static int sizeX = 200;
	private static Cell cell[][] = new Cell[sizeX][sizeY];
	
	private static volatile World instance; 
	
	private World(){};
	
	public static World getInstance(){
		if( instance == null)
			instance = new World();
		return instance;
	}
	
	public static int getSizeY() {
		return sizeY;
	}

	public static void setSizeY(int sizeY) {
		World.sizeY = sizeY;
	}

	public static int getSizeX() {
		return sizeX;
	}

	public static void setSizeX(int sizeX) {
		World.sizeX = sizeX;
	}

	public static Cell getCell(int x, int y) {
		return cell[x][y];
	}

	public static void setCell(int x, int y) {
		World.cell[x][y] = cell[x][y];
		WorldMap.draw(x, y);
	}

	public static void setInstance(World instance) {
		World.instance = instance;
	}

}
