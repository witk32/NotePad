package NotePad;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;


public class NotePad extends JFrame implements ActionListener{
	
	
	
	private static final Object BorderLayout = null;
	private static final int North = 0;
	private static final int South = 0;
	JTextArea jta=null;
	JMenuBar jmb=null;
	JMenu jm1=null;
	JMenu jm2=null;
	
	//JMenuIten--jm1
	JMenuItem jmi1=null;
	JMenuItem jmi2=null;
	JMenuItem jmi3=null;
	JMenuItem jmi4=null;
	
	//filename
	String filename="";
	
	
	public NotePad()
	{
		jta=new JTextArea();
		jmb=new JMenuBar();
		//JMenuBar
		jm1=new JMenu("文件");
		jm2=new JMenu("编辑");
		
		//JMenuItem--文件
		jmi1=new JMenuItem("打开(F)",new ImageIcon("qq.gif"));
		jmi2=new JMenuItem("关闭(C)");
		jmi3=new JMenuItem("保存(S)");
		jmi4=new JMenuItem("另存为(B)");
		
		
		//加入组件
		jmb.add(jm1);
		jmb.add(jm2);
		
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jm1.add(jmi4);
		
		//注册监听
		//open
		jmi1.addActionListener(this);
		jmi1.setActionCommand("open");
		
		//close
		jmi2.addActionListener(this);
		jmi2.setActionCommand("close");
		
		//save
		jmi3.addActionListener(this);
		jmi3.setActionCommand("save");
		
		//lingsave
		jmi4.addActionListener(this);
		jmi4.setActionCommand("lingsave");
		
		
		 
		
		
		
		//放入JFrame
		this.add(jta);
		//this.setLayout(new BorderLayout());
		this.setJMenuBar(jmb);
		this.setLocation(200, 200);
		this.setSize(400,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("NotePad by witk32");
		
		
		
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		//打开
		if (e.getActionCommand().equals("open"))
			{
			//创建一个文件选择组件
			JFileChooser jfc=new JFileChooser();
			//设置对话框标题
			jfc.setDialogTitle("请选择文件");
			//设置组件默认样式
			jfc.showOpenDialog(null);
			jfc.setVisible(true);
			//得到选择的文件的路径
			filename=jfc.getSelectedFile().getAbsolutePath();
			String fname=jfc.getSelectedFile().getName();
			this.setTitle(fname);
			FileReader fr=null;
			BufferedReader bf=null;
	
			try {
				fr=new FileReader(filename);
				bf=new BufferedReader(fr);
				String s="";
				String s1="";
				while((s=bf.readLine())!=null)
				{
					s1+=s+"\r\n";
					jta.setText(s1);
				}
				
			} catch (Exception e1) {
				e1.printStackTrace();
		}
				finally{
				try {
					fr.close();
					bf.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		
			}
		//close
		else if(e.getActionCommand().equals("close"))
		{
			this.jta.setText("");
			this.setTitle("NotePad by witk32");
		}
		//保存
		else if(e.getActionCommand().equals("save")&&(!(filename.equals(""))))
		{
//			String filename2=filename;
//			FileWriter fw=null;
//			BufferedWriter bw=null;
//			System.out.println(filename2);
//			try {
//
//				fw=new FileWriter(filename2);
//				bw=new BufferedWriter(fw);
//				bw.write(this.jta.getText());
//				
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}finally{
//				try {
//				
//					fw.close();
//					bw.close();
//					
//				} catch (Exception e3) {
//					e3.printStackTrace();
//					// TODO: handle exception
//				}
//			}
			String filename2=filename;
			FileWriter fw=null;
			BufferedWriter bf=null;
			try {
				fw=new FileWriter(filename2);
				bf=new BufferedWriter(fw);
				bf.write(this.jta.getText());
			} catch (Exception e2) {
				e2.printStackTrace();
			}finally{
				try {
					bf.close();
					fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		}

		//另存为
		else if(e.getActionCommand().equals("lingsave"))
		{
			JFileChooser jfc=new JFileChooser();
			jfc.setDialogTitle("另存为...");
			jfc.setVisible(true);
			jfc.showSaveDialog(null);
			String filename1=jfc.getSelectedFile().getAbsolutePath();
			FileWriter fw=null;
			BufferedWriter bf=null;
			try {
				fw=new FileWriter(filename1);
				bf=new BufferedWriter(fw);
				bf.write(this.jta.getText());
			} catch (Exception e2) {
				e2.printStackTrace();
			}finally{
				try {
					bf.close();
					fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		}
	
	//主函数
			public static void main(String[] args) {
				// TODO Auto-generated method stub
				NotePad np=new NotePad();
		
			}
	
}

	
	

