package Clases;

import java.util.ArrayList;
import java.util.List;

public class Listado {
    private List<Experimento> experimentos;

    public Listado() {
        this.experimentos = new ArrayList<>();
    }

    public void agregarExperimento(Experimento experimento) {
        this.experimentos.add(experimento);
    }

    public List<Experimento> obtenerExperimentos() {
        return this.experimentos;
    }
}
