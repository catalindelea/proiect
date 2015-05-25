package ro.ase.csie.cts.proiect.factory;

import java.util.Date;

import ro.ase.csie.cts.proiect.entity.Angajat;
import ro.ase.csie.cts.proiect.entity.Persoana;
import ro.ase.csie.cts.proiect.exceptions.CnpNotValidExcetion;
import ro.ase.csie.cts.proiect.exceptions.NumeNotValidException;
import ro.ase.csie.cts.proiect.exceptions.PrenumeNotValidException;
import ro.ase.csie.cts.proiect.util.Tip;

public class Factory {
	public Persoana creazaPersoana(Tip tip, String cnp, String nume,
									String prenume, Date limitaContractuala) throws CnpNotValidExcetion, NumeNotValidException, PrenumeNotValidException{
		switch (tip) {
		case Persoana : return new Persoana(cnp, nume, prenume);
		case Angajat : return new Angajat(cnp, nume, prenume, limitaContractuala);
		}
		return null;
	}
}
