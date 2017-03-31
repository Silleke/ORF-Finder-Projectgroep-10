
package FileHandler;

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
