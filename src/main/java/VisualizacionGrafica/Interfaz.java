package VisualizacionGrafica;

import Clases.Bacteria;
import Clases.Experimento;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

        addButton.addActionListener(e -> {
            try {
                agregarExperimento();
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        });
        saveButton.addActionListener(e -> guardarExperimentos());
        loadButton.addActionListener(e -> cargarExperimentos());
    }

    private void agregarExperimento() throws ParseException {
        String nombre = JOptionPane.showInputDialog(this, "Introduce el nombre de la población");
        String fechaInicio = JOptionPane.showInputDialog(this, "Introduce la fecha de inicio de la población (dd/MM/yyyy)");
        String fechaFin = JOptionPane.showInputDialog(this, "Introduce la fecha de fin de la población (dd/MM/yyyy)");
        String numBacteriasIniciales = JOptionPane.showInputDialog(this, "Introduce el número de bacterias iniciales");
        String temperatura = JOptionPane.showInputDialog(this, "Introduce la temperatura a la que se someterán las bacterias");
        String[] condiciones = {"Alta", "Media", "Baja"};
        String condicionLuminosidad = (String) JOptionPane.showInputDialog(this, "Selecciona las condiciones de luminosidad", "Luminosidad", JOptionPane.QUESTION_MESSAGE, null, condiciones, condiciones[0]);
        String comidaInicial = JOptionPane.showInputDialog(this, "Introduce la cantidad inicial de comida que se le dará el primer día");
        String diaIncrementoComida = JOptionPane.showInputDialog(this, "Introduce el día hasta el cual se debe incrementar la cantidad de comida");
        String comidaDiaIncremento = JOptionPane.showInputDialog(this, "Introduce la comida de este día");
        String comidaFinal = JOptionPane.showInputDialog(this, "Introduce la cantidad final de comida en el día 30");

        if (nombre != null && fechaInicio != null && fechaFin != null && numBacteriasIniciales != null && temperatura != null && condicionLuminosidad != null && comidaInicial != null && diaIncrementoComida != null && comidaDiaIncremento != null && comidaFinal != null) {
            Bacteria bacteria = new Bacteria(nombre, new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio), new SimpleDateFormat("dd/MM/yyyy").parse(fechaFin), Integer.parseInt(numBacteriasIniciales), Double.parseDouble(temperatura), condicionLuminosidad, Integer.parseInt(comidaInicial), Integer.parseInt(diaIncrementoComida), Integer.parseInt(comidaDiaIncremento), Integer.parseInt(comidaFinal));
            Experimento experimento = new Experimento();
            experimento.agregarBacteria(bacteria);
            DefaultListModel<Experimento> model = (DefaultListModel<Experimento>) experimentoList.getModel();
            model.addElement(experimento);
        }
    }

    private void guardarExperimentos() {
        // Aquí irá el código para guardar los experimentos
    }

    private void cargarExperimentos() {
        // Aquí irá el código para cargar los experimentos
    }
}
