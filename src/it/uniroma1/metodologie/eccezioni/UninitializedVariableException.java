package it.uniroma1.metodologie.eccezioni;

public class UninitializedVariableException extends EccezioniMiniBASIC
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5729144442635671275L;

	public UninitializedVariableException(int n)
	{
		super("Variabile non inizzializzata alla riga: "+n);
	}
}
