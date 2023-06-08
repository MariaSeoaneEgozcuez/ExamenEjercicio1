# ExamenEjercicio1
El ejercicio 1 del examen

# Matrix Calculator

Este es un programa Java que lee dos matrices, A y C, desde archivos de texto y calcula la matriz B tal que A + B = C. El resultado se guarda en otro archivo de texto.

## Requisitos previos

- Java 8 o superior.

## Uso

1. Clona o descarga este repositorio en tu máquina local.

2. Coloca los archivos de texto que contienen las matrices A y C en el mismo directorio que el código fuente. Los archivos deben tener el siguiente formato:

   - `matrix_a.txt`: Archivo que contiene la matriz A. El primer número en el archivo indica las dimensiones de la matriz, seguido de los elementos separados por comas.

     Ejemplo:
     ```
     3,3
     1,2,3
     4,5,6
     7,8,9
     ```

   - `matrix_c.txt`: Archivo que contiene la matriz C. El formato es similar al de `matrix_a.txt`.

3. Ejecuta la aplicación ejecutando el archivo `MatrixCalculator.java`.

4. La aplicación calculará la matriz B y la guardará en un archivo llamado `matrix_b.txt` en el mismo directorio.

5. El resultado del cálculo se mostrará en la consola, junto con la ubicación del archivo `matrix_b.txt`.

## Pruebas

El código incluye pruebas unitarias utilizando JUnit para verificar la funcionalidad de cálculo de la matriz B y las operaciones de lectura y escritura de archivos.

Para ejecutar las pruebas, asegúrate de tener JUnit en tu entorno de desarrollo y ejecuta el archivo `MatrixCalculatorTest.java` como una prueba de unidad.

## Limitaciones

- El código asume que las matrices A y C tienen las mismas dimensiones.

- Las matrices se representan como matrices de enteros.

- Las matrices se almacenan en archivos de texto con un formato específico.


## Licencia

Este proyecto está bajo la Licencia MIT. Puedes consultar el archivo [LICENSE](LICENSE) para obtener más información.


