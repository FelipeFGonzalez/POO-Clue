package Model;

import java.util.*;

import view.TelaJogo;

public class GameStart {
	private static GameStart ctrl = null;
	private int cont;
	ArrayList<Jogador> lista = new ArrayList<Jogador>();
	ArrayList<Suspeito> listaSus = new ArrayList<Suspeito>();
	Tabuleiro tab = new Tabuleiro();
	Dado dado1 = new Dado();
	Dado dado2 = new Dado();
	Envelope envelopeResposta;
	ArrayList<Arma> lista_armas = new ArrayList<Arma>();
	
	
	
	public static GameStart getJogo(boolean[] estados)
	{
		if (ctrl == null)
		{
			ctrl = new GameStart(estados);
		}
		return ctrl;
	}
	
	public static GameStart getJogo(String[] resposta, int numPl, ArrayList<String> nomePlayers, ArrayList<boolean[]> blocosPl,
			ArrayList<ArrayList<String>> cartasPl, ArrayList<Boolean> eliminadosPl, ArrayList<String> salaArmas)
	{
		if (ctrl == null)
		{
			ctrl = new GameStart(resposta, numPl, nomePlayers, blocosPl, cartasPl, eliminadosPl, salaArmas);
		}
		return ctrl;
	}
	
	public static GameStart getJogo()
	{
		return ctrl;
	}
	
	
	private GameStart(boolean[] estados)
	{	
		// Cria Jogadores
		if (estados[0] == true)
		{
			Jogador PlayerG = new Jogador("Coronel Mustard");
			lista.add(PlayerG);
			listaSus.add(PlayerG);
		}
		else
		{
			Suspeito SuspeitoG = new Suspeito("Coronel Mustard");
			listaSus.add(SuspeitoG);
		}
		if (estados[1] == true)
		{
			Jogador PlayerM = new Jogador("Professor Plum");
			lista.add(PlayerM);
			listaSus.add(PlayerM);
		}
		else
		{
			Suspeito SuspeitoM = new Suspeito("Professor Plum");
			listaSus.add(SuspeitoM);
		}
		if (estados[2] == true)
		{
			Jogador PlayerPc = new Jogador("Reverendo Green");
			lista.add(PlayerPc);
			listaSus.add(PlayerPc);
		}
		else
		{
			Suspeito SuspeitoPc = new Suspeito("Reverendo Green");
			listaSus.add(SuspeitoPc);
		}
		if (estados[3] == true)
		{
			Jogador PlayerPl = new Jogador("Sra. Peacock");
			lista.add(PlayerPl);
			listaSus.add(PlayerPl);
		}
		else
		{
			Suspeito SuspeitoPl = new Suspeito("Sra. Peacock");
			listaSus.add(SuspeitoPl);
		}
		if (estados[4] == true)
		{
			Jogador PlayerW = new Jogador("Sra. White");
			lista.add(PlayerW);
			listaSus.add(PlayerW);
		}
		else
		{
			Suspeito SuspeitoW = new Suspeito("Sra. White");
			listaSus.add(SuspeitoW);
		}
		if (estados[5] == true)
		{
			Jogador PlayerS = new Jogador("Srta. Scarlet");
			lista.add(PlayerS);
			listaSus.add(PlayerS);
			// Coloca Srta. Scarlet na primeia posicao da lista
			Collections.swap(lista, lista.indexOf(PlayerS), 0);
		}
		else
		{
			Suspeito SuspeitoS = new Suspeito("Srta. Scarlet");
			listaSus.add(SuspeitoS);
		}
		cont = Jogador.getCount();		
		
		
		// Cria as listas de cartas
		ArrayList<Carta> cartas_arma = new ArrayList<Carta>();
		ArrayList<Carta> cartas_sus = new ArrayList<Carta>();
		ArrayList<Carta> cartas_sala = new ArrayList<Carta>();
		
		Carta carta_corda = new Carta("Arma", "Corda");
		Carta carta_cano = new Carta("Arma", "Cano de Chumbo");
		Carta carta_faca = new Carta("Arma", "Faca");
		Carta carta_chave = new Carta("Arma", "Chave Inglesa");
		Carta carta_cast = new Carta("Arma", "Castiçal");
		Carta carta_rev = new Carta("Arma", "Revólver");
		Collections.addAll(cartas_arma, carta_corda, carta_cano, carta_faca, 
				carta_chave, carta_cast, carta_rev);
		
				
		Carta carta_white = new Carta("Suspeito", "Sra. White");
		Carta carta_scarlet = new Carta("Suspeito", "Srta. Scarlet");
		Carta carta_mustard = new Carta("Suspeito", "Coronel Mustard");
		Carta carta_plum = new Carta("Suspeito", "Professor Plum");
		Carta carta_peacock = new Carta("Suspeito", "Sra. Peacock");
		Carta carta_green = new Carta("Suspeito", "Reverendo Green");
		Collections.addAll(cartas_sus, carta_white, carta_scarlet, carta_mustard, 
				carta_plum, carta_peacock, carta_green);
		
		Carta carta_cozinha = new Carta("Sala", "Cozinha");
		Carta carta_jantar = new Carta("Sala", "Sala de Jantar");
		Carta carta_estar = new Carta("Sala", "Sala de Estar");
		Carta carta_hall = new Carta("Sala", "Hall");
		Carta carta_esc = new Carta("Sala", "Escritório");
		Carta carta_bibl = new Carta("Sala", "Biblioteca");
		Carta carta_jogos = new Carta("Sala", "Salão de Jogos");
		Carta carta_musica = new Carta("Sala", "Jardim de Inverno");
		Carta carta_festas = new Carta("Sala", "Sala de Música");
		Collections.addAll(cartas_sala, carta_cozinha, carta_jantar, carta_estar, 
				carta_hall, carta_esc, carta_bibl, carta_jogos, carta_musica, carta_festas);

		
		
		// Cria as armas
		Collections.shuffle(cartas_sala);
		for (int i = 0; i < 6; i++)
		{
			Arma novaArma = new Arma(cartas_sala.get(i).getPista(), cartas_arma.get(i).getPista());
			lista_armas.add(novaArma);
		}
		
		// Randomiza a resposta
		java.util.Random random = new java.util.Random();
		int randomArma = random.nextInt(6);
		int randomSus = random.nextInt(6);
		int randomSala = random.nextInt(9);
		
		envelopeResposta = new Envelope(cartas_sus.get(randomSus),
										cartas_arma.get(randomArma),
										cartas_sala.get(randomSala));
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println(cartas_sus.get(randomSus).getPista());
		System.out.println(cartas_arma.get(randomArma).getPista());
		System.out.println(cartas_sala.get(randomSala).getPista());
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// Remove a resposta das listas de cartas
		cartas_arma.remove(randomArma);
		cartas_sus.remove(randomSus);
		cartas_sala.remove(randomSala);

		ArrayList<Carta> all_cartas = new ArrayList<Carta>();
		all_cartas.addAll(cartas_arma);
		all_cartas.addAll(cartas_sus);
		all_cartas.addAll(cartas_sala);
		
		// Distribui as cartas entre os jogadores
		Collections.shuffle(all_cartas);
		for (int i = 0; i < 18; i++)
		{
			lista.get(i % cont).recebeCartas(all_cartas.get(i));
		}
	}
	
	
	private GameStart(String[] resposta, int numPl, ArrayList<String> nomePlayers, ArrayList<boolean[]> blocosPl,
			ArrayList<ArrayList<String>> cartasPl, ArrayList<Boolean> eliminadosPl, ArrayList<String> salaArmas)
	{
		cont = numPl;
		Carta resp1 = new Carta("Suspeito", resposta[0]);
		Carta resp2 = new Carta("Arma", resposta[1]);
		Carta resp3 = new Carta("Sala", resposta[2]);
		envelopeResposta = new Envelope(resp1, resp2, resp3);
		for (int i = 0; i < numPl; i++)
		{
			lista.add(new Jogador(nomePlayers.get(i)));
			lista.get(i).getBloco().atualiza(blocosPl.get(i));
			for (int j = 0; j < cartasPl.get(i).size(); j++)
			{
				String tipo = "Sala";
				String pista = cartasPl.get(i).get(j);
				
				if (pista.equals("Reverendo Green") || pista.equals("Coronel Mustard") || pista.equals("Professor Plum") ||
						pista.equals("Sra. White") || pista.equals("Sra. Peacock") || pista.equals("Srta. Scarlet"))
				{
					tipo = "Suspeito";
				}
				else if (pista.equals("Faca") || pista.equals("Corda") || pista.equals("Castiçal") ||
						pista.equals("Revólver") || pista.equals("Chave Inglesa") || pista.equals("Cano de Chumbo"))
				{
					tipo = "Arma";
				}
				
				lista.get(i).recebeCartas(new Carta(tipo, pista));
			}
			
			if (eliminadosPl.get(i))
			{
				lista.get(i).eliminar();
			}
		}
		
		String[] listaNomesSus = {"Coronel Mustard", "Professor Plum", "Reverendo Green", "Sra. Peacock", "Sra. White", "Srta. Scarlet"};
		for (int i = 0; i < 6; i++)
		{
			if (nomePlayers.contains(listaNomesSus[i]))
			{
				listaSus.add(lista.get(nomePlayers.indexOf(listaNomesSus[i])));
			}
			else
			{
				listaSus.add(new Suspeito(listaNomesSus[i]));
			}
		}

		String[] nomesArmas = {"Corda", "Cano de Chumbo", "Faca", "Chave Inglesa", "Castiçal", "Revólver"};
		for (int i = 0; i < 6; i++)
		{
			lista_armas.add(new Arma(salaArmas.get(i), nomesArmas[i]));
		}
		
		
		
	}
	
