package ro.ase.csie.cts.proiect.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.NotActiveException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import ro.ase.csie.cts.proiect.entity.Persoana;
import ro.ase.csie.cts.proiect.exceptions.NotNumericValue;

public class PersoanaTest {
	Persoana p;

	@Before
	public void setUp() throws Exception {
		p = new Persoana("4999999999999", "asd", "asd");
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
	public void invalidGenderCnp() {
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
		boolean isGood=false;
		for (String s:possibleGenders){
			if ((p.getCnp().charAt(0)+"").equalsIgnoreCase(s)){
				isGood=true;
			}
		}
		assertFalse("Cnp-ul trebuie sa inceapa cu cifre de la 1 la 6", !isGood);
	}
}
