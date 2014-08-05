/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulazione;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author carlo
 */
public class Simulazione extends Thread {

    private EventList eventList;
    private StatisticheSimulazione stats;
    private int totaleArrivi;
    private int totalePartenze;
    private int totaleClienti;
    private boolean EndOfSim;
    private boolean inPause;
    private double currentTime;
    private double oldTime;
    private double tempoSimulazione;
    private int tempoAttesa;
    Vector<Cassa> casse;
    private int numCasseFaiDaTe;
    private int numOperatori;
    private Exponential distArrivi;
    private FrameSimulazione simFrame;
    private FrameProveRipetute simFrameRip;

    Simulazione(double paramArrivi, int numCasseFaiDaTe, int numOperatori,
            double paramFaiDaTe, double paramOperatore, double tempoSimulazione) {

        this.numOperatori = numOperatori;
        this.numCasseFaiDaTe = numCasseFaiDaTe;

        double lambda = 1 / paramArrivi;
        distArrivi = new Exponential(lambda);
        this.tempoSimulazione = tempoSimulazione;

        int i;
        casse = new Vector<Cassa>();
        for (i = 0; i < numOperatori; i++) {
            casse.insertElementAt(new Cassa(TipoCassa.OPERATORE, i, paramOperatore), i);
        }

        for (; i < numOperatori + numCasseFaiDaTe; i++) {
            casse.insertElementAt(new Cassa(TipoCassa.FAIDATE, i - numOperatori, paramFaiDaTe), i);
        }

        eventList = new EventList();

        stats = new StatisticheSimulazione(numOperatori, numCasseFaiDaTe);
        inizializza();

    }

    void arrivo(Event evento) {

        stats.AccumulaStatistiche(totaleArrivi, totaleClienti, totalePartenze, currentTime);
        Cassa cassaEvento = evento.getCassa();
        cassaEvento.arrivo(currentTime, totaleArrivi + 1);
        Event nuovoEvento;
        //statistiche()
        totaleArrivi++;
        totaleClienti++;

        Cassa cassaSel = cassaSelezionata();
        nuovoEvento = new Event(TipoEvento.ARRIVAL, currentTime + distArrivi.NextValue(), cassaSel);
        eventList.sched(nuovoEvento);
        if (cassaEvento.getNumClienti() == 1) {
            nuovoEvento = new Event(TipoEvento.DEPARTURE, currentTime + cassaEvento.getTempoServizio(), cassaEvento);
            eventList.sched(nuovoEvento);
        }

        String str = this.getName() + " evento arrivo: tempo " + String.format("%.3f%n", evento.getSchedTime()) + " cassa tipo "
                + cassaEvento.getTipoCassa().name() + " numero " + cassaEvento.getNumeroCassa() + "\n"
                + "utenti nel sistema: " + totaleClienti + " - utenti in cassa : " + cassaEvento.getNumClienti() + "\n";

        if (simFrame != null) {
            System.out.println(str);
            simFrame.printArea(str);
        }
    }

    void partenza(Event evento) {

        stats.AccumulaStatistiche(totaleArrivi, totaleClienti, totalePartenze, currentTime);
        Cassa cassaEvento = evento.getCassa();
        cassaEvento.partenza(currentTime);
        totalePartenze++;
        totaleClienti--;
        //stats

        Event nuovaPartenza;
        if (cassaEvento.getNumClienti() > 0) {
            nuovaPartenza = new Event(TipoEvento.DEPARTURE, currentTime + cassaEvento.getTempoServizio(), cassaEvento);
            eventList.sched(nuovaPartenza);
        }

        String str = this.getName() + " evento partenza: tempo " + String.format("%.3f%n", evento.getSchedTime()) + " cassa tipo "
                + cassaEvento.getTipoCassa().name() + " numero " + cassaEvento.getNumeroCassa() + "\n"
                + "utenti nel sistema: " + totaleClienti + " - utenti in cassa : " + cassaEvento.getNumClienti() + "\n";

        if (simFrame != null) {
            System.out.println(str);
            simFrame.printArea(str);
        }
    }

    private void inizializza() {

        Event Evento;
        totaleArrivi = 0;
        totalePartenze = 0;
        totaleClienti = 0;
        EndOfSim = false;
        inPause = false;
        oldTime = 0.0;


        Evento = new Event(TipoEvento.ARRIVAL, 0.0, cassaSelezionata());
        eventList.sched(Evento);

        Evento = new Event(tempoSimulazione);
        eventList.sched(Evento);

        currentTime = 0.0;

    }

