package uas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu_suplier extends JFrame 
{
	private String cek;
	private static final int lebar = 380;
	private static final int tinggi = 140;
	private static final int posisi_x = 150;
	private static final int posisi_y = 250;
	
	// atas
	private JLabel id_suplier = new JLabel("ID Suplier");
	private JLabel nama_suplier = new JLabel("Nama");
	
	private JTextField id_sup = new JTextField(10);
	private JTextField nama_sup = new JTextField(10);
	
	private JButton cari = new JButton("Cari");
	
	// bawah
	private JButton tambah = new JButton("Tambah");
	private JButton ubah = new JButton("Ubah");
	private JButton hapus = new JButton("Hapus");
	private JButton batal = new JButton("Batal");
	
	private JOptionPane jop = new JOptionPane();

	public menu_suplier(String judul)
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
		id_suplier.setBounds(10,10,100,20);
		id_sup.setBounds(100,10,160,20);
		cari.setBounds(270,10,80,20);
		
		// baris 2
		nama_suplier.setBounds(10,35,100,20);
		nama_sup.setBounds(100,35,160,20);
								
		// baris 6
		tambah.setBounds(10,70,80,20);
		ubah.setBounds(100,70,80,20);
		hapus.setBounds(190,70,80,20);
		batal.setBounds(280,70,80,20);
		
		kontainer.add(id_suplier);
		kontainer.add(id_sup);
		kontainer.add(cari);
		kontainer.add(nama_suplier);
		kontainer.add(nama_sup);		
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
					nama_sup.setText("");
					
					main_suplier ms = new main_suplier();
					suplier s = ms.cari_sup(id_sup.getText());
					
					nama_sup.setText(s.getNama_suplier());
					
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
						main_suplier ms = new main_suplier();
						suplier s = ms.cari_sup(id_sup.getText());
						if(s == null)
						{
							ms.insert_sup(id_sup.getText(),nama_sup.getText());
							
							id_sup.setText("");
							nama_sup.setText("");
							
							jop.showConfirmDialog(null, "Data Suplier Berhasil Ditambah", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
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
					cek = id_sup.getText();
					if(cek.length() != 0)
					{
						main_suplier ms = new main_suplier();
						suplier s = ms.cari_sup(id_sup.getText());
						if(s != null)
						{
							ms.update_sup(id_sup.getText(),nama_sup.getText());
							
							id_sup.setText("");
							nama_sup.setText("");
							
							tambah.setEnabled(true);
							ubah.setEnabled(false);
							hapus.setEnabled(false);
							
							jop.showConfirmDialog(null, "Data Suplier Berhasil Dirubah", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
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
					cek = id_sup.getText();
					if(cek.length() != 0)
					{
						main_suplier ms = new main_suplier();
						suplier s = ms.cari_sup(id_sup.getText());
						if(s != null)
						{
							ms.delete_sup(id_sup.getText());
							
							id_sup.setText("");
							nama_sup.setText("");
							
							tambah.setEnabled(true);
							ubah.setEnabled(false);
							hapus.setEnabled(false);
							
							jop.showConfirmDialog(null, "Data Suplier Berhasil Dihapus", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
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
				id_sup.setText("");
				nama_sup.setText("");
				
				tambah.setEnabled(true);
				ubah.setEnabled(false);
				hapus.setEnabled(false);
			}
		}
		);
	}
	public static void main(String [] args)
	{
		menu_suplier ms = new menu_suplier("");
		ms.setVisible(true);
	}
}