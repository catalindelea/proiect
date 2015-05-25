package ro.ase.csie.cts.proiect.entity;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import ro.ase.csie.cts.proiect.exceptions.CnpNotValidExcetion;
import ro.ase.csie.cts.proiect.exceptions.NumeNotValidException;
import ro.ase.csie.cts.proiect.exceptions.PrenumeNotValidException;

public class Angajat extends Persoana{
	private Date limitaContractuala;
	
	public Angajat(String cnp, String nume, String prenume, Date limitaContractuala) throws CnpNotValidExcetion, NumeNotValidException, PrenumeNotValidException {
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
