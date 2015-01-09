package uas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class menu_admin extends JFrame
{
	private static final int lebar = 400;
	private static final int tinggi = 300;
	private static final int posisi_x = 500;
	private static final int posisi_y = 250;
	
	private JMenu file = new JMenu("File");
	private JMenu master = new JMenu("Master");
	private JMenu transaksi = new JMenu("Transaksi");
	private JMenu laporan = new JMenu("Laporan");
	
	// item file
	private JMenuItem ganti_pass = new JMenuItem("Ubah Password");
	private JMenuItem keluar = new JMenuItem("Keluar");
	
	// item master
	private JMenuItem karyawan = new JMenuItem("Karyawan");
	private JMenuItem produk = new JMenuItem("Produk");
	private JMenuItem suplier = new JMenuItem("Suplier");
	private JMenuItem pelanggan = new JMenuItem("Pelanggan");
	private JMenuItem divisi = new JMenuItem("Divisi");
	
	// item transaksi
	private JMenuItem penjualan = new JMenuItem("Penjualan");
	
	// item laporan
	private JMenuItem lap_penjualan = new JMenuItem("Laporan Penjualan");
	private JMenuItem lap_stok = new JMenuItem("Laporan Stok Produk");
	
	public menu_admin(String judul)
	{
		super(judul);
		setSize(lebar,tinggi);
		setLocation(posisi_x,posisi_y);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		menu.add(file);
		menu.add(master);
		menu.add(transaksi);
		menu.add(laporan);
		
		file.add(ganti_pass);
		file.add(keluar);
		master.add(karyawan);
		master.add(produk);
		master.add(suplier);
		master.add(pelanggan);
		master.add(divisi);
		transaksi.add(penjualan);
		laporan.add(lap_penjualan);
		laporan.add(lap_stok);
		
		ganti_pass.addActionListener(new ActionListener()
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
		
		karyawan.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				menu_karyawan mk = new menu_karyawan("Maintenance Karyawan");
				mk.setVisible(true);
			}
		}
		);
		
		produk.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				menu_produk mp = new menu_produk("Maintenance Produk");
				mp.setVisible(true);
			}
		}
		);
		
		suplier.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				menu_suplier ms = new menu_suplier("Maintenance Suplier");
				ms.setVisible(true);
			}
		}
		);
		
		pelanggan.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				menu_pelanggan mp = new menu_pelanggan("Maintenance Pelanggan");
				mp.setVisible(true);
			}
		}
		);
		
		divisi.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				menu_divisi md = new menu_divisi("Maintenance Divisi");
				md.setVisible(true);
			}
		}
		);
		
		penjualan.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				menu_transaksi mt = new menu_transaksi("Menu Penjualan");
				mt.setVisible(true);
			}
		}
		);
		
		lap_penjualan.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				menu_laporan_penjualan mlp = new menu_laporan_penjualan("Menu Laporan Penjualan");
				mlp.setVisible(true);
			}
		}
		);
		
		lap_stok.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				menu_laporan_stok mls = new menu_laporan_stok("Menu Laporan Stok Produk");
				mls.setVisible(true);
			}
		}
		);
	}
	public static void main(String [] args)
	{
		menu_admin ma = new menu_admin("Admin");
		ma.setVisible(true);
	}
}
