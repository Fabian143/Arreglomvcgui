
package controlador;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Numeros;
import vista.Componentes;

public class Menu2 extends Menu1 {

    private final Numeros manejonumerosMenu2 = new Numeros();

    private final String[] mensajesFinales = {
        "Adios",
        "Ten un buen dia, espero que te haya gustado el programa",
        "Hasta luego, :)",
        "Mensaje generico del fin del programa",
        "Ya esta el programa finalizo su ciclo de existencia y ejecución :("
    };

    public Menu2(Componentes componentes) {
        super(componentes);
        ejecutarMenu2();
    }

    private void ejecutarMenu2() {
        JPanel panelMenu2 = new JPanel(new BorderLayout(10, 10));
        JPanel panelOpciones = new JPanel(new GridLayout(4, 2, 10, 10));

        componentes.getLblTitulo().setText("Menú de operaciones");

        // Reutiliza las cuatro opciones de Menu1.
        creaciondebotonesprincipales(panelOpciones, panelMenu2);

        // Opciones adicionales del menú.
        JButton btnOp5 = componentes.agregarBoton(panelOpciones, "Opción 5: Mostrar números");

        JButton btnOp6 = componentes.agregarBoton(panelOpciones, "Opción 6: Eliminar número");

        JButton btnOp7 = componentes.agregarBoton(panelOpciones, "Opción 7: Calcular sumatoria");

        JButton btnSalir = componentes.agregarBoton(panelOpciones, "Opción 8: Salir del programa");

        // Acciones de los botones adicionales.
        accionesBotones.configurarAccion(btnOp5, this::opcion5);
        accionesBotones.configurarAccion(btnOp6, this::opcion6);
        accionesBotones.configurarAccion(btnOp7, this::opcion7);
        accionesBotones.configurarAccion(btnSalir, this::finalizarPrograma);

        componentes.agregarPanel("PANEL_MENU2", panelMenu2);
        componentes.mostrarPanel("PANEL_MENU2");
    }

    // Opción 5: mostrar los números almacenados.
    private void opcion5() {
        StringBuilder mensaje = new StringBuilder();

        if (manejonumerosMenu2.getEsarreglo()) {
            for (int i = 0; i < Numeros.numeros.length; i++) {
            	creacionDeStringNumeros(mensaje,i);
            }
            
        } else {
            if (Numeros.numeros2.isEmpty()) {
                mostrarInfo.mostrarError("No hay números almacenados.");
                return;
            }

            for (int i = 0; i < Numeros.numeros2.size(); i++) {
            	creacionDeStringNumeros(mensaje,i);
            }
        }

        JOptionPane.showMessageDialog(componentes.getVentana(),mensaje.toString(),"Números almacenados",JOptionPane.INFORMATION_MESSAGE);
    }

    // Opción 6: eliminar un número por su posición.
    private void opcion6() {
        boolean esArreglo = manejonumerosMenu2.getEsarreglo();

        int cantidad = esArreglo? Numeros.numeros.length: Numeros.numeros2.size();

        if (cantidad == 0) {
            mostrarInfo.mostrarError("No hay números para eliminar.");
            return;
        }

        String entrada = JOptionPane.showInputDialog(componentes.getVentana(),"Ingresa la posición del número que deseas eliminar (1 a "+ cantidad + "):"
        );

        // El usuario canceló la operación.
        if (entrada == null) {
            return;
        }

        try {
            int posicion = Integer.parseInt(entrada.trim());

            if (posicion < 1 || posicion > cantidad) {
                mostrarInfo.mostrarError("La posición debe estar entre 1 y " + cantidad + ".");
                return;
            }

            int indice = posicion - 1;

            if (esArreglo) {
                // En un arreglo fijo, eliminar significa reemplazar por cero.
                manejonumerosMenu2.eliminarInfoArreglo(indice);
            } else {
                // En un ArrayList, se elimina realmente el elemento.
                manejonumerosMenu2.eliminarInfoArray(indice);
            }

            JOptionPane.showMessageDialog(componentes.getVentana(),"Número eliminado correctamente.","Eliminación",JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            mostrarInfo.mostrarError("Debes ingresar una posición entera válida.");
        }
    }

    // Opción 7: calcular la sumatoria.
    private void opcion7() {
        double resultado;

        if (manejonumerosMenu2.getEsarreglo()) {
            resultado = manejonumerosMenu2.sumatoriaArreglo();
        } else {
            resultado = manejonumerosMenu2.sumatoriaArray();
        }

        JOptionPane.showMessageDialog(componentes.getVentana(),"La sumatoria es: " + resultado,"Sumatoria",JOptionPane.INFORMATION_MESSAGE);
    }

    // Opción 8: mostrar una despedida y cerrar el programa.
    private void finalizarPrograma() {
        int indice = (int) (Math.random() * mensajesFinales.length);

        JOptionPane.showMessageDialog(componentes.getVentana(),mensajesFinales[indice],"Fin del programa",JOptionPane.INFORMATION_MESSAGE);

        componentes.cerrarVentana();
        System.exit(0);
    }
    
    private void creacionDeStringNumeros(StringBuilder sb,int i) {
    	sb.append("Número ").append(i + 1) .append(": ").append(Numeros.numeros[i]).append("\n");
    }
}
