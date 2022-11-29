package view;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import Controller.Acusar;
import Controller.ChamadaGS;
import Controller.MovimentacaoSus;
import Controller.Turnos;
import Model.GameStart;

public class botaoConfirmarAcusacao implements ActionListener
{
	Component c;
	Component tj;
	ArrayList<JComboBox> selecoesSalvas;
	
	public botaoConfirmarAcusacao(Component x, ArrayList<JComboBox> selecoes, Component telaJ)
	{
		c = x;
		tj = telaJ;
		selecoesSalvas = selecoes;
	}
	
	public void actionPerformed(ActionEvent e)
	{	
		if (Acusar.verificar(selecoesSalvas.get(0).getSelectedItem()+"", selecoesSalvas.get(1).getSelectedItem()+"", 
									   selecoesSalvas.get(2).getSelectedItem()+""))
		{
			tj.setVisible(false);
			((Window) tj).dispose();
			TelaFimJogo tfj = new TelaFimJogo("Fim de Jogo", ChamadaGS.getP(), selecoesSalvas.get(0).getSelectedItem()+"",
					selecoesSalvas.get(1).getSelectedItem()+"", selecoesSalvas.get(2).getSelectedItem()+"");
		}
		else
		{
			
			String salaBloqueada = ChamadaGS.jogadorBloqueandoPorta();
			if (salaBloqueada != "")
			{
				int[] posicaoFinal = GameStart.getJogo().getPosSala(salaBloqueada);
				
				
				MovimentacaoSus mv = new MovimentacaoSus(posicaoFinal[0], posicaoFinal[1], 
						GameStart.getJogo().getNumSuspeito(GameStart.getJogo().getPlayerAtual(Turnos.getTurno())));
				GameStart.getJogo().movimentaJogador(Turnos.getTurno(), posicaoFinal[0], posicaoFinal[1]);
			}
			
			Acusar.eliminar();
			
			
			
		}
		
		
		c.setVisible(false);
		((Window) c).dispose();
	}
}
