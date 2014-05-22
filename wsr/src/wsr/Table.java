package wsr;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.PatternSyntaxException;

import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import javax.swing.*;



public class Table extends JFrame implements ActionListener
{

  // public static String table = "db_clients";

  public static FileSystem FS;
  public Statement statement;
  public DB_Link link;  
  Container contentPane;
  Client client;

  //For Table
  String col[] = {"ID","Last Name","Fisrt Name","Gender"};	 	  
  DefaultTableModel model;	 
  JTextField[] fields;
  public JTable table;		  			  	
  final TableRowSorter<TableModel> sorter;	  
  String selectedData;     


  //For  Profile
  private JTextField nameTextField, addressTextField, cityTextField,
          stateTextField, zipTextField, phoneTextField, emailTextField,
          nameTextField1, addressTextField1, cityTextField1,
          stateTextField1, zipTextField1, phoneTextField1, emailTextField1,testfield;

  private JLabel nameLabel, addressLabel, cityLabel, stateLabel, zipLabel,
          phoneLabel, emailLabel, nameLabel1, addressLabel1, cityLabel1,
          stateLabel1, zipLabel1, phoneLabel1, emailLabel1, testlabel;

  JButton enterButton;


  
  

  public Table() throws ClassNotFoundException{
    /*
     * Initialize classes
     */
    link = new DB_Link();
    client = new Client();
    FS = new FileSystem();
    
    /*
     * For the table
     */
    model = new DefaultTableModel(col,link.totalEntries());	 
    table=new JTable(model){
      @Override public boolean isCellEditable(int arg0, int arg1){ return false; } };	   	
    sorter = new TableRowSorter<TableModel>(model);

  }

  
  
  

