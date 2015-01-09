package uas;

import java.sql.*;

public class main_data_transaksi 
{
	private Connection koneksi;	
	
	public main_data_transaksi()
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
	public void insert_dtra(String id_tra, String id_pro, int jumlah, int sub)
	{
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO DATA_TRANSAKSI(ID_TRANSAKSI, ID_PRODUK, JUMLAH, SUB_TOTAL) VALUES ('" + id_tra  + "','" + id_pro + "','" + jumlah + "','" + sub +  "')");
			while(rs.next())
			{
				System.out.println("Data Berhasil dimasukan"); 
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}