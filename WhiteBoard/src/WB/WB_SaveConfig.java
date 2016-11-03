package WB;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class WB_SaveConfig {
	
	private static String torf="true";
	
	public WB_SaveConfig(){}
	
	public static void loadConfig()throws Exception{
		File directory = new File(getDefaultDirectory(), "/White Board");
		if(!directory.exists())
			directory.mkdirs();
		
		File config = new File(directory, "/conifg.txt");
		if(!config.exists()){
			System.out.println("불러오기 실패");
			config.createNewFile();
			saveConfig();
			return;
		}
		Scanner s = new Scanner(config);
		HashMap<String, String> values = new HashMap<String, String>();
		while(s.hasNextLine()){
			String[] entry = s.nextLine().split(">");
			String key = entry[0];
			String value = entry[1];
			values.put(key,  value);
		}
		if(values.size()==0){
			saveConfig();
			return;
		}
		
		WB_Home.list.append(values.get("list"));
		WB_Home_Func.instruction[2]=values.get("userbutton1");
		WB_Home_Func.check_blank[2]=torf.equals(values.get("btnchk1"));
		WB_Home.btnStr[2]=values.get("ubname1");
		
		WB_Home_Func.instruction[3]=values.get("userbutton2");
		WB_Home_Func.check_blank[3]=torf.equals(values.get("btnchk2"));
		WB_Home.btnStr[3]=values.get("ubname2");
		
		WB_Home_Func.instruction[4]=values.get("userbutton3");
		WB_Home_Func.check_blank[4]=torf.equals(values.get("btnchk3"));
		WB_Home.btnStr[4]=values.get("ubname3");
		
		WB_Home_Func.instruction[5]=values.get("userbutton4");
		WB_Home_Func.check_blank[5]=torf.equals(values.get("btnchk4"));
		WB_Home.btnStr[5]=values.get("ubname4");
	}
	
	public static void saveConfig() throws Exception{
		File directory = new File(getDefaultDirectory(), "/White Board");
		if(!directory.exists())
			directory.mkdirs();
		
		File config = new File(directory, "/conifg.txt");
		
		PrintWriter pw = new PrintWriter(config);
		
		pw.println("list>"+WB_Home.list.getText()+" ");
		pw.println("btnchk1>"+WB_Home_Func.check_blank[2]);
		pw.println("userbutton1>"+WB_Home_Func.instruction[2]);
		pw.println("ubname1>"+WB_Home.btnStr[2]);
		
		pw.println("btnchk2>"+WB_Home_Func.check_blank[3]);
		pw.println("userbutton2>"+WB_Home_Func.instruction[3]);
		pw.println("ubname2>"+WB_Home.btnStr[3]);
		
		pw.println("btnchk3>"+WB_Home_Func.check_blank[4]);
		pw.println("userbutton3>"+WB_Home_Func.instruction[4]);
		pw.println("ubname3>"+WB_Home.btnStr[4]);
		
		pw.println("btnchk4>"+WB_Home_Func.check_blank[5]);
		pw.println("userbutton4>"+WB_Home_Func.instruction[5]);
		pw.println("ubname4>"+WB_Home.btnStr[5]);
		
		pw.close();
	}
	
	public static String getDefaultDirectory(){
		String OS = System.getProperty("os.name").toUpperCase();
		if(OS.contains("WIN")){
			return System.getenv("APPDATA");
		}
		if(OS.contains("MAC")){
			return System.getProperty("user.home")+"Library/Applicaiton Support";
		}
		return System.getProperty("user.home");
	}
}
