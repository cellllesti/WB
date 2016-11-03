package WB;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WB_Sign extends JFrame implements MouseListener, Use_showMessage{
	private JPanel contentPane;
	private JTextField id;
	private JTextField pw;
	private JTextField name;
	private JTextField email;
	
	private JLabel lbl_id;
	private JLabel lbl_pw;
	private JLabel lbl_name;
	private JLabel lbl_email;
	
	private JButton check;
	private JButton OK;
	private JButton Cancel;
	
	private WB_Sign_Func sign_f=new WB_Sign_Func();
	
	private boolean sign_ok =false;
	public WB_Sign(){
		setSize(500, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
	
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setBackground(Color.white);
		
		lbl_id= new JLabel("ID");
		lbl_id.setBounds(40, 10, 100, 50);
		lbl_id.setFont(new Font("바탕", Font.BOLD, 20));
		
		lbl_pw= new JLabel("PW");
		lbl_pw.setBounds(40, 70, 100, 50);
		lbl_pw.setFont(new Font("바탕", Font.BOLD, 20));
		
		lbl_name= new JLabel("NAME");
		lbl_name.setBounds(40, 130, 100, 50);
		lbl_name.setFont(new Font("바탕", Font.BOLD, 20));
		
		lbl_email= new JLabel("E-MAIL");
		lbl_email.setBounds(40, 190, 100, 50);
		lbl_email.setFont(new Font("바탕", Font.BOLD, 20));
		
		id = new JTextField();
		id.setBounds(170, 10, 200, 50);
		
		pw= new JTextField();
		pw.setBounds(170, 70, 200, 50);
		
		name = new JTextField();
		name.setBounds(170, 130, 200, 50);
		
		email = new JTextField();
		email.setBounds(170, 190, 200, 50);
		
		check = new JButton("중복 체크");
		check.setFont(new Font("굴림", Font.BOLD, 15));
		check.setBounds(380, 10, 100, 60);
		
		OK = new JButton("가입");
		OK.setFont(new Font("굴림", Font.BOLD, 15));
		OK.setBounds(150, 250, 100, 70);
		
		Cancel = new JButton("닫기");
		Cancel.setFont(new Font("굴림", Font.BOLD, 15));
		Cancel.setBounds(280, 250, 100, 70);
		
		add(lbl_id);
		add(lbl_pw);
		add(lbl_name);
		add(lbl_email);
		
		add(id);
		add(pw);
		add(name);
		add(email);
		
		add(check);
		add(OK);
		add(Cancel);
		
		check.addMouseListener(this);
		OK.addMouseListener(this);
		Cancel.addMouseListener(this);
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	
		if(e.getSource()==check){
			int i=sign_f.select(id.getText());
			if(i==1){
				showMessage("사용불가", "사용중인 아이디입니다.");
			}
			else{
				showMessage("사용가능", "사용가능한 아이디입니다.");
				id.setEnabled(false);
				sign_ok=true;
			}
		}
		else if(e.getSource()==OK && sign_ok==false){
			showMessage("중복체크", "중복체크를 하지 않았습니다.");
		}
		else if(e.getSource()==OK && sign_ok==true){
			sign_f.insert(id.getText(), pw.getText(), name.getText(), email.getText());
			showMessage("완료", "가입되었습니다.");
			dispose();
		}
		
		else if(e.getSource()==Cancel){
			dispose();
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

	@Override
	public void showMessage(String title, String message) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
}
