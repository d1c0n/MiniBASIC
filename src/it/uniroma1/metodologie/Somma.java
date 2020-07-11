package it.uniroma1.metodologie;
/**
 * La classe Somma semplifica la creazione di espressioni per assegnazioni, iterazioni e selezioni.
 * @author Riccardo Tittarelli
 *
 */
public class Somma implements Eseguibile
{
	Dato[] operandi;
	
	/**
	 * Crea una Somma tra gli elementi di un Array di Dati
	 * @param operandi Un Array di Dati
	 */
	public Somma(Dato... operandi)
	{
		this.operandi = operandi;
	}
	
	public void esegui(Programma p) {}
	
	/**
	 * Ritorna la rappresentazione in String della Somma 
	 * @return La rappresentazione in String della Somma
	 */
	public String toString()
	{
		String s = operandi[0].toString();
		for (int i=1; i<operandi.length; i++)
			s += "+" + operandi[i];
		return s;
	}
}
