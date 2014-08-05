/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulazione;

enum TipoEvento {ARRIVAL, DEPARTURE, SIM_END};
/**
 *
 * @author carlo
 */
public class Event {
    private TipoEvento tipo;
    private double sched_time;
    private Cassa cassaSelezionata;
    
    Event(double sched_time){
        this.tipo=TipoEvento.SIM_END;
        this.sched_time=sched_time;
    }
    
    Event(TipoEvento tipo,double sched_time,Cassa cassaSelezionata){
        this.tipo=tipo;
        this.sched_time=sched_time;
        this.cassaSelezionata=cassaSelezionata;
    }
    
    TipoEvento getTipo(){
        return tipo;
    }

    double getSchedTime(){
        return sched_time;
    }
    
    Cassa getCassa(){
        return cassaSelezionata;
    }
}
