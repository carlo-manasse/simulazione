/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulazione;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ShapeUtilities;

/**
 *
 * @author carlo
 */
public class FrameProveRipetute extends javax.swing.JFrame {

    /**
     * Creates new form FrameProveRipetute
     */
    public static final double U_ALPHA_MEZZI = 1.645;
    private int simulazioniCompletate;
    private Vector<Simulazione> listSimulazioni;
    int numSimulazioni;

    public FrameProveRipetute(Vector<Simulazione> listSimulazioni) {
        this.listSimulazioni = new Vector<>();
        this.listSimulazioni = listSimulazioni;
        this.numSimulazioni = listSimulazioni.size();
        simulazioniCompletate = 0;

        initComponents();
        jProgressBar1.setMinimum(0);
        jProgressBar1.setMaximum(numSimulazioni);

        jLabelOperatore.setBackground(Color.white);
        jLabelFaiDaTe.setBackground(Color.white);
        jLabelOperatore.setOpaque(true);
        jLabelFaiDaTe.setOpaque(true);
        jLabelOperatore.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 16));
        jLabelFaiDaTe.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 16));
        jLabelOperatore.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelFaiDaTe.setHorizontalAlignment(SwingConstants.CENTER);

        for (Simulazione tr : listSimulazioni) {
            tr.setFrameSimulazione(this);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startButton = new javax.swing.JButton();
        grafico = new javax.swing.JPanel();
        grafico1 = new javax.swing.JPanel();
        torta2 = new javax.swing.JPanel();
        torta1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabelOperatore = new javax.swing.JLabel();
        jLabelFaiDaTe = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        grafico.setBackground(new java.awt.Color(255, 255, 255));
        grafico.setLayout(new java.awt.BorderLayout());

        grafico1.setBackground(new java.awt.Color(255, 255, 255));
        grafico1.setLayout(new java.awt.BorderLayout());

        torta2.setBackground(new java.awt.Color(255, 255, 255));
        torta2.setPreferredSize(new java.awt.Dimension(210, 190));
        torta2.setLayout(new java.awt.BorderLayout());

        torta1.setBackground(new java.awt.Color(255, 255, 255));
        torta1.setPreferredSize(new java.awt.Dimension(210, 190));
        torta1.setLayout(new java.awt.BorderLayout());

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabelOperatore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelFaiDaTe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("completamento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(grafico, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                            .addComponent(grafico1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(torta1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(torta2, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabelOperatore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelFaiDaTe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(44, 44, 44)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(grafico, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(torta1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelOperatore, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(torta2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelFaiDaTe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(grafico1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("inizio simulazione");
        //printArea("inizio simulazione");

        for (Simulazione tr : listSimulazioni) {
            tr.setTempoAttesa(50);
            tr.start();
        }
        startButton.setEnabled(false);
    }//GEN-LAST:event_startButtonActionPerformed

    synchronized void simulazioneCompletata() {
        simulazioniCompletate++;
        jProgressBar1.setValue(simulazioniCompletate);
        //System.out.println(simulazioniCompletate + " simulazioni completate");

        if (simulazioniCompletate == numSimulazioni) {
            System.out.println("fine simulazione");
            double sommaRhoOperatore = 0.0;
            double sommaRhoFaiDaTe = 0.0;
            double sommaMuOperatore = 0.0;
            double sommaMuFaiDaTe = 0.0;
            double sommaLambdaOperatore = 0.0;
            double sommaLambdaFaiDaTe = 0.0;
            double sommaMedieAtteseOperatore = 0.0;
            double sommaMedieAtteseFaiDaTe = 0.0;

            for (Simulazione tr : listSimulazioni) {
                StatisticheSimulazione s = tr.getStats();
                sommaRhoOperatore += s.mediaRhoOPERATORE;
                sommaRhoFaiDaTe += s.mediaRhoFAIDATE;
                sommaMuOperatore += s.mediaMuOPERATORE;
                sommaMuFaiDaTe += s.mediaMuFAIDATE;
                sommaLambdaOperatore += s.mediaLambdaOPERATORE;
                sommaLambdaFaiDaTe += s.mediaLambdaFAIDATE;
                sommaMedieAtteseOperatore += s.mediaAtteseOPERATORE;
                sommaMedieAtteseFaiDaTe += s.mediaAtteseFAIDATE;
                //sommaRho+=s.getRho();
                //sommaMu+=s.getMu();
                //sommaLambda+=s.getLambda();
            }

            double mediaRhoOperatore = sommaRhoOperatore / numSimulazioni;
            double mediaRhoFaiDaTe = sommaRhoFaiDaTe / numSimulazioni;
            double mediaMuOperatore = sommaMuOperatore / numSimulazioni;
            double mediaMuFaiDaTe = sommaMuFaiDaTe / numSimulazioni;
            double mediaLambdaOperatore = sommaLambdaOperatore / numSimulazioni;
            double mediaLambdaFaiDaTe = sommaLambdaFaiDaTe / numSimulazioni;
            double mediaMedieAtteseOperatore = sommaMedieAtteseOperatore / numSimulazioni;
            double mediaMedieAtteseFaiDaTe = sommaMedieAtteseFaiDaTe / numSimulazioni;

            String strOperatore =
                    "\nmedia dei Rho Operatore: " + mediaRhoOperatore
                    + "\nmedia dei Mu Operatore: " + mediaMuOperatore
                    + "\nmedia dei Lambda Operatore: " + mediaLambdaOperatore
                    + "\nmedia delle Attese medie Operatore: " + mediaMedieAtteseOperatore
                    + "\n"
                    + "\nmedia dei Rho FaiDaTe: " + mediaRhoFaiDaTe
                    + "\nmedia dei Mu FaiDaTe: " + mediaMuFaiDaTe
                    + "\nmedia dei Lambda FaiDaTe: " + mediaLambdaFaiDaTe
                    + "\nmedia delle Attese medie FaiDaTe: " + mediaMedieAtteseFaiDaTe;

            System.out.println(strOperatore);
            //jTextArea1.setText(strOperatore);
            printArea(strOperatore);

            double sommaQuadratiOperatore = 0.0;
            double sommaQuadratiFaiDaTe = 0.0;
            for (Simulazione tr : listSimulazioni) {
                StatisticheSimulazione s = tr.getStats();
                sommaQuadratiOperatore += Math.pow((s.mediaAtteseOPERATORE - mediaMedieAtteseOperatore), 2);
                sommaQuadratiFaiDaTe += Math.pow((s.mediaAtteseFAIDATE - mediaMedieAtteseFaiDaTe), 2);
            }

            double S2Operatore = sommaQuadratiOperatore * (numSimulazioni / (numSimulazioni - 1));
            double S2FaiDaTe = sommaQuadratiFaiDaTe * (numSimulazioni / (numSimulazioni - 1));// / (numSimulazioni - 1);

            //double SOperatore = Math.sqrt(S2Operatore);
            //double SFaiDaTe = Math.sqrt(S2FaiDaTe);
            double stdErrorOperatore = Math.sqrt(S2Operatore / numSimulazioni);
            double stdErrorFaiDaTe = Math.sqrt(S2FaiDaTe / numSimulazioni);

            double infOperatore = calcolaInf(numSimulazioni, mediaMedieAtteseOperatore, stdErrorOperatore);
            double supOperatore = calcolaSup(numSimulazioni, mediaMedieAtteseOperatore, stdErrorOperatore);

            double infFaiDaTe = calcolaInf(numSimulazioni, mediaMedieAtteseFaiDaTe, stdErrorFaiDaTe);
            double supFaiDaTe = calcolaSup(numSimulazioni, mediaMedieAtteseFaiDaTe, stdErrorFaiDaTe);


            System.out.println("inf Operatore: " + infOperatore);
            System.out.println("inf FaiDaTe: " + infFaiDaTe);
            System.out.println("sup Operatore: " + supOperatore);
            System.out.println("sup FaiDaTe: " + supFaiDaTe);
            System.out.println("stdErrorOperatore " + stdErrorOperatore);
            System.out.println("stdErrorFaiDaTe " + stdErrorFaiDaTe);
            
            int countOperatore = 0;
            int countFaiDaTe = 0;

            for (Simulazione tr : listSimulazioni) {
                StatisticheSimulazione s = tr.getStats();
                //System.out.println(" attesa Operatore: " + s.mediaAtteseOPERATORE);
                if (s.mediaAtteseOPERATORE >= infOperatore && s.mediaAtteseOPERATORE <= supOperatore) {
                    countOperatore++;
                }
                if (s.mediaAtteseFAIDATE >= infFaiDaTe && s.mediaAtteseFAIDATE <= supFaiDaTe) {
                    countFaiDaTe++;
                }
            }


            System.out.println("confidenza attesa Operatore: " + countOperatore + " su " + numSimulazioni);
            printArea("\nconfidenza attesa Operatore: " + countOperatore + " su " + numSimulazioni);
            System.out.println("confidenza attesa FaiDaTe: " + countFaiDaTe + " su " + numSimulazioni);
            printArea("confidenza attesa FaiDaTe: " + countFaiDaTe + " su " + numSimulazioni);


            disegnaGrafico1(infOperatore, supOperatore, numSimulazioni, listSimulazioni, mediaMedieAtteseOperatore);
            disegnaGrafico2(infFaiDaTe, supFaiDaTe, numSimulazioni, listSimulazioni, mediaMedieAtteseFaiDaTe);
            disegnaTorta1(countOperatore);
            disegnaTorta2(countFaiDaTe);

            if (mediaRhoOperatore <= 1.0) {
                jLabelOperatore.setText("Rho Operatore - stabile");
                jLabelOperatore.setBackground(Color.green);
            } else {
                jLabelOperatore.setText("Rho Operatore - instabile");
                jLabelOperatore.setBackground(Color.red);
            }

            if (mediaRhoFaiDaTe <= 1.0) {
                jLabelFaiDaTe.setText("Rho Fai da te - stabile");
                jLabelFaiDaTe.setBackground(Color.green);
            } else {
                jLabelFaiDaTe.setText("Rho Fai da te - instabile");
                jLabelFaiDaTe.setBackground(Color.red);
            }
        }
    }

    public static double calcolaInf(int numSimulazioni, double mediaMedieAttese, double S) {
        double inf = mediaMedieAttese - (S * U_ALPHA_MEZZI);
        if (inf < 0.0) {
            inf = 0.0;
        }
        return inf;
    }

    public static double calcolaSup(int numSimulazioni, double mediaMedieAttese, double S) {
        double sup = mediaMedieAttese + (S * U_ALPHA_MEZZI);
        return sup;
    }

    private void disegnaGrafico1(double inf, double sup, int numSimulazioni, Vector<Simulazione> listSimulazioni, double mediaMedieAttese) {

        XYSeries xyseries1 = new XYSeries("Esperimento");
        for (int i = 0; i < numSimulazioni; i++) {
            xyseries1.add(i + 1, listSimulazioni.get(i).getStats().mediaAtteseOPERATORE);
        }

        XYSeries xyseries2 = new XYSeries("Media");
        for (int i = 0; i < numSimulazioni; i++) {
            xyseries2.add(i + 1, mediaMedieAttese);
        }

        XYSeries xyseries3 = new XYSeries("Inf");
        for (int i = 0; i < numSimulazioni; i++) {
            xyseries3.add(i + 1, inf);
        }

        XYSeries xyseries4 = new XYSeries("Sup");
        for (int i = 0; i < numSimulazioni; i++) {
            xyseries4.add(i + 1, sup);
        }

        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries(xyseries1);
        xyseriescollection.addSeries(xyseries2);
        xyseriescollection.addSeries(xyseries3);
        xyseriescollection.addSeries(xyseries4);

        JFreeChart chart = ChartFactory.createXYLineChart("Grafico delle medie d'attesa (Operatore)",
                "Numero Esperimenti", "Attesa (sec)", xyseriescollection,
                PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = (XYPlot) chart.getPlot();
        xyplot.setBackgroundPaint(Color.white);
        xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) xyplot.getRenderer();
        // 1 ->Esperimento
        xylineandshaperenderer.setSeriesShapesVisible(0, true);
        xylineandshaperenderer.setSeriesShape(0, ShapeUtilities.createDiamond(1F));
        xylineandshaperenderer.setSeriesPaint(0, Color.GREEN);
        // 2 ->Media
        xylineandshaperenderer.setSeriesShapesVisible(1, false);
        xylineandshaperenderer.setSeriesPaint(1, Color.BLACK);
        // 3 ->Inf
        xylineandshaperenderer.setSeriesShapesVisible(2, false);
        xylineandshaperenderer.setSeriesPaint(2, Color.BLUE);
        // 4 ->Sup
        xylineandshaperenderer.setSeriesShapesVisible(3, false);
        xylineandshaperenderer.setSeriesPaint(3, Color.RED);

        NumberAxis numberaxis = (NumberAxis) xyplot.getRangeAxis();
        numberaxis.setAutoRangeIncludesZero(false);
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        BufferedImage image = chart.createBufferedImage(450, 270);
        JLabel labelGrafico = new JLabel();
        labelGrafico.setIcon(new ImageIcon(image));
        grafico.add(labelGrafico, BorderLayout.CENTER);
        grafico.validate();
    }

    private void disegnaGrafico2(double inf, double sup, int numSimulazioni, Vector<Simulazione> listSimulazioni, double mediaMedieAttese) {

        XYSeries xyseries1 = new XYSeries("Esperimento");
        for (int i = 0; i < numSimulazioni; i++) {
            xyseries1.add(i + 1, listSimulazioni.get(i).getStats().mediaAtteseFAIDATE);
        }

        XYSeries xyseries2 = new XYSeries("Media");
        for (int i = 0; i < numSimulazioni; i++) {
            xyseries2.add(i + 1, mediaMedieAttese);
        }

        XYSeries xyseries3 = new XYSeries("Inf");
        for (int i = 0; i < numSimulazioni; i++) {
            xyseries3.add(i + 1, inf);
        }

        XYSeries xyseries4 = new XYSeries("Sup");
        for (int i = 0; i < numSimulazioni; i++) {
            xyseries4.add(i + 1, sup);
        }

        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries(xyseries1);
        xyseriescollection.addSeries(xyseries2);
        xyseriescollection.addSeries(xyseries3);
        xyseriescollection.addSeries(xyseries4);

        JFreeChart chart = ChartFactory.createXYLineChart("Grafico delle medie d'attesa (Fai da te)",
                "Numero Esperimenti", "Attesa (sec)", xyseriescollection,
                PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = (XYPlot) chart.getPlot();
        xyplot.setBackgroundPaint(Color.white);
        xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) xyplot.getRenderer();
        // 1 ->Esperimento
        xylineandshaperenderer.setSeriesShapesVisible(0, true);
        xylineandshaperenderer.setSeriesShape(0, ShapeUtilities.createDiamond(1F));
        xylineandshaperenderer.setSeriesPaint(0, Color.GREEN);
        // 2 ->Media
        xylineandshaperenderer.setSeriesShapesVisible(1, false);
        xylineandshaperenderer.setSeriesPaint(1, Color.BLACK);
        // 3 ->Inf
        xylineandshaperenderer.setSeriesShapesVisible(2, false);
        xylineandshaperenderer.setSeriesPaint(2, Color.BLUE);
        // 4 ->Sup
        xylineandshaperenderer.setSeriesShapesVisible(3, false);
        xylineandshaperenderer.setSeriesPaint(3, Color.RED);

        NumberAxis numberaxis = (NumberAxis) xyplot.getRangeAxis();
        numberaxis.setAutoRangeIncludesZero(false);
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        BufferedImage image = chart.createBufferedImage(450, 270);
        JLabel labelGrafico = new JLabel();
        labelGrafico.setIcon(new ImageIcon(image));
        grafico1.add(labelGrafico, BorderLayout.CENTER);
        grafico1.validate();
    }

    private void disegnaTorta1(int correct) {

        DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
        defaultpiedataset.setValue("ok", correct);
        defaultpiedataset.setValue("no", numSimulazioni - correct);
        JFreeChart jfreechart = ChartFactory.createPieChart(null, defaultpiedataset, true, true, false);
        PiePlot pieplot = (PiePlot) jfreechart.getPlot();
        pieplot.setSectionPaint("ok", Color.GREEN);
        pieplot.setSectionPaint("no", Color.RED);
        pieplot.setNoDataMessage("Nessun dato disponibile");
        pieplot.setExplodePercent("no", 0.20000000000000001D);
        pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} " + "{1}" + " ({2})"));
        pieplot.setLabelBackgroundPaint(new Color(220, 220, 220));
        pieplot.setSimpleLabels(true);
        pieplot.setInteriorGap(0.0D);

        BufferedImage image2 = jfreechart.createBufferedImage(190, 170);
        JLabel labelTorta = new JLabel();
        labelTorta.setIcon(new ImageIcon(image2));
        torta1.add(labelTorta, BorderLayout.CENTER);
        torta1.validate();
    }

    private void disegnaTorta2(int correct) {

        DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
        defaultpiedataset.setValue("ok", correct);
        defaultpiedataset.setValue("no", numSimulazioni - correct);
        JFreeChart jfreechart = ChartFactory.createPieChart(null, defaultpiedataset, true, true, false);
        PiePlot pieplot = (PiePlot) jfreechart.getPlot();
        pieplot.setSectionPaint("ok", Color.GREEN);
        pieplot.setSectionPaint("no", Color.RED);
        pieplot.setNoDataMessage("Nessun dato disponibile");
        pieplot.setExplodePercent("no", 0.20000000000000001D);
        pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} " + "{1}" + " ({2})"));
        pieplot.setLabelBackgroundPaint(new Color(220, 220, 220));
        pieplot.setSimpleLabels(true);
        pieplot.setInteriorGap(0.0D);

        BufferedImage image2 = jfreechart.createBufferedImage(190, 170);
        JLabel labelTorta = new JLabel();
        labelTorta.setIcon(new ImageIcon(image2));
        torta2.add(labelTorta, BorderLayout.CENTER);
        torta2.validate();
    }

    public void printArea(String str) {
        jTextArea1.append(str + "\n");
        jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel grafico;
    private javax.swing.JPanel grafico1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFaiDaTe;
    private javax.swing.JLabel jLabelOperatore;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton startButton;
    private javax.swing.JPanel torta1;
    private javax.swing.JPanel torta2;
    // End of variables declaration//GEN-END:variables
}