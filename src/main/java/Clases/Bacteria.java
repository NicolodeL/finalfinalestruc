package Clases;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bacteria implements Serializable {
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


    public String toString() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }




    public int calcularComida(int dia) {
        // Implementar la lógica para calcular la cantidad de comida en el día dado
        return 0; // Cambiar esto por la implementación correcta
    }
    public String getInformacionDetallada() {
        StringBuilder informacion = new StringBuilder();
        informacion.append("Nombre de la bacteria: ").append(nombre).append("\n")
                .append("Fecha de inicio: ").append(fechaInicio).append("\n")
                .append("Fecha de fin: ").append(fechaFin).append("\n")
                .append("Número de bacterias iniciales: ").append(numBacteriasIniciales).append("\n")
                .append("Temperatura: ").append(temperatura).append("\n")
                .append("Condiciones de luminosidad: ").append(condicionesLuminosidad).append("\n")
                .append("Comida inicial: ").append(comidaInicial).append("\n")
                .append("Día de incremento de comida: ").append(diaIncrementoComida).append("\n")
                .append("Comida en el día de incremento: ").append(comidaDiaIncremento).append("\n")
                .append("Comida final: ").append(comidaFinal).append("\n");

        // Calcular la dosis de alimento para cada día
        double incrementoDiario = (comidaFinal - comidaInicial) / 29.0; // asumimos que el incremento es lineal
        for (int dia = 1; dia <= 30; dia++) {
            double dosisDia = comidaInicial + (dia - 1) * incrementoDiario;
            informacion.append("Dosis de alimento para el día ").append(dia).append(": ").append(dosisDia).append("\n");
        }





        return informacion.toString();
    }

    public static Bacteria fromInformacionDetallada(String informacion) throws ParseException {
        String[] lines = informacion.split("\n");
        String nombre = lines[0].split(": ")[1];
        Date fechaInicio = new SimpleDateFormat("dd/MM/yyyy").parse(lines[1].split(": ")[1]);
        Date fechaFin = new SimpleDateFormat("dd/MM/yyyy").parse(lines[2].split(": ")[1]);
        int numBacteriasIniciales = Integer.parseInt(lines[3].split(": ")[1]);
        double temperatura = Double.parseDouble(lines[4].split(": ")[1]);
        String condicionesLuminosidad = lines[5].split(": ")[1];
        int comidaInicial = Integer.parseInt(lines[6].split(": ")[1]);
        int diaIncrementoComida = Integer.parseInt(lines[7].split(": ")[1]);
        int comidaDiaIncremento = Integer.parseInt(lines[8].split(": ")[1]);
        int comidaFinal = Integer.parseInt(lines[9].split(": ")[1]);

        return new Bacteria(nombre, fechaInicio, fechaFin, numBacteriasIniciales, temperatura, condicionesLuminosidad, comidaInicial, diaIncrementoComida, comidaDiaIncremento, comidaFinal);
    }
}





