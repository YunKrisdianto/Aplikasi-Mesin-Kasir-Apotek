package uas;

import java.util.Date;

public class karyawan 
{
	private String id_karyawan;
	private String nama_karyawan;
	private String alamat_karyawan;
	private Date tanggal_lahir;
	private String password;
	private String id_divisi;

	public karyawan(String id_karyawan, String nama_karyawan, String alamat_karyawan, Date tanggal_lahir, String password, String id_divisi) 
	{
		this.id_karyawan = id_karyawan;
		this.nama_karyawan = nama_karyawan;
		this.alamat_karyawan = alamat_karyawan;
		this.tanggal_lahir = tanggal_lahir;
		this.password = password;
		this.id_divisi = id_divisi;
	}
	
	@Override
	public String toString() 
	{
		return id_karyawan + nama_karyawan + alamat_karyawan + tanggal_lahir + password + id_divisi;
	}
	
	public String getId_karyawan() 
	{
		return id_karyawan;
	}
	public void setId_karyawan(String id_karyawan) 
	{
		this.id_karyawan = id_karyawan;
	}
	public String getNama_karyawan() 
	{
		return nama_karyawan;
	}
	public void setNama_karyawan(String nama_karyawan) 
	{
		this.nama_karyawan = nama_karyawan;
	}
	public String getAlamat_karyawan() 
	{
		return alamat_karyawan;
	}
	public void setAlamat_karyawan(String alamat_karyawan) 
	{
		this.alamat_karyawan = alamat_karyawan;
	}
	public Date getTanggal_lahir() 
	{
		return tanggal_lahir;
	}
	public void setTanggal_lahir(Date tanggal_lahir) 
	{
		this.tanggal_lahir = tanggal_lahir;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getId_divisi() 
	{
		return id_divisi;
	}
	public void setId_divisi(String id_divisi) 
	{
		this.id_divisi = id_divisi;
	}
}