  public JScrollPane db_table() throws ClassNotFoundException 
  {

	  //add_new_client();
	//  mainProfile();
    /*
     * Make the UI_table
     */
    table.setRowSorter(sorter);

    /*
     * This calls the function to populate the UI_table
     * Returns the number of items in the table
     */
    DisplayDataBase(link.getTable());
    /*
     * Mouse listener to find ID of selected client
     */
    ListSelectionModel cellSelectionModel = table.getSelectionModel();
    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {				   
        selectedData = (String) table.getValueAt(table.getSelectedRows()[0], 0);	
 
 
              try {
      			client = link.searchById(selectedData);
  				//JOptionPane.showMessageDialog(null, mainProfile(client),"New Client",0);
				JOptionPane.showMessageDialog(null, mainLayout(client),"Client",JOptionPane.PLAIN_MESSAGE);

				
			} catch (HeadlessException e1) {
 				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
 				e1.printStackTrace();
			}
      }
    });

    JScrollPane pane = new JScrollPane(table); //pane 
    return pane;
  }

  
  /*
   * Call an object of the ResutlSet to display all the data available on the database
   * 
   */
  public void DisplayDataBase(ResultSet rs) {
    int i = 0;
    try {
      while(rs.next()) {
        table.setValueAt(rs.getString("ID"),i,0); 
        table.setValueAt(rs.getString("LastName"),i,1); 
        table.setValueAt(rs.getString("FirstName"),i,2); 
        table.setValueAt(rs.getString("Gender"),i,3); 
        i++;  
      }
    }
    catch(SQLException e)
    {
      System.err.println(e.getMessage());
    }  
  }

   
  /*
	 * SIDEBAR
	 */
	public JPanel sideBar(final String ID){
		
JPanel dynamicLabels = new JPanel(new BorderLayout(4,4));
dynamicLabels.setBorder(new TitledBorder("Forms Available") );	
		
final JPanel labels = new JPanel(new GridLayout(0,2,3,3));
labels.setBorder(new TitledBorder("Forms Available") );

 
 String path = "/Users/JC/Documents/workspace/wsr/Users/"+ID; 

String files;
File folder = new File(path);
if (!folder.exists()) { //if FOLDER DEOS NOT EXIST IT RETURNS 
	return dynamicLabels;
}

File[] listOfFiles = folder.listFiles(); 




if (listOfFiles.length >= 1){ //CHECK TO SEE IF THERE IS MORE THAN 1 PDF 
 
final JPanel d= new JPanel(new GridLayout((int)((listOfFiles.length)/2)+1,(int)((listOfFiles.length)/4)+1));
JButton button[] = new JButton[listOfFiles.length];

for (int i = 0; i < listOfFiles.length; i++) 
{
 if (listOfFiles[i].isFile()) 
 {
 files = listOfFiles[i].getName();
     if (files.endsWith(".pdf") || files.endsWith(".PDF"))
     {
     	 button[i] = new JButton();
          button[i].setText(files); //adds txt to buttons
    	 d.add(button[i]);  //adds buttons to JPane

    	
//listener
  	 final String nami = files;
button[i].addActionListener( new ActionListener(){
	String fileName = "/Users/JC/Documents/workspace/wsr//Users/" + ID + "/" + nami;
  public void actionPerformed(ActionEvent ae) {
    	if (Desktop.isDesktopSupported()) {
  	    try {
   	        File myFile = new File(fileName);
  	        Desktop.getDesktop().open(myFile);
  	    } catch (IOException ex) {
  	        // no application registered for PDFs
  	    }
  	}  
  }
} ); //Listener
     }
     }
 }
 
//dynamicLabels.add( new JScrollPane(labels), BorderLayout.CENTER );
dynamicLabels.add( new JScrollPane(d), BorderLayout.SOUTH );

}



//THIS WILL BE USED TO DISPLAY ALL THE FORMS AVAILABLE

///button
JButton addNew = new JButton("New Form");
dynamicLabels.add( addNew, BorderLayout.NORTH );

//listener
addNew.addActionListener( new ActionListener(){
    public void actionPerformed(ActionEvent ae) {
        labels.add( new JLabel("Label " + 1) );
        //frame.validate();
     
    }
} ); //Listener

//dynamicLabels.add( new JScrollPane(labels), BorderLayout.CENTER );


		return dynamicLabels;
	}





 

	

	
	public Container add_form(){
		 return contentPane;
	}

	
	
	
  public Container mainProfile(Client client){

   // Client client = new Client();


   // Container contentPane = getContentPane();
      contentPane = getContentPane();
      contentPane.removeAll();
      
    contentPane.setBackground(Color.WHITE);
    contentPane.setLayout(new GridLayout(8,4));


    addressLabel = new JLabel("ID:  ");
    contentPane.add(addressLabel);
    addressTextField = new JTextField(client.GetID(),18);
    contentPane.add(addressTextField);
    
    addressLabel = new JLabel("Address:  ");
    contentPane.add(addressLabel);
    addressTextField = new JTextField(client.GetAddress(),18);
    contentPane.add(addressTextField);
    
    nameLabel = new JLabel("Name: ");
    contentPane.add(nameLabel);
   String name = client.GetFirstName() + " " + client.GetLastName();
     nameTextField = new JTextField(name,18);
    contentPane.add(nameTextField);

    cityLabel = new JLabel("City: ");
    contentPane.add(cityLabel);
    cityTextField = new JTextField(client.GetCity(),18);
    contentPane.add(cityTextField);

    stateLabel = new JLabel("State: ");
    contentPane.add(stateLabel);
    stateTextField = new JTextField(client.GetState(),18);
    contentPane.add(stateTextField);

    zipLabel = new JLabel("Zip code: ");
    contentPane.add(zipLabel);
    zipTextField = new JTextField(client.GetZip(),18);
    contentPane.add(zipTextField);

    phoneLabel = new JLabel("Phone number: ");
    contentPane.add(phoneLabel);
    phoneTextField = new JTextField(client.GetPhone(),18);
    contentPane.add(phoneTextField);

    emailLabel = new JLabel("Email: ");
    contentPane.add(emailLabel);
    emailTextField = new JTextField("xxxx@gmail.com",18);
    contentPane.add(emailTextField);

    nameLabel1 = new JLabel("Data of Birth: ");
    contentPane.add(nameLabel1);
    nameTextField1 = new JTextField(client.GetDOB(),18);
    //final JTextField filterText = new JTextField(""); 
    contentPane.add(nameTextField1);

    addressLabel1 = new JLabel("Age:  ");
    contentPane.add(addressLabel1);
    addressTextField1 = new JTextField(client.GetAge(),18);
    contentPane.add(addressTextField1);

    cityLabel1 = new JLabel("Gender: ");
    contentPane.add(cityLabel1);
    cityTextField1 = new JTextField(client.GetGender(),18);
    contentPane.add(cityTextField1);

    stateLabel1 = new JLabel("Date of Entry: ");
    contentPane.add(stateLabel1);
    stateTextField1 = new JTextField("xx/xx/xxxx",18);
    contentPane.add(stateTextField1);

    zipLabel1 = new JLabel("Date of Exit: ");
    contentPane.add(zipLabel1);
    zipTextField1 = new JTextField("xx/xx/xxxx",18);
    contentPane.add(zipTextField1);

    phoneLabel1 = new JLabel("Status: ");
    contentPane.add(phoneLabel1);
    phoneTextField1 = new JTextField(client.GetRank(),18);
    contentPane.add(phoneTextField1);

    emailLabel1 = new JLabel("Program Turn out: ");
    contentPane.add(emailLabel1);
    emailTextField1 = new JTextField("Not Succesful",18);
    contentPane.add(emailTextField1);

    enterButton = new JButton("Update Record");
    enterButton.addActionListener(this);
    contentPane.add(enterButton);

 


    return contentPane;
  }




  public void actionPerformed(ActionEvent e)
  {
    String actionCommand = e.getActionCommand();
    if(actionCommand.equals("Update Record"))
    {
      String display = nameTextField.getText() + "\n";
      display += addressTextField.getText() + "\n";
      display += cityTextField.getText() + "\n";
      display += stateTextField.getText() + "\n";
      display += zipTextField.getText() + "\n";
      display += phoneTextField.getText() + "\n";
      display += emailTextField.getText();

      nameTextField.setText("");
      addressTextField.setText("");
      cityTextField.setText("");
      stateTextField.setText("");
      zipTextField.setText("");
      phoneTextField.setText("");
      emailTextField.setText("");

      JOptionPane.showMessageDialog(null, display);
    }
    else


      System.exit(0);
  }




   



  /*
   * This is the seach bar to seach on the table  
   */
  public JPanel searchField() {

    JPanel panel = new JPanel(new BorderLayout());
    JLabel label = new JLabel("Search");
    panel.add(label, BorderLayout.WEST);

    /// this is the text to appear on the search space      
    final JTextField filterText = new JTextField(""); 

    /*
     * adds panel with a filter to the pane
     */
    panel.add(filterText, BorderLayout.CENTER);

    // button
    JButton button = new JButton("Search");				  			        
    button.addActionListener(new ActionListener() {        	
      public void actionPerformed(ActionEvent e) {
        String text = filterText.getText();
        if (text.length() == 0) {
          sorter.setRowFilter(null);
        } else {
          try {
            sorter.setRowFilter(
              RowFilter.regexFilter(text));
          } catch (PatternSyntaxException pse) {
            System.err.println("Bad regex pattern");
          }
        }
      }
    });

    panel.add(button, BorderLayout.EAST);

    return panel;
  }


  
  
  
  /*
   * Split Panel for Table and Profile Panels
   */
  public JSplitPane mainLayout(Client client) throws ClassNotFoundException{
    JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, mainProfile(client), new JScrollPane(sideBar(client.GetID())));   
    //JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, mainProfile(client), new JScrollPane(sideBar()));   

    return splitPane;
  }
  
  
  
 public JPanel table_seachBar(){
	 
 
     final JPanel gui = new JPanel(new BorderLayout(5,5));
 
     JScrollPane middle_Bar = null;
     //JSplitPane middle_Bar = null;
     try {
      // middle_Bar = db_tb.mainLayout();	
     	middle_Bar = db_table();
     } catch (ClassNotFoundException e) {				 
       e.printStackTrace();
     }

     //Adding Search field to the toolBar
     gui.add(searchField(), BorderLayout.NORTH); //its added to the top		 
     /*
      * Adding JPanels to JFrame	
      */

     gui.add( middle_Bar, BorderLayout.CENTER );//split table & picture
     return gui;
 }
	
/*
 
  public static void main(String[] args) throws ClassNotFoundException {
	    final Table db_tb = new Table();

	    Runnable r = new Runnable() {

	      public void run() {
	        final JFrame frame = new JFrame("West Slope Recovery");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

/////////////////////////////////////////////	        
	       //THIS IS ALL YOU NEED TO ADD TO A CLASS.
	        final JPanel gui = new JPanel(new BorderLayout(5,5));
 	        gui.add(db_tb.table_seachBar(), BorderLayout.CENTER);
/////////////////////////////////////////////
	       
 	        
	         // JFrame Properties
	        
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
  
  */
	}


