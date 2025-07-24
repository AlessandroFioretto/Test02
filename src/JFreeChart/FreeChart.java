package JFreeChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class FreeChart {

    public static void main(String[] args) {
        System.out.println("Avvio del test JFreeChart...");

        try {
            // Creazione dataset
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.addValue(1, "Serie A", "Categoria 1");
            dataset.addValue(4, "Serie A", "Categoria 2");
            dataset.addValue(3, "Serie A", "Categoria 3");

            System.out.println("Dataset creato con successo.");

            // Creazione del grafico
            JFreeChart chart = ChartFactory.createBarChart(
                    "Grafico di Test",         // Titolo
                    "Categoria",               // Etichetta asse X
                    "Valore",                  // Etichetta asse Y
                    dataset,                   // Dataset
                    PlotOrientation.VERTICAL,  // Orientamento
                    true,                      // Mostra legenda
                    true,                      // Tooltips
                    false                      // URLs
            );

            System.out.println("Grafico creato con successo.");

            // Creazione e visualizzazione del pannello
            ChartPanel chartPanel = new ChartPanel(chart);
            JFrame frame = new JFrame("Test JFreeChart");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(chartPanel);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            System.out.println("JFreeChart funziona correttamente.");

        } catch (Exception e) {
            System.out.println("JFreeChart NON funziona correttamente.");
            e.printStackTrace(); // Stampa dettagli dell'errore
        }
    }
}