package Controller;

import Model.GameStart;
import view.TelaJogo;

public class ContDados implements ObservableCont {

	int dado1;
	int dado2;
	public void rolarDados() 
	{
		dado1 = GameStart.getJogo().rolarDado1();
		dado2 = GameStart.getJogo().rolarDado2();
		
		TelaJogo.getTelaJogo().notifyDados();
		
		Movimento.setPassos(dado1 + dado2);
		Movimento.setFlag(true);
	}
	
	public void definirDados(int d1, int d2)
	{
		dado1 = d1;
		dado2 = d2;
		
		TelaJogo.getTelaJogo().notifyDados();
		
		Movimento.setPassos(dado1 + dado2);
		Movimento.setFlag(true);
	}
	
	public int[] get()
	{
		int[] r = {dado1, dado2};
		return r;
	}
}
