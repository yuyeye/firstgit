package shiyan2;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.util.*;
import java.sql.*;

class BookBrower    implements  ActionListener
{   
   
	JFrame f;
	Container cp;
	JPanel jpS,jpanelWest;
	JButton  jbt1,jbt2;//按钮，查询、取消、修改
	JLabel label,L;				//标签
	JTable table;//用来接收数据库中返回的信息
    Object columnName[]={"图书名","图书号","单价","作者","出版社","入库时间"};
    Object ar[][] =new Object[80][6];
	String sno;
	String count="xx";
	
    BookBrower()
   { 
	f=new JFrame();
	cp=f.getContentPane(); // 初始化面板、按钮、标签、文本框
	jpS=new JPanel();       
    jpanelWest=new JPanel();
	jbt1=new JButton("确定");   
	jbt2=new JButton("返回");
	label=new JLabel("<html><font color=#CC00FF size='4'>图书概览</font>",SwingConstants.CENTER);
	label.setForeground(Color.blue);
	L=new JLabel("书库现在共有图书"+count+"本");
    table=new JTable(ar,columnName);//ar存放表中的数据，columnname表示列名
	JScrollPane scrollpane = new JScrollPane(table);
	jpS.add(jbt1);	
	jpS.add(jbt2);
	JPanel jpanel=new JPanel();
	jpanel.add(label);
	JPanel pp4=new JPanel();
    JPanel jpE=new JPanel();	
	cp.add(jpanel,"North");
	JPanel jp=new JPanel();
	//jp.add(scrollpane);
	JPanel p=new JPanel();//用来放两个表
	p.setLayout(new BorderLayout());	
	p.add(L,"North");p.add(scrollpane);   
	cp.add(pp4,"West");cp.add(p,"Center");cp.add(jpS,"South");cp.add(jpE,"East");

    Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screen=kit.getScreenSize();
	int x=screen.width;					/*取得显示器窗口的宽度*/
	int y=screen.height;					/*取得显示器窗口的高度*/
	 f.setSize(400,330);
	 int xcenter=(x-350)/2;
	 int ycenter=(y-330)/2;
     f.setLocation(xcenter,ycenter);/*显示在窗口中央*/
	  f.setVisible(true);
   //-------------------------------------------------
    jbt1.addActionListener(this);//注册监听器
    jbt2.addActionListener(this);
    
   /* f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		}
		);*/
	}
	//------------------------------------------------
	int i=0;
   public void showRecord()
	{ 
		while(i>=0)
			{	
			ar[i][0]="";
			ar[i][1]="";
			ar[i][2]="";
			ar[i][3]="";
			ar[i][4]="";
			ar[i][5]="";
			i--;
			}
			i=0;


        try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   }catch(ClassNotFoundException e){System.out.println("加载驱动程序失败!");}
		try{
			 String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=Book.mdb";//直接使用当前类目录下的数据库文件
			 Connection con=DriverManager.getConnection(url);
					
			 String s="select * from book ";
             Statement sql=con.createStatement();
			  ResultSet rs=sql.executeQuery(s);
			  
            
			 while(rs.next())
	          {
			    String bname=rs.getString(1);
				String bno=rs.getString(2);
				String price=rs.getString(3);
				String writer=rs.getString(4);
				String publish=rs.getString(5);
				String indate=rs.getString(6);
				ar[i][0]=bname;
				ar[i][1]=bno;
				ar[i][2]=price;
				ar[i][3]=writer;
				ar[i][4]=publish;
				ar[i][5]=indate;
				i++;
			  }
			    count=""+i+"";
				L.setText("书库现在共有图书"+count+"本");
				f.repaint();
			
				 con.close();
           }catch(SQLException g)
				{
				 System.out.println("E Code"+g.getErrorCode());
				 System.out.println("E M"+g.getMessage());
			    }
    
	 }
	
 public void actionPerformed(ActionEvent e)
	{  
		
		
		 String cmd=e.getActionCommand();
		  if(cmd.equals("确定"))
			 
			   {
         		 f.hide();
				
			  } 
		   
		   if(cmd.equals("返回"))
				   f.hide(); 
		         
				
	}
public static void main(String []arg){
		   
		   BookBrower a=new BookBrower();
		   a.showRecord();
}

}
