package digi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Introduce el nombre del Domador:");
        String nombreDomador = scanner.nextLine();
        Domador domador = new Domador(nombreDomador);
        System.out.println("Bienvenido, " + domador.getNombre());

        List<Digimon> digimonsDisponibles = new ArrayList<>(Arrays.asList(
            new Digimon("Tailmon"),
            new Digimon("Piyomon"),
            new Digimon("Tentomon"),
            new Digimon("Devimon"),
            new Digimon("Etemon"),
            new Digimon("Agumon"),
            new Digimon("Patamon"),
            new Digimon("Gabumon")
        ));

        // Seleccionar un Digimon aleatorio para el jugador
        Digimon digimonInicial = digimonsDisponibles.remove(rand.nextInt(digimonsDisponibles.size()));
        domador.addDigimon(digimonInicial);
        System.out.println("Has recibido a " + digimonInicial.getNombre() + " como tu primer Digimon.");

        while (true) {
            System.out.println("Opciones: 1. Iniciar batalla, 2. Salir");
            int opcion = scanner.nextInt();
            if (opcion == 1) {
                BatallaDigital batalla = new BatallaDigital(domador, digimonsDisponibles);
                boolean jugadorGana = batalla.elige();
                if (jugadorGana) {
                    System.out.println("¡Has ganado el juego! Gracias por jugar.");
                    break;
                } else if (domador.getDigimons().size() == 1) { // Si solo queda el inicial, significa que perdió
                    System.out.println("Has perdido el juego. Empieza de nuevo.");
                    break;
                }
            } else if (opcion == 2) {
                System.out.println("Gracias por jugar.");
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}
