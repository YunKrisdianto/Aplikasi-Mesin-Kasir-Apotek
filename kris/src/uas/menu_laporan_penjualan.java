package uas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class menu_laporan_penjualan extends JFrame 
{
	int thn;
	int bln;
	int tgl;
	String moon;
	String kabisat;
	
	private static final int lebar = 485;
	private static final int tinggi = 390;
	private static final int posisi_x = 150;
	private static final int posisi_y = 250;
	
	// bagian atas
	private JComboBox tahun = new JComboBox();
	private JComboBox bulan = new JComboBox();
	private JComboBox tanggal = new JComboBox();
	private JButton lihat = new JButton("Lihat");
	
	// bagian tengah
	//private JTextArea d_lihat = new JTextArea(20,10);
	
	private JTable d_pen;
	private DefaultTableModel dtm;
	private String header[] = {"ID Transaksi", "Tanggal Transaksi", "ID Karyawan", "ID Pelanggan"};
	
	private JOptionPane jop = new JOptionPane();
	
	public menu_laporan_penjualan(String judul)
	{
		super(judul);
		setSize(lebar,tinggi);
		setLocation(posisi_x,posisi_y);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		// tabel
		dtm = new DefaultTableModel(null, header);
		d_pen = new JTable(dtm);
		d_pen.setModel(dtm);
		
		d_pen.setEnabled(false);
		bulan.setEnabled(false);
		tanggal.setEnabled(false);

		JScrollPane scroll = new JScrollPane(d_pen);
		scroll.setBounds(15,50,450,300);
		scroll.setViewportView(d_pen);
		
		Container kontainer = getContentPane();
		kontainer.setLayout(null);
		
		tahun.setBounds(150,10,55,20);
		bulan.setBounds(210,10,40,20);
		tanggal.setBounds(255,10,40,20);
		lihat.setBounds(310,10,80,20);
		//d_lihat.setBounds(15,50,450,300);
		
		//d_lihat.setEditable(false);
		
		//d_lihat.setText("ID Transaksi \t Tanggal Transaksi \t ID Karyawan \t ID Pelanggan \n");
		
		kontainer.add(tahun);
		kontainer.add(bulan);
		kontainer.add(tanggal);
		kontainer.add(lihat);
		//kontainer.add(d_lihat);
		kontainer.add(scroll);
		
		for(int a = 1990; a <= 2020; a++)
		{
			tahun.addItem(a);
		}
		
		tahun.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					thn = (int) tahun.getSelectedItem();
					
					bulan.removeAllItems();
					bulan.addItem(null);
					
					tanggal.removeAllItems();
					tanggal.addItem(null);
					
					for(int a = 1; a <= 12; a++)
					{
						bulan.addItem(a);
					}
					if(bulan.getSelectedItem() != null)
					{
						main_transaksi mt = new main_transaksi();
						mt.cek_tanggal(thn, bln);
						for(int a = 1; a <= Integer.parseInt(mt.tgl); a++)
						{
							tanggal.addItem(a);
						}
					}

					bulan.setEnabled(true);
				}
				catch(Exception a)
				{
					jop.showConfirmDialog(null, "Error Bung", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
				}
			}
		}
		);
		
		bulan.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					if(bulan.getSelectedItem() != null)
					{
						bln = (int) bulan.getSelectedItem();
						tanggal.removeAllItems();
						tanggal.addItem(null);
						main_transaksi mt = new main_transaksi();
						mt.cek_tanggal(thn, bln);
						for(int a = 1; a <= Integer.parseInt(mt.tgl); a++)
						{
							tanggal.addItem(a);
						}
						switch(bln)
						{
							case 1:
								moon = "Jan";
								break;
							case 2:
								moon = "Feb";
								break;
							case 3:
								moon = "Mar";
								break;
							case 4:
								moon = "Apr";
								break;
							case 5:
								moon = "May";
								break;
							case 6:
								moon = "Jun";
								break;
							case 7:
								moon = "Jul";
								break;
							case 8:
								moon = "Aug";
								break;
							case 9:
								moon = "Sep";
								break;
							case 10:
								moon = "Oct";
								break;
							case 11:
								moon = "Nov";
								break;
							case 12:
								moon = "Dec";
								break;
						}
					}
					
					tanggal.setEnabled(true);
				}
				catch(Exception b)
				{
					jop.showConfirmDialog(null, "Error Mas Bro", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
				}
			}
		}
		);
		
		tanggal.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{					
					if(tanggal.getSelectedItem() != null)
					{
						tgl = (int) tanggal.getSelectedItem();
					}
				}
				catch(Exception c)
				{
					jop.showConfirmDialog(null, "Error Cin", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
				}
			}
		}
		);
		
		lihat.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{					
					main_transaksi mt = new main_transaksi();
					//d_lihat.setText("ID Transaksi \t Tanggal Transaksi \t ID Karyawan \t ID Pelanggan \n");
					
					int baris = dtm.getRowCount();
					for(int a=0; a < baris; a++)
					{
						dtm.removeRow(0);
					}
				
					if(tahun.getSelectedItem() != null)
					{
						if(bulan.getSelectedItem() == null && tanggal.getSelectedItem() == null)
						{
							List <transaksi> hasilAll = mt.lihat_tahun(String.valueOf(thn));
							for(transaksi l:hasilAll)
							{
								Object obj[] = new Object[4];
								obj[0] = l.getId_transaksi();
								obj[1] = l.getTanggal_transaksi();
								obj[2] = l.getId_karyawan();
								obj[3] = l.getId_pelanggan();
								
								dtm.addRow(obj);
								//d_lihat.append(l.getId_transaksi() + "\t " + l.getTanggal_transaksi() + "\t\t " + l.getId_karyawan() + "\t " + l.getId_pelanggan() + "\n");
							}
						}
						else if(bulan.getSelectedItem() != null && tanggal.getSelectedItem() == null)
						{
							List <transaksi> hasilAll = mt.lihat_bulan(String.valueOf(thn), moon);
							for(transaksi l:hasilAll)
							{
								Object obj[] = new Object[4];
								obj[0] = l.getId_transaksi();
								obj[1] = l.getTanggal_transaksi();
								obj[2] = l.getId_karyawan();
								obj[3] = l.getId_pelanggan();
								
								dtm.addRow(obj);
								//d_lihat.append(l.getId_transaksi() + "\t " + l.getTanggal_transaksi() + "\t\t " + l.getId_karyawan() + "\t " + l.getId_pelanggan() + "\n");
							}
						}
						else
						{
							List <transaksi> hasilAll = mt.lihat_tanggal(String.valueOf(thn), moon, String.valueOf(tgl));
							for(transaksi l:hasilAll)
							{
								Object obj[] = new Object[4];
								obj[0] = l.getId_transaksi();
								obj[1] = l.getTanggal_transaksi();
								obj[2] = l.getId_karyawan();
								obj[3] = l.getId_pelanggan();
								
								dtm.addRow(obj);
								//d_lihat.append(l.getId_transaksi() + "\t " + l.getTanggal_transaksi() + "\t\t " + l.getId_karyawan() + "\t " + l.getId_pelanggan() + "\n");
							}
						}
						
						bulan.removeAllItems();
						tanggal.removeAllItems();
						bulan.setEnabled(false);
						tanggal.setEnabled(false);
					}
				}
				catch(Exception c)
				{
					jop.showConfirmDialog(null, "Error Gan", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
				}
			}
		}
		);
	}
	
	public static void main(String [] args)
	{
		menu_laporan_penjualan mlp = new menu_laporan_penjualan("");
		mlp.setVisible(true);
	}
}