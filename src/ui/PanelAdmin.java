package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Service.UsuarioService;
import imp.Usuario;

public class PanelAdmin extends JPanel {
	private PanelManager panelManager;
	
private Usuario usu = new Usuario();
	
	public void guardarUsuario (Usuario usuario) {
    	this.usu=usuario;
    }

	private JLabel lblBienvenido;

	// Botonera
	private JButton btnOdontologos;
	private JButton btnPacientes;
	private JButton btnTurnos;
	private JButton btnVolverLogin;

	public void armarPanelAdmin(PanelManager panelManager) {
		setLayout(null);
		this.panelManager = panelManager;
		// creacion combo
		
		lblBienvenido= new JLabel("Bienvenido admin");
		lblBienvenido.setBounds(183, 16, 107, 66);
		add(lblBienvenido);
		
		btnOdontologos = new JButton("administrar odontologos");
		btnOdontologos.setBounds(50, 93, 178, 156);
		add(btnOdontologos);
		
		btnPacientes = new JButton("administrar pacientes");
		btnPacientes.setBounds(249, 93, 178, 156);
		add(btnPacientes);
		
		btnTurnos = new JButton("administrar turnos");
		btnTurnos.setBounds(50, 274, 178, 156);
		add(btnTurnos);
		
		btnVolverLogin = new JButton("Regresar al Login");
		btnVolverLogin.setBounds(249, 274, 178, 156);
		add(btnVolverLogin);

		btnOdontologos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				panelManager.mostrarVistaOdontologos(usu);
			}
		});
		
		btnPacientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				panelManager.mostrarVistaPacientes(usu);
			}
		});
		
		btnTurnos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				panelManager.mostrarTurno(usu);
			}
		});
		
		btnVolverLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				panelManager.mostrarPanelLogIn();;
			}
		});

	}
}
