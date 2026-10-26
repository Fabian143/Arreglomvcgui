package vista;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;


public class MostrarInfoGUI {

    private final Componentes componentes;
    private final JTextArea areaMensajes;

    public MostrarInfoGUI(Componentes componentes, JPanel panel) {

        this.componentes = componentes;

        // Crea el área de mensajes con 30 filas y 50 columnas
        areaMensajes = componentes.agregarAreaMensajes(panel, 30, 50);

       
    }

    public MostrarInfoGUI(Componentes componentes) {
		this.componentes = componentes;
		this.areaMensajes = new JTextArea();
	}

	// Imprime un mensaje en el área de texto
    public void imprimirMensaje(String mensaje) {
        areaMensajes.append(mensaje + "\n");
    }

    // Muestra una ventana emergente de error
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null,mensaje,"Error",JOptionPane.ERROR_MESSAGE);
    }

    // Borra los mensajes impresos
    public void limpiarMensajes() {
        areaMensajes.setText("");
    }

	public Componentes getComponentes() {
		return componentes;
	}
}
