package uas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class menu_transaksi extends JFrame
{
	public static int dibayar;
	private int x = 0;
	private int kembalian;
	
	public static Vector idp = new Vector();
	public static Vector nmp = new Vector();
	public static Vector hrg = new Vector();
	public static Vector jml = new Vector();
	public static Vector sbt = new Vector();
	private int total = 0;
	
	private static final int lebar = 730;
	private static final int tinggi = 700;
	private static final int posisi_x = 250;
	private static final int posisi_y = 50;

	// bagian atas
	private JLabel id_transaksi = new JLabel("ID Transaksi");
	private JLabel tgl_transaksi = new JLabel("Tanggal Transaksi");
	private JLabel id_karyawan = new JLabel("ID Karyawan");
	private JLabel id_pelanggan = new JLabel("ID Pelanggan");
	private JTextField id_tra = new JTextField();
	private JTextField tgl_tra = new JTextField();
	private JTextField id_kar = new JTextField();
	private JTextField id_pel = new JTextField();
	
	// bagian tengah
	private JLabel id_produk = new JLabel("ID Produk");
	private JLabel nama_produk = new JLabel("Nama");
	private JLabel harga_produk = new JLabel("Harga");
	private JLabel jumlah_produk = new JLabel("Jumlah");
	private JTextField id_pro = new JTextField(10);
	private JTextField nama_pro = new JTextField(10);
	private JTextField harga_pro = new JTextField(10);
	private JTextField jumlah_pro = new JTextField(10);
	
	// bagian kiri
	private JLabel total_penjualan = new JLabel("Total");
	private JTextField total_pen = new JTextField();
	private JLabel total_uang = new JLabel("Uang Anda");
	private JTextField total_uan = new JTextField();
	private JLabel total_kembali = new JLabel("Kembalian");
	private JTextField total_kem = new JTextField();
	private JButton buy = new JButton("Buy");
	private JButton cek = new JButton("Cek");
	private JButton cancel = new JButton("Cancel");
	//private JTextArea d_tra = new JTextArea();
	
	private JTable d_tra;
	private DefaultTableModel dtm;
	private String header[] = {"ID Produk", "Nama Produk", "Jumlah", "Harga", "Sub Total"};
	
	//button
	private JButton cari = new JButton("Cari");
	private JButton ok = new JButton("Ok");
	
	private JOptionPane jop = new JOptionPane();
	
	public menu_transaksi(String judul)
	{
		super(judul);
		setSize(lebar,tinggi);
		setLocation(posisi_x,posisi_y);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		Container kontainer = getContentPane();
		kontainer.setLayout(null);
		
		// tabel
		dtm = new DefaultTableModel(null, header);
		d_tra = new JTable(dtm);
		d_tra.setModel(dtm);

		JScrollPane scroll = new JScrollPane(d_tra);
		scroll.setBounds(10,170,700,400);
		scroll.setViewportView(d_tra);
		
		// enable
		id_tra.setEditable(false);
		tgl_tra.setEditable(false);
		id_kar.setEditable(false);
		nama_pro.setEditable(false);
		harga_pro.setEditable(false);
		total_pen.setEditable(false);
		total_kem.setEditable(false);
		
		d_tra.setEnabled(false);
		//d_tra.setEditable(false);
		
		
		id_transaksi.setBounds(10,10,100,20);
		id_tra.setBounds(130,10,100,20);
		tgl_transaksi.setBounds(10,35,120,20);
		tgl_tra.setBounds(130,35,100,20);
		id_karyawan.setBounds(250, 10, 100, 20);
		id_kar.setBounds(350, 10, 100, 20);
		id_pelanggan.setBounds(250, 35, 100, 20);
		id_pel.setBounds(350, 35, 100, 20);
		id_produk.setBounds(10, 60, 100, 20);
		id_pro.setBounds(70, 60, 100, 20);
		cari.setBounds(180,60,80,20);
		nama_produk.setBounds(10, 85, 100, 20);
		nama_pro.setBounds(70, 85, 190, 20);
		harga_produk.setBounds(10,110,100,20);
		harga_pro.setBounds(70,110,100,20);
		jumlah_produk.setBounds(10,135,100,20);
		jumlah_pro.setBounds(70,135,100,20);
		ok.setBounds(180,135,80,20);
		total_penjualan.setBounds(470,10,100,20);
		total_pen.setBounds(540,10,100,20);
		total_uang.setBounds(470,35,100,20);
		total_uan.setBounds(540,35,100,20);
		total_kembali.setBounds(470,60,100,20);
		total_kem.setBounds(540,60,100,20);
		cek.setBounds(650,60, 60,20);
		//d_tra.setBounds(10,170,700,400);
		buy.setBounds(230,590,80,20);
		cancel.setBounds(320,590,80,20);
		
		//d_tra.setText("ID Produk \t Nama Produk \t\t\t\t Harga \t Jumlah \t Sub Total \n");
		
		kontainer.add(id_transaksi);
		kontainer.add(id_tra);
		kontainer.add(tgl_transaksi);
		kontainer.add(tgl_tra);
		kontainer.add(id_karyawan);
		kontainer.add(id_kar);
		kontainer.add(id_pelanggan);
		kontainer.add(id_pel);
		kontainer.add(id_produk);
		kontainer.add(id_pro);
		kontainer.add(cari);
		kontainer.add(nama_produk);
		kontainer.add(nama_pro);
		kontainer.add(harga_produk);
		kontainer.add(harga_pro);
		kontainer.add(jumlah_produk);
		kontainer.add(jumlah_pro);
		kontainer.add(ok);
		kontainer.add(total_penjualan);
		kontainer.add(total_pen);
		kontainer.add(total_uang);
		kontainer.add(total_uan);
		kontainer.add(total_kembali);
		kontainer.add(total_kem);
		kontainer.add(cek);
		//kontainer.add(d_tra);
		kontainer.add(scroll);
		kontainer.add(buy);
		kontainer.add(cancel);
		
		main_transaksi mt = new main_transaksi();
		transaksi tra = mt.gen_id();
		id_tra.setText("TRA-" + tra.getId_transaksi());
		
		tgl tgl = new tgl();
		tgl_tra.setText(tgl.getTanggal());
		
		menu_login ml = new menu_login("");
		main_karyawan mk = new main_karyawan();
		karyawan k = mk.cari_pass(ml.s_user);
		id_kar.setText(k.getId_karyawan());
		
		cari.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					nama_pro.setText("");
					harga_pro.setText("");
					jumlah_pro.setText("");
					
					main_produk mp = new main_produk();
					produk p = mp.cariById(id_pro.getText());
					
					nama_pro.setText(p.getNama_produk());
					harga_pro.setText(String.valueOf(p.getHarga()));
				}
				catch(Exception a)
				{
					jop.showConfirmDialog(null, "Data Produk Tidak Ditemukan", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
				}
			}
		}
		);
		
		ok.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					int sub = Integer.parseInt(jumlah_pro.getText()) * Integer.parseInt(harga_pro.getText());
					data_transaksi dt = new data_transaksi(id_tra.getText(),id_pro.getText(),Integer.parseInt(jumlah_pro.getText()),sub);
					
					idp.add(dt.getId_produk());
					nmp.add(nama_pro.getText());
					hrg.add(harga_pro.getText());
					jml.add(jumlah_pro.getText());
					sbt.add(sub);
					
					//d_tra.append(idp.elementAt(x).toString() + "\t" + nmp.elementAt(x).toString() + "\t" + hrg.elementAt(x).toString() + "\t" + jml.elementAt(x).toString() + "\t" + sbt.elementAt(x).toString() + "\n");
					
					// input table
					Object obj[] = new Object[5];
					obj[0] = idp.elementAt(x);
					obj[1] = nmp.elementAt(x);
					obj[2] = jml.elementAt(x);
					obj[3] = hrg.elementAt(x);
					obj[4] = sbt.elementAt(x);
					
					dtm.addRow(obj);
					
					x++;
					
					for(int a = 0; a < x; a++)
					{
						total = total + Integer.parseInt((sbt.elementAt(a).toString()));
						
					}
					id_pro.setText("");
					nama_pro.setText("");
					harga_pro.setText("");
					jumlah_pro.setText("");
					
					total_pen.setText(String.valueOf(total));
					
					dibayar = total;
					
					total = 0;
				}
				catch(Exception a)
				{
					jop.showConfirmDialog(null, "Data Tidak Valid", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
				}
			}
		}
		);	
		
		cek.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					kembalian = Integer.parseInt(total_uan.getText()) - Integer.parseInt(total_pen.getText());
					total_kem.setText(String.valueOf(kembalian));
				}
				catch(Exception a)
				{
					jop.showConfirmDialog(null, "Data Tidak Valid", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
				}
			}
		}
		);
		
		cancel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				id_pro.setText("");
				nama_pro.setText("");
				harga_pro.setText("");
				jumlah_pro.setText("");
				id_pel.setText("");
				
				idp = new Vector();
				nmp = new Vector();
				hrg = new Vector();
				jml = new Vector();
				sbt = new Vector();
				
				id_pel.setText("");
				
				main_transaksi mt = new main_transaksi();
				transaksi tra = mt.gen_id();
				id_tra.setText("TRA-" + tra.getId_transaksi());
				x = 0;
				
				//d_tra.setText("ID Produk \t Nama Produk \t\t\t\t Harga \t Jumlah \t Sub Total \n");
				
				int baris = dtm.getRowCount();
				for(int a=0; a < baris; a++)
				{
					dtm.removeRow(0);
				}
				
				total_uan.setText("");
				total_kem.setText("");
				total_pen.setText("");
				
				kembalian = 0;
				dibayar = 0;
			}
		}
		);
		
		buy.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					if(Integer.parseInt(total_kem.getText()) >= 0)
					{
						main_transaksi mt = new main_transaksi();
						mt.insert_transaksi(id_tra.getText(), tgl_tra.getText(),id_kar.getText(),id_pel.getText());
						
						for(int a = 0; a < idp.size(); a++)
						{
							main_data_transaksi mdt = new main_data_transaksi();
							mdt.insert_dtra(id_tra.getText(),idp.elementAt(a).toString(),Integer.parseInt(jml.elementAt(a).toString()),Integer.parseInt(sbt.elementAt(a).toString()));
							
							main_produk mp = new main_produk();
							produk p = mp.cari_stok(idp.elementAt(a).toString());
							
							int stk = p.getStok();
							int stok = stk - Integer.parseInt(jml.elementAt(a).toString());
							mp.update_stok(idp.elementAt(a).toString(), stok);
						}
						
						idp = new Vector();
						nmp = new Vector();
						hrg = new Vector();
						jml = new Vector();
						sbt = new Vector();
						
						transaksi tra = mt.gen_id();
						id_tra.setText("TRA-" + tra.getId_transaksi());
						x = 0;
						
						//d_tra.setText("ID Produk \t Nama Produk \t\t\t\t Harga \t Jumlah \t Sub Total \n");
						
						id_pel.setText("");
						
						int baris = dtm.getRowCount();
						for(int a=0; a < baris; a++)
						{
							dtm.removeRow(0);
						}
						
						total_pen.setText("");
						total_uan.setText("");
						total_kem.setText("");
						kembalian = 0;
						dibayar = 0;
						
						jop.showConfirmDialog(null, "Semoga Anda Lekas Sembuh Ibu / Bapak", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
					}
				}
				catch(Exception a)
				{
					jop.showConfirmDialog(null, "Data Tidak Valid", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
				}
			}
		}
		);
	}
	public static void main(String [] args)
	{
		menu_transaksi mt = new menu_transaksi("");
		mt.setVisible(true);
	}
}