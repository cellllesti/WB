package WB;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WB_Random extends JPanel implements MouseListener{
	
	private int count = 0;
	private JButton btn_start;
	private JTextField positive;
	private JTextField negative;
	
	private int rand_num =0;
	
	public WB_Random(){
		setBackground(Color.white);
		setLayout(null);
		ImageIcon img = new ImageIcon("res/2.png");
		Image image = img.getImage();
		
		positive = new JTextField();
		positive.setBackground(new Color(234, 234, 234));
		positive.setBounds(50, 50, 100, 30);
		
		positive.setText("ex) 한다");
		
		negative = new JTextField();
		negative.setBackground(new Color(234, 234, 234));
		negative.setBounds(50, 90, 100, 30);
		
		negative.setText("ex) 안한다");
		
		btn_start = new JButton();
		btn_start.setFont(new Font("굴림", Font.BOLD, 20));
		btn_start.setBounds(170, 50, 150, 70);
		btn_start.setBackground(Color.WHITE);
		btn_start.setIcon(img);
		
		btn_start.addMouseListener(this);
	
		add(btn_start);
		add(positive);
		add(negative);		
	}
	
	public String getPoText(){
		return positive.getText();
	}
	public String getNeText(){
		return negative.getText();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		g.setFont(new Font("Default", Font.BOLD, 40));
		if(count==0)
			g.drawString("3", 350, 300);
		else if(count==1)
			g.drawString("2", 350, 300);
		else if(count==2)
			g.drawString("1", 350, 300);
		else{
			if(rand_num==0)
				g.drawString(getPoText(), 350, 300);
			else
				g.drawString(getNeText(), 350, 300);
		}
				
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btn_start){
			Rand();
			count=0;
			repaint();
			try {
				Counter();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void Rand(){
		Random rand = new Random();
		rand_num = rand.nextInt(2);
	}
	
	public void Counter() throws Exception{
		System.out.println("시작");
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			public void run(){
				try{
					Thread.sleep(1000);
					count++;
					repaint();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				if(count>2){
					timer.cancel();
					
				}
			}
		}, 0, 1000);
		
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
		
}