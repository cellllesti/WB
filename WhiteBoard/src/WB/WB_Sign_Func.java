package WB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class WB_Sign_Func  {
	String driver        = "org.mariadb.jdbc.Driver";
    String url           = "jdbc:mariadb://211.199.52.230:3306/members";
    String uId           = "ms";
    String uPwd          = "alstn";
    
    String id, pw;
    Connection               con;
    PreparedStatement        pstmt;
    ResultSet                rs;
    
    WB_Sign_Func(){
        try {
       	 //this.id = id;
       	 //this.pw = pw;
           Class.forName(driver);
           con = DriverManager.getConnection(url, uId, uPwd);
           
           if( con != null ){ System.out.println("데이터 베이스 접속 성공"); }
           
       } catch (ClassNotFoundException e) { e.printStackTrace();  } 
         catch (SQLException e) { e.printStackTrace(); }
    }
    
    public int select(String id){
        String sql = "select name from login where id = '"+id+"'";// and pw = '"+pw+"'";
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            if(rs.next()){
            	System.out.println("writer    : " + rs.getString("name"));
            	return 1;
            }
//            while(rs.next()){
//                System.out.println("writer    : " + rs.getString("name"));
//                //System.out.println("title     : " + rs.getString("pw"));
//            }
            else{
            	//showMessage("접근 거부", "비밀번호가 틀렸습니다.");
            	return 2;
            }
           
        } catch (SQLException e) { System.out.println("쿼리 수행 실패"); }
		return 0;
    }
    
    public int insert(String id, String pw, String name, String email){
    	String sql = "insert into login values('"+id+"', '"+pw+"', '"+email+"', '"+name+"')";
    	
    	try {
            pstmt = con.prepareStatement(sql);
            int i = pstmt.executeUpdate();
            System.out.println("가입성공");
            return 2;
           
        } catch (SQLException e) { 
        	System.out.println("쿼리 수행 실패"); 
        }
    	return 0;
    }


}
