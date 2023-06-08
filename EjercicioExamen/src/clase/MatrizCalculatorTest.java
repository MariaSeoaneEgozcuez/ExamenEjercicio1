package clase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MatrizCalculatorTest {
    private static final String INPUT_FILE_A = "matrix_a.txt";
    private static final String INPUT_FILE_C = "matrix_c.txt";
    @Test
    public void testMatrixCalculation() {
        // Creo una matriz de prueba A
        int[][] matrizA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        // Creo una matriz de prueba C
        int[][] matrizC = {{10, 11, 12}, {13, 14, 15}, {16, 17, 18}};
        
        // Calcular la matriz B
        int[][] matrizB = MatrizCalculator.CalcularB(matrizA, matrizC);
        
        // Verificar el resultado esperado de la matriz B
        int[][] expectedMatrizB = {{9, 9, 9}, {9, 9, 9}, {9, 9, 9}};
        Assertions.assertArrayEquals(expectedMatrizB, matrizB);
    }
    
    @Test
    public void testFileIO() throws IOException {
        // Crear una matriz de prueba A
        int[][] matrizA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        // Crear una matriz de prueba C
        int[][] matrizC = {{10, 11, 12}, {13, 14, 15}, {16, 17, 18}};
        
        // Guardar las matrices A y C en archivos de texto
        MatrizCalculator.EscribirArchivo(matrizA, INPUT_FILE_A);
        MatrizCalculator.EscribirArchivo(matrizC, INPUT_FILE_C);
        
        // Leer las matrices desde los archivos de texto
        int[][] readMatrizA = readMatrixFromFile(INPUT_FILE_A);
        int[][] readMatrizC = readMatrixFromFile(INPUT_FILE_C);
        
        // Verificar que las matrices leídas sean iguales a las matrices originales
        Assertions.assertArrayEquals(matrizA, readMatrizA);
        Assertions.assertArrayEquals(matrizC, readMatrizC);
    }
    
    private static int[][] readMatrixFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        
        // Leer las dimensiones de la matriz
        String[] dimensions = reader.readLine().split(",");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        
        int[][] matriz = new int[rows][cols];
        
        // Leer los elementos de la matriz
        String line;
        int rowIndex = 0;
        while ((line = reader.readLine()) != null) {
            String[] elements = line.split(",");
            for (int colIndex = 0; colIndex < elements.length; colIndex++) {
                matriz[rowIndex][colIndex] = Integer.parseInt(elements[colIndex]);
            }
            rowIndex++;
        }
        
        reader.close();
        
        return matriz;
    }
}