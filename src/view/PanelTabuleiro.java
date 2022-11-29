package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PanelTabuleiro extends JPanel{
	
	Image i;
	public PanelTabuleiro(Image img)
	{
		i = img;
	}
			
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(i, 0, -20, 930, 700, this);
	}
}
