import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException; 
import java.util.*;
public class Getcon {  
    public static final String url = "jdbc:kingbase://127.0.0.1/MOMO";  
    public static final String name = "com.Kingbase.Driver";  
    //public static final String user = "system";  
    //public static final String password = "123456";  
  
    public Connection conn = null;  
    public PreparedStatement pst = null;  
  
    public Getcon() {
        try {  
        	 Scanner scanner=new Scanner(System.in);
             String user = scanner.nextLine(); 
             String password = scanner.nextLine();
             //Class.forName(name);//ָ���������� 
        	DriverManager.registerDriver(new com.kingbase.Driver());
            conn = DriverManager.getConnection(url, user, password);//��ȡ����  
            //pst = conn.prepareStatement(sql);//׼��ִ����� 
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
  
    public void close() {  
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}  






