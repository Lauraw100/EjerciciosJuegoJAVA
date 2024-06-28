package com.ahorcados;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //! Lista de palabras
        String[] palabras = {"java", "programacion", "ahorcado", "computadora", "desarrollador"};

        //! Seleccionar una palabra aleatoriamente
        Random random = new Random();
        String palabraSeleccionada = palabras[random.nextInt(palabras.length)];

        //! Variables del juego
        int vidas = 3;
        boolean palabraAdivinada = false;
        char[] palabraAdivinadaArray = new char[palabraSeleccionada.length()];
        ArrayList<Character> letrasIngresadas = new ArrayList<>();

        //! Inicializar el array con guiones bajos
        for (int i = 0; i < palabraAdivinadaArray.length; i++) {
            palabraAdivinadaArray[i] = '_';
        }

        Scanner scanner = new Scanner(System.in);

        //! Ciclo del juego
        while (vidas > 0 && !palabraAdivinada) {
            System.out.println("Palabra: " + new String(palabraAdivinadaArray));
            System.out.println("Vidas restantes: " + vidas);
            System.out.print("Ingresa una letra: ");
            char letraIngresada = scanner.next().charAt(0);

            //! Validar si la letra ya fue ingresada
            if (letrasIngresadas.contains(letraIngresada)) {
                System.out.println("Ya has ingresado esta letra. Intenta con otra.");
                continue;
            }

            letrasIngresadas.add(letraIngresada);

            //! Validar si la letra está en la palabra
            boolean letraEncontrada = false;
            for (int i = 0; i < palabraSeleccionada.length(); i++) {
                if (palabraSeleccionada.charAt(i) == letraIngresada) {
                    palabraAdivinadaArray[i] = letraIngresada;
                    letraEncontrada = true;
                }
            }

            //! Si la letra no está en la palabra
            if (!letraEncontrada) {
                vidas--;
                System.out.println("Perdiste una vida.");
            }

            //! Verificar si la palabra ha sido adivinada
            palabraAdivinada = true;
            for (int i = 0; i < palabraAdivinadaArray.length; i++) {
                if (palabraAdivinadaArray[i] == '_') {
                    palabraAdivinada = false;
                    break;
                }
            }
        }

        //! Mostrar el resultado del juego
        if (palabraAdivinada) {
            System.out.println("¡WOW! Has adivinado la palabra: " + palabraSeleccionada);
        } else {
            System.out.println("Has perdido. La palabra era: " + palabraSeleccionada);
        }

        scanner.close();
    }
}
