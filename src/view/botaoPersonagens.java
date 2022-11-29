package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Controller.ControladorPrincipal;

import java.util.*;

public class botaoPersonagens implements ActionListener
{
	Component c;
	ArrayList<JCheckBox> botoesSalvos = new ArrayList<JCheckBox>();
	
	public botaoPersonagens(Component x, ArrayList<JCheckBox> botoes)
	{
		c = x;
		botoesSalvos = botoes;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		boolean[] estados = new boolean[6];
		for (int i = 0; i < 6; i++)
		{
			estados[i] = botoesSalvos.get(i).isSelected();
		}
		
		
		
		
		c.setVisible(false);
		((Window) c).dispose();
		ControladorPrincipal cp = new ControladorPrincipal(estados);
	}
}
