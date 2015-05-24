package ro.ase.csie.cts.proiect.entity;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import ro.ase.csie.cts.proiect.util.TipAnalize;

public class Analiza {
	private Date dataAnaliza;
	private String descriere;
	private float greutate;
	private float inaltime;
	private TipAnalize setAnalize;
	
	public float getInaltime() {
		return inaltime;
	}

	public void setInaltime(float inaltime) {
		this.inaltime = inaltime;
	}

	public void setDataAnaliza(Date dataAnaliza) {
		this.dataAnaliza = dataAnaliza;
	}

	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}

	public void setGreutate(float greutate) {
		this.greutate = greutate;
	}

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
	
	public float getGreutate() {
		return greutate;
	}
	
	public void setTipAnalize(TipAnalize setAnalize) {
		this.setAnalize = setAnalize;
	}
	
	public TipAnalize getTipAnalize() {
		return setAnalize;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
