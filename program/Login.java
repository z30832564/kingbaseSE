import javax.swing.*;  
  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
  
public class Login extends JFrame implements ActionListener {  
  
    //�������  
    JButton jb1,jb2=null;  
    JRadioButton jrb1,jrb2=null;  
    JPanel jp1,jp2,jp3,jp4=null;  
    JTextField jtf=null;  
    JLabel jlb1,jlb2=null;  
    JPasswordField jpf=null;  
    ButtonGroup bg=null;  
          
    //�趨�û���������  
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
         //�������  
        jb1=new JButton("��¼");  
        jb2=new JButton("����");  
        //���ü���  
        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
          
        jrb1=new JRadioButton("������Ա");  
        jrb2=new JRadioButton("�û�");  
        bg=new ButtonGroup();  
        bg.add(jrb1);  
        bg.add(jrb2);  
        jrb2.setSelected(true);  
          
        jp1=new JPanel();  
        jp2=new JPanel();  
        jp3=new JPanel();  
        jp4=new JPanel();                 
          
        jlb1=new JLabel("�û�����");  
        jlb2=new JLabel("��    �룺");  
          
        jtf=new JTextField(10);  
        jpf=new JPasswordField(10);  
        //���뵽JPanel��  
        jp1.add(jlb1);  
        jp1.add(jtf);  
          
        jp2.add(jlb2);  
        jp2.add(jpf);  
          
        jp3.add(jrb1);  
        jp3.add(jrb2);  
          
        jp4.add(jb1);  
        jp4.add(jb2);  
          
        //����JFrame��  
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3);  
        this.add(jp4);  
        //���ò��ֹ�����  
        this.setLayout(new GridLayout(4,1));  
        //���������ñ���  
        this.setTitle("MOMO���");  
        //���ô����С  
        this.setSize(300,200);  
        //���ô����ʼλ��  
        this.setLocation(200, 150);  
        //���õ��رմ���ʱ����֤JVMҲ�˳�  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //��ʾ����  
        this.setVisible(true);  
        this.setResizable(true);  
          
    }  
    @Override  
    public void actionPerformed(ActionEvent e) {  
          
        if(e.getActionCommand()=="��¼")  
        {  
            //���ѡ�й�����Ա��¼  
            if(jrb1.isSelected())  
            {  
                Getcon db1 = null;  
                ResultSet ret = null;  
                    db1 = new Getcon();//�������ݿ����  
              
                    try { 
                    	w_name=jtf.getText();
                        db1.pst=db1.conn.prepareStatement("select w_code from marry.worker where w_idcard='"+ w_name +"'");
                    	ret=db1.pst.executeQuery();
                        while (ret.next()) {  
                            w_pwd = ret.getString(1); 
                        }//��ʾ����  
                        ret.close();  
                        db1.close();//�ر�����  
                    } catch (SQLException e1) {  
                        e1.printStackTrace();  
                    }    
            	w_login(); 
                   
            }else if(jrb2.isSelected()) //�û��ڵ�¼ϵͳ 
            {  
                Getcon db1 = null;  
                ResultSet ret = null;  
                    db1 = new Getcon();//�������ݿ����  
              
                    try { 
                    	c_name=jtf.getText();
                        db1.pst=db1.conn.prepareStatement("select c_code from marry.candidate where c_idcard='"+ c_name +"'");
                    	ret=db1.pst.executeQuery();
                        while (ret.next()) {  
                            c_pwd = ret.getString(1); 
                        }//��ʾ����  
                        ret.close();  
                        db1.close();//�ر�����  
                    } catch (SQLException e1) {  
                        e1.printStackTrace();  
                    }  
                     
                  c_login();  
            }  
              
        }else if(e.getActionCommand()=="����")  
        {  
                  clear();  
        }             
          
    }  
      
     //�û���¼�жϷ���  
    public void c_login()  
    {  
        if(c_name.equals(jtf.getText())&&c_pwd.equals(String.valueOf((jpf).getPassword())))  
        {  
//          System.out.println("��¼�ɹ�");  
            JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
            clear();  
          //�رյ�ǰ����  
            dispose();  
            //����һ���½��棬�����ڽ�ʦ������ѧ��  
            Cplace cplace=new Cplace();
        }else if(jtf.getText().isEmpty()&&String.valueOf((jpf).getPassword()).equals(""))  
        {  
            JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }else if(jtf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }else if(String.valueOf((jpf).getPassword()).equals(""))  
        {  
            JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }else  
        {  
            JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);  
            //��������  
            clear();  
        }  
    }  
    
   
    
    
    
    //������¼�жϷ��� 
    
    
    public void w_login()  
    {  
        if(w_name.equals(jtf.getText())&&w_pwd.equals(String.valueOf((jpf).getPassword())))  
        {  
//          System.out.println("��¼�ɹ�");  
             JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
             clear();  
           //�رյ�ǰ����  
             dispose();  
             //����һ���½��棬�����ڽ�ʦ������ѧ��  
             Wplace wplace=new Wplace();
        }else if(jtf.getText().isEmpty()&&String.valueOf((jpf).getPassword()).equals(""))  
        {  
            JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }else if(jtf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }else if(String.valueOf((jpf).getPassword()).equals(""))  
        {  
            JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }else  
        {  
            JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);  
            //��������  
            clear();  
        }  
    }  
    //����ı���������  
    public  void clear()  
    {  
        jtf.setText("");  
        jpf.setText("");  
    }  
          
}