package ro.ase.csie.cts.proiect.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Persoana {
	private String cnp;
	private String nume;
	private String prenume;
	private List<Analiza> istroicAnalize;
	
	public Persoana (String cnp, String nume, String prenume){
		this.cnp = cnp;
		this.nume = nume;
		this.prenume = prenume;
		this.istroicAnalize = new ArrayList<Analiza>();
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getCnp() {
		return cnp;
	}

	public List<Analiza> getIstroicAnalize() {
		return istroicAnalize;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
