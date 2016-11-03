package WB;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class WB_Alarm extends JPanel implements MouseListener, Use_showMessage, Runnable, ActionListener{

	private JButton sound_start;
	private JRadioButton rdb_second;
	private JRadioButton rdb_minute;
	private ButtonGroup r_group;
	
	private JTextField input_time;
/*
 * 현재 주석 처리 되어있는 것은 후에 삭제해야 함.
 * 
 */
	
//	private JLabel lbl_stopwatch = new JLabel("STOP WATCH");
//	
//	private JTextField tf1 = new JTextField("00",2);
//
//	private JTextField tf2 = new JTextField("00",2);
//
//	private JTextField tf3 = new JTextField("00",2);
//
//	private JTextField tf4 = new JTextField("00",2);
//	
//	private JLabel label1 = new JLabel(":");
//
//	private JLabel label2 = new JLabel(":");
//
//	private JLabel label3 = new JLabel(":");
//	
//	private JButton b1 = new JButton("Start");
//
//	private JButton b2 = new JButton("Stop");
//
//	private JButton b3 = new JButton("Zero");
//
//	boolean flag;
//
//	int ms = 0;
//
//	int s = 0;
//
//	int m = 0;
//
//	int h = 0;
//	
//	long start;
//
//	long end;
	
	private WB_Alarm_Func alarm_f = new WB_Alarm_Func();
	
	public WB_Alarm() {
		
		setBackground(Color.white);
		setLayout(null);
		
		rdb_second = new JRadioButton("초단위");
		rdb_second.setBounds(30, 30, 200, 50);
		rdb_second.setBackground(Color.white);
		rdb_second.setFont(new Font("굴림", Font.BOLD, 15));
		rdb_second.setSelected(true);
		
		rdb_minute = new JRadioButton("분단위");
		rdb_minute.setBounds(250, 30, 300, 50);
		rdb_minute.setBackground(Color.white);
		rdb_minute.setFont(new Font("굴림", Font.BOLD, 15));
		
		r_group=new ButtonGroup();
		
		input_time = new JTextField();
		input_time.setFont(new Font("굴림", Font.BOLD, 15));
		input_time.setBounds(30, 100, 200, 50);
		
		sound_start = new JButton("START");
		sound_start.setFont(new Font("굴림", Font.BOLD, 20));
		sound_start.setBounds(280, 100, 120, 50);
		
//		tf1.setBounds(60, 250, 100, 100);
//		tf1.setFont(new Font("굴림", Font.BOLD, 80));
//		
//		tf2.setBounds(180, 250, 100, 100);
//		tf2.setFont(new Font("굴림", Font.BOLD, 80));
//		
//		tf3.setBounds(300, 250, 100, 100);
//		tf3.setFont(new Font("굴림", Font.BOLD, 80));
//		
//		tf4.setBounds(420, 250, 100, 100);
//		tf4.setFont(new Font("굴림", Font.BOLD, 80));
//		
//		lbl_stopwatch.setBounds(50, 150, 400, 100);
//		lbl_stopwatch.setForeground(Color.red);
//		lbl_stopwatch.setFont(new Font("굴림", Font.BOLD, 50));
//		label1.setBounds(155, 250, 50, 100);
//		label1.setFont(new Font("굴림", Font.BOLD, 70));
//		label2.setBounds(276, 250, 50, 100);
//		label2.setFont(new Font("굴림", Font.BOLD, 70));
//		label3.setBounds(395, 250, 50, 100);
//		label3.setFont(new Font("굴림", Font.BOLD, 70));
//		
//		b1.setBounds(130, 365, 100, 80);
//		b2.setBounds(230, 365, 100, 80);
//		b3.setBounds(330, 365, 100, 80);
		
		add(rdb_second);
		add(rdb_minute);
		r_group.add(rdb_second);
		r_group.add(rdb_minute);
		add(sound_start);
		add(input_time);
		
//		add(tf1);
//		add(tf2);
//		add(tf3);
//		add(tf4);
//		add(lbl_stopwatch);
//		add(label1);
//		add(label2);
//		add(label3);
//		add(b1);
//		add(b2);
//		add(b3);
//		
//		b1.addActionListener(this);
//		b2.addActionListener(this);
//		b3.addActionListener(this);

		sound_start.addMouseListener(this);
	}

//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		  while (flag) {
//			  end = System.currentTimeMillis();
//
//			  ms = (int) ((end - start) / 10);
//
//			  h = ms / (3600 * 100);
//
//			  m = (ms - h * 3600 * 100) / (60 * 100);
//
//			  s = (ms - h * 3600 * 100 - m * 60 * 100) / 100;
//
//			  ms = ms - h * 3600 * 100 - m * 60 * 100 - s * 100;
//
//			  tf4.setText(ms < 10 ? "0" + ms : "" + ms);
//
//			  tf3.setText(s < 10 ? "0" + s : "" + s);
//
//			  tf2.setText(m < 10 ? "0" + m : "" + m);
//
//			  tf1.setText(h < 10 ? "0" + h : "" + h);
//			  try {
//			      Thread.sleep(5);
//
//			  } catch (InterruptedException e) {
//			    	e.printStackTrace();
//			  }
//
//		  }
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		Object ob = e.getSource();
//		  if (ob == b1) {
//			  System.out.println("s");
//		   if (!flag) {
//
//		    start = System.currentTimeMillis();
//
//		    flag = true;
//
//		    Thread c = new Thread(this);
//
//		    c.start();
//
//		   }
//
//		  } else {
//
//		   flag = false;
//
//		   if (ob == b3){
//
//		    tf1.setText("00");
//
//		    tf2.setText("00");
//
//		    tf3.setText("00");
//
//		    tf4.setText("00");  
//
//		   }
//
//		  }
//	} 

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==sound_start && rdb_second.isSelected()){
			int num = Integer.parseInt(input_time.getText());
			alarm_f.sound(num*1000);
			String s=num+"초 후에 알람이 울립니다.";
			showMessage("시작", s);
		}
		
		else if(e.getSource() ==sound_start && rdb_minute.isSelected()){
			int num = Integer.parseInt(input_time.getText());
			alarm_f.sound(num*1000*60);
			String s=num+"분 후에 알람이 울립니다.";
			showMessage("시작", s);
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

	public void showMessage(String title, String message) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//지워야함
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//지워야함
	}
	
	
	
}
