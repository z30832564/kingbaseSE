
	import java.awt.*;  
	import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;  
	  
	public class Wadd extends JFrame implements ActionListener  
	{
	         //�������  
	        JButton jb1=null;  
	        JPanel jp1,jp2,jp3,jp4,jp5=null;  
	        JLabel jlb1,jlb2,jlb3,jlb4=null;
	        JTextField jtf1,jtf2,jtf3,jtf4=null; 
	        public static void main(String[] args) {  
	            // TODO Auto-generated method stub  
         // Wadd  wadd=new Wadd();  
	        }  
	          
	        //���캯��  
	        public  Wadd()    //��������Ϊvoid!!!!!���򵯲����½���  
	        {  
	        	
	            //�������    
	        	jp1=new JPanel();  
	            jp2=new JPanel();
	            jp3=new JPanel();  
	            jp4=new JPanel();
	            jp5=new JPanel();
	            jlb1=new JLabel("�з�id");
	            jtf1=new JTextField(10); 
	            jlb2=new JLabel("Ů��id");
	            jtf2=new JTextField(10); 
	            jlb3=new JLabel("Լ��ʱ��");
	            jtf3=new JTextField(10);
	            jlb4=new JLabel("Լ���ص�");
	            jtf4=new JTextField(10); 
	            jb1=new JButton("����");
	            jb1.addActionListener(this);
	            jp1.add(jlb1);
	            jp1.add(jtf1);
	            jp2.add(jlb2);
	            jp2.add(jtf2);
	            jp3.add(jlb3);
	            jp3.add(jtf3);
	            jp4.add(jlb4);
	            jp4.add(jtf4);
	            jp5.add(jb1);
	            this.add(jp1);
	            this.add(jp2);

	            this.add(jp3);
	            this.add(jp4);

	            this.add(jp5);
	            
	          
	            
	            //���ò��ֹ�����  
	            this.setLayout(new GridLayout(5,1));  
	            this.setTitle("���Լ����¼");  
	            this.setSize(400,300);  
	            this.setLocation(200, 200);       
	            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	            this.setVisible(true);
	}  
	        public void check()
	          {  
	           if(jtf1.getText().isEmpty())  
	            {  
	                JOptionPane.showMessageDialog(null,"�������з�id","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
	            }else if(jtf2.getText().isEmpty())  
	            {  
	                JOptionPane.showMessageDialog(null,"������Ů��id","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
	            }else if(jtf3.getText().isEmpty())  
	            {  
	                JOptionPane.showMessageDialog(null,"������Լ��ʱ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
	                
	            }else if(jtf4.getText().isEmpty())  
	            {  
	                JOptionPane.showMessageDialog(null,"������Լ���ص�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
	            }
	            else  
	            {  
	            	Getcon db1 = new Getcon(); 
	                ResultSet ret = null; 
	                    try { 
	                        db1.pst=db1.conn.prepareStatement("insert into marry.records values('"+jtf1.getText()+"','"+jtf2.getText()+"','"+jtf3.getText()+"','"+jtf4.getText()+"')");
	                    	ret=db1.pst.executeQuery(); 
	                        ret.close();  
	                        db1.close();//�ر�����  
	                    } catch (SQLException e1) {  
	                        e1.printStackTrace();  
	                    } 
	                    JOptionPane.showMessageDialog(null,"����ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
	            } 
	           }
	        @Override  
	        public void actionPerformed(ActionEvent e) {  
	        	if(e.getActionCommand()=="����") {
	        	check();
	        }  
	        }
	}  
