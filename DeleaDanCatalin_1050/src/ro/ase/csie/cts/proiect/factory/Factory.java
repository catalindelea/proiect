package ro.ase.csie.cts.proiect.factory;

import java.util.Date;

import ro.ase.csie.cts.proiect.entity.Angajat;
import ro.ase.csie.cts.proiect.entity.Persoana;
import ro.ase.csie.cts.proiect.util.Tip;

public class Factory {
	public Persoana creazaPersoana(Tip tip, String cnp, String nume,
									String prenume, Date limitaContractuala){
		switch (tip) {
		case Persoana : return new Persoana(cnp, nume, prenume);
		case Angajat : return new Angajat(cnp, nume, prenume, limitaContractuala);
		}
		return null;
	}
}
