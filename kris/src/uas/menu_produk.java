package uas;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu_produk extends JFrame
{
	private String cek;
	private static final int lebar = 380;
	private static final int tinggi = 200;
	private static final int posisi_x = 150;
	private static final int posisi_y = 250;
	
	// atas
	private JLabel id_produk = new JLabel("ID Produk");
	private JLabel nama_produk = new JLabel("Nama");
	private JLabel id_suplier = new JLabel("ID Suplier");
	private JLabel harga_produk = new JLabel("Harga");
	private JLabel stok_produk = new JLabel("Stok");
	
	private JTextField id_pro = new JTextField(10);
	private JTextField nama_pro = new JTextField(10);
	private JTextField id_sup = new JTextField(10);
	private JTextField harga_pro = new JTextField(10);
	private JTextField stok_pro = new JTextField(10);
	
	private JButton cari = new JButton("Cari");
	
	// bawah
	private JButton tambah = new JButton("Tambah");
	private JButton ubah = new JButton("Ubah");
	private JButton hapus = new JButton("Hapus");
	private JButton batal = new JButton("Batal");
	
	private JOptionPane jop = new JOptionPane();

	public menu_produk(String judul)
	{
		super(judul);
		setSize(lebar,tinggi);
		setLocation(posisi_x,posisi_y);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		ubah.setEnabled(false);
		hapus.setEnabled(false);
		
		Container kontainer = getContentPane();
		kontainer.setLayout(null);
		
		// baris 1
		id_produk.setBounds(10,10,100,20);
		id_pro.setBounds(100,10,160,20);
		cari.setBounds(270,10,80,20);
		
		// baris 2
		nama_produk.setBounds(10,35,100,20);
		nama_pro.setBounds(100,35,160,20);
		
		// baris 3
		harga_produk.setBounds(10,60,100,20);
		harga_pro.setBounds(100,60,160,20);
		
		// baris 4
		stok_produk.setBounds(10,85,100,20);
		stok_pro.setBounds(100,85,160,20);
		
		// baris 4
		id_suplier.setBounds(10,110,100,20);
		id_sup.setBounds(100,110,160,20);
				
		// baris 6
		tambah.setBounds(10,145,80,20);
		ubah.setBounds(100,145,80,20);
		hapus.setBounds(190,145,80,20);
		batal.setBounds(280,145,80,20);
		
		kontainer.add(id_produk);
		kontainer.add(id_pro);
		kontainer.add(cari);
		kontainer.add(nama_produk);
		kontainer.add(nama_pro);
		kontainer.add(harga_produk);
		kontainer.add(harga_pro);
		kontainer.add(stok_produk);
		kontainer.add(stok_pro);
		kontainer.add(id_suplier);
		kontainer.add(id_sup);
		kontainer.add(tambah);
		kontainer.add(ubah);
		kontainer.add(hapus);
		kontainer.add(batal);
		
		cari.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					nama_pro.setText("");
					id_sup.setText("");
					harga_pro.setText("");
					stok_pro.setText("");
					
					main_produk mp = new main_produk();
					produk p = mp.cariById(id_pro.getText());
					
					nama_pro.setText(p.getNama_produk());
					id_sup.setText(p.getId_suplier());
					harga_pro.setText(String.valueOf(p.getHarga()));
					stok_pro.setText(String.valueOf(p.getStok()));
					
					tambah.setEnabled(false);
					ubah.setEnabled(true);
					hapus.setEnabled(true);
				}
				catch(Exception a)
				{
					jop.showConfirmDialog(null, "Data Pencarian Tidak Ditemukan", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
				}
			}
		}
		);
		
		tambah.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					cek = id_sup.getText();
					if(cek.length() != 0)
					{
						main_produk mp = new main_produk();
						produk p = mp.cariById(id_pro.getText());
						if(p == null)
						{
							mp.insert_pro(id_pro.getText(),nama_pro.getText(),id_sup.getText(),Integer.parseInt(harga_pro.getText()),Integer.parseInt(stok_pro.getText()));
							
							id_pro.setText("");
							nama_pro.setText("");
							id_sup.setText("");
							harga_pro.setText("");
							stok_pro.setText("");
							
							jop.showConfirmDialog(null, "Data Produk Berhasil Ditambah", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
						}
						else
						{
							jop.showConfirmDialog(null, "Data Tidak Valid", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
						}
					}
					else
					{
						jop.showConfirmDialog(null, "Data Tidak Valid", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
					}
				}
				catch(Exception a)
				{
					jop.showConfirmDialog(null, "Data Tidak Valid", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
				}
			}
		}
		);
		
		ubah.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					cek = id_pro.getText();
					if(cek.length() != 0)
					{
						main_produk mp = new main_produk();
						produk p = mp.cariById(id_pro.getText());
						if(p != null)
						{
							mp.update_pro(id_pro.getText(),nama_pro.getText(),id_sup.getText(),harga_pro.getText(),stok_pro.getText());
							
							id_pro.setText("");
							nama_pro.setText("");
							id_sup.setText("");
							harga_pro.setText("");
							stok_pro.setText("");
							
							tambah.setEnabled(true);
							ubah.setEnabled(false);
							hapus.setEnabled(false);
							
							jop.showConfirmDialog(null, "Data Produk Berhasil Dirubah", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
						}
						else
						{
							jop.showConfirmDialog(null, "Data Tidak Valid", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
						}
					}
					else
					{
						jop.showConfirmDialog(null, "Data Tidak Valid", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
					}
				}
				catch(Exception a)
				{
					jop.showConfirmDialog(null, "Data Tidak Valid", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
				}
			}
		}
		);
		
		hapus.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					cek = id_pro.getText();
					if(cek.length() != 0)
					{
						main_produk mp = new main_produk();
						produk p = mp.cariById(id_pro.getText());
						if(p != null)
						{
							mp.delete_pro(id_pro.getText());
							
							id_pro.setText("");
							nama_pro.setText("");
							id_sup.setText("");
							harga_pro.setText("");
							stok_pro.setText("");
							
							tambah.setEnabled(true);
							ubah.setEnabled(false);
							hapus.setEnabled(false);
							
							jop.showConfirmDialog(null, "Data Produk Berhasil Dihapus", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
						}
						else
						{
							jop.showConfirmDialog(null, "Data Tidak Valid", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
						}
					}
					else
					{
						jop.showConfirmDialog(null, "Data Tidak Valid", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
					}
				}
				catch(Exception a)
				{
					jop.showConfirmDialog(null, "Data Tidak Valid", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
				}
			}
		}
		);
		
		batal.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				id_pro.setText("");
				nama_pro.setText("");
				harga_pro.setText("");
				stok_pro.setText("");
				id_sup.setText("");
				
				tambah.setEnabled(true);
				ubah.setEnabled(false);
				hapus.setEnabled(false);
			}
		}
		);
	}
	public static void main(String [] args)
	{
		menu_produk mp = new menu_produk("");
		mp.setVisible(true);
	}
}