package digi;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BatallaDigital {
    private Domador domador;
    private List<Digimon> digimonsDisponibles;
    private Random rand = new Random();
    private Scanner scanner = new Scanner(System.in);

    public BatallaDigital(Domador domador, List<Digimon> digimonsDisponibles) {
        this.domador = domador;
        this.digimonsDisponibles = digimonsDisponibles;
    }

    public void elige() {
        while (true) {
            Digimon digimonJugador = seleccionarDigimonJugador();
            Digimon digimonRival = seleccionarDigimonRival();

            System.out.println("¡Comienza la batalla entre " + digimonJugador.getNombre() + " y " + digimonRival.getNombre() + "!");

            while (digimonJugador.getSalud() > 0 && digimonRival.getSalud() > 0) {
                System.out.println(digimonJugador);
                System.out.println(digimonRival);

                System.out.print("Elige el ataque para " + digimonJugador.getNombre() + " (1 o 2): ");
                int ataqueJugador = scanner.nextInt();
                if (ataqueJugador == 1) {
                    digimonJugador.ataque1(digimonRival);
                } else if (ataqueJugador == 2) {
                    digimonJugador.ataque2(digimonRival);
                }

                if (digimonRival.getSalud() <= 0) {
                    System.out.println(digimonRival.getNombre() + " ha sido derrotado!");
                    domador.addDigimon(digimonRival);
                    digimonsDisponibles.remove(digimonRival);
                    break;
                }

                int ataqueRival = rand.nextInt(2) + 1;
                if (ataqueRival == 1) {
                    digimonRival.ataque1(digimonJugador);
                } else if (ataqueRival == 2) {
                    digimonRival.ataque2(digimonJugador);
                }

                if (digimonJugador.getSalud() <= 0) {
                    System.out.println(digimonJugador.getNombre() + " ha sido derrotado!");
                    System.out.println("Has perdido. Empieza de nuevo.");
                    return;
                }
            }

            if (domadorTieneDigimonsRequeridos()) {
                System.out.println("¡Felicidades! Has conseguido a Agumon, Patamon y Gabumon. ¡Has ganado el juego!");
                break;
            }
        }
    }

    private Digimon seleccionarDigimonJugador() {
        System.out.println("Elige tu Digimon:");
        List<Digimon> digimons = domador.getDigimons();
        for (int i = 0; i < digimons.size(); i++) {
            System.out.println((i + 1) + ". " + digimons.get(i).getNombre());
        }
        int eleccion = scanner.nextInt();
        return digimons.get(eleccion - 1);
    }

    private Digimon seleccionarDigimonRival() {
        int index = rand.nextInt(digimonsDisponibles.size());
        return digimonsDisponibles.get(index);
    }

    private boolean domadorTieneDigimonsRequeridos() {
        boolean tieneAgumon = false;
        boolean tienePatamon = false;
        boolean tieneGabumon = false;

        for (Digimon digimon : domador.getDigimons()) {
            if (digimon.getNombre().equals("Agumon")) tieneAgumon = true;
            if (digimon.getNombre().equals("Patamon")) tienePatamon = true;
            if (digimon.getNombre().equals("Gabumon")) tieneGabumon = true;
        }

        return tieneAgumon && tienePatamon && tieneGabumon;
    }
}
