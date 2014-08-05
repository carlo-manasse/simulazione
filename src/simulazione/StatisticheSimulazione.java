/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulazione;

import java.util.Vector;

/**
 *
 * @author carlo
 */
public class StatisticheSimulazione {

    double mediaArriviOPERATORE = 0.0;
    double mediaPartenzeOPERATORE = 0.0;
    double mediaLambdaOPERATORE = 0.0;
    double mediaMuOPERATORE = 0.0;
    double mediaRhoOPERATORE = 0.0;
    double mediaThroughputOPERATORE = 0.0;
    double mediaUtilizzazioneOPERATORE = 0.0;
    double mediaClientiInCassaOPERATORE = 0.0;
    double mediaPermanenzaOPERATORE = 0.0;
    double mediaServizioOPERATORE = 0.0;
    double mediaAtteseOPERATORE = 0.0;
    double mediaArriviFAIDATE = 0;
    double mediaPartenzeFAIDATE = 0;
    double mediaLambdaFAIDATE = 0;
    double mediaMuFAIDATE = 0;
    double mediaRhoFAIDATE = 0;
    double mediaThroughputFAIDATE = 0;
    double mediaUtilizzazioneFAIDATE = 0;
    double mediaClientiInCassaFAIDATE = 0;
    double mediaPermanenzaFAIDATE = 0;
    double mediaServizioFAIDATE = 0;
    double mediaAtteseFAIDATE = 0;
    int numOperatori;
    int numCasseFaiDaTe;
    private int totaleArrivi;
    private int totalePartenze;
    private double Area; // Area sottostante la curva n(t)
    private double BTIME; // Tempo totale di occupazione del sistema
    private double OldTime;
    private double currentTime;
    private double Lambda; // Frequenza degli arrivi
    private double U; // Utilizzazione
    private double X; // Frequenza delle partenze

    public StatisticheSimulazione(int numOperatori, int numCasseFaiDaTe) {
        this.numOperatori = numOperatori;
        this.numCasseFaiDaTe = numCasseFaiDaTe;

        totaleArrivi = 0;
        totalePartenze = 0;
        Area = 0.0;
        BTIME = 0.0;
        OldTime = 0.0;
        currentTime = 0.0;

    }

    void AccumulaStatistiche(int totaleArrivi, int totaleClienti, int totalePartenze, double currentTime) {
        this.totaleArrivi = totaleArrivi;
        this.totalePartenze = totalePartenze;
        this.currentTime = currentTime;

        double Interval;
        Interval = currentTime - OldTime;
        OldTime = currentTime;
        if (totaleClienti > 0) {
            Area = Area + Interval * totaleClienti;
            BTIME = BTIME + Interval;
            //System.out.println("area "+Area);
            //System.out.println("BTIME "+BTIME);
        }


    }

    void Report() {
        Lambda = totaleArrivi / currentTime;
        X = totalePartenze / currentTime;
        U = BTIME / currentTime;
    }

    public String reportString() {

        String str = "\nRisultati dell'esperimento di simulazione:"
                + "\nArrivi totali: " + totaleArrivi
                + "\nPartenze totali: " + totalePartenze
                + "\nLambda totale: " + Lambda
                + "\nUtilizzazione totale: " + U
                + "\nThroughput totale: " + X;

        return str;
    }

