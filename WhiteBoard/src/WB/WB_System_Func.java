package WB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class WB_System_Func implements Use_showMessage{

	public WB_System_Func() {

	}

	public void System_Lock(){
		try {
		      Runtime rt = Runtime.getRuntime(); 
		      Process proc = rt.exec("cmd /c rundll32.exe user32.dll,LockWorkStation"); //�ý��� ��ɾ�

		  } catch (IOException e) {
		      e.printStackTrace();
		  }
	}

	public void System_Exit(String text) {
		try {
			int num = Integer.parseInt(text);
			num = 60*num;
			String instruction = "cmd /c shutdown -s -t " + num;
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(instruction); // �ý��� ��ɾ�
			showMessage("Start", "(����)���ᰡ ���۵˴ϴ�");
		}catch(NumberFormatException e){
			showMessage("Access Number", "���ڰ� �ƴմϴ�.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void System_Restart(String text){
		try {	
			int num = Integer.parseInt(text);
			num = 60*num;
			String instruction = "cmd /c shutdown -r -t " + num;
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(instruction); // �ý��� ��ɾ�
			showMessage("Cancel", "(����)�ٽý����� ��ҵǾ����ϴ�.");
		}
		catch(NumberFormatException e){
			showMessage("Access Number", "���ڰ� �ƴմϴ�.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void System_Cancel(){
		try {	
			String instruction = "cmd /c shutdown -a" ;
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(instruction); // �ý��� ��ɾ�
			showMessage("Cancel", "(����)���� or �ٽý��� ��ҵǾ����ϴ�.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void showMessage(String title, String message) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
}
