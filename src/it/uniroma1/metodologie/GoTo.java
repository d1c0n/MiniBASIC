package it.uniroma1.metodologie;

/**
 * La classe GoTo permette di spostarsi all'interno dell'esecuzione di un Programma
 * @author Riccardo Tittarelli
 *
 */
public class GoTo implements Eseguibile
{
	private String nomeEtichetta;
	
	/**
	 * Crea un GoTo con il nome dell'etichetta a cui si vuole andare
	 * @param nomeEtichetta
	 */
	public GoTo(String nomeEtichetta)
	{
		this.nomeEtichetta = nomeEtichetta;
	}
	
	/**
	 * Imposta il valore del ProgramCounter alla posizione dell'etichetta
	 * @param prog Programma in cui eseguire il GoTo
	 */
	@Override
	public void esegui(Programma prog)
	{
		prog.setPC(prog.etichette.indexOf(nomeEtichetta));
	}
}
