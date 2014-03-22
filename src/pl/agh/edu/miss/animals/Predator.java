package pl.agh.edu.miss.animals;

public class Predator extends Animal{

	public Predator(int x, int y) {
		super(x, y);
		world.getCell(x, y).setAnimal(this);
	}
	
	public void moveTo(int x, int y){
		super.moveTo(x, y);
	}

}
