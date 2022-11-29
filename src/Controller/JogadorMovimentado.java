package Controller;

public class JogadorMovimentado {
	static boolean[] estados = new boolean[6];
	
	
	static public void atualizaTrue(int i)
	{
		estados[i] = true;
	}
	
	static public void atualizaFalse(int i)
	{
		estados[i] = false;
	}
	
	static public boolean getEstado(int i)
	{
		return estados[i];
	}
}
