package uas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class menu_login extends JFrame
{
	public static String s_user;
	public static String s_log;
	
	private static final int lebar = 400;
	private static final int tinggi = 300;
	private static final int posisi_x = 500;
	private static final int posisi_y = 250;
	
	// header
	private JLabel header = new JLabel("Selamat Datang Di Toko Obat Roses");
	
	// username
	private JLabel username = new JLabel("Username");
	private JTextField user = new JTextField();
	
	// password
	private JLabel password = new JLabel("Password");
	private JPasswordField pass = new JPasswordField();
	
	// button
	private JButton login = new JButton("Login");
	private JButton cancel = new JButton("Cancel");
	
	// tulisan
	private JLabel copyright = new JLabel("© Yun Krisdianto (2015) IBIS STIKOM Surabaya");
	
	private JOptionPane jop = new JOptionPane();
	
	//private JLabel image = new JLabel();
	
	public menu_login(String judul)
	{
		super(judul);
		setSize(lebar,tinggi);
		setLocation(posisi_x,posisi_y);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		//image.setIcon(new ImageIcon("D:/Kris(hapus awas)/kris/gambar/converse.jpg"));
		//image.setBounds(10, 12, 100, 100);
		
		Container kontainer = getContentPane();
		kontainer.setLayout(null);
		//kontainer.setBackground(Color.blue);
				
		header.setBounds(90,10,220,20);
		username.setBounds(100, 100, 70, 20);
		user.setBounds(170, 100, 100, 20);
		password.setBounds(100, 130, 70, 20);
		pass.setBounds(170, 130, 100, 20);
		login.setBounds(110,170,70,20);
		cancel.setBounds(185,170,80,20);
		copyright.setBounds(70,220,300,20);
		
		kontainer.add(header);
		kontainer.add(username);
		kontainer.add(user);
		kontainer.add(password);
		kontainer.add(pass);
		kontainer.add(login);
		kontainer.add(cancel);
		kontainer.add(copyright);
		//kontainer.add(image);
		
		login.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				main_karyawan mk = new main_karyawan();
				karyawan kar = mk.cari_pass(user.getText());
				try
				{
					if(kar.getPassword().equalsIgnoreCase(pass.getText()))
					{
						if(kar.getId_divisi().equalsIgnoreCase("DIV-1"))
						{
							menu_admin admin = new menu_admin("Selamat Datang " + user.getText());
							admin.setVisible(true);
							s_user = user.getText();
							s_log = "admin";
							dispose();
						}
						else
						{
							menu_kasir mksr = new menu_kasir("Selamat Datang " + user.getText());
							mksr.setVisible(true);
							s_user = user.getText();
							s_log = "kasir";
							dispose();
						}
					}
					else
					{
						jop.showConfirmDialog(null, "Kombinasi Usename & Password Salah", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
					}
				}
				catch (Exception a)
				{
					jop.showConfirmDialog(null, "Username Salah", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
				}
			}
		}
		);
		cancel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		}
		);
	}
	public static void main(String [] args)
	{
		menu_login log = new menu_login("Login");
		log.setVisible(true);
	}
}
