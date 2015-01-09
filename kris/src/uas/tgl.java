package uas;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class tgl
{
	private String tanggal;
	
	
	public tgl() 
	{
	}
	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}
	public String getTanggal()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		tanggal = dateFormat.format(date);
		return tanggal;
	}
}

