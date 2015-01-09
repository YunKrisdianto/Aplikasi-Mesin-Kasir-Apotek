package uas;

import java.util.*;

public class transaksi 
{
	private String id_transaksi;
	private Date tanggal_transaksi;
	private String id_karyawan;
	private String id_pelanggan;
	
	
	public transaksi(String id_transaksi) 
	{
		this.id_transaksi = id_transaksi;
	}	
	
	public transaksi(String id_transaksi, Date tanggal_transaksi,	String id_karyawan, String id_pelanggan) 
	{
		super();
		this.id_transaksi = id_transaksi;
		this.tanggal_transaksi = tanggal_transaksi;
		this.id_karyawan = id_karyawan;
		this.id_pelanggan = id_pelanggan;
	}

	public String getId_transaksi() 
	{
		return id_transaksi;
	}

	public void setId_transaksi(String id_transaksi) 
	{
		this.id_transaksi = id_transaksi;
	}

	public Date getTanggal_transaksi() 
	{
		return tanggal_transaksi;
	}

	public void setTanggal_transaksi(Date tanggal_transaksi) 
	{
		this.tanggal_transaksi = tanggal_transaksi;
	}

	public String getId_karyawan() 
	{
		return id_karyawan;
	}

	public void setId_karyawan(String id_karyawan) 
	{
		this.id_karyawan = id_karyawan;
	}

	public String getId_pelanggan() 
	{
		return id_pelanggan;
	}

	public void setId_pelanggan(String id_pelanggan) 
	{
		this.id_pelanggan = id_pelanggan;
	}
}