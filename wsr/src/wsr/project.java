package wsr;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;

import javax.swing.JButton;   
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;  
import javax.swing.JPanel;

import com.itextpdf.text.DocumentException;

class project implements ActionListener{
   public static void main(String Args[]){
      logIn();
      //homePage();
      //formsList();
      //manageWindow();
      //createNewUser();
      //resetUserPassword();
      //resetPasswordNotMatch();
      //userPasswordNotMatch();
      
	  // backupDataBasePrompt();
	   
      //File path variable
      
   }
//For right now all buttons/ text fields are universal for this class
//until I find a better solution for bringing buttons between methods

//Creates log in Pane & everything for it
   
   static JFrame logInFrame = new JFrame("WestSlope Recovery");
   static JButton logInButton = new JButton("Log In");
   
   public static void logIn(){
	   
	  ActionListener AL = new project(); 
      logInFrame.pack();
      logInFrame.setSize(350,350);
      logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
      Container logInPane = logInFrame.getContentPane();
      logInPane.setLayout(new BoxLayout(logInPane, BoxLayout.Y_AXIS));
      ImageIcon image = new ImageIcon("Images/westslopmain.JPG");
      
      JPanel home = new JPanel();
      home.setBackground(Color.WHITE);
      JLabel pic = new JLabel(image);
      home.add(pic);
  
      JPanel box = new JPanel();
      box.setLayout(new BorderLayout());
      box.setBackground(Color.WHITE);
      
      JPanel midBox = new JPanel(new GridLayout(2, 2, 2, 55));
      midBox.setBackground(Color.WHITE);
      
      JLabel blk = new JLabel("  ");
      blk.setBackground(Color.WHITE);
      box.add(blk, BorderLayout.NORTH);

      JLabel userNameLabel = new JLabel("Username",JLabel.CENTER);
      userNameLabel.setLocation(350,200);
      userNameLabel.setSize(100,40);
      midBox.add(userNameLabel);
      
      JTextField userField = new JTextField("", 15);
      midBox.add(userField);
      
      JLabel passwordLabel = new JLabel("Password",JLabel.CENTER);
      midBox.add(passwordLabel);
      
      JPasswordField passwordField = new JPasswordField(15);
      midBox.add(passwordField);
      
      box.add(midBox);
      
     
      logInButton.addActionListener(AL);
      box.add(logInButton, BorderLayout.SOUTH);
  
      
      logInPane.add(home);
      logInPane.add(box);
      logInFrame.setResizable(false);
      logInFrame.setLocationRelativeTo(null);
      logInFrame.setVisible(true);
   }  
   
   static JButton upnmOkButton = new JButton("OK");
   static JFrame userPasswordNotMatchFrame = new JFrame("Error");
   public static void userPasswordNotMatch(){
	   ActionListener AL = new project();
	   
	   
	   userPasswordNotMatchFrame.setSize(250, 110);
	   
	   Container rptnmFrame = userPasswordNotMatchFrame.getContentPane();
	   
	   rptnmFrame.setLayout(new BorderLayout());
	   JLabel error = new JLabel("   The UserName/ Password Do Not Match");
	   rptnmFrame.add(error, BorderLayout.CENTER);
	   upnmOkButton.addActionListener(AL);
	   rptnmFrame.add(upnmOkButton, BorderLayout.SOUTH);
	   
	   userPasswordNotMatchFrame.setLocationRelativeTo(null);
	   userPasswordNotMatchFrame.setResizable(false);
	   userPasswordNotMatchFrame.setVisible(true);
   }   
   
//Creates home page and all of its elements
 
  // static JTextField searchBar = new JTextField("Search...", 15);
   static JButton searchButton = new JButton("Search");
   static JButton newClient = new JButton("New Potential Client");
   static JButton manage = new JButton("Manage");
   static JButton blankForms = new JButton("Blank Forms");
   static JLabel currentUser = new JLabel("CurentUser");
   static JButton topHomeButton = new JButton("Home");
   static JButton waitList = new JButton("Wait Listed Clients");
   static JButton generateReportButton = new JButton("Generate Report");
   static JFrame homeFrame = new JFrame("West Slope Recovery");
   static JPanel centerPanel = new JPanel();
   
