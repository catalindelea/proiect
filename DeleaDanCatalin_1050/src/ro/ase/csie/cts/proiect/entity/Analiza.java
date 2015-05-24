package ro.ase.csie.cts.proiect.entity;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Analiza {
	private Date dataAnaliza;
	private String descriere;
	private float greutate;
	private float inaltime;
	
	
	public Analiza(String descriere, float greutate){
		dataAnaliza = new Date();
		this.greutate = greutate;
		this.descriere = descriere;
	}
	
	public Date getDataAnaliza() {
		return dataAnaliza;
	}
	
	public String getDescriere() {
		return descriere;
	}
	
	public float getGreutate() {
		return greutate;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
