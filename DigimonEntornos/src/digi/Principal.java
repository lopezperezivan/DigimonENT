package digi;
import java.util.Scanner;


public class Principal {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del Domador:");
        String nombreDomador = scanner.nextLine();
        Domador domador = new Domador(nombreDomador);
        System.out.println("Bienvenido, " + domador.getNombre());

        while (true) {
            System.out.println("Opciones: 1. Iniciar batalla, 2. Salir");
            int opcion = scanner.nextInt();
            if (opcion == 1) {
                BatallaDigital batalla = new BatallaDigital(domador);
                batalla.elige();
            } else if (opcion == 2) {
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
        System.out.println("Gracias por jugar.");
    }

}
