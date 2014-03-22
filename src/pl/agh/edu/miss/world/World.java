package pl.agh.edu.miss.world;

import pl.agh.edu.miss.animals.Predator;
import pl.agh.edu.miss.animals.Animal;
import pl.agh.edu.miss.graphics.WorldMap;

public class World {
	private static int sizeY = 500;
	private static int sizeX = 500;
	private static Cell cell[][] = new Cell[sizeX][sizeY];
	
	private static volatile World instance; 
	
	private World(){
		for(int i = 0; i < sizeX; i++)
			for(int j = 0; j < sizeY; j++)
				cell[i][j] = new Cell();
	};
	
	
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
		WorldMap.draw(x, y);
		return cell[x][y];
	}

	public static void setCell(int x, int y) {
		World.cell[x][y] = cell[x][y];
//		WorldMaip.draw(x, y);
	}

	public static void setInstance(World instance) {
		World.instance = instance;
	}
	
	public static void repaintWorld(){
		while (true) {
			for (int i = 0; i < sizeX; i++)
				for (int j = 0; j < sizeY; j++) {
					if (cell[i][j].getAnimal() instanceof Predator)
						WorldMap.draw(i, j);
					else
						WorldMap.remove(i, j);
				}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
