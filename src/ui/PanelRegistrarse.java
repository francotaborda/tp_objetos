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

import Service.PacienteService;
import Service.TurnoService;
import imp.Paciente;
import imp.Turno;

public class PanelRegistrarse extends JPanel {
	private PanelManager panelManager;

    //componentes
    private JLabel lblRegistrarse;
    private JPanel panelEncabezado;

    private JPanel panelFormulario;

    private JPanel panelNombre;
    private JPanel panelApellido;
    private JPanel panelDomicilio;
    private JPanel panelDNI;
    private JPanel panelNombreUsuario;
    private JPanel panelPassword;

    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblDomicilio;
    private JLabel lblDNI;
    private JLabel lblNombreUsuario;
    private JLabel lblPassword;

    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDomicilio;
    private JTextField txtDNI;
    private JTextField txtNombreUsuario;
    private JPasswordField txtPassword;

    //botonera
    private JButton btnConfirmar;
    private JButton btnCancelar;
    private JPanel panelBotonera;

    public void armarRegistrarsePanel(PanelManager panelManager){
        this.panelManager = panelManager;
        setLayout(null);

        lblRegistrarse = new JLabel("Registrarse");
        panelEncabezado=new JPanel();
        panelEncabezado.add(lblRegistrarse);

        lblNombre= new JLabel("Nombre");
        lblNombre.setBounds(59, 43, 179, 14);
        add(lblNombre);
        
        lblApellido= new JLabel("Apellido: ");
        lblApellido.setBounds(240, 43, 179, 14);
        add(lblApellido);
        
        lblDomicilio= new JLabel("Domicilio: ");
        lblDomicilio.setBounds(59, 95, 179, 14);
        add(lblDomicilio);
        
        lblDNI= new JLabel("DNI: ");
        lblDNI.setBounds(240, 95, 179, 14);
        add(lblDNI);
        
        lblNombreUsuario= new JLabel("Nombre Usuario: ");
        lblNombreUsuario.setBounds(59, 145, 179, 14);
        add(lblNombreUsuario);
        
        lblPassword= new JLabel("Contraseña: ");
        lblPassword.setBounds(240, 145, 179, 14);
        add(lblPassword);

        txtNombre = new JTextField("",10);;
        txtNombre.setBounds(59, 64, 141, 20);
        add(txtNombre);
        
        txtApellido= new JTextField("",10);;
        txtApellido.setBounds(240, 64, 141, 20);
        add(txtApellido);
        
        txtDomicilio= new JTextField("",10);;
        txtDomicilio.setBounds(59, 114, 141, 20);
        add(txtDomicilio);
        
        txtDNI= new JTextField("",10);;
        txtDNI.setBounds(240, 114, 141, 20);
        add(txtDNI);
        
        txtNombreUsuario= new JTextField("",10);;
        txtNombreUsuario.setBounds(59, 162, 141, 20);
        add(txtNombreUsuario);
        
        txtPassword= new JPasswordField("",10);;
        txtPassword.setBounds(240, 162, 141, 20);
        add(txtPassword);

        
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(59, 216, 322, 23);
        add(btnConfirmar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(128, 250, 190, 23);
        add(btnCancelar);
        
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String nombre = txtNombre.getText().toString();
            	String apellido=txtApellido.getText().toString();
            	String domicilio=txtDomicilio.getText().toString();
            	int DNI;
            	if (txtDNI.getText().equals("")) { 
                    DNI = 0; 
                } else { 
                   DNI = Integer.parseInt(txtDNI.getText()); 
                }
            	
            	String nombreUsuario=txtNombreUsuario.getText().toString();
            	//String contraseña=new String(txtPassword.getPassword().toString());
            	String contraseña=txtPassword.getText().toString();
            	
            	System.out.println("contraseña "+ txtPassword.getText().toString());
            	
            	
            	if(nombre.equals("") || apellido.equals("") || domicilio.equals("") || DNI==0|| nombreUsuario.equals("") || contraseña.equals("")) {
            		
            		JOptionPane.showMessageDialog(null, "Falta informacion", "Aviso", JOptionPane.WARNING_MESSAGE);
            		
            	}else {
            		PacienteService pacServ = new PacienteService();
    				
    				boolean resultado = pacServ.existePaciente(DNI, nombreUsuario);

    				if (resultado == true) {
    					JOptionPane.showMessageDialog(null, "Usuario ya existente", "Aviso",
    					        JOptionPane.INFORMATION_MESSAGE);
    				}else {
    					Paciente paciente = new Paciente();
    				
    				paciente.setNombre(nombre);
            		paciente.setApellido(apellido);
            		paciente.setDomicilio(domicilio);
            		paciente.setDNI(DNI);
            		paciente.setNombreUsuario(nombreUsuario);
            		System.out.println("nombreUsuario "+ paciente.getNombreUsuario());
            		paciente.setApellido(apellido);
            		paciente.setPass(contraseña);
            		System.out.println("contra "+ paciente.getPass());
    				
    				pacServ.guardar(paciente);
            		JOptionPane.showMessageDialog(null, "Paciente Creado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            		panelManager.mostrarPanelLogIn();
            	}}
            
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Verificacion de usuario
                panelManager.mostrarPanelLogIn();
            }
        });
    }
}
