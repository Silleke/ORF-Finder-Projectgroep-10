
package FileHandler;
/**
 * @author Amber Janssen Groesbeek en Danique Bodt
 * 15-03-2017
 * Deze class bevat de custom exception voor de controle van de sequentie op DNA
 */
public class NotNuclSequence extends Exception{
    /**
     * De custom exception wordt opgeroepen wanneer er geen DNA sequentie als input wordt gegeven
     * 
     */
    public NotNuclSequence() {
        super();
    }
    
    public NotNuclSequence(String err){
        super(err);
    }
}
