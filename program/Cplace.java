
import java.awt.*;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener; 

import javax.swing.*;  
	  
	public class Cplace extends JFrame implements ActionListener  
	{
	         //�������  
	        JButton jb1,jb2,jb3=null;  
	        JPanel jp1,jp2,jp3,jp4,jp5=null;  
	        JLabel jlb1,jlb2,jlb3=null;  
	          
	        public static void main(String[] args) {  
	            // TODO Auto-generated method stub  
//	          UI  ui=new UI();  
	        }  
	          
	        //���캯��  
	        public  Cplace()    //��������Ϊvoid!!!!!���򵯲����½���  
	        {  
	            //�������    
	            jp1=new JPanel();  
	            jp2=new JPanel();  
	            jp3=new JPanel();  
	            jp4=new JPanel(); 
	              
	            jlb1=new JLabel("��ӭ��");
	            Getcon db1 = new Getcon(); 
                ResultSet ret = null; 
                String c_name_ = null;
                    try { 
                        db1.pst=db1.conn.prepareStatement("select c_name from marry.candidate where c_idcard='"+ Login.c_name +"'");
                    	ret=db1.pst.executeQuery();
                        while (ret.next()) {  
                            c_name_ = ret.getString(1); 
                        }//��ʾ����  
                        ret.close();  
                        db1.close();//�ر�����  
                    } catch (SQLException e1) {  
                        e1.printStackTrace();  
                    }  
	            jlb2=new JLabel(c_name_+" ������ѡ��");  	              
	            jp1.add(jlb1);  
	            jp1.add(jlb2);  
	            //���1
	        	jb1=new JButton("�����Ƽ�");  
	        	jb1.addActionListener(this);  
	            jp2.add(jb1);   
	            //2
	            jb2=new JButton("��Ͷ���");
	        	jb2.addActionListener(this); 
	            jp3.add(jb2);  
	            //3
	            jb3=new JButton("Լ����¼"); 
	        	jb3.addActionListener(this); 
	            jp4.add(jb3);  
	            //4
	            
	            jp5=new JPanel();
	            jlb3=new JLabel("MOMO���  Ե������");
	            jlb3.setFont(new java.awt.Font("Dialog", 1, 40));
	            jp5.add(jlb3);
	            
	            this.add(jp1);  
	            this.add(jp2);  
	            this.add(jp3);  
	            this.add(jp4); 
	              
	            //���ò��ֹ�����  
	            this.setLayout(new GridLayout(5,1));  
	            this.setTitle("��������");  
	            this.setSize(900,600);  
	            this.setLocation(5, 5);       
	            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
	            this.setVisible(true);  
	  
	}  
	        @Override  
	        public void actionPerformed(ActionEvent e) {  
	            // TODO Auto-generated method stub  
	        	if(e.getActionCommand()=="�����Ƽ�") {
	        		Ctj ctj = new Ctj();
	        	}
	        	else if(e.getActionCommand()=="��Ͷ���") {
	        		Clover clover = new Clover();
	        	}
	        	else if(e.getActionCommand()=="Լ����¼") {
	        		Cmetlog cmetlog = new Cmetlog();
	        	}
	        	
	        }  
	}  
