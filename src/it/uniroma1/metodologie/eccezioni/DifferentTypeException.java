package it.uniroma1.metodologie.eccezioni;

public class DifferentTypeException extends EccezioniMiniBASIC
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2202331229800233687L;

	public DifferentTypeException(int n)
	{
		super("Impossibile eseguire confronto tra tipi diversi alla riga "+n);
	}
}
