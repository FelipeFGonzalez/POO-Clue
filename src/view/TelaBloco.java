package view;
import javax.swing.*;

import Controller.ChamadaGS;
import Controller.Turnos;
import Model.GameStart;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class TelaBloco  extends JFrame
{
	JCheckBox sus1 = new JCheckBox("Coronel Mustard", false);
	JCheckBox sus2 = new JCheckBox("Professor Plum", false);
	JCheckBox sus3 = new JCheckBox("Reverendo Green", false);
	JCheckBox sus4 = new JCheckBox("Sra. Peacock", false);
	JCheckBox sus5 = new JCheckBox("Sra. White", false);
	JCheckBox sus6 = new JCheckBox("Srta. Scarlet", false);

	JCheckBox arm1 = new JCheckBox("Cano de Chumbo", false);
	JCheckBox arm2 = new JCheckBox("Castiçal", false);
	JCheckBox arm3 = new JCheckBox("Chave Inglesa", false);
	JCheckBox arm4 = new JCheckBox("Corda", false);
	JCheckBox arm5 = new JCheckBox("Faca", false);
	JCheckBox arm6 = new JCheckBox("Revólver", false);

	JCheckBox sala1 = new JCheckBox("Biblioteca", false);
	JCheckBox sala2 = new JCheckBox("Cozinha", false);
	JCheckBox sala3 = new JCheckBox("Escritório", false);
	JCheckBox sala4 = new JCheckBox("Hall", false);
	JCheckBox sala5 = new JCheckBox("Jardim de Inverno", false);
	JCheckBox sala6 = new JCheckBox("Sala de Estar", false);
	JCheckBox sala7 = new JCheckBox("Sala de Jantar", false);
	JCheckBox sala8 = new JCheckBox("Sala de Música", false);
	JCheckBox sala9 = new JCheckBox("Salão de Jogos", false);
	
	ArrayList<JCheckBox> botoes = new ArrayList<JCheckBox>();
	
	
	public TelaBloco(String s)
	{
		super(s);
		setLayout(null);
		
		Collections.addAll(botoes, sus1, sus2, sus3, sus4, sus5, sus6,
								   arm1, arm2, arm3, arm4, arm5, arm6,
								   sala1, sala2, sala3, sala4, sala5, sala6, sala7, sala8, sala9);
		
		boolean[] estados = ChamadaGS.getBloco();
		for (int i = 0; i < 21; i++)
		{
			botoes.get(i).setSelected(estados[i]);
		}
		
		JPanel pSus = new JPanel();
		JPanel pArm = new JPanel();
		JPanel pSala = new JPanel();
		
		pSus.setBorder(BorderFactory.createTitledBorder("Suspeitos"));
		pArm.setBorder(BorderFactory.createTitledBorder("Armas"));
		pSala.setBorder(BorderFactory.createTitledBorder("Salas"));
         
        BoxLayout layout1 = new BoxLayout(pSus, BoxLayout.Y_AXIS);
        BoxLayout layout2 = new BoxLayout(pArm, BoxLayout.Y_AXIS);
        BoxLayout layout3 = new BoxLayout(pSala, BoxLayout.Y_AXIS);
        pSus.setLayout(layout1);
        pArm.setLayout(layout2);
        pSala.setLayout(layout3);
        
        pSus.add(sus1);
        pSus.add(sus2);
        pSus.add(sus3);
        pSus.add(sus4);
        pSus.add(sus5);
        pSus.add(sus6);
        
        pArm.add(arm1);
        pArm.add(arm2);
        pArm.add(arm3);
        pArm.add(arm4);
        pArm.add(arm5);
        pArm.add(arm6);
        
        pSala.add(sala1);
        pSala.add(sala2);
        pSala.add(sala3);
        pSala.add(sala4);
        pSala.add(sala5);
        pSala.add(sala6);
        pSala.add(sala7);
        pSala.add(sala8);
        pSala.add(sala9);
        
        setLayout(new FlowLayout());
        add(pSus);
        add(pArm);
        add(pSala);
		
        addWindowListener(salvarEstados);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
		setSize(450, 300);
		setVisible(true);
	}
	
	WindowAdapter salvarEstados = new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent evt) {
			boolean[] listaEstados = new boolean[21];
			
			for (int i = 0; i < 21; i++)
			{
				listaEstados[i] = botoes.get(i).isSelected();
			}
			
			ChamadaGS.atualizaBloco(listaEstados);
		}
	};
}
