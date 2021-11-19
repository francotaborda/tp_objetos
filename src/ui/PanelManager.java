package ui;

import javax.swing.*;

import imp.Turno;
import imp.Usuario;

public class PanelManager {

	private PanelLogIn panelLogIn;
	private PanelRegistrarse panelRegistrarse;
	private MenuPaciente menuPaciente;
	private PanelTurno panelTurno;
	private PanelModificarTurno panelModificarTurno;
	private PanelAdmin panelAdmin;
	private PanelAdminOdontologos panelAdminOdontologos;
	private PanelAdminPacientes panelAdminPacientes;
	private PanelCrearOdontologo panelModOdontologo;

	private JFrame jframe;

	public void armarManager() {

		jframe = new JFrame();
		jframe.setBounds(200, 200, 500, 500);

		panelLogIn = new PanelLogIn();
		panelLogIn.armarLogIn(this);
		mostrarPanelLogIn();

		panelRegistrarse = new PanelRegistrarse();
		panelRegistrarse.armarRegistrarsePanel(this);

		panelTurno = new PanelTurno();
		panelTurno.armarPanelListaTurno(this);

		panelAdminOdontologos = new PanelAdminOdontologos();
		panelAdminOdontologos.panelAdminOdontologos(this);

		panelAdminPacientes = new PanelAdminPacientes();
		panelAdminPacientes.panelAdminPacientes(this);

		panelAdmin = new PanelAdmin();
		panelAdmin.armarPanelAdmin(this);

		panelModificarTurno = new PanelModificarTurno();
		panelModificarTurno.armarPanelListaTurno(this);

		menuPaciente = new MenuPaciente();
		menuPaciente.armarMenuPaciente(this);

		panelModOdontologo = new PanelCrearOdontologo();
		panelModOdontologo.armanrPanelCrearOdontologo(this);

		jframe.setVisible(true);
	}

	public void mostrarPanelLogIn() {
		jframe.getContentPane().removeAll();
		jframe.getContentPane().add(panelLogIn);
		jframe.getContentPane().validate();
		jframe.getContentPane().repaint();

	}

	public void mostrarTurno(Usuario usu) {
		panelTurno.guardarUsuario(usu);
		jframe.getContentPane().removeAll();
		jframe.getContentPane().add(panelTurno);
		jframe.getContentPane().validate();
		jframe.getContentPane().repaint();

	}

	public void modificarTurno(Turno turno, Usuario usu) {
		panelModificarTurno.guardarTurno(turno);
		panelModificarTurno.guardarPaciente(usu);

		jframe.getContentPane().removeAll();
		jframe.getContentPane().add(panelModificarTurno);
		jframe.getContentPane().validate();
		jframe.getContentPane().repaint();

	}

	public void mostrarVistaAdmin(Usuario valUsu) {
		panelAdmin.guardarUsuario(valUsu);
		jframe.getContentPane().removeAll();
		jframe.getContentPane().add(panelAdmin);
		jframe.getContentPane().validate();
		jframe.getContentPane().repaint();

	}

	public void mostrarVistaOdontologos(Usuario usu) {
		panelAdminOdontologos.guardarUsuario(usu);
		jframe.getContentPane().removeAll();
		jframe.getContentPane().add(panelAdminOdontologos);
		jframe.getContentPane().validate();
		jframe.getContentPane().repaint();
	}

	public void mostrarCrearOdontologos() {
		// panelAdmin.armarPanelAdmin();
		jframe.getContentPane().removeAll();
		jframe.getContentPane().add(panelModOdontologo);
		jframe.getContentPane().validate();
		jframe.getContentPane().repaint();
	}

	public void mostrarVistaPacientes(Usuario usu) {
		panelAdminPacientes.guardarUsuario(usu);
		jframe.getContentPane().removeAll();
		jframe.getContentPane().add(panelAdminPacientes);
		jframe.getContentPane().validate();
		jframe.getContentPane().repaint();
	}

	public void mostrarRegistrarse() {
		jframe.getContentPane().removeAll();
		jframe.getContentPane().add(panelRegistrarse);
		jframe.getContentPane().validate();
		jframe.getContentPane().repaint();
	}

	public void mostrarMenuPaciente(Usuario valUsu) {
		menuPaciente.guardarPaciente(valUsu);
		jframe.getContentPane().removeAll();
		jframe.getContentPane().add(menuPaciente);
		jframe.getContentPane().validate();
		jframe.getContentPane().repaint();
	}

}
