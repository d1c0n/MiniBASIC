package it.uniroma1.metodologie;
/**
 * La classe End funziona esclusivamente da terminatore del programma da cui è eseguita
 * @author Riccardo Tittarelli
 *
 */
public class End implements Eseguibile
{
	/**
	 * Fa terminare l'esecuzione del Programma
	 * @param p Programma in cui eseguire l'End
	 */
	public void esegui(Programma p) {p.endProgram();}
}
