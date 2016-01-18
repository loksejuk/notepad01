/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package xnotepad01a;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author $ Łukasz Oksejuk
 */
public class NotepadLang{
    Properties texts;
    
    
    
    public NotepadLang(String version) throws IOException
        {
            
          
            /*
        if(version.equals("en"))    
            {
            try 
                {
                FileReader reader = null;
                reader = new FileReader("lang/texts.lang");
                texts = new Properties();
                texts.load(reader);
                reader.close();
                } 
            catch (FileNotFoundException ex) 
                {
                System.out.println("file not found");
                //stworzyc plik z tekstami angielskimi
                } 
            catch (IOException ex) 
                {
                Logger.getLogger(NotepadLang.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("file not loaded");
                }
            }
            */
        switch (version)
            {
            case "en":
            {
            try 
                {
                FileReader reader = null;
                reader = new FileReader("lang/texts.lang");
                texts = new Properties();
                texts.load(reader);
                reader.close();
                } 
            catch (FileNotFoundException ex) 
                {
                System.out.println("file not found");
                //stworzyc plik z tekstami angielskimi
                } 
            catch (IOException ex) 
                {
                Logger.getLogger(NotepadLang.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("file not loaded");
                }
            }
            case "pl":
            {
            try 
                {
                FileReader reader = null;
                reader = new FileReader("lang/pl_texts.lang");
                texts = new Properties();
                texts.load(reader);
                reader.close();
                } 
            catch (FileNotFoundException ex) 
                {
                System.out.println("file not found");
                } 
            catch (IOException ex) 
                {
                Logger.getLogger(NotepadLang.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("file not loaded");
                }
            }    
            /*default:
                {
            try 
                {
                FileReader reader = null;
                reader = new FileReader("lang/texts2.lang");
                texts = new Properties();
                texts.load(reader);
                reader.close();
                } 
            catch (FileNotFoundException ex) 
                {
                System.out.println("file not found");
                } 
            catch (IOException ex) 
                {
                Logger.getLogger(NotepadLang.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("file not loaded");
                }
            }      */ 
            }
                
            
        
        
        
        
        }
    
    String getProperty(String prop)
        {
        return texts.getProperty(prop);
        }

}