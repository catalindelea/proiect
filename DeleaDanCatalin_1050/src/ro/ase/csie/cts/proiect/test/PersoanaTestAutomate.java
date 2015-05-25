package ro.ase.csie.cts.proiect.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import ro.ase.csie.cts.proiect.entity.Persoana;

public class PersoanaTestAutomate {
	static Persoana p;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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

	@Test
	public void testGetSex() throws IOException {
		File file = new File("normalValuesGenderCnp");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String linie = null;
		while ((linie = reader.readLine()) != null) {
			if (linie.startsWith("#"))
				continue;
			linie = linie.trim();
			if (linie.isEmpty())
				continue;
			String[] valori = linie.split("\t");
			if (valori.length != 2)
				continue;
			p.setCnp(valori[0]);
			String sex = valori[1];
			assertEquals("Testare getSex()", sex, p.getSex());
		}
		reader.close();
	}
	
	@Test
	public void testGetJudet() throws IOException {
		File file = new File("normalValuesJudetCnp");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String linie = null;
		while ((linie = reader.readLine()) != null) {
			if (linie.startsWith("#"))
				continue;
			linie = linie.trim();
			if (linie.isEmpty())
				continue;
			String[] valori = linie.split("\t");
			if (valori.length != 2)
				continue;
			p.setCnp(valori[0]);
			String judet = valori[1];
			assertEquals("Testare getJudet()", judet, p.getJudet());
		}
		reader.close();
	}
	
	@Test
	public void testGetAnNastere() throws IOException {
		File file = new File("normalValuesAnNastereCnp");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String linie = null;
		while ((linie = reader.readLine()) != null) {
			if (linie.startsWith("#"))
				continue;
			linie = linie.trim();
			if (linie.isEmpty())
				continue;
			String[] valori = linie.split("\t");
			if (valori.length != 2)
				continue;
			p.setCnp(valori[0]);
			int an = Integer.parseInt(valori[1]);
			assertEquals("Testare getAnNastere()", an, p.getAnNastere());
		}
		reader.close();
	}
	
	@Test
	public void testGetLunaNastere() throws IOException {
		File file = new File("normalValuesLunaNastereCnp");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String linie = null;
		while ((linie = reader.readLine()) != null) {
			if (linie.startsWith("#"))
				continue;
			linie = linie.trim();
			if (linie.isEmpty())
				continue;
			String[] valori = linie.split("\t");
			if (valori.length != 2)
				continue;
			p.setCnp(valori[0]);
			int luna = Integer.parseInt(valori[1]);
			assertEquals("Testare getLunaNastere()", luna, p.getLunaNastere());
		}
		reader.close();
	}
	
	@Test
	public void testGetZiNastere() throws IOException {
		File file = new File("normalValuesZiNastereCnp");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String linie = null;
		while ((linie = reader.readLine()) != null) {
			if (linie.startsWith("#"))
				continue;
			linie = linie.trim();
			if (linie.isEmpty())
				continue;
			String[] valori = linie.split("\t");
			if (valori.length != 2)
				continue;
			p.setCnp(valori[0]);
			int zi = Integer.parseInt(valori[1]);
			assertEquals("Testare getZiNastere()", zi, p.getZiNastere());
		}
		reader.close();
	}
	
	@Test
	public void testVerificaCnp() throws IOException {
		File file = new File("normalValuesVerificaCnp");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String linie = null;
		while ((linie = reader.readLine()) != null) {
			if (linie.startsWith("#"))
				continue;
			linie = linie.trim();
			if (linie.isEmpty())
				continue;
			String[] valori = linie.split("\t");
			if (valori.length != 2)
				continue;
			p.setCnp(valori[0]);
			boolean valid = Boolean.parseBoolean(valori[1]);
			assertEquals("Testare getJudet()", valid, p.verificaCnp());
		}
		reader.close();
	}
	
	
}
