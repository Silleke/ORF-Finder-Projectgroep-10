package FileHandler;

import java.io.File;
import javax.swing.JFileChooser;
/**
 * @author Amber Janssen Groesbeek en Danique Bodt
 * 15-03-2017
 * In deze class kan een file gekozen worden door middel van een pop up.
 */
public class FileChooser extends javax.swing.JFrame{
    JFileChooser fileChooser;
    File selectedFile;
    
    /**
    In deze methode wordt het mogelijk dat er doormiddel van een popup een bestand
    geselecteerd kan worden.
    */
    public void ChooseFile(){
        fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(this);
        
        selectedFile = fileChooser.getSelectedFile();
    }
    
    /**
     * 
     * @return selectedFile.getAbsolutePath()   Hierbij kan het path dat in het textfield staat opgehaald worden.
     */
    public String getPath(){
        return selectedFile.getAbsolutePath();
    }
}
