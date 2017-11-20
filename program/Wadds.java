
	import java.awt.*;  
	import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;  
	  
	public class Wadds extends JFrame implements ActionListener  
	{
	         //定义组件  
	        JButton jb1=null;  
	        JPanel jp1,jp2,jp3,jp4,jp5=null;  
	        JLabel jlb1,jlb2,jlb3,jlb4=null;
	        JTextField jtf1,jtf2,jtf3,jtf4=null; 
	        public static void main(String[] args) {  
	            // TODO Auto-generated method stub  
         // Wadds  wadds=new Wadds();  
	        }  
	          
	        //构造函数  
	        public  Wadds()    //不能申明为void!!!!!否则弹不出新界面  
	        {  
	        	
	            //创建组件    
	        	jp1=new JPanel();  
	            jp2=new JPanel();
	            jp3=new JPanel();  
	            jp4=new JPanel();
	            jp5=new JPanel();
	            jlb1=new JLabel("男方id");
	            jtf1=new JTextField(10); 
	            jlb2=new JLabel("女方id");
	            jtf2=new JTextField(10); 
	            jlb3=new JLabel("男方评价");
	            jtf3=new JTextField(10);
	            jlb4=new JLabel("女方评价");
	            jtf4=new JTextField(10); 
	            jb1=new JButton("保存");
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
	            
	          
	            
	            //设置布局管理器  
	            this.setLayout(new GridLayout(5,1));  
	            this.setTitle("添加双方评价");  
	            this.setSize(400,300);  
	            this.setLocation(200, 200);       
	            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	            this.setVisible(true);
	}  
	        public void check()
	          {  
	           if(jtf1.getText().isEmpty())  
	            {  
	                JOptionPane.showMessageDialog(null,"请输入男方id","提示消息",JOptionPane.WARNING_MESSAGE);  
	            }else if(jtf2.getText().isEmpty())  
	            {  
	                JOptionPane.showMessageDialog(null,"请输入女方id","提示消息",JOptionPane.WARNING_MESSAGE);  
	            }else if(jtf3.getText().isEmpty())  
	            {  
	                JOptionPane.showMessageDialog(null,"请输入男方评价","提示消息",JOptionPane.WARNING_MESSAGE);  
	                
	            }else if(jtf4.getText().isEmpty())  
	            {  
	                JOptionPane.showMessageDialog(null,"请输入女方评价","提示消息",JOptionPane.WARNING_MESSAGE);  
	            }
	            else  
	            {  
	            	Getcon db1 = new Getcon(); 
	                    try { 
	                        db1.pst=db1.conn.prepareStatement("update marry.records set(m_to_w,w_to_m)=('"+jtf3.getText()+ "','"+jtf4.getText()+ "') where m_id='"+jtf1.getText()+ "' and w_id='"+jtf2.getText()+"'");
	                        int i = db1.pst.executeUpdate();            //执行插入数据操作，返回影响的行数
	                                if (i == 1) {
	                                    System.out.println("1");
	                                }
	                        db1.close();//关闭连接  
	                    } catch (SQLException e1) {  
	                        e1.printStackTrace();  
	                    } 
	                    JOptionPane.showMessageDialog(null,"保存成功！","提示消息",JOptionPane.WARNING_MESSAGE);
	            } 
	           }
	        @Override  
	        public void actionPerformed(ActionEvent e) {  
	        	if(e.getActionCommand()=="保存") {
	        	check();
	        }  
	        }
	}  
