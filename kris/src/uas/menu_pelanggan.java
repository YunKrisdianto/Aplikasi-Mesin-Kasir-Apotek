package uas;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu_pelanggan extends JFrame
{
	private String cek;
	
	private static final int lebar = 370;
	private static final int tinggi = 150;
	private static final int posisi_x = 150;
	private static final int posisi_y = 250;
	
	// atas
	private JLabel id_pelanggan = new JLabel("ID Pelanggan");
	private JLabel nama_pelanggan = new JLabel("Nama");
	private JLabel alamat_pelanggan = new JLabel("Alamat");
	
	private JTextField id_pel = new JTextField();
	private JTextField nama_pel = new JTextField();
	private JTextField alamat_pel = new JTextField();
	
	private JButton cari = new JButton("Cari");
	
	// bawah
	private JButton tambah = new JButton("Tambah");
	private JButton ubah = new JButton("Ubah");
	private JButton hapus = new JButton("Hapus");
	private JButton batal = new JButton("Batal");
	
	private JOptionPane jop = new JOptionPane();
	
	public menu_pelanggan(String judul)
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
		id_pelanggan.setBounds(10,10,100,20);
		id_pel.setBounds(100,10,160,20);
		cari.setBounds(270,10,80,20);
		
		// baris 2
		nama_pelanggan.setBounds(10,35,100,20);
		nama_pel.setBounds(100,35,160,20);
		
		// baris 3
		alamat_pelanggan.setBounds(10,60,100,20);
		alamat_pel.setBounds(100,60,160,20);
		
		// baris 6
		tambah.setBounds(10,90,80,20);
		ubah.setBounds(100,90,80,20);
		hapus.setBounds(190,90,80,20);
		batal.setBounds(280,90,80,20);
		
		kontainer.add(id_pelanggan);
		kontainer.add(id_pel);
		kontainer.add(cari);
		kontainer.add(nama_pelanggan);
		kontainer.add(nama_pel);
		kontainer.add(alamat_pelanggan);
		kontainer.add(alamat_pel);
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
					nama_pel.setText("");
					alamat_pel.setText("");
					
					main_pelanggan mp = new main_pelanggan();
					pelanggan p = mp.cari_id(id_pel.getText());
					
					nama_pel.setText(p.getNama_pelanggan());
					alamat_pel.setText(p.getAlamat_pelanggan());
					
					tambah.setEnabled(false);
					ubah.setEnabled(true);
					hapus.setEnabled(true);
				}
				catch(Exception a)
				{
					jop.showConfirmDialog(null, "Pencarian Tidak Ditemukan", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
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
					cek = id_pel.getText();
					if(cek.length() != 0)
					{
						main_pelanggan mp = new main_pelanggan();
						pelanggan p = mp.cari_id(id_pel.getText());
						if(p == null)
						{
							mp.insert_pel(id_pel.getText(), nama_pel.getText(), alamat_pel.getText());
							
							id_pel.setText("");
							nama_pel.setText("");
							alamat_pel.setText("");
							
							jop.showConfirmDialog(null, "Data Pelanggan Berhasil Ditambah", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
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
					cek = id_pel.getText();
					if(cek.length() != 0)
					{						
						main_pelanggan mp = new main_pelanggan();
						pelanggan p = mp.cari_id(id_pel.getText());
						if(p != null)
						{
							mp.update_pel(id_pel.getText(), nama_pel.getText(), alamat_pel.getText());
							
							id_pel.setText("");
							nama_pel.setText("");
							alamat_pel.setText("");
							
							tambah.setEnabled(true);
							ubah.setEnabled(false);
							hapus.setEnabled(false);
							
							jop.showConfirmDialog(null, "Data Pelanggan Berhasil Dirubah", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
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
					cek = id_pel.getText();
					if(cek.length() != 0)
					{
						main_pelanggan mp = new main_pelanggan();
						pelanggan p = mp.cari_id(id_pel.getText());
						if(p != null)
						{
							mp.delete_pel(id_pel.getText());
							
							id_pel.setText("");
							nama_pel.setText("");
							alamat_pel.setText("");
							
							tambah.setEnabled(true);
							ubah.setEnabled(false);
							hapus.setEnabled(false);
							
							jop.showConfirmDialog(null, "Data Pelanggan Berhasil Dihapus", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
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
				id_pel.setText("");
				nama_pel.setText("");
				alamat_pel.setText("");
				
				tambah.setEnabled(true);
				ubah.setEnabled(false);
				hapus.setEnabled(false);
			}
		}
		);
	}
	public static void main(String [] args)
	{
		menu_pelanggan mk = new menu_pelanggan("Maintenance Karyawan");
		mk.setVisible(true);
	}
}