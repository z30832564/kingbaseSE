
	import java.awt.*;  
	import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;  
	  
	public class Wplace extends JFrame implements ActionListener  
	{
	         //�������  
	        JButton jb1,jb2,jb3=null;  
	        JPanel jp1,jp2,jp3,jp4=null;  
	        JLabel jlb1,jlb2=null;  
	          
	        public static void main(String[] args) {  
	            // TODO Auto-generated method stub  
//	          UI  ui=new UI();  
	        }  
	          
	        //���캯��  
	        public  Wplace()    //��������Ϊvoid!!!!!���򵯲����½���  
	        {  
	            //�������    
	            jp1=new JPanel();  
	            jp2=new JPanel();  
	            jp3=new JPanel();  
	            jp4=new JPanel(); 
	              
	            jlb1=new JLabel("��ӭ��");  
	            Getcon db1 = new Getcon(); 
                ResultSet ret = null; 
                String w_name_ = null;
                    try { 
                        db1.pst=db1.conn.prepareStatement("select w_name from marry.worker where w_idcard='"+ Login.w_name +"'");
                    	ret=db1.pst.executeQuery();
                        while (ret.next()) {  
                            w_name_ = ret.getString(1); 
                        }//��ʾ����  
                        ret.close();  
                        db1.close();//�ر�����  
                    } catch (SQLException e1) {  
                        e1.printStackTrace();  
                    }  
	            jlb2=new JLabel(w_name_+"/n������ѡ��");  	              
	            jp1.add(jlb1);  
	            jp1.add(jlb2);  
	            //���1
	        	jb1=new JButton("���Լ����¼");  
	        	jb1.addActionListener(this); 
	            jp2.add(jb1);   
	            //2
	            jb2=new JButton("���˫������");
	        	jb2.addActionListener(this); 
	            jp3.add(jb2);  
	            //3
	            jb3=new JButton("��ѯ�ҵĿͻ�"); 
	        	jb3.addActionListener(this); 
	            jp4.add(jb3);
	            //4
	            this.add(jp1);  
	            this.add(jp2);  
	            this.add(jp3);  
	            this.add(jp4); 
	              
	            //���ò��ֹ�����  
	            this.setLayout(new GridLayout(4,1));  
	            this.setTitle("��������");  
	            this.setSize(400,300);  
	            this.setLocation(200, 200);       
	            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	            this.setVisible(true);  
	  
	}  
	        @Override  
	        public void actionPerformed(ActionEvent e) {  
	            // TODO Auto-generated method stub  
	        	if(e.getActionCommand()=="���Լ����¼") {
	        		Wadd wadd = new Wadd();
	        	}
	        	else if(e.getActionCommand()=="���˫������") {
	        		Wadds wadds = new Wadds();
	        	}
	        	else if(e.getActionCommand()=="��ѯ�ҵĿͻ�") {
	        		Wsearch wsearch = new Wsearch();
	        	}
	              
	        }  
	}  
