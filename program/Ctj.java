import java.awt.*;  
import javax.swing.*;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.*;

public class Ctj extends JFrame  
{  
    public Ctj()  
    {  
        super("向我推荐"); setSize(400,300);  
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
            rowName.add("年龄");
            rowName.add("身高");
            rowName.add("薪水");
            rowName.add("民族");
            rowName.add("籍贯");
      
            try {
                db1.pst=db1.conn.prepareStatement("select m_max_tall,m_min_tall,m_max_salary,m_min_salary,m_max_age,m_min_age,if_same_nation,if_same_native from marry.m_re where m_id='"+Login.c_name+"'");
            	ret1=db1.pst.executeQuery();
            	int m_max_tall=0; 
                int m_min_tall=0;
                int m_max_salary=0; 
                int m_min_salary=0;
                int m_max_age=0;
                int m_min_age=0;
                boolean if_same_nation=false;
                boolean if_same_native=false;
                String m_nation=null;
                String m_native=null;
            	if(ret1.next()) {{
            		 m_max_tall = ret1.getInt(1); 
                     m_min_tall = ret1.getInt(2);
                     m_max_salary = ret1.getInt(3); 
                     m_min_salary = ret1.getInt(4); 
                     m_max_age = ret1.getInt(5); 
                     m_min_age = ret1.getInt(6); 
                     if_same_nation = ret1.getBoolean(7); 
                     if_same_native = ret1.getBoolean(8); 
                    }//获取要求

                db1.pst=db1.conn.prepareStatement("select c_nation,c_native from marry.candidate where c_idcard='"+Login.c_name+"'");
            	ret1=db1.pst.executeQuery();
            	if(ret1.next()) {
                    m_nation = ret1.getString(1); 
                    m_native = ret1.getString(2); 
                   }//获取要求
            	
                    db1.pst=db1.conn.prepareStatement("select c_tall,c_salary,datediff(year,c_age,sysdate)+5,c_nation,c_native,c_name from marry.candidate where c_sex='女'");
                	ret1=db1.pst.executeQuery();
                	while(ret1.next()) {
                	int score = 0;
               		int tall_ = ret1.getInt(1);
               		if(tall_<=m_max_tall&&tall_>=m_min_tall)score++;
                    int salary_ = ret1.getInt(2);
                    if(salary_<=m_max_salary&&salary_>=m_min_salary)score++;
                    int age_ = ret1.getInt(3);
                    if(age_<=m_max_age&&age_>=m_min_age)score++;
                    String nation_ = ret1.getString(4);
                    if(if_same_nation==false)score++;
                    else {
                    	if(nation_.equals(m_nation))score++;
                    	}
                    String native_ = ret1.getString(5);

                    if(if_same_native==false)score++;
                    else {
                    	if(native_.equals(m_native))score++;
                    	}
                    String name_ = ret1.getString(6);
                    if(score>=5) {
                    	row.add(name_);
                    	row.add(age_);
                    	row.add(tall_);
                    	row.add(salary_);
                    	row.add(nation_);
                    	row.add(native_);
                    	
                    	data.add(row);

                        row = new Vector();
                    	
                    }
                       }//显示数据
                	
            	}
            	
            	
        		//db1.pst=db1.conn.prepareStatement("select c_name,meettime,point from marry.candidate,marry.records where c_idcard in (select m_id from marry.records where w_id='"+"2220153711"+"') and marry.candidate.c_idcard=marry.records.m_id and w_id='"+"2220153711"+"'" );
            	//ret=db1.pst.executeQuery();

                	db1.pst=db1.conn.prepareStatement("select w_max_tall,w_min_tall,w_max_salary,w_min_salary,w_max_age,w_min_age,if_same_nation,if_same_native from marry.w_re where w_id='"+Login.c_name+"'");
                	ret2=db1.pst.executeQuery();
                	int w_max_tall=0; 
                    int w_min_tall=0;
                    int w_max_salary=0; 
                    int w_min_salary=0;
                    int w_max_age=0;
                    int w_min_age=0;
                    boolean w_if_same_nation=false;
                    boolean w_if_same_native=false;
                    String w_nation=null;
                    String w_native=null;
                	if(ret2.next()) {{
                		 w_max_tall = ret2.getInt(1); 
                         w_min_tall = ret2.getInt(2);
                         w_max_salary = ret2.getInt(3); 
                         w_min_salary = ret2.getInt(4); 
                         w_max_age = ret2.getInt(5); 
                         w_min_age = ret2.getInt(6); 
                         if_same_nation = ret2.getBoolean(7); 
                         if_same_native = ret2.getBoolean(8); 
                        }//获取要求

                    db1.pst=db1.conn.prepareStatement("select c_nation,c_native from marry.candidate where c_idcard='"+Login.c_name+"'");
                	ret2=db1.pst.executeQuery();
                	if(ret2.next()) {
                        w_nation = ret2.getString(1); 
                        w_native = ret2.getString(2); 
                       }//获取要求
                	
                        db1.pst=db1.conn.prepareStatement("select c_tall,c_salary,datediff(year,c_age,sysdate)+5,c_nation,c_native,c_name from marry.candidate where c_sex='男'");
                    	ret2=db1.pst.executeQuery();
                    	while(ret2.next()) {
                    	int score = 0;
                   		int tall_ = ret2.getInt(1);
                   		if(tall_<=w_max_tall&&tall_>=w_min_tall)score++;
                        int salary_ = ret2.getInt(2);
                        if(salary_<=w_max_salary&&salary_>=w_min_salary)score++;
                        int age_ = ret2.getInt(3);
                        if(age_<=w_max_age&&age_>=w_min_age)score++;
                        String nation_ = ret2.getString(4);
                        if(if_same_nation==false)score++;
                        else {
                        	if(nation_.equals(w_nation))score++;
                        	}
                        String native_ = ret2.getString(5);
                        if(if_same_native==false)score++;
                        else {
                        	if(native_.equals(w_native))score++;
                        	}
                        String name_ = ret2.getString(6);
                        if(score>=5) {
                        	row.add(name_);
                        	row.add(age_);
                        	row.add(tall_);
                        	row.add(salary_);
                        	row.add(nation_);
                        	row.add(native_);
                        	
                        	data.add(row);

                            row = new Vector();
                        	
                        }
                           }//显示数据
                	}
            	
                ret1.close(); 
                ret2.close(); 
                db1.close();//关闭连接  
            }catch (SQLException e1) {  
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
    	Ctj ctj = new Ctj();
    }  
}  