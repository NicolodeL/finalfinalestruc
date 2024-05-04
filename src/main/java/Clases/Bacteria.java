package Clases;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Bacteria {
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private int numBacteriasIniciales;
    private double temperatura;
    private String condicionesLuminosidad;
    private int comidaInicial;
    private int diaIncrementoComida;
    private int comidaDiaIncremento;
    private int comidaFinal;

    public Bacteria(String nombre, Date fechaInicio, Date fechaFin, int numBacteriasIniciales, double temperatura, String condicionesLuminosidad, int comidaInicial, int diaIncrementoComida, int comidaDiaIncremento, int comidaFinal) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numBacteriasIniciales = numBacteriasIniciales;
        this.temperatura = temperatura;
        this.condicionesLuminosidad = condicionesLuminosidad;
        this.comidaInicial = comidaInicial;
        this.diaIncrementoComida = diaIncrementoComida;
        this.comidaDiaIncremento = comidaDiaIncremento;
        this.comidaFinal = comidaFinal;
    }

    public int calcularComida(int dia) {
        // Implementar la lógica para calcular la cantidad de comida en el día dado
        return 0; // Cambiar esto por la implementación correcta
    }
}
