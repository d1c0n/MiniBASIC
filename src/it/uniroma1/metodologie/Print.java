package it.uniroma1.metodologie;

import it.uniroma1.metodologie.eccezioni.UninitializedVariableException;
/**
 * La classe Print permette di creare un istruzione che stampa a video un Dato. Se l'istruzione viene costruita con un'espressione, durante l'esecuzione essa verra'
 * risolta e verra' stampato a video il risultato. 
 * @author Riccardo Tittarelli
 *
 */
public class Print implements Eseguibile
{
	private String espressione;
	private int variabile;
	private String mark;
	
	/**
	 * Crea un'Istruzione Print con una String che rappresenta un'espressione
	 * @param espressione La String che contiene l'espressione il cui valore viene stampato
	 */	
	public Print(String espressione)
	{
		this.espressione = espressione;
		mark = "espressione";
	}
	
	/**
	 * Crea un'Istruzione Print con una Stringa
	 * @param stringa La Stringa da stampare
	 */	
	public Print(Stringa stringa)
	{
		this.espressione = stringa.toString();
		mark = "espressione";
	}
	
	/**
	 * Crea un'Istruzione Print con un Intero
	 * @param intero L'intero da stampare
	 */	
	public Print(Intero intero)
	{
		this.espressione = intero.toString();
		mark = "espressione";
	}
	
	/**
	 * Crea un'Istruzione Print con un Booleano
	 * @param bool Il Booleano da stampare
	 */	
	public Print(Booleano bool)
	{
		this.espressione = bool.toString();
		mark = "espressione";
	}
	
	/**
	 * Crea un'Istruzione Print con una Variabile
	 * @param var La Variabile di cui stampare il valore
	 */
	public Print(Variabile var)
	{
		variabile = var.getValore();
		mark = "variabile";
	}
	
	/**
	 * Crea un'Istruzione Print con una Somma
	 * @param var La Somma il cui risultato si vuole stampare
	 */
	public Print(Somma s)
	{
		this.espressione = s.toString();
		mark = "espressione";
	}
	
	/**
	 * Crea un'Istruzione Print con un Confronto
	 * @param var Il Confronto il cui risultato si vuole stampare
	 */
	public Print(Confronto c)
	{
		this.espressione = c.toString();
		mark = "espressione";
	}
	
	/**
	 * Stampa o il valore della costante o il valore della variabile o il valore dell'espressione
	 * @param p il Programma in cui eseguire l'Istruzione
	 * @throws UninitializedVariableException Se la variabile non è inizializzata
	 */
	public void esegui(Programma p)
	{
		
		switch (mark)
		{
			case "variabile" -> 
			{
				if (p.variabili[variabile] == null)
					throw new UninitializedVariableException(p.getPC()+1);
				else
					System.out.println(p.variabili[variabile]);
			}
			case "espressione" -> System.out.println(Espressione.risolvi(espressione, p));
		};
	}
}
