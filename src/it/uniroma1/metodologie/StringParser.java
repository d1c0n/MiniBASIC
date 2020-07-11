package it.uniroma1.metodologie;

import java.util.ArrayList;
import java.util.Arrays;
import it.uniroma1.metodologie.eccezioni.SyntaxException;
/**
 * La classe StringParser mette a disposizione una serie di metodi statici che permettono l'identificazione di istruzioni e di etichette all'interno di un file scritto
 * in linguaggio MiniBASIC
 * @author Riccardo Tittarelli
 *
 */
public class StringParser 
{
	private static final String istruzioni = "PRINT$0$1$2$3$4$5$6$7$8$9IFWHILEGOTOREMEND";
	

	/**
	 * Prende un Array di String scritte in MiniBASIC e ritorna un Array che ne contiene le etichette
	 * 
	 * @return Un Array contente le etichette all'indice della posizione in cui si trovano nel Programma
	 * 
	 */
	public static ArrayList<String> trovaEtichette(ArrayList<String> righe)
	{
		String[] etichette = new String[righe.size()];
		for (int i=0; i<righe.size(); i++)
		{
			String linea = righe.get(i).trim();
			String[] parti = linea.split("[ :=]");
			if (!istruzioni.contains(parti[0]))
			{
				if (linea.charAt(linea.length()-1) == ':')
					etichette[i] = parti[0];
				else
				{
					throw new SyntaxException(i+1);
				}
			}

		}
		ArrayList<String> etichetteArray = new ArrayList<String>(Arrays.asList(etichette));
		return etichetteArray;
	}
	
	  
	
	/**
	 * Prende un Array di righe scritte in MiniBASIC e ritorna un Array di Istruzioni
	 * 
	 * @param righe Un Array di righe scritte in MiniBASIC
	 * @return Un Array di Istruzioni
	 */
	public static ArrayList<Eseguibile> toIstruzioni(ArrayList<String> righe)
	{
		ArrayList<Eseguibile> istruzioni = new ArrayList<>();
		for (int i=0; i<righe.size(); i++)
		{
			String[] parti = righe.get(i).trim().split("[ :=]");
			switch (parti[0])
			{
				case "" ->  istruzioni.add(new Rem());
				case "PRINT" ->  istruzioni.add(creaPrint(righe, i));
				case "$0","$1","$2","$3","$4","$5","$6","$7","$8","$9" ->  istruzioni.add(creaAssegna(righe, i));
				case "IF" ->  istruzioni.add(creaIfThenElse(righe, i));
				case "WHILE" ->  istruzioni.add(creaWhile(righe, i));
				case "GOTO" ->  istruzioni.add(new GoTo(parti[1]));
				case "REM" ->  istruzioni.add(new Rem());
				case "END" ->  istruzioni.add(new End());
				default -> istruzioni.add(new Rem());
			};
		}
		return istruzioni;
	}
	
	private static Eseguibile creaPrint(ArrayList<String> righe, int i)
	{
		String stampa = righe.get(i).trim();
		return new Print(stampa.substring(6,stampa.length()).trim());
	}
	private static Eseguibile creaAssegna(ArrayList<String> righe, int i)
	{
		String linea = righe.get(i);
		int variabile = Integer.parseInt(linea.substring(1,2));
		String espressioneStringa = linea.substring(linea.indexOf("=")+1).trim();
		return new Assegna(new Variabile(variabile), espressioneStringa);
	}
	private static Eseguibile creaIfThenElse(ArrayList<String> righe, int i)
	{
		String[] getThen = {};
		String[] getElse = {};
		String linea = righe.get(i)+" ";
		int posThen = linea.indexOf("THEN");
		int posElse = linea.lastIndexOf("ELSE");
		String espressioneStringa = linea.substring(2,posThen).trim();
		
		if (posElse == -1) 
		{
			getThen = linea.substring(posThen+4, linea.length()).split(":");
		}
		else
		{
			getThen = linea.substring(posThen+4, posElse).split(":");
			getElse = linea.substring(posElse+4).split(":");
		}
		for (int j=0;j<getThen.length;j++) {getThen[j] = getThen[j].trim();}
		for (int j=0;j<getElse.length;j++) {getElse[j] = getElse[j].trim();}
		
		ArrayList<Eseguibile> istruzioniThen = new ArrayList<>();
		ArrayList<Eseguibile> istruzioniElse = new ArrayList<>();
		
		if (getThen.length != 0) 
			istruzioniThen = StringParser.toIstruzioni(new ArrayList<String>(Arrays.asList(getThen)));
		if (getElse.length != 0)
			istruzioniElse = StringParser.toIstruzioni(new ArrayList<String>(Arrays.asList(getElse)));
		
		return new IfThenElse(espressioneStringa, istruzioniThen, istruzioniElse);
	}
	private static Eseguibile creaWhile(ArrayList<String> righe, int i)
	{
		String[] getWhile = righe.get(i).trim().split("DO");
		String espressioneStringa = getWhile[0].substring(6).trim();
		String[] getDo = getWhile[1].split(":");
		for (int j=0; j<getDo.length; j++)
			getDo[j] = getDo[j].trim();
		ArrayList<Eseguibile> istruzioniDo = StringParser.toIstruzioni(new ArrayList<String>(Arrays.asList(getDo)));
		return new WhileDo(espressioneStringa, istruzioniDo);
	}
}
