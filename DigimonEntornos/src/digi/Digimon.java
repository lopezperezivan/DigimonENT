package digi;

import java.util.Random;

/**
 * Representa un Digimon con sus características y ataques.
 */
public class Digimon {
    private String nombre;
    private int nivel;
    private int puntosAtaque;
    private int salud;
    private int dp1;
    private int dp2;

    /**
     * Constructor de la clase Digimon.
     * 
     * @param nombre Nombre del Digimon.
     */
    public Digimon(String nombre) {
        this.nombre = nombre;
        Random rand = new Random();
        this.nivel = rand.nextInt(5) + 1;
        this.puntosAtaque = 5 * nivel;
        this.salud = 10 * nivel;
        this.dp1 = 10;
        this.dp2 = 10;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void reducirSalud(int cantidad) {
        this.salud -= cantidad;
    }

    public void ataque1(Digimon enemigo) {
        if (dp1 > 0) {
            enemigo.reducirSalud(puntosAtaque);
            dp1--;
        }
    }

    public void ataque2(Digimon enemigo) {
        if (dp2 >= 2) {
            enemigo.reducirSalud(2 * puntosAtaque);
            dp2 -= 2;
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Nivel: " + nivel + ", Puntos de Ataque: " + puntosAtaque + 
               ", Salud: " + salud + ", DP1: " + dp1 + ", DP2: " + dp2;
    }
}
