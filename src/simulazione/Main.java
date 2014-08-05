/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulazione;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author carlo
 */
public class Main {
        public static void main(String[] args) {
        // TODO code application logic here
         
            
        /*    
            //prova distribuzione esponenziale.
            //FUNZIONA (ricorda che il parametro è mu)
        Exponential exp=new Exponential(1/4.5);
        double somma=0.0;
        for(int i=0;i<1000;i++){
            
            //double n=r.uniform();
            double s=exp.NextValue();
            System.out.println("uniforme "+ " exp "+s);
            somma+=s;
         }
        System.out.println("media "+somma/1000);
        */
            
            //prova del frame dei parametri
            
           // da decommentare
            
        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
            
            
        FrameParametri parametri = new FrameParametri();
        parametri.setLocationRelativeTo(null); // center to screen
        parametri.setVisible(true);
          
          
        /*    
        Cassa cassa=new Cassa(TipoCassa.OPERATORE,0,0.5); 
        cassa.setNumClienti(10);
        PanelCassa frameCassa=new PanelCassa(cassa);
        
        
        JFrame frame=new JFrame();
        frame.setSize(300, 300);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        frame.add(frameCassa);
        
        frameCassa.setClienti();
        */
            
            
            
            //prova di simulazione
            
            
   /* Simulazione(double paramArrivi,int numCasseFaiDaTe,int numOperatori,
            double paramFaiDaTe,double paramOperatore,double tempoSimulazione)*/
            
      /*  Simulazione prova=new Simulazione(5,1,2,4,8,100);
        prova.start();
            
        FrameSimulazione argFrame = new FrameSimulazione();
        argFrame.setLocationRelativeTo(null); // center to screen
        argFrame.setVisible(true);
            */
            
    }
}
