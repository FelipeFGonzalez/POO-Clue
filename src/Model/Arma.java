package Model;

class Arma {
	private String sala;
	private String tipo;
	
	public Arma(String salaInicio, String tipoArma)
	{
		sala = salaInicio;
		tipo = tipoArma;
	}
	
	public void moveArma(String salaNova)
	{
		sala = salaNova;
	}
	
	public String getSala()
	{
		return sala;
	}
	
	public String getTipo()
	{
		return tipo;
	}
}
