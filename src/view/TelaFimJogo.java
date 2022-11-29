package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaFimJogo extends JFrame{
	
	public TelaFimJogo(String s, String vencedor, String sus, String arma, String sala)
	{
		super(s);
		
		setLayout(null);
		Container c = getContentPane();
		
		JLabel lFdj = new JLabel("Fim de Jogo!");
		JLabel lVenc = new JLabel("Vencedor:");
		JLabel lNomeVenc = new JLabel(vencedor);
		JLabel lResp = new JLabel("A Resposta era:");
		
		lFdj.setBounds(250, 50, 100, 40);
		lVenc.setBounds(50, 120, 100, 40);
		lNomeVenc.setBounds(150, 120, 100, 40);
		lResp.setBounds(50, 150, 100, 40);
		
		c.add(lFdj, Component.CENTER_ALIGNMENT);
		c.add(lVenc);
		c.add(lNomeVenc);
		c.add(lResp);
		
		
		String pCartaSus = "";
		String pCartaArma = "";
		String pCartaSala = "";
		
		if (sus.equals("Reverendo Green"))
			pCartaSus = "Green";
		else if (sus.equals("Coronel Mustard"))
			pCartaSus = "Mustard";
		else if (sus.equals("Sra. Peacock"))
			pCartaSus = "Peacock";
		else if (sus.equals("Professor Plum"))
			pCartaSus = "Plum";
		else if (sus.equals("Srta. Scarlet"))
			pCartaSus = "Scarlet";
		else if (sus.equals("Sra. White"))
			pCartaSus = "White";
		
		if (arma.equals("Corda"))
			pCartaArma = "Corda";
		else if (arma.equals("Cano de Chumbo"))
			pCartaArma = "Cano";
		else if (arma.equals("Faca"))
			pCartaArma = "Faca";
		else if (arma.equals("Chave Inglesa"))
			pCartaArma = "ChaveInglesa";
		else if (arma.equals("Castiçal"))
			pCartaArma = "Castical";
		else if (arma.equals("Revólver"))
			pCartaArma = "Revolver";
		
		if (sala.equals("Cozinha"))
			pCartaSala = "Cozinha";
		else if (sala.equals("Sala de Jantar"))
			pCartaSala = "SalaDeJantar";
		else if (sala.equals("Sala de Estar"))
			pCartaSala = "SalaDeEstar";
		else if (sala.equals("Hall"))
			pCartaSala = "Entrada";
		else if (sala.equals("Escritório"))
			pCartaSala = "Escritorio";
		else if (sala.equals("Biblioteca"))
			pCartaSala = "Biblioteca";
		else if (sala.equals("Salão de Jogos"))
			pCartaSala = "SalaoDeJogos";
		else if (sala.equals("Sala de Música"))
			pCartaSala = "SalaDeMusica";
		else if (sala.equals("Jardim de Inverno"))
			pCartaSala = "JardimInverno";
		
		Image imgSus = null;
		Image imgArma = null;
		Image imgSala = null;
		try {
			imgSus=ImageIO.read(new File("imagens/Imagens/Suspeitos/" + pCartaSus + ".jpg"));
			imgArma=ImageIO.read(new File("imagens/Imagens/Armas/" + pCartaArma + ".jpg"));
			imgSala=ImageIO.read(new File("imagens/Imagens/Comodos/" + pCartaSala + ".jpg"));
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		JPanel pcardSus = new PanelCarta(imgSus);
		JPanel pcardArma = new PanelCarta(imgArma);
		JPanel pcardSala = new PanelCarta(imgSala);
		
		
		pcardSus.setBounds(0, 200, 190, 325);
		pcardArma.setBounds(200, 200, 190, 325);
		pcardSala.setBounds(400, 200, 190, 325);
		
		c.add(pcardSus);
		c.add(pcardArma);
		c.add(pcardSala);

		setSize(600, 560);
		setVisible(true);
	}
	
}
