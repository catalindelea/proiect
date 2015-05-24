package ro.ase.csie.cts.proiect.entity;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Angajat extends Persoana{
	private Date limitaContractuala;
	
	public Angajat(String cnp, String nume, String prenume, Date limitaContractuala) {
		super(cnp, nume, prenume);
		this.limitaContractuala = limitaContractuala;
	}
	
	public Date getLimitaContractuala() {
		return limitaContractuala;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
