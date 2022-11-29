package view;

import java.awt.*;

import javax.swing.JPanel;

public class Piao extends JPanel {
	int sus;

    public Piao(int s) {
        setPreferredSize(new Dimension(33, 24));
        sus = s;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (sus == 0)
        	g.setColor(Color.YELLOW);
        else if (sus == 1)
        	g.setColor(Color.MAGENTA);
        else if (sus == 2)
        	g.setColor(Color.GREEN);
        else if (sus == 3)
        	g.setColor(Color.BLUE);
        else if (sus == 4)
        	g.setColor(Color.BLACK);
        else if (sus == 5)
        	g.setColor(Color.RED);
        
        
        g.fillOval(0, 0, 33, 24);
    }
}