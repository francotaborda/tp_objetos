package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Service.OdontologoService;
import Service.TurnoService;
import imp.Odontologo;
import imp.Turno;
import imp.Usuario;

public class PanelAdminOdontologos extends JPanel {

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
	private JButton btnCrear;
	private JButton btnEditar;
	private JButton btnVolver;
	private JPanel panelBotonera;

	private JLabel lblTitulo;

	public void panelAdminOdontologos(PanelManager panelManager) {
		setLayout(new BorderLayout());
		this.panelManager = panelManager;

		// creacion combo
		OdontologoService odn = new OdontologoService();
		ArrayList<Odontologo> lista = odn.listar();

		panelComponentes = new JPanel(new FlowLayout());
		lblTitulo = new JLabel("Gestionar Odontologos");
		panelComponentes.add(lblTitulo);

		btnCrear = new JButton("crear odontologos");
		btnEditar = new JButton("editar odontologos");
		btnVolver = new JButton("Volver");

		panelBotonera = new JPanel();
		panelBotonera.add(btnCrear);
		panelBotonera.add(btnEditar);
		panelBotonera.add(btnVolver);

		// Listado - Grilla - Tabla de Cuentas
		contenidoTable = new DefaultTableModel();
		jtable = new JTable(contenidoTable);
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(jtable);

		contenidoTable.addColumn("ID");
		contenidoTable.addColumn("NOMBRE");
		contenidoTable.addColumn("APELLIDO");
		contenidoTable.addColumn("MATRICULA");

		add(panelBotonera, BorderLayout.SOUTH);
		add(panelComponentes, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);

		for (Odontologo odontologo : lista) {
			Object[] row = new Object[4];
			row[0] = odontologo.getId();
			row[1] = odontologo.getNombre();
			row[2] = odontologo.getApellido();
			row[3] = odontologo.getMatricula();
			contenidoTable.addRow(row);
		}

		btnCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			panelManager.mostrarCrearOdontologos();
			}
		});

		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

            	Odontologo odon = new Odontologo();
            	OdontologoService serviceOdon = new OdontologoService();
                long id = (long) jtable.getValueAt( jtable.getSelectedRow() ,0);
                String nombre = (String) jtable.getValueAt( jtable.getSelectedRow() ,1);
                String apellido = (String) jtable.getValueAt( jtable.getSelectedRow() ,2);
                String  matricula = (String) jtable.getValueAt( jtable.getSelectedRow() ,3);
               
                serviceOdon.eliminar(id);
                
                odon.setApellido(apellido);
                odon.setMatricula(matricula);
                odon.setNombre(nombre);
                odon.setId(0);
                serviceOdon.guardar(odon);
                System.out.println(odon.getNombre());
                
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

/*
 * {
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * odontologos.addActionListener(new ActionListener() {
 * 
 * @Override public void actionPerformed(ActionEvent e) { String control = null;
 * control=odontologos.getSelectedItem().toString();
 * 
 * TurnoService service = new TurnoService(); ArrayList<Turno> lista1 =
 * service.listar();
 * 
 * for(Turno turno : lista1){ if (turno.getOdontologo().equals(control)){ Object
 * [] row = new Object[4]; row[0] = turno.getId(); row[1] =
 * turno.getOdontologo(); row[2] = turno.getDisponible(); row[3] =
 * turno.getFecha(); contenidoTable.addRow(row);}
 * 
 * 
 * }
 * 
 * } });
 * 
 * 
 * btnModificar.addActionListener(new ActionListener() {
 * 
 * @Override public void actionPerformed(ActionEvent e) { TurnoService service =
 * new TurnoService(); long id = (long) jtable.getValueAt(
 * jtable.getSelectedRow() ,0); Turno turno = service.recuperar(id);
 * panelManager.modificarTurno(turno,usu); } });
 * 
 * 
 * }
 * 
 * }
 */
