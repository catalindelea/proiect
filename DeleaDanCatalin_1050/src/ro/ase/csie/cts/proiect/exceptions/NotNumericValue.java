package ro.ase.csie.cts.proiect.exceptions;

public class NotNumericValue extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotNumericValue(){
		super("This value must be numeric");
	}
}
