/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulazione;

import java.util.NoSuchElementException;
import java.util.Vector;
/**
 *
 * @author carlo
 */
public class EventList {
    Vector<Event> eventList;
    
    EventList(){
        eventList=new Vector<Event>();
    }
    
    public void sched(Event evento){
        int i;
        
        for(i=0; i<eventList.size() && ( (Event) eventList.get(i)).getSchedTime() <= evento.getSchedTime(); i++)
        {}
        
        eventList.insertElementAt(evento, i);
    }
    
    public Event getEvento(){
        Event evento;
        try{
            evento = (Event) eventList.firstElement();
            eventList.removeElementAt(0);
        }
        catch(NoSuchElementException exc){
            evento=null;
        }
        return evento;
    }
    
    public int size(){
        return eventList.size();
    }
    
}
