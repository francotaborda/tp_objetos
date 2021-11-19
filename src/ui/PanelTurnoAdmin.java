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


public class PanelTurnoAdmin  extends JPanel {
	 private PanelManager panelManager;
	    
	    //Listado - Grilla - Tabla
	    private JTable jtable;
	    private DefaultTableModel contenidoTable;
	    private JScrollPane scrollPane;

	    //Botonera
	    private JButton btnVolver;
	    private JPanel panelBotonera;
	    public void guardarPaciente (Usuario usuario) {
	    }
	    

	    public void armarPanelListaTurnoAdmin(PanelManager panelManager)
	    {
	        setLayout(new BorderLayout());
	        this.panelManager = panelManager;
	       
	        //creacion botonera (Nueva-Mdificar-Eliminar)
	        btnVolver= new JButton("Volver");
	        panelBotonera = new JPanel();
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

	        TurnoService service = new TurnoService();
		    ArrayList<Turno> lista1 = service.listar();
		    	        
		    for(Turno turno : lista1){
		    	
		    	Object [] row = new Object[4];
		    	row[0] = turno.getId();
		    	row[1] = turno.getOdontologo();
		    	row[2] = turno.getDisponible();
		    	row[3] = turno.getFecha();		
		    	contenidoTable.addRow(row);  
		    	        }
	        add(panelBotonera, BorderLayout.SOUTH);
	        add(scrollPane, BorderLayout.CENTER);

	        
	        btnVolver.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					panelManager.mostrarVistaAdmin(null);
					}
			
			});
	    }}
	    