    void clock() {
        Event eventoSchedulato = eventList.getEvento();
        currentTime = eventoSchedulato.getSchedTime();

        switch (eventoSchedulato.getTipo()) {
            case ARRIVAL:
                arrivo(eventoSchedulato);
                break;
            case DEPARTURE:
                partenza(eventoSchedulato);
                break;
            case SIM_END:
                EndOfSim = true;
                break;
        }

    }

    
    private Cassa cassaSelezionata1(){
        
         if(totaleClienti!=0){
         int imin=0;
         for (int i=0;i<casse.size();i++){
         if(casse.elementAt(i).getNumClienti()<casse.elementAt(imin).getNumClienti()){
         imin=i;
         }
         }
            
            
         Cassa cassa=casse.elementAt(imin);
         return cassa;
            
         } else {
         //System.out.println("cassa selezionata 0");
         return casse.elementAt(0);
            
         }

    }
    
    private Cassa cassaSelezionata2(int j){
    
         Cassa cassa=casse.elementAt(j);
         j++;
         j=j%(numOperatori+numCasseFaiDaTe);
         
         return cassa;
    }
    
    
    private Cassa cassaSelezionata() {

        //da riscrivere con le probabilità

        double somma = 0.0;

        //l'array di seguito contiene per ogni cassa la probabilità di essere selezionata
        double[] arrayProb = new double[casse.size()];

        for (int i = 0; i < casse.size(); i++) {
            double esponente = 1.5 * casse.elementAt(i).getNumClienti();
            arrayProb[i] = Math.pow(Math.E, -esponente);

            if (casse.elementAt(i).getTipoCassa() == TipoCassa.FAIDATE) {
                arrayProb[i] = (double) 1 / 4 * arrayProb[i];
            } else {
                arrayProb[i] = (double) 3 / 4 * arrayProb[i];
            }
            //System.out.println("prob cassa "+i+" = "+arrayProb[i]);
            somma = somma + arrayProb[i];
        }


        for (int i = 0; i < casse.size(); i++) {
            arrayProb[i] = arrayProb[i] / somma;
            //System.out.println("prob cassa "+i+" = "+arrayProb[i]+", utenti = "
            //        +casse.elementAt(i).getNumClienti()+", totale clienti = "+totaleClienti);
        }

        double rand = Math.random();
        double somma2 = 0.0;
        int i;
        for (i = 0; i < casse.size(); i++) {
            //una volta normalizzata la probabilità si divide il range [0,1]
            //in casse.size() parti, ognuna proporzionale alla probabilità di una cassa.
            //a questo punto si stabilisce in quale parte cade il numero random generato.
            //nota che tanti più clienti si trovano nella cassa i tanta più bassa è la sua probabilità.
            //Quindi essendo più piccolo il segmento in [0,1] associato alla cassa è più difficile che rand ci ricada.

            somma2 += arrayProb[i];
            if (somma2 > rand) {
                break;
            }
        }


        //System.out.println("cassa selezionata "+i);
        Cassa cassa = casse.elementAt(i);
        return cassa;
    }

    @Override
    public void run() {

        do {
            if (inPause) {
                ;
            } else {
                clock();
                if (simFrame != null) {
                    simFrame.aggiorna();
                }
                try {
                    Thread.sleep(tempoAttesa);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Simulazione.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } while (EndOfSim == false);




//        for(int i=0;i<casse.size();i++){
//            System.out.println(" tempo attesa medio per cassa "+i+" "+casse.elementAt(i).getMediaTempoAttesa());
//        }

        /*    for(int i=0;i<casse.size();i++){
         System.out.println("\nstatistiche cassa "+i+" \n"+casse.elementAt(i).endSim().Report());
         }*/

        stats.Report();
        stats.calcolaMedie(casse);
        //prova singola
        if (simFrame != null) {
            String str = stats.reportString();
            String str2=stats.ReportMedie();
            System.out.println(str);
            simFrame.printArea(str+"\n");
            System.out.println(str2);
            simFrame.printArea(str2);
            simFrame.setLabelStabile(stats.mediaRhoOPERATORE, stats.mediaRhoFAIDATE);
            
        } //prove ripetute
        else {
            simFrameRip.simulazioneCompletata();
        }
    }

    void setTempoAttesa(int tempoAttesa) {
        //il valore passato varia tra 0(velocità minima) e 50(velocità massima)
        tempoAttesa = (50 - tempoAttesa) * 10;
        this.tempoAttesa = tempoAttesa;
    }

    void setFrameSimulazione(JFrame TypeSimFrame) {
        if (TypeSimFrame.getClass().getName().equals(FrameSimulazione.class.getName())) {
            this.simFrame = (FrameSimulazione) TypeSimFrame;
        } else {
            this.simFrameRip = (FrameProveRipetute) TypeSimFrame;

        }
    }

    void setInPause() {
        this.inPause = !this.inPause;
    }

    StatisticheSimulazione getStats() {
        return stats;
    }
}
