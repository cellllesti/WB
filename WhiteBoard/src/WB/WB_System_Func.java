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
		      Process proc = rt.exec("cmd /c rundll32.exe user32.dll,LockWorkStation"); //시스템 명령어

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
			Process proc = rt.exec(instruction); // 시스템 명령어
			showMessage("Start", "(예약)종료가 시작됩니다");
		}catch(NumberFormatException e){
			showMessage("Access Number", "숫자가 아닙니다.");
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
			Process proc = rt.exec(instruction); // 시스템 명령어
			showMessage("Cancel", "(예약)다시시작이 취소되었습니다.");
		}
		catch(NumberFormatException e){
			showMessage("Access Number", "숫자가 아닙니다.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void System_Cancel(){
		try {	
			String instruction = "cmd /c shutdown -a" ;
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(instruction); // 시스템 명령어
			showMessage("Cancel", "(예약)종료 or 다시시작 취소되었습니다.");
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
