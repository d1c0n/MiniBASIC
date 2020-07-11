package it.uniroma1.metodologie.eccezioni;

public class SyntaxException extends EccezioniMiniBASIC
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5015563958208078823L;

	public SyntaxException(int n)
	{
		super("Errore di Sintassi alla riga "+n);
	}
}
