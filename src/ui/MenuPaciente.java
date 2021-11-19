package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Service.OdontologoService;
import Service.TurnoService;
import imp.Odontologo;
import imp.Turno;
import imp.Usuario;

public class MenuPaciente extends JPanel {
	private PanelManager panelManager;
	
	private Usuario usu = new Usuario();
	
	public void guardarPaciente (Usuario usuario) {
    	this.usu=usuario;
    }

    //componentes
    private JLabel lblBienvenido;
    private JPanel panelEncabezado;

    private JLabel lblOdontologos;
    private JComboBox cmbOdontologos;
    private JLabel lblTurnos;
    private JComboBox cmbTurnos;

    private JPanel panelComponentes;

    //botonera
    private JButton btnVisualizarTurnos;
    private JButton btnConfirmarTurno;
    private JPanel panelBotonera;

    public void armarMenuPaciente(PanelManager panelManager){
    	this.panelManager = panelManager;
        setLayout(new BorderLayout());

        lblBienvenido=new JLabel("Bienvenido al sistema");
        lblOdontologos= new JLabel("Seleccione odontologo: ");
        lblTurnos= new JLabel("Seleccione turno: ");
        cmbOdontologos = new JComboBox();
        cmbTurnos=new JComboBox();
        
        OdontologoService odnService = new OdontologoService();
        ArrayList<Odontologo> listaOdontologos = odnService.listar();
        for(Odontologo odn:listaOdontologos) {
        	cmbOdontologos.addItem(odn.getNombre());
        }

        panelEncabezado = new JPanel(new FlowLayout());
        panelEncabezado.add(lblBienvenido);

        panelComponentes= new JPanel(new FlowLayout());
        panelComponentes.add(lblOdontologos);
        panelComponentes.add(cmbOdontologos);
        panelComponentes.add(lblTurnos);
        panelComponentes.add(cmbTurnos);

        btnVisualizarTurnos = new JButton("Visualizar turnos");
        btnConfirmarTurno = new JButton("Confirmar Turno");
        panelBotonera = new JPanel(new FlowLayout());
        panelBotonera.add(btnVisualizarTurnos);
        panelBotonera.add(btnConfirmarTurno);

        add(panelEncabezado,BorderLayout.NORTH);
        add(panelComponentes, BorderLayout.CENTER);
        add(panelBotonera, BorderLayout.SOUTH);
        
        btnVisualizarTurnos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Verificacion de usuario
                panelManager.mostrarTurno(usu);
            }
        });
        
        btnConfirmarTurno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Verificacion de usuario
            	
            	int indiceCmbOdontologos = cmbOdontologos.getSelectedIndex();
            	int indiceCmbTurnos = cmbTurnos.getSelectedIndex();
            	
            	
            	if (indiceCmbOdontologos==-1 || indiceCmbTurnos==-1) {

            		JOptionPane.showMessageDialog(null, "Faltan elegir opciones", "Verificar", JOptionPane.WARNING_MESSAGE);
            	}else {
            		
            		int odontologoID = cmbOdontologos.getSelectedIndex()+1;
            	
            	
                Turno nuevoTurno = new Turno();
                TurnoService turnoService = new TurnoService();
            	
                nuevoTurno.setDisponible(false);
                nuevoTurno.setFecha(cmbTurnos.getSelectedItem().toString());
                nuevoTurno.setOdontologo(cmbOdontologos.getSelectedItem().toString());
                nuevoTurno.setId(0);
                //nuevoTurno.setPaciente(usu.getId());
            	
                turnoService.guardar(nuevoTurno);
                JOptionPane.showMessageDialog(null, "Turno Creado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                
                panelManager.mostrarTurno(usu);
            	}
            }
        });
        
        cmbOdontologos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	cmbTurnos.removeAllItems();
            	String control = null;
            	control=cmbOdontologos.getSelectedItem().toString();
            	System.out.print("COntrol: "+control);
            	TurnoService turnosService = new TurnoService();
    	        ArrayList<Turno> listaTurnos = turnosService.listar();
    	        
    	        for(Turno turno : listaTurnos){
    	        	if (turno.getOdontologo().equals(control)){
    	        		cmbTurnos.addItem(turno.getDisponible());
    	        	}    
    	        }
            }
        });
    
    }

}