   public static void homePage(){
	   ActionListener AL = new project();
	   	    	
	   homeFrame.setSize(800, 600);
       homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   Container homeCont = homeFrame.getContentPane();
	   homeCont.setLayout(new BorderLayout());
	        
	   //West Panel Start
	   JPanel westPanel = new JPanel();
	   westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));	
	   
	  // westPanel.add(searchBar);
	   searchButton.addActionListener(AL);
	   searchButton.setOpaque(false);
	   searchButton.setContentAreaFilled(false);
	   searchButton.setBorderPainted(false);
	   westPanel.add(searchButton);
	  
	   newClient.addActionListener(AL);
	   newClient.setOpaque(false);
	   newClient.setContentAreaFilled(false);
	   newClient.setBorderPainted(false);
	   westPanel.add(newClient);
      
	   waitList.addActionListener(AL);
	   waitList.setOpaque(false);
	   waitList.setContentAreaFilled(false);
	   waitList.setBorderPainted(false);
	   westPanel.add(waitList);

	   //westPanel.add(Box.createHorizontalGlue());
	   westPanel.add(Box.createRigidArea(new Dimension(0,385)));
	   
	   generateReportButton.addActionListener(AL);
	   generateReportButton.setOpaque(false);
	   generateReportButton.setContentAreaFilled(false);
	   generateReportButton.setBorderPainted(false);
	   westPanel.add(generateReportButton);
	   
	   blankForms.addActionListener(AL);
	   blankForms.setOpaque(false);
	   blankForms.setContentAreaFilled(false);
	   blankForms.setBorderPainted(false);
       westPanel.add(blankForms);
	   
       manage.addActionListener(AL);
       manage.setOpaque(false);
	   manage.setContentAreaFilled(false);
	   manage.setBorderPainted(false);
       westPanel.add(manage);
	   
	   homeCont.add(westPanel, BorderLayout.WEST);
	   //West Panel End
	        
	        
	   //North Panel Start
       JPanel northPanel = new JPanel();
       northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));    
       
       northPanel.add(Box.createRigidArea(new Dimension(640,0)));
       
	   northPanel.add(currentUser);
	   
	   topHomeButton.addActionListener(AL);
	   topHomeButton.setOpaque(false);
	   topHomeButton.setContentAreaFilled(false);
	   topHomeButton.setBorderPainted(false);
	   northPanel.add(topHomeButton);   
	        
       homeCont.add(northPanel, BorderLayout.NORTH);
	   //North Panel End
       
       //Center Panel Start
      
       centerPanel.setBackground(Color.white);
       
       ImageIcon image = new ImageIcon("Images/WSRFINAL.png");
       JLabel pic = new JLabel(image);
       centerPanel.add(pic);
       
       
       homeCont.add(centerPanel, BorderLayout.CENTER); 
       
       //Center Panel End
        
       homeFrame.setResizable(false);
	   homeFrame.setLocationRelativeTo(null);          
       homeFrame.setVisible(true);
	        	   
   }
   
   static JPanel centerPanelWS = new JPanel();
   static JFrame homeFrameWS = new JFrame("West SLope Recovery");
   
   public static void homePageWS(){
	   ActionListener AL = new project();
	   	    	   
	   homeFrameWS.setSize(800, 600);
       homeFrameWS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   Container homeContWS = homeFrameWS.getContentPane();
	   homeContWS.setLayout(new BorderLayout());
	        
	   //West Panel Start
	   JPanel westPanelWS = new JPanel();
	   westPanelWS.setLayout(new BoxLayout(westPanelWS, BoxLayout.Y_AXIS));	
	   
	   //westPanelWS.add(searchBar);
	   
	   searchButton.addActionListener(AL);
	   searchButton.setOpaque(false);
	   searchButton.setContentAreaFilled(false);
	   searchButton.setBorderPainted(false);
	   westPanelWS.add(searchButton);
	     
	   newClient.addActionListener(AL);
	   newClient.setOpaque(false);
	   newClient.setContentAreaFilled(false);
	   newClient.setBorderPainted(false);
	   westPanelWS.add(newClient);
      
	   waitList.addActionListener(AL);
	   waitList.setOpaque(false);
	   waitList.setContentAreaFilled(false);
	   waitList.setBorderPainted(false);
	   westPanelWS.add(waitList);

	   //westPanel.add(Box.createHorizontalGlue());
	   westPanelWS.add(Box.createRigidArea(new Dimension(0,385)));
	   
	   generateReportButton.addActionListener(AL);
	   generateReportButton.setOpaque(false);
	   generateReportButton.setContentAreaFilled(false);
	   generateReportButton.setBorderPainted(false);
	   westPanelWS.add(generateReportButton);
	   
	   blankForms.addActionListener(AL);
	   blankForms.setOpaque(false);
	   blankForms.setContentAreaFilled(false);
	   blankForms.setBorderPainted(false);
       westPanelWS.add(blankForms);
	   
       manage.addActionListener(AL);
       manage.setOpaque(false);
	   manage.setContentAreaFilled(false);
	   manage.setBorderPainted(false);
       westPanelWS.add(manage);
	   
	   homeContWS.add(westPanelWS, BorderLayout.WEST);
	   //West Panel End
	        
	        
	   //North Panel Start
       JPanel northPanelWS = new JPanel();
       northPanelWS.setLayout(new BoxLayout(northPanelWS, BoxLayout.X_AXIS));    
       
       northPanelWS.add(Box.createRigidArea(new Dimension(640,0)));
       
	   northPanelWS.add(currentUser);
	   
	   topHomeButton.addActionListener(AL);
	   topHomeButton.setOpaque(false);
	   topHomeButton.setContentAreaFilled(false);
	   topHomeButton.setBorderPainted(false);
	   northPanelWS.add(topHomeButton);
	        
       homeContWS.add(northPanelWS, BorderLayout.NORTH);
	   //North Panel End
          
       try{
    	   final Table db_tb = new Table();
    	   
    	   final JPanel gui = new JPanel(new BorderLayout(5,5));
           gui.add(db_tb.table_seachBar(), BorderLayout.CENTER);
           centerPanelWS.add(gui);
           System.out.println("asf");
           
    	   }catch(Throwable ignoreAndContinue){
    	   }
       
       //Center Panel Start
      
       centerPanelWS.setBackground(Color.white);
       
       homeContWS.add(centerPanelWS, BorderLayout.CENTER); 
       
       //Center Panel End
        
       homeFrameWS.setResizable(false);
	   homeFrameWS.setLocationRelativeTo(null);          
       homeFrameWS.setVisible(true);
	        	   
   }
   
