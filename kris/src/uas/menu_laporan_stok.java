package uas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class menu_laporan_stok extends JFrame 
{	
	private static final int lebar = 485;
	private static final int tinggi = 290;
	private static final int posisi_x = 150;
	private static final int posisi_y = 250;
	
	// bagian tengah
	//private JTextArea d_lihat = new JTextArea(20,10);
	
	private JLabel stok_produk = new JLabel("Jumlah");
	private JLabel id_produk = new JLabel("ID Produk");
	private JTextField stok_pro = new JTextField();
	private JComboBox id_pro = new JComboBox();
	
	private JTable d_tra;
	private DefaultTableModel dtm;
	private String header[] = {"ID Produk", "Nama Produk", "ID Suplier", "Harga", "Stok"};
	
	private JButton tambah = new JButton ("Tambah");
	
	private JOptionPane jop = new JOptionPane();
	
	public menu_laporan_stok(String judul)
	{
		super(judul);
		setSize(lebar,tinggi);
		setLocation(posisi_x,posisi_y);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		// tabel
		dtm = new DefaultTableModel(null, header);
		d_tra = new JTable(dtm);
		d_tra.setModel(dtm);
		
		d_tra.setEnabled(false);
		
		JScrollPane scroll = new JScrollPane(d_tra);
		scroll.setBounds(10,50,460,200);
		scroll.setViewportView(d_tra);
		
		Container kontainer = getContentPane();
		kontainer.setLayout(null);
		
		//d_lihat.setBounds(10,10,170,300);
		stok_produk.setBounds(10,10,100,20);
		stok_pro.setBounds(60,10,40,20);
		id_produk.setBounds(120,10,100,20);
		id_pro.setBounds(180,10,80,20);
		tambah.setBounds(280,10,80,20);
		
		//d_lihat.setText("ID Produk \t Stok Tersisa \n");
		
		//d_lihat.setEditable(false);
		
		//kontainer.add(d_lihat);
		kontainer.add(scroll);
		kontainer.add(stok_produk);
		kontainer.add(stok_pro);
		kontainer.add(id_produk);
		kontainer.add(id_pro);
		kontainer.add(tambah);
		
		id_pro.addItem("");
		main_produk mp = new main_produk();
		List <produk> hasilAll = mp.lihat_produk();
		for(produk p:hasilAll)
		{
			id_pro.addItem(p.getId_produk());
			//d_lihat.append(p.getId_produk() + "\t " + p.getStok() + "\n");
			Object obj[] = new Object[5];
			obj[0] = p.getId_produk();
			obj[1] = p.getNama_produk();
			obj[2] = p.getId_suplier();
			obj[3] = p.getHarga();
			obj[4] = p.getStok();
			
			dtm.addRow(obj);
		}
		
		tambah.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					main_produk mp = new main_produk();
					produk p = mp.cari_stok(id_pro.getSelectedItem().toString());
					
					mp.update_stok(id_pro.getSelectedItem().toString(), Integer.parseInt(stok_pro.getText()) + p.getStok());
					
					//d_lihat.setText("ID Produk \t Stok Tersisa \n");
					
					stok_pro.setText("");
					id_pro.removeAllItems();
					
					id_pro.addItem("");
					
					int baris = dtm.getRowCount();
					for(int a=0; a < baris; a++)
					{
						dtm.removeRow(0);
					}
					
					List <produk> hasilAll = mp.lihat_produk();
					for(produk pr:hasilAll)
					{
						id_pro.addItem(pr.getId_produk());
						//d_lihat.append(pr.getId_produk() + "\t " + pr.getStok() + "\n");
						Object obj[] = new Object[5];
						obj[0] = pr.getId_produk();
						obj[1] = pr.getNama_produk();
						obj[2] = pr.getId_suplier();
						obj[3] = pr.getHarga();
						obj[4] = pr.getStok();
						
						dtm.addRow(obj);
					}
					jop.showConfirmDialog(null, "Stok Telah Berhasil Ditambah", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
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
		menu_laporan_stok mlp = new menu_laporan_stok("");
		mlp.setVisible(true);
	}
}