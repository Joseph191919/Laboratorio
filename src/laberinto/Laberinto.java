/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laberinto;

import java.util.Scanner;

/**
 *
 * @author PC
 */

public class Laberinto {
       private int[][] tablero;
        private int filas;
        private int columnas;
        private int posX;
        private int posY;
    
    public Laberinto(int filas, int columnas) {
     this.filas = filas;
        this.columnas = columnas;
        this.tablero = new int[filas][columnas];
        inicializarTablero();
        this.posX = 0;
        this.posY = 1; // Iniciar en la posición [0][1]
    }

    private void inicializarTablero() {
        // Llenar el borde con unos (paredes)
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == 0 || j == 0 || i ==   filas - 1 || j == columnas - 1) {
                    tablero[i][j] = 1; // Pared
                } else {
                    tablero[i][j] = 0; // Espacio disponible
                    
                }
            }
        }
          int objetivoX = filas - 1;
        int objetivoY = columnas - 1;
        tablero[objetivoX][objetivoY] = 7; 
        tablero[0][1] = 3;
    }

    public void imprimirLaberinto() {
      tablero[0][0]= 7;
                tablero[1][2]= 1;
                tablero[2][2]= 1;
                tablero[3][2]= 1;
                tablero[4][2]= 1;
                tablero[5][2]= 1;
                tablero[6][2]= 1;
                tablero[7][2]= 1;
                
                
                tablero[2][4]= 1;
                tablero[3][4]= 1;
                tablero[4][4]= 1;
                tablero[5][4]= 1;
                tablero[6][4]= 1;
                tablero[7][4]= 1;
                tablero[8][4]= 1;
                
                tablero[1][6]= 1;
                tablero[2][6]= 1;
                tablero[3][6]= 1;
                tablero[4][6]= 1;
                tablero[5][6]= 1;
                tablero[6][6]= 1;
                tablero[7][6]= 1;
                
                tablero[1][8]= 1;
                tablero[2][8]= 1;
                tablero[3][8]= 1;
                tablero[4][8]= 1;
                tablero[5][8]= 1;
                tablero[6][8]= 1;
                tablero[7][8]= 1;
                
                tablero[1][7]= 1;
                tablero[2][7]= 1;
                tablero[3][7]= 1;
                tablero[4][7]= 1;
                tablero[5][7]= 1;
                tablero[6][7]= 1;
                tablero[7][7]= 1;
                
                                tablero[9][8]= 0;
                
               
                

        
         tablero[tablero.length-1][tablero[0].length-1]= 7;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    
       public boolean mover(String direccion) {
        int nuevoX = posX;
        int nuevoY = posY;
        switch (direccion) {
            case "arriba":
                nuevoX = posX - 1;
                break;
            case "abajo":
                nuevoX = posX + 1;
                break;
            case "izquierda":
                nuevoY = posY - 1;
                break;
            case "derecha":
                nuevoY = posY + 1;
                break;
            default:
                System.out.println("Dirección no válida.");
                return false;
        }

        if (nuevoX >= 0 && nuevoX < filas && nuevoY >= 0 && nuevoY < columnas && tablero[nuevoX][nuevoY] != 1) {
            tablero[posX][posY] = 0; 
            posX = nuevoX;
            posY = nuevoY;
            tablero[posX][posY] = 3; 
            return true;
        } else {
            System.out.println("Movimiento inválido, elige otra dirección.");
            return false;
        }
    }

    public static void main(String[] args) {
        int filas = 10;
        int columnas = 10;
        Laberinto laberinto = new Laberinto(filas, columnas);
        Scanner scanner = new Scanner(System.in);

        while (laberinto.tablero[laberinto.posX][laberinto.posY] != 7) {
            laberinto.imprimirLaberinto();
            System.out.print("Ingresa la dirección (arriba, abajo, izquierda, derecha): ");
            String direccion = scanner.nextLine();
            laberinto.mover(direccion);
            System.out.println();
        }

        laberinto.imprimirLaberinto();
        System.out.println("¡Felicidades! Has alcanzado el objetivo.");
        scanner.close();
    }
}
