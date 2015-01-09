package uas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class main_produk 
{
	private Connection koneksi;	
	
	public main_produk()
	{
		try
		{
			Class.forName(config.database_driver).newInstance();
			koneksi = DriverManager.getConnection(config.url,config.username,config.password);
		}
		catch (Exception e)
		{
			System.out.println("Koneksi Gagal");
		}
	}
	public produk cariById(String id_produk)
	{
		produk cari_id = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUK WHERE ID_PRODUK = '" + id_produk +"'");
			while(rs.next())
			{
				String nama_produk = rs.getString(2);
				String id_suplier = rs.getString(3);
				int harga = rs.getInt(4);
				int stok = rs.getInt(5);
				cari_id = new produk(id_produk, nama_produk, id_suplier, harga,stok);	
			}
		}catch(SQLException e)
		{
			System.out.println("Data Tidak Ada");
		}
		return cari_id;
	}
	public produk cari_by_nama(String nama_produk)
	{
		produk cari_nama = new produk("","","",0,0);
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUK WHERE NAMA_PRODUK = '" + nama_produk +"'");
			while(rs.next())
			{
				String id_produk = rs.getString(1);
				String id_suplier = rs.getString(3);
				int harga = rs.getInt(4);
				int stok = rs.getInt(5);
				cari_nama = new produk(id_produk, nama_produk, id_suplier, harga,stok);	
			}
		}catch(SQLException e)
		{
			System.out.println("Data Tidak Ada");
		}
		return cari_nama;
	}
	public List<produk> viewAll()
	{
		List<produk> daftarproduk = new ArrayList<produk>();
		try
		{
			//rs = selectAll.executeQuery();
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUK");
			while(rs.next())
			{
				daftarproduk.add(new produk(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
			}
		}catch(SQLException e)
		{
			System.out.println("Data Tidak Ada");
		}
		return daftarproduk;
	}
	public List<produk> viewAll(String filter)
	{
		List<produk> daftarproduk = new ArrayList<produk>();
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUK");
			while(rs.next())
			{
				daftarproduk.add(new produk(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
			}
		}catch(SQLException e)
		{
			System.out.println("Data Tidak Ada");
		}
		return daftarproduk;
	}
	public void insert_pro(String id_pro, String nama, String id_sup, int harga, int stok)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO PRODUK(ID_PRODUK, NAMA_PRODUK, ID_SUPLIER, HARGA, STOK) VALUES ('" + id_pro + "','" + nama + "','" + id_sup + "','" + harga + "','" + stok + "')");
			while(rs.next())
			{
				System.out.println("Data Berhasil Dimasukan");
			}
		}
		catch(SQLException e)
		{
			System.out.println("Data Tidak Valid");
		}
	}
	public void update_pro(String id_pro, String nama, String id_sup, String harga, String stok)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("UPDATE PRODUK SET ID_PRODUK = '" + id_pro +"', NAMA_PRODUK = '" + nama + "', ID_SUPLIER = '" + id_sup + "', HARGA = '" + harga + "', STOK = '" + stok + "' WHERE ID_PRODUK = '" + id_pro + "'");
			while(rs.next())
			{
				System.out.println("Data Berhasil Diubah");
			}
		}
		catch(SQLException e)
		{
			System.out.println("Data Tidak Valid");
		}
	}
	public void delete_pro(String id_pro)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("DELETE FROM PRODUK WHERE ID_PRODUK = '" + id_pro + "'");
			while(rs.next())
			{
				System.out.println("Data Berhasil Dihapus");
			}
		}
		catch(SQLException e)
		{
			System.out.println("Data Tidak Valid");
		}
	}
	public produk cari_stok(String id_pro)
	{
		produk stk = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUK WHERE ID_PRODUK = '" + id_pro + "'");
			while(rs.next())
			{
				String nama = rs.getString(2);
				String id_sup = rs.getString(3);
				int jumlah = rs.getInt(5); 
				int stok = rs.getInt(5); 
				stk = new produk(id_pro, nama, id_sup, jumlah, stok);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return stk;
	}
	public void update_stok(String id_pro, int stok)
	{
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("UPDATE PRODUK SET STOK = '" + stok + "' WHERE ID_PRODUK = '" + id_pro + "'");
			while(rs.next())
			{
				System.out.println("Data Berhasil dimasukan"); 
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public List <produk> lihat_produk()
	{
		List <produk> daftarpenjualan = new ArrayList<produk>();
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUK WHERE STOK < 50");
			while(rs.next())
			{
				daftarpenjualan.add(new produk(rs.getString(1),rs.getString(2), rs.getString(3),rs.getInt(4), rs.getInt(5)));
			}
		}catch(SQLException e)
		{
			System.out.println("Data Tidak Ada");
		}
		return daftarpenjualan;
	}
}