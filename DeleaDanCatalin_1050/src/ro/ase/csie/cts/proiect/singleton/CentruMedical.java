package ro.ase.csie.cts.proiect.singleton;

import java.util.ArrayList;
import java.util.List;

import ro.ase.csie.cts.proiect.entity.Persoana;

public class CentruMedical {
	private static CentruMedical centru;
	private static List<Persoana> persoane;
	
	private CentruMedical(){
		persoane = new ArrayList<Persoana>();
	}
	
	public CentruMedical getInstance(){
		if (centru == null) 
			centru = new CentruMedical();
		return centru;
	}
}
