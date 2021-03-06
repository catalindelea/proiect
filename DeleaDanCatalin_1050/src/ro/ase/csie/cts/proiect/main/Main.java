package ro.ase.csie.cts.proiect.main;

import java.util.Date;

import ro.ase.csie.cts.proiect.builder.AnalizaBuilder;
import ro.ase.csie.cts.proiect.entity.Analiza;
import ro.ase.csie.cts.proiect.entity.Persoana;
import ro.ase.csie.cts.proiect.exceptions.CnpNotValidExcetion;
import ro.ase.csie.cts.proiect.exceptions.NumeNotValidException;
import ro.ase.csie.cts.proiect.exceptions.PrenumeNotValidException;
import ro.ase.csie.cts.proiect.factory.Factory;
import ro.ase.csie.cts.proiect.singleton.CentruMedical;
import ro.ase.csie.cts.proiect.util.Tip;
import ro.ase.csie.cts.proiect.util.TipAnalize;

public class Main {

	public static void main(String[] args) {
		Factory persoaneFactory = new Factory();
		Persoana p1 = null;
		try {
			p1 = persoaneFactory.creazaPersoana(Tip.Persoana,"1930523340442", "Delea", "Catalin",new Date());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String sex = p1.getSex();
		Date dataNastere = p1.getDataNastere();
		String judet = p1.getJudet();
		System.out.println("p1 este "+sex);
		System.out.println("nascut pe "+dataNastere);
		System.out.println("in judetul "+judet);
		System.out.println("CNP este valid: "+p1.cnpIsValid());
		Analiza a1 = new AnalizaBuilder("Set analize rutina")
						.setGreutate(65.0f)
						.setInaltime(179f)
						.setSetAnalize(TipAnalize.Rutina)
						.build();
		p1.getIstroicAnalize().add(a1);
		System.out.println(p1);
		System.out.println(a1);
		
		
		Persoana p2 = null;
		try {
			p2 = persoaneFactory.creazaPersoana(Tip.Angajat,"2910322454552", "Popescu", "Maria",new Date());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sex = p2.getSex();
		dataNastere = p2.getDataNastere();
		judet = p2.getJudet();
		System.out.println("p2 este "+sex);
		System.out.println("nascut pe "+dataNastere);
		System.out.println("in judetul "+judet);
		System.out.println("CNP este valid: "+p1.cnpIsValid());
		Analiza a2 = new AnalizaBuilder("Set analize biliare")
						.setGreutate(72.0f)
						.setInaltime(165f)
						.setSetAnalize(TipAnalize.Biliare)
						.build();
		p2.getIstroicAnalize().add(a2);
		System.out.println(p2);
		System.out.println(a2);
		
		
		CentruMedical centru = CentruMedical.getInstance();
		centru.addPersoana(p1);
		centru.addPersoana(p2);
		
		for (Persoana p : CentruMedical.getInstance().getListaPersoane()) {
			System.out.println(p);
		}
	}
}
