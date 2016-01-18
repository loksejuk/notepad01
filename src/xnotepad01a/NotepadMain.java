/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xnotepad01a;

/**
 *
 * @author Operator
 */

//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import javax.swing.*; // for the main JFrame design
import java.awt.*; // for the GUI stuff
import java.awt.event.*; // for the event handling
import java.util.Scanner; // for reading from a file
import java.io.*; // for writing to a file
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;




public class NotepadMain extends JFrame implements ActionListener {
    
    
    Properties properties;
    
    private String text01 = "";
    private TextArea textArea;
    
    private TextArea textarea2 = new TextArea(); //nigdzie nie uzyte
    
    private MenuBar menuBar = new MenuBar(); // first, create a MenuBar item
    private Menu file = new Menu(); // our File menu
    private Menu settings = new Menu();
    
    // what's going in File? let's see...
    private MenuItem openFile = new MenuItem();  // an open option
    private MenuItem saveFile = new MenuItem(); // a save option
    private MenuItem close = new MenuItem(); // and a close option!
    private NotepadSettings notepad_s;
    
    public NotepadLang lang;
    
    
    
    public NotepadMain(String text01) throws IOException
        {
            
        try {
            
            notepad_s = new NotepadSettings();
        } catch (IOException ex) {
            Logger.getLogger(NotepadMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        switch (notepad_s.getScrolls())
                {
                case 0:
                    textArea = new TextArea(text01, 0,0, TextArea.SCROLLBARS_NONE);
                    break;
                case 1:
                    textArea = new TextArea(text01, 0,0, TextArea.SCROLLBARS_VERTICAL_ONLY);
                    break; 
                case 2:
                    textArea = new TextArea(text01, 0,0, TextArea.SCROLLBARS_HORIZONTAL_ONLY);
                    break;
                case 3:
                    textArea = new TextArea(text01, 0,0, TextArea.SCROLLBARS_BOTH);
                    break;
                default:
                    textArea = new TextArea(text01, 0,0, TextArea.SCROLLBARS_BOTH);
                    break;
                }
        
        
        lang = new NotepadLang(notepad_s.getLang());
        
        
        
        this.setSize(500, 300); // set the initial size of the window
        this.setTitle(lang.getProperty("w1s0")); // set the title of the window
        setDefaultCloseOperation(EXIT_ON_CLOSE); // set the default close operation (exit when it gets closed)
        this.textArea.setFont(new Font("Century Gothic", Font.BOLD, 12)); // set a default font for the TextArea
        // this is why we didn't have to worry about the size of the TextArea!
        this.getContentPane().setLayout(new BorderLayout()); // the BorderLayout bit makes it fill it automatically
        this.getContentPane().add(textArea);
        // add our menu bar into the GUI
        this.setMenuBar(this.menuBar);
        this.menuBar.add(this.file); // we'll configure this later
        // first off, the design of the menuBar itself. Pretty simple, all we need to do
        // is add a couple of menus, which will be populated later on
        this.file.setLabel(lang.getProperty("w1s1"));
        // now it's time to work with the menu. I'm only going to add a basic File menu
        // but you could add more!
        // now we can start working on the content of the menu~ this gets a little repetitive,
        // so please bare with me!


        // time for the repetitive stuff. let's add the "Open" option
        this.openFile.setLabel(lang.getProperty("w1s2")); // set the label of the menu item
        this.openFile.addActionListener(this); // add an action listener (so we know when it's been clicked
        this.openFile.setShortcut(new MenuShortcut(KeyEvent.VK_O, false)); // set a keyboard shortcut
        this.file.add(this.openFile); // add it to the "File" menu

        // and the save...
        this.saveFile.setLabel(lang.getProperty("w1s3"));
        this.saveFile.addActionListener(this);
        this.saveFile.setShortcut(new MenuShortcut(KeyEvent.VK_S, false));
        this.file.add(this.saveFile);

        // and finally, the close option
        this.close.setLabel(lang.getProperty("w1s4"));
        // along with our "CTRL+F4" shortcut to close the window, we also have
        // the default closer, as stated at the beginning of this tutorial.
        // this means that we actually have TWO shortcuts to close:
        // 1) the default close operation (example, Alt+F4 on Windows)
        // 2) CTRL+F4, which we are about to define now: (this one will appear in the label)
        this.close.setShortcut(new MenuShortcut(KeyEvent.VK_F4, false));
        this.close.addActionListener(this);
        this.file.add(this.close);
        
        this.settings.setLabel(lang.getProperty("w1s5"));
        this.menuBar.add(this.settings);
        
        
        //this.setVisible(true);      
        }
    /*
    
    public NotepadMain() 
        {
        //makewindow("", 0);
        }//constructor
    
    public NotepadMain(String text02) 
        {
        //makewindow(text02, 0);
        }//constructor
    */
    
    @Override
    public void actionPerformed (ActionEvent e) 
        {
        // if the source of the event was our "close" option
        if (e.getSource() == this.close)
            this.dispose(); // dispose all resources and close the application

        // if the source was the "open" option
        else if (e.getSource() == this.openFile) {
            JFileChooser open = new JFileChooser(); // open up a file chooser (a dialog for the user to browse files to open)
            int option = open.showOpenDialog(this); // get the option that the user selected (approve or cancel)
            // NOTE: because we are OPENing a file, we call showOpenDialog
            // if the user clicked OK, we have "APPROVE_OPTION"
            // so we want to open the file
            if (option == JFileChooser.APPROVE_OPTION) {
                this.textArea.setText(""); // clear the TextArea before applying the file contents
                try {
                    // create a scanner to read the file (getSelectedFile().getPath() will get the path to the file)
                    Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
                    while (scan.hasNext()) // while there's still something to read
                        this.textArea.append(scan.nextLine() + "\n"); // append the line to the TextArea
                } catch (Exception ex) { // catch any exceptions, and...
                    // ...write to the debug console
                    System.out.println(ex.getMessage());
                }
            }
        }

        // and lastly, if the source of the event was the "save" option
        else if (e.getSource() == this.saveFile) {
            JFileChooser save = new JFileChooser(); // again, open a file chooser
            int option = save.showSaveDialog(this); // similar to the open file, only this time we call
            // showSaveDialog instead of showOpenDialog
            // if the user clicked OK (and not cancel)
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    // create a buffered writer to write to a file
                    BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
                    out.write(this.textArea.getText()); // write the contents of the TextArea to the file
                    out.close(); // close the file stream
                } catch (Exception ex) { // again, catch any exceptions and...
                    // ...write to the debug console
                    System.out.println(ex.getMessage());
                }
            }
        }

        }//actperf

    
    }
