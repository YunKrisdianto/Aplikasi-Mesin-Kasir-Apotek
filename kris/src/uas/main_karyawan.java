package uas;

import java.sql.*;
import java.util.Date;


public class main_karyawan 
{
	private Connection koneksi;	
	
	public main_karyawan()
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
	
	public karyawan cari_pass(String nama)
	{
		karyawan cari_user = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM KARYAWAN WHERE NAMA_KARYAWAN = '" + nama + "'");
			while(rs.next())
			{
				String id = rs.getString(1);
				String alamat = rs.getString(3);
				Date tgl = rs.getDate(4);
				String pass = rs.getString(5);
				String divisi = rs.getString(6);
				cari_user = new karyawan(id, nama, alamat, tgl, pass, divisi);	
			}
		}
		catch(SQLException e)
		{
			System.out.println("Username tidak ada");
		}
		return cari_user;
	}
	public karyawan cari_id(String id)
	{
		karyawan cari_kar = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM KARYAWAN WHERE ID_KARYAWAN = '" + id + "'");
			while(rs.next())
			{
				String nama = rs.getString(2);
				String alamat = rs.getString(3);
				Date tgl = rs.getDate(4);
				String pass = rs.getString(5);
				String divisi = rs.getString(6);
				cari_kar = new karyawan(id, nama, alamat, tgl, pass, divisi);	
			}
		}
		catch(SQLException e)
		{
			System.out.println("ID Karyawan tidak ada");
		}
		return cari_kar;
	}
	public void insert_kar(String id_kar, String nama, String alamat, String tgl, String id_div)
	{
		try 
		{
			String pass = id_kar;
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO KARYAWAN (ID_KARYAWAN, NAMA_KARYAWAN, ALAMAT, TANGGAL_LAHIR, PASSWORD, ID_DIVISI) VALUES ('" + id_kar + "','" + nama + "','" + alamat + "','" + tgl + "','" + pass + "','" + id_div + "')");
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
	public void update_kar(String id_kar, String nama, String alamat, String tgl, String id_div)
	{
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("UPDATE KARYAWAN SET ID_KARYAWAN = '" + id_kar + "',NAMA_KARYAWAN = '" + nama + "',ALAMAT = '" + alamat + "',TANGGAL_LAHIR = '" + tgl + "',ID_DIVISI = '" + id_div +"' WHERE ID_KARYAWAN = '" + id_kar + "'");
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
	
	public void delete_kar(String id_kar)
	{
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("DELETE FROM KARYAWAN WHERE ID_KARYAWAN = '" + id_kar + "'");
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
	public karyawan search_pass(String pass,String nama)
	{
		karyawan cari_password = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			//ResultSet rs = stmt.executeQuery("SELECT * FROM KARYAWAN WHERE PASSWORD = '" + pass + "' AND NAMA_KARYAWAN = '" + nama +"'");
			ResultSet rs = stmt.executeQuery("SELECT * FROM KARYAWAN WHERE PASSWORD = '" + pass + "' AND NAMA_KARYAWAN = '" + nama + "'");
			while(rs.next())
			{
				String id = rs.getString(1);
				//String nama = rs.getString(2);
				String alamat = rs.getString(3);
				Date tgl = rs.getDate(4);
				String divisi = rs.getString(6);
				cari_password = new karyawan(id, nama, alamat, tgl, pass, divisi);	
			}
		}
		catch(SQLException e)
		{
			System.out.println("Password tidak ada");
		}
		return cari_password;
	}
	public void update_pass(String pass, String id)
	{
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("UPDATE KARYAWAN SET PASSWORD = '" + pass + "' WHERE ID_KARYAWAN = '" + id + "'");
			while (rs.next())
			{
				System.out.println("Password Berhasil Diubah");
			}
		}
		catch(SQLException e)
		{
			System.out.println("Data Tidak Valid");
		}
	}
}