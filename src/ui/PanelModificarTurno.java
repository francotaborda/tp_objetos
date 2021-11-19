package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import imp.Turno;
import imp.Usuario;

public class PanelModificarTurno extends JPanel {
 	private Usuario usu = new Usuario();
 	private Turno tur = new Turno();
    private PanelManager panelManager;
 	
    //componentes
    private JLabel lblId;
    private JLabel lblSaldo;
    private JTextField txtSaldo;
    private JLabel lblTipos;
    private JPanel panelComponentes;

    //botonera
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JPanel panelBotonera;
    
    
	public void guardarTurno(Turno turno) {
		this.tur=turno;
		
	}


	public void guardarPaciente(Usuario usuario) {
		this.usu=usuario;
		
	}
 	
    public void armarPanelListaTurno(PanelManager panelManager) {
    	this.panelManager = panelManager;
    	
        setLayout(new BorderLayout());
        
        lblId = new JLabel("ID turno: "+tur.getId());
        lblSaldo = new JLabel("Odon.: "+tur.getOdontologo());
        lblTipos = new JLabel("Tipo: ");
        txtSaldo = new JTextField(10);


        panelComponentes = new JPanel(new GridLayout());
        panelComponentes.add(lblId);
        panelComponentes.add(lblSaldo);
        panelComponentes.add(txtSaldo);
        panelComponentes.add(lblTipos);

        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        panelBotonera = new JPanel();
        panelBotonera.add(btnCancelar);
        panelBotonera.add(btnGuardar);

        add(panelComponentes, BorderLayout.CENTER);
        add(panelBotonera, BorderLayout.SOUTH);
        
    }




}
