
package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Componentes {

    private final JFrame ventana;
    private final JPanel contenedor;
    private final CardLayout tarjetas;
 
    private JLabel lblTitulo;
    private JTextField campoTexto;
    
    public Componentes(String titulo) {
        ventana = new JFrame(titulo);
        ventana.setUndecorated(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 400);
        ventana.setLocationRelativeTo(null);
        
        //se inizializan las variables de la clase
        tarjetas = new CardLayout();
        contenedor = new JPanel(tarjetas);
		campoTexto=new JTextField();
        lblTitulo = new JLabel(titulo, JLabel.CENTER);


        ventana.setLayout(new BorderLayout(5, 5));
        ventana.add(lblTitulo, BorderLayout.NORTH);
        ventana.add(contenedor, BorderLayout.CENTER);
       
    }
    
    
    public JButton agregarBoton(JPanel panel, String textoBoton) {
        JButton boton = new JButton(textoBoton);
        panel.add(boton);
        return boton;
    }
    
    
 // Crea un campo de escritura para que el usuario escriba informacion y lo agrega al panel indicado
    public JTextField agregarCampoTexto(JPanel panel, int columnas) {//las columnas son las cantida de caracteres que puede contener el campodetexto por ejemplo "abcdefghij" tiene 10 caracteres

        campoTexto = new JTextField(columnas);
        panel.add(campoTexto);

        return campoTexto;
    }

    
    // Lee el contenido del campo
    public String obtenerTexto() {
        return campoTexto.getText();
    }

    // Borra el contenido del campo
    public void limpiarCampoTexto() {
        campoTexto.setText("");
    }
    

    public void agregarPanel(String nombre, JPanel panel) {
        // El nombre es el identificador con el que se registra
        // el panel dentro del contenedor.
        contenedor.add(panel, nombre);
    }

    public void mostrarPanel(String nombre) {
        // El nombre debe coincidir con el identificador asignado
        // al agregar el panel. Conviene evitar nombres repetidos.
        tarjetas.show(contenedor, nombre);
    }

    // Agrega un área de texto para imprimir mensajes al panel indicado.
    public JTextArea agregarAreaMensajes(JPanel panel, int filas, int columnas) {

        JTextArea area = new JTextArea(filas, columnas);
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        panel.add(area);
        return area;
    }

    // Agrega un área de texto con desplazamiento.
    public JScrollPane agregarScrollMensajes(JPanel panel, JTextArea area) {

        JScrollPane scroll = new JScrollPane(area);
        panel.add(scroll);
        return scroll;
    }

    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    public void mostrarVentana() {
        ventana.setVisible(true);
    }

    public void cerrarVentana() {
        ventana.dispose();
    }

	public JTextField getCampoTexto() {
		return campoTexto;
	}

	public void setCampoTexto(JTextField campoTexto) {
		this.campoTexto = campoTexto;
	}


	public Component getVentana() {
		return ventana;
	}
}


