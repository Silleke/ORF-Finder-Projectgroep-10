package FileHandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author amberjanssengroesbeek
 */
public class FileReader {
    private static BufferedReader inFile;
    String header;
    static String tempStr = "";
    static String compStr = "";

    /**
     * Het bestand wordt ingelezen, de header wordt opgeslagen en de andere regels worden naar de methode
     * ControlSequence gestuurd. 
     * 
     * @param pathTextField     Het pad dat wordt opgehaald uit het textfield
     * @throws NotNuclSequence  Wanneer de sequentie bestaat uit iets anders dan ATGC of N dan werpt het deze exception op
     */
    public void Read(String pathTextField) throws NotNuclSequence{
       String line;
       
        try {
            inFile = new BufferedReader(new java.io.FileReader(pathTextField));
            
            while ((line = inFile.readLine()) != null) {
                // header begint altijd met > in een fasta bestand. 
                if(line.startsWith(">")){
                    header = line;
                }else{
                    // als de regel niet met > begint, dan is het een DNA sequentie die gecontroleerd wordt
                    ControlSequence(line);
                }
            }
        }
         catch (FileNotFoundException ex) {
            System.out.println("Bestand niet gevonden!");
        } catch (IOException ioe) {
            System.out.println("Fout met lezen van een regel!");
        }
    }

    /**
     * Controleren of de DNA sequentie uit ATGC of N bestaat. 
     * 
     * @param line              een regel uit het bestand (niet de header)
     * @throws NotNuclSequence  Als de regel niet bestaat uit alleen ATGC of N dan werpt het deze exception op
     */
    public void ControlSequence(String line) throws NotNuclSequence{
        // Als er iets ander in de sequentie zit dan ATGC of N, dan werpt het programma een exception op
        if(!line.matches("[ATGCN]*")){
            throw new NotNuclSequence("Dit is een niet bestaand nucleotide sequentie.");
        
        // Bestaat de regel wel alleen uit ATGC of N dan wordt het toegevoegd aan de sequentie zodat je één string krijgt. 
        }else{
            tempStr += line;
        }
    }

    /**
     * Het genereren van de complementaire streng.
     */
    public void setComplementStrand(){
        for (int nucl = 0; nucl < tempStr.length(); nucl++) {
            if(tempStr.charAt(nucl) == 'A'){
                compStr = compStr + "T";
            }if(tempStr.charAt(nucl) == 'T'){
                compStr = compStr + "A";
            }if(tempStr.charAt(nucl) == 'G'){
                compStr = compStr + "C";
            }if(tempStr.charAt(nucl) == 'C'){
                compStr = compStr + "G";
            }
        }
        
        // Zodat de complementaire ook van '5 naar '3 wordt gelezen, dus de string wordt omgedraaid.
        compStr = new StringBuilder(compStr.toUpperCase()).reverse().toString();
    }
    
    /**
     *
     * @return tempStr      String met de gehele template sequentie.
     */
    public String getTemplateStrand(){
        return tempStr;
    }

    /**
     *
     * @return compStr     Een string met de gehele complement strand.
     */
    public String getComplementStrand(){
        return compStr;
    }
}
