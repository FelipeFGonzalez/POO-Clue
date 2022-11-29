package Model;

class Bloco {
	private boolean[] listaEstados = new boolean[21];

	
	public void atualiza(boolean[] estados)
	{
		listaEstados = estados;
	}
	
	public boolean[] getEstados()
	{
		return listaEstados;
	}
			
}
