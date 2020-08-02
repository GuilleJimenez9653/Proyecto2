package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class ventanaRegistro2 extends JFrame {
	
	private boolean comprobarRegistro(){
		boolean log = true;
		
		if ((textFieldNombres.getText().isEmpty()) || (textFieldApellidos.getText().isEmpty()) || (textFieldNombreDeUsuario.getText().isEmpty()) || (textFieldCorreoElectronico.getText().isEmpty()) || (textFieldContraseña.getText().isEmpty()) || (textFieldConfirmarContraseña.getText().isEmpty()))
			log = false;
		
		return log;
	}

	private JPanel contentPane;
	private JTextField textFieldNombres;
	private JTextField textFieldApellidos;
	private JTextField textFieldNombreDeUsuario;
	private JTextField textFieldCorreoElectronico;
	private JTextField textFieldContraseña;
	private JTextField textFieldConfirmarContraseña;

	public ventanaRegistro2(Frame padre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombres.setBounds(192, 59, 56, 25);
		contentPane.add(lblNombres);
		
		textFieldNombres = new JTextField();
		textFieldNombres.setBounds(258, 53, 120, 31);
		contentPane.add(textFieldNombres);
		textFieldNombres.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellidos.setBounds(192, 101, 56, 25);
		contentPane.add(lblApellidos);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(258, 95, 120, 31);
		contentPane.add(textFieldApellidos);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreDeUsuario.setBounds(128, 143, 120, 25);
		contentPane.add(lblNombreDeUsuario);
		
		textFieldNombreDeUsuario = new JTextField();
		textFieldNombreDeUsuario.setColumns(10);
		textFieldNombreDeUsuario.setBounds(258, 137, 120, 31);
		contentPane.add(textFieldNombreDeUsuario);
		
		JLabel lblCorreoElectronico = new JLabel("Correo Electronico:");
		lblCorreoElectronico.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCorreoElectronico.setBounds(138, 185, 110, 25);
		contentPane.add(lblCorreoElectronico);
		
		textFieldCorreoElectronico = new JTextField();
		textFieldCorreoElectronico.setColumns(10);
		textFieldCorreoElectronico.setBounds(258, 179, 120, 31);
		contentPane.add(textFieldCorreoElectronico);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContrasea.setBounds(148, 227, 100, 25);
		contentPane.add(lblContrasea);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setColumns(10);
		textFieldContraseña.setBounds(258, 221, 120, 31);
		contentPane.add(textFieldContraseña);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar Contrase\u00F1a:");
		lblConfirmarContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConfirmarContrasea.setBounds(117, 269, 131, 25);
		contentPane.add(lblConfirmarContrasea);
		
		textFieldConfirmarContraseña = new JTextField();
		textFieldConfirmarContraseña.setColumns(10);
		textFieldConfirmarContraseña.setBounds(258, 263, 120, 31);
		contentPane.add(textFieldConfirmarContraseña);
		
		JLabel lblErrorContraseña = new JLabel("Error, las contrase\u00F1as no coinciden.");
		lblErrorContraseña.setEnabled(false);
		lblErrorContraseña.setForeground(Color.RED);
		lblErrorContraseña.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblErrorContraseña.setBounds(257, 305, 205, 14);
		contentPane.add(lblErrorContraseña);
		
		JLabel lblDebeLlenarTodos = new JLabel("Debe llenar todos los requerimientos.");
		lblDebeLlenarTodos.setEnabled(false);
		lblDebeLlenarTodos.setForeground(Color.RED);
		lblDebeLlenarTodos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDebeLlenarTodos.setBounds(248, 321, 214, 14);
		contentPane.add(lblDebeLlenarTodos);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				padre.setVisible(true);
			}
		});
		btnRegresar.setBounds(518, 427, 89, 23);
		contentPane.add(btnRegresar);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				boolean log = comprobarRegistro();
				boolean logLlenar = false;
				boolean logPass = false;
				if (log == false)
					lblDebeLlenarTodos.setEnabled(true);
				else{
					lblDebeLlenarTodos.setEnabled(false);
					logLlenar = true;
				}
				
				if (!textFieldContraseña.getText().equals(textFieldConfirmarContraseña.getText())){
					lblErrorContraseña.setEnabled(true);
					textFieldContraseña.setText("");
					textFieldConfirmarContraseña.setText("");
				}	
				else{
					logPass = true;
					lblErrorContraseña.setEnabled(false);
				}
				
				if ((logPass) && (logLlenar)){
					System.out.print("Entro");
				}
			}
		}
		);
		btnSiguiente.setBounds(419, 427, 89, 23);
		contentPane.add(btnSiguiente);
		setVisible(true);
	

	}
}
