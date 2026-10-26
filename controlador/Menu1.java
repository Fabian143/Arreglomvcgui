package controlador;

import modelo.Numeros;
import vista.Componentes;
import vista.MostrarInfoGUI;
import vista.RecibirInfoGUI;

public class Menu1 {
    protected final Componentes componentes;
    protected final Numeros modelo;
    protected final RecibirInfoGUI recibirInfo;
    protected final MostrarInfoGUI mostrarInfo;

    public Menu1(Componentes componentes) {
        this(componentes, new Numeros());
    }

    public Menu1(Componentes componentes, Numeros modelo) {
        this.componentes = componentes;
        this.modelo = modelo;
        this.recibirInfo = new RecibirInfoGUI(componentes);
        this.mostrarInfo = new MostrarInfoGUI(componentes);
        ejecutarmenu();
    }

    private void ejecutarmenu() {
        componentes.getLblTitulo().setText("Menú Inicial - Seleccione una opción");
        componentes.mostrarMenuPrincipal(this::opcion1, this::opcion2, this::opcion3, this::opcion4);
    }

    protected void avanzarAMenu2() {
        new Menu2(componentes, modelo).mostrarPantalla();
    }

    public void opcion1() {
        modelo.limpiar();
        modelo.setEsarreglo(true);

        componentes.mostrarFormularioDiezNumeros(valores -> {
            for (int i = 0; i < valores.length; i++) {
                modelo.añadirElementoArreglo(i, valores[i]);
            }
            avanzarAMenu2();
        }, () -> mostrarInfo.mostrarError("Todos los campos deben contener números válidos."),
            () -> avanzarAMenu2());
    }

    public void opcion2() {
        modelo.limpiar();
        modelo.setEsarreglo(false);

        componentes.mostrarFormularioNValores(numero -> {
            modelo.añadirElementoArray(numero);
        }, () -> {
            if (Numeros.numeros2.isEmpty()) {
                mostrarInfo.mostrarError("Debes ingresar al menos un número.");
                return;
            }
            avanzarAMenu2();
        }, () -> mostrarInfo.mostrarError("Debes ingresar un número válido."));
    }

    public void opcion3() {
        modelo.limpiar();
        modelo.setEsarreglo(true);
        for (int i = 0; i < 10; i++) {
            modelo.aleatorioArreglo(i);
        }
        avanzarAMenu2();
    }

    public void opcion4() {
        modelo.limpiar();
        modelo.setEsarreglo(false);

        componentes.mostrarFormularioGenerarAleatorios(cantidad -> {
            for (int i = 0; i < cantidad; i++) {
                modelo.aleatorioArray();
            }
            avanzarAMenu2();
        }, () -> mostrarInfo.mostrarError("La cantidad debe ser un entero mayor que cero."));
    }
}
