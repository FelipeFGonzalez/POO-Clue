package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PanelDado extends JPanel{
	
	Image i;
	public PanelDado()
	{
		i = null;
	}
	
	public void atualizaImagem(Image img)
	{
		i = img;
	}
			
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(i, 0, 0, this);
	}
}
