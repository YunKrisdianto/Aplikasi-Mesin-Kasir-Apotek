package uas;

public class produk 
{	
	private String id_produk;
	private String nama_produk;
	private String id_suplier;
	private int harga;
	private int stok;

	public produk(String id_produk, String nama_produk, String id_suplier, int harga, int stok) 
	{
		this.id_produk = id_produk;
		this.nama_produk = nama_produk;
		this.id_suplier = id_suplier;
		this.harga = harga;
		this.stok = stok;
	}
	public int getStok() {
		return stok;
	}
	public void setStok(int stok) {
		this.stok = stok;
	}
	public String getId_produk() 
	{
		return id_produk;
	}
	public void setId_produk(String id_produk) 
	{
		this.id_produk = id_produk;
	}
	public String getNama_produk() 
	{
		return nama_produk;
	}
	public void setNama_produk(String nama_produk) 
	{
		this.nama_produk = nama_produk;
	}
	public String getId_suplier() 
	{
		return id_suplier;
	}
	@Override
	public String toString() 
	{
		return id_produk + "\t"	+ nama_produk + "\t" + id_suplier + "\t" + harga + "\t" + stok;
	}
	public void setId_suplier(String id_suplier) 
	{
		this.id_suplier = id_suplier;
	}
	public int getHarga() 
	{
		return harga;
	}
	public void setHarga(int harga) 
	{
		this.harga = harga;
	}
}