package it.uniroma1.metodologie;
/**
 * La clase Booleano rappresenta i valori booleani all'interno dell'ambiente MiniBASIC
 * @author Riccardo Tittarelli
 *
 */
public class Booleano extends Dato
{

	private boolean valore;
	
	/**
	 * Costruisce un Oggetto Booleano da un valore boolean
	 * @param valore
	 */
	public Booleano(boolean valore)
	{
		this.valore = valore;
	}

	
	/**
	 * Ritorna il valore in string del Booleano
	 * @return Il valore in string del Booleano
	 */
	public String toString() {return String.valueOf(valore);}
	
	/**
	 * Ritorna il valore del Booleano
	 * @return Il valore del Booelano
	 */
	public boolean getValore() {return valore;}

	/**
	 * Compara questo oggetto con l'oggetto specificato
	 * @return true se gli oggetti sono logicamente uguali, false altrimenti 
	 */
	@Override
	public boolean equals(Object o) 
	{
		if (o == null || !(o instanceof Booleano))
			return false;
		return valore == ((Booleano)o).getValore() ? true : false;
	}
}
