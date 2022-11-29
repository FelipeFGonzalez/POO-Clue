package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaRPalpite extends JFrame
{
	public TelaRPalpite(String s, String mensagem)
	{
		super(s);
		setLayout(null);
		JLabel label = new JLabel(mensagem);
		label.setHorizontalAlignment(JLabel.CENTER);

		label.setBounds(0, 20, 400, 30);
		add(label);
		
		
		setSize(400, 100);
		setVisible(true);
	}
}
