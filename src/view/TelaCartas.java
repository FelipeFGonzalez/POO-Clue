package view;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TelaCartas  extends JFrame
{
	public TelaCartas(String s, ArrayList<String> cartas)
	{
		super(s);
		setLayout(null);
		
		int x = 0;
		int y = 0;
		Container c = getContentPane();
		for (int i = 0; i < cartas.size(); i++)
		{
			Image img = null;
			try {
				img=ImageIO.read(new File("imagens/Imagens/" + cartas.get(i) + ".jpg"));
			}
			catch(IOException e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
			
			JPanel pcard = new PanelCarta(img);
			if (i == 3)
			{
				x = 0;
				y = 330;
			}
			pcard.setBounds(x, y, 186, 328);
			
			x+= 200;
			
			
			c.add(pcard);
		}
		
		setSize(600, 700);
		setVisible(true);
	}
}
