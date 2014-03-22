package pl.agh.edu.miss.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.agh.edu.miss.animals.Animal;
import pl.agh.edu.miss.animals.Predator;
import pl.agh.edu.miss.world.World;

public class WorldMap {
	
	BufferedImage worldMap;
	World world = World.getInstance();
	static ImagePanel panel;
	
	public static void main(String [] args){
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setVisible(true);
		panel = new ImagePanel();
//		panel.draw(5, 5, Color.RED);
		frame.add(panel);
		Predator predator = new Predator(5,5);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.draw(50, 20, Color.RED);
		panel.draw(100, 10, Color.RED);
		panel.draw(60, 30, Color.RED);
//		predator.moveTo(50, 12);
		predator.moveTo(60, 30);
		predator.moveTo(100,10);
		predator.moveTo(50, 20);
	}
	
	public static void draw(int x, int y){
		panel.draw(x, y, Color.BLACK);
		panel.repaint();
	}
	
	public static void remove(int x, int y){
		panel.draw(x, y, Color.WHITE);
	}
	
	public static class ImagePanel extends JPanel{
//		private Graphics2D g;
		
		BufferedImage img = new BufferedImage(400,400,BufferedImage.TYPE_INT_RGB);
		public ImagePanel(){
			Graphics2D g = img.createGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, img.getHeight(), img.getWidth());
			g.dispose();
		}
		
		public void draw(int x, int y, Color color){
			Graphics2D g = img.createGraphics();
			g.setColor(color);
			g.drawRect(x, y, 1, 1);
//			g.dispose();
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
//			g.setColor(Color.WHITE);
			g.drawImage(img, 0, 0, null);
//			g.setColor(Color.WHITE);
//			g.fillRect(0, 0, 400, 400);
		}
	}
}
