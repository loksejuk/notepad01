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
import javax.swing.JOptionPane;
/**
 *
 * @author Operator
 */
public class NotepadSettings {
    
    Properties props;
    //public NotepadLang lang = new NotepadLang("en");
    
    
    
    public NotepadSettings() throws IOException
        {

        try {
            FileReader reader = new FileReader("config.properties");
            props = new Properties();
            props.load(reader);
            reader.close();
            } 
        catch (FileNotFoundException ex) 
            {
            createSettings();            
            FileReader reader = new FileReader("config.properties");
            props = new Properties();
            props.load(reader);
            reader.close();
            } 
        }
    
    
    private void createSettings() throws IOException
        {
        System.out.println("file doesn't exist!");
            File file = new File("config.properties");
            if (file.createNewFile()){
	        System.out.println("File is created!");
	      }else{
	        System.out.println("File already exists.");
	      }
            
        //wypelnienie pliku domyslnymi wartosciami
            
        //message dialog
            JOptionPane.showMessageDialog(null, "No settings file found! \n Default settings file has been created.\n Please run application again.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    
    
    public int getScrolls()
        {
        String scrolls = props.getProperty("scrolls");//bez pliku properties sie wysypuje
        if(scrolls == null)//check if there's an scrolls option
            {
            return 3;
            }
        else
            {//if there is, we can switch
            switch (scrolls)
                {
                case "0":
                    return 0;
                case "1":
                    return 1;
                case "2":
                    return 2;
                case "3":
                    return 3;
                default:
                    return 3;
                }
            }
        }
    
    public void setScrolls()
        {
        
        }
    
    public String getLang()
        {
        String lang = props.getProperty("lang");
        if (lang == null || lang.isEmpty())
                {
                System.out.println("jest!");
                lang="en";
                }
        System.out.println(lang);
        return lang;
        }
}
