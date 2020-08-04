package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import archivos.manejoDeArchivos;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ventanaRegistro2 extends JFrame {
	
	private boolean comprobarRegistro(){
		boolean log = true;
		
		if ((textFieldNombres.getText().isEmpty()) || (textFieldApellidos.getText().isEmpty()) || (textFieldNombreDeUsuario.getText().isEmpty()) || (textFieldCorreoElectronico.getText().isEmpty()) || (textFieldContraseña.getText().isEmpty()) || (textFieldConfirmarContraseña.getText().isEmpty()))
			log = false;
		
		return log;
	}
		
	private fondoVentanas contentPane;
	private JTextField textFieldNombres;
	private JTextField textFieldApellidos;
	private JTextField textFieldNombreDeUsuario;
	private JTextField textFieldCorreoElectronico;
	private JTextField textFieldContraseña;
	private JTextField textFieldConfirmarContraseña;

	public ventanaRegistro2(Frame padre) {
		setTitle("2048 Fake - REGISTRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 500);
		contentPane = new fondoVentanas("/imagenes/fondoRegistro.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		textFieldNombres = new JTextField();
		textFieldNombres.setBounds(285, 69, 140, 31);
		contentPane.add(textFieldNombres);
		textFieldNombres.setColumns(10);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(285, 113, 140, 31);
		contentPane.add(textFieldApellidos);
		
		textFieldNombreDeUsuario = new JTextField();
		textFieldNombreDeUsuario.setColumns(10);
		textFieldNombreDeUsuario.setBounds(285, 158, 140, 31);
		contentPane.add(textFieldNombreDeUsuario);
		
		textFieldCorreoElectronico = new JTextField();
		textFieldCorreoElectronico.setColumns(10);
		textFieldCorreoElectronico.setBounds(285, 203, 140, 31);
		contentPane.add(textFieldCorreoElectronico);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setColumns(10);
		textFieldContraseña.setBounds(285, 248, 140, 31);
		contentPane.add(textFieldContraseña);
		
		textFieldConfirmarContraseña = new JTextField();
		textFieldConfirmarContraseña.setColumns(10);
		textFieldConfirmarContraseña.setBounds(285, 293, 140, 31);
		contentPane.add(textFieldConfirmarContraseña);
		
		JLabel lblErrorContraseña = new JLabel("Error, las contrase\u00F1as no coinciden.");
		lblErrorContraseña.setVisible(false);
		lblErrorContraseña.setIcon(new ImageIcon(ventanaRegistro2.class.getResource("/imagenes/errorUno.png")));
		lblErrorContraseña.setForeground(Color.RED);
		lblErrorContraseña.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblErrorContraseña.setBounds(268, 335, 293, 23);
		contentPane.add(lblErrorContraseña);
		
		JLabel lblDebeLlenarTodos = new JLabel("Debe llenar todos los requerimientos.");
		lblDebeLlenarTodos.setIcon(new ImageIcon(ventanaRegistro2.class.getResource("/imagenes/errorDos.png")));
		lblDebeLlenarTodos.setVisible(false);
		lblDebeLlenarTodos.setForeground(Color.WHITE);
		lblDebeLlenarTodos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDebeLlenarTodos.setBounds(248, 360, 359, 23);
		contentPane.add(lblDebeLlenarTodos);
		
		JButton btnRegresar = new JButton("");
		btnRegresar.setIcon(new ImageIcon(ventanaRegistro2.class.getResource("/imagenes/regresar.png")));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				padre.setVisible(true);
			}
		});
		btnRegresar.setBounds(482, 427, 125, 25);
		contentPane.add(btnRegresar);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.setIcon(new ImageIcon(ventanaRegistro2.class.getResource("/imagenes/siguiente.png")));
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				boolean log = comprobarRegistro();
				boolean logLlenar = false;
				boolean logPass = false;
				String texto;
				if (log == false)
					lblDebeLlenarTodos.setVisible(true);
				else{
					lblDebeLlenarTodos.setVisible(false);
					logLlenar = true;
				}
				
				if (!textFieldContraseña.getText().equals(textFieldConfirmarContraseña.getText())){
					lblErrorContraseña.setVisible(true);
					textFieldContraseña.setText(null);
					textFieldConfirmarContraseña.setText(null);
				}	
				else{
					logPass = true;
					lblErrorContraseña.setVisible(false);
				}
				
				if ((logPass) && (!logLlenar)){							
					lblDebeLlenarTodos.setBounds(248, 335, 359, 23);
				}
				else
					lblDebeLlenarTodos.setBounds(248, 360, 359, 23);
				
				if ((logPass) && (logLlenar)){				//EN CASO DE QUE ESTE TODO BIEN, PROCEDE A GUARDAR TODO EN UN ARCHIVO.
					manejoDeArchivos archivo = new manejoDeArchivos(textFieldNombres.getText());
					archivo = new manejoDeArchivos(textFieldApellidos.getText());
					archivo = new manejoDeArchivos(textFieldNombreDeUsuario.getText());
					archivo = new manejoDeArchivos(textFieldCorreoElectronico.getText());
					archivo = new manejoDeArchivos(textFieldContraseña.getText());
					archivo = new manejoDeArchivos(textFieldConfirmarContraseña.getText());				
				}
			}
		}
		);
		btnSiguiente.setBounds(347, 427, 125, 25);
		contentPane.add(btnSiguiente);
		setVisible(true);
	

	}
}
