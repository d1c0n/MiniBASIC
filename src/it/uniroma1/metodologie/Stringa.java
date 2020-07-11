package it.uniroma1.metodologie;
/**
 * La clase Stringa rappresenta le String all'interno dell'ambiente MiniBASIC
 * @author Riccardo Tittarelli
 *
 */
public class Stringa extends Dato
{

	private String valore = "";
	/**
	 * Costruisce un Oggetto Stringa da un valore string
	 * @param valore
	 */
	public Stringa(String valore)
	{
		this.valore = valore;

	}

	
	/**
	 * Ritorna il valore in string della Stringa
	 * @return Una String con il valore della Stringa
	 */
	@Override
	public String toString() {return valore;}
	
	/**
	 * Ritorna il valore della Stringa
	 * @return Il valore della Stringa
	 */
	public String getValore() {return valore;}
	
	@Override
	public boolean equals(Object o) 
	{
		if (o == null || !(o instanceof Stringa))
			return false;
		return valore.equals(((Stringa)o).getValore()) ? true : false;
	}
}
