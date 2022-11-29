package Controller;

import Model.GameStart;
import view.TelaPalpite;
import view.TelaRPalpite;

public class Palpite {

	public static void confirmacaoPalpite(String suspeito, String arma, String sala, TelaPalpite t) 
	{
		int[] posSala = GameStart.getJogo().getPosSala(sala);
		int numSuspeito = GameStart.getJogo().getNumSuspeito(suspeito);
		int[] posSuspeito = GameStart.getJogo().getPosSus(numSuspeito);
		GameStart.getJogo().movimentaSuspeito(numSuspeito, posSala[0], posSala[1]);

		if (posSuspeito[0] != posSala[0] || posSuspeito[1] != posSala[1])
		{
			JogadorMovimentado.atualizaTrue(numSuspeito);
		}
		
		MovimentacaoSus mvs = new MovimentacaoSus(posSala[0], posSala[1], numSuspeito);
		GameStart.getJogo().movimentaArma(arma, sala);
		
		int i = Turnos.getTurno() + 1;
		String msg = "Nenhum jogador refutou o seu palpite!";
		while (i != Turnos.getTurno())
		{
			if (i == GameStart.getJogo().getNumPlayers())
				i = 0;
			
			if (GameStart.getJogo().getCarta(i, suspeito))
			{	
				msg = suspeito + " refutado por " + GameStart.getJogo().getPlayerAtual(i);
				TelaRPalpite tr = new TelaRPalpite("Palpite", msg);
				t.setVisible(false);
				t.dispose();
				Botoes.habilitar(false, false, true, false, true);
				return;
			}
			if (GameStart.getJogo().getCarta(i, arma))
			{
				msg = arma + " refutado por " + GameStart.getJogo().getPlayerAtual(i);
				TelaRPalpite tr = new TelaRPalpite("Palpite", msg);
				t.setVisible(false);
				t.dispose();
				Botoes.habilitar(false, false, true, false, true);
				return;
			}
			if (GameStart.getJogo().getCarta(i, sala))
			{
				msg = sala + " refutado por " + GameStart.getJogo().getPlayerAtual(i);
				TelaRPalpite tr = new TelaRPalpite("Palpite", msg);
				t.setVisible(false);
				t.dispose();
				Botoes.habilitar(false, false, true, false, true);
				return;
			}
			i++;
		}
		
		Botoes.habilitar(false, false, true, false, true);
		
		TelaRPalpite tr = new TelaRPalpite("Palpite", msg);
	}
}
