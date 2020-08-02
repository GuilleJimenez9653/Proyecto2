package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class ventanaRegistro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombres;
	private JTextField textFieldApellidos;
	private JTextField textFieldNombreDeUsuario;
	private JTextField textFieldEmail;
	private JTextField textFieldContraseña;
	private JTextField textFieldConfimarContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ventanaRegistro dialog = new ventanaRegistro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ventanaRegistro() {
		setBounds(100, 100, 500, 500);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombres = new JLabel("Nombres:");
			lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNombres.setBounds(116, 51, 56, 14);
			contentPanel.add(lblNombres);
		}
		{
			textFieldNombres = new JTextField();
			textFieldNombres.setBounds(183, 41, 137, 34);
			contentPanel.add(textFieldNombres);
			textFieldNombres.setColumns(10);
		}
		{
			JLabel lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblApellidos.setBounds(116, 94, 56, 14);
			contentPanel.add(lblApellidos);
		}
		{
			textFieldApellidos = new JTextField();
			textFieldApellidos.setColumns(10);
			textFieldApellidos.setBounds(183, 84, 137, 34);
			contentPanel.add(textFieldApellidos);
		}
		{
			JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
			lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNombreDeUsuario.setBounds(57, 139, 115, 14);
			contentPanel.add(lblNombreDeUsuario);
		}
		{
			textFieldNombreDeUsuario = new JTextField();
			textFieldNombreDeUsuario.setColumns(10);
			textFieldNombreDeUsuario.setBounds(183, 129, 137, 34);
			contentPanel.add(textFieldNombreDeUsuario);
		}
		{
			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEmail.setBounds(136, 183, 36, 14);
			contentPanel.add(lblEmail);
		}
		{
			textFieldEmail = new JTextField();
			textFieldEmail.setColumns(10);
			textFieldEmail.setBounds(183, 174, 137, 34);
			contentPanel.add(textFieldEmail);
		}
		{
			JLabel lblNombres = new JLabel("Contrase\u00F1a:");
			lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNombres.setBounds(102, 229, 70, 14);
			contentPanel.add(lblNombres);
		}
		{
			textFieldContraseña = new JTextField();
			textFieldContraseña.setColumns(10);
			textFieldContraseña.setBounds(183, 219, 137, 34);
			contentPanel.add(textFieldContraseña);
		}
		{
			JLabel lblNombres = new JLabel("Confirmar contrase\u00F1a:");
			lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNombres.setBounds(43, 273, 129, 14);
			contentPanel.add(lblNombres);
		}
		{
			textFieldConfimarContraseña = new JTextField();
			textFieldConfimarContraseña.setColumns(10);
			textFieldConfimarContraseña.setBounds(183, 264, 137, 34);
			contentPanel.add(textFieldConfimarContraseña);
		}
		{
			JLabel lblErrorContraseña = new JLabel("Las claves no coinciden.");
			lblErrorContraseña.setEnabled(false);
			lblErrorContraseña.setForeground(Color.RED);
			lblErrorContraseña.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblErrorContraseña.setBounds(183, 309, 137, 14);
			contentPanel.add(lblErrorContraseña);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSiguiente = new JButton("Siguiente");
				btnSiguiente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (textFieldContraseña.getText() != textFieldConfimarContraseña.getText()){
							
						}
					}
				});
				btnSiguiente.setActionCommand("OK");
				buttonPane.add(btnSiguiente);
				getRootPane().setDefaultButton(btnSiguiente);
			}
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
	}

}
