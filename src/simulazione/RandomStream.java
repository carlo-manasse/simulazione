/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulazione;

import java.util.Random;

/**
 *
 * @author carlo
 */
public class RandomStream {

    private long seed;
    private Random rand;
    private int numCall=0;
    
    RandomStream(){
        seed = System.currentTimeMillis()*(long)Math.random()*Thread.currentThread().getId();
        rand=new Random(seed);
    }
        
    public double uniform() {
        //numCall++;
        //if(numCall%10==0){
        //    seed = System.currentTimeMillis()*(long)Math.random();
        //    rand=new Random(seed);
        //}
        return rand.nextDouble();
    }
    
    
}