//Creates Frame for Manage Window and all of its elements   
   static JButton createNewUser = new JButton("Create New User");
   //static JButton createNewForm = new JButton("Create New Form");
   static JButton resetUserPassword = new JButton("Reset User Password");
   static JButton backupDatabase = new JButton("Backup DataBase");
   static JButton manageHome = new JButton("Home");
   static JFrame manageFrame = new JFrame("Manage");
   
   public static void manageWindow(){
      ActionListener AL = new project();
      
      
      manageFrame.setSize(500,300);     
      Container manageContentPane = manageFrame.getContentPane();
      manageContentPane.setLayout(new BorderLayout());
      //BoxLayout.LEFT_ALIGNMENT();
      JPanel managePanel = new JPanel();
      managePanel.setLayout(new BoxLayout(managePanel, BoxLayout.Y_AXIS));
      
      createNewUser.addActionListener(AL);
      createNewUser.setOpaque(false);
	  createNewUser.setContentAreaFilled(false);
	  createNewUser.setBorderPainted(false); 
      managePanel.add(createNewUser);
      
      /* TBD
      createNewForm.addActionListener(AL);
      manageFrame.add(createNewForm);
      */
      
      resetUserPassword.addActionListener(AL);
      resetUserPassword.setOpaque(false);
	  resetUserPassword.setContentAreaFilled(false);
	  resetUserPassword.setBorderPainted(false);
      managePanel.add(resetUserPassword);
      
      backupDatabase.addActionListener(AL);
      backupDatabase.setOpaque(false);
	  backupDatabase.setContentAreaFilled(false);
	  backupDatabase.setBorderPainted(false);
      managePanel.add(backupDatabase); 
      
      manageHome.addActionListener(AL);
      
      manageContentPane.add(managePanel, BorderLayout.CENTER);
      manageContentPane.add(manageHome, BorderLayout.SOUTH);
      manageFrame.setLocationRelativeTo(null);
      manageFrame.setResizable(false);
      manageFrame.setVisible(true);
   
   }
   
   static JFrame backupDataBasePromtFrame = new JFrame(" ");
   static JButton dbprompt = new JButton("OK");
   
   public static void  backupDataBasePrompt(){
	   ActionListener AL = new project();
	   
	   backupDataBasePromtFrame.setSize(250, 110);
	   
	   Container rpnmFrame = backupDataBasePromtFrame.getContentPane();
	   
	   rpnmFrame.setLayout(new BorderLayout());
	   JLabel error = new JLabel("        The DataBase has been Backed up");
	   rpnmFrame.add(error, BorderLayout.CENTER);
	
	   
	   dbprompt.addActionListener(AL);
	   rpnmFrame.add(dbprompt, BorderLayout.SOUTH);
	   
	   backupDataBasePromtFrame.setLocationRelativeTo(null);
	   backupDataBasePromtFrame.setResizable(false);
	   backupDataBasePromtFrame.setVisible(true);
   }
   
   
