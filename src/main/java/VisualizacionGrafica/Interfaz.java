package VisualizacionGrafica;

import Clases.Experimento;

import javax.swing.*;
import java.awt.*;

public class Interfaz extends JFrame {
    private JList<Experimento> experimentoList;
    private JButton addButton;
    private JButton saveButton;
    private JButton loadButton;

    public Interfaz() {
        super("Gestión de Experimentos");
        setLayout(new BorderLayout());

        experimentoList = new JList<>();
        addButton = new JButton("Agregar Experimento");
        saveButton = new JButton("Guardar Experimentos");
        loadButton = new JButton("Cargar Experimentos");

        add(new JScrollPane(experimentoList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> agregarExperimento());
        saveButton.addActionListener(e -> guardarExperimentos());
        loadButton.addActionListener(e -> cargarExperimentos());
    }

    private void agregarExperimento() {
        // Aquí irá el código para agregar un nuevo experimento
    }

    private void guardarExperimentos() {
        // Aquí irá el código para guardar los experimentos
    }

    private void cargarExperimentos() {
        // Aquí irá el código para cargar los experimentos
    }
}
