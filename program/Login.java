import javax.swing.*;  
  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
  
public class Login extends JFrame implements ActionListener {  
  
    //定义组件  
    JButton jb1,jb2=null;  
    JRadioButton jrb1,jrb2=null;  
    JPanel jp1,jp2,jp3,jp4=null;  
    JTextField jtf=null;  
    JLabel jlb1,jlb2=null;  
    JPasswordField jpf=null;  
    ButtonGroup bg=null;  
          
    //设定用户名和密码  
    static String c_name;  
    static String c_pwd;  
    static String w_name;  
    static String w_pwd;  
      
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        Login  ms=new Login();
    }  
    public Login()  
    {  
         //创建组件  
        jb1=new JButton("登录");  
        jb2=new JButton("重置");  
        //设置监听  
        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
          
        jrb1=new JRadioButton("工作人员");  
        jrb2=new JRadioButton("用户");  
        bg=new ButtonGroup();  
        bg.add(jrb1);  
        bg.add(jrb2);  
        jrb2.setSelected(true);  
          
        jp1=new JPanel();  
        jp2=new JPanel();  
        jp3=new JPanel();  
        jp4=new JPanel();                 
          
        jlb1=new JLabel("用户名：");  
        jlb2=new JLabel("密    码：");  
          
        jtf=new JTextField(10);  
        jpf=new JPasswordField(10);  
        //加入到JPanel中  
        jp1.add(jlb1);  
        jp1.add(jtf);  
          
        jp2.add(jlb2);  
        jp2.add(jpf);  
          
        jp3.add(jrb1);  
        jp3.add(jrb2);  
          
        jp4.add(jb1);  
        jp4.add(jb2);  
          
        //加入JFrame中  
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3);  
        this.add(jp4);  
        //设置布局管理器  
        this.setLayout(new GridLayout(4,1));  
        //给窗口设置标题  
        this.setTitle("MOMO婚介");  
        //设置窗体大小  
        this.setSize(300,200);  
        //设置窗体初始位置  
        this.setLocation(200, 150);  
        //设置当关闭窗口时，保证JVM也退出  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //显示窗体  
        this.setVisible(true);  
        this.setResizable(true);  
          
    }  
    @Override  
    public void actionPerformed(ActionEvent e) {  
          
        if(e.getActionCommand()=="登录")  
        {  
            //如果选中工作人员登录  
            if(jrb1.isSelected())  
            {  
                Getcon db1 = null;  
                ResultSet ret = null;  
                    db1 = new Getcon();//创建数据库对象  
              
                    try { 
                    	w_name=jtf.getText();
                        db1.pst=db1.conn.prepareStatement("select w_code from marry.worker where w_idcard='"+ w_name +"'");
                    	ret=db1.pst.executeQuery();
                        while (ret.next()) {  
                            w_pwd = ret.getString(1); 
                        }//显示数据  
                        ret.close();  
                        db1.close();//关闭连接  
                    } catch (SQLException e1) {  
                        e1.printStackTrace();  
                    }    
            	w_login(); 
                   
            }else if(jrb2.isSelected()) //用户在登录系统 
            {  
                Getcon db1 = null;  
                ResultSet ret = null;  
                    db1 = new Getcon();//创建数据库对象  
              
                    try { 
                    	c_name=jtf.getText();
                        db1.pst=db1.conn.prepareStatement("select c_code from marry.candidate where c_idcard='"+ c_name +"'");
                    	ret=db1.pst.executeQuery();
                        while (ret.next()) {  
                            c_pwd = ret.getString(1); 
                        }//显示数据  
                        ret.close();  
                        db1.close();//关闭连接  
                    } catch (SQLException e1) {  
                        e1.printStackTrace();  
                    }  
                     
                  c_login();  
            }  
              
        }else if(e.getActionCommand()=="重置")  
        {  
                  clear();  
        }             
          
    }  
      
     //用户登录判断方法  
    public void c_login()  
    {  
        if(c_name.equals(jtf.getText())&&c_pwd.equals(String.valueOf((jpf).getPassword())))  
        {  
//          System.out.println("登录成功");  
            JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);  
            clear();  
          //关闭当前界面  
            dispose();  
            //创建一个新界面，适用于教师来管理学生  
            Cplace cplace=new Cplace();
        }else if(jtf.getText().isEmpty()&&String.valueOf((jpf).getPassword()).equals(""))  
        {  
            JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
        }else if(jtf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);  
        }else if(String.valueOf((jpf).getPassword()).equals(""))  
        {  
            JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
        }else  
        {  
            JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);  
            //清空输入框  
            clear();  
        }  
    }  
    
   
    
    
    
    //工作登录判断方法 
    
    
    public void w_login()  
    {  
        if(w_name.equals(jtf.getText())&&w_pwd.equals(String.valueOf((jpf).getPassword())))  
        {  
//          System.out.println("登录成功");  
             JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);  
             clear();  
           //关闭当前界面  
             dispose();  
             //创建一个新界面，适用于教师来管理学生  
             Wplace wplace=new Wplace();
        }else if(jtf.getText().isEmpty()&&String.valueOf((jpf).getPassword()).equals(""))  
        {  
            JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
        }else if(jtf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);  
        }else if(String.valueOf((jpf).getPassword()).equals(""))  
        {  
            JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
        }else  
        {  
            JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);  
            //清空输入框  
            clear();  
        }  
    }  
    //清空文本框和密码框  
    public  void clear()  
    {  
        jtf.setText("");  
        jpf.setText("");  
    }  
          
}