package ro.ase.csie.cts.proiect.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ro.ase.csie.cts.proiect.entity.Persoana;

public class PersoanaTest {
	Persoana p;

	@Before
	public void setUp() throws Exception {
		File file = new File("normalValuesCnp");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String linie = null;
		while ((linie = reader.readLine()) != null) {
			if (linie.startsWith("#"))
				continue;
				String[] valori = linie.split("\t");
				String cnp = valori[0];
				String nume = valori[1];
				String prenume = valori[2];
				p = new Persoana(cnp, nume, prenume);
				break;
		}
		reader.close();
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

	@Test
	public void cnpNotNumericFormat() {
		try {
			Long cnpNumeric = Long.parseLong(p.getCnp());
		} catch (Exception e) {
			assertFalse("cnp-ul persoanei nu este numeric", true);
			e.printStackTrace();
		}
	}

	@Test
	public void invalidLengthCnp() {
		if (p.getCnp().length() != 13)
			assertFalse("Lungumea cnp-ului trebuie sa fie 13 caractere", true);
	}

	@Test
	public void invalidGenderOrNegativeCnp() {
		BufferedReader br = openFile("sex");
		String linie;
		List<String> possibleGenders = new ArrayList<String>();
		try {
			while ((linie = br.readLine()) != null) {
				possibleGenders.add(linie.split("%")[0]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean isGood = false;
		for (String s : possibleGenders) {
			if ((p.getCnp().charAt(0) + "").equalsIgnoreCase(s)) {
				isGood = true;
			}
		}
		assertFalse("Cnp-ul trebuie sa inceapa cu cifre de la 1 la 6", !isGood);
	}

	@Test
	public void invalidMonthCnp() {
		int luna = Integer.parseInt(p.getCnp().charAt(3) + "" + p.getCnp().charAt(4) + "");
		if (luna > 12) {
			assertFalse("valoarea lunii din cnp nu poate fi peste 12", true);
		}
	}

	@Test
	public void invalidDayCnp() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
			sdf.setLenient(false);
			Date dataNasterii = sdf.parse(p.getCnp().substring(1, 7));
		} catch (Exception ex) {
			ex.printStackTrace();
			assertFalse("Data nasterii din cnp nu este valida", true);
		}
	}

	@Test
	public void invalidCountyCnp() {
		BufferedReader br = openFile("judet");
		String line;
		List<String> possibleCountys = new ArrayList<String>();
		try {
			while ((line = br.readLine()) != null) {
				possibleCountys.add(line.split("\t")[0]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean isGood = false;
		String county = p.getCnp().charAt(7)+""+p.getCnp().charAt(8)+"";
		for (String s : possibleCountys) {
			
			if (county.equalsIgnoreCase(s)) {
				isGood = true;
			}
		}
		assertFalse("Cnp-ul trebuie sa contina un judet valid", !isGood);
	}
	
	@Test
	public void lastNameNotNull(){
		if (p.getNume()==null) {
			assertFalse("Numele nu poate fi null", true);
		}
	}
	
	@Test
	public void invalidLastNameInConstructor(){
		assertFalse("Numele trebuie sa inceapa cu litera mare", !Character.isUpperCase(p.getNume().charAt(0)));
	}
	
	@Test
	public void firstNameNotNull(){
		if (p.getPrenume()==null) {
			assertFalse("Preumele nu poate fi null", true);
		}
	}
	
	@Test
	public void invalidFirstNameInConstructor(){
		assertFalse("Preumele trebuie sa inceapa cu litera mare", !Character.isUpperCase(p.getPrenume().charAt(0)));
	}
	
	@Test
	public void getSexFromCnpExpectedValue() {
		assertEquals("Valoare invalida pentru getSex()", "Male", p.getSex());
	}
	
	@Test
	public void getJudetFromCnpExpectedValue() {
		assertEquals("Valoare invalida pentru getSex()", "Teleorman", p.getJudet());
	}
	
	
	@Test
	public void getDataNastereCnpExpectedValue(){
		try {
			Date expectedDate = new SimpleDateFormat("yyyyMMdd").parse("19930523");
			assertEquals("Valoare invalida pentru data", expectedDate, p.getDataNastere());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getAnNastereExpectedValue(){
		assertEquals("Anul returnat nu este corect", 1993, p.getAnNastere());
	}
	
	@Test
	public void getLunaNastereExpectedValue(){
		assertEquals("Luna returnata nu este corecta", 5, p.getLunaNastere());
	}
	
	@Test
	public void getZiNastereExpectedValue(){
		assertEquals("Ziua returnata nu este corecta", 23, p.getZiNastere());
	}
}
