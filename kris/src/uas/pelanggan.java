package uas;

public class pelanggan 
{
	private String id_pelanggan;
	private String nama_pelanggan;
	private String alamat_pelanggan;
	
	public pelanggan(String id_pelanggan, String nama_pelanggan, String alamat_pelanggan) 
	{
		super();
		this.id_pelanggan = id_pelanggan;
		this.nama_pelanggan = nama_pelanggan;
		this.alamat_pelanggan = alamat_pelanggan;
	}

	@Override
	public String toString() 
	{
		return id_pelanggan + "" + nama_pelanggan + "" + alamat_pelanggan;
	}

	public String getId_pelanggan() 
	{
		return id_pelanggan;
	}

	public void setId_pelanggan(String id_pelanggan) 
	{
		this.id_pelanggan = id_pelanggan;
	}

	public String getNama_pelanggan() 
	{
		return nama_pelanggan;
	}

	public void setNama_pelanggan(String nama_pelanggan) 
	{
		this.nama_pelanggan = nama_pelanggan;
	}

	public String getAlamat_pelanggan() 
	{
		return alamat_pelanggan;
	}

	public void setAlamat_pelanggan(String alamat_pelanggan) 
	{
		this.alamat_pelanggan = alamat_pelanggan;
	}
}
