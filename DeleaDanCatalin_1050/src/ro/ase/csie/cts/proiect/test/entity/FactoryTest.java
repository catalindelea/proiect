package ro.ase.csie.cts.proiect.test.entity;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.ase.csie.cts.proiect.entity.Persoana;
import ro.ase.csie.cts.proiect.exceptions.CnpNotValidExcetion;
import ro.ase.csie.cts.proiect.exceptions.NumeNotValidException;
import ro.ase.csie.cts.proiect.exceptions.PrenumeNotValidException;
import ro.ase.csie.cts.proiect.factory.Factory;
import ro.ase.csie.cts.proiect.util.Tip;

public class FactoryTest {
	Factory factory;
	Persoana persoana;
	
	@Before
	public void setUp() throws Exception {
		factory = new Factory();
	}

	@After
	public void tearDown(){
		factory = null;
		persoana = null;
	}
	
	@Test
	public void persoanaInstanceOfPersoana() throws CnpNotValidExcetion, NumeNotValidException, PrenumeNotValidException {
		persoana = factory.creazaPersoana(Tip.Persoana, "1930523340442", "Delea", "Catalin", new Date());
		assertTrue("Persoana este instanta a clasei persoana", persoana instanceof Persoana);
	}
	
	@Test
	public void persoanaNotNull() throws CnpNotValidExcetion, NumeNotValidException, PrenumeNotValidException{
		persoana = factory.creazaPersoana(Tip.Persoana, "1930523340442", "Delea", "Catalin", new Date());
		assertFalse("Persoana instantiata este null ", (persoana==null));
	}
	
	@Test
	public void angajatInstanceOfPersoana() throws CnpNotValidExcetion, NumeNotValidException, PrenumeNotValidException {
		persoana = factory.creazaPersoana(Tip.Angajat, "1930523340442", "Delea", "Catalin", new Date());
		assertTrue("Angajatul este instanta a clasei persoana", persoana instanceof Persoana);
	}
	
	@Test
	public void angajatNotNull() throws CnpNotValidExcetion, NumeNotValidException, PrenumeNotValidException{
		persoana = factory.creazaPersoana(Tip.Angajat, "1930523340442", "Delea", "Catalin", new Date());
		assertFalse("Persoana instantiata este null ", (persoana==null));
	}
}
