package pl.agh.edu.miss.world;

import pl.agh.edu.miss.animals.Animal;

public class Cell {
	private Animal animal;
	private boolean grass;
	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public boolean isGrass() {
		return grass;
	}
	public void setGrass(boolean grass) {
		this.grass = grass;
	}
	
	
}
