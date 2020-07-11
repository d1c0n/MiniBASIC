package it.uniroma1.metodologie.eccezioni;

public class IllegalOperatorException extends EccezioniMiniBASIC
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3635162009756074091L;

	public IllegalOperatorException(int n)
	{
		super("Operatore non persmesso alla riga "+n);
	}
}
