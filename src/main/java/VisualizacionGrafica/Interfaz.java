package VisualizacionGrafica;

import Clases.Bacteria;
import Clases.Experimento;
import Experimentos.Almacenamiento;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Interfaz extends JFrame {
    private JList<Experimento> experimentoList;
    private JButton addButton;
    private JButton saveButton;
    private JButton loadButton;

    public Interfaz() {
        super("Gestión de Experimentos");
        setLayout(new BorderLayout());

        experimentoList = new JList<>();
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
                agregarPoblacion();
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        });
        saveButton.addActionListener(e -> guardarExperimentos());
        loadButton.addActionListener(e -> cargarExperimentos());
    }

    private void agregarExperimento() throws ParseException {
        Experimento experimento = new Experimento();
        experimento.agregarBacteria(bacteria);
        DefaultListModel<Experimento> model = (DefaultListModel<Experimento>) experimentoList.getModel();
        model.addElement(experimento);

// Guardar el experimento en un archivo
        try {
            Almacenamiento.guardarExperimento(experimento, nombre + ".ser");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el experimento");
        }
    }

    private void agregarPoblacion() throws ParseException {
        Experimento experimento = experimentoList.getSelectedValue();
        if (experimento == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un experimento");
            return;
        }

        // Aquí puedes repetir el proceso de creación de una bacteria y agregarla al experimento
        // ...
        experimento.agregarBacteria(bacteria);

        // Actualizar la lista de bacterias
        DefaultListModel<Bacteria> model = (DefaultListModel<Bacteria>) bacteriaList.getModel();
        model.addElement(bacteria);

        // Guardar el experimento actualizado en un archivo
        try {
            Almacenamiento.guardarExperimento(experimento, experimento.getNombre() + ".ser");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el experimento");
        }
    }

    private void guardarExperimentos() {
        // Aquí irá el código para guardar los experimentos
    }

    private void cargarExperimentos() {
        // Aquí irá el código para cargar los experimentos
    }
}
