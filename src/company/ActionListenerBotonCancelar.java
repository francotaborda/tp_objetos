package company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerBotonCancelar implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clic sobre boton Cancelar");
    }
}
