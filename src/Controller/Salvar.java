package Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import Model.GameStart;
import view.TelaJogo;

public class Salvar {
	
	public static void realizaSalvamento()
	{
		String[] resposta = GameStart.getJogo().getRespostaEnv();
		int numPl = GameStart.getJogo().getNumPlayers();
		ArrayList<String> nomePlayers = GameStart.getJogo().getNomesPlayers(); 
		ArrayList<boolean[]> blocosPl = GameStart.getJogo().getBlocosPlayers();
		ArrayList<ArrayList<String>> cartasPl = GameStart.getJogo().getCartasPlayers();
		ArrayList<Boolean> eliminadosPl = GameStart.getJogo().getPlayersEliminados();
		
		ArrayList<String> salaArmas = GameStart.getJogo().getSalasArmas();
		ArrayList<int[]> posSuspeitos = GameStart.getJogo().getPosSuspeitos();
		int turno = Turnos.getTurno();
		boolean palp = TelaJogo.getTelaJogo().statusPalp();
		
		
		String localArq = "";
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		fc.setFileFilter(filter);
		int r = fc.showSaveDialog(null);
		if (r == JFileChooser.APPROVE_OPTION)	 
        {
			localArq = fc.getSelectedFile().getAbsolutePath();
        }
		
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter(localArq));
			out.write(resposta[0] + "\n" + resposta[1] + "\n" + resposta[2] + "\n");
			out.write(Integer.toString(numPl) + "\n");
			for (int i = 0; i < numPl; i++)
			{
				out.write(nomePlayers.get(i) + "\n");
				for (int j = 0; j < blocosPl.get(i).length; j++)
				{
					out.write(Boolean.toString(blocosPl.get(i)[j]) + ",");
				}
				out.write("\n");
				for (int j = 0; j < cartasPl.get(i).size(); j++)
				{
					out.write(cartasPl.get(i).get(j) + ",");
				}
				out.write("\n");
				
				out.write(eliminadosPl.get(i) + "\n");
			}
			
			for (int i = 0; i < salaArmas.size(); i++)
			{
				out.write(salaArmas.get(i) + "\n");
			}
			
			for (int i = 0; i < posSuspeitos.size(); i++)
			{
				out.write(Integer.toString(posSuspeitos.get(i)[0]) + "," + Integer.toString(posSuspeitos.get(i)[1]) + "\n");
			}
			
			out.write(turno + "\n" + palp + "\n");
			
			out.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		
		
		

	}
}
