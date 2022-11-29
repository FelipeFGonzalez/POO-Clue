package view;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controller.ControladorPrincipal;

import java.awt.*;
import java.awt.event.*;

public class TelaInicio extends JFrame{
	public TelaInicio(String s) {
		super(s);
		setLayout(null);
		JButton b1 = new JButton("Novo Jogo");
		JButton b2 = new JButton("Continuar");
		JPanel p = new JPanel();
		Container c = getContentPane();
		c.add(p);
		
		b1.setBounds(225,140,150,30);
		b2.setBounds(225,180,150,30);
		
		b1.addActionListener(new botaoStart(this));
		b2.addActionListener(carregar);
		
		c.add(b1, Component.CENTER_ALIGNMENT);
		c.add(b2, Component.CENTER_ALIGNMENT);
		
		setSize(600, 400);
		setVisible(true);
	}
	
	ActionListener carregar = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event)
		{
			String localArq = "";
			JFileChooser fc = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
			fc.setFileFilter(filter);
			int r = fc.showOpenDialog(null);
			if (r == JFileChooser.APPROVE_OPTION)	 
	        {
				localArq = fc.getSelectedFile().getAbsolutePath();
				setVisible(false);
				dispose();
	        }
			
			ControladorPrincipal cp = new ControladorPrincipal(localArq);
		}
	};
	
	
}
