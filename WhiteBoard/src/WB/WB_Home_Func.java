package WB;

import java.io.IOException;

import javax.swing.JOptionPane;

public class WB_Home_Func implements Use_showMessage {
	
	public static boolean okok = false;
	
	public static boolean check_blank[] = new boolean[6];
	private WB_Home_Func2 home_f2;
	public static String instruction[] = new String[10];
	
	public static String share;

	
	public WB_Home_Func(){}
	
	public void iexplorer(){
		try {
			instruction[0] = "c:\\program files\\internet explorer\\iexplore.exe goolge.com";
			Runtime rt = Runtime.getRuntime();
			rt.exec(instruction[0]); // 시스템 명령어
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void calc(){
		try {
			instruction[6] = "C:\\Windows\\System32\\calc.exe";
			Runtime rt = Runtime.getRuntime();
			rt.exec(instruction[6]); // 시스템 명령어
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void snippingtool(){
		try {
			instruction[7] = "C:\\Windows\\System32\\snippingtool.exe";
			Runtime rt = Runtime.getRuntime();
			rt.exec(instruction[7]); // 시스템 명령어
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void notepad(){
		try {
			instruction[1] = "C:\\Windows\\notepad.exe";
			Runtime rt = Runtime.getRuntime();
			rt.exec(instruction[1]); // 시스템 명령어
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Blank(int num){
		
		if(!check_blank[num]){
			home_f2 = new WB_Home_Func2(num);
		}
		else{
			try {
				Runtime rt = Runtime.getRuntime();
				rt.exec(instruction[num]); // 시스템 명령어
			}
			catch(NullPointerException e){
				showMessage("잘못된 접근", "잘못된 경로입니다");
			}
			catch (IOException e) {
				showMessage("잘못된 접근", "잘못된 경로입니다");
			}
		}
	}
	public void Cancel(int i){
		instruction[i]=null;
		WB_Home.btnStr[i]=" ";
		WB_Home.btn_blank[i].setLabel(" ");
		check_blank[i]=false;
	}

	@Override
	public void showMessage(String title, String message) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
}













