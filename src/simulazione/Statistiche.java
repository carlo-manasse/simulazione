/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulazione;

import javax.swing.JFrame;

/**
 *
 * @author carlo
 */
public class Statistiche {
    
    //int NumSys; // Numero di clienti nel sistema
    
    private int totaleArrivi;
    private int totalePartenze;
    private int totaleClienti;
    
    private double Area; // Area sottostante la curva n(t)
    private double BTIME; // Tempo totale di occupazione del sistema
    private double OldTime;
    private double currentTime;
    
    
    private double Lambda; // Frequenza degli arrivi
    private double Mu; // Tasso di servizio
    private double NMean; // Lunghezza media della coda
    private double U; // Utilizzazione
    private double WMean; // Tempo medio di attesa
    private double X; // Frequenza delle partenze
    private double rho;
    private double mediaAttesa;
    private double tempoServizio;
    
    Statistiche(){
        totaleArrivi=0;
        totaleClienti=0;
        totalePartenze=0;
        Area=0.0;
        BTIME=0.0;
        OldTime=0.0;
        currentTime=0.0; 
        mediaAttesa=0.0;
        tempoServizio=0.0;
    
    }
    
    void AccumulaStatistiche(int totaleArrivi,int totaleClienti,int totalePartenze,double currentTime){
        this.totaleArrivi=totaleArrivi;
        this.totaleClienti=totaleClienti;
        this.totalePartenze=totalePartenze;
        this.currentTime=currentTime;
                
        double Interval;
        Interval = currentTime-OldTime;
        OldTime = currentTime;
        if (totaleClienti > 0) {
            Area = Area + Interval * totaleClienti;
            BTIME = BTIME + Interval;
            //System.out.println("area "+Area);
            //System.out.println("BTIME "+BTIME);
        }
        
        
    }
    
    void Report(){ 
        NMean = Area / currentTime; 
        WMean = Area / totalePartenze;
        Lambda = totaleArrivi / currentTime; 
        Mu = totalePartenze / BTIME;
        X = totalePartenze / currentTime; 
        U = BTIME / currentTime;
        rho = Lambda/Mu;
        tempoServizio=1/Mu;
        mediaAttesa=WMean-tempoServizio;

    }
    
    
    public String reportString(){
            
       String str="\nRisultati dell'esperimento di simulazione:"+
                "\nArrivi: " + totaleArrivi+
                "\nPartenze: " + totalePartenze +
                "\nLambda: " + Lambda +
                "\nMu: " + Mu +
                "\nRho: " + rho +
                "\nThroughput: " + X +
                "\nUtilizzazione: " + U +
                "\nNumero medio di clienti nel sistema: " + NMean +
                "\nTempo medio di permanenza: " + WMean +
                "\nTempo medio servizio: " + tempoServizio +
                "\nTempo medio attesa: " + mediaAttesa;
       return str;
    }
    
    public double getLambda(){
        return Lambda;
    }
    public double getMu(){
        return Mu;
    }
    public double getNMean(){
        return NMean;
    }
    public double getU(){
        return U;
    }
    public double getWMean(){
        return WMean;
    }
    public double getX(){
        return X;
    }
    public double getRho(){
        return rho;
    }
    public double getMediaAttesa(){
        return mediaAttesa;
    }
    public double getTempoServizio(){
        return tempoServizio;
    }
    
    
    public int getTotaleArrivi(){
        return totaleArrivi;
    }
    
    public int getTotalePartenze(){
        return totalePartenze;
    }
    
}
