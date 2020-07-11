package it.uniroma1.metodologie;

/**
 * La classe MiniBASIC è un piccolo interprete in grado di interpretare semplici programmi 
 * scritti in un linguaggio simile al BASIC che dispone dei seguenti elementi:
 * <p>Tipi di dato:</p> 
 * <ul>
 * <li>booleano</li>
 * <li>intero positivo</li> 
 * <li>stringa</li>
 * </ul>
 * <p>Espressioni:</p>
 * <ul>
 * 		<li>una costante è un’espressione (ad es. 5, true, "ciao")</li>
 * 		<li>il linguaggio è dotato di 10 variabili ($0, …, $9); le variabili sono espressioni e assumono il tipo dell’espressione che viene loro assegnata (ad es. $1 = "ciao" assegna il tipo STRINGA alla variabile $1, $5 = 10 assegna alla variabile $5 il tipo INTERO, ecc.)</li>
 * 		<li>la somma di due espressioni dello stesso tipo è un’espressione del tipo corrispondente (ad esempio, "ciao"+"!!" è di tipo STRINGA ed è la concatenazione tra le due stringhe, 0+42 è di tipo INTERO mentre true+false è BOOLEANO ed è l’or tra i due valori booleani); non è possibile sommare due valori di tipo diverso</li>
 * 		<li>il confronto tra due espressioni è un’espressione di tipo booleano (espressione1 == espressione2 per l’uguaglianza, espressione1 <> espressione2 per la disuguaglianza; per il tipo intero è possibile confrontare anche con gli operatori >, <, <= e >=)</li>
 * </ul>
 * <p>Istruzioni (ogni istruzione deve essere specificata tutta su un’unica riga):</p>
 * <ul>
 * 		<li>stampa: PRINT <variabile o costante di tipo stringa> (ad es. PRINT $3 oppure PRINT "ciao")</li>
 * 		<li>assegnazione: variabile = espressione (ad es. $3 = 5+2)</li>
 * 		<li>selezione: IF <espressione booleana> THEN istruzione1 : istruzione 2 : … : istruzionen [ELSE istruzione1 : … : istruzionem]</li>
 * 		<li>iterazione: WHILE <espressione booleana> DO istruzione1 : … : istruzionen</li>
 * 		<li>etichetta: è possibile identificare una posizione mediante un’etichetta di posizione su una singola riga seguita dai due punti (es. inizio:);</li>
 * 		<li>salto: è possibile saltare a un’etichetta specificata con il comando GOTO etichetta</li>
 * 		<li>commento: una riga di commento inizia con REM, ad esempio: REM commento</li>
 * 		<li>termine dell’esecuzione: mediante l’istruzione END (o il termine delle istruzioni del programma)</li>
 * </ul>
 * @author Riccardo Tittarelli
 *
 */
public class MiniBASIC 
{

	/**
	 * Esegue le Istruzioni contenute all'interno di un Programma
	 * @param p Il Programma di cui eseguire le Istruzioni
	 */
	public void esegui(Programma p) 
	{
		for (Eseguibile i: p)
			{
				i.esegui(p);
			}
	}
}