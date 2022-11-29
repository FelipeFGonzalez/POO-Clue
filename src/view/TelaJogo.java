package view;

import javax.swing.*;

import Controller.ChamadaGS;
import Controller.Movimento;
import Controller.ObservableCont;
import Controller.ObserverCont;
import Controller.ContDados;
import Controller.Salvar;
import Controller.Turnos;
import Model.GameStart;

import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;


public class TelaJogo extends JFrame implements ObserverCont
{
	private static TelaJogo ctrl = null;
	

	JButton botaoSecreta;
	JButton botaoProx;
	JButton botaoCartas;
	JButton botaoBloco;
	JButton botaoPalpite;
	JButton botaoAcusar;
	JButton botaoSalvar;
	JButton rolarDado;
	JButton definirDado;
	
	JSpinner s1;
	JSpinner s2;
	
	JLabel l1;
	JLabel l2;
	JLabel lMov;
	
	Image imagemTab;
	Image imgDado1;
	Image imgDado2;
	PanelDado pdado1 = new PanelDado();
	PanelDado pdado2 = new PanelDado();
	
	Piao p1 = new Piao(0);
	Piao p2 = new Piao(1);
	Piao p3 = new Piao(2);
	Piao p4 = new Piao(3);
	Piao p5 = new Piao(4);
	Piao p6 = new Piao(5);
	ArrayList<Piao> listaP = new ArrayList<Piao>();
	
	ContDados dadosC = new ContDados();
	
	
	public static TelaJogo getTelaJogo()
	{
		if (ctrl == null)
		{
			ctrl = new TelaJogo("Clue");
		}
		return ctrl;
	}
	
	private TelaJogo(String s)
	{
		super(s);
		
		try {
			imagemTab=ImageIO.read(new File("imagens/Imagens/Tabuleiros/Tabuleiro-Clue-A.jpg"));
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}

		Collections.addAll(listaP, p1, p2, p3, p4, p5, p6);
		
		
		JPanel ptab = new PanelTabuleiro(imagemTab);
		

		l1 = new JLabel(ChamadaGS.getP(), SwingConstants.CENTER);
		l2 = new JLabel("-  Passo(s)", SwingConstants.CENTER);
		lMov = new JLabel("", SwingConstants.CENTER);
		
		
		setLayout(null);
		botaoSecreta = new JButton("Passagem Secreta");
		botaoProx = new JButton("Próximo");
		botaoCartas = new JButton("Mostrar Cartas");
		botaoBloco = new JButton("Bloco de Notas");
		botaoPalpite = new JButton("Palpite");
		botaoAcusar = new JButton("Acusar");
		botaoSalvar = new JButton("Salvar Jogo");
		rolarDado = new JButton("Rolar Dados");
		definirDado = new JButton ("Definir");
		s1 = new JSpinner(new SpinnerNumberModel(1, 1, 6, 1));
		s2 = new JSpinner(new SpinnerNumberModel(1, 1, 6, 1));		
		
		Container c = getContentPane();
		botaoSecreta.setEnabled(false);
		botaoPalpite.setEnabled(false);
		botaoProx.setEnabled(false);
		this.setResizable(false);
		
		botaoProx.addActionListener(turnos);
		botaoSecreta.addActionListener(passagem);
		botaoCartas.addActionListener(cartas);
		botaoBloco.addActionListener(bloco);
		botaoAcusar.addActionListener(new botaoAcusar(this));
		botaoPalpite.addActionListener(palpite);
		rolarDado.addActionListener(rolar);
		definirDado.addActionListener(definir);
		botaoSalvar.addActionListener(salvar);
		ptab.addMouseListener(detectaClique);
		
		ptab.setBounds(0, 0, 930, 700);
		pdado1.setBounds(960, 400, 95, 110);
		pdado2.setBounds(1055, 400, 95, 110);
		botaoSecreta.setBounds(960, 30, 190, 30);
		botaoProx.setBounds(960, 70, 190, 30);
		botaoCartas.setBounds(960, 110, 190, 30);
		botaoBloco.setBounds(960, 150, 190, 30);
		botaoPalpite.setBounds(960, 190, 190, 30);
		botaoAcusar.setBounds(960, 230, 190, 30);
		botaoSalvar.setBounds(960, 300, 190, 30);
		l1.setBounds(960, 350, 190, 30);
		l2.setBounds(960, 368, 190, 30);
		lMov.setBounds(960, 620, 190, 30);
		rolarDado.setBounds(960, 530, 190, 30);
		s1.setBounds(960, 570, 35, 30);
		s2.setBounds(1000, 570, 35, 30);
		definirDado.setBounds(1040, 570, 110, 30);
		
		int [] suspos0 = ChamadaGS.getPosSus(0);
		int [] suspos1 = ChamadaGS.getPosSus(1);
		int [] suspos2 = ChamadaGS.getPosSus(2);
		int [] suspos3 = ChamadaGS.getPosSus(3);
		int [] suspos4 = ChamadaGS.getPosSus(4);
		int [] suspos5 = ChamadaGS.getPosSus(5);
		
		listaP.get(0).setBounds(suspos0[1] * 33 + 35, suspos0[0] * 24 + 4, 33, 24);
		listaP.get(1).setBounds(suspos1[1] * 33 + 35, suspos1[0] * 24 + 4, 33, 24);
		listaP.get(2).setBounds(suspos2[1] * 33 + 35, suspos2[0] * 24 + 4, 33, 24);
		listaP.get(3).setBounds(suspos3[1] * 33 + 35, suspos3[0] * 24 + 4, 33, 24);
		listaP.get(4).setBounds(suspos4[1] * 33 + 35, suspos4[0] * 24 + 4, 33, 24);
		listaP.get(5).setBounds(suspos5[1] * 33 + 35, suspos5[0] * 24 + 4, 33, 24);
		
		
		for(int i = 0; i < 6; i++)
		{
			c.add(listaP.get(i));
		}
		
		c.add(ptab);
		c.add(pdado1);
		c.add(pdado2);
		c.add(botaoSecreta);
		c.add(botaoProx);
		c.add(botaoCartas);
		c.add(botaoBloco);
		c.add(botaoPalpite);
		c.add(botaoAcusar);
		c.add(botaoSalvar);
		c.add(l1);
		c.add(l2);
		c.add(lMov);
		c.add(s1);
		c.add(s2);
		c.add(rolarDado);
		c.add(definirDado);
		
	
		
		setSize(1200, 700);
		setVisible(true);
	}
	
	MouseAdapter detectaClique = new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent event) {
			int x_mouse = event.getX();
			int y_mouse = event.getY();
			// x,y do mouse correspondem a y,x nas coordenadas do tabuleiro
			int coordY = (x_mouse - 35) / 33;
			int coordX = (y_mouse - 4) / 24;
			
			Movimento.tentaMovimento(coordX, coordY);
        }
	};
	
	ActionListener salvar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			Salvar.realizaSalvamento();
		}
	};
	
	ActionListener turnos = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			Turnos.nextTurno();
		}
	};
	
	ActionListener passagem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			ChamadaGS.movePassagemSecreta();
		}
	};
	
	ActionListener bloco = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			TelaBloco tempBloco = new TelaBloco("Bloco de Notas");
		}
	};
	
	ActionListener cartas = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			TelaCartas tempCartas = new TelaCartas("Cartas", ChamadaGS.getCartas());
		}
	};
	
	ActionListener palpite = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			TelaPalpite tempPalpite = new TelaPalpite("Palpite", ChamadaGS.getSala());
		}
	};
	
	ActionListener rolar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			dadosC.rolarDados();
		}
	};
	
	ActionListener definir = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			int dado1 = (int) s1.getValue();
			int dado2 = (int) s2.getValue();
			
			dadosC.definirDados(dado1, dado2);
		}
	};

	
	public void proxTurno(String playerAtual, boolean passagem, boolean palpite, boolean prox, boolean dados)
	{
		l1.setText(playerAtual);
		l2.setText("-  Passo(s)");
		rolarDado.setEnabled(dados);
		definirDado.setEnabled(dados);
		botaoSecreta.setEnabled(passagem);
		botaoPalpite.setEnabled(palpite);
		botaoAcusar.setEnabled(true);
		botaoSalvar.setEnabled(true);
		
		botaoProx.setEnabled(prox);
		
	}
	
	public void notifyDados()
	{
		int[] dados = dadosC.get();
		int dado1 = dados[0];
		int dado2 = dados[1];
		
		try {
			imgDado1=ImageIO.read(new File("imagens/Imagens/Tabuleiros/dado" + Integer.toString(dado1) + ".jpg"));
			imgDado2=ImageIO.read(new File("imagens/Imagens/Tabuleiros/dado" + Integer.toString(dado2) + ".jpg"));
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		pdado1.atualizaImagem(imgDado1);
		pdado2.atualizaImagem(imgDado2);
		repaint();
		
		rolarDado.setEnabled(false);
		definirDado.setEnabled(false);
		botaoProx.setEnabled(false);
		botaoAcusar.setEnabled(false);
		botaoSecreta.setEnabled(false);
		botaoSalvar.setEnabled(false);
		
		l2.setText(Integer.toString(dado1 + dado2) + "  Passo(s)");
	}
	
	public void terminaMovimento(int x, int y)
	{
		botaoProx.setEnabled(true);
		botaoAcusar.setEnabled(true);
	}
	
	public void mudarTextoMov(String s)
	{
		lMov.setText(s);
		repaint();
	}
	
	public void notify(ObservableCont o)
	{
		int[] detalhes = (int[])o.get();
		
		
		if (detalhes[1] == 7 && detalhes[2] == 5)
		{
			detalhes[1] = 4;
			detalhes[2] = 2;
			if (detalhes[0] > 3)
			{
				detalhes[1] = 5;
				detalhes[2] = 3 - 4;
			}
			
			detalhes[2] += detalhes[0];
			
		}
		else if (detalhes[1] == 13 && detalhes[2] == 8)
		{
			detalhes[1] = 14;
			detalhes[2] = 2;
			
			detalhes[2] += detalhes[0];
		}
		else if (detalhes[1] == 20 && detalhes[2] == 7)
		{
			detalhes[1] = 23;
			detalhes[2] = 1;
			
			detalhes[2] += detalhes[0];
		}
		else if (detalhes[1] == 19 && detalhes[2] == 13)
		{
			detalhes[1] = 23;
			detalhes[2] = 11;
			if (detalhes[0] > 3)
			{
				detalhes[1] = 24;
				detalhes[2] = 12 - 4;
			}
			
			detalhes[2] += detalhes[0];
		}
		else if (detalhes[1] == 22 && detalhes[2] == 18)
		{
			detalhes[1] = 24;
			detalhes[2] = 19;
			
			detalhes[2] += detalhes[0];
		}
		else if (detalhes[1] == 17 && detalhes[2] == 18)
		{
			detalhes[1] = 18;
			detalhes[2] = 19;
			
			detalhes[2] += detalhes[0];
		}
		else if (detalhes[1] == 13 && detalhes[2] == 23)
		{
			detalhes[1] = 12;
			detalhes[2] = 19;
			
			detalhes[2] += detalhes[0];
		}
		else if (detalhes[1] == 6 && detalhes[2] == 20)
		{
			detalhes[1] = 5;
			detalhes[2] = 20;
			if (detalhes[0] > 3)
			{
				detalhes[1] = 6;
				detalhes[2] = 21 - 4;
			}
			
			detalhes[2] += detalhes[0];
		}
		else if (detalhes[1] == 6 && detalhes[2] == 16)
		{
			detalhes[1] = 7;
			detalhes[2] = 10;
			
			detalhes[2] += detalhes[0];
		}
		
		listaP.get(detalhes[0]).setBounds(detalhes[2] * 33 + 35, detalhes[1] * 24 + 4, 33, 24);
		repaint();
	}
	
	
	public boolean bloquearMov()
	{
		boolean estadoAnterior = rolarDado.isEnabled();
		
		rolarDado.setEnabled(false);
		definirDado.setEnabled(false);
		
		return estadoAnterior;
	}
	
	
	public void permitirMov()
	{
		rolarDado.setEnabled(true);
		definirDado.setEnabled(true);
	}
	
	public boolean bloquearPS()
	{
		boolean estadoAnterior = botaoSecreta.isEnabled();
		botaoSecreta.setEnabled(false);
		return estadoAnterior;
	}
	
	
	public void permitirPS()
	{
		botaoSecreta.setEnabled(true);
	}
	
	
	public void permitirPalpite()
	{
		botaoPalpite.setEnabled(true);
	}
	
	
	public boolean bloquearPalpite()
	{
		boolean estadoAnterior = botaoPalpite.isEnabled();
		botaoPalpite.setEnabled(false);
		return estadoAnterior;
	}
	
	
	public void permitirProx()
	{
		botaoProx.setEnabled(true);
	}
	
	
	public boolean bloquearProx()
	{
		boolean estadoAnterior = botaoProx.isEnabled();
		botaoProx.setEnabled(false);
		return estadoAnterior;
	}
	
	
	public void permitirAcusacao()
	{
		botaoAcusar.setEnabled(true);
	}
	
	
	public void bloquearAcusacao()
	{
		botaoAcusar.setEnabled(false);
	}
	
	
	public void bloquearSalvamento()
	{
		botaoSalvar.setEnabled(false);
	}
	
	
	public boolean statusPalp()
	{
		return botaoPalpite.isEnabled();
	}
}
