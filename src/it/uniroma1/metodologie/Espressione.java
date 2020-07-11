package it.uniroma1.metodologie;
import it.uniroma1.metodologie.eccezioni.*;

/**
 * La classe Espressione implementa una serie di metodi statici per il controllo e la risoluzione di espressioni
 * all'interno dell'ambiente MiniBASIC
 * @author Riccardo Tittarelli
 *
 */
public class Espressione
{	
	/**
	 * Controlla se una stringa rappresenta un valore intero
	 * @param s
	 * @return true se la stringa rappresenta un valore intero, false altrimenti
	 */
	public static boolean isNumeric(String s)
	{
		for (char c : s.toCharArray())
		{
			if (!Character.isDigit(c))
				return false;
		}
		return s.length() == 0? false: true;
	}
	
	/**
	 * Controlla se una stringa rappresenta un valore booleano
	 * @param s
	 * @return true se la stringa rappresenta un valore booleano, false altrimenti
	 */
	public static boolean isBoolean(String s) {return (s.trim().equals("true") || s.trim().equals("false"));}
	
	/**
	 * Controlla se una stringa rappresenta una stringa
	 * @param s
	 * @return true se la stringa rappresenta una stringa, false altrimenti
	 */
	public static boolean isVariabile(String s) {return s.trim().charAt(0) == '$';}
	
	/**
	 * Controlla se una stringa rappresenta una stringa
	 * @param s
	 * @return true se la stringa rappresenta una stringa, false altrimenti
	 */
	public static boolean isString(String s) {return s.trim().charAt(0) == '"';}
	
	/**
	 * Ritorna il valore di un'espressione scritta in una stringa
	 *  
	 * @param p Il Programma che contiene le Variabili
	 * @param espressione La stringa contenente l'espressione da risolvere
	 * 
	 * @return La Costante risultato dell'espressione
	 */
	public static Dato risolvi(String espressione, Programma p)
	{
		try 
		{
			//Controlla se l'espressione e' un confronto
			if (espressione.split("[==>=<=]").length != 1)
				return confronto(espressione, espressione.trim().split("[==>=<=]"), p);
			
			//Controlla se l'espressione e' una somma/concatenazione/or
			else if (espressione.split("[+]").length != 1)
				return addizione(espressione, espressione.split("[+]"), p);
			
			/**
			 * Se l'espressione non e' ne' un confronto ne' un'operazione
			 * calcola e ritorna il valore della costante
			 */
			else if (isBoolean(espressione))
				return new Booleano(Boolean.parseBoolean(espressione));
			
			else if (isNumeric(espressione))
				return new Intero(Integer.parseInt(espressione));
			
			else if (isVariabile(espressione))
				if (p.variabili[Integer.parseInt(espressione.substring(1))] == null)
				{
					throw new UninitializedVariableException(p.getPC()+1);
				}
				else return p.variabili[Integer.parseInt(espressione.substring(1))];
			
			isString(espressione);
			return new Stringa(espressione.substring(1,espressione.length()-1));
		}	
		catch (Exception ex)
		{
			throw new InvalidExpressionException(p.getPC()+1);
		}		
	}
	
	private static Dato confronto(String e, String[] confronto, Programma p)
	{
		Dato op1 = Espressione.risolvi(confronto[0].trim(), p);
		Dato op2 = Espressione.risolvi(confronto[confronto.length-1].trim(), p);
		
		if (op1.getClass().equals(op2.getClass()))
		{
			//Ottiene l'operatore cercando >,< o = all'interno dell'espressione
			String operatore = "";
			for (int i=0; i<e.length(); i++)
			{
				if (e.charAt(i) == '<' || e.charAt(i) == '>' || e.charAt(i) == '=')
					operatore += e.substring(i,i+1);
			}

			try
			{
				return switch (operatore)
				{
					case ">=" -> new Booleano(((Intero)op1).greaterEqualTo((Intero)op2));
					case "<=" -> new Booleano(((Intero)op1).lesserEqualTo((Intero)op2));
					case "<>" -> new Booleano(!(op1.equals(op2)));
					case "==" -> new Booleano(op1.equals(op2));
					case ">" -> new Booleano(((Intero)op1).greaterThan((Intero)op2));
					case "<" -> new Booleano(((Intero)op1).lesserThan((Intero)op2));
					default -> throw new IllegalOperatorException(p.getPC()+1);
				};
			}
			catch (Exception ex)
			{
				throw new IllegalOperatorException(p.getPC()+1);
			}
		}
		else
		{
			throw new DifferentTypeException(p.getPC()+1);
		}
	}
	

	private static Dato addizione(String e, String[] operandi, Programma p)

	{
		for (int i=0; i<operandi.length; i++)
		{
			if (isVariabile(operandi[i].trim()))
				operandi[i] = p.variabili[Integer.parseInt(operandi[i].trim().substring(1,2))].toString();			
		}
		if (isString(operandi[0]))
		{
			String s = "";
			for (String parola : operandi) 
			{
				parola = parola.trim();
				if (isString(parola))
					s += parola.substring(1,parola.length()-1);
				else
				{
					throw new IllegalOperationException("Impossibile concatenare stringa con altri tipi alla riga ", p.getPC()+1);
				}	
			}
			return new Stringa(s);
		}
		else if (isBoolean(operandi[0]))
		{
			boolean b = false;
			for (String booleano : operandi)
			{
				if (isBoolean(booleano))
					b = b || Boolean.parseBoolean(booleano);
				else
				{
					throw new IllegalOperationException("Impossibile eseguire l'or tra non booleani ", p.getPC()+1);
				}
			}
			return new Booleano(b);
			
		}
		int n = 0;
		for (String intero : operandi)
		{
			intero = intero.trim();
			if (isNumeric(intero.trim()))
				n += Integer.parseInt(intero);
			else
			{
				throw new IllegalOperationException("Impossibile fare la somma tra non interi ", p.getPC()+1);
			}
		}
		return new Intero(n);
	}
}

