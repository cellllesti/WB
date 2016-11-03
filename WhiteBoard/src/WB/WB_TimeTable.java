package WB;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class WB_TimeTable extends JPanel{
	
	ImageIcon img = new ImageIcon("res/example.png");
	Image image = img.getImage();
	
	public WB_TimeTable(){
		setBackground(Color.white);
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(image, 10, 10, this.getWidth(), this.getHeight(), this);
	}
	
}
