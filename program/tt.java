import java.awt.*;  
import javax.swing.*;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.*;

public class tt extends JFrame  
{  
    public tt()  
    {  
        super("我的约见记录"); setSize(400,300);  
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
            rowName.add("时间");
            rowName.add("地点");
      
            try {
            	db1.pst=db1.conn.prepareStatement("select c_name,meettime,point from marry.candidate,marry.records where c_idcard in (select m_id from marry.records where w_id='"+"2220153209"+"') and marry.candidate.c_idcard=marry.records.m_id and w_id='"+"2220153209"+"'");
            	ret1=db1.pst.executeQuery();
            	if(ret1.next()) {
            		boolean flag = true;
                    while (flag) { 
                       String c_name_ = ret1.getString(1); 
                       row.add(c_name_);
                       String meettime = ret1.getString(2); 
                       row.add(meettime);
                       String point = ret1.getString(3); 
                       row.add(point);
                       data.add(row);
                       row = new Vector();
                       if(ret1.next()) {
                       }
                       else {
                    	   flag = false;
                       }
                    }//显示数据 
            	}
            	else {
            		//db1.pst=db1.conn.prepareStatement("select c_name,meettime,point from marry.candidate,marry.records where c_idcard in (select m_id from marry.records where w_id='"+"2220153711"+"') and marry.candidate.c_idcard=marry.records.m_id and w_id='"+"2220153711"+"'" );
                	//ret=db1.pst.executeQuery();

            		db1.pst=db1.conn.prepareStatement("select c_name,meettime,point from marry.candidate,marry.records where c_idcard in (select m_id from marry.records where w_id='"+"2220153201"+"') and marry.candidate.c_idcard=marry.records.m_id and w_id='"+"2220153201"+"'");
                	ret2=db1.pst.executeQuery();
                	int row_count=ret2.getRow();
                    System.out.println(row_count);
                	boolean flag = true;
                    while (flag) { 
                       String c_name_ = ret2.getString(1); 
                       row.add(c_name_);
                       String meettime = ret2.getString(2); 
                       row.add(meettime);
                       String point = ret2.getString(3); 
                       row.add(point);
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
    	tt cmetlog = new tt();
    }  
}  