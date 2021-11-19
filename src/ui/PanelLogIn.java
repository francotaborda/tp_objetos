package ui;

import javax.swing.*;

import Service.UsuarioService;
import imp.Usuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelLogIn extends JPanel {
	
	
	
	private PanelManager panelManager;
	// componentes
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblPass;
	private JPasswordField txtPass;
	private JPanel panelComponentes;
	// botonera
	private JButton btnIngresar;
	private JButton btnRegistrarse;
	private JPanel panelBotonera;

	public void armarLogIn(PanelManager panelManager) {
		
		this.panelManager=panelManager;
		setLayout(null);

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(59, 118, 360, 14);
		lblPass = new JLabel("Contraseña");
		lblPass.setBounds(59, 176, 360, 14);
		txtUsuario = new JTextField("",15);
		txtUsuario.setBounds(59, 143, 360, 20);
		txtPass = new JPasswordField("",15);
		txtPass.setBounds(59, 195, 360, 20);

		add(lblUsuario);
		add(lblPass);
		add(txtUsuario);
		add(txtPass);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(59, 278, 149, 69);
		btnRegistrarse= new JButton("Registrarse");
		btnRegistrarse.setBounds(270, 278, 149, 69);
		add(btnIngresar);
		add(btnRegistrarse);

		
		btnIngresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UsuarioService usuServ = new UsuarioService();
				Usuario control = new Usuario();
				Usuario valUsu = new Usuario();

				control.setUsuario(txtPass.getText().toString(), "", txtUsuario.getText().toString());
				valUsu = usuServ.validarUsuario(control.getUsuario(), control.getPass());// rol

				if (valUsu == null) {
					JOptionPane.showMessageDialog(null, "Credenciales Incorrectas", "Aviso",
					        JOptionPane.WARNING_MESSAGE);
					return;
				}
				// usuario es paciente
				if (valUsu.getRol().equals("paciente")) {
					panelManager.mostrarMenuPaciente(valUsu);
				}
				if (valUsu.getRol().equals("admin")) {
					panelManager.mostrarVistaAdmin(valUsu);
				}
			
			}
		});
		
		btnRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Verificacion de usuario
                panelManager.mostrarRegistrarse();
            }
        });
	}
}
