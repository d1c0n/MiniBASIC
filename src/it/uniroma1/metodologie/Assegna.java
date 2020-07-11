package it.uniroma1.metodologie;

/**
 * La classe Assegna permette di assegnare ad una variabile di un Programma MiniBasic un valore.
 * Si può costruire sia con una Costante, sia con un'espressione il cui valore verrà calcolato e assegnato
 * al momento dell'esecuzione dell'assegnazione.
 * @author Riccardo Tittarelli
 *
 */
public class Assegna implements Eseguibile
{
	private int variabile;
	private String espressioneStringa; 
	
	/**
	 * Costruisce un'Istruzione Assegna con il nome della variabile e una string contente un'espressione
	 * @param variabile La Variabile a cui assegnare il valore
	 * @param espressioneStringa Una String che contiene un'espressione
	 */
	public Assegna(Variabile variabile, String espressioneStringa)
	{
		this.variabile = variabile.getValore();
		this.espressioneStringa = espressioneStringa;
	}
	
	/**
	 * Costruisce un'Istruzione Assegna con il nome della variabile e una Somma
	 * @param variabile variabile La Variabile a cui assegnare il valore
	 * @param s Una Somma
	 */
	public Assegna(Variabile variabile, Somma s)
	{
		this.variabile = variabile.getValore();
		this.espressioneStringa = s.toString();
	}
	
	/**
	 * Costruisce un'Istruzione Assegna con il nome della variabile e un Confronto
	 * @param variabile La Variabile a cui assegnare il valore
	 * @param s Un Confronto
	 */
	public Assegna(Variabile variabile, Confronto c)
	{
		this.variabile = variabile.getValore();
		this.espressioneStringa = c.toString();
	}
	
	/**
	 * Costruisce un'Istruzione Assegna con il nome della variabile e un Intero
	 * @param variabile La Variabile a cui assegnare il valore
	 * @param intero Un Intero
	 */
	public Assegna(Variabile variabile, Intero intero)
	{
		this.variabile = variabile.getValore();
		this.espressioneStringa = intero.toString();
	}
	
	/**
	 * Costruisce un'Istruzione Assegna con il nome della variabile e un Booleano
	 * @param variabile La Variabile a cui assegnare il valore
	 * @param bool Un Booleano
	 */
	public Assegna(Variabile variabile, Booleano bool)
	{
		this.variabile = variabile.getValore();
		this.espressioneStringa = bool.toString();
	}
	
	/**
	 * Costruisce un'Istruzione Assegna con il nome della variabile e una Stringa
	 * @param variabile La Variabile a cui assegnare il valore
	 * @param stringa Una Stringa
	 */
	public Assegna(Variabile variabile, Stringa stringa)
	{
		this.variabile = variabile.getValore();
		this.espressioneStringa = "\""+stringa.toString()+"\"";
	}
	
	/**
	 * Costruisce un'Istruzione Assegna con il nome della variabile e un'altra variabile
	 * @param variabile La Variabile a cui assegnare il valore
	 * @param var2 Una Variabile
	 */
	public Assegna(Variabile variabile, Variabile var2)
	{
		this.variabile = variabile.getValore();
		this.espressioneStringa = "$"+var2.getValore();
	}

	/**
	 * Associa nel programma il valore scelto alla variabile corrispondente nel Programma
	 * Nel caso in cui il valore sia un'espressione, ne calcola prima il valore e associa il risultato
	 * @param prog Programma in cui eseguire l'Assegnazione
	 */
	@Override
	public void esegui(Programma prog) 
	{
		prog.variabili[variabile] = Espressione.risolvi(espressioneStringa, prog);
	}
}
