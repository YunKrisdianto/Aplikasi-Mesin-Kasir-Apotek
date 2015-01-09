package uas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class menu_kasir extends JFrame 
{
	private static final int lebar = 300;
	private static final int tinggi = 200;
	private static final int posisi_x = 150;
	private static final int posisi_y = 250;
	
	// menu bar
	private JMenuBar menu = new JMenuBar();
	private JMenu file= new JMenu("File");
	private JMenu transaksi= new JMenu("Transaksi");
	
	// menu item
	private JMenuItem ubah_pass = new JMenuItem("Ganti Password");
	private JMenuItem keluar = new JMenuItem("Keluar");
	private JMenuItem kasir = new JMenuItem("Kasir");
	
	public menu_kasir(String judul)
	{
		super(judul);
		setSize(lebar,tinggi);
		setLocation(posisi_x,posisi_y);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		Container kon = getContentPane();
		kon.setLayout(null);
		
		setJMenuBar(menu);
		menu.add(file);
		menu.add(transaksi);
		
		file.add(ubah_pass);
		file.add(keluar);
		transaksi.add(kasir);
		
		ubah_pass.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				menu_login ml = new menu_login("");
				menu_ganti_password mgp = new menu_ganti_password("Anda Masuk Sebagai : " + ml.s_user);
				mgp.setVisible(true);
			}
		}
		);
		
		keluar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				menu_login ml = new menu_login("Menu Login");
				ml.setVisible(true);
				dispose();
			}
		}
		);
		
		kasir.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				menu_transaksi mt = new menu_transaksi("Menu Penjualan");
				mt.setVisible(true);
			}
		}
		);
	}
}
