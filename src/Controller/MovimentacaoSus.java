package Controller;


import view.TelaJogo;

public class MovimentacaoSus implements ObservableCont
{
	private int x;
	private int y;
	private int idxSus;
	
	
	public MovimentacaoSus(int x, int y, int idx)
	{
		this.x = x;
		this.y = y;
		this.idxSus = idx;
		
		TelaJogo.getTelaJogo().notify(this);
	}
	
	public int[] get()
	{
		int[] a = {idxSus, x, y};
		return a;
	}
}
