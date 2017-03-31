package FileHandler;

import java.io.File;
import javax.swing.JFileChooser;

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
