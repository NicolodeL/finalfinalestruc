package Clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Experimento implements Serializable {
    private List<Bacteria> bacterias;

    public Experimento() {
        this.bacterias = new ArrayList<>();
    }

    public void agregarBacteria(Bacteria bacteria) {
        this.bacterias.add(bacteria);
    }

    public List<Bacteria> obtenerBacterias() {
        return this.bacterias;
    }
}

