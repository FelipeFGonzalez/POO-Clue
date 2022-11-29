package Controller;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import Model.GameStart;
import view.TelaJogo;

public class Movimento {
	private static boolean flag = false;
	private static int passos;
	
	public static void setFlag(boolean estado)
	{
		flag = estado;
	}
	
	public static boolean getFlag()
	{
		return flag;
	}
	
	public static void setPassos(int p)
	{
		passos = p;
	}
	
	public static int getPassos()
	{
		return passos;
	}
	
	
	public static void tentaMovimento(int x, int y)
	{
		if (flag == false)
			return;
		
		int[] posicaoFinal = GameStart.getJogo().getTilesSalas(x, y);
		
		if (GameStart.getJogo().ocupado(x, y) && posicaoFinal == null)
		{
			TelaJogo.getTelaJogo().mudarTextoMov("Casa ocupada");
			return;
		}
		
		if (posicaoFinal == null)
		{
			int[] pos = {x, y};
			posicaoFinal = pos;
		}
		
		int[] posicao = GameStart.getJogo().getPosicaoPlayerAtual(Turnos.getTurno());
		
		if (posicao[0] == posicaoFinal[0] && posicao[1] == posicaoFinal[1])
		{
			TelaJogo.getTelaJogo().mudarTextoMov("É necessário sair da sala!");
			return;
		}
		
		ArrayList<int[]> listaPortas = GameStart.getJogo().getPortasTab(posicao[0], posicao[1]);
		ArrayList<int[]> listaPortasObjetivo = GameStart.getJogo().getPortasTab(posicaoFinal[0], posicaoFinal[1]);
		
		if (listaPortas == null)
		{
			listaPortas = new ArrayList<int[]>();
			listaPortas.add(posicao);
		}
		else 
		{
			boolean ver = true;
			for (int i = 0; i < listaPortas.size(); i++)
			{
				ver = ver && GameStart.getJogo().ocupado(listaPortas.get(i)[0], listaPortas.get(i)[1]);
			}
			if (ver)
			{
				TelaJogo.getTelaJogo().mudarTextoMov("Todas as saídas ocupadas!");
				return;
			}
		}
		
		if (listaPortasObjetivo == null)
		{
			listaPortasObjetivo = new ArrayList<int[]>();
			int[] objetivo = {posicaoFinal[0], posicaoFinal[1]};
			listaPortasObjetivo.add(objetivo);
		}
		else
		{
			boolean ver = true;
			for (int i = 0; i < listaPortasObjetivo.size(); i++)
			{
				ver = ver && GameStart.getJogo().ocupado(listaPortasObjetivo.get(i)[0], listaPortasObjetivo.get(i)[1]);
				if (listaPortas.get(0)[0] == listaPortasObjetivo.get(i)[0] && listaPortas.get(0)[1] == listaPortasObjetivo.get(i)[1])
				{
					ver = false;
				}
			}
			if (ver)
			{
				TelaJogo.getTelaJogo().mudarTextoMov("Todas as entradas ocupadas!");
				return;
			}
		}
		
		
		for (int j = 0; j < listaPortasObjetivo.size(); j++)
		{

			boolean verificacao = false;
			for (int i = 0; i < listaPortas.size(); i++)
			{
				int passosNecessarios = retornaCaminho(GameStart.getJogo().getTabTiles(), listaPortas.get(i)[0], listaPortas.get(i)[1], listaPortasObjetivo.get(j)[0], listaPortasObjetivo.get(j)[1]);
				verificacao = verificacao || (passosNecessarios <= passos && passosNecessarios != -1);
			}
			if (verificacao)
			{		
				TelaJogo.getTelaJogo().mudarTextoMov("");
				MovimentacaoSus mv = new MovimentacaoSus(posicaoFinal[0], posicaoFinal[1], 
						GameStart.getJogo().getNumSuspeito(GameStart.getJogo().getPlayerAtual(Turnos.getTurno())));
				
				TelaJogo.getTelaJogo().permitirProx();
				if (GameStart.getJogo().getSalas(posicaoFinal[0], posicaoFinal[1]) != "")
				{
					TelaJogo.getTelaJogo().permitirPalpite();
				}
				
				
				
				flag = false;
				GameStart.getJogo().movimentaJogador(Turnos.getTurno(), posicaoFinal[0], posicaoFinal[1]);
				TelaJogo.getTelaJogo().terminaMovimento(posicaoFinal[0], posicaoFinal[1]);
				return;
			}
			else
			{
				continue;
			}
			
		}
		TelaJogo.getTelaJogo().mudarTextoMov("Movimento impossivel");
		return;
	}
	
	
	public static int retornaCaminho(int[][] tab_tiles, int xi, int yi, int xf, int yf) {
		  Queue<Node> queue = new ArrayDeque<>();
		  boolean[][] discovered = new boolean[27][25];
		  
		  discovered[xi][yi] = true;
		  queue.add(new Node(xi, yi, 0));
		  
		  
		  while (!queue.isEmpty()) 
		  {
			  Node node = queue.poll();
			  for (int i = 0; i < 4; i++)
			  {
				  int nx;
				  int ny;
				  
				  if (i < 2)
				  {
					  nx = node.x + i % 2;
					  ny = node.y + (i+1) % 2;
				  }
				  else
				  {
					  nx = node.x - i % 2;
					  ny = node.y - (i+1) % 2;
				  }
				  
				  int nd = node.dist + 1;
				  
				  if (nx == xf && ny == yf)
				  {
					  return nd;
				  }

				  if ((tab_tiles[nx][ny] == 1) && !discovered[nx][ny]) 
				  {
				        discovered[nx][ny] = true;
				        queue.add(new Node(nx, ny, nd));
				  }
				  
			  }
			  
		  }
		  return -1;
	}
	
	private static class Node {
		final int x;
		final int y;
		final int dist;
		 
		public Node(int x, int y, int dist) {
			this.x = x;
		    this.y = y;
		    this.dist = dist;
		}
	}
}
