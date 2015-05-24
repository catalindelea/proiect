package ro.ase.csie.cts.proiect.builder;

import ro.ase.csie.cts.proiect.entity.Analiza;
import ro.ase.csie.cts.proiect.util.TipAnalize;

public class AnalizaBuilder {
	private Analiza analiza = null;

	public AnalizaBuilder(String descriere) {
		analiza = new Analiza(descriere);
	}

	public AnalizaBuilder setGreutate(float greutate) {
		this.analiza.setGreutate(greutate);
		return this;
	}

	public AnalizaBuilder setInaltime(float inaltime) {
		this.analiza.setInaltime(inaltime);
		return this;
	}

	public AnalizaBuilder setSetAnalize(TipAnalize tip) {
		this.analiza.setTipAnalize(tip);
		return this;
	}

	public Analiza build() {
		return this.analiza;
	}
}
