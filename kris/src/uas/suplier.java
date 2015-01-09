package uas;

public class suplier 
{
	private String id_suplier;
	private String nama_suplier;
	
	public suplier(String id_suplier, String nama_suplier) 
	{
		this.id_suplier = id_suplier;
		this.nama_suplier = nama_suplier;
	}
		
	@Override
	public String toString() 
	{
		return id_suplier + nama_suplier;
	}

	public String getId_suplier() 
	{
		return id_suplier;
	}
	public void setId_suplier(String id_suplier) 
	{
		this.id_suplier = id_suplier;
	}
	public String getNama_suplier() 
	{
		return nama_suplier;
	}
	public void setNama_suplier(String nama_suplier) 
	{
		this.nama_suplier = nama_suplier;
	}
}