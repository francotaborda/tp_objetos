package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Service.OdontologoService;
import Service.PacienteService;
import Service.TurnoService;
import imp.Odontologo;
import imp.Paciente;
import imp.Turno;
import imp.Usuario;

public class PanelAdminPacientes extends JPanel{

	private PanelManager panelManager;
	
	private Usuario usu = new Usuario();
    public void guardarUsuario (Usuario usuario) {
    	this.usu=usuario;
    }

	// componentes
	private JPanel panelComponentes;
	
	private JTable jtable;
    private DefaultTableModel contenidoTable;
    private JScrollPane scrollPane;

	// Botonera
	private JButton btnBaja;
	private JButton btnModificar;
	private JButton btnVolver;
	private JPanel panelBotonera;
	
	private JLabel lblTitulo;

	public void panelAdminPacientes(PanelManager panelManager) {
		setLayout(new BorderLayout());
		this.panelManager = panelManager;
		
		//creacion combo
		
		
		//llamar servicio pacientes
        PacienteService pacienteService = new PacienteService();
        ArrayList<Paciente> listaPacientes = pacienteService.listar();
     
        panelComponentes = new JPanel(new FlowLayout());
        lblTitulo = new JLabel("Gestionar Pacientes"); 
        panelComponentes.add(lblTitulo);
		
		btnBaja = new JButton("Dar de baja");
		btnModificar = new JButton("Modificar");
		btnVolver = new JButton("Volver");
		panelBotonera = new JPanel();
		panelBotonera.add(btnVolver);
        panelBotonera.add(btnBaja);
        panelBotonera.add(btnModificar);
        
      //Listado - Grilla - Tabla de Cuentas
        contenidoTable = new DefaultTableModel();
        jtable = new JTable(contenidoTable);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(jtable);
        
        contenidoTable.addColumn("ID");
        contenidoTable.addColumn("NOMBRE");
        contenidoTable.addColumn("APELLIDO");
        contenidoTable.addColumn("DNI");
        contenidoTable.addColumn("NOMBRE USUARIO");

        add(panelBotonera, BorderLayout.SOUTH);
        add(panelComponentes, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
            	
    	for(Paciente paciente : listaPacientes){
    	        	
    		Object [] row = new Object[5];
    	    row[0] = paciente.getId();
    	    row[1] = paciente.getNombre();
    	    row[2] = paciente.getApellido();
    	    row[3] = paciente.getDNI();
    	    row[4] = paciente.getNombreUsuario();
    	    contenidoTable.addRow(row);}        
    	
    	btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Paciente pac = new Paciente();
				PacienteService servicePac = new PacienteService();
                long id = (long) jtable.getValueAt( jtable.getSelectedRow() ,0);
                String nombre = (String) jtable.getValueAt( jtable.getSelectedRow() ,1);
                String apellido = (String) jtable.getValueAt( jtable.getSelectedRow() ,2);
                int  dni = (int) jtable.getValueAt( jtable.getSelectedRow() ,3);
                String nombreUsuario = (String) jtable.getValueAt( jtable.getSelectedRow() ,4);
                servicePac.eliminar(id);
                
                pac.setApellido(apellido);
                pac.setDNI(dni);
                pac.setNombre(nombre);
                pac.setNombreUsuario(nombreUsuario);
                pac.setId(0);
                servicePac.guardar(pac);
                JOptionPane.showMessageDialog(null, "Paciente modificado", "Aviso", JOptionPane.WARNING_MESSAGE);
                
      			}
		});
    	btnBaja.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Paciente pac = new Paciente();
				PacienteService servicePac = new PacienteService();
                long id = (long) jtable.getValueAt( jtable.getSelectedRow() ,0);
                servicePac.eliminar(id);
                JOptionPane.showMessageDialog(null, "Paciente eliminado", "Aviso", JOptionPane.WARNING_MESSAGE);
                
    	
  			}
	});
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			panelManager.mostrarVistaAdmin(usu);
			}
		});
    	
    	
	}
}
    	
