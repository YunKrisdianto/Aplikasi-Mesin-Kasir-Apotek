package uas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main_pelanggan 
{
	private Connection koneksi;	
	
	public main_pelanggan()
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
	
	public pelanggan cari_id(String id)
	{
		pelanggan cari_pel = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PELANGGAN WHERE ID_PELANGGAN = '" + id + "'");
			while(rs.next())
			{
				String nama = rs.getString(2);
				String alamat = rs.getString(3);
				cari_pel = new pelanggan(id, nama, alamat);	
			}
		}
		catch(SQLException e)
		{
			System.out.println("ID Karyawan tidak ada");
		}
		return cari_pel;
	}
	public void insert_pel(String id_pel, String nama, String alamat)
	{
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO PELANGGAN (ID_PELANGGAN, NAMA_PELANGGAN, ALAMAT) VALUES ('" + id_pel + "','" + nama + "','" + alamat + "')");
			while (rs.next())
			{
				System.out.println("Data Berhasil Dimasukan");
			}
		}
		catch(SQLException e)
		{
			System.out.println("Data Tidak Valid");
		}
	}
	public void update_pel(String id_pel, String nama, String alamat)
	{
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("UPDATE PELANGGAN SET ID_PELANGGAN = '" + id_pel + "',NAMA_PELANGGAN = '" + nama + "',ALAMAT = '" + alamat + "' WHERE ID_PELANGGAN = '" + id_pel + "'");
			System.out.println("ya");
			while (rs.next())
			{
				System.out.println("Data Berhasil Diubah");
			}
		}
		catch(SQLException e)
		{
			System.out.println("Data Tidak Valid");
		}
	}
	
	public void delete_pel(String id_pel)
	{
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("DELETE FROM PELANGGAN WHERE ID_PELANGGAN = '" + id_pel + "'");
			while (rs.next())
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