//Creates Frame for generating a report

   static JButton genReportButton = new JButton("Generate Report");
   
   public static void generateReport(){
	   ActionListener AL = new project();
	   
	   JFrame genReportFrame = new JFrame("Generate Report");
       genReportFrame.setSize(800, 400);
       Container genReportCont = genReportFrame.getContentPane();
       genReportCont.setLayout(new BorderLayout());
       JPanel genReportPane = new JPanel();
       genReportPane.setLayout(new GridLayout(4, 4, 2, 80));
       
       JCheckBox dem1 = new JCheckBox("Number of Intakes");
       JCheckBox dem2 = new JCheckBox("Total Discharges");
       JCheckBox dem3 = new JCheckBox("Successful Discharges");
       JCheckBox dem4 = new JCheckBox("Unsuccessful Discharges");
       JCheckBox dem5 = new JCheckBox("Total Clients this month");
       JCheckBox dem6 = new JCheckBox("Active Clients at End of Month");
       JCheckBox dem7 = new JCheckBox("Average Days in Treatment");
       
       JLabel space = new JLabel(" ");
       JLabel space1 = new JLabel(" ");
       JLabel space2 = new JLabel(" ");
       
       String[] ageGroups = {"Age Group", "18-25", "26-35", "36-45", "46-55", "56-65", "65+"};       
       JComboBox ageGroupBox = new JComboBox(ageGroups);
       
       String[] races = {"Race", "White", "Hispanic", "African American", "Asian", "Other"};
       JComboBox dem9 = new JComboBox(races);
       
       String[] genders = {"Gender", "Male", "Female"};
       JComboBox dem10 = new JComboBox(genders);
      
       String[] countys = {"County", "Sacramento", "Placerville,", "San Joaquin", "Yolo"};
       JComboBox dem11 = new JComboBox(countys);
       
       String[] funders = {"Funder", "HealthCare Plus", "GetBetter.com", "Their Mom", "Personal"};
       
       JComboBox dem12 = new JComboBox(funders);
      
       genReportPane.add(dem1);
       genReportPane.add(dem2);
       genReportPane.add(dem3);
       genReportPane.add(dem4);       
       genReportPane.add(dem5);
       genReportPane.add(dem6);
       genReportPane.add(dem7);
    
       genReportPane.add(ageGroupBox);
       
       genReportPane.add(dem9);
       genReportPane.add(dem10);
       genReportPane.add(dem11);
       genReportPane.add(dem12);
       genReportPane.add(space1);
       genReportPane.add(space2);
       genReportPane.add(space);
       
       genReportButton.addActionListener(AL);
       genReportPane.add(genReportButton);
       
       genReportFrame.setLocationRelativeTo(null);
       genReportCont.add(genReportPane);
       genReportFrame.setVisible(true);
   }
   
   
   
 //CREATE NEW USER METHOD  
   static JTextField newUsernameField = new JTextField(20);
   static JPasswordField newUserPasswordField = new JPasswordField(20);
   static JPasswordField newUserPasswordCheckField = new JPasswordField(20);
   static JButton createNewUserButton = new JButton("Create New User");
   static JFrame createNewUserFrame = new JFrame("Create New User");
   
   
   public static void createNewUser(){
      ActionListener AL = new project();
      createNewUserFrame.setSize(450, 250);
      Container cnuContPane = createNewUserFrame.getContentPane();
      cnuContPane.setLayout(new BorderLayout());
      
      JPanel midPanel = new JPanel(new GridLayout(3,2,2,55 ));
      
      JLabel title = new JLabel(" ");
      cnuContPane.add(title, BorderLayout.NORTH);   
      
      JLabel newUsernameLabel = new JLabel("New Username:");
      newUsernameLabel.setSize(80,50);
      midPanel.add(newUsernameLabel);
      
      midPanel.add(newUsernameField);
      
      JLabel newUserPassword = new JLabel("New User Password:");
      newUserPassword.setSize(80,50);
      midPanel.add(newUserPassword);
     
      midPanel.add(newUserPasswordField);
     
      JLabel newUserPasswordCheck = new JLabel("Confirm New User Password:");
      newUserPasswordCheck.setSize(80,50);
      midPanel.add(newUserPasswordCheck);
      
      midPanel.add(newUserPasswordCheckField);
     
      createNewUserButton.addActionListener(AL);
      cnuContPane.add(createNewUserButton, BorderLayout.SOUTH);

      cnuContPane.add(midPanel, BorderLayout.CENTER);
      createNewUserFrame.setResizable(false);
	  //createNewUserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      createNewUserFrame.setLocationRelativeTo(null);
      createNewUserFrame.setVisible(true);
   }
 
 
