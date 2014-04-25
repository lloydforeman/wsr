package wsr;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import org.jpedal.examples.viewer.Commands;
import org.jpedal.examples.viewer.Viewer;

public class Viewer1 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
         //Create display frame
    JFrame frame = new JFrame();
    frame.getContentPane().setLayout(new BorderLayout());
    
    /**
     * possible options to add
     */
    
    //All the main components most commonly used work, and others work to.
    ////////////////////////////////////////////////////////
    JInternalFrame rootContainer = new JInternalFrame("INTERNAL FRAME 1");
//    JPanel rootContainer = new JPanel();  
//    JTabbedPane rootContainer = new JTabbedPane();
//    JScrollPane rootContainer = new JScrollPane();
//    JLayeredPane rootContainer = new JLayeredPane();
//    JRootPane rootContainer = new JRootPane(); //not recommended for general usage
//    JSplitPane rootContainer = new JSplitPane();
    ////////////////////////////////////////////////////////
    
    
    //Additional Label to show this is another program
    JLabel label = new JLabel("This is a very simple program.");
    label.setFont(new Font("Lucida", Font.BOLD, 20));
    label.setForeground(Color.RED);
    frame.add(label, BorderLayout.NORTH);
    
    
    
    //The only two lines required to setup viewer for your software
    ////////////////////////////////////////////////////////
    Viewer viewer = new Viewer(rootContainer, null);
    viewer.setupViewer();
    ////////////////////////////////////////////////////////
    //You can remove our GUI by using the options within viewer in the menu View->Preferences->Menu

    //Add the viewer to your application
    frame.add(rootContainer, BorderLayout.CENTER);
    
    
    //Require for internalFrame to be displayed
    rootContainer.setVisible(true);
    
    //Set up JFrame
    frame.setTitle("Viewer in External Viewer");
    frame.setSize(800, 600);
    frame.addWindowListener(new WindowListener(){
      @Override
            public void windowActivated(WindowEvent e) {}
      @Override
            public void windowClosed(WindowEvent e) {}
      @Override
            public void windowClosing(WindowEvent e) {System.exit(1);}
      @Override
            public void windowDeactivated(WindowEvent e) {}
      @Override
            public void windowDeiconified(WindowEvent e) {}
      @Override
            public void windowIconified(WindowEvent e) {}
      @Override
            public void windowOpened(WindowEvent e) {}
    });
    
    //Display Frame
    frame.setVisible(true);
    
    
	Object[] myPDFinput;

	//Specify file you wish to open (JPedal handles getting the byte data)
	myPDFinput = new Object[]{"/Users/lloydforeman/Downloads/WSR Feb 24 Updates/WSR Client File 2014/pdfs/panel 1/1-Screening & Client Information.pdf"};
	viewer.executeCommand(Commands.OPENFILE, myPDFinput);
	}

}
