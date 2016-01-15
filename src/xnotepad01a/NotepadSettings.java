/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xnotepad01a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
/**
 *
 * @author Operator
 */
public class NotepadSettings {
    
    Properties props;
    
    
    public NotepadSettings()
        {
        load();
        }//konstruktor
    
    public void load()
        {
        File configFile = new File("config.properties");

        try {
            FileReader reader = new FileReader(configFile);
            props = new Properties();
            props.load(reader);

            String host = props.getProperty("host");

            System.out.print("Host name is: " + host);
            reader.close();
            } 
        catch (FileNotFoundException ex) 
            {
            System.out.println("leci");
            // file does not exist
            } 
        catch (IOException ex) 
            {
            // I/O error
            }
        }
    
    
}
