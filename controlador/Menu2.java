package controlador;

import modelo.Numeros;
import vista.Componentes;
import vista.MostrarInfoGUI;
import vista.VistaMensajes;

public class Menu2 {
    private final Componentes componentes;
    private final Numeros modelo;
    private final MostrarInfoGUI mostrarInfo;

    public Menu2(Componentes componentes) {
        this(componentes, new Numeros());
    }

    public Menu2(Componentes componentes, Numeros modelo) {
        this.componentes = componentes;
        this.modelo = modelo;
        this.mostrarInfo = new MostrarInfoGUI(componentes);
    }

    public void mostrarPantalla() {
        componentes.getLblTitulo().setText("Menú de operaciones");
        componentes.mostrarMenuOperaciones(this::opcion5, this::opcion6, this::opcion7, this::finalizarPrograma);
    }

    private void opcion5() {
        StringBuilder mensaje = new StringBuilder();

        if (modelo.getEsarreglo()) {
            for (int i = 0; i < Numeros.numeros.length; i++) {
                mensaje.append("Número ").append(i + 1).append(": ").append(Numeros.numeros[i]).append("\n");
            }
        } else {
            if (Numeros.numeros2.isEmpty()) {
                mostrarInfo.mostrarError("No hay números almacenados.");
                return;
            }
            for (int i = 0; i < Numeros.numeros2.size(); i++) {
                mensaje.append("Número ").append(i + 1).append(": ").append(Numeros.numeros2.get(i)).append("\n");
            }
        }

        componentes.mostrarDialogoInformacion(mensaje.toString(), "Números almacenados");
    }

    private void opcion6() {
        boolean esArreglo = modelo.getEsarreglo();
        int cantidad = esArreglo ? Numeros.numeros.length : Numeros.numeros2.size();

        if (cantidad == 0) {
            mostrarInfo.mostrarError("No hay números para eliminar.");
            return;
        }

        String entrada = componentes.pedirTexto("Ingresa la posición del número que deseas eliminar (1 a " + cantidad + "):");
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
                modelo.eliminarInfoArreglo(indice);
            } else {
                modelo.eliminarInfoArray(indice);
            }

            componentes.mostrarDialogoInformacion("Número eliminado correctamente.", "Eliminación");
        } catch (NumberFormatException e) {
            mostrarInfo.mostrarError("Debes ingresar una posición entera válida.");
        }
    }

    private void opcion7() {
        double resultado = modelo.getEsarreglo() ? modelo.sumatoriaArreglo() : modelo.sumatoriaArray();
        componentes.mostrarDialogoInformacion("La sumatoria es: " + resultado, "Sumatoria");
    }

    private void finalizarPrograma() {
        componentes.mostrarDialogoInformacion(VistaMensajes.mensajeDespedidaAleatorio(), "Fin del programa");
        componentes.cerrarVentana();
        System.exit(0);
    }
}
