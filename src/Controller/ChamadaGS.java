package Controller;

import java.util.ArrayList;

import Model.GameStart;
import view.TelaJogo;

public class ChamadaGS {

	public static boolean[] getBloco()
	{
		return GameStart.getJogo().getBlocoJogador(Turnos.getTurno());
	}
	
	public static void atualizaBloco(boolean[] listaEstados)
	{
		GameStart.getJogo().atualizaBloco(Turnos.getTurno(), listaEstados);
	}
	
	public static ArrayList<String> getCartas()
	{
		return GameStart.getJogo().getCartasAtuais(Turnos.getTurno());
	}
	
	public static void movePassagemSecreta()
	{
		int[] novaPos = GameStart.getJogo().movePassagemSecreta(Turnos.getTurno());
		
		MovimentacaoSus mvs = new MovimentacaoSus(novaPos[0], novaPos[1], 
				GameStart.getJogo().getNumSuspeito(GameStart.getJogo().getPlayerAtual(Turnos.getTurno())));
		TelaJogo.getTelaJogo().bloquearMov();
		TelaJogo.getTelaJogo().bloquearPS();
		TelaJogo.getTelaJogo().permitirPalpite();
		TelaJogo.getTelaJogo().permitirProx();
		TelaJogo.getTelaJogo().bloquearSalvamento();
	}
	
	public static String getSala()
	{
		return GameStart.getJogo().getSalaAtual(Turnos.getTurno());
	}
	
	public static int numP()
	{
		return GameStart.getJogo().getNumPlayers();
	}
	
	public static String getP()
	{
		return GameStart.getJogo().getPlayerAtual(Turnos.getTurno());
	}
	
	
	public static int[] getPosSus(int i)
	{
		return GameStart.getJogo().getPosSus(i);
	}
	
	
	public static String jogadorBloqueandoPorta()
	{
		return GameStart.getJogo().getBloqueandoPorta(Turnos.getTurno());
	}
}
