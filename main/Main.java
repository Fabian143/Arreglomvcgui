package main;

import controlador.Inicio1;
import vista.Componentes;

public class Main {

    public static void main(String[] args) {
        // Inicializamos la ventana central con la nueva arquitectura
        Componentes componentes = new Componentes("Arreglo MVC");
        
        // Arrancamos el flujo del programa
        new Inicio1(componentes);
        componentes.mostrarVentana();
    }
}
