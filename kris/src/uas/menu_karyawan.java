package uas;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu_karyawan extends JFrame
{
	private String cek;
	
	private static final int lebar = 370;
	private static final int tinggi = 200;
	private static final int posisi_x = 150;
	private static final int posisi_y = 250;
	
	// atas
	private JLabel id_karyawan = new JLabel("ID Karyawan");
	private JLabel nama_karyawan = new JLabel("Nama");
	private JLabel alamat_karyawan = new JLabel("Alamat");
	private JLabel tgl_karyawan = new JLabel("Tanggal Lahir");
	private JLabel id_divisi = new JLabel("ID Divisi");
	
	private JTextField id_kar = new JTextField();
	private JTextField nama_kar = new JTextField();
	private JTextField alamat_kar = new JTextField();
	private JTextField tgl_kar = new JTextField();
	private JTextField id_div = new JTextField();
	
	private JButton cari = new JButton("Cari");
	
	// bawah
	private JButton tambah = new JButton("Tambah");
	private JButton ubah = new JButton("Ubah");
	private JButton hapus = new JButton("Hapus");
	private JButton batal = new JButton("Batal");
	
	private JOptionPane jop = new JOptionPane();
	
	public menu_karyawan(String judul)
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
		id_karyawan.setBounds(10,10,100,20);
		id_kar.setBounds(100,10,160,20);
		cari.setBounds(270,10,80,20);
		
		// baris 2
		nama_karyawan.setBounds(10,35,100,20);
		nama_kar.setBounds(100,35,160,20);
		
		// baris 3
		alamat_karyawan.setBounds(10,60,100,20);
		alamat_kar.setBounds(100,60,160,20);
		
		// baris 4
		tgl_karyawan.setBounds(10,85,100,20);
		tgl_kar.setBounds(100,85,160,20);
		
		// baris 5
		id_divisi.setBounds(10,110,100,20);
		id_div.setBounds(100,110,160,20);
		
		// baris 6
		tambah.setBounds(10,145,80,20);
		ubah.setBounds(100,145,80,20);
		hapus.setBounds(190,145,80,20);
		batal.setBounds(280,145,80,20);
		
		kontainer.add(id_karyawan);
		kontainer.add(id_kar);
		kontainer.add(cari);
		kontainer.add(nama_karyawan);
		kontainer.add(nama_kar);
		kontainer.add(alamat_karyawan);
		kontainer.add(alamat_kar);
		kontainer.add(tgl_karyawan);
		kontainer.add(tgl_kar);
		kontainer.add(id_divisi);
		kontainer.add(id_div);
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
					nama_kar.setText("");
					alamat_kar.setText("");
					tgl_kar.setText("");
					id_div.setText("");
					
					main_karyawan mk = new main_karyawan();
					karyawan k = mk.cari_id(id_kar.getText());
					
					nama_kar.setText(k.getNama_karyawan());
					alamat_kar.setText(k.getAlamat_karyawan());
					tgl_kar.setText(k.getTanggal_lahir().toString());
					id_div.setText(k.getId_divisi());
					
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
					cek = id_kar.getText();
					if(cek.length() != 0)
					{
						main_karyawan mk = new main_karyawan();
						karyawan k = mk.cari_id(id_kar.getText());
						if(k == null)
						{
							mk.insert_kar(id_kar.getText(),nama_kar.getText(),alamat_kar.getText(),tgl_kar.getText(),id_div.getText());
							
							id_kar.setText("");
							nama_kar.setText("");
							alamat_kar.setText("");
							tgl_kar.setText("");
							id_div.setText("");
							
							jop.showConfirmDialog(null, "Data Karyawan Berhasil Ditambah", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
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
					cek = id_kar.getText();
					if(cek.length() != 0)
					{						
						main_karyawan mk = new main_karyawan();
						karyawan k = mk.cari_id(id_kar.getText());
						if(k != null)
						{
							mk.update_kar(id_kar.getText(),nama_kar.getText(),alamat_kar.getText(),tgl_kar.getText(),id_div.getText());
							
							id_kar.setText("");
							nama_kar.setText("");
							alamat_kar.setText("");
							tgl_kar.setText("");
							id_div.setText("");
							
							tambah.setEnabled(true);
							ubah.setEnabled(false);
							hapus.setEnabled(false);
							
							jop.showConfirmDialog(null, "Data Karyawan Berhasil Dirubah", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
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
					cek = id_kar.getText();
					if(cek.length() != 0)
					{
						main_karyawan mk = new main_karyawan();
						karyawan k = mk.cari_id(id_kar.getText());
						if(k != null)
						{
							mk.delete_kar(id_kar.getText());
							
							id_kar.setText("");
							nama_kar.setText("");
							alamat_kar.setText("");
							tgl_kar.setText("");
							id_div.setText("");
							
							tambah.setEnabled(true);
							ubah.setEnabled(false);
							hapus.setEnabled(false);
							
							jop.showConfirmDialog(null, "Data Karyawan Berhasil Dihapus", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
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
				id_kar.setText("");
				nama_kar.setText("");
				alamat_kar.setText("");
				tgl_kar.setText("");
				id_div.setText("");
				
				tambah.setEnabled(true);
				ubah.setEnabled(false);
				hapus.setEnabled(false);
			}
		}
		);
	}
	public static void main(String [] args)
	{
		menu_karyawan mk = new menu_karyawan("Maintenance Karyawan");
		mk.setVisible(true);
	}
}