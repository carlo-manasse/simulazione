/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulazione;

/**
 *
 * @author carlo
 */
public class Utente {
    private int idUtente;
    private double tempoArrivo;
    private double tempoInizioServizio;
    
    Utente(int idUtente,double tempoArrivo){
        this.idUtente=idUtente;
        this.tempoArrivo=tempoArrivo;
        this.tempoInizioServizio=tempoArrivo;
    }
    
    void setTempoInizioServizio(double t){
        tempoInizioServizio=t;
    }
    
    double calcolaAttesa(){
        return tempoInizioServizio-tempoArrivo;
    }
    
    int getId(){
        return idUtente;
    }
    
}
