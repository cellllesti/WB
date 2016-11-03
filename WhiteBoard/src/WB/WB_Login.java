package WB;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class WB_Login extends JPanel implements MouseListener {
	
	private JTextField input_id;
	//private JTextField input_pw;
	private JPasswordField input_pw;
	
	private JLabel lbl_id;
	private JLabel lbl_pw;
	
	private JButton btn_login;
	private JButton btn_sign;
	
	private WB_Login_Func login_f;
	
	private WB_Sign sign;
	
	private boolean re_paint=false;
	
	public WB_Login(){
		setBackground(Color.white);
		setLayout(null);
		
		
		lbl_id = new JLabel("ID");
		lbl_pw = new JLabel("PASSWORD");
		
		lbl_id.setBounds(125, 145, 50, 50);
		lbl_id.setFont(new Font("±¼¸²", Font.BOLD, 15));

		lbl_pw.setBounds(100, 200, 100, 50);
		lbl_pw.setFont(new Font("±¼¸²", Font.BOLD, 15));
		
		input_id = new JTextField();
		input_id.setBounds(200, 145, 200, 40);
		input_id.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		
		input_pw = new JPasswordField();
		input_pw.setBounds(200, 200, 200, 40);
//		input_pw = new JTextField();
//		input_pw.setBounds(200, 200, 200, 40);
//		input_pw.setFont(new Font("±¼¸²", Font.PLAIN, 15));
	
		
		btn_login = new JButton("LOGIN");
		btn_login.setBounds(430, 140, 120, 110);
		btn_login.setFont(new Font("±¼¸²", Font.BOLD, 20));
		
		btn_sign = new JButton("È¸¿ø°¡ÀÔ");
		btn_sign.setBounds(200, 260, 120, 50);
		btn_sign.setFont(new Font("¹ÙÅÁ", Font.BOLD, 20));
		btn_sign.setBackground(Color.white);
		btn_sign.setForeground(Color.blue);
		btn_sign.setBorderPainted(false);
		
		add(input_id);
		add(input_pw);
		add(lbl_id);
		add(lbl_pw);
		add(btn_login);
		add(btn_sign);
		
		btn_login.addMouseListener(this);
		btn_sign.addMouseListener(this);
		
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		g.setFont(new Font("Default", Font.BOLD, 40));
		if(re_paint)
			g.drawString("·Î±×ÀÎ µÊ", 350, 300);
				
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_login){
			login_f = new WB_Login_Func(input_id.getText(), input_pw.getText());
			int num =login_f.select();
			if(num==1){
				re_paint=true;
				System.out.println("S");
				lbl_id.setVisible(false);
				lbl_pw.setVisible(false);
				input_id.setVisible(false);
				input_pw.setVisible(false);
				btn_login.setVisible(false);
				btn_sign.setVisible(false);
				repaint();
			}
		}
		else if(e.getSource()==btn_sign)
			sign=new WB_Sign();
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
