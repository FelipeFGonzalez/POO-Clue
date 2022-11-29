package Controller;

import view.TelaJogo;

public class Botoes {
	
	public static void habilitar(boolean mov, boolean ps, boolean prox, boolean palp, boolean ac)
	{
		if (mov)
			TelaJogo.getTelaJogo().permitirMov();
		if (ps)
			TelaJogo.getTelaJogo().permitirPS();
		if (prox)
			TelaJogo.getTelaJogo().permitirProx();
		if (palp)
			TelaJogo.getTelaJogo().permitirPalpite();
		if (ac)
			TelaJogo.getTelaJogo().permitirAcusacao();
	}
	
}
