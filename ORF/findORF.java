package ORF;

import FileHandler.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author amberjanssengroesbeek
 */
public class findORF { 
    int orfStart;
    int orfEnd;
    int orfReadingFrame;
    String orfSequence;
    
    // Arrays voor statistieken template strand
    static ArrayList<Integer> arrORFstart_temp = new ArrayList<>();
    static ArrayList<Integer> arrORFend_temp = new ArrayList<>();
    static ArrayList<Integer> arrORFrf_temp = new ArrayList<>();
    static ArrayList<String> arrORF_temp = new ArrayList<>();
    
    // Arrays voor statistieken complement strand
    static ArrayList<Integer> arrORFstart_comp = new ArrayList<>();
    static ArrayList<Integer> arrORFend_comp = new ArrayList<>();
    static ArrayList<Integer> arrORFrf_comp = new ArrayList<>();
    static ArrayList<String> arrORF_comp = new ArrayList<>();

    /**
     * De regular expression voor het vinden van het ORF wordt hier bepaald en kijken of het matcht met de 
     * complement en template strand. De methodes setStatisticsTemplate en setStatisticsComplement worden 
     * hier aangeroepen. 
     */
    public void setORF(String ORF_length_input){
        int orfLength = Integer.parseInt(ORF_length_input);
        
        FileReader reader = new FileReader();
        String tempStr = reader.getTemplateStrand();
        String compStr = reader.getComplementStrand();
       
        // Deze regex zoekt al per drie nucleotiden. 
        Pattern orfPattern = Pattern.compile("ATG([ATGC]{3})+?(TAA|TAG|TGA)");
        Matcher orfTemplateStr = orfPattern.matcher(tempStr);
        Matcher orfComplementStr = orfPattern.matcher(compStr);
        
        // statistieken voor de template strand
        setStatisticsTemplate(tempStr, orfTemplateStr, orfLength);
        
        // statistieken voor de complement strand
        setStatisticsComplement(compStr, orfComplementStr, orfLength);
    }

    /**
     * Doormiddel van de template strand en de matcher kunnen er meerdere ORFs gevonden worden in de template strand.
     * Wanneer er een ORF gevonden wordt, worden de gegeven van het ORF opgeslagen in een verschillende arraylist waardoor
     * de arraylist opgehaald kunnen worden in een andere class en de statistieken in de GUI weergeven kunnen worden.
     * 
     * @param tempStr           De template strand
     * @param orfTemplateStr   
     */
    public void setStatisticsTemplate(String tempStr, Matcher orfTemplateStr, int orfLength){            
        // Vinden van de waardes in de template strand
        while(orfTemplateStr.find()){
            // De sequentie van het ORF
            orfSequence = orfTemplateStr.group();

            // Positie van het start codon in de sequentie
            orfStart = orfTemplateStr.start();

            // De positie van het eerste stopcodon is de lengte van het ORF plus de positie van het startcodon.
            orfEnd = orfTemplateStr.end();

            // Hierbij is er rekening gehouden met de index 0. 
            if(orfStart%3 == 0){
                orfReadingFrame = 1;
            }else if(orfStart%3 == 1){
                orfReadingFrame = 2;
            }else{
                orfReadingFrame = 3;
            }       
            
            // Als de lengte groter is dan de ingevoerde lengte van de gebruiker, dan worden de statistieken toegevoegd aan de arraylists.
            if(orfSequence.length() > orfLength){
                arrORF_temp.add(orfSequence);     
                arrORFstart_temp.add(orfStart);
                arrORFend_temp.add(orfEnd);
                arrORFrf_temp.add(orfReadingFrame);
            }
        }
    }
    
    /**
     * Doormiddel van de complement strand en de matcher kunnen er meerdere ORFs gevonden worden in de complement strand.
     * Wanneer er een ORF gevonden wordt, worden de gegeven van het ORF opgeslagen in een verschillende arraylist waardoor 
     * de arraylist opgehaald kunnen worden in een andere class en de statistieken in de GUI weergeven kunnen worden.
     * 
     * @param compStr               complement strand
     * @param orfComplementStr
     */

    public void setStatisticsComplement(String compStr, Matcher orfComplementStr, int orfLength){
        
        while(orfComplementStr.find()){
            // De ORF sequentie ophalen en toevoegen aan de arraylist
            orfSequence = orfComplementStr.group();
            
            // Positie van het start codon in de sequentie ophalen en aan de arraylist toevoegen
            orfStart = orfComplementStr.start();
  
            // De positie van het eerste stopcodon is de lengte van het ORF plus de positie van het startcodon.
            orfEnd = orfComplementStr.end();
            
            // Hierbij is er rekening gehouden met de index 0, reading frame toevoegen aan arraylist
            if(orfStart%3 == 0){
                orfReadingFrame = 1;
            }else if(orfStart%3 == 1){
                orfReadingFrame = 2;
            }else{
                orfReadingFrame = 3;
            }
            
            // Als de lengte groter is dan de ingevoerde lengte van de gebruiker, dan worden de statistieken toegevoegd aan de arraylists.
            if(orfSequence.length() > orfLength){
                arrORF_comp.add(orfSequence);
                arrORFstart_comp.add(orfStart);
                arrORFend_comp.add(orfEnd);
                arrORFrf_comp.add(orfReadingFrame);
            }
        }
    }

    /**
     *
     * @return ArrORFstart_temp     ArrayList met voor elk ORF in de template strand de positie van het start codon
     */

    public ArrayList<Integer> getORFstartTemp(){
        return arrORFstart_temp;
    }
    
    /**
     *
     * @return ArrORFend_temp       ArrayList met voor elk ORF in de template strand de positie van het stop codon
     */
    public ArrayList<Integer> getORFendTemp(){
        return arrORFend_temp;
    }
    
    /**
     *
     * @return ArrORFrf_temp        ArrayList met voor elk ORF in de template strand het reading frame van het ORF
     */
    public ArrayList<Integer> getORFrfTemp(){
        return arrORFrf_temp;
    }
    
    /**
     *
     * @return ArrORF_temp          ArrayList met alle sequenties van de ORFs in de template strand.
     */
    public ArrayList<String> getORFsequenceTemp(){
        return arrORF_temp;
    }

    /**
     *
     * @return ArrORFstart_comp     ArrayList met voor elk ORF in de complement strand de positie van het start codon
     */
    public ArrayList<Integer> getORFstartComp(){
        return arrORFstart_comp;
    }
    
    /**
     *
     * @return ArrORFend_comp       ArrayList met voor elk ORF in de complement strand de positie van het stop codon
     */
    public ArrayList<Integer> getORFendComp(){
        return arrORFend_comp;
    }
    
    /**
     *
     * @return  ArrORFrf_comp       ArrayList met voor elk ORF in de complement strand het reading frame van het ORF
     */
    public ArrayList<Integer> getORFrfComp(){
        return arrORFrf_comp;
    }
    
    /**
     *
     * @return ArrORF_comp          ArrayList met alle sequenties van de ORFs in de complement strand.
     */
    public ArrayList<String> getORFsequenceComp(){
        return arrORF_comp;
    }    
    
}
