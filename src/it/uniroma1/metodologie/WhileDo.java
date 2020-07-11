package it.uniroma1.metodologie;

import java.util.ArrayList;
/**
 * La classe WhileDo permette di creare un istruzione del formato WHILE DO a partire o da un'espressione che deve essere risolta, o da un valore Booleano.
 * Nel momento in cui viene eseguita, l'istanza si occupa di risolvere l'espressione e eseguire le Istruzioni corrispondenti finche' la condizione è verificata.
 * E' possibile eseguire più istruzioni per iterazioni. Nel caso in cui si vogliano annidare più selezioni o iterazioni bisogna obbligatoriamente costruire l'istruzione utilizzando
 * un metodo costruttore.
 * @author Riccardo Tittarelli
 *
 */
public class WhileDo implements Eseguibile
{
	private String condizioneStringa;
	private ArrayList<Eseguibile> istruzioniDo;
	
	/**
	 * Costruisce un'Istruzione WhileDo con una String che rappresenta un'espressione di condizione e un Array di istruzioni
     * @param condizioneStringa Stringa che rappresenta un'espressione di condizione
	 * @param istruzioniDo Array di istruzioni da eseguire finche' la condizione risulta vera
	 */
	public WhileDo(String condizioneStringa, ArrayList<Eseguibile> istruzioniDo)
	{
		this.condizioneStringa = condizioneStringa;
		this.istruzioniDo = istruzioniDo;
	}
	
	/**
	 * Costruisce un'Istruzione WhileDo con un Confronto e un Array di istruzioni
     * @param condizioneStringa Stringa che rappresenta un'espressione di condizione
	 * @param istruzioniDo Array di istruzioni da eseguire finche' la condizione risulta vera
	 */
	public WhileDo(Confronto c, ArrayList<Eseguibile> istruzioniDo)
	{
		this.condizioneStringa = c.toString();
		this.istruzioniDo = istruzioniDo;
	}
	
	/**
	 * Costruisce un'Istruzione WhileDo con un Booleano e un Array di istruzioni
	 * @param bool Un Booleano
	 * @param istruzioniDo Array di istruzioni da eseguire finche' la condizione risulta vera
	 */
	public WhileDo(Booleano bool, ArrayList<Eseguibile> istruzioniDo)
	{
		this.condizioneStringa = bool.toString();
		this.istruzioniDo = istruzioniDo;
	}
	
	/**
	 * Determina il valore dell'espressione di condizione e esegue le Istruzioni in istruzioniThen se risulta true, esegue quelle in
	 * istruzioniElse altrimenti
	 * @param prog il Programma in cui eseguire l'IfThenElse
	 */
	public void esegui(Programma prog)
	{
		while (((Booleano)Espressione.risolvi(condizioneStringa, prog)).getValore())
			for (Eseguibile i : istruzioniDo)
			{	
				if (i instanceof GoTo || i instanceof End) 
				{
					i.esegui(prog);
					break;
				}
				i.esegui(prog);
			}
	}
}
