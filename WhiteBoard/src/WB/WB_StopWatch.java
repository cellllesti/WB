package WB;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WB_StopWatch extends JPanel implements ActionListener, Runnable {
	private JLabel lbl_stopwatch = new JLabel("STOP WATCH");

	private JTextField tf1 = new JTextField("00", 2);

	private JTextField tf2 = new JTextField("00", 2);

	private JTextField tf3 = new JTextField("00", 2);

	private JTextField tf4 = new JTextField("00", 2);

	private JLabel label1 = new JLabel(":");

	private JLabel label2 = new JLabel(":");

	private JLabel label3 = new JLabel(":");

	private JButton b1 = new JButton("Start");

	private JButton b2 = new JButton("Stop");

	private JButton b3 = new JButton("Zero");
	
	private JButton record = new JButton("Record");

	boolean flag;

	int ms = 0;

	int s = 0;

	int m = 0;

	int h = 0;

	long start;

	long end;

	long end2;

	boolean stop = false;

	private JTextArea textArea;
	
	private JScrollPane scroll;
	
	public WB_StopWatch() {
		setBackground(Color.white);
		setLayout(null);

		tf1.setBounds(60, 100, 100, 100);
		tf1.setFont(new Font("±¼¸²", Font.BOLD, 80));

		tf2.setBounds(180, 100, 100, 100);
		tf2.setFont(new Font("±¼¸²", Font.BOLD, 80));

		tf3.setBounds(300, 100, 100, 100);
		tf3.setFont(new Font("±¼¸²", Font.BOLD, 80));

		tf4.setBounds(420, 100, 100, 100);
		tf4.setFont(new Font("±¼¸²", Font.BOLD, 80));

		lbl_stopwatch.setBounds(50, 10, 400, 100);
		lbl_stopwatch.setForeground(Color.red);
		lbl_stopwatch.setFont(new Font("±¼¸²", Font.BOLD, 50));
		label1.setBounds(155, 100, 50, 100);
		label1.setFont(new Font("±¼¸²", Font.BOLD, 70));
		label2.setBounds(276, 100, 50, 100);
		label2.setFont(new Font("±¼¸²", Font.BOLD, 70));
		label3.setBounds(395, 100, 50, 100);
		label3.setFont(new Font("±¼¸²", Font.BOLD, 70));

		b1.setBounds(130, 220, 100, 80);
		b2.setBounds(230, 220, 100, 80);
		b3.setBounds(330, 220, 100, 80);
		
		record.setBounds(440, 220, 100, 80);
		record.setEnabled(false);
		
		scroll = new JScrollPane();
		//scroll.setBounds(60,320, 450, 170);
		
		textArea = new JTextArea("±â·Ï ¡é \n");
		//textArea.setBounds(60, 320, 450, 170);
		textArea.setBackground(new Color(228, 247, 186));
		textArea.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		textArea.setEditable(false);
		
		scroll = new JScrollPane(textArea);
		scroll.setBounds(60,320, 450, 170);
		//scroll.getViewport().setView(textArea);
		//scroll.setViewportView(textArea);
		
		add(scroll);
		//add(textArea);
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		add(lbl_stopwatch);
		add(label1);
		add(label2);
		add(label3);
		add(b1);
		add(b2);
		add(b3);
		add(record);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		record.addActionListener(this);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (flag) {
			if (stop == false)
				end = System.currentTimeMillis();
			else {
				end = end2 += 3;
			}

			ms = (int) ((end - start) / 10);

			h = ms / (3600 * 100);

			m = (ms - h * 3600 * 100) / (60 * 100);

			s = (ms - h * 3600 * 100 - m * 60 * 100) / 100;

			ms = ms - h * 3600 * 100 - m * 60 * 100 - s * 100;

			tf4.setText(ms < 10 ? "0" + ms : "" + ms);

			tf3.setText(s < 10 ? "0" + s : "" + s);

			tf2.setText(m < 10 ? "0" + m : "" + m);

			tf1.setText(h < 10 ? "0" + h : "" + h);
			try {
				Thread.sleep(5);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Object ob = e.getSource();
		if (ob == b1) {
			System.out.println("s");
			record.setEnabled(true);
			if (!flag) {

				if (stop == false)
					start = System.currentTimeMillis();

				flag = true;

				Thread c = new Thread(this);

				c.start();

			}

		}
		else if(ob == record){
			textArea.append(tf1.getText() + " : " + tf2.getText()+" : "+ tf3.getText()+" : "+ tf4.getText() + "\n");
			textArea.setCaretPosition(textArea.getDocument().getLength()); 
			//scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());
		}
		else {
			flag = false;
			if (stop == false)
				end2 = System.currentTimeMillis();
			stop = true;
			
			record.setEnabled(false);
	
			if (ob == b3) {
				tf1.setText("00");

				tf2.setText("00");

				tf3.setText("00");

				tf4.setText("00");
				stop = false;
				textArea.setText("±â·Ï ¡é \n");
			}

		}
	}
}
