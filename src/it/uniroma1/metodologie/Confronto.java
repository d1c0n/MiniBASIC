package it.uniroma1.metodologie;
/**
 * La classe Confronto semplifica la creazione di espressioni condizionali per assegnazioni, iterazioni e selezioni.
 * @author Riccardo Tittarelli
 *
 */
public class Confronto
{
	private Dato c1;
	private Dato c2;
	private OperatoreDiConfronto op;

	/**
	 * Crea un confronto tra due Dati con un OperatoreDiConfronto
	 * @param c1 Un Dato 
	 * @param c2 Un Dato su cui confrontare
	 * @param op Un Operatore di confronto
	 */
	public Confronto(Dato c1, Dato c2, OperatoreDiConfronto op)
	{
		this.c1 = c1;
		this.c2 = c2;
		this.op = op;
	}
	
	/**
	 * Ritorna la rappresentazione in String del confronto 
	 * @return La rappresentazione in String del confronto 
	 */
	public String toString()
	{
		return switch(op)
				{
					case UGUALE -> c1.toString() + "==" + c2.toString();
					case DIVERSO -> c1.toString() + "<>" + c2.toString();
					case MAGGIORE -> c1.toString() + ">" + c2.toString();
					case MINORE -> c1.toString() + "<" + c2.toString();
					case MAGGIOREUGUALE -> c1.toString() + ">=" + c2.toString();
					case MINOREUGUALE -> c1.toString() + "<=" + c2.toString();
				};
	}
}
