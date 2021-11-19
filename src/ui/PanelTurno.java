package ui;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Service.OdontologoService;
import Service.TurnoService;
import Service.UsuarioService;
import imp.Odontologo;
import imp.Turno;
import imp.Usuario;


public class PanelTurno  extends JPanel {
	 private PanelManager panelManager;
	 	
	 	private Usuario usu = new Usuario();
	    //componentes

	    private JComboBox odontologos;
	    private JPanel panelComponentes;
	    
	    //Listado - Grilla - Tabla
	    private JTable jtable;
	    private DefaultTableModel contenidoTable;
	    private JScrollPane scrollPane;

	    //Botonera
	    private JButton btnModificar;
	    private JButton btnVolver;
	    private JPanel panelBotonera;
	    public void guardarUsuario (Usuario usuario) {
	    	this.usu=usuario;
	    }
	    

	    public void armarPanelListaTurno(PanelManager panelManager)
	    {
	        setLayout(new BorderLayout());
	        this.panelManager = panelManager;
	        //creacion combo
	        odontologos = new JComboBox();
	        OdontologoService odn = new OdontologoService();
	        ArrayList<Odontologo> lista = odn.listar();
	        for(Odontologo ca:lista) {
	        	odontologos.addItem(ca.getNombre());
	        }
	        //odontologos.addItem("pepe");
	        //odontologos.addItem("juan");
	        panelComponentes = new JPanel(new GridLayout());
	        panelComponentes.add(odontologos);
	        
	        //creacion botonera (Nueva-Mdificar-Eliminar)
	        btnVolver= new JButton("Volver");
	        btnModificar = new JButton("Modificar");
	        panelBotonera = new JPanel();
	        panelBotonera.add(btnModificar);
	        panelBotonera.add(btnVolver);


	        //Listado - Grilla - Tabla de Cuentas
	        contenidoTable = new DefaultTableModel();
	        jtable = new JTable(contenidoTable);
	        scrollPane = new JScrollPane();
	        scrollPane.setViewportView(jtable);

	        contenidoTable.addColumn("ID");
	        contenidoTable.addColumn("ODON");
	        contenidoTable.addColumn("DISPONIBLE");
	        contenidoTable.addColumn("FECHA");

	        add(panelBotonera, BorderLayout.SOUTH);
	        add(panelComponentes, BorderLayout.NORTH);
	        add(scrollPane, BorderLayout.CENTER);

	        odontologos.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	String control = null;
	            	control=odontologos.getSelectedItem().toString();

	            	TurnoService service = new TurnoService();
	    	        ArrayList<Turno> lista1 = service.listar();
	    	        
	    	        for(Turno turno : lista1){
	    	        	if (turno.getOdontologo().equals(control)){
	    	            Object [] row = new Object[4];
	    	            row[0] = turno.getId();
	    	            row[1] = turno.getOdontologo();
	    	            row[2] = turno.getDisponible();
	    	            row[3] = turno.getFecha();		
	    	            contenidoTable.addRow(row);}    
	    	        }
	            }
	        });
	        
	        /*btnModificar.addActionListener(new ActionListener() {
	            @Override
	            
	        });*/
	        
	        
	        btnVolver.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(usu.getRol().equals("admin")) {
						panelManager.mostrarVistaAdmin(usu);
					}else {
						panelManager.mostrarMenuPaciente(usu);
					}
					
				}
			});
	    }}
	    