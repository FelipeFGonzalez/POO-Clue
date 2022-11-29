package Model;

class Envelope {
	private Carta cartaSuspeito;
	private Carta cartaArma;
	private Carta cartaSala;
	
	public Envelope(Carta sus, Carta a, Carta sala)
	{
		cartaSuspeito = sus;
		cartaArma = a;
		cartaSala = sala;
	}
	
	public boolean verificaResposta(String sus, String a, String sala)
	{
		return a.equals(cartaArma.getPista()) && sus.equals(cartaSuspeito.getPista()) && sala.equals(cartaSala.getPista());
	}
	
	public String[] getResposta()
	{
		String[] resp = {cartaSuspeito.getPista(), cartaArma.getPista(), cartaSala.getPista()};
		return resp;
	}
}
