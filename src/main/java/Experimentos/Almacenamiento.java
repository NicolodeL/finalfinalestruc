package Experimentos;


import Clases.Experimento;

import java.io.*;

public class Almacenamiento {

    public static void guardarExperimento(Experimento experimento, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(experimento);
        }
    }

    public static Experimento cargarExperimento(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Experimento) ois.readObject();
        }
    }
}