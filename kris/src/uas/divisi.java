package uas;

public class divisi 
{
	private String id_divisi;
	private String nama_divisi;
	
	public divisi(String id_divisi, String nama_divisi) 
	{
		super();
		this.id_divisi = id_divisi;
		this.nama_divisi = nama_divisi;
	}

	@Override
	public String toString() 
	{
		return id_divisi + "" + nama_divisi;
	}

	public String getId_divisi() 
	{
		return id_divisi;
	}

	public void setId_divisi(String id_divisi) 
	{
		this.id_divisi = id_divisi;
	}

	public String getNama_divisi() 
	{
		return nama_divisi;
	}

	public void setNama_divisi(String nama_divisi) 
	{
		this.nama_divisi = nama_divisi;
	}
}
