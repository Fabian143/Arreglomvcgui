package controlador;

import modelo.Numeros;
import vista.Componentes;
import vista.VistaMensajes;

public class Inicio1 {
    protected final Componentes componentes;
    protected final Numeros modelo;

    public Inicio1(Componentes componentes) {
        this(componentes, new Numeros());
    }

    public Inicio1(Componentes componentes, Numeros modelo) {
        this.componentes = componentes;
        this.modelo = modelo;
        ejecutarInicio();
    }

    private void ejecutarInicio() {
        String mensaje = VistaMensajes.mensajeBienvenidaAleatorio();
        componentes.mostrarPantallaInicio(mensaje, () -> new Menu1(componentes, modelo));
    }
}
