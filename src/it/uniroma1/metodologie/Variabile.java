package it.uniroma1.metodologie;
/**
 * La clase Stringa rappresenta le Variabili all'interno dell'ambiente MiniBASIC
 * @author Riccardo Tittarelli
 *
 */
public class Variabile extends Dato
{
	private int nomeVariabile;
	
	/**
	 * Crea una Variabile dato il suo numero
	 * @param nomeVariabile
	 */
	public Variabile(int nomeVariabile)
	{
		this.nomeVariabile = nomeVariabile;
	}
	
	/**
	 * Ritorna il nome della Variabile
	 * @return Il nome della Variabile
	 */
	public int getValore() {return nomeVariabile;}
	
	@Override
	public String toString()
	{
		return "$"+nomeVariabile;
	}

	@Override
	public boolean equals(Object o) {return false;}
}