//RESET PASSWORD METHOD   
   static JButton resetUserPass = new JButton("Reset Password");
   static JPasswordField resetPassword = new JPasswordField(20);
   static JPasswordField resetPasswordCheck = new JPasswordField(20);
   static JFrame resetPasswordFrame = new JFrame("Reset Password");
   
   
   public static void resetUserPassword(){
      ActionListener AL = new project();
      resetPasswordFrame.setSize(400, 200);
      Container resetPasswordCont = resetPasswordFrame.getContentPane();
      resetPasswordCont.setLayout(new BorderLayout());
      
      JLabel topBlank = new JLabel(" ");
      resetPasswordCont.add(topBlank, BorderLayout.NORTH);
      
      JPanel midResetPane = new JPanel();
      midResetPane.setLayout(new GridLayout(3,3,2,33)); 
      
      JLabel pickUser = new JLabel("User:");
      midResetPane.add(pickUser);
      
      //JLabel userList = new JLabel("User DropList");
      //midResetPane.add(userList);
      
      String[] userNames = {"Dave", "Tim", "Steve", "Bob", "Anne", "Hugh"}; 
      
      JComboBox userNameBox = new JComboBox(userNames);
      midResetPane.add(userNameBox);
      
      JLabel newPass = new JLabel("New Password:");
      midResetPane.add(newPass);
      
      resetPassword.setSize(15,100);
      midResetPane.add(resetPassword);
      
      JLabel newPassCheck = new JLabel("Confirm New Password");
      midResetPane.add(newPassCheck);
      
      resetPasswordCheck.setSize(100, 20);
      midResetPane.add(resetPasswordCheck);
      
      resetPasswordCont.add(midResetPane);
      
      resetUserPass.addActionListener(AL);
      resetPasswordCont.add(resetUserPass, BorderLayout.SOUTH);
      
      resetPasswordFrame.setResizable(false);
	  //resetPasswordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      resetPasswordFrame.setLocationRelativeTo(null);
      resetPasswordFrame.setVisible(true);
      
   }  
   
   static JButton rpnmokButton = new JButton("OK");
   
   static JFrame resetPasswordNotMatchFrame = new JFrame("Error");
   public static void resetPasswordNotMatch(){
	   ActionListener AL = new project();
	   
	   resetPasswordNotMatchFrame.setSize(250, 110);
	   
	   Container rpnmFrame = resetPasswordNotMatchFrame.getContentPane();
	   
	   rpnmFrame.setLayout(new BorderLayout());
	   JLabel error = new JLabel("             The Passwords Do Not Match");
	   rpnmFrame.add(error, BorderLayout.CENTER);
	   
	   
	   rpnmokButton.addActionListener(AL);
	   rpnmFrame.add(rpnmokButton, BorderLayout.SOUTH);
	   
	   resetPasswordNotMatchFrame.setLocationRelativeTo(null);
	   resetPasswordNotMatchFrame.setResizable(false);
	   resetPasswordNotMatchFrame.setVisible(true);
   }
   
   
