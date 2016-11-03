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

public class WB_Home_Func2 extends JFrame implements MouseListener, Use_showMessage{
	private JPanel contentPane;
	
	private JLabel lbl;
	private JTextField input_text;
	private JTextField input_name;
	
	private int num;
	private String ret;
	private JButton btn_ok;
	private JButton btn_cancel;
	
	public WB_Home_Func2(int num){
		setSize(500, 350);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setBackground(Color.white);
		
		this.num=num;	//버튼 위치 받기
		
		lbl = new JLabel("경로 입력 ↓ ");
		lbl.setFont(new Font("굴림", Font.BOLD, 20));
		lbl.setBounds(50, 20, 150, 70);
		
		input_text = new JTextField("역슬래쉬가 있을 경우 역슬래쉬를 2번 써주세요");
		input_text.setFont(new Font("굴림", Font.BOLD, 15));
		input_text.setBounds(50, 80, 380, 40);
		
		input_name = new JTextField("제목 입력");
		input_name.setFont(new Font("굴림", Font.BOLD, 15));
		input_name.setBounds(50, 140, 380, 40);
		
		btn_ok = new JButton("추가");
		btn_ok.setFont(new Font("굴림", Font.BOLD, 20));
		btn_ok.setBounds(130, 200, 100, 70);
		
		btn_cancel= new JButton("닫기");
		btn_cancel.setFont(new Font("굴림", Font.BOLD, 20));
		btn_cancel.setBounds(240, 200, 100, 70);
		
		add(lbl);
		add(btn_ok);
		add(input_text);
		add(input_name);
		add(btn_cancel);
		
		btn_ok.addMouseListener(this);
		btn_cancel.addMouseListener(this);
		setVisible(true);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_ok){
			WB_Home_Func.check_blank[num]=true;
			WB_Home_Func.instruction[num]=input_text.getText();
			
			WB_Home.btnStr[num] = input_name.getText();
			WB_Home.btn_blank[num].setLabel(WB_Home.btnStr[num]);
			showMessage("완료", "추가되었습니다");
		}
		else if(e.getSource()==btn_cancel){
			dispose();
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showMessage(String title, String message) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	
}











