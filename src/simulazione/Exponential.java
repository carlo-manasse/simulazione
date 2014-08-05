/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulazione;

/**
 *
 * @author carlo
 */
public class Exponential {
    
    private RandomStream rand;
    private double lambda;
    
    Exponential(double lambda){
        rand=new RandomStream();
        this.lambda=lambda;
    }
   
    double NextValue(){
        return -Math.log(1 - rand.uniform()) / lambda;
    }
}
