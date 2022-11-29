package view;
import javax.swing.*;

import Controller.Botoes;
import Model.GameStart;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class TelaAcusar extends JFrame
{
	String suspeitos[] = {"Coronel Mustard", "Professor Plum", "Reverendo Green", "Sra. Peacock", "Sra. White", "Srta. Scarlet"};
	String armas[] = {"Cano de Chumbo", "Castiçal", "Chave Inglesa", "Corda", "Faca", "Revólver"};
	String salas[] = {"Biblioteca", "Cozinha", "Escritório", "Hall", "Jardim de Inverno", "Sala de Estar", 
					  "Sala de Jantar", "Sala de Música", "Salão de Jogos"};
	
	JButton b1 = new JButton("Confirmar");
	JComboBox selecaoSus = new JComboBox(suspeitos);
	JComboBox selecaoArmas = new JComboBox(armas);
	JComboBox selecaoSalas = new JComboBox(salas);
	
	boolean mov;
	boolean prox;
	boolean palp;
	boolean ps;
	
	ArrayList<JComboBox> selecoes = new ArrayList<JComboBox>();
	
	
	public TelaAcusar(String s, Component x)
	{
		super(s);
		Collections.addAll(selecoes, selecaoSus, selecaoArmas, selecaoSalas);
		
		mov = TelaJogo.getTelaJogo().bloquearMov();
		prox = TelaJogo.getTelaJogo().bloquearProx();
		ps = TelaJogo.getTelaJogo().bloquearPS();
		palp = TelaJogo.getTelaJogo().bloquearPalpite();
		TelaJogo.getTelaJogo().bloquearAcusacao();
		
		
		setLayout(null);
		Container c = getContentPane();

		
		b1.addActionListener(new botaoConfirmarAcusacao(this, selecoes, x));
		addWindowListener(fechar);
		
		JLabel l1 = new JLabel("Suspeito: ");
		JLabel l2 = new JLabel("Arma: ");
		JLabel l3 = new JLabel("Sala: ");
		
		l1.setBounds(50, 40, 130, 30);
		l2.setBounds(50, 80, 130, 30);
		l3.setBounds(50, 120, 130, 30);
		
		selecaoSus.setBounds(150, 40, 130, 30);
		selecaoArmas.setBounds(150, 80, 130, 30);
		selecaoSalas.setBounds(150, 120, 130, 30);
		b1.setBounds(50, 200, 130, 30);
		
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(selecaoSus);
		c.add(selecaoArmas);
		c.add(selecaoSalas);
		c.add(b1);
		
		
		setSize(350, 300);
		setVisible(true);
	}
	
	WindowAdapter fechar = new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent event)
		{
			Botoes.habilitar(mov, ps, prox, palp, true);
		}
	};
	
}
