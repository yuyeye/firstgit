package shiyan2;
import java.net.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;import java.util.*;
class Book extends JFrame implements ActionListener 
{
	JButton QueryScore=new JButton("图书查询");
	JButton  QueryXuefen=new JButton("图书入库");
	JButton  jiangfa=new JButton("图书删除");
	JButton  xuanke=new JButton("图书概览");
	JMenuBar mb = new JMenuBar();//菜单栏
	JPanel jp=new JPanel();//用来填放子模块
	Container cp=getContentPane();
    String	username;
	Book(){}
    Book(String username)
	{
		this.username=username;
		mb.add(QueryScore);
		mb.add(QueryXuefen);
		mb.add(jiangfa);
		mb.add(xuanke);
        cp.add(mb,"North");
	    jp.setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createLineBorder(Color.blue, 2),null, 
				TitledBorder.CENTER, TitledBorder.TOP));
		jp.setLayout(new BorderLayout());
         JLabel label1 = new JLabel(new ImageIcon("4.jpg"));
		jp.add(label1);
		JLabel label2 = new JLabel(new ImageIcon("2.jpg"));
		JScrollPane scrollpane=new JScrollPane(jp);
		cp.add(scrollpane);
		setTitle("欢迎登陆");
 
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screen=kit.getScreenSize();
		int x=screen.width;					/*取得显示器窗口的宽度*/
		int y=screen.height;					/*取得显示器窗口的高度*/
	 	setSize(600,600);				
	    int xcenter=(x-600)/2;
	    int ycenter=(y-600)/2;
	    setLocation(xcenter,ycenter);/*显示在窗口中央*/	
		setVisible(true);						
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//注册临听器
		QueryScore.addActionListener(this);
		QueryXuefen.addActionListener(this);
		jiangfa.addActionListener(this);
		xuanke.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String cmd=e.getActionCommand();
		if (cmd.equals("图书查询"))
		{
			new QueryBook();
		}
		if (cmd.equals("图书入库"))
		{
			new BookIn();
		}
		if (cmd.equals("图书删除"))
		{
			new RemoveBook();
		}
		if (cmd.equals("图书概览"))
		{
			new BookBrower().showRecord();
		} 
}
public static void main(String[]args)
	{
		new Book("");
		}
}

