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
    int ORFstart;
    int ORFend;
    int ORFreadingframe;
    String ORFsequence;
    
    // Arrays voor statistieken template strand
    ArrayList<Integer> ArrORFstart_temp = new ArrayList<>();
    ArrayList<Integer> ArrORFend_temp = new ArrayList<>();
    ArrayList<Integer> ArrORFrf_temp = new ArrayList<>();
    ArrayList<String> ArrORF_temp = new ArrayList<>();
    
    // Arrays voor statistieken complement strand
    ArrayList<Integer> ArrORFstart_comp = new ArrayList<>();
    ArrayList<Integer> ArrORFend_comp = new ArrayList<>();
    ArrayList<Integer> ArrORFrf_comp = new ArrayList<>();
    ArrayList<String> ArrORF_comp = new ArrayList<>();

    /**
     * De regular expression voor het vinden van het ORF wordt hier bepaald en kijken of het matcht met de 
     * complement en template strand. De methodes setStatisticsTemplate en setStatisticsComplement worden 
     * hier aangeroepen. 
     */
    public void setORF(String ORF_length_input){
        int ORF_length = Integer.parseInt(ORF_length_input);
        
        FileReader reader = new FileReader();
        String tempStr = reader.getTemplateStrand();
        String compStr = reader.getComplementStrand();
       
        // Deze regex zoekt al per drie nucleotiden. 
        Pattern ORF_pattern = Pattern.compile("ATG([ATGC]{3})+?(TAA|TAG|TGA)");
        Matcher ORF_TemplateStr = ORF_pattern.matcher(tempStr);
        Matcher ORF_ComplementStr = ORF_pattern.matcher(compStr);
        
        // statistieken voor de template strand
        setStatisticsTemplate(tempStr, ORF_TemplateStr, ORF_length);
        
        // statistieken voor de complement strand
        setStatisticsComplement(compStr, ORF_ComplementStr, ORF_length);
    }

    /**
     * Doormiddel van de template strand en de matcher kunnen er meerdere ORFs gevonden worden in de template strand.
     * Wanneer er een ORF gevonden wordt, worden de gegeven van het ORF opgeslagen in een verschillende arraylist waardoor
     * de arraylist opgehaald kunnen worden in een andere class en de statistieken in de GUI weergeven kunnen worden.
     * 
     * @param tempStr           De template strand
     * @param ORF_TemplateStr   
     */
    public void setStatisticsTemplate(String tempStr, Matcher ORF_TemplateStr, int ORF_length){            
        // Vinden van de waardes in de template strand
        while(ORF_TemplateStr.find()){
            // De sequentie van het ORF
            ORFsequence = ORF_TemplateStr.group();

            // Positie van het start codon in de sequentie
            ORFstart = ORF_TemplateStr.start();

            // De positie van het eerste stopcodon is de lengte van het ORF plus de positie van het startcodon.
            ORFend = ORF_TemplateStr.end();

            // Hierbij is er rekening gehouden met de index 0. 
            if(ORFstart%3 == 0){
                ORFreadingframe = 1;
            }else if(ORFstart%3 == 1){
                ORFreadingframe = 2;
            }else{
                ORFreadingframe = 3;
            }       
            
            // Als de lengte groter is dan de ingevoerde lengte van de gebruiker, dan worden de statistieken toegevoegd aan de arraylists.
            if(ORFsequence.length() > ORF_length){
                ArrORF_temp.add(ORFsequence);     
                ArrORFstart_temp.add(ORFstart);
                ArrORFend_temp.add(ORFend);
                ArrORFrf_temp.add(ORFreadingframe);
            }
        }
    }
    
    /**
     * Doormiddel van de complement strand en de matcher kunnen er meerdere ORFs gevonden worden in de complement strand.
     * Wanneer er een ORF gevonden wordt, worden de gegeven van het ORF opgeslagen in een verschillende arraylist waardoor 
     * de arraylist opgehaald kunnen worden in een andere class en de statistieken in de GUI weergeven kunnen worden.
     * 
     * @param compStr               complement strand
     * @param ORF_ComplementStr
     */

    public void setStatisticsComplement(String compStr, Matcher ORF_ComplementStr, int ORF_length){
        
        while(ORF_ComplementStr.find()){
            // De ORF sequentie ophalen en toevoegen aan de arraylist
            ORFsequence = ORF_ComplementStr.group();
            
            // Positie van het start codon in de sequentie ophalen en aan de arraylist toevoegen
            ORFstart = ORF_ComplementStr.start();
  
            // De positie van het eerste stopcodon is de lengte van het ORF plus de positie van het startcodon.
            ORFend = ORF_ComplementStr.end();
            
            // Hierbij is er rekening gehouden met de index 0, reading frame toevoegen aan arraylist
            if(ORFstart%3 == 0){
                ORFreadingframe = 1;
            }else if(ORFstart%3 == 1){
                ORFreadingframe = 2;
            }else{
                ORFreadingframe = 3;
            }
            
            // Als de lengte groter is dan de ingevoerde lengte van de gebruiker, dan worden de statistieken toegevoegd aan de arraylists.
            if(ORFsequence.length() > ORF_length){
                ArrORF_comp.add(ORFsequence);
                ArrORFstart_comp.add(ORFstart);
                ArrORFend_comp.add(ORFend);
                ArrORFrf_comp.add(ORFreadingframe);
            }
        }
    }

    /**
     *
     * @return ArrORFstart_temp     ArrayList met voor elk ORF in de template strand de positie van het start codon
     */

    public ArrayList<Integer> getORFstartTemp(){
        return ArrORFstart_temp;
    }
    
    /**
     *
     * @return ArrORFend_temp       ArrayList met voor elk ORF in de template strand de positie van het stop codon
     */
    public ArrayList<Integer> getORFendTemp(){
        return ArrORFend_temp;
    }
    
    /**
     *
     * @return ArrORFrf_temp        ArrayList met voor elk ORF in de template strand het reading frame van het ORF
     */
    public ArrayList<Integer> getORFrfTemp(){
        return ArrORFrf_temp;
    }
    
    /**
     *
     * @return ArrORF_temp          ArrayList met alle sequenties van de ORFs in de template strand.
     */
    public ArrayList<String> getORFsequenceTemp(){
        return ArrORF_temp;
    }

    /**
     *
     * @return ArrORFstart_comp     ArrayList met voor elk ORF in de complement strand de positie van het start codon
     */
    public ArrayList<Integer> getORFstartComp(){
        return ArrORFstart_comp;
    }
    
    /**
     *
     * @return ArrORFend_comp       ArrayList met voor elk ORF in de complement strand de positie van het stop codon
     */
    public ArrayList<Integer> getORFendComp(){
        return ArrORFend_comp;
    }
    
    /**
     *
     * @return  ArrORFrf_comp       ArrayList met voor elk ORF in de complement strand het reading frame van het ORF
     */
    public ArrayList<Integer> getORFrfComp(){
        return ArrORFrf_comp;
    }
    
    /**
     *
     * @return ArrORF_comp          ArrayList met alle sequenties van de ORFs in de complement strand.
     */
    public ArrayList<String> getORFsequenceComp(){
        return ArrORF_comp;
    }    
    
}
