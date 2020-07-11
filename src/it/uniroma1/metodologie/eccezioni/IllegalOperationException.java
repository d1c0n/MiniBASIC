package it.uniroma1.metodologie.eccezioni;

public class IllegalOperationException extends EccezioniMiniBASIC
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1627432212734680893L;

	public IllegalOperationException(String s, int n)
	{
		super(s+n);
	}
}
