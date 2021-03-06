package shiyan2;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.util.*;
import java.sql.*;

class QueryBook implements ActionListener
{   
   
	JFrame f3;
	Container cp;
	JPanel jp1,jp2,jp3,jp4,jp,jpanelWest;
	JButton  jbt1,jbt2;//按钮，确定、取消
	JLabel label;				//标签：请输入图书号
	JTextField tf,tf1,tf2,tf3,tf4,tf5,tf6;    //定义文本框
	JLabel label1,label2,label3,label4;
	
    QueryBook()
   { 
	f3=new JFrame();
	cp=f3.getContentPane(); // 初始化面板、按钮、标签、文本框
	jp1=new JPanel();       
	jp2=new JPanel();
	jp3=new JPanel();
	jp4=new JPanel();
	jpanelWest=new JPanel();
	jp=new JPanel();
	jbt1=new JButton("确定");   
	jbt2=new JButton("取消");
	label=new JLabel("<html><font color=#CC00FF size='4'>请输入图书号：</font>",SwingConstants.CENTER);
	label.setForeground(Color.blue);
	tf=new JTextField(20);
	tf1=new JTextField(20);
	tf2=new JTextField(20);
	tf3=new JTextField(20);
	tf4=new JTextField(20);
	tf5=new JTextField(20);
    tf6=new JTextField(20);
	JPanel jpanel=new JPanel();
	jpanel.add(label);jpanel.add(tf);
	JPanel pp4=new JPanel();
    JPanel jpane4=new JPanel();
	cp.add(jpanel,"North");
	JPanel pp2=new JPanel(new GridLayout(6,1));
	JPanel pp3=new JPanel();
	pp4.setLayout(new GridLayout(6,1));
	pp4.add(new JLabel("图书名",SwingConstants.CENTER));pp2.add(tf1);
	pp4.add(new JLabel("图书号",SwingConstants.CENTER));pp2.add(tf2);
	pp4.add(new JLabel("单  价",SwingConstants.CENTER));pp2.add(tf3);
	pp4.add(new JLabel("作  者",SwingConstants.CENTER));pp2.add(tf4);
	pp4.add(new JLabel("出版社",SwingConstants.CENTER));pp2.add(tf5);
	pp4.add(new JLabel("入库时间",SwingConstants.CENTER));
	pp2.add(tf6);pp3.add(jbt1);pp3.add(jbt2); 
	cp.add(pp4,"West");cp.add(pp2,"Center");
    cp.add(pp3,"South"); cp.add(jpane4,"East");
    Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screen=kit.getScreenSize();
	int x=screen.width;					
	int y=screen.height;				
	f3.setSize(350,330);
	 int xcenter=(x-350)/2;int ycenter=(y-330)/2;
	 f3.setLocation(xcenter,ycenter);/*显示在窗口中央*/
	 f3.setVisible(true);
     jbt1.addActionListener(this);//注册监听器
    jbt2.addActionListener(this);  
	}

public void showRecord()
	{ 
        try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   }catch(ClassNotFoundException e){System.out.println("加载驱动程序失败!");}
		try{
			String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=Book.mdb";//直接使用当前类目录下的数据库文件
			Connection con=DriverManager.getConnection(url);
			Statement sql;		
			String ql=tf.getText().trim();
			String s="select * from book  where 图书号 ='"+ql +"'";
            sql=con.createStatement();
			 ResultSet rs=sql.executeQuery(s);
			 if(rs.next())
	         {		  
		       String bname=rs.getString(1);
				String bno=rs.getString(2);
				String price=rs.getString(3);
				String writer=rs.getString(4);
				String publish=rs.getString(5);
				String indate=rs.getString(6);
				tf1.setText(bname);tf2.setText(bno);tf3.setText(price);
				tf4.setText(writer);tf5.setText(publish);tf6.setText(indate);
			 } 
                else
	             {JOptionPane.showMessageDialog(null,"您输入的图书号不存在，请重新输入",
					 "输入错误", JOptionPane.YES_NO_OPTION);
				 }
				 con.close();
            }catch(SQLException g)
				{
				System.out.println("E Code"+g.getErrorCode());
				System.out.println("E M"+g.getMessage());
			     }    
	  tf1.setEditable(false);tf2.setEditable(false); 
	  tf3.setEditable(false);tf4.setEditable(false);
	  tf5.setEditable(false);tf6.setEditable(false);
	}	

public void actionPerformed(ActionEvent e)
	{  
		 String cmd=e.getActionCommand();
		    if(cmd.equals("确定"))			 
			   {
			    showRecord();
				tf.setText("");
			  } 								   
			   else if(cmd.equals("取消"))
				   f3.hide();		         				}
public static void main(String []arg){		   
		   QueryBook a=new QueryBook();
}}

