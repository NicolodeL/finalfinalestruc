package Clases;

import java.util.ArrayList;
import java.util.List;

public class Listado {
    private List<Bacteria> bacterias;

    public Listado() {
        this.bacterias = new ArrayList<>();
    }

    public void agregarBacteria(Bacteria bacteria) {
        this.bacterias.add(bacteria);
    }

    public List<Bacteria> obtenerBacterias() {
        return this.bacterias;
    }
}
