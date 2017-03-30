package FileHandler;

import java.io.File;
import javax.swing.JFileChooser;

public class FileChooser extends javax.swing.JFrame{
    JFileChooser fileChooser;
    File selectedFile;
    
    public void ChooseFile(){
        fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(this);
        
        selectedFile = fileChooser.getSelectedFile();
    }
    
    public String getPath(){
        return selectedFile.getAbsolutePath();
    }
}
