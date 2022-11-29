package Model;

class Dado {
	private java.util.Random random = new java.util.Random();
	private int roll;
	
	public void setValor(int valor) 
	{
		roll = valor;
	}
	public int getRoll()
	{
		return roll;
	}
	public void rolar()
	{
		roll = random.nextInt(6) + 1;
	}
}
