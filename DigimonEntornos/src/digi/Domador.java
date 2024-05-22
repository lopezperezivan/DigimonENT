package digi;
import java.util.ArrayList;
import java.util.Random;
/**
 * Representa a un domador de Digimon.
 */
public class Domador {
    private String nombre;
    private ArrayList<Digimon> equipo;
    private static final int CAPACIDAD_EQUIPO = 3;
    private static final String[] DIGIMON_NAMES = {"Agumon", "Gabumon", "Patamon"};

    /**
     * Constructor de la clase Domador.
     * 
     * @param nombre Nombre del Domador.
     */
    public Domador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
        Random rand = new Random();
        Digimon inicial = new Digimon(DIGIMON_NAMES[rand.nextInt(DIGIMON_NAMES.length)]);
        equipo.add(inicial);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Digimon> getEquipo() {
        return equipo;
    }

    public void capturar(Digimon digimon) {
        if (digimon.getSalud() <= 20 && equipo.size() < CAPACIDAD_EQUIPO) {
            equipo.add(digimon);
            System.out.println(digimon.getNombre() + " se ha unido a su equipo.");
        } else {
            System.out.println("No se puede unir " + digimon.getNombre() + ".");
        }
    }

    @Override
    public String toString() {
        return "Domador: " + nombre + ", Equipo: " + equipo;
    }
}