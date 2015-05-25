package ro.ase.csie.cts.proiect.test.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.ase.csie.cts.proiect.entity.Persoana;
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
	public void persoanaInstanceOfPersoana() {
		persoana = factory.creazaPersoana(Tip.Persoana, null, null, null, null);
		assertTrue("Persoana este instanta a clasei persoana", persoana instanceof Persoana);
	}
	
	@Test
	public void persoanaNotNull(){
		persoana = factory.creazaPersoana(Tip.Persoana, null, null, null, null);
		assertFalse("Persoana instantiata este null ", (persoana==null));
	}
	
	@Test
	public void angajatInstanceOfPersoana() {
		persoana = factory.creazaPersoana(Tip.Angajat, null, null, null, null);
		assertTrue("Angajatul este instanta a clasei persoana", persoana instanceof Persoana);
	}
	
	@Test
	public void angajatNotNull(){
		persoana = factory.creazaPersoana(Tip.Angajat, null, null, null, null);
		assertFalse("Persoana instantiata este null ", (persoana==null));
	}
}
