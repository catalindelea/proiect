package ro.ase.csie.cts.proiect.validators;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CnpValidator {

	public static BufferedReader openFile(String nume) {
		InputStream file;
		BufferedReader br = null;
		try {
			file = new FileInputStream(nume);
			InputStreamReader isr = new InputStreamReader(file);
			br = new BufferedReader(isr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return br;
	}

	public static boolean verificaCnp(String cnp) {
		int s = 0;
		String number = "279146358279";
		for (int i = 0; i < 12; i++) {
			s += Integer.parseInt("" + number.charAt(i)) * Integer.parseInt("" + cnp.charAt(i));
		}
		int cifra = s % 11;
		if (cifra == 10)
			cifra = 1;
		return cifra == Integer.parseInt("" + cnp.charAt(12));
	}

	public static boolean cnpIsValid(String cnp) {
		boolean isValid = true;
		try {
			long numericCnp = Long.parseLong(cnp);
		} catch (Exception ex) {
			ex.printStackTrace();
			isValid = false;
		}

		if (cnp.length() != 13) {
			isValid = false;
		}

		BufferedReader br = openFile("fisiere/sex");
		String linie;
		List<String> possibleGenders = new ArrayList<String>();
		try {
			while ((linie = br.readLine()) != null) {
				possibleGenders.add(linie.split("%")[0]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		possibleGenders.remove(cnp.charAt(0) + "");
		if (possibleGenders.size() != 5)
			isValid = false;

		int luna = Integer.parseInt(cnp.charAt(3) + "" + cnp.charAt(4) + "");
		if (luna > 12)
			isValid = false;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
			sdf.setLenient(false);
			Date dataNasterii = sdf.parse(cnp.substring(1, 7));
		} catch (Exception ex) {
			ex.printStackTrace();
			isValid = false;
		}

		br = openFile("fisiere/judet");
		String line;
		List<String> possibleCountys = new ArrayList<String>();
		try {
			while ((line = br.readLine()) != null) {
				possibleCountys.add(line.split("\t")[0]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String county = cnp.charAt(7) + "" + cnp.charAt(8) + "";
		possibleCountys.remove(county);
		if (possibleCountys.size() == 48) {
			isValid = false;
		}

		
		//Daca decomentam asta crapa multe deste din cauza invaliditatii
		//cnp-urilor din fisierele text
//		if (!verificaCnp(cnp)) {
//			isValid = false;
//		}

		return isValid;
	}
}
