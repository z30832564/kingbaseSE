
import java.awt.*;  
import javax.swing.*;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.*;

public class Wsearch extends JFrame  
{  
    public Wsearch()  
    {  
        super("我的客户"); setSize(400,300);  
        try{ UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  
        }catch(Exception e){}  
        Container c=getContentPane();  
        //创建表值 
        Getcon db1 = null;  
        ResultSet ret1 = null; 

        ResultSet ret2 = null;
            db1 = new Getcon();//创建数据库对象 
            Vector row = new Vector();
        	Vector data = new Vector();
        	Vector rowName=new Vector(); 
            rowName.add("姓名");
            rowName.add("约见次数");
      
            try {
                db1.pst=db1.conn.prepareStatement("select c_name,count(c_name) from marry.candidate,marry.records,marry.candidate_worker where marry.candidate.c_idcard=marry.records.w_id and\r\n" + 
                		"	marry.candidate.c_idcard=marry.candidate_worker.cw_candidate_id and\r\n" + 
                		"	cw_worker_id='"+Login.w_name+"'\r\n" + 
                		"	group by(c_name)\r\n" + 
                		"	having count(c_name)");
                ret1=db1.pst.executeQuery();
            	if(ret1.next()) {
            		boolean flag = true;
                    while (flag) { 
                       String c_name_ = ret1.getString(1); 
                       row.add(c_name_);
                       String count = ret1.getString(2); 
                       row.add(count);
                       data.add(row);
                       row = new Vector();
                       if(ret1.next()) {
                       }
                       else {
                    	   flag = false;
                       }
                    }//显示数据 
            	}
            	db1.pst=db1.conn.prepareStatement("select c_name,count(c_name) from marry.candidate,marry.records,marry.candidate_worker where marry.candidate.c_idcard=marry.records.m_id and\r\n" + 
                		"	marry.candidate.c_idcard=marry.candidate_worker.cw_candidate_id and\r\n" + 
                		"	cw_worker_id='"+Login.w_name+"'\r\n" + 
                		"	group by(c_name)\r\n" + 
                		"	having count(c_name)");
                ret2=db1.pst.executeQuery();
            	if(ret2.next()) {
            		boolean flag = true;
                    while (flag) { 
                       String c_name_ = ret2.getString(1); 
                       row.add(c_name_);
                       String count = ret2.getString(2); 
                       row.add(count);
                       data.add(row);
                       row = new Vector();
                       if(ret2.next()) {
                       }
                       else {
                    	   flag = false;
                       }
                    }//显示数据 
            	}
                ret1.close(); 
                ret2.close(); 
                db1.close();//关闭连接  
            } catch (SQLException e1) {  
                e1.printStackTrace();  
            }
        JTable table = new JTable(data,rowName);
        JScrollPane jsp = new JScrollPane(table);  
        c.add(jsp);
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }  
  
    public static void main(String []args)  
    {    
    	Wsearch wsearch = new Wsearch();
    }  
}  
