package ro.ase.csie.cts.proiect.main;

import java.util.Date;

import ro.ase.csie.cts.proiect.entity.Persoana;

public class Main {

	public static void main(String[] args) {
		Persoana p = new Persoana("1930523340442", "as", "ass");
		String sex = p.getSex();
		Date dataNastere = p.getDataNastere();
		System.out.println(sex);
		System.out.println(dataNastere);
		String judet = p.getJudet();
		System.out.println(judet);
		System.out.println(p.verificaCnp());
	}

}
