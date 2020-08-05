package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import archivos.manejoDeArchivos;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class menuPrincipal extends JFrame {

	private fondoVentanas contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPrincipal frame = new menuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public menuPrincipal() {
		File archivo = new File("datosUsuario.txt");
		setTitle("2048 Fake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new fondoVentanas("/imagenes/fondo2.jpeg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JButton btnJugar = new JButton("");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!archivo.exists()){
				ventanaRegistro2 registro = new ventanaRegistro2(menuPrincipal.this);
				setVisible(false);
				}
				else{
					ventanaLogin login = new ventanaLogin(menuPrincipal.this);
					setVisible(false);
					//SE ABRE VENTANA DE INICIO DE SECCION.
				}
			}
		});
		btnJugar.setIcon(new ImageIcon(menuPrincipal.class.getResource("/imagenes/jugarNew.png")));
		btnJugar.setBounds(117, 382, 200, 40);
		contentPane.add(btnJugar);
		
		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setIcon(new ImageIcon(menuPrincipal.class.getResource("/imagenes/salirNew.png")));
		btnSalir.setBounds(117, 439, 200, 40);
		contentPane.add(btnSalir);
		
		JButton btnInfo = new JButton("");
		btnInfo.setIcon(new ImageIcon(menuPrincipal.class.getResource("/imagenes/info.png")));
		btnInfo.setBounds(924, 11, 50, 50);
		contentPane.add(btnInfo);
		setLocationRelativeTo(null);
	}
}
