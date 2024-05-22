package digi;

import java.util.Scanner;

public class BatallaDigital {
    private Domador domador;

    public BatallaDigital(Domador domador) {
        this.domador = domador;
    }

    public void elige() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Elige el nombre del primer Digimon: ");
        Digimon digimon1 = new Digimon(scanner.nextLine());
        domador.addDigimon(digimon1);
        
        System.out.print("Elige el nombre del segundo Digimon: ");
        Digimon digimon2 = new Digimon(scanner.nextLine());
        domador.addDigimon(digimon2);

        System.out.println("¡Comienza la batalla entre " + digimon1.getNombre() + " y " + digimon2.getNombre() + "!");

        while (digimon1.getSalud() > 0 && digimon2.getSalud() > 0) {
            System.out.println(digimon1);
            System.out.println(digimon2);

            System.out.print("Elige el ataque para " + digimon1.getNombre() + " (1 o 2): ");
            int ataque1 = scanner.nextInt();
            if (ataque1 == 1) {
                digimon1.ataque1(digimon2);
            } else if (ataque1 == 2) {
                digimon1.ataque2(digimon2);
            }

            if (digimon2.getSalud() <= 0) {
                System.out.println(digimon2.getNombre() + " ha sido derrotado!");
                break;
            }

            System.out.print("Elige el ataque para " + digimon2.getNombre() + " (1 o 2): ");
            int ataque2 = scanner.nextInt();
            if (ataque2 == 1) {
                digimon2.ataque1(digimon1);
            } else if (ataque2 == 2) {
                digimon2.ataque2(digimon1);
            }

            if (digimon1.getSalud() <= 0) {
                System.out.println(digimon1.getNombre() + " ha sido derrotado!");
            }
        }
    }
}
