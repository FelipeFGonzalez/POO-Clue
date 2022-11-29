package Model;

class Carta {
	private String tipo;
	private String pista;
	
	public Carta(String t, String p) {
		tipo = t;
		pista = p;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String getPista() {
		return pista;
	}
	
	public boolean equals(Carta c)
	{
		return tipo == c.tipo && pista == c.pista;
	}
}
