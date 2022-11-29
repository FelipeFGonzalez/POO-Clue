package Model;

import java.util.*;

class Jogador extends Suspeito {	
	private ArrayList<Carta> cartas = new ArrayList<Carta>();
	private boolean eliminado;
	private static int count;
	private Bloco blocoJogador;
	
	public Jogador(String sus) {
		super(sus);
		count += 1;
		eliminado = false;
		blocoJogador = new Bloco();
	}
	
	
	
	public static int getCount()
	{
		return count;
	}
	
	public boolean estaNaSala(Tabuleiro tab, String sala)
	{
		int[] posicao = super.getPos();
		int posX = posicao[0];
		int posY = posicao[1];
		if (tab.getSala(posX, posY) == (sala))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean estaEmSala(Tabuleiro tab)
	{
		int[] posicao = super.getPos();
		int posX = posicao[0];
		int posY = posicao[1];
		if (tab.getSala(posX, posY) != "")
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean acessoPassagemSecreta(Tabuleiro tab)
	{
		int[] posicao = super.getPos();
		int posX = posicao[0];
		int posY = posicao[1];
		if (tab.destinoPassagem(posX, posY) != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void recebeCartas(Carta c) {
		cartas.add(c);
	}
	
	public boolean verificaCarta(Carta c)
	{
		return cartas.contains(c);
	}
	
	public boolean verificaCartaString(String s)
	{
		for (int i = 0; i < cartas.size(); i++)
		{
			if (cartas.get(i).getPista().equals(s))
				return true;
		}
		return false;
	}
	
	public boolean estaEliminado()
	{
		return eliminado;
	}
	
	public void eliminar()
	{
		eliminado = true;
	}
	
	public Bloco getBloco()
	{
		return blocoJogador;
	}
	
	public ArrayList<String> getCartasPath()
	{
		ArrayList<String> saida = new ArrayList<String>();
		
		for (int i = 0; i < cartas.size(); i ++)
		{
			Carta c = cartas.get(i);
			if (c.getTipo() == "Suspeito")
			{
				String s = "Suspeitos/";
				if (c.getPista().equals("Reverendo Green"))
					s += "Green";
				else if (c.getPista().equals("Coronel Mustard"))
					s += "Mustard";
				else if (c.getPista().equals("Sra. Peacock"))
					s += "Peacock";
				else if (c.getPista().equals("Professor Plum"))
					s += "Plum";
				else if (c.getPista().equals("Srta. Scarlet"))
					s += "Scarlet";
				else if (c.getPista().equals("Sra. White"))
					s += "White";
				
				saida.add(s);
			}
			else if (c.getTipo() == "Arma")
			{
				String s = "Armas/";
				if (c.getPista().equals("Corda"))
					s += "Corda";
				else if (c.getPista().equals("Cano de Chumbo"))
					s += "Cano";
				else if (c.getPista().equals("Faca"))
					s += "Faca";
				else if (c.getPista().equals("Chave Inglesa"))
					s += "ChaveInglesa";
				else if (c.getPista().equals("Castiçal"))
					s += "Castical";
				else if (c.getPista().equals("Revólver"))
					s += "Revolver";
				saida.add(s);
			}
			else if (c.getTipo() == "Sala")
			{
				String s = "Comodos/";
				if (c.getPista().equals("Cozinha"))
					s += "Cozinha";
				else if (c.getPista().equals("Sala de Jantar"))
					s += "SalaDeJantar";
				else if (c.getPista().equals("Sala de Estar"))
					s += "SalaDeEstar";
				else if (c.getPista().equals("Hall"))
					s += "Entrada";
				else if (c.getPista().equals("Escritório"))
					s += "Escritorio";
				else if (c.getPista().equals("Biblioteca"))
					s += "Biblioteca";
				if (c.getPista().equals("Salão de Jogos"))
					s += "SalaoDeJogos";
				else if (c.getPista().equals("Sala de Música"))
					s += "SalaDeMusica";
				else if (c.getPista().equals("Jardim de Inverno"))
					s += "JardimInverno";

				saida.add(s);
			}
		}
		return saida;		
	}
	
	
	public ArrayList<String> getCartas()
	{
		ArrayList<String> r = new ArrayList<String>();
		for (int i = 0; i < cartas.size(); i++)
		{
			r.add(cartas.get(i).getPista());
		}
		return r;
	}
}
