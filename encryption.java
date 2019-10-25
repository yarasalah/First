import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.Font.*;
import java.io.*;
import java.lang.Object.*;
import javax.swing.filechooser.*;
class T extends JFrame implements ActionListener,ChangeListener {
	 Container c;
	JLabel L1,L2,L3;
	JTextField t;
	JRadioButton r1,r2;
	JButton b1,b2;
	ButtonGroup G;
	JPanel panel;
	JSlider s;
	JFileChooser open,save;
	public T(){
		super("Encryption software images");
		c=getContentPane();
		setLayout(null);
		L1=new JLabel("Open File");
		L1.setBounds(10,60,60,20);
		c.add(L1);
		t=new JTextField();
		t.setBounds(70,60,290,20);
		c.add(t);
		//t.setEditable(false);
		L2=new JLabel("Select the value of protection");
		L2.setBounds(10,100,180,20);
		c.add(L2);
		L3=new JLabel("Value");
		L3.setBounds(390,100,60,20);
		c.add(L3);
		s=new JSlider();
		s.setBounds(180,100,200,20);
		c.add(s);
		G=new ButtonGroup();
		r1=new JRadioButton("Encrypt");
		r1.setBounds(10,10,80,20);
         c.add(r1);
		r2=new JRadioButton("Decrypt");
		r2.setBounds(100,10,80,20);
	    c.add(r2);
		panel=new JPanel();
		panel.setBounds(5,40,470,150);
	    c.add(panel);
    	panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		b1=new JButton(".....");
		b1.setBounds(380,60,50,20);
		c.add(b1);
		b2=new JButton("Select the Encrypt or Decrypt");
		b2.setBounds(10,156,460,20);
		c.add(b2);
		b2.setBackground(Color.green);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	r1.addActionListener(this);
	r2.addActionListener(this);
	b1.addActionListener(this);
	b2.addActionListener(this);
   s.addChangeListener(this);

		L3.setBackground(Color.blue);
		G.add(r1);

		G.add(r2);
		r1.setBackground(Color.green);
		r2.setBackground(Color.green);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(500,250);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==r1){
			b2.setText(r1.getText());
		} else if(e.getSource()==r2){
			b2.setText(r2.getText());
		} else 	if(e.getSource()==b1){
			open=new JFileChooser();
			FileNameExtensionFilter filter=new FileNameExtensionFilter("Text","txt","java");
			open.setFileFilter(filter);
			int rs=open.showOpenDialog(this);
			if(rs==0){
				File path=open.getSelectedFile();
				t.setText(path.toString());
			}
		}else if(e.getSource()==b2){
				FileInputStream in=null;
				FileOutputStream out=null;
			if(r1.isSelected()){
				save=new JFileChooser();
				FileNameExtensionFilter filter=new FileNameExtensionFilter("Text","txt","java");
				save.setFileFilter(filter);
				int rs=save.showSaveDialog(this);
				if(rs==0){
					try{
			     	in=new FileInputStream(t.getText());
			     	out=new FileOutputStream(save.getSelectedFile()+getExtention());
			     	int c;
			     	while((c=in.read())!=-1){
			     		out.write(c);
			     	}
			     	JOptionPane.showMessageDialog(null,"Encrypted successfully");
					}catch(Exception ee){

					}finally{
						try{
					  if(in!=null){
					  	in.close();
					  }
					  	if(out!=null){
					  	out.close();
					  }
					  	//File de=new File(t.getText());
					  //	de.delete();
						}catch(Exception ee){
						}
					}

				}else{
					JOptionPane.showMessageDialog(null,"ÇÎÊÑ ãßÇä ÍÝÙ ÇáãáÝ");
				}
			}else if(r2.isSelected()){
				save=new JFileChooser();
				int rs=save.showSaveDialog(this);
				FileNameExtensionFilter filter=new FileNameExtensionFilter("Text","txt","java");
				save.setFileFilter(filter);
				if(rs==0){
				try{
				in=new FileInputStream(t.getText());
				out=new FileOutputStream(save.getSelectedFile()+getExtention());
				int c;
				while((c=in.read())!=-1){
					out.write(c-s.getValue());
				}

					JOptionPane.showMessageDialog(null,"Decrypted successfully");
				}catch(Exception ee){

				}finally{
							try{
					  if(in!=null){
					  	in.close();
					  }
					  	if(out!=null){
					  	out.close();
					  }
					   	//File de=new File(t.getText());
					  //	de.delete();
						}catch(Exception ee){
						}
				}


				}else{
					JOptionPane.showMessageDialog(null,"ÇÎÊÑ ãßÇä ÍÝÙ ÇáãáÝ");
				}
			}
		}
	}


	public void stateChanged(ChangeEvent e){
		if(e.getSource()==s){
			L3.setText(s.getValue()+"");
		}
	}
	public String getExtention(){
		String extention="";
		int x=t.getText().lastIndexOf('.');
		if(x>0){
		extention=t.getText().substring(x);
		}
		return extention;
	}




	public static void main (String[] args) {
		new T();
}
}