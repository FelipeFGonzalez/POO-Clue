package Model;

public class Suspeito {
	private String suspeito;
	private int posX;
	private int posY;
	
	public Suspeito(String sus)
	{
		suspeito = sus;
		
		if (sus == "Coronel Mustard")
			this.setPos(18, 1);
		if (sus == "Srta. Scarlet")
			this.setPos(25, 8);
		if (sus == "Professor Plum")
			this.setPos(20, 24);
		if (sus == "Reverendo Green")
			this.setPos(1, 15);
		if (sus == "Sra. White")
			this.setPos(1, 10);
		if (sus == "Sra. Peacock")
			this.setPos(7, 24);
	}
	
	public void setPos(int x, int y)
	{
		posX = x;
		posY = y;
	}
	
	public int[] getPos()
	{
		int[] posicao = {posX, posY};
		return posicao;
	}
	
	public String getSus()
	{
		return suspeito;
	}
}
