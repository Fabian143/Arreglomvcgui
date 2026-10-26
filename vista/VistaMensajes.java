package vista;

public final class VistaMensajes {
    private static final String[] BIENVENIDA = {
        "Hola bienvenido al programa -_-",
        "Hola bienvenido al programa :)",
        "Hola bienvenido al programa :(",
        "Hola bienvenido al programa, espero que te guste",
        "Hola bienvenido al programa, el dia de hoy vamos a jugar con numeros"
    };

    private static final String[] DESPEDIDA = {
        "Adios",
        "Ten un buen dia, espero que te haya gustado el programa",
        "Hasta luego, :)",
        "Mensaje generico del fin del programa",
        "Ya esta el programa finalizo su ciclo de existencia y ejecución :("
    };

    private VistaMensajes() {
    }

    public static String mensajeBienvenidaAleatorio() {
        return BIENVENIDA[(int) (Math.random() * BIENVENIDA.length)];
    }

    public static String mensajeDespedidaAleatorio() {
        return DESPEDIDA[(int) (Math.random() * DESPEDIDA.length)];
    }
}
