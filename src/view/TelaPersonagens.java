package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TelaPersonagens extends JFrame{
	private int selecionados = 0;
	JButton b1 = new JButton("Confirmar");
	JCheckBox cb1 = new JCheckBox("Coronel Mustard", false);
	JCheckBox cb2 = new JCheckBox("Professor Plum", false);
	JCheckBox cb3 = new JCheckBox("Reverendo Green", false);
	JCheckBox cb4 = new JCheckBox("Sra. Peacock", false);
	JCheckBox cb5 = new JCheckBox("Sra. White", false);
	JCheckBox cb6 = new JCheckBox("Srta. Scarlet", false);
	ArrayList<JCheckBox> botoes = new ArrayList<JCheckBox>();
	
	
	
	public TelaPersonagens(String s)
	{
		super(s);
		Collections.addAll(botoes, cb1, cb2, cb3, cb4, cb5, cb6);
		
		
		setLayout(null);
		Container c = getContentPane();
		b1.setEnabled(false);
		
		b1.addActionListener(new botaoPersonagens(this, this.botoes));
		
		cb1.addActionListener(contador);
		cb2.addActionListener(contador);
		cb3.addActionListener(contador);
		cb4.addActionListener(contador);
		cb5.addActionListener(contador);
		cb6.addActionListener(contador);
		
		cb1.setBounds(50, 40, 130, 30);
		cb2.setBounds(50, 70, 130, 30);
		cb3.setBounds(50, 100, 130, 30);
		cb4.setBounds(50, 130, 130, 30);
		cb5.setBounds(50, 160, 130, 30);
		cb6.setBounds(50, 190, 130, 30);
		b1.setBounds(50, 230, 130, 30);
		c.add(cb1);
		c.add(cb2);
		c.add(cb3);
		c.add(cb4);
		c.add(cb5);
		c.add(cb6);
		c.add(b1);
		setSize(250, 350);
		setVisible(true);
	}
	
	ActionListener contador = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			JCheckBox checkbox = (JCheckBox) event.getSource();
			if (checkbox.isSelected() == true)
				selecionados += 1;
            else
            	selecionados -= 1;
			
            if (selecionados >= 3)
            	b1.setEnabled(true);
            else
            	b1.setEnabled(false);
		}
	};
	
	public boolean[] getEstados()
	{
		boolean[] estados = new boolean[6];
		estados[0] = cb1.isSelected();
		estados[1] = cb2.isSelected();
		estados[2] = cb3.isSelected();
		estados[3] = cb4.isSelected();
		estados[4] = cb5.isSelected();
		estados[5] = cb6.isSelected();
		
		return estados;
	}
	
}
