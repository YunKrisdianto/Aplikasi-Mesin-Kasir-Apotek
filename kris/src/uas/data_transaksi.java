package uas;

public class data_transaksi 
{
	private String id_transaksi;
	private String id_produk;
	private int jumlah;
	private int sub_total;
	
	public data_transaksi(String id_transaksi, String id_produk, int jumlah,int sub_total) 
	{
		this.id_transaksi = id_transaksi;
		this.id_produk = id_produk;
		this.jumlah = jumlah;
		this.sub_total = sub_total;
	}
	
	@Override
	public String toString() 
	{
		return id_transaksi + id_produk + jumlah + sub_total;
	}

	public String getId_transaksi() 
	{
		return id_transaksi;
	}
	public void setId_transaksi(String id_transaksi) 
	{
		this.id_transaksi = id_transaksi;
	}
	public String getId_produk() 
	{
		return id_produk;
	}
	public void setId_produk(String id_produk) 
	{
		this.id_produk = id_produk;
	}
	public int getJumlah() 
	{
		return jumlah;
	}
	public void setJumlah(int jumlah) 
	{
		this.jumlah = jumlah;
	}
	public int getSub_total() 
	{
		return sub_total;
	}
	public void setSub_total(int sub_total) 
	{
		this.sub_total = sub_total;
	}
}