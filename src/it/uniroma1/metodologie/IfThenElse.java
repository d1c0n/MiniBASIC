package it.uniroma1.metodologie;

import java.util.ArrayList;
/**
 * La classe IfThenElse permette di creare un istruzione del formato IF THEN ELSE a partire o da un'espressione che deve essere risolta, o da un valore Booleano.
 * Nel momento in cui viene eseguita, l'istanza si occupa di risolvere l'espressione e eseguire le Istruzioni corrispondenti.
 * E' possibile eseguire più istruzioni per selezione. Nel caso in cui si vogliano annidare più selezioni o iterazioni bisogna obbligatoriamente costruire l'istruzione utilizzando
 * un metodo costruttore.
 * @author Riccardo Tittarelli
 *
 */
public class IfThenElse implements Eseguibile
{
	private String condizioneStringa;
	private ArrayList<Eseguibile> istruzioniIf;
	private ArrayList<Eseguibile> istruzioniElse;
	
    /**
     * Costruisce un'Istruzione IfThenElse con una String che rappresenta un'espressione di condizione e due Array di istruzioni then e else
     * @param condizioneStringa Stringa che rappresenta un'espressione di condizione
     * @param istruzioniIf Array di istruzioni da eseguire se la condizione risulta vera
     * @param istruzioniElse Array di istruzioni da eseguire se la condizione risulta falsa
     */
	public IfThenElse(String condizioneStringa, ArrayList<Eseguibile> istruzioniIf, ArrayList<Eseguibile> istruzioniElse)
	{
		this.condizioneStringa = condizioneStringa;
		this.istruzioniIf = istruzioniIf;
		this.istruzioniElse = istruzioniElse;
	}
	
	/**
	 * Costruisce un'Istruzione IfThenElse con un Confronto e due Array di istruzioni
	 * @param c Un Confronto
	 * @param istruzioniIf Array di istruzioni da eseguire se la condizione risulta vera
     * @param istruzioniElse Array di istruzioni da eseguire se la condizione risulta falsa
	 */
	public IfThenElse(Confronto c, ArrayList<Eseguibile> istruzioniIf, ArrayList<Eseguibile> istruzioniElse)
	{
		this.condizioneStringa = c.toString();
		this.istruzioniIf = istruzioniIf;
		this.istruzioniElse = istruzioniElse;
	}
	
	/**
	 * Costruisce un'Istruzione IfThenElse con un Booleano e due Array di istruzioni
	 * @param bool Un Booleano
	 * @param istruzioniIf Array di istruzioni da eseguire se la condizione risulta vera
     * @param istruzioniElse Array di istruzioni da eseguire se la condizione risulta falsa
	 */
	public IfThenElse(Booleano bool, ArrayList<Eseguibile> istruzioniIf, ArrayList<Eseguibile> istruzioniElse)
	{
		this.condizioneStringa = bool.toString();
		this.istruzioniIf = istruzioniIf;
		this.istruzioniElse = istruzioniElse;
	}
	
	/**
	 * Determina il valore dell'espressione di condizione e esegue le Istruzioni in istruzioniThen se risulta true, esegue quelle in
	 * istruzioniElse altrimenti
	 * @param prog il Programma in cui eseguire l'IfThenElse
	 */
	public void esegui(Programma prog)
	{
		if (((Booleano)Espressione.risolvi(condizioneStringa, prog)).getValore())
			for (Eseguibile i : istruzioniIf)
			{	
				if (i instanceof GoTo || i instanceof End) 
				{
					i.esegui(prog);
					break;
				}
				i.esegui(prog);
			}
		else
			for (Eseguibile i : istruzioniElse)
				{	
					if (i instanceof GoTo) 
					{
						i.esegui(prog);
						break;
					}
					i.esegui(prog);
				}
	}
}
