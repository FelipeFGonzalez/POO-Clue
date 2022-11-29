package Controller;

import java.util.ArrayList;

import Model.GameStart;
import view.TelaJogo;

public class Turnos {
	private static int turno = 0;
	
	public static int getTurno()
	{
		return turno;
	}
	
	public static void nextTurno()
	{
		do{
			turno++;
			if (turno == GameStart.getJogo().getNumPlayers())
				turno = 0;
		}while(GameStart.getJogo().estaEliminado(turno));
		
		
		String nome = GameStart.getJogo().getPlayerAtual(turno);
		int numSus = GameStart.getJogo().getNumSuspeito(nome);
		boolean ps = GameStart.getJogo().validaPassagemSecreta(turno);
		int[] posSus = GameStart.getJogo().getPosicaoPlayerAtual(turno);
		ArrayList<int[]> portas = GameStart.getJogo().getPortasTab(posSus[0], posSus[1]);
		boolean todasPortasOcupadas = false;
		if (portas != null)
		{
			todasPortasOcupadas = true;
			for (int i = 0; i < portas.size(); i++)
			{
				todasPortasOcupadas = todasPortasOcupadas && GameStart.getJogo().ocupado(portas.get(i)[0], portas.get(i)[1]);
			}
		}
		
		TelaJogo.getTelaJogo().proxTurno(nome, ps, JogadorMovimentado.getEstado(numSus), todasPortasOcupadas && !ps, 
				!todasPortasOcupadas);
		
		JogadorMovimentado.atualizaFalse(numSus);
	}
	
	
	public static void setTurno(int i)
	{
		turno = i;
	}
}
