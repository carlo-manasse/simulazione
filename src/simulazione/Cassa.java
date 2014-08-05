/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulazione;

import java.util.Vector;

enum TipoCassa {OPERATORE,FAIDATE}
/**
 *
 * @author carlo
 */
public class Cassa {
    
    private Statistiche stats;
    
    private TipoCassa tipoCassa;
    private int numeroCassa;
    
    private int numArrivi;
    private int numPartenze;
    private int numClienti;
    
    //private double sommaTempiAttesa;
    //private double mediaTempiAttesa;
    
    private Exponential distTempoServizio;
    
    Vector<Utente> codaUtenti;
    
    Cassa(TipoCassa tipoCassa,int numeroCassa,double tempoServizio){
        
        this.numeroCassa=numeroCassa;
        this.tipoCassa=tipoCassa;
        double mu=1/tempoServizio;
        distTempoServizio=new Exponential(mu);
        numArrivi=0;
        numPartenze=0;
        numClienti=0;
//        sommaTempiAttesa=0;
//        mediaTempiAttesa=0;
        
        codaUtenti=new Vector<Utente>();
        
        stats=new Statistiche();
        
    }
    
    void arrivo(double tempoArrivo,int idUtente){
        
        stats.AccumulaStatistiche(numArrivi, numClienti, numPartenze, tempoArrivo);
        numArrivi++;
        numClienti++;
        Utente utente=new Utente(idUtente,tempoArrivo);
        codaUtenti.add(utente);
        //System.out.println("utente "+utente.getId()+" in arrivo in cassa "+ this.tipoCassa+" "+this.numeroCassa);
    }
    
    void partenza(double tempoPartenza){
        stats.AccumulaStatistiche(numArrivi, numClienti, numPartenze, tempoPartenza);
        numPartenze++;
        numClienti--;
        Utente utente=codaUtenti.firstElement();
//        sommaTempiAttesa+=utente.calcolaAttesa();
        //System.out.println("utente "+utente.getId()+" uscito dal sistema. In attesa per "+ utente.calcolaAttesa());
        codaUtenti.removeElement(utente);
        if(!codaUtenti.isEmpty()){
            Utente utenteNuovo=codaUtenti.firstElement();
            utenteNuovo.setTempoInizioServizio(tempoPartenza);
        }
    }
    
    
    Statistiche endSim(){
//        calcolaTempoAttesa();
        stats.Report();
        return stats;
    } 
    
    TipoCassa getTipoCassa(){
        return tipoCassa;
    }
            
    int getNumeroCassa(){
        return numeroCassa;
    }
    
    int getNumArrivi(){
        return numArrivi;
    }
    
    int getNumPartenze(){
        return numPartenze;
    }
    
    int getNumClienti(){
        return numClienti;
    }
    
    
    //da cancellare
    void setNumClienti(int clienti){
        this.numClienti=clienti;
    }
    
    
    double getTempoServizio(){
        return distTempoServizio.NextValue();
    }
    
    int idUtenteServito(){
        return codaUtenti.firstElement().getId();
    }
    
//    private void calcolaTempoAttesa(){
//        mediaTempiAttesa=sommaTempiAttesa/numPartenze;
//    }
    
//    double getMediaTempoAttesa(){ 
        //calcolaTempoAttesa();
        /*
        double somma
        for (int i=0;i<codaUtenti.size();i++){
        
        }*/
//        return mediaTempiAttesa;
//    }
        
    Statistiche getStats(){
        return stats;
    }
}
