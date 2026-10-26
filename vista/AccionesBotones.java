package vista;

import javax.swing.JButton;
import java.awt.event.ActionListener;

public class AccionesBotones {

    private final Componentes componentes;

    public AccionesBotones(Componentes componentes) {
        this.componentes = componentes;
    }

    
    public void configurarCerrar(JButton botonCerrar) {
        ActionListener accion = e -> componentes.cerrarVentana();
        botonCerrar.addActionListener(accion);
    }

    
    public void configurarNavegacion(JButton botonNavegar, String nombrePanel) {
        ActionListener accion = e -> componentes.mostrarPanel(nombrePanel);
        botonNavegar.addActionListener(accion);
    }
    public void configurarAccion( JButton boton, Runnable accion) {
        boton.addActionListener(e -> accion.run());
    }
}