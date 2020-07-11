package it.uniroma1.metodologie;
/**
 * La clase Intero rappresenta i valori interi all'interno dell'ambiente MiniBASIC
 * @author Riccardo Tittarelli
 *
 */
public class Intero extends Dato
{

	private int valore = 0;
	/**
	 * Costruisce un Oggetto Intero da un valore int
	 * @param valore
	 */
	public Intero(int valore)
	{
		this.valore = valore;
	}
	/**
	 * Ritorna il valore dell'Intero
	 * @return Il valore dell'Intero
	 */
	public int getValore() {return valore;}
	
	/**
	 * Ritorna il valore in string dell'Intero
	 */
	@Override
	public String toString() {return String.valueOf(valore);}
	
	public boolean greaterThan(Intero i) {return valore > i.getValore()? true : false;}
	
	public boolean lesserThan(Intero i) {return valore < i.getValore()? true : false;}
	
	public boolean greaterEqualTo(Intero i) {return valore >= i.getValore()? true : false;}
	
	public boolean lesserEqualTo(Intero i) {return valore <= i.getValore()? true : false;}
	
	@Override
	public boolean equals(Object o) 
	{
		if (o == null || !(o instanceof Intero))
			return false;
		return valore == ((Intero)o).getValore() ? true : false;
	}

}
