# Arreglomvcgui

Este proyecto es una pequeña aplicación Java Swing para practicar y corregir la implementación del patrón MVC (Modelo-Vista-Controlador) manteniendo la misma interfaz visual del programa original.

La aplicación permite:
- escribir 10 números en un arreglo,
- escribir una cantidad variable de números,
- generar números aleatorios en arreglo o lista,
- mostrar los valores almacenados,
- eliminar un valor por posición,
- calcular la sumatoria de los números,
- salir del programa con un mensaje final.

La parte del modelo ya estaba implementada y no se modifica; lo que se ajustó fue la estructura de la vista y el controlador para que el proyecto siga una arquitectura más ordenada.

## Estructura del proyecto

- `modelo/` : contiene la lógica del dominio (`Numeros.java`)
- `vista/` : contiene los componentes visuales y la interfaz gráfica
- `controlador/` : contiene la lógica de navegación y acciones del programa
- `main/` : contiene la clase principal que inicia la aplicación

## Requisitos

- Java JDK 8 o superior
- Eclipse IDE o NetBeans IDE
- Git (opcional, para clonar el repositorio)

## Cómo ejecutarlo en Eclipse

1. Abre Eclipse.
2. Selecciona `File > Import > Existing Projects into Workspace`.
3. Busca la carpeta del proyecto `Arreglomvcgui`.
4. Importa el proyecto.
5. En el explorador de paquetes, localiza la clase:
   - `main/Main.java`
6. Haz clic derecho sobre `Main.java` y selecciona:
   - `Run As > Java Application`

Si Eclipse te pide configuraciones del proyecto, asegúrate de que esté usando el JDK correcto y que el proyecto sea un proyecto Java estándar.

## Cómo ejecutarlo en NetBeans

1. Abre NetBeans.
2. Selecciona `Archivo > Abrir Proyecto...`.
3. Elige la carpeta del proyecto `Arreglomvcgui`.
4. Cuando el proyecto se cargue, haz clic derecho sobre el proyecto y selecciona:
   - `Construir`
5. Luego, haz clic derecho sobre el proyecto y selecciona:
   - `Ejecutar`

También puedes ejecutar directamente la clase:
- `main/Main.java`

## Cómo ejecutarlo desde la línea de comandos

Desde la carpeta del proyecto:

```bash
javac -d out $(find . -name "*.java")
java -cp out main.Main
```

## Cómo usar la aplicación

Cuando inicies la app, aparecerá un menú principal con estas opciones:

- Opción 1: Escribir 10 números
- Opción 2: Escribir n números
- Opción 3: Llenar 10 aleatorios
- Opción 4: Llenar n aleatorios

Después, el programa muestra el segundo menú con opciones adicionales:

- Opción 5: Mostrar números
- Opción 6: Eliminar número
- Opción 7: Calcular sumatoria
- Opción 8: Salir del programa

## Nota importante

El modelo (`Numeros.java`) sigue siendo la capa de datos/lógica del problema y no debe modificarse para esta práctica, mientras que la vista y el controlador se reorganizan para una mejor separación de responsabilidades.

## Autor

Fabian Yesid Londoño Penagos
