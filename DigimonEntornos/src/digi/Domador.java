package digi;

import java.util.ArrayList;
import java.util.List;

public class Domador {
    private String nombre;
    private List<Digimon> digimons;

    public Domador(String nombre) {
        this.nombre = nombre;
        this.digimons = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void addDigimon(Digimon digimon) {
        digimons.add(digimon);
    }

    public List<Digimon> getDigimons() {
        return digimons;
    }

    public boolean tieneDigimonsRequeridos() {
        boolean tieneAgumon = false;
        boolean tienePatamon = false;
        boolean tieneGabumon = false;

        for (Digimon digimon : digimons) {
            if (digimon.getNombre().equals("Agumon")) tieneAgumon = true;
            if (digimon.getNombre().equals("Patamon")) tienePatamon = true;
            if (digimon.getNombre().equals("Gabumon")) tieneGabumon = true;
        }

        return tieneAgumon && tienePatamon && tieneGabumon;
    }
}
