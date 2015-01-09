package uas;

import java.sql.*;

public class main_divisi 
{
	private Connection koneksi;	
	
	public main_divisi()
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
	public divisi cari_divisi(String id_div)
	{
		divisi div = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM DIVISI WHERE ID_DIVISI = '" + id_div + "'");
			while(rs.next())
			{
				String nama = rs.getString(2); 
				div = new divisi(id_div,nama);
			}
		}catch(SQLException e)
		{
			System.out.println("Data Tidak Ada");
		}
		return div;
	}
	public void insert_div(String id_div, String nama)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO DIVISI(ID_DIVISI, NAMA_DIVISI) VALUES ('" + id_div + "','" + nama + "')");
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
	public void update_div(String id_div, String nama)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("UPDATE DIVISI SET ID_DIVISI = '" + id_div + "', NAMA_DIVISI = '" + nama + "' WHERE ID_DIVISI = '" + id_div + "'");
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
	public void delete_div(String id_div)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("DELETE FROM DIVISI WHERE ID_DIVISI = '" + id_div + "'");
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