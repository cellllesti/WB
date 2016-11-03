package WB;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class WB_System extends JPanel implements MouseListener{
	private JButton btn_start;
	private JButton btn_cancel;
	private JButton btn_lock;
	
	private JRadioButton rdb_exit;
	private JRadioButton rdb_rexit;
	private ButtonGroup r_group;

	private JTextField input_text;

	
	private WB_System_Func sys_f = new WB_System_Func();
	
	public WB_System(){
		setBackground(Color.white);
		setLayout(null);
		
		//JLabel reservation = new JLabel("예약종료");
		//reservation.setFont(new Font("굴림", Font.PLAIN, 17));
		//reservation.setBounds(100, 100, 100, 30);
		//add(reservation);
		
		input_text = new JTextField("0");
		input_text.setFont(new Font("굴림", Font.BOLD, 15));
		input_text.setBounds(30, 100, 200, 50);
		
		rdb_exit = new JRadioButton("종료(0 입력) / 예약종료");
		rdb_exit.setBounds(30, 30, 200, 50);
		rdb_exit.setBackground(Color.white);
		rdb_exit.setFont(new Font("굴림", Font.BOLD, 15));
		rdb_exit.setSelected(true);
		
		rdb_rexit = new JRadioButton("다시시작(0 입력) / 예약 다시시작");
		rdb_rexit.setBounds(250, 30, 300, 50);
		rdb_rexit.setBackground(Color.white);
		rdb_rexit.setFont(new Font("굴림", Font.BOLD, 15));
		
		r_group=new ButtonGroup();
		
		btn_start = new JButton("시작");
		btn_start.setFont(new Font("굴림", Font.BOLD, 20));
		btn_start.setBounds(30, 200, 150, 70);
		btn_start.setBackground(Color.WHITE);
		
		btn_cancel = new JButton("취소");
		btn_cancel.setFont(new Font("굴림", Font.BOLD, 20));
		btn_cancel.setBounds(200, 200, 150, 70);
		btn_cancel.setBackground(Color.WHITE);
		
		btn_lock = new JButton("컴퓨터 잠금");
		btn_lock.setFont(new Font("굴림", Font.BOLD, 20));
		btn_lock.setBounds(370, 200, 150, 70);
		btn_lock.setBackground(Color.WHITE);
		
		add(input_text);
		
		add(rdb_exit);
		add(rdb_rexit);
		r_group.add(rdb_exit);
		r_group.add(rdb_rexit);
		
		add(btn_start);
		add(btn_cancel);
		add(btn_lock);
		
		rdb_exit.addMouseListener(this);
		rdb_rexit.addMouseListener(this);
		btn_start.addMouseListener(this);
		btn_cancel.addMouseListener(this);
		btn_lock.addMouseListener(this);
		
		//rundll32.exe user32.dll,LockWorkStation
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btn_lock)
			sys_f.System_Lock();
		else if(e.getSource() == btn_start && rdb_exit.isSelected())
			sys_f.System_Exit(input_text.getText());
		else if(e.getSource() == btn_start && rdb_rexit.isSelected())
			sys_f.System_Restart(input_text.getText());
		else if(e.getSource() == btn_cancel)
			sys_f.System_Cancel();
		
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
