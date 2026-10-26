package controlador;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import vista.AccionesBotones;
import vista.Componentes;

public class Inicio1 {
    protected final Componentes componentes;
    protected final AccionesBotones accionesBotones;
    
    private final String[] mensajesBienvenida = {
        "Hola bienvenido al programa -_-",
        "Hola bienvenido al programa :)",
        "Hola bienvenido al programa :(",
        "Hola bienvenido al programa, espero que te guste",
        "Hola bienvenido al programa, el dia de hoy vamos a jugar con numeros"
    };

    public Inicio1(Componentes componentes) {
        this.componentes = componentes;
        this.accionesBotones = new AccionesBotones(componentes);
        
        // Creamos y mostramos la pantalla de inicio
    	ejecutarInicio();
        
    }



private void ejecutarInicio() {
    int indice = (int) (Math.random() * mensajesBienvenida.length);
    String mensajeSeleccionado = mensajesBienvenida[indice];

    JLabel lblBienvenida = new JLabel(mensajeSeleccionado, JLabel.CENTER);

    JPanel panelInicio = new JPanel();
    panelInicio.setLayout(new java.awt.BorderLayout(10, 10));

    panelInicio.add(lblBienvenida, java.awt.BorderLayout.CENTER);

    JButton btnContinuar = new JButton("Continuar al Menú");
    panelInicio.add(btnContinuar, java.awt.BorderLayout.SOUTH);
    
    //boton que lleva al siguiente panel
    accionesBotones.configurarAccion(btnContinuar, () -> new Menu1(componentes));
   

    componentes.agregarPanel("PANEL_INICIO", panelInicio);
    componentes.mostrarPanel("PANEL_INICIO");
}


}