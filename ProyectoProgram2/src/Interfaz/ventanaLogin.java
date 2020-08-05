package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import archivos.manejoDeArchivos;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventanaLogin extends JFrame {

	private fondoVentanas contentPane;
	private JTextField textFieldNickname;
	private JTextField textFieldClave;

	public ventanaLogin(Frame padre) {
		setTitle("2048 Fake - LOGIN");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 350);
		contentPane = new fondoVentanas("/imagenes/fondoLogin.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNickname = new JLabel("New label");
		lblNickname.setIcon(new ImageIcon(ventanaLogin.class.getResource("/imagenes/nickname.png")));
		lblNickname.setBounds(30, 97, 158, 33);
		contentPane.add(lblNickname);
		
		JLabel lblClave = new JLabel("");
		lblClave.setIcon(new ImageIcon(ventanaLogin.class.getResource("/imagenes/clave.png")));
		lblClave.setBounds(92, 149, 96, 41);
		contentPane.add(lblClave);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setBounds(201, 95, 127, 33);
		contentPane.add(textFieldNickname);
		textFieldNickname.setColumns(10);
		
		textFieldClave = new JTextField();
		textFieldClave.setColumns(10);
		textFieldClave.setBounds(201, 155, 127, 33);
		contentPane.add(textFieldClave);
		
		JButton btnRegresar = new JButton("");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				padre.setVisible(true);
			}
		});
		btnRegresar.setIcon(new ImageIcon(ventanaLogin.class.getResource("/imagenes/regresar.png")));
		btnRegresar.setBounds(259, 285, 125, 25);
		contentPane.add(btnRegresar);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//ARREGLAR ESTO. LECTURA DE ARCHIVO
				manejoDeArchivos archivo = new manejoDeArchivos(null);
				archivo.leerTXT("datosUsuario.txt");
				System.out.println(archivo.leerTXT("datosUsuario.txt"));
			}
		});
		btnSiguiente.setIcon(new ImageIcon(ventanaLogin.class.getResource("/imagenes/siguiente.png")));
		btnSiguiente.setBounds(124, 285, 125, 25);
		contentPane.add(btnSiguiente);
		
		JLabel lblError = new JLabel("Error");
		lblError.setIcon(new ImageIcon(ventanaLogin.class.getResource("/imagenes/ErrorTres.png")));
		lblError.setBounds(10, 220, 374, 25);
		contentPane.add(lblError);
		lblError.setVisible(false);
		setLocationRelativeTo(null);
		setResizable(false);
	}
}
