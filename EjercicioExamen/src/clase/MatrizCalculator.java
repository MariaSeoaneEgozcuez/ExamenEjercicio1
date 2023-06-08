package clase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MatrizCalculator {
    private static final String INPUT_FILE_A = "matriz_a.txt";
    private static final String INPUT_FILE_C = "matriz_c.txt";
    private static final String OUTPUT_FILE_B = "matriz_b.txt";
    
    public static void main(String[] args) {
        try {
            // Leer las matrices A y C desde los archivos de texto creados previamente.
            int[][] matrizA = LeerMatriz(INPUT_FILE_A);
            int[][] matrizC = LeerMatriz(INPUT_FILE_C);
            
            // Calcular la matriz B
            int[][] matrizB = CalcularB(matrizA, matrizC);
            
            // Escribir la matriz B en el archivo de salida
            EscribirArchivo(matrizB, OUTPUT_FILE_B);
            
            System.out.println("Cálculo completado. El resultado se ha guardado en " + OUTPUT_FILE_B);
        } catch (IOException e) {
            System.out.println("Error al leer o escribir en los archivos.");
            e.printStackTrace();
        }
    }
    
    private static int[][] LeerMatriz(String fileName) throws IOException { //Leer la matriz a partir del archivo de texto
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        
        // Leer las dimensiones de la matriz
        String[] dimension = reader.readLine().split(",");
        int fils = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);
        
        int[][] matriz = new int[fils][cols];
        
        // Leer los elementos de la matriz
        String line;
        int fila = 0;
        while ((line = reader.readLine()) != null) {
            String[] elements = line.split(",");
            for (int columna = 0; columna < elements.length; columna++) {
                matriz[fila][columna] = Integer.parseInt(elements[columna]);
            }
            fila++;
        }
        
        reader.close();
        
        return matriz;
    }
    
    static void EscribirArchivo(int[][] matriz, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        
        // Escribir las dimensiones de la matriz
        writer.write(matriz.length + "," + matriz[0].length);
        writer.newLine();
        
        // Escribir los elementos de la matriz
        for (int[] fil : matriz) { 
            for (int i = 0; i < fil.length; i++) {
                writer.write(fil[i] + "");
                if (i < fil.length - 1) {
                    writer.write(",");
                }
            }
            writer.newLine();
        }
        
        writer.close();
    }
    
    static int[][] CalcularB(int[][] matrizA, int[][] matrizC) {
        int fils = matrizA.length;
        int cols = matrizA[0].length;
        //Se crea una matriz nueva de dimensiones m x n
        int[][] matrizB = new int[fils][cols]; 
        
        // Realizar la resta entre C y A para obtener B
        for (int i = 0; i < fils; i++) {
            for (int j = 0; j < cols; j++) {
                matrizB[i][j] = matrizC[i][j] - matrizA[i][j];
            }
        }
        return matrizB;
    }
    
}
