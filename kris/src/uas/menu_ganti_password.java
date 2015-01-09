package uas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu_ganti_password extends JFrame 
{
	private static final int lebar = 250;
	private static final int tinggi = 150;
	private static final int posisi_x = 150;
	private static final int posisi_y = 250;
		
	// bag tengah
	private JLabel pass_lama = new JLabel("Password Lama");
	private JLabel pass_new = new JLabel("Password Baru");
	private JLabel re_pass_new = new JLabel("Re-Password Baru");
	
	private JPasswordField p_lama = new JPasswordField(10);
	private JPasswordField p_new = new JPasswordField(10);
	private JPasswordField re_p_new = new JPasswordField(10);
	
	// button
	private JButton simpan = new JButton("Simpan");
	private JButton batal = new JButton("Batal");
	
	private JOptionPane jop = new JOptionPane();
	
	public menu_ganti_password(String judul)
	{
		super(judul);
		setSize(lebar,tinggi);
		setLocation(posisi_x,posisi_y);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		Container kontainer = getContentPane();
		kontainer.setLayout(null);
		
		pass_lama.setBounds(10,10,100,20);
		p_lama.setBounds(130,10,100,20);
		pass_new.setBounds(10,35,100,20);
		p_new.setBounds(130,35,100,20);
		re_pass_new.setBounds(10,60,130,20);
		re_p_new.setBounds(130,60,100,20);
		simpan.setBounds(15,90,100,20);
		batal.setBounds(125,90,100,20);
		
		kontainer.add(pass_lama);
		kontainer.add(p_lama);
		kontainer.add(pass_new);
		kontainer.add(p_new);
		kontainer.add(re_pass_new);
		kontainer.add(re_p_new);
		kontainer.add(simpan);
		kontainer.add(batal);
		
		simpan.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					menu_login ml = new menu_login("Login");
					main_karyawan mk = new main_karyawan();
					karyawan k = mk.search_pass(p_lama.getText(),ml.s_user);
					if(p_lama.getText().equalsIgnoreCase(k.getPassword()))
					{
						String tes = p_new.getText();
						if(tes.length() != 0)
						{
							if(p_new.getText().equalsIgnoreCase(re_p_new.getText()))
							{
								mk.update_pass(p_new.getText(), k.getId_karyawan());
								
								p_lama.setText("");
								p_new.setText("");
								re_p_new.setText("");
								
								jop.showConfirmDialog(null, "Password Berhasil Dirubah", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
							}
							else
							{
								jop.showConfirmDialog(null, "Password Baru & Re-Password Tidak Cocok", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
							}
						}
						else
						{
							jop.showConfirmDialog(null, "Password Tidak Boleh Kosong", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
						}
					}
				}
				catch(Exception a)
				{
					jop.showConfirmDialog(null, "Password Lama Salah", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
				}
			}
		}
		);
		
		batal.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				p_lama.setText("");
				p_new.setText("");
				re_p_new.setText("");
			}
		}
		);
	}
	public static void main(String [] args)
	{
		menu_ganti_password mgp = new menu_ganti_password("lala");
		mgp.setVisible(true);
	}
}