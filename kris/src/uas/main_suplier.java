package uas;

import java.sql.*;

public class main_suplier 
{
	private Connection koneksi;	
	
	public main_suplier()
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
	public suplier cari_sup(String id_sup)
	{
		suplier sup = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM SUPLIER WHERE ID_SUPLIER = '" + id_sup + "'");
			while(rs.next())
			{
				String nama = rs.getString(2); 
				sup = new suplier(id_sup,nama);
			}
		}catch(SQLException e)
		{
			System.out.println("Data Tidak Ada");
		}
		return sup;
	}
	public void insert_sup(String id_sup, String nama)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO SUPLIER(ID_SUPLIER, NAMA_SUPLIER) VALUES ('" + id_sup + "','" + nama + "')");
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
	public void update_sup(String id_sup, String nama)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("UPDATE SUPLIER SET ID_SUPLIER = '" + id_sup + "', NAMA_SUPLIER = '" + nama + "' WHERE ID_SUPLIER = '" + id_sup + "'");
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
	public void delete_sup(String id_sup)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("DELETE FROM SUPLIER WHERE ID_SUPLIER = '" + id_sup + "'");
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
}