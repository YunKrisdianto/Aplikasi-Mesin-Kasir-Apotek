package uas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu_divisi extends JFrame 
{
	private String cek;
	private static final int lebar = 380;
	private static final int tinggi = 140;
	private static final int posisi_x = 150;
	private static final int posisi_y = 250;
	
	// atas
	private JLabel id_divisi = new JLabel("ID Divisi");
	private JLabel nama_divisi = new JLabel("Nama");
	
	private JTextField id_div = new JTextField(10);
	private JTextField nama_div = new JTextField(10);
	
	private JButton cari = new JButton("Cari");
	
	// bawah
	private JButton tambah = new JButton("Tambah");
	private JButton ubah = new JButton("Ubah");
	private JButton hapus = new JButton("Hapus");
	private JButton batal = new JButton("Batal");
	
	private JOptionPane jop = new JOptionPane();

	public menu_divisi(String judul)
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
		id_divisi.setBounds(10,10,100,20);
		id_div.setBounds(100,10,160,20);
		cari.setBounds(270,10,80,20);
		
		// baris 2
		nama_divisi.setBounds(10,35,100,20);
		nama_div.setBounds(100,35,160,20);
								
		// baris 6
		tambah.setBounds(10,70,80,20);
		ubah.setBounds(100,70,80,20);
		hapus.setBounds(190,70,80,20);
		batal.setBounds(280,70,80,20);
		
		kontainer.add(id_divisi);
		kontainer.add(id_div);
		kontainer.add(cari);
		kontainer.add(nama_divisi);
		kontainer.add(nama_div);		
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
					nama_div.setText("");
					
					main_divisi md = new main_divisi();
					divisi d = md.cari_divisi(id_div.getText());
					
					nama_div.setText(d.getNama_divisi());
					
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
					cek = id_div.getText();
					if(cek.length() != 0)
					{
						main_divisi md = new main_divisi();
						divisi d = md.cari_divisi(id_div.getText());
						if(d == null)
						{
							md.insert_div(id_div.getText(), nama_div.getText());
							
							id_div.setText("");
							nama_div.setText("");
							
							jop.showConfirmDialog(null, "Data Divisi Berhasil Ditambah", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
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
					cek = id_div.getText();
					if(cek.length() != 0)
					{
						main_divisi md = new main_divisi();
						divisi d = md.cari_divisi(id_div.getText());
						if(d != null)
						{
							md.update_div(id_div.getText(), nama_div.getText());
							
							id_div.setText("");
							nama_div.setText("");
							
							tambah.setEnabled(true);
							ubah.setEnabled(false);
							hapus.setEnabled(false);
							
							jop.showConfirmDialog(null, "Data Divisi Berhasil Dirubah", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
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
					cek = id_div.getText();
					if(cek.length() != 0)
					{
						main_divisi md = new main_divisi();
						divisi d = md.cari_divisi(id_div.getText());
						if(d != null)
						{
							md.delete_div(id_div.getText());
							
							id_div.setText("");
							nama_div.setText("");
							
							tambah.setEnabled(true);
							ubah.setEnabled(false);
							hapus.setEnabled(false);
							
							jop.showConfirmDialog(null, "Data Divisi Berhasil Dihapus", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
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
				id_div.setText("");
				nama_div.setText("");
				
				tambah.setEnabled(true);
				ubah.setEnabled(false);
				hapus.setEnabled(false);
			}
		}
		);
	}
	public static void main(String [] args)
	{
		menu_divisi ms = new menu_divisi("");
		ms.setVisible(true);
	}
}