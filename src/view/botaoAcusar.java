package view;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.Turnos;
import Model.GameStart;

public class botaoAcusar implements ActionListener
{
	TelaJogo t;

	
	public botaoAcusar(TelaJogo telajogo)
	{
		t = telajogo;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		new TelaAcusar("Acusar", (Component)t);
	}
}
