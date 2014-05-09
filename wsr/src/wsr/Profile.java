package wsr;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
 

public class Profile {
	static Table db_tb;  
	//static AddressBook book;
	
public Profile() throws ClassNotFoundException{
	  db_tb = new Table();
 	
}
	
	
	
	/*
	 *  Profile
	 */
	public JPanel profile() throws ClassNotFoundException{
    JPanel pane = db_tb.userProfile();		  
    return pane;
	}

	/*
	 *  returns the table as an JScrollPane
	 */
	public JScrollPane scrolltable() throws ClassNotFoundException{
	    JScrollPane tableScroll =  db_tb.db_table();  
		return tableScroll;
	}	
/*
 * Split Panel for Table and Profile Panels
 */
public JSplitPane mainLayout() throws ClassNotFoundException{
    JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrolltable(), new JScrollPane(profile()));   
    return splitPane;
}
	


/*
 * MAIN FOR TESTING ONLY
 */
    public static void main(String[] args) throws ClassNotFoundException {
    	final Profile ALL = new Profile();

        Runnable r = new Runnable() {
    	
            public void run() {
                final JFrame frame = new JFrame("West Slope Recovery");
                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 
                final JPanel gui = new JPanel(new BorderLayout(5,5));
               gui.setBorder( new TitledBorder("BorderLayout(5,5)") );

                
                JSplitPane middle_Bar = null;
                
				try {
					middle_Bar = ALL.mainLayout();								
				} catch (ClassNotFoundException e) {				 
					e.printStackTrace();
				}
				
				
				
                
    
                
            	    //Adding Search field to the toolBar
				gui.add(db_tb.searchField(), BorderLayout.NORTH); //its added to the top		 
                /*
                 * Adding JPanels to JFrame	
                 */
 
                gui.add( middle_Bar, BorderLayout.CENTER );//split table & picture
            

                /*
                 * JFrame Properties
                 */
                frame.setContentPane(gui);
                frame.pack();
                frame.setLocationRelativeTo(null);               
                try {
                    frame.setLocationByPlatform(true);                   
                    // This makes the GUI the size of the screen 
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    frame.setBounds(0,0,screenSize.width, screenSize.height);                   
                } catch(Throwable ignoreAndContinue) {
                }
               
                frame.setVisible(true);
            }
        };
        
        
        
        SwingUtilities.invokeLater(r);
    }



}
