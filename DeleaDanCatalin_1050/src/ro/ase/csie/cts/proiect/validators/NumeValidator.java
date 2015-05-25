package ro.ase.csie.cts.proiect.validators;

public class NumeValidator {
	public static boolean numeIsValid(String nume){
		boolean isValid = true;
		
		if (nume.length()<=2)
			isValid = false;
		
//		if (!(Character.isUpperCase(nume.charAt(0)))) 
//			isValid = false;
		
		return isValid;
	}
}
