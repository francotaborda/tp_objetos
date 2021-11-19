package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Service.OdontologoService;
import Service.TurnoService;
import imp.Odontologo;
import imp.Turno;
import imp.Usuario;

public class PanelCrearOdontologo extends JPanel {
	private PanelManager panelManager;
	
	private Usuario usu = new Usuario();
    public void guardarPaciente (Usuario usuario) {
    	this.usu=usuario;
    }

	// componentes
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblMatricula;
	private JTextField txtMatricula;
	private JPanel panelComponentes;
	// botonera
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private JPanel panelBotonera;

    public void armanrPanelCrearOdontologo(PanelManager panelManager){
        this.panelManager = panelManager;
        setLayout(new BorderLayout());
        
        lblApellido = new JLabel("Apellido: ");
        txtApellido = new JTextField(15);
        lblNombre = new JLabel("Nombre: ");
        txtNombre = new JTextField(15);
        lblMatricula = new JLabel("Matricula: ");
        txtMatricula = new JTextField(15);
        panelComponentes = new JPanel(new FlowLayout());
        panelComponentes.add(lblApellido);
        panelComponentes.add(txtApellido);
        panelComponentes.add(lblNombre);
        panelComponentes.add(txtNombre);
        panelComponentes.add(lblMatricula);
        panelComponentes.add(txtMatricula);
        
        btnConfirmar = new JButton("Confirmar");
        btnCancelar= new JButton("Cancelar");
		panelBotonera = new JPanel();
		panelBotonera.add(btnConfirmar);
		panelBotonera.add(btnCancelar);
        
		// orden
		add(panelComponentes, BorderLayout.CENTER);
		add(panelBotonera, BorderLayout.SOUTH);
        
		btnConfirmar.addActionListener(new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent e) {
            	if(txtNombre.getText().toString()!="" && txtApellido.getText().toString()!="" && txtMatricula.getText().toString()!="") {
            		Odontologo odon = new Odontologo();
            		OdontologoService odonServ = new OdontologoService();
            		odon.setApellido(txtApellido.getText().toString());
            		odon.setNombre(txtNombre.getText().toString());
            		odon.setMatricula(txtMatricula.getText().toString());
            		odon.setId(0);
            		
            		odonServ.guardar(odon);         		
            		JOptionPane.showMessageDialog(null, "Odontologo creado", "Aviso", JOptionPane.WARNING_MESSAGE);
            		
            		
            	}else {
            		JOptionPane.showMessageDialog(null, "Falta informacion", "Aviso", JOptionPane.WARNING_MESSAGE);
            	}
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //vuelvo
                panelManager.mostrarVistaOdontologos(usu);
            }
        });
    }
}
