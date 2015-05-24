package ro.ase.csie.cts.proiect.entity;

import java.util.Date;

public class Analiza {
	private Date dataAnaliza;
	private String descriere;
	
	public Analiza(String descriere){
		dataAnaliza = new Date();
		this.descriere = descriere;
	}
	
	public Date getDataAnaliza() {
		return dataAnaliza;
	}
	
	public String getDescriere() {
		return descriere;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
