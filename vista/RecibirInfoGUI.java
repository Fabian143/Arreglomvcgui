package vista;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RecibirInfoGUI {

    private final Componentes componentes;

    public RecibirInfoGUI(Componentes componentes) {
        this.componentes = componentes;
    }

    // Crea un campo con una indicación y una caja de texto al lado.
    public JTextField agregarCampo(JPanel panel, String indicacion, int columnas) {

        JLabel etiqueta = new JLabel(indicacion);
        JTextField campo = componentes.agregarCampoTexto(panel, columnas);

        panel.add(etiqueta);
        panel.add(campo);

        return campo;
    }

    // Obtiene la información escrita en un campo específico.
    public String obtenerInformacion(JTextField campo) {
        return campo.getText();
    }

    // Limpia un campo específico.
    public void limpiarCampo(JTextField campo) {
        campo.setText("");
    }

    // Limpia varios campos si necesitas reiniciar un formulario.
    public void limpiarCampos(JTextField[] campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
    }
}