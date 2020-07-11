package it.uniroma1.metodologie.eccezioni;

public class InvalidExpressionException extends EccezioniMiniBASIC 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3456222088554406986L;

	public InvalidExpressionException(int n)
	{
		super("Espressione non valida alla riga "+n);
	}
}
