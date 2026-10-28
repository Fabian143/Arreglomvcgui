package vista;

import javax.swing.JButton;
import java.awt.event.ActionListener;

public class AccionesBotones {

    private final Componentes componentes;

    //constructor De acciones botones solo le da el valor a componentes
    public AccionesBotones(Componentes componentes) {
        this.componentes = componentes;
    }

    public void configurarCerrar(JButton botonCerrar) {
       configurarAccion(botonCerrar, () -> componentes.cerrarVentana());
    }

    
    public void configurarNavegacion(JButton botonNavegar, String nombrePanel) {
        configurarAccion(botonNavegar, () -> componentes.mostrarPanel(nombrePanel));
    }
    
    public void configurarAccion( JButton boton, Runnable accion) {
        boton.addActionListener(e -> accion.run());
    }
}
