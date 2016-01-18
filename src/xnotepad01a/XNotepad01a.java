/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xnotepad01a;

import java.io.IOException;

/**
 *
 * @author Operator
 * 
 * made from tutorial on http://www.dreamincode.net/forums/topic/66176-creating-a-basic-notepad-application/
 */





public class XNotepad01a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        
        NotepadMain notepad = new NotepadMain("");
        //notepad.changeText("alalala");
        notepad.setVisible(true);
    }
    
}
