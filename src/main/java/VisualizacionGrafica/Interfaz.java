package VisualizacionGrafica;

import Clases.Bacteria;
import Clases.Experimento;
import Experimentos.Almacenamiento;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Interfaz extends JFrame {
    private JList<Experimento> experimentoList;
    private JList<Bacteria> bacteriaList;
    private JButton addButton;
    private JButton saveButton;
    private JButton loadButton;

    public Interfaz() {
        super("Gestión de Experimentos");
        setLayout(new BorderLayout());

        experimentoList = new JList<>();
        bacteriaList = new JList<>();
        experimentoList.setModel(new DefaultListModel<Experimento>());
        addButton = new JButton("Agregar Experimento");
        saveButton = new JButton("Guardar Experimentos");
        loadButton = new JButton("Cargar Experimentos");

        add(new JScrollPane(experimentoList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            try {
                agregarExperimento();
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        });
        JList<Bacteria> bacteriaList = new JList<>(new DefaultListModel<Bacteria>());
        add(new JScrollPane(bacteriaList), BorderLayout.EAST);

        experimentoList.addListSelectionListener(e -> {
            Experimento experimento = experimentoList.getSelectedValue();
            if (experimento != null) {
                DefaultListModel<Bacteria> model = (DefaultListModel<Bacteria>) bacteriaList.getModel();
                model.clear();
                for (Bacteria bacteria : experimento.obtenerBacterias()) {
                    model.addElement(bacteria);
                }
            }
        });

        JButton agregarPoblacionButton = new JButton("Agregar Población");
        buttonPanel.add(agregarPoblacionButton);
        agregarPoblacionButton.addActionListener(e -> {
            try {
                agregarBacteria();
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        });
        saveButton.addActionListener(e -> guardarExperimentos());
        loadButton.addActionListener(e -> cargarExperimentos());
    }

    private void agregarExperimento() throws ParseException {
        String nombre = JOptionPane.showInputDialog(this, "Por favor, introduce el nombre del experimento");
        Experimento experimento = new Experimento(nombre);
        DefaultListModel<Experimento> model = (DefaultListModel<Experimento>) experimentoList.getModel();
        model.addElement(experimento);


    }

    private void agregarBacteria() throws ParseException {
        Experimento experimento = experimentoList.getSelectedValue();
        if (experimento == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un experimento");
            return;
        }
        String nombre = JOptionPane.showInputDialog(this, "Introduce el nombre de la población");
        String fechaInicioStr = JOptionPane.showInputDialog(this, "Introduce la fecha de inicio de la población (dd/MM/yyyy)");
        Date fechaInicio = null;
        try {
            fechaInicio = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicioStr);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "La fecha de inicio debe estar en el formato correcto (dd/MM/yyyy)");
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicio);
        calendar.add(Calendar.DATE, 30);
        Date fechaFin = calendar.getTime();

        String numBacteriasInicialesStr = JOptionPane.showInputDialog(this, "Introduce el número de bacterias iniciales");
        int numBacteriasIniciales = Integer.parseInt(numBacteriasInicialesStr);
        if (numBacteriasIniciales < 0) {
            JOptionPane.showMessageDialog(this, "El número de bacterias iniciales no puede ser negativo");
            return;
        }

        String temperaturaStr = JOptionPane.showInputDialog(this, "Introduce la temperatura a la que se someterán las bacterias");
        int temperatura = Integer.parseInt(temperaturaStr);
        if (temperatura < 0) {
            JOptionPane.showMessageDialog(this, "La temperatura no puede ser negativa");
            return;
        }

        String[] condiciones = {"Alta", "Media", "Baja"};
        String condicionLuminosidad = (String) JOptionPane.showInputDialog(this, "Selecciona las condiciones de luminosidad", "Luminosidad", JOptionPane.QUESTION_MESSAGE, null, condiciones, condiciones[0]);

        String comidaInicialStr = JOptionPane.showInputDialog(this, "Introduce la cantidad inicial de comida que se le dará el primer día");
        int comidaInicial = Integer.parseInt(comidaInicialStr);
        if (comidaInicial < 0 || comidaInicial >= 300) {
            JOptionPane.showMessageDialog(this, "La cantidad inicial de comida debe ser un valor entero menor que 300");
            return;
        }

        String diaIncrementoComidaStr = JOptionPane.showInputDialog(this, "Introduce el día hasta el cual se debe incrementar la cantidad de comida");
        int diaIncrementoComida = Integer.parseInt(diaIncrementoComidaStr);
        if (diaIncrementoComida <= 0 || diaIncrementoComida >= 30) {
            JOptionPane.showMessageDialog(this, "El día hasta el cual se debe incrementar la cantidad de comida debe ser un valor entero mayor que 0 y menor que 30");
            return;
        }

        String comidaDiaIncrementoStr = JOptionPane.showInputDialog(this, "Introduce la comida de este día");
        int comidaDiaIncremento = Integer.parseInt(comidaDiaIncrementoStr);
        if (comidaDiaIncremento < 0 || comidaDiaIncremento >= 300) {
            JOptionPane.showMessageDialog(this, "La comida de este día debe ser un valor entero menor que 300");
            return;
        }

        String comidaFinalStr = JOptionPane.showInputDialog(this, "Introduce la cantidad final de comida en el día 30");
        int comidaFinal = Integer.parseInt(comidaFinalStr);
        if (comidaFinal < 0 || comidaFinal >= 300) {
            JOptionPane.showMessageDialog(this, "La cantidad final de comida en el día 30 debe ser un valor entero menor que 300");
            return;
        }

        Bacteria bacteria = new Bacteria(nombre, fechaInicio, fechaFin, numBacteriasIniciales, temperatura, condicionLuminosidad, comidaInicial, diaIncrementoComida, comidaDiaIncremento, comidaFinal);
        experimento.agregarBacteria(bacteria);

        DefaultListModel<Experimento> model = (DefaultListModel<Experimento>) experimentoList.getModel();

        int index = model.indexOf(experimento);
        if (index != -1) {
            model.set(index, experimento);
        }

        ListModel modelBacteria = bacteriaList.getModel();
        DefaultListModel<Bacteria> bacteriaModel;
        if (modelBacteria instanceof DefaultListModel) {
            bacteriaModel = (DefaultListModel<Bacteria>) modelBacteria;
        } else {
            bacteriaModel = new DefaultListModel<>();
            bacteriaList.setModel(bacteriaModel);
        }
        bacteriaModel.addElement(bacteria);

    }

    private void guardarExperimentos() {
        DefaultListModel<Experimento> model = (DefaultListModel<Experimento>) experimentoList.getModel();
        for (int i = 0; i < model.getSize(); i++) {
            Experimento experimento = model.getElementAt(i);
            try {
                Almacenamiento.guardarExperimento(experimento, experimento.getNombre() + ".ser");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar el experimento " + experimento.getNombre());
            }
        }
    }

    private void cargarExperimentos() {
        File folder = new File("src/main/resources/ExperimentosGuardados");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    try {
                        Experimento experimento = Almacenamiento.cargarExperimento(file.getName());
                        ((DefaultListModel<Experimento>) experimentoList.getModel()).addElement(experimento);
                    } catch (IOException | ClassNotFoundException e) {
                        JOptionPane.showMessageDialog(this, "Error al cargar el experimento " + file.getName());
                    }
                }
            }
        }
    }
}
