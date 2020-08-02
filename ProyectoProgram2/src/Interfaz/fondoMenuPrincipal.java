package Interfaz;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class fondoMenuPrincipal extends JPanel {
	ImageIcon imagen;

	public fondoMenuPrincipal(String nombre) {
		super();
		imagen = new ImageIcon(getClass().getResource(nombre));
		setSize(imagen.getIconHeight(), imagen.getIconWidth());

	}
	
	public void paintComponent(Graphics g){
		Dimension d = getSize();
		g.drawImage(imagen.getImage(), 0, 0, d.width, d.height, null);
		this.setOpaque(false);
		super.paintComponent(g);
	}

}
