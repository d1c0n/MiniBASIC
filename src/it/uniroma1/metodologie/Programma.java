package it.uniroma1.metodologie;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
/**
 * La classe Programma si occupa della gestione del programma MiniBASIC, essa tiene traccia dello stato delle variabili e del punto di esecuzione del programma.
 * @author Riccardo Tittarelli
 *
 */
public class Programma implements Iterable<Eseguibile>
{
	/**
	 * Array che tiene traccia delle variabili del programma.
	 * 
	 * Ogni programma ha un Array di 10 variabili visibili a tutto il package
	 * Il nome della variabile è l'indice dell'elemento e il suo valore è l'elemento stesso
	 */
	Dato[] variabili = new Dato[10];
	
	private ArrayList<Eseguibile> istruzioni;
	
	private ArrayList<String> righe = new ArrayList<String>();
	
	private int PC = 0;
	
	/**Dizionario {etichetta:posizione dell'etichetta}*/
	ArrayList<String> etichette;

	/** 
	 * Ritorna il valore del ProgramCounter
	 * @return int il valore del ProgramCounter
	 */
	public int getPC() {return PC;}
	/**
	 * Imposta il ProgramCounter al valore scelto
	 * @param posizione Valore a cui imposta il ProgramCounter
	 */
	public void setPC(int posizione) {PC = posizione;}
	/**
	 * Aumenta di 1 il valore del ProgramCounter
	 */
	public void endProgram() {PC = istruzioni.size();}
	
	/**
	 * Crea un Programma dal percorso di un File con codice MiniBASIC
	 *
	 * @throws IOException Se non trova il file
	 * @param nomeFile Nome del file con codice MiniBASIC
	 */
	public Programma(String nomeFile)
	{
		try(BufferedReader br =
				Files.newBufferedReader(Paths.get(nomeFile)))
				{
				while(br.ready())
				{
					String linea = br.readLine();
					righe.add(linea);
				}
				etichette = StringParser.trovaEtichette(righe);
				istruzioni = StringParser.toIstruzioni(righe);
			}
			catch(IOException e)
			{
				System.out.println("File non trovato");
			}
	}
	
	/**
	 * Crea un Programma da un File con codice MiniBASIC
	 *
	 * @throws IOException Se non trova il file
	 * @param nomeFile File con codice MiniBASIC
	 */
	public Programma(File file)
	{
		try(Scanner s = new Scanner(file))
				{
				while(s.hasNextLine())
				{
					String linea = s.nextLine();
					righe.add(linea);
				}
				etichette = StringParser.trovaEtichette(righe);
				istruzioni = StringParser.toIstruzioni(righe);
			}
			catch(IOException e)
			{
				System.out.println("File non trovato");
			}
	}
	
	
	/**
	 * Crea un Programma da un Array di Istruzioni
	 * @param istruzioniFormattate Array di Istruzioni da eseguire
	 */
	public Programma(Eseguibile... istruzioniFormattate)
	{
		ArrayList<Eseguibile> ists = new ArrayList<>(Arrays.asList(istruzioniFormattate));
		this.istruzioni = ists;
	}
	
	/**
	 * Ritorna un Programma creato dal nome di file con sintassi MiniBASIC
	 * @param nomeFile Nome del file da cui creare il Programma
	 * @return Programma Programma creato da un file
	 */
	public static Programma fromFile(String nomeFile) 
	{
		return new Programma(nomeFile);
	}
	
	public static Programma fromFile(File file) 
	{
		return new Programma(file);
	}
	
	/**
	 * Ritorna un programma creato con un Array di Istruzioni MiniBASIC
	 * @param istruzioniFormattate Array di Istruxioni MiniBasic
	 * @return Programma creato dall'Array
	 */
	public static Programma of(Eseguibile... istruzioniFormattate) 
	{
		return new Programma(istruzioniFormattate);
	}
	
	/**
	 * Ritorna l'Array contenente le Istruzioni del Programma
	 * @return Array che contiene le Istruzioni del Programma
	 */
	public ArrayList<Eseguibile> getIstruzioni() {return istruzioni;}
	
	@Override
	public Iterator<Eseguibile> iterator() 
	{
		
		return new Iterator<Eseguibile>()
		{
			@Override
			public boolean hasNext() 
			{
				return PC<istruzioni.size();
			}

			@Override
			public Eseguibile next() 
			{
				return istruzioni.get(PC++);
			}
		};
	}
}
