package Model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

class Tabuleiro {
	
	private int[][] tab_tiles = {
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
			{0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
			{0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
	};
	
	private int[] portaCozinha = {8, 5};
	private int[] portaJantar = {13, 9};
	private int[] portaJantar2 = {17, 7};
	private int[] portaEstar = {19, 7};
	private int[] portaHall = {18, 13};
	private int[] portaHall2 = {18, 12};
	private int[] portaHall3 = {21, 16};
	private int[] portaEscritorio = {21, 18};
	private int[] portaBib = {17, 17};
	private int[] portaBib2 = {14, 21};
	private int[] portaJogos = {14, 23};
	private int[] portaJogos2 = {10, 18};
	private int[] portaInverno = {6, 19};
	private int[] portaMusica = {6, 17};
	private int[] portaMusica2 = {9, 15};
	private int[] portaMusica3 = {9, 10};
	private int[] portaMusica4 = {6, 8};
	
	private int[] posicaoCozinha = {7, 5};
	private int[] posicaoJantar = {13, 8};
	private int[] posicaoEstar = {20, 7};
	private int[] posicaoHall = {19, 13};
	private int[] posicaoEscritorio = {22, 18};
	private int[] posicaoBiblioteca = {17, 18};
	private int[] posicaoJogos = {13, 23};
	private int[] posicaoInverno = {6, 20};
	private int[] posicaoMusica = {6, 16};
	
	public int[] getPosSala(String nomeSala)
	{
		if (nomeSala == "Cozinha")
			return posicaoCozinha;
		if (nomeSala == "Sala de Jantar")
			return posicaoJantar;
		if (nomeSala == "Sala de Estar")
			return posicaoEstar;
		if (nomeSala == "Hall")
			return posicaoHall;
		if (nomeSala == "Escritório")
			return posicaoEscritorio;
		if (nomeSala == "Biblioteca")
			return posicaoBiblioteca;
		if (nomeSala == "Salão de Jogos")
			return posicaoJogos;
		if (nomeSala == "Jardim de Inverno")
			return posicaoInverno;
		if (nomeSala == "Sala de Música")
			return posicaoMusica;
		else
			return null;
	}
	
	public String getSala(int x, int y)
	{
		if (posicaoCozinha[0] == x && posicaoCozinha[1] == y)
		{
			return "Cozinha";
		}
		else if (posicaoJantar[0] == x && posicaoJantar[1] == y)
		{
			return "Sala de Jantar";
		}
		else if (posicaoEstar[0] == x && posicaoEstar[1] == y)
		{
			return "Sala de Estar";
		}
		else if (posicaoHall[0] == x && posicaoHall[1] == y)
		{
			return "Hall";
		}
		else if (posicaoEscritorio[0] == x && posicaoEscritorio[1] == y)
		{
			return "Escritório";
		}
		else if (posicaoBiblioteca[0] == x && posicaoBiblioteca[1] == y)
		{
			return "Biblioteca";
		}
		else if (posicaoJogos[0] == x && posicaoJogos[1] == y)
		{
			return "Salão de Jogos";
		}
		else if (posicaoInverno[0] == x && posicaoInverno[1] == y)
		{
			return "Jardim de Inverno";
		}
		else if (posicaoMusica[0] == x && posicaoMusica[1] == y)
		{
			return "Sala de Música";
		}
		else
		{
			return "";
		}
	}
	
	public String getSalaDaPorta(int x, int y)
	{	
		int[] posicao = {x, y};
		
		if (Arrays.equals(portaCozinha, posicao))
		{
			return "Cozinha";
		}
		if (Arrays.equals(portaJantar, posicao) || Arrays.equals(portaJantar2, posicao))
		{
			return "Sala de Jantar";
		}
		if (Arrays.equals(portaEstar, posicao))
		{
			return "Sala de Estar";
		}
		if (Arrays.equals(portaHall, posicao) || Arrays.equals(portaHall2, posicao) || 
			Arrays.equals(portaHall3, posicao))
		{
			return "Hall";
		}
		if (Arrays.equals(portaEscritorio, posicao))
		{
			return "Escritório";
		}
		if (Arrays.equals(portaBib, posicao) || Arrays.equals(portaBib2, posicao))
		{
			return "Biblioteca";
		}
		if (Arrays.equals(portaJogos, posicao) || Arrays.equals(portaJogos2, posicao))
		{
			return "Salão de Jogos";
		}
		if (Arrays.equals(portaInverno, posicao))
		{
			return "Jardim de Inverno";
		}
		if (Arrays.equals(portaMusica, posicao) || Arrays.equals(portaMusica2, posicao) ||
			Arrays.equals(portaMusica3, posicao) || Arrays.equals(portaMusica4, posicao))
		{
			return "Sala de Música";
		}
		else
		{
			return "";
		}
	}
	
	public String passagemSecreta(int[] posicao)
	{
		if (Arrays.equals(posicaoCozinha, posicao))
		{
			return "Cozinha";
		}
		else if (Arrays.equals(posicaoEstar, posicao))
		{
			return "Sala de Estar";
		}
		else if (Arrays.equals(posicaoEscritorio, posicao))
		{
			return "Escritório";
		}
		else if (Arrays.equals(posicaoInverno, posicao))
		{
			return "Jardim de Inverno";
		}
		else
		{
			return "";
		}
	}
	
	
 	public int[] destinoPassagem(int x, int y) 
 	{
 		if (posicaoCozinha[0] == x && posicaoCozinha[1] == y)
 			return posicaoEscritorio;
 		else if (posicaoEscritorio[0] == x && posicaoEscritorio[1] == y)
 			return posicaoCozinha;
 		else if (posicaoEstar[0] == x && posicaoEstar[1] == y)
 			return posicaoInverno;
 		else if (posicaoInverno[0] == x && posicaoInverno[1] == y)
 			return posicaoEstar;
 		
 		else
 		{
 			return null;
 		}
 	}
			
	
	public boolean verificaPos(int x, int y)
	{
		if (x > 26 || x < 0 || y > 25 || y < 0)
		{
			return false;
		}
		else if (tab_tiles[x][y] == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void ocupaPos(int x, int y)
	{
		tab_tiles[x][y] = 0;
	}
	
	public void desocupaPos(int x, int y)
	{
		tab_tiles[x][y] = 1;
	}
	
	public ArrayList<int[]> getPortas(int x, int y)
	{
		ArrayList<int[]> resp = new ArrayList<int[]>();
		
		if (posicaoCozinha[0] == x && posicaoCozinha[1] == y)
		{
			resp.add(portaCozinha);
		}
		else if (posicaoJantar[0] == x && posicaoJantar[1] == y)
		{
			resp.add(portaJantar);
			resp.add(portaJantar2);

		}
		else if (posicaoEstar[0] == x && posicaoEstar[1] == y)
		{
			resp.add(portaEstar);
		}
		else if (posicaoHall[0] == x && posicaoHall[1] == y)
		{
			resp.add(portaHall);
			resp.add(portaHall2);
			resp.add(portaHall3);

		}
		else if (posicaoEscritorio[0] == x && posicaoEscritorio[1] == y)
		{
			resp.add(portaEscritorio);
		}
		else if (posicaoBiblioteca[0] == x && posicaoBiblioteca[1] == y)
		{
			resp.add(portaBib);
			resp.add(portaBib2);
		}
		else if (posicaoJogos[0] == x && posicaoJogos[1] == y)
		{
			resp.add(portaJogos);
			resp.add(portaJogos2);
		}
		else if (posicaoInverno[0] == x && posicaoInverno[1] == y)
		{
			resp.add(portaInverno);
		}
		else if (posicaoMusica[0] == x && posicaoMusica[1] == y)
		{
			resp.add(portaMusica);
			resp.add(portaMusica2);
			resp.add(portaMusica3);
			resp.add(portaMusica4);
		}
		else
		{
			return null;
		}
		return resp;
	}
		
	
	public int[][] getTiles()
	{
		return tab_tiles;
	}
	
	
	public int[] tilesSalas(int x, int y)
	{
		if (13 >= x && x >= 9 && 24 >= y && y >= 19)
		{
			return posicaoJogos;
		}
		if ((5 >= x && x >= 2 && 24 >= y && y >= 19) || (x == 6 && 23 >= y && y >= 20))
		{
			return posicaoInverno;
		}
		if ((8 >= x && x >= 3 && 16 >= y && y >= 9) || (x == 2 && 14 >= y && y >= 11))
		{
			return posicaoMusica;
		}
		if ((6 >= x && x >= 1 && 6 >= y && y >= 1) || (x == 7 && 6 >= y && y >= 2))
		{
			return posicaoCozinha;
		}
		if ((16 >= x && x >= 11 && 8 >= y && y >= 1) || (x == 10 && 5 >= y && y >= 1))
		{
			return posicaoJantar;
		}
		if ((24 >= x && x >= 20 && 7 >= y && y >= 1) || (x == 25 && 6 >= y && y >= 1))
		{
			return posicaoEstar;
		}
		if ((24 >= x && x >= 19 && 15 >= y && y >= 10) || (x == 25 && 14 >= y && y >= 11))
		{
			return posicaoHall;
		}
		if ((25 >= x && x >= 22 && 24 >= y && y >= 19) || (y == 18 && 24 >= x && x >= 22))
		{
			return posicaoEscritorio;
		}
		if ((18 >= x && x >= 16 && 24 >= y && y >= 18) || (x == 15 && 23 >= y && y >= 19) || (x == 19 && 23 >= y && y >= 19))
		{
			return posicaoBiblioteca;
		}
		
		return null;
	}
}
