package controlador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Numeros;
import vista.Componentes;
import vista.MostrarInfoGUI;
import vista.RecibirInfoGUI;

public class Menu1 extends Inicio1 {
    
    final Numeros manejonumeros = new Numeros();
    protected final RecibirInfoGUI recibirInfo;
    protected final MostrarInfoGUI mostrarInfo;
    //protected AccionesBotones accionesbotones;
    
    public Menu1(Componentes componentes) {
        super(componentes);
        this.recibirInfo = new RecibirInfoGUI(componentes);
        this.mostrarInfo = new MostrarInfoGUI(componentes);
        ejecutarmenu();
    }
    
    private void ejecutarmenu() {
    	JPanel panelMenu1 = new JPanel(new BorderLayout(10, 10));
    	JPanel panelOpciones = new JPanel(new GridLayout(2, 2, 10, 10));

    	componentes.getLblTitulo().setText("Menú Inicial - Seleccione una opción");

    	creaciondebotonesprincipales(panelOpciones, panelMenu1);
    	
    	componentes.agregarPanel("PANEL_MENU1", panelMenu1);
    	componentes.mostrarPanel("PANEL_MENU1");
    }
    
    protected void avanzarAMenu2() {
        new Menu2(componentes);
    }
    
    public void opcion1() {
        manejonumeros.limpiar();
        manejonumeros.setEsarreglo(true);

        JPanel llenar10numeros = new JPanel(new BorderLayout(10, 10));
        JPanel panelCampos = new JPanel(new GridLayout(10, 2, 5, 5));

        JTextField[] campos = new JTextField[10];

        for (int i = 0; i < 10; i++) {
            campos[i] = recibirInfo.agregarCampo(panelCampos, "Número " + (i + 1) + ":", 10);
        }

        JButton btnTerminar = new JButton("Terminar");

        llenar10numeros.add(panelCampos, BorderLayout.CENTER);
        llenar10numeros.add(btnTerminar, BorderLayout.SOUTH);

        accionesBotones.configurarAccion(btnTerminar, () -> {
            try {
                double[] valores = new double[10];

                // Primero validamos todos los campos.
                for (int i = 0; i < 10; i++) {
                    valores[i] = Double.parseDouble(campos[i].getText().trim());
                }

                // Solo guardamos si los diez valores son válidos.
                for (int i = 0; i < 10; i++) {
                    manejonumeros.añadirElementoArreglo(i, valores[i]);
                }

                new Menu2(componentes);

            } catch (NumberFormatException e) {
            	recibirInfo.limpiarCampos(campos);
                mostrarInfo.mostrarError("Todos los campos deben contener números válidos.");
            }
        });

        componentes.agregarPanel("PANEL_LLENAR_10", llenar10numeros);
        componentes.mostrarPanel("PANEL_LLENAR_10");
    }
    

