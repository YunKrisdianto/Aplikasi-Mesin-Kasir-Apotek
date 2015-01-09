package uas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class main_transaksi 
{
	public String kabisat;
	public String tgl;
	private Connection koneksi;	
	
	public main_transaksi()
	{
		try
		{
			Class.forName(config.database_driver).newInstance();
			koneksi = DriverManager.getConnection(config.url,config.username,config.password);
		}
		catch (Exception e)
		{
		}
	}
	public transaksi gen_id()
	{
		transaksi gen = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*)+1 FROM TRANSAKSI");
			while(rs.next())
			{
				String id = rs.getString(1); 
				gen = new transaksi(id);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return gen;
	}
	public void insert_transaksi(String id_tra, String tgl, String id_kar, String id_pel)
	{
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO TRANSAKSI(ID_TRANSAKSI, TANGGAL_TRANSAKSI, ID_KARYAWAN, ID_PELANGGAN) VALUES ('" + id_tra  + "','" + tgl + "','" + id_kar + "','" + id_pel + "')");
			while(rs.next())
			{
				System.out.println("Data Berhasil dimasukan"); 
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	// laporan
	public void cek_tanggal(int tahun, int bulan)
	{
		if(tahun % 4 == 0)
		{
			kabisat = "yes";
		}
		else
		{
			kabisat ="no";
		}
					
		if(bulan == 2)
		{
			if(kabisat == "yes")
			{
				tgl = "29";
			}
			else
			{
				tgl = "28";
			}
		}
		else if(bulan == 1 || bulan == 3 || bulan == 5 || bulan == 7 || bulan == 8 || bulan == 10 || bulan == 12)
		{
			tgl= "31";
		}
		else
		{
			tgl = "30";
		}
	}
	public List <transaksi> lihat_tahun(String tahun)
	{
		List <transaksi> daftarpenjualan = new ArrayList<transaksi>();
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM TRANSAKSI WHERE SUBSTRING(TANGGAL_TRANSAKSI,25,4) = '" + tahun + "'");
			while(rs.next())
			{
				daftarpenjualan.add(new transaksi(rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4)));
			}
		}catch(SQLException e)
		{
			System.out.println("Data Tidak Ada");
		}
		return daftarpenjualan;
	}
	public List <transaksi> lihat_bulan(String tahun, String bulan)
	{
		List <transaksi> daftarpenjualan = new ArrayList<transaksi>();
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM TRANSAKSI WHERE SUBSTRING(TANGGAL_TRANSAKSI,25,4) = '" + tahun + "' AND SUBSTRING(TANGGAL_TRANSAKSI,5,3) = '" + bulan + "'");
			while(rs.next())
			{
				daftarpenjualan.add(new transaksi(rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4)));
			}
		}catch(SQLException e)
		{
			System.out.println("Data Tidak Ada");
		}
		return daftarpenjualan;
	}
	public List <transaksi> lihat_tanggal(String tahun, String bulan, String tanggal)
	{
		List <transaksi> daftarpenjualan = new ArrayList<transaksi>();
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM TRANSAKSI WHERE SUBSTRING(TANGGAL_TRANSAKSI,25,4) = '" + tahun + "' AND SUBSTRING(TANGGAL_TRANSAKSI,5,3) = '" + bulan + "' AND SUBSTRING(TANGGAL_TRANSAKSI,9,2) = '" + tanggal + "'");
			while(rs.next())
			{
				daftarpenjualan.add(new transaksi(rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4)));
			}
		}catch(SQLException e)
		{
			System.out.println("Data Tidak Ada");
		}
		return daftarpenjualan;
	}
}
