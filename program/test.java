



import java.sql.ResultSet;  
import java.sql.SQLException;  
  
public class test {  
  
    static String sql = null;  
    static Getcon db1 = null;  
    static ResultSet ret = null;  
  
    public static void main(String[] args) {   
        db1 = new Getcon();//�������ݿ����  
  
        try {  
            db1.pst=db1.conn.prepareStatement("select * from marry.candidate");
        	ret=db1.pst.executeQuery();
            while (ret.next()) {  
                String c_idcard = ret.getString(1);  
                String c_accont = ret.getString(2);  
                String c_key = ret.getString(3);  
                String c_name = ret.getString(4);  
                System.out.println(c_idcard + "\t" + c_accont + "\t" + c_key + "\t" + c_name );  
            }//��ʾ����  
            ret.close();  
            db1.close();//�ر�����  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
  
}  