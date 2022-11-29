package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PanelCarta extends JPanel{
	
	Image i;
	public PanelCarta(Image img)
	{
		i = img;
	}
			
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(i, 0, 0, 186, 328, this);
	}
}
