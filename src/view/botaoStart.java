package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class botaoStart implements ActionListener 
{
	Component c;
	
	public botaoStart(Component x)
	{
		c = x;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		c.setVisible(false);
		((Window) c).dispose();
		TelaPersonagens p = new TelaPersonagens("Suspeitos");
	}
}
