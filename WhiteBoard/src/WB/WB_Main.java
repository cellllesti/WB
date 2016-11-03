package WB;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class WB_Main extends JFrame implements WindowListener, ActionListener, Use_showMessage{

	private SystemTray systemTray;
	private PopupMenu mPopup;
	private MenuItem mItemNew, mItemOpen, mItemSave, mItemExit;
	
	public static final int WIDTH = 700, HEIGHT =565;
	
	private boolean first=true;
	
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WB_Main frame = new WB_Main(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WB_Main(boolean first) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setBackground(Color.white);
		setTitle("White Board");
		
		JTabbedPane tab = new JTabbedPane();
		tab.setFont(new Font("굴림", Font.PLAIN, 20));
		
		if(first){
		try {
			WB_SaveConfig.loadConfig();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); //불러오기
		}
		}
		
		WB_Alarm Alarm = new WB_Alarm();
		WB_Health Health = new WB_Health();
		WB_Home Home = new WB_Home();
		WB_Login  Login = new WB_Login();
		WB_Random Random = new WB_Random();
		WB_System Syst = new WB_System();
		WB_Schedule Schedule = new WB_Schedule();
		WB_Tip tip = new WB_Tip();
		WB_TimeTable timetable = new WB_TimeTable();
		WB_StopWatch stopwatch = new WB_StopWatch();
		Random.setForeground(Color.WHITE);
		Random.setBackground(Color.WHITE);
		
		
		tab.addTab("Login", Login);
		tab.addTab("Home", Home);
		tab.addTab("Alarm", Alarm);
		tab.addTab("StopWatch", stopwatch);
		tab.addTab("Health", Health);
		tab.addTab("Schedule", Schedule);
		tab.addTab("Select", Random);
		tab.addTab("TimeTable", timetable);

		tab.addTab("System", Syst);
		tab.addTab("Tip", tip);
		Random.setLayout(null);

		tab.setBackground(Color.white);
		tab.setSelectedIndex(1); // 맨처음 켰을때 홈화면 
		tab.setTabPlacement(JTabbedPane.RIGHT);
		tab.setSize(new Dimension(250, 50));
		getContentPane().add(tab);
		
		this.first=first;
		
		this.addWindowListener(this);
		
		
	}
	public void statusBar(){
		if (SystemTray.isSupported()) {
			mPopup = new PopupMenu();
			//mItemNew = new MenuItem("New");
			mItemOpen = new MenuItem("Open");
			//mItemSave = new MenuItem("Save");
			mItemExit = new MenuItem("Exit");

			//mItemNew.addActionListener(this);
			mItemOpen.addActionListener(this);
			//mItemSave.addActionListener(this);
			mItemExit.addActionListener(this);

			//mPopup.add(mItemNew);
			//mPopup.addSeparator();
			mPopup.add(mItemOpen);
			//mPopup.add(mItemSave);
			mPopup.addSeparator();
			mPopup.add(mItemExit);

			Image image = Toolkit.getDefaultToolkit().getImage("res/1.png");
			TrayIcon trayIcon = new TrayIcon(image, "Java 6.0 SystemTrayIcon Test", mPopup);
			trayIcon.setImageAutoSize(true);

			systemTray = SystemTray.getSystemTray();
			try {
				systemTray.add(trayIcon);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		if(first){
			first=false;
			statusBar();
		}
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//if (e.getSource() == mItemNew) {
			//showMessage("New File...", "새로운 파일을 생성합니다.");
		 if (e.getSource() == mItemOpen) {
			showMessage("File Open...", "파일을 엽니다.");
			WB_Main restart = new WB_Main(first);
			restart.setVisible(true);
		//} else if (e.getSource() == mItemSave) {
			//showMessage("File Save...", "파일을 저장합니다.");
		} else if (e.getSource() == mItemExit) {
			try {
				WB_SaveConfig.saveConfig();
			} catch (Exception e1) {
				//showMessage("Exit SystemTrayIcon Test...", "종료하겠습니다.");
				e1.printStackTrace();  //저장
			}
			showMessage("Exit SystemTrayIcon Test...", "종료하겠습니다.");
			System.exit(0);
		}
	}
	public void showMessage(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
}