    void calcolaMedie(Vector<Cassa> casse) {

        for (int i = 0; i < numOperatori; i++) {
            Statistiche statsCassa = casse.elementAt(i).endSim();
            mediaArriviOPERATORE += statsCassa.getTotaleArrivi();
            mediaPartenzeOPERATORE += statsCassa.getTotalePartenze();
            mediaLambdaOPERATORE += statsCassa.getLambda();
            mediaMuOPERATORE += statsCassa.getMu();
            mediaRhoOPERATORE += statsCassa.getRho();
            mediaThroughputOPERATORE += statsCassa.getX();
            mediaUtilizzazioneOPERATORE += statsCassa.getU();
            mediaClientiInCassaOPERATORE += statsCassa.getNMean();
            mediaPermanenzaOPERATORE += statsCassa.getWMean();
            mediaServizioOPERATORE += statsCassa.getTempoServizio();
            mediaAtteseOPERATORE += statsCassa.getMediaAttesa();

            //System.out.println("\nstatistiche cassa "+i+" \n"+casse.elementAt(i).endSim().Report());
        }

        mediaArriviOPERATORE /= (double) numOperatori;
        mediaPartenzeOPERATORE /= (double) numOperatori;
        mediaLambdaOPERATORE = mediaLambdaOPERATORE / (double) numOperatori;
        mediaMuOPERATORE /= (double) numOperatori;
        mediaRhoOPERATORE /= (double) numOperatori;
        mediaThroughputOPERATORE /= (double) numOperatori;
        mediaUtilizzazioneOPERATORE /= (double) numOperatori;
        mediaClientiInCassaOPERATORE /= (double) numOperatori;
        mediaPermanenzaOPERATORE /= (double) numOperatori;
        mediaServizioOPERATORE /= (double) numOperatori;
        mediaAtteseOPERATORE /= (double) numOperatori;

        for (int i = numOperatori; i < numOperatori + numCasseFaiDaTe; i++) {
            Statistiche statsCassa = casse.elementAt(i).endSim();
            mediaArriviFAIDATE += statsCassa.getTotaleArrivi();
            mediaPartenzeFAIDATE += statsCassa.getTotalePartenze();
            mediaLambdaFAIDATE += statsCassa.getLambda();
            mediaMuFAIDATE += statsCassa.getMu();
            mediaRhoFAIDATE += statsCassa.getRho();
            mediaThroughputFAIDATE += statsCassa.getX();
            mediaUtilizzazioneFAIDATE += statsCassa.getU();
            mediaClientiInCassaFAIDATE += statsCassa.getNMean();
            mediaPermanenzaFAIDATE += statsCassa.getWMean();
            mediaServizioFAIDATE += statsCassa.getTempoServizio();
            mediaAtteseFAIDATE += statsCassa.getMediaAttesa();

            //System.out.println("\nstatistiche cassa "+i+" \n"+casse.elementAt(i).endSim().Report());
        }

        mediaArriviFAIDATE /= (double) numCasseFaiDaTe;
        mediaPartenzeFAIDATE /= (double) numCasseFaiDaTe;
        mediaLambdaFAIDATE /= (double) numCasseFaiDaTe;
        mediaMuFAIDATE /= (double) numCasseFaiDaTe;
        mediaRhoFAIDATE /= (double) numCasseFaiDaTe;
        mediaThroughputFAIDATE /= (double) numCasseFaiDaTe;
        mediaUtilizzazioneFAIDATE /= (double) numCasseFaiDaTe;
        mediaClientiInCassaFAIDATE /= (double) numCasseFaiDaTe;
        mediaPermanenzaFAIDATE /= (double) numCasseFaiDaTe;
        mediaServizioFAIDATE /= (double) numCasseFaiDaTe;
        mediaAtteseFAIDATE /= (double) numCasseFaiDaTe;


    }
    
    public String ReportMedie(){
    
        String statsOperatore ="Statistiche casse Operatore \n"+
                "media arrivi " + mediaArriviOPERATORE + " \n"
                + "media partenze " + mediaPartenzeOPERATORE + " \n"
                + "media lambda " + mediaLambdaOPERATORE + " \n"
                + "media mu " + mediaMuOPERATORE + " \n"
                + "media rho " + mediaRhoOPERATORE + " \n"
                + "media throughput " + mediaThroughputOPERATORE + " \n"
                + "media utilizzazione " + mediaUtilizzazioneOPERATORE + " \n"
                + "media clienti in cassa " + mediaClientiInCassaOPERATORE + " \n"
                + "media tempo di permanenza " + mediaPermanenzaOPERATORE + " \n"
                + "media tempo di servizio " + mediaServizioOPERATORE + " \n"
                + "media tempi attesa " + mediaAtteseOPERATORE + " \n";
        //System.out.println(statsOperatore);

        String statsCasseFaiDaTe ="Statistiche casse fai da te\n"+
                "media arrivi " + mediaArriviFAIDATE + " \n"
                + "media partenze " + mediaPartenzeFAIDATE + " \n"
                + "media lambda " + mediaLambdaFAIDATE + " \n"
                + "media mu " + mediaMuFAIDATE + " \n"
                + "media rho " + mediaRhoFAIDATE + " \n"
                + "media throughput " + mediaThroughputFAIDATE + " \n"
                + "media utilizzazione " + mediaUtilizzazioneFAIDATE + " \n"
                + "media clienti in cassa " + mediaClientiInCassaFAIDATE + " \n"
                + "media tempo di permanenza " + mediaPermanenzaFAIDATE + " \n"
                + "media tempo di servizio " + mediaServizioFAIDATE + " \n"
                + "media tempi attesa " + mediaAtteseFAIDATE + " \n";

        //System.out.println(statsCasseFaiDaTe);
    
        return(statsOperatore+"\n"+statsCasseFaiDaTe);
    }
}
