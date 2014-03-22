package pl.agh.edu.miss.animals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pl.agh.edu.miss.graphics.WorldMap;
import pl.agh.edu.miss.world.Cell;
import pl.agh.edu.miss.world.World;

public class Animal {
	private int speed = 50;
	private int age;
	private int rangeOfSight;
	protected int posX;
	protected int posY;
	
	protected World world;
	
	private boolean alive;
	
	private String name;
	
	
	protected Animal(int x, int y){
		this.posX = x;
		this.posY = y;
		world = World.getInstance();
//		WorldMap.draw(5,6);
//		world.setCell(posX, posY);
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRangeOfSight() {
		return rangeOfSight;
	}
	public void setRangeOfSight(int rangeOfSight) {
		this.rangeOfSight = rangeOfSight;
	}
	
	private void biologicalClock(){
		alive = true;
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(new Runnable() {
			
			@Override
			public void run() {
				
			}
		});
	}
	
	public void moveTo(int x, int y){
	/*	double distX = Math.abs(posX - x);
		double distY = Math.abs(posY - y);
		double xModifier = posX < x ? 1 : -1;
//		xModifier *= distX/distY;
		double yModifier = posY < y ? 1 : -1;
		
//		yModifier *= distY/distX;
//		double speedFactor = Math.sqrt(xModifier*xModifier + yModifier*yModifier);
//		System.out.println(speedFactor+" "+xModifier+" "+yModifier+"\n");
//		while( xModifier > 1){
//			xModifier /= 10;
//			yModifier /= 10;
//		}
//		while( yModifier > 1){
//			yModifier /= 10;
//			xModifier /= 10;
//		}
		while( Math.abs(posX-x) > 3 || Math.round(posY - y) > 3 ){
//			distX = Math.abs(posX - x);
//			distY = Math.abs(posY - y);
			WorldMap.remove((int)posX, (int)posY);

//			if( Math.round(posX*1000)/1000 != x)
				posX += xModifier;
//			if( Math.round(posY*1000)/1000 != y)
				posY += yModifier;
			WorldMap.draw((int)posX, (int)posY);
			try {
				Thread.sleep(Math.round(1000/speed));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(posX+" "+posY);
//			System.out.println((Math.round(posX*100)/100)+" "+(Math.round(posY*100)/100));
		}
		posX = x;
		posY = y;
		System.out.println("\n\n");
	*/
//		double x0 = posX;
//		double y0 = posY;
//		double y1 = y;
//		double x1 = x;
//		double xx = posX;
//		double yy = posY;
//		double m = (y1 - y0)/( x1 - x0);
//		while(Math.abs(x1 - x0) > 5 && Math.abs(y1 - y0) > 5){
//			xx += (1/m/10);
//			yy += (m/10);
//			System.out.println(xx+" "+yy);
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			WorldMap.draw((int)xx, (int)yy);
//		}
		/*boolean steep = Math.abs( y1 - y0) > Math.abs(x1 - x0);
		if(steep){
			int tmp = x1;
			x1 = y1;
			y1 = tmp;
			tmp = x0;
			x0 = y0;
			y0 = tmp;
		}
		if( x0 > x1){
			int tmp = x1;
			x1 = x0;
			x0 = tmp;
			tmp = y1;
			y1 = y0;
			y0 = tmp;
		}
		int deltaX = x1 - x0;
		int deltaY = Math.abs(y1 - y0);
		int error = deltaX / 2;
		int ystep = y0 < y1 ? 1 : -1;
		int yy = y0;
//		if( y0 < y)
//			ystep = 1;
//		else ystep = -1;
//		double deltaE
//		if( x0 < x1)
		for(int xx = x0; xx <= x1; xx++){
			if(steep)
				WorldMap.draw(yy, xx);
			else WorldMap.draw(xx, yy);
			try {

				posX = xx;
				posY = yy;
				Thread.sleep(1000/speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			error -= deltaY;
			if( error < 0){
				yy += ystep;
				error += deltaX;
			}
		}*/
		double distX = Math.abs(posX - x);
		double distY = Math.abs(posY - y);
		double xModifier = posX < x ? 1 : -1;
		double yModifier = posY < y ? 1 : -1;
		double xMod = 1;
		double yMod = 1;
		double tmp = 0;
//		world.getCell(posX, posY).setAnimal(null);
		if( distX > distY){
			yMod = distY/distX*yModifier;
			tmp = posY;
		}
		if( xModifier > 0)
			for(;posX < x; posX++){
				tmp += yMod;
				world.getCell(posX - 1, posY).setAnimal(null);
				posY = (int) Math.ceil(tmp);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				world.getCell(posX, posY).setAnimal(this);
//				WorldMap.draw(posX, posY);
		}
		else
			for(;posX > x; posX--){
				tmp += yMod;
				posY = (int) tmp;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				WorldMap.draw(posX, posY);
			}
		
		System.out.println(posX+" "+posY);
	}
	
}
