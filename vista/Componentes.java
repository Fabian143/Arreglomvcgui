package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.Numeros;

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

        tarjetas = new CardLayout();
        contenedor = new JPanel(tarjetas);
        campoTexto = new JTextField();
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

    public JTextField agregarCampoTexto(JPanel panel, int columnas) {
        campoTexto = new JTextField(columnas);
        panel.add(campoTexto);
        return campoTexto;
    }

    public String obtenerTexto() {
        return campoTexto.getText();
    }

    public void limpiarCampoTexto() {
        campoTexto.setText("");
    }

    public void agregarPanel(String nombre, JPanel panel) {
        for (Component componente : contenedor.getComponents()) {
            if (nombre.equals(componente.getName())) {
                contenedor.remove(componente);
                break;
            }
        }
        panel.setName(nombre);
        contenedor.add(panel, nombre);
    }

    public void mostrarPanel(String nombre) {
        tarjetas.show(contenedor, nombre);
    }

    public JTextArea agregarAreaMensajes(JPanel panel, int filas, int columnas) {
        JTextArea area = new JTextArea(filas, columnas);
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        panel.add(area);
        return area;
    }

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

    public void mostrarPantallaInicio(String mensaje, Runnable accionContinuar) {
        JPanel panelInicio = new JPanel(new BorderLayout(10, 10));
        JLabel lblBienvenida = new JLabel(mensaje, JLabel.CENTER);
        JButton btnContinuar = new JButton("Continuar al Menú");

        panelInicio.add(lblBienvenida, BorderLayout.CENTER);
        panelInicio.add(btnContinuar, BorderLayout.SOUTH);

        new AccionesBotones(this).configurarAccion(btnContinuar, accionContinuar);

        agregarPanel("PANEL_INICIO", panelInicio);
        mostrarPanel("PANEL_INICIO");
    }

    public void mostrarMenuPrincipal(Runnable opcion1, Runnable opcion2, Runnable opcion3, Runnable opcion4) {
        JPanel panelMenu1 = new JPanel(new BorderLayout(10, 10));
        JPanel panelOpciones = new JPanel(new java.awt.GridLayout(2, 2, 10, 10));

        JButton btnOp1 = agregarBoton(panelOpciones, "Opcion 1: Escribir 10 numeros");
        JButton btnOp2 = agregarBoton(panelOpciones, "Opcion 2: Escribir n numeros");
        JButton btnOp3 = agregarBoton(panelOpciones, "Opcion 3: Llenar 10 aleatorios");
        JButton btnOp4 = agregarBoton(panelOpciones, "Opcion 4: Llenar n aleatorios");

        panelMenu1.add(panelOpciones, BorderLayout.CENTER);

        new AccionesBotones(this).configurarAccion(btnOp1, opcion1);
        new AccionesBotones(this).configurarAccion(btnOp2, opcion2);
        new AccionesBotones(this).configurarAccion(btnOp3, opcion3);
        new AccionesBotones(this).configurarAccion(btnOp4, opcion4);

        agregarPanel("PANEL_MENU1", panelMenu1);
        mostrarPanel("PANEL_MENU1");
    }

    public void mostrarMenuOperaciones(
        Runnable opcion1,
        Runnable opcion2,
        Runnable opcion3,
        Runnable opcion4,
        Runnable opcion5,
        Runnable opcion6,
        Runnable opcion7,
        Runnable opcion8
    ) {
        JPanel panelMenu2 = new JPanel(new BorderLayout(10, 10));
        JPanel panelOpciones = new JPanel(new java.awt.GridLayout(4, 2, 10, 10));

        JButton btnOp1 = agregarBoton(panelOpciones, "Opcion 1: Escribir 10 numeros");
        JButton btnOp2 = agregarBoton(panelOpciones, "Opcion 2: Escribir n numeros");
        JButton btnOp3 = agregarBoton(panelOpciones, "Opcion 3: Llenar 10 aleatorios");
        JButton btnOp4 = agregarBoton(panelOpciones, "Opcion 4: Llenar n aleatorios");
        JButton btnOp5 = agregarBoton(panelOpciones, "Opción 5: Mostrar números");
        JButton btnOp6 = agregarBoton(panelOpciones, "Opción 6: Eliminar número");
        JButton btnOp7 = agregarBoton(panelOpciones, "Opción 7: Calcular sumatoria");
        JButton btnSalir = agregarBoton(panelOpciones, "Opción 8: Salir del programa");

        panelMenu2.add(panelOpciones, BorderLayout.CENTER);

        new AccionesBotones(this).configurarAccion(btnOp1, opcion1);
        new AccionesBotones(this).configurarAccion(btnOp2, opcion2);
        new AccionesBotones(this).configurarAccion(btnOp3, opcion3);
        new AccionesBotones(this).configurarAccion(btnOp4, opcion4);
        new AccionesBotones(this).configurarAccion(btnOp5, opcion5);
        new AccionesBotones(this).configurarAccion(btnOp6, opcion6);
        new AccionesBotones(this).configurarAccion(btnOp7, opcion7);
        new AccionesBotones(this).configurarAccion(btnSalir, opcion8);

        agregarPanel("PANEL_MENU2", panelMenu2);
        mostrarPanel("PANEL_MENU2");
    }

    public void mostrarFormularioDiezNumeros(Consumer<double[]> onGuardar, Runnable onError, Runnable onSiguiente) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel panelCampos = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField[] campos = new JTextField[10];

        for (int i = 0; i < 10; i++) {
            JLabel etiqueta = new JLabel("Número " + (i + 1) + ":");
            JTextField campo = new JTextField(12);
            campos[i] = campo;

            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.weightx = 0.0;
            gbc.anchor = GridBagConstraints.LINE_END;
            panelCampos.add(etiqueta, gbc);

            gbc.gridx = 1;
            gbc.weightx = 1.0;
            gbc.anchor = GridBagConstraints.LINE_START;
            panelCampos.add(campo, gbc);
        }

        JButton btnTerminar = new JButton("Terminar");
        panel.add(panelCampos, BorderLayout.CENTER);
        panel.add(btnTerminar, BorderLayout.SOUTH);

        new AccionesBotones(this).configurarAccion(btnTerminar, () -> {
            try {
                double[] valores = new double[10];
                for (int i = 0; i < 10; i++) {
                    valores[i] = Double.parseDouble(campos[i].getText().trim());
                }
                onGuardar.accept(valores);
                onSiguiente.run();
            } catch (NumberFormatException e) {
                for (JTextField campo : campos) {
                    campo.setText("");
                }
                onError.run();
            }
        });

        agregarPanel("PANEL_LLENAR_10", panel);
        mostrarPanel("PANEL_LLENAR_10");
    }

    public void mostrarFormularioNValores(DoubleConsumer onAgregar, Runnable onTerminar, Runnable onError) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel panelEntrada = new JPanel(new GridBagLayout());
        JPanel panelBotones = new JPanel(new java.awt.FlowLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblNumero = new JLabel("Ingresa un número:");
        JTextField campoNumero = new JTextField(12);
        JLabel lblCantidad = new JLabel("Números ingresados: 0");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelEntrada.add(lblNumero, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelEntrada.add(campoNumero, gbc);

        JButton btnAgregar = new JButton("Agregar número");
        JButton btnTerminar = new JButton("Terminar");
        panelBotones.add(btnAgregar);
        panelBotones.add(btnTerminar);

        panel.add(panelEntrada, BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);
        panel.add(lblCantidad, BorderLayout.NORTH);

        new AccionesBotones(this).configurarAccion(btnAgregar, () -> {
            try {
                double numero = Double.parseDouble(campoNumero.getText().trim());
                onAgregar.accept(numero);
                lblCantidad.setText("Números ingresados: " + Numeros.numeros2.size());
                campoNumero.setText("");
                campoNumero.requestFocusInWindow();
            } catch (NumberFormatException e) {
                campoNumero.setText("");
                onError.run();
                campoNumero.requestFocusInWindow();
            }
        });

        new AccionesBotones(this).configurarAccion(btnTerminar, onTerminar);

        agregarPanel("PANEL_INGRESAR_N", panel);
        mostrarPanel("PANEL_INGRESAR_N");
    }

    public void mostrarFormularioGenerarAleatorios(IntConsumer onGenerar, Runnable onError) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel panelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblCantidad = new JLabel("Cantidad de números aleatorios:");
        JTextField campoCantidad = new JTextField(12);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.LINE_END;
        panelEntrada.add(lblCantidad, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelEntrada.add(campoCantidad, gbc);

        JButton btnGenerar = new JButton("Generar números");
        panel.add(panelEntrada, BorderLayout.CENTER);
        panel.add(btnGenerar, BorderLayout.SOUTH);

        new AccionesBotones(this).configurarAccion(btnGenerar, () -> {
            try {
                int cantidad = Integer.parseInt(campoCantidad.getText().trim());
                if (cantidad <= 0) {
                    onError.run();
                    return;
                }
                onGenerar.accept(cantidad);
            } catch (NumberFormatException e) {
                campoCantidad.setText("");
                onError.run();
                campoCantidad.requestFocusInWindow();
            }
        });

        agregarPanel("PANEL_ALEATORIOS_N", panel);
        mostrarPanel("PANEL_ALEATORIOS_N");
    }

    private void aplicarCampoCompacto(JTextField campo) {
        campo.setPreferredSize(new Dimension(180, 26));
        campo.setMinimumSize(new Dimension(180, 26));
        campo.setMaximumSize(new Dimension(180, 26));
    }

    public String pedirTexto(String mensaje) {
        return JOptionPane.showInputDialog(ventana, mensaje);
    }

    public void mostrarDialogoInformacion(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(ventana, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