	public String getPlayerAtual(int turno)
	{
		return lista.get(turno).getSus();
	}
	
	
	public int getNumPlayers()
	{
		return cont;
	}
	
	public boolean validaPassagemSecreta(int turno)
	{
		return (lista.get(turno).acessoPassagemSecreta(tab));
	}
	
	public int[] movePassagemSecreta(int turno)
	{
		int[] posicao = lista.get(turno).getPos();
		int[] destino = tab.destinoPassagem(posicao[0], posicao[1]);
		
		lista.get(turno).setPos(destino[0], destino[1]);
		return destino;
	}
	
	
	public boolean validaPalpite(int turno)
	{
		return (lista.get(turno).estaEmSala(tab));
	}
	
	
	public boolean verificaResposta(String sus, String a, String sala)
	{
		return envelopeResposta.verificaResposta(sus, a, sala);
	}
	
	
	public boolean estaEliminado(int turno)
	{
		return lista.get(turno).estaEliminado();
	}
	
	
	public void eliminar(int turno)
	{
		lista.get(turno).eliminar();
	}
	
	
	public boolean[] getBlocoJogador(int turno)
	{
		return lista.get(turno).getBloco().getEstados();
	}
	
	
	public void atualizaBloco(int turno, boolean[] estados)
	{
		lista.get(turno).getBloco().atualiza(estados);
	}
	
	
	public int rolarDado1()
	{
		dado1.rolar();
		return dado1.getRoll();
	}
	
	public int rolarDado2()
	{
		dado2.rolar();
		return dado2.getRoll();
	}
	
	
	public String getSalaAtual(int turno)
	{
		int[] pos = lista.get(turno).getPos();
		return tab.getSala(pos[0], pos[1]);
	}
	
	
	public boolean getCarta(int turno, String carta)
	{
		return lista.get(turno).verificaCartaString(carta);		
	}
	
	
	public ArrayList<String> getCartasAtuais(int turno)
	{
		return lista.get(turno).getCartasPath();
	}
	
	
	public void movimentaJogador(int turno, int x, int y)
	{
		int[] posicao = lista.get(turno).getPos();
		if (tab.getSala(posicao[0], posicao[1]) == "")
		{
			tab.desocupaPos(posicao[0], posicao[1]);
		}
		lista.get(turno).setPos(x, y);
		tab.ocupaPos(x, y);
	}
	
	
	public void movimentaSuspeito(int numSus, int x, int y)
	{
		int[] posicao = listaSus.get(numSus).getPos();
		
		if (tab.getSala(posicao[0], posicao[1]) == "")
		{
			tab.desocupaPos(posicao[0], posicao[1]);
		}
		listaSus.get(numSus).setPos(x, y);
		tab.ocupaPos(x, y);
	}
	
	
	public int[] getPosSala(String nomeSala)
	{
		return tab.getPosSala(nomeSala);
	}
	
	
	public void movimentaArma(String n, String sala)
	{
		if (n == "Corda")
		{
			lista_armas.get(0).moveArma(sala);
		}
		if (n == "Cano de Chumbo")
		{
			lista_armas.get(1).moveArma(sala);
		}
		if (n == "Faca")
		{
			lista_armas.get(2).moveArma(sala);
		}
		if (n == "Chave Inglesa")
		{
			lista_armas.get(3).moveArma(sala);
		}
		if (n == "Castiçal")
		{
			lista_armas.get(4).moveArma(sala);
		}
		if (n == "Revólver")
		{
			lista_armas.get(5).moveArma(sala);
		}
	}
	
	
	public int getNumSuspeito(String s)
	{
		if (s.equals("Coronel Mustard"))
		{
			return 0;
		}
		if (s.equals("Professor Plum"))
		{
			return 1;
		}
		if (s.equals("Reverendo Green"))
		{
			return 2;
		}
		if (s.equals("Sra. Peacock"))
		{
			return 3;
		}
		if (s.equals("Sra. White"))
		{
			return 4;
		}
		if (s.equals("Srta. Scarlet"))
		{
			return 5;
		}
		return -1;
	}
	
	
	public int[] getPosicaoPlayerAtual(int turno)
	{
		return lista.get(turno).getPos();
	}
	
	
	public int[] getPosSus(int idx)
	{
		return listaSus.get(idx).getPos();
	}
	
	
	public ArrayList<int[]> getPortasTab(int x, int y)
	{
		return tab.getPortas(x, y);
	}
	
	
	public int[][] getTabTiles()
	{
		return tab.getTiles();
	}
	
