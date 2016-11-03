package WB;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class WB_Home extends JPanel implements MouseListener{
	
	private JButton btn_iexplorer;
	private JButton btn_notepad;
	private JButton btn_calc;
	private JButton btn_snippingtool;
	
	public static JTextArea list = new JTextArea();
	
	public static JButton btn_blank[] = new JButton[6];	//πŸ∑Œ∞°±‚ ≥÷±‚
	private JButton btn_blank1_cancel[] = new JButton[6];	//∏Æº¬

	public static String btnStr[]= new String[6];	//πˆ∆∞ ¿Ã∏ß
	
	private WB_Home_Func home_f = new WB_Home_Func();
	
	public WB_Home(){
		setBackground(Color.white);
		setLayout(null);
		
		ImageIcon img[] = new ImageIcon[4];
		img[0]=new ImageIcon("res/iexplorer.png");
		img[1]=new ImageIcon("res/notepad.png");
		img[2]=new ImageIcon("res/snippingtool.png");
		img[3]=new ImageIcon("res/calc.png");
		
		list.setBounds(100, 250, 400, 200);
		list.setBackground(new Color(234, 234, 234));
		list.setFont(new Font("πŸ≈¡", Font.PLAIN, 20));
		
		btn_iexplorer = new JButton();
		btn_iexplorer.setFont(new Font("±º∏≤", Font.BOLD, 15));
		btn_iexplorer.setBounds(50, 40, 100, 70);
		btn_iexplorer.setBackground(Color.WHITE);
		btn_iexplorer.setIcon(img[0]);
		
		btn_notepad = new JButton();
		btn_notepad.setFont(new Font("±º∏≤", Font.BOLD, 15));
		btn_notepad.setBounds(160, 40, 100, 70);
		btn_notepad.setBackground(Color.WHITE);
		btn_notepad.setIcon(img[1]);
		
		btn_calc = new JButton();
		btn_calc.setFont(new Font("±º∏≤", Font.BOLD, 15));
		btn_calc.setBounds(270, 40, 100, 70);
		btn_calc.setBackground(Color.WHITE);
		btn_calc.setIcon(img[3]);
		
		btn_snippingtool = new JButton();
		btn_snippingtool.setFont(new Font("±º∏≤", Font.BOLD, 15));
		btn_snippingtool.setBounds(380, 40, 100, 70);
		btn_snippingtool.setBackground(Color.WHITE);
		btn_snippingtool.setIcon(img[2]);
		
		btn_blank[2] = new JButton(btnStr[2]);
		btn_blank[2].setFont(new Font("±º∏≤", Font.BOLD, 15));
		btn_blank[2].setBounds(50, 130, 100, 70);
		btn_blank[2].setBackground(Color.WHITE);
		
		btn_blank1_cancel[2] = new JButton("ªË¡¶"); 
		btn_blank1_cancel[2].setFont(new Font("±º∏≤", Font.BOLD, 13));
		btn_blank1_cancel[2].setBounds(50, 210, 70, 25);
		btn_blank1_cancel[2].setBackground(Color.WHITE);
		btn_blank1_cancel[2].setForeground(Color.blue);
		btn_blank1_cancel[2].setBorderPainted(false);
		
		btn_blank[3] = new JButton(btnStr[3]);
		btn_blank[3].setFont(new Font("±º∏≤", Font.BOLD, 15));
		btn_blank[3].setBounds(160, 130, 100, 70);
		btn_blank[3].setBackground(Color.WHITE);
		
		btn_blank1_cancel[3] = new JButton("ªË¡¶"); 
		btn_blank1_cancel[3].setFont(new Font("±º∏≤", Font.BOLD, 13));
		btn_blank1_cancel[3].setBounds(160, 210, 70, 25);
		btn_blank1_cancel[3].setBackground(Color.WHITE);
		btn_blank1_cancel[3].setForeground(Color.blue);
		btn_blank1_cancel[3].setBorderPainted(false);
		
		btn_blank[4] = new JButton(btnStr[4]);
		btn_blank[4].setFont(new Font("±º∏≤", Font.BOLD, 15));
		btn_blank[4].setBounds(270, 130, 100, 70);
		btn_blank[4].setBackground(Color.WHITE);
		
		btn_blank1_cancel[4] = new JButton("ªË¡¶"); 
		btn_blank1_cancel[4].setFont(new Font("±º∏≤", Font.BOLD, 13));
		btn_blank1_cancel[4].setBounds(270, 210, 70, 25);
		btn_blank1_cancel[4].setBackground(Color.WHITE);
		btn_blank1_cancel[4].setForeground(Color.blue);
		btn_blank1_cancel[4].setBorderPainted(false);
		
		btn_blank[5] = new JButton(btnStr[5]);
		btn_blank[5].setFont(new Font("±º∏≤", Font.BOLD, 15));
		btn_blank[5].setBounds(380, 130, 100, 70);
		btn_blank[5].setBackground(Color.WHITE);
		
		btn_blank1_cancel[5] = new JButton("ªË¡¶"); 
		btn_blank1_cancel[5].setFont(new Font("±º∏≤", Font.BOLD, 13));
		btn_blank1_cancel[5].setBounds(380, 210, 70, 25);
		btn_blank1_cancel[5].setBackground(Color.WHITE);
		btn_blank1_cancel[5].setForeground(Color.blue);
		btn_blank1_cancel[5].setBorderPainted(false);
		
		add(btn_iexplorer);
		add(btn_notepad);
		add(btn_calc);
		add(btn_snippingtool);
		add(list);
		add(btn_blank[2]);
		add(btn_blank1_cancel[2]);
		add(btn_blank[3]);
		add(btn_blank1_cancel[3]);
		add(btn_blank[4]);
		add(btn_blank1_cancel[4]);
		add(btn_blank[5]);
		add(btn_blank1_cancel[5]);
		
		btn_iexplorer.addMouseListener(this);
		btn_notepad.addMouseListener(this);
		btn_calc.addMouseListener(this);
		btn_snippingtool.addMouseListener(this);
		
		btn_blank[2].addMouseListener(this);
		btn_blank1_cancel[2].addMouseListener(this);
		btn_blank[3].addMouseListener(this);
		btn_blank1_cancel[3].addMouseListener(this);
		btn_blank[4].addMouseListener(this);
		btn_blank1_cancel[4].addMouseListener(this);
		btn_blank[5].addMouseListener(this);
		btn_blank1_cancel[5].addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_iexplorer)
			home_f.iexplorer();
		else if(e.getSource()==btn_notepad)
			home_f.notepad();
		else if(e.getSource()==btn_calc){
			home_f.calc();
		}
		else if(e.getSource()==btn_snippingtool){
			home_f.snippingtool();
		}
		else if(e.getSource()==btn_blank[2]){
			home_f.Blank(2);
		}
		else if(e.getSource()==btn_blank1_cancel[2]){
			home_f.Cancel(2);
		}
		else if(e.getSource()==btn_blank[3]){
			home_f.Blank(3);
		}
		else if(e.getSource()==btn_blank1_cancel[3]){
			home_f.Cancel(3);
		}
		else if(e.getSource()==btn_blank[4]){
			home_f.Blank(4);
		}
		else if(e.getSource()==btn_blank1_cancel[4]){
			home_f.Cancel(4);
		}
		else if(e.getSource()==btn_blank[5]){
			home_f.Blank(5);
		}
		else if(e.getSource()==btn_blank1_cancel[5]){
			home_f.Cancel(5);
		}
		
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
