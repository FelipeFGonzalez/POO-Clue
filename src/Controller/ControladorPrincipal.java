package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.GameStart;
import view.TelaJogo;

public class ControladorPrincipal {

	public ControladorPrincipal(boolean[] estados)
	{
		GameStart jogo = GameStart.getJogo(estados);
		TelaJogo telaJogo = TelaJogo.getTelaJogo();
		
	}
	
	public ControladorPrincipal(String arq)
	{
		String[] resposta = new String[3];
		int numPl = 0;
		ArrayList<String> nomePlayers = new ArrayList<String>();
		ArrayList<boolean[]> blocosPl = new ArrayList<boolean[]>();
		ArrayList<ArrayList<String>> cartasPl = new ArrayList<ArrayList<String>>();
		ArrayList<Boolean> eliminadosPl = new ArrayList<Boolean>();
		
		ArrayList<String> salaArmas = new ArrayList<String>();
		ArrayList<int[]> posSuspeitos = new ArrayList<int[]>();
		int turno = 0;
		boolean palp = false;
		
		Scanner s = null;
		
		try {
			s = new Scanner(new File(arq));
			
			resposta[0] = s.nextLine();
			resposta[1] = s.nextLine();
			resposta[2] = s.nextLine();
			numPl = Integer.parseInt(s.nextLine());
			for (int i = 0; i < numPl; i++)
			{
				nomePlayers.add(s.nextLine());
				String bloco = s.nextLine();
				String[] bloco_sep = bloco.split(",");
				boolean[] bloco_bool = new boolean[21];
				for (int j = 0; j < 21; j++)
				{
					bloco_bool[j] = bloco_sep[j].equals("true");
				}
				blocosPl.add(bloco_bool);
				
				String cartas = s.nextLine();
				String[] cartas_sep = cartas.split(",");
				ArrayList<String> cartas_finais = new ArrayList<String>();
				for (int j = 0; j < cartas_sep.length; j++)
				{
					cartas_finais.add(cartas_sep[j]);
				}
				cartasPl.add(cartas_finais);
				
				String eliminado = s.nextLine();
				eliminadosPl.add(eliminado.equals("true"));
			}
			
			for (int k = 0; k < 6; k++)
				salaArmas.add(s.nextLine());
			
			for (int p = 0; p < 6; p++)
			{
				String[] pos = s.nextLine().split(",");
				int[] pos_int = {Integer.parseInt(pos[0]), Integer.parseInt(pos[1])};
				posSuspeitos.add(pos_int);
			}
			
			turno = Integer.parseInt(s.nextLine());
			palp = s.nextLine().equals("true");
			
			s.close();
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		
		GameStart jogo = GameStart.getJogo(resposta, numPl, nomePlayers, blocosPl, cartasPl, eliminadosPl, salaArmas);
		TelaJogo telaJogo = TelaJogo.getTelaJogo();
		

		for (int t = 0; t < 6; t++)
		{
			GameStart.getJogo().movimentaSuspeito(t, posSuspeitos.get(t)[0], posSuspeitos.get(t)[1]);
			MovimentacaoSus mvs = new MovimentacaoSus(posSuspeitos.get(t)[0], posSuspeitos.get(t)[1], t);
		}
		
		Turnos.setTurno(turno);
		if (palp)
			TelaJogo.getTelaJogo().permitirPalpite();
		
	}
	
}