	public int[] getTilesSalas(int x, int y)
	{
		return tab.tilesSalas(x, y);
	}
	
	
	public boolean ocupado(int x, int y)
	{
		return !tab.verificaPos(x, y);
	}
	
	
	public String getSalas(int x, int y)
	{
		return tab.getSala(x, y);
	}
	
	
	public String[] getRespostaEnv()
	{
		return envelopeResposta.getResposta();
	}
	
	
	public ArrayList<String> getNomesPlayers()
	{
		ArrayList<String> n = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) 
		{
			n.add(lista.get(i).getSus());
		}
		return n;
	}
	
	public ArrayList<boolean[]> getBlocosPlayers()
	{
		ArrayList<boolean[]> b = new ArrayList<boolean[]>();
		for (int i = 0; i < lista.size(); i++) 
		{
			b.add(lista.get(i).getBloco().getEstados());
		}
		return b;
	}
	
	public ArrayList<ArrayList<String>> getCartasPlayers()
	{
		ArrayList<ArrayList<String>> c = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < lista.size(); i++) 
		{
			c.add(lista.get(i).getCartas());
		}
		return c;
	}
	
	
	public ArrayList<Boolean> getPlayersEliminados()
	{
		ArrayList<Boolean> el = new ArrayList<Boolean>();
		for (int i = 0; i < lista.size(); i++) 
		{
			el.add(lista.get(i).estaEliminado());
		}
		return el;
	}
	
	
	public ArrayList<String> getSalasArmas()
	{
		ArrayList<String> sa = new ArrayList<String>();
		for (int i = 0; i < lista_armas.size(); i++)
		{
			sa.add(lista_armas.get(i).getSala());
		}
		return sa;
	}
	
	
	public ArrayList<int[]> getPosSuspeitos()
	{
		ArrayList<int[]> p = new ArrayList<int[]>();
		for (int i = 0; i < listaSus.size(); i++) 
		{
			p.add(listaSus.get(i).getPos());
		}
		return p;
	}
	
	
	public String getBloqueandoPorta(int turno)
	{
		int[] pos = lista.get(turno).getPos();
		return (tab.getSalaDaPorta(pos[0], pos[1]));
	}
}
