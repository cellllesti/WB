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
			rt.exec(instruction[0]); // �ý��� ��ɾ�
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void calc(){
		try {
			instruction[6] = "C:\\Windows\\System32\\calc.exe";
			Runtime rt = Runtime.getRuntime();
			rt.exec(instruction[6]); // �ý��� ��ɾ�
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void snippingtool(){
		try {
			instruction[7] = "C:\\Windows\\System32\\snippingtool.exe";
			Runtime rt = Runtime.getRuntime();
			rt.exec(instruction[7]); // �ý��� ��ɾ�
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void notepad(){
		try {
			instruction[1] = "C:\\Windows\\notepad.exe";
			Runtime rt = Runtime.getRuntime();
			rt.exec(instruction[1]); // �ý��� ��ɾ�
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
				rt.exec(instruction[num]); // �ý��� ��ɾ�
			}
			catch(NullPointerException e){
				showMessage("�߸��� ����", "�߸��� ����Դϴ�");
			}
			catch (IOException e) {
				showMessage("�߸��� ����", "�߸��� ����Դϴ�");
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













