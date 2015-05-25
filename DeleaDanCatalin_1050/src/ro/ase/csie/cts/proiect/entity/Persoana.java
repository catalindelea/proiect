package ro.ase.csie.cts.proiect.entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import ro.ase.csie.cts.proiect.exceptions.CnpNotValidExcetion;
import ro.ase.csie.cts.proiect.exceptions.NumeNotValidException;
import ro.ase.csie.cts.proiect.exceptions.PrenumeNotValidException;
import ro.ase.csie.cts.proiect.validators.*;


public class Persoana {
	private String cnp;
	private String nume;
	private String prenume;
	private List<Analiza> istroicAnalize;

	public Persoana(String cnp, String nume, String prenume) throws CnpNotValidExcetion, NumeNotValidException, PrenumeNotValidException {
		if (!CnpValidator.cnpIsValid(cnp)) 
			throw new CnpNotValidExcetion();
		if (!NumeValidator.numeIsValid(nume))
			throw new NumeNotValidException();
		if (!NumeValidator.numeIsValid(prenume))
			throw new PrenumeNotValidException();

		this.cnp = cnp;
		this.nume = nume;
		this.prenume = prenume;
		this.istroicAnalize = new ArrayList<Analiza>();
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) throws NumeNotValidException {
		if (!NumeValidator.numeIsValid(nume))
			throw new NumeNotValidException();
			this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) throws PrenumeNotValidException {
		if (!NumeValidator.numeIsValid(prenume))
			throw new PrenumeNotValidException();
			this.prenume = prenume;
	}

	public String getCnp() {
		return cnp;
	}
	
	public void setCnp(String cnp) throws CnpNotValidExcetion {
		if (!CnpValidator.cnpIsValid(cnp)) 
			throw new CnpNotValidExcetion();
			this.cnp = cnp;
	}

	public List<Analiza> getIstroicAnalize() {
		return istroicAnalize;
	}

	public BufferedReader openFile(String nume) {
		InputStream file;
		BufferedReader br = null;
		try {
			file = new FileInputStream(nume);
			InputStreamReader isr = new InputStreamReader(file);
			br = new BufferedReader(isr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return br;
	}

	public String getSex() {
		String linie;
		BufferedReader br = openFile("fisiere/sex");
		try {
			while ((linie = br.readLine()) != null) {
				if (linie.split("%")[0].equalsIgnoreCase(this.getCnp().substring(0,1))) {
					return linie.split("%")[1];
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Date getDataNastere(){
		String data = this.cnp.substring(1, 7);
		Date dataNastere=null;
		try {
			dataNastere = new SimpleDateFormat("yyMMdd").parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dataNastere;
	}
	
	public int getAnNastere(){
		String data = this.cnp.substring(1, 7);
		SimpleDateFormat dataNastere=null;
		Calendar cal = Calendar.getInstance();
		try {
			dataNastere = new SimpleDateFormat("yyMMdd");
			cal.setTime(dataNastere.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cal.get(Calendar.YEAR);
	}
	
	public int getLunaNastere(){
		String data = this.cnp.substring(1, 7);
		SimpleDateFormat dataNastere=null;
		Calendar cal = Calendar.getInstance();
		try {
			dataNastere = new SimpleDateFormat("yyMMdd");
			cal.setTime(dataNastere.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cal.get(Calendar.MONTH)+1;
	}
	
	public int getZiNastere(){
		String data = this.cnp.substring(1, 7);
		SimpleDateFormat dataNastere=null;
		Calendar cal = Calendar.getInstance();
		try {
			dataNastere = new SimpleDateFormat("yyMMdd");
			cal.setTime(dataNastere.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public String getJudet(){
		String linie;
		BufferedReader br = openFile("fisiere/judet");
		try {
			while ((linie = br.readLine()) != null) {
				if (linie.substring(0,2).equalsIgnoreCase(this.getCnp().substring(7,9))) {
					return linie.split("\t")[1];
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean verificaCnp(){
		int s=0;
		 String number="279146358279";
		for(int i=0;i<12;i++){
			s+=Integer.parseInt(""+number.charAt(i))*Integer.parseInt(""+this.cnp.charAt(i));			
		}
		int cifra=s%11;
		if(cifra==10)
			cifra=1;
		return cifra==Integer.parseInt(""+this.cnp.charAt(12));
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
