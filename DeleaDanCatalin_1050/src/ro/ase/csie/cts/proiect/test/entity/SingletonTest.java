package ro.ase.csie.cts.proiect.test.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import ro.ase.csie.cts.proiect.singleton.CentruMedical;

public class SingletonTest {
	CentruMedical centru;
	
	@After
	public void tearDown(){
		centru = null;
	}
	@Test
	public void centruMedicalNotNull() {
		CentruMedical centru = CentruMedical.getInstance();
		assertFalse("Centrul medical instatiat este null", centru==null);
	}
	
	@Test
	public void centruMedicalNotUnique() {
		CentruMedical centru = CentruMedical.getInstance();
		CentruMedical centru2 = CentruMedical.getInstance();
		assertFalse("Centrele medicale instatiate nu sunt identice", centru!=centru2);
	}
	
	@Test
	public void centruMedicalNotInstanceofCentruMedical(){
		CentruMedical centru = CentruMedical.getInstance();
		assertFalse("CentruMedical nu este instanta a CentruMedical", !(centru instanceof CentruMedical));
	}

}
