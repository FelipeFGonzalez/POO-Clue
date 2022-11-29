package view;
import javax.swing.*;

import Controller.Botoes;
import Controller.Palpite;
import Model.GameStart;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class TelaPalpite  extends JFrame
{
	String suspeitos[] = {"Coronel Mustard", "Professor Plum", "Reverendo Green", "Sra. Peacock", "Sra. White", "Srta. Scarlet"};
	String armas[] = {"Cano de Chumbo", "Castiçal", "Chave Inglesa", "Corda", "Faca", "Revólver"};
	
	
	JButton b1 = new JButton("Confirmar");
	JComboBox selecaoSus = new JComboBox(suspeitos);
	JComboBox selecaoArmas = new JComboBox(armas);
	
	String salaS;
	TelaPalpite tp = null;
	
	boolean mov;
	boolean prox;
	boolean ps;
	
	ArrayList<JComboBox> selecoes = new ArrayList<JComboBox>();
	public TelaPalpite(String s, String salaAtual)
	{
		super(s);
		tp = this;
		String salas[] = {salaAtual};
		JComboBox selecaoSalas = new JComboBox(salas);
		Collections.addAll(selecoes, selecaoSus, selecaoArmas, selecaoSalas);

		salaS = salaAtual;
		
		mov = TelaJogo.getTelaJogo().bloquearMov();
		prox = TelaJogo.getTelaJogo().bloquearProx();
		ps = TelaJogo.getTelaJogo().bloquearPS();
		TelaJogo.getTelaJogo().bloquearPalpite();
		TelaJogo.getTelaJogo().bloquearAcusacao();
		
		
		setLayout(null);
		Container c = getContentPane();

		
		
		b1.addActionListener(confirmarPalpite);
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
		
		selecaoSalas.setEnabled(false);
		
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
	
	ActionListener confirmarPalpite = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			
			String suspeitoSelecionado = (String)selecaoSus.getSelectedItem();
			String armaSelecionada = (String)selecaoArmas.getSelectedItem();
			
			Palpite.confirmacaoPalpite(suspeitoSelecionado, armaSelecionada, salaS, tp);
		}
	};
	
	WindowAdapter fechar = new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent event)
		{
			Botoes.habilitar(mov, ps, prox, true, true);
		}
	};

	
}