    public void opcion2() {
    	manejonumeros.limpiar();
    	manejonumeros.setEsarreglo(false);

    	JPanel panelOpcion2 = new JPanel(new BorderLayout(10, 10));
    	JPanel panelEntrada = new JPanel(new GridLayout(1, 2, 5, 5));
    	JPanel panelBotones = new JPanel(new FlowLayout());

    	JLabel lblNumero = new JLabel("Ingresa un número:");
    	JTextField campoNumero = new JTextField(10);

    	JLabel lblCantidad = new JLabel("Números ingresados: 0");
    	
    	panelEntrada.add(lblNumero);
    	panelEntrada.add(campoNumero);

    	JButton btnAgregar = new JButton("Agregar número");
    	JButton btnTerminar = new JButton("Terminar");

    	panelBotones.add(btnAgregar);
    	panelBotones.add(btnTerminar);

    	panelOpcion2.add(panelEntrada, BorderLayout.CENTER);
    	panelOpcion2.add(panelBotones, BorderLayout.SOUTH);
    	panelOpcion2.add(lblCantidad, BorderLayout.NORTH);

    	accionesBotones.configurarAccion(btnAgregar, () -> {
    		try {
    			double numero = Double.parseDouble(campoNumero.getText().trim());

    			manejonumeros.añadirElementoArray(numero);
    			
    			lblCantidad.setText("Números ingresados: " + Numeros.numeros2.size());
    			campoNumero.setText("");
    			campoNumero.requestFocusInWindow();

    		} catch (NumberFormatException e) {
    			recibirInfo.limpiarCampo(campoNumero);
    			mostrarInfo.mostrarError("Debes ingresar un número válido.");
    			campoNumero.requestFocusInWindow();
    		}
    	});

    	accionesBotones.configurarAccion(btnTerminar, () -> {
    		if (Numeros.numeros2.isEmpty()) {
    			mostrarInfo.mostrarError("Debes ingresar al menos un número.");
    			return;
    		}

    		new Menu2(componentes);
    	});

    componentes.agregarPanel("PANEL_INGRESAR_N", panelOpcion2);
    componentes.mostrarPanel("PANEL_INGRESAR_N");
}

    
    public void opcion3() {
        Numeros.numeros2.clear();
        manejonumeros.setEsarreglo(true);
        for(int i = 0; i < 10; i++) {
            manejonumeros.aleatorioArreglo(i);
        }
    }
    

    public void opcion4() {
    	manejonumeros.limpiar();
    	manejonumeros.setEsarreglo(false);

    	JPanel panelOpcion4 = new JPanel(new BorderLayout(10, 10));
    	JPanel panelEntrada = new JPanel(new GridLayout(1, 2, 5, 5));

    	JLabel lblCantidad = new JLabel("Cantidad de números aleatorios:");
    	JTextField campoCantidad = new JTextField(10);

    	panelEntrada.add(lblCantidad);
    	panelEntrada.add(campoCantidad);

    	JButton btnGenerar = new JButton("Generar números");

    	panelOpcion4.add(panelEntrada, BorderLayout.CENTER);
    	panelOpcion4.add(btnGenerar, BorderLayout.SOUTH);

    	accionesBotones.configurarAccion(btnGenerar, () -> {
    		try {
    			int cantidad = Integer.parseInt(campoCantidad.getText().trim());

    			if (cantidad <= 0) {
    				mostrarInfo.mostrarError(
    						"La cantidad debe ser un entero mayor que cero."
    						);
    				return;
    			}

    			for (int i = 0; i < cantidad; i++) {
    				manejonumeros.aleatorioArray();
    			}

    			avanzarAMenu2();

    		} catch (NumberFormatException e) {
    			recibirInfo.limpiarCampo(campoCantidad);
    			mostrarInfo.mostrarError("Debes ingresar una cantidad entera válida.");
    			campoCantidad.requestFocusInWindow();
    		}
    	});

    	componentes.agregarPanel("PANEL_ALEATORIOS_N", panelOpcion4);
    	componentes.mostrarPanel("PANEL_ALEATORIOS_N");
    }

    
    public void creaciondebotonesprincipales(JPanel panel,JPanel panel2) {
    	
    	JButton btnOp1 = componentes.agregarBoton(panel, "Opcion 1: Escribir 10 numeros");
    	JButton btnOp2 = componentes.agregarBoton(panel, "Opcion 2: Escribir n numeros");
    	JButton btnOp3 = componentes.agregarBoton(panel, "Opcion 3: Llenar 10 aleatorios");
    	JButton btnOp4 = componentes.agregarBoton(panel, "Opcion 4: Llenar n aleatorios");
    	
    	panel2.add(panel, BorderLayout.CENTER);
    	
    	accionesBotones.configurarAccion(btnOp1, this::opcion1);
    	accionesBotones.configurarAccion(btnOp2, () -> {opcion2();});
    	accionesBotones.configurarAccion(btnOp3, () -> {opcion3();avanzarAMenu2();});
    	accionesBotones.configurarAccion(btnOp4, () -> {opcion4();});
    	
    	
    }
}