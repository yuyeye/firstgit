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
	JButton QueryScore=new JButton("ͼ���ѯ");
	JButton  QueryXuefen=new JButton("ͼ�����");
	JButton  jiangfa=new JButton("ͼ��ɾ��");
	JButton  xuanke=new JButton("ͼ�����");
	JMenuBar mb = new JMenuBar();//�˵���
	JPanel jp=new JPanel();//���������ģ��
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
		setTitle("��ӭ��½");
 
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screen=kit.getScreenSize();
		int x=screen.width;					/*ȡ����ʾ�����ڵĿ��*/
		int y=screen.height;					/*ȡ����ʾ�����ڵĸ߶�*/
	 	setSize(600,600);				
	    int xcenter=(x-600)/2;
	    int ycenter=(y-600)/2;
	    setLocation(xcenter,ycenter);/*��ʾ�ڴ�������*/	
		setVisible(true);						
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ע��������
		QueryScore.addActionListener(this);
		QueryXuefen.addActionListener(this);
		jiangfa.addActionListener(this);
		xuanke.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String cmd=e.getActionCommand();
		if (cmd.equals("ͼ���ѯ"))
		{
			new QueryBook();
		}
		if (cmd.equals("ͼ�����"))
		{
			new BookIn();
		}
		if (cmd.equals("ͼ��ɾ��"))
		{
			new RemoveBook();
		}
		if (cmd.equals("ͼ�����"))
		{
			new BookBrower().showRecord();
		} 
}
public static void main(String[]args)
	{
		new Book("");
		}
}