//BLANK FORMS METHOD   
   static JButton form1 = new JButton("Client Screening & Intake Form");
   static JButton form2 = new JButton("Fire Response Plan");
   static JButton form3 = new JButton("ASAM");
   static JButton form4 = new JButton("Client Admission Agreement");
   static JButton form5 = new JButton("Financial");
   static JButton form6 = new JButton("Client Rights & Consent to Treatment");
   static JButton form7 = new JButton("The Program and Resident Rules");
   static JButton form8 = new JButton("Group Rules");
   static JButton form9 = new JButton("Hygiene Standard");
   static JButton form10 = new JButton("UA");
   static JButton form11 = new JButton("H.Q.");
   static JButton form12 = new JButton("Admission Bookeeping Form");
   static JButton form13 = new JButton("CFR Statement");
   static JButton form14 = new JButton("Follow up and Consent");
   static JButton form15 = new JButton("Authorization for release or Psychiatric");
   static JButton form16 = new JButton("Consent Doc 1");
   static JButton form17 = new JButton("Consnet Doc 2");
   static JButton form18 = new JButton("Criminal Justice Release Doc 3");
   static JButton form19 = new JButton("Awareness Notice");
   static JButton form20 = new JButton("Rules and Rights Violation");
   static JButton form21 = new JButton("1 on 1 Notes");
   static JButton form22 = new JButton("TX Plan");
   static JButton form23 = new JButton("DSM IV ");
   static JButton form24 = new JButton("Phase Eval");
   static JButton form25 = new JButton("Phase II Info");
   static JButton form26 = new JButton("Exit Bookkeeping");
   static JButton form27 = new JButton("Discharge Criteria");
   static JButton form28 = new JButton("Discharge Summary");
   static JButton form29 = new JButton("Client Self Evalutation and Exit Plan");
   static JButton form30 = new JButton("Safekeeping Agreement");
   static JButton form31 = new JButton("Linen Agreement");
   static JButton formHome = new JButton("Home");
   static JFrame formFrame= new JFrame("Blank Forms");
   
   public static void formsList(){
      ActionListener AL = new project();
      
      formFrame.setSize(400, 400);
      
      Container contentPane = formFrame.getContentPane();
      contentPane.setLayout(new BorderLayout());
      JPanel formPanel = new JPanel();
      
      formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.PAGE_AXIS));
      JScrollPane sp = new JScrollPane(formPanel);
      
      form1.addActionListener(AL);
      form1.setOpaque(false);
	  form1.setContentAreaFilled(false);
	  form1.setBorderPainted(false);
      formPanel.add(form1);
      
      form2.addActionListener(AL);
      form2.setOpaque(false);
	  form2.setContentAreaFilled(false);
	  form2.setBorderPainted(false);
      formPanel.add(form2);
      
      form3.addActionListener(AL);
      form3.setOpaque(false);
	  form3.setContentAreaFilled(false);
	  form3.setBorderPainted(false);
      formPanel.add(form3);
      
      form4.addActionListener(AL);
      form4.setOpaque(false);
	  form4.setContentAreaFilled(false);
	  form4.setBorderPainted(false);
      formPanel.add(form4);
      
      form5.addActionListener(AL);
      form5.setOpaque(false);
	  form5.setContentAreaFilled(false);
	  form5.setBorderPainted(false);
      formPanel.add(form5);
      
      form6.addActionListener(AL);
      form6.setOpaque(false);
	  form6.setContentAreaFilled(false);
	  form6.setBorderPainted(false);
      formPanel.add(form6);
      
      form7.addActionListener(AL);
      form7.setOpaque(false);
	  form7.setContentAreaFilled(false);
	  form7.setBorderPainted(false);
      formPanel.add(form7);
      
      form8.addActionListener(AL);
      form8.setOpaque(false);
	  form8.setContentAreaFilled(false);
	  form8.setBorderPainted(false);
      formPanel.add(form8);
      
      form9.addActionListener(AL);
      form9.setOpaque(false);
	  form9.setContentAreaFilled(false);
	  form9.setBorderPainted(false);
      formPanel.add(form9);
      
      form10.addActionListener(AL);
      form10.setOpaque(false);
	  form10.setContentAreaFilled(false);
	  form10.setBorderPainted(false);
      formPanel.add(form10);
      
      form11.addActionListener(AL);
      form11.setOpaque(false);
	  form11.setContentAreaFilled(false);
	  form11.setBorderPainted(false);
      formPanel.add(form11);
      
      form12.addActionListener(AL);
      form12.setOpaque(false);
	  form12.setContentAreaFilled(false);
	  form12.setBorderPainted(false);
      formPanel.add(form12);
      
      form13.addActionListener(AL);
      form13.setOpaque(false);
	  form13.setContentAreaFilled(false);
	  form13.setBorderPainted(false);
      formPanel.add(form13);
      
      form14.addActionListener(AL);
      form14.setOpaque(false);
	  form14.setContentAreaFilled(false);
	  form14.setBorderPainted(false);
      formPanel.add(form14);
      
      form15.addActionListener(AL);
      form15.setOpaque(false);
	  form15.setContentAreaFilled(false);
	  form15.setBorderPainted(false);
      formPanel.add(form15);
      
      form16.addActionListener(AL);
      form16.setOpaque(false);
	  form16.setContentAreaFilled(false);
	  form16.setBorderPainted(false);
      formPanel.add(form16);
      
      form17.addActionListener(AL);
      form17.setOpaque(false);
	  form17.setContentAreaFilled(false);
	  form17.setBorderPainted(false);
      formPanel.add(form17);
      
      form18.addActionListener(AL);
      form18.setOpaque(false);
	  form18.setContentAreaFilled(false);
	  form18.setBorderPainted(false);
      formPanel.add(form18);
      
      form19.addActionListener(AL);
      form19.setOpaque(false);
	  form19.setContentAreaFilled(false);
	  form19.setBorderPainted(false);
      formPanel.add(form19);
      
      form20.addActionListener(AL);
      form20.setOpaque(false);
	  form20.setContentAreaFilled(false);
	  form20.setBorderPainted(false);
      formPanel.add(form20);
      
      form21.addActionListener(AL);
      form21.setOpaque(false);
	  form21.setContentAreaFilled(false);
	  form21.setBorderPainted(false);
      formPanel.add(form21);
      
      form22.addActionListener(AL);
      form22.setOpaque(false);
	  form22.setContentAreaFilled(false);
	  form22.setBorderPainted(false);
      formPanel.add(form22);
      
      form23.addActionListener(AL);
      form23.setOpaque(false);
	  form23.setContentAreaFilled(false);
	  form23.setBorderPainted(false);
      formPanel.add(form23);
      
      form24.addActionListener(AL);
      form24.setOpaque(false);
	  form24.setContentAreaFilled(false);
	  form24.setBorderPainted(false);
	  formPanel.add(form24);
      
      form25.addActionListener(AL);
      form25.setOpaque(false);
	  form25.setContentAreaFilled(false);
	  form25.setBorderPainted(false);
      formPanel.add(form25);
      
      form26.addActionListener(AL);
      form26.setOpaque(false);
	  form26.setContentAreaFilled(false);
	  form26.setBorderPainted(false);
      formPanel.add(form26);
      
      form27.addActionListener(AL);
      form27.setOpaque(false);
	  form27.setContentAreaFilled(false);
	  form27.setBorderPainted(false);
      formPanel.add(form27);
      
      form28.addActionListener(AL);
      form28.setOpaque(false);
	  form28.setContentAreaFilled(false);
	  form28.setBorderPainted(false);
      formPanel.add(form28);
      
      form29.addActionListener(AL);
      form29.setOpaque(false);
	  form29.setContentAreaFilled(false);
	  form29.setBorderPainted(false);
      formPanel.add(form29);
      
      form30.addActionListener(AL);
      form30.setOpaque(false);
	  form30.setContentAreaFilled(false);
	  form30.setBorderPainted(false);
      formPanel.add(form30);
      
      form31.addActionListener(AL);
      form31.setOpaque(false);
	  form31.setContentAreaFilled(false);
	  form31.setBorderPainted(false);
      formPanel.add(form31);
      
      formHome.addActionListener(AL);

      contentPane.add(sp, BorderLayout.CENTER);
      contentPane.add(formHome, BorderLayout.SOUTH);
      //formFrame.setResizable(false);
      formFrame.setLocationRelativeTo(null);
      formFrame.setVisible(true);
   }
   
   public static void formsListWithAutoFill(){
   
   }
   
   public static boolean isFileClosed(File file) {
	    try {
	        Process plsof = new ProcessBuilder(new String[]{"lsof", "|", "grep", file.getAbsolutePath()}).start();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(plsof.getInputStream()));
	        String line;
	        while((line=reader.readLine())!=null) {
	            if(line.contains(file.getAbsolutePath())) {                            
	                reader.close();
	                plsof.destroy();
	                return false;
	            }
	        }
	        reader.close();
		    plsof.destroy();
	    } catch(Exception ex) {
	        
	    }
	    
	    return true;
	}
   
   
   
   
   
   
   public void actionPerformed(ActionEvent e){
	  //LOG IN PAGE ACTIONS START
	   

	  if(e.getSource() == logInButton){
		  System.out.println("check");
		  logInFrame.dispose();
		  homePage();
	  } 
	  
	  if(e.getSource() == upnmOkButton){
		  System.out.println("check");
		  userPasswordNotMatchFrame.dispose();
	  }
	  
	  //LOG IN PAGE ACTIONS END
   
      //HOME PAGE ACTIONS
	  if(e.getSource() == searchButton){
    	  homePageWS();
    	  homeFrame.dispose();
	      }
	  
      if(e.getSource() == newClient){
         PDFViewer.openViewer("PDFs/panel_1/1-Screening _ Client Information.pdf");
         File temp = new File("PDFs/panel_1/1-Screening _ Client Information.pdf");
         while(!isFileClosed(temp)){
        	 
         }
         try {
			TextFields.retrieveFields("PDFs/panel_1/1-Screening _ Client Information.pdf");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      }
      
      if(e.getSource() == blankForms){
    	  formsList();
      }
      if(e.getSource() == waitList){
    	  System.out.println("wait List");
      }
      
      if(e.getSource() == generateReportButton){
    	  generateReport();
      }
      
      if(e.getSource() == manage){
    	  manageWindow();
      }
      
      if(e.getSource() == topHomeButton){
    	  System.out.println("Return to Home Screen");
      }
      //END HOMEPAGE ACTIONS
      
      //GENERATE REPORT PANE ACTIONS
      if(e.getSource() == genReportButton){
    	  System.out.println("Generate Report");
      }
      
      //END GENERATE REPORT PANE END
      
      //MANAGE ACTIONS
      if(e.getSource() == createNewUser){
    	  createNewUser();
      }
      
      /*This Will be determined Later
      
      if(e.getSource() == createNewForm){
         System.out.println("create new form TBD");
      }
      
      */
      
      if(e.getSource() == resetUserPassword){
    	  resetUserPassword();
      }
      
      if(e.getSource() == backupDatabase){
         System.out.println("backupDataBase");
         backupDataBasePrompt();
      }
      
      if(e.getSource() == manageHome){
          manageFrame.dispose();
       }
      
      if(e.getSource() == dbprompt){
          System.out.println("backupDataBase prompt");
          backupDataBasePromtFrame.dispose();
       }
      
      
      //END MANAGE ACTIONS
      
      //RESET USER PASSWORD ACTIONS
      
      if(e.getSource() == resetUserPass){
         System.out.println("Reset User Password");
         resetPasswordFrame.dispose();
      }
      
      if(e.getSource() == rpnmokButton){
    	  System.out.println("good");
    	  resetPasswordNotMatchFrame.dispose();
      }
      
      //END RESETUSER PASSWORD ACTIONS
      
      //CREATE NEW USER ACTIONS
      if(e.getSource() == createNewUserButton){
         System.out.println("Create New User Account");
         createNewUserFrame.dispose();
      }
      //END CREATE NEW USER ACTIONS
      
      //FORMS ACTIONS
      if(e.getSource() == form1){
    	 PDFViewer.openViewer("PDFs/panel_1/1-Screening _ Client Information.pdf");  
      }
      
      if(e.getSource() == form2){
    	  PDFViewer.openViewer("PDFs/panel_1/10-Fire Response Plan.pdf");
      }
      
      if(e.getSource() == form3){
    	  PDFViewer.openViewer("PDFs/panel_1/2-ASAM.pdf");
      }
      
      if(e.getSource() == form4){
    	 PDFViewer.openViewer("PDFs/panel_1/4-CLIENT ADMISSION AGREEMENT revised.pdf");
      }
      
      if(e.getSource() == form5){
    	 PDFViewer.openViewer("PDFs/panel_1/5-Financial West Slope Recovery.pdf");
      }
      
      if(e.getSource() == form6){
    	  PDFViewer.openViewer("PDFs/panel_1/6-CLIENT RIGHTS AND CONSENT to TREATMENT.pdf");
      }
         
     if(e.getSource() == form7){
    	 PDFViewer.openViewer("PDFs/panel_1/7-The Program and Resident Rules.pdf");
      }
      
      if(e.getSource() == form8){
    	  PDFViewer.openViewer("PDFs/panel_1/8-Group Rules.pdf");
      }
      
      if(e.getSource() == form9){
    	 PDFViewer.openViewer("PDFs/panel_1/9-Hygiene Standards.pdf"); 
      }
      
      if(e.getSource() == form10){
    	  PDFViewer.openViewer("PDFs/panel_2/1-UA.pdf");
      }
      
      if(e.getSource() == form11){
    	  PDFViewer.openViewer("PDFs/panel_2/2-H_Q.pdf");
      }
      
      if(e.getSource() == form12){
    	 PDFViewer.openViewer("PDFs/panel_3/1-ADMISSION BOOKKEEPING FORM.pdf");
      }
      
      if(e.getSource() == form13){
    	  PDFViewer.openViewer("PDFs/panel_3/2-CFR Statement.pdf");
      }
      
      if(e.getSource() == form14){
    	 PDFViewer.openViewer("PDFs/panel_3/3-Follow-up and Consent.pdf");
      }
      
      if(e.getSource() == form15){
    	 PDFViewer.openViewer("PDFs/panel_3/4-AUTHORIZATION FOR RELEASE OF PSYCHIATRIC.pdf");
      }
      
      if(e.getSource() == form16){
    	  PDFViewer.openViewer("PDFs/panel_3/5-Consent Doc1.pdf");
      }
      
      if(e.getSource() == form17){
    	  PDFViewer.openViewer("PDFs/panel_3/6-Consent Doc2.pdf");
      }
      
      if(e.getSource() == form18){
    	  PDFViewer.openViewer("PDFs/panel_3/7-Criminal Justice Release Doc3.pdf");
      }
      
      if(e.getSource() == form19){
    	  PDFViewer.openViewer("PDFs/panel_4/1-Awareness Notice.pdf");
      }
   
      if(e.getSource() == form20){
    	  PDFViewer.openViewer("PDFs/panel_4/2-RULES AND RIGHTS VIOLATION.pdf");
      }
      
      if(e.getSource() == form21){
    	  PDFViewer.openViewer("PDFs/panel_5/2- 1on1 notes 2.pdf");
      }
      
      if(e.getSource() == form22){
    	  PDFViewer.openViewer("PDFs/panel_5/3-TX Plan.pdf");
      }
      
      if(e.getSource() == form23){
    	  PDFViewer.openViewer("PDFs/panel_5/4-DSM IV.pdf");
      }
      
      if(e.getSource() == form24){
    	  PDFViewer.openViewer("PDFs/panel_5/6-Phase Eval.pdf");
      }
      if(e.getSource() == form25){
    	  PDFViewer.openViewer("PDFs/panel_5/7-Phase II Info.pdf");
      }
      
      if(e.getSource() == form26){
    	  PDFViewer.openViewer("PDFs/panel_6/1-Exit Bookkeeping.pdf");
      }
      
      if(e.getSource() == form27){
    	  PDFViewer.openViewer("PDFs/panel_6/3-Discharge Criteria.pdf");
      }
      
      if(e.getSource() == form28){
    	  PDFViewer.openViewer("PDFs/panel_6/4-Discharge Summary.pdf");
      }
      
      if(e.getSource() == form29){
    	  PDFViewer.openViewer("PDFs/panel_6/5-Client Self Evaluation and Exit Plan.pdf");
      }
      
      if(e.getSource() == form30){
    	  PDFViewer.openViewer("PDFs/panel_6/6-Safekeeping Agreement.pdf");
      }
      
      if(e.getSource() == form31){
    	  PDFViewer.openViewer("PDFs/panel_6/7-LINEN AGREEMENT.pdf");
      }
      
      if(e.getSource() == formHome){
          formFrame.dispose();
       }  
      //END FORMS ACTIONS
   }
}