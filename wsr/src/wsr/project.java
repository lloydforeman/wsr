package wsr;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.JFrame.*;

import com.itextpdf.text.DocumentException;

class project implements ActionListener{
  public static void main(String Args[]){
    //System.out.print("Sup Niggas");
    logIn();
    // homePage();
    //formsList();
    //  manageWindow();
    // createNewUser();
    // resetUserPassword();



  }
  //For right now all buttons/ text fields are universal for this class
  //until I find a better solution for bringing buttons between methods
  //For right now all buttons/ text fields are universal for this class
  //until I find a better solution for bringing buttons between methods

  //Creates log in Pane & everything for it

  static JButton logInButton = new JButton("Log In");
  public static void logIn(){

    ActionListener AL = new project();
    JFrame logInFrame = new JFrame("WestSlope Recovery");
    logInFrame.pack();
    logInFrame.setLocation(400,300);
    logInFrame.setSize(300,129);
    logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container logInPane = logInFrame.getContentPane();
    logInPane.setLayout(null);

    ImageIcon image = new ImageIcon("C:/Users/Gilly/Documents/College/CSC 131/Project/wsrp13.jpg");

    JPanel home = new JPanel();
    home.setLayout(null);
    home.setLocation(0,0);
    home.setSize(861, 487);
    home.setBackground(Color.red);
    logInPane.add(home);

    JLabel pic = new JLabel(image);
    pic.setSize(861, 487);
    home.add(pic);

    JPanel box = new JPanel();
    box.setLocation(0,0);
    box.setSize(300, 100);

    JLabel userNameLabel = new JLabel("Username",JLabel.CENTER);
    userNameLabel.setLocation(350,200);
    userNameLabel.setSize(100,40);
    box.add(userNameLabel);

    JTextField userField = new JTextField("", 15);
    userField.setLocation(325,230);
    //userField.setSize(150,30);
    box.add(userField);

    JLabel passwordLabel = new JLabel("Password",JLabel.CENTER);
    passwordLabel.setLocation(350,255);
    passwordLabel.setSize(100,40);
    box.add(passwordLabel);

    JPasswordField passwordField = new JPasswordField(15);
    passwordField.setLocation(325,285);
    //passwordField.setSize(150,30);
    box.add(passwordField);

    logInButton.addActionListener(AL);
    logInButton.setLocation(360,325);
    logInButton.setSize(80,40);
    box.add(logInButton);

    home.add(box);
    logInFrame.setVisible(true);
    logInFrame.setResizable(false);
  }



  static JTextField searchBar = new JTextField(15);
  static JButton newClient = new JButton("New Potential Client");
  static JButton manage = new JButton("Manage");
  static JButton blankForms = new JButton("Blank Forms");
  static JLabel currentUser = new JLabel("CurentUser");
  static JButton topHomeButton = new JButton("Home");


  public static void homePage(){
    ActionListener AL = new project();

    JFrame homeFrame = new JFrame("West Slope Recovery");
    homeFrame.setSize(800, 600);
    homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container homeCont = homeFrame.getContentPane();
    homeCont.setLayout(new BorderLayout());

    //West Panel Start
    JPanel westPanel = new JPanel();
    westPanel.setLayout(new GridLayout(10, 1));


    westPanel.add(searchBar);

    newClient.addActionListener(AL);
    westPanel.add(newClient);

    blankForms.addActionListener(AL);
    westPanel.add(blankForms);

    manage.addActionListener(AL);
    westPanel.add(manage);

    homeCont.add(westPanel, BorderLayout.WEST);
    //West Panel End


    //North Panel Start
    JPanel northPanel = new JPanel();
    northPanel.setLayout(new GridLayout(1,5));


    northPanel.add(currentUser);

    topHomeButton.addActionListener(AL);
    northPanel.add(topHomeButton);

    homeCont.add(northPanel, BorderLayout.NORTH);
    //North Panel End

    //Center Panel Start

    //Center Panel End

    homeFrame.setVisible(true);

  }


  //Creates Frame for Manage Window and all of its elements
  static JButton createNewUser = new JButton("Create New User");
  //static JButton createNewForm = new JButton("Create New Form");
  static JButton resetUserPassword = new JButton("Reset User Password");
  static JButton backupDatabase = new JButton("Backup DataBase");

  public static void manageWindow(){
    ActionListener AL = new project();

    JFrame manageFrame = new JFrame("Manage");
    manageFrame.setSize(500,500);
    Container manageContentPane = manageFrame.getContentPane();
    manageContentPane.setLayout(new FlowLayout());

    createNewUser.addActionListener(AL);
    manageFrame.add(createNewUser);

    /* TBD
       createNewForm.addActionListener(AL);
       manageFrame.add(createNewForm);
       */

    resetUserPassword.addActionListener(AL);
    manageFrame.add(resetUserPassword);

    backupDatabase.addActionListener(AL);
    manageFrame.add(backupDatabase);

    manageFrame.setResizable(false);
    manageFrame.setVisible(true);

  }


  //Creates Frame for generating a report
  //STILL NEED DEMOGRAPHICS!!!
  public static void generateReport(){

  }



  //CREATE NEW USER METHOD
  static JTextField newUsernameField = new JTextField(20);
  static JPasswordField newUserPasswordField = new JPasswordField(20);
  static JPasswordField newUserPasswordCheckField = new JPasswordField(20);
  static JButton createNewUserButton = new JButton("Create New User");

  public static void createNewUser(){
    ActionListener AL = new project();
    JFrame createNewUserFrame = new JFrame("Create New User");
    createNewUserFrame.setSize(500, 400);
    Container cnuContPane = createNewUserFrame.getContentPane();
    cnuContPane.setLayout(new BorderLayout());

    JPanel midPanel = new JPanel(new GridLayout(3,2));

    JLabel title = new JLabel("Create New User");
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

    createNewUserFrame.setVisible(true);
  }


  //RESET PASSWORD METHOD
  static JButton resetUserPass = new JButton("Reset Password");
  static JPasswordField resetPassword = new JPasswordField(20);
  static JPasswordField resetPasswordCheck = new JPasswordField(20);

  public static void resetUserPassword(){
    ActionListener AL = new project();
    JFrame resetPasswordFrame = new JFrame("Reset Password");
    resetPasswordFrame.setSize(500, 400);
    Container resetPasswordCont = resetPasswordFrame.getContentPane();
    resetPasswordCont.setLayout(new BorderLayout());

    JPanel midResetPane = new JPanel();
    midResetPane.setLayout(new GridLayout(3,3));

    JLabel pickUser = new JLabel("User:");
    midResetPane.add(pickUser);

    JLabel userList = new JLabel("User DropList");
    midResetPane.add(userList);

    JLabel newPass = new JLabel("New Password:");
    midResetPane.add(newPass);

    midResetPane.add(resetPassword);

    JLabel newPassCheck = new JLabel("Confirm New Password");
    midResetPane.add(newPassCheck);

    midResetPane.add(resetPasswordCheck);

    resetPasswordCont.add(midResetPane);

    resetUserPass.addActionListener(AL);
    resetPasswordCont.add(resetUserPass, BorderLayout.SOUTH);

    resetPasswordFrame.setResizable(false);
    //resetPasswordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    resetPasswordFrame.setVisible(true);

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
  static JButton form32 = new JButton("Form 32");
  static JButton form33 = new JButton("Form 33");
  static JButton form34 = new JButton("Form 34");
  static JButton form35 = new JButton("Form 35");

  public static void formsList(){
    ActionListener AL = new project();
    JFrame formFrame= new JFrame("Blank Forms");
    formFrame.setSize(400, 400);

    Container contentPane = formFrame.getContentPane();
    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
    //JScrollPane sp = new JScrollPane(contentPane);

    form1.addActionListener(AL);
    form1.setSize(20,50);
    contentPane.add(form1);

    form2.addActionListener(AL);
    form2.setSize(20,50);
    contentPane.add(form2);

    form3.addActionListener(AL);
    form3.setSize(20,50);
    contentPane.add(form3);

    form4.addActionListener(AL);
    form3.setSize(20,50);
    formFrame.add(form4);

    form5.addActionListener(AL);
    formFrame.add(form5);

    form6.addActionListener(AL);
    formFrame.add(form6);

    form7.addActionListener(AL);
    formFrame.add(form7);

    form8.addActionListener(AL);
    formFrame.add(form8);

    form9.addActionListener(AL);
    formFrame.add(form9);

    form10.addActionListener(AL);
    formFrame.add(form10);

    form11.addActionListener(AL);
    formFrame.add(form11);

    form12.addActionListener(AL);
    formFrame.add(form12);

    form13.addActionListener(AL);
    formFrame.add(form13);

    form14.addActionListener(AL);
    formFrame.add(form14);

    form15.addActionListener(AL);
    formFrame.add(form15);

    form16.addActionListener(AL);
    formFrame.add(form16);

    form17.addActionListener(AL);
    formFrame.add(form17);

    form18.addActionListener(AL);
    formFrame.add(form18);

    form19.addActionListener(AL);
    formFrame.add(form19);

    form20.addActionListener(AL);
    formFrame.add(form20);

    form21.addActionListener(AL);
    formFrame.add(form21);

    form22.addActionListener(AL);
    formFrame.add(form22);

    form23.addActionListener(AL);
    formFrame.add(form23);

    form24.addActionListener(AL);
    formFrame.add(form24);

    form25.addActionListener(AL);
    formFrame.add(form25);

    form26.addActionListener(AL);
    formFrame.add(form26);

    form27.addActionListener(AL);
    formFrame.add(form27);

    form28.addActionListener(AL);
    formFrame.add(form28);

    form29.addActionListener(AL);
    formFrame.add(form29);

    form30.addActionListener(AL);
    formFrame.add(form30);

    form31.addActionListener(AL);
    formFrame.add(form31);

    form32.addActionListener(AL);
    formFrame.add(form32);

    form33.addActionListener(AL);
    formFrame.add(form33);

    form34.addActionListener(AL);
    formFrame.add(form34);

    form35.addActionListener(AL);
    formFrame.add(form35);


    formFrame.setResizable(false);
    //formFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    formFrame.setVisible(true);
  }

  public static void formsListWithAutoFill(){

  }

  public void actionPerformed(ActionEvent e){

    if(e.getSource()== logInButton){
      homePage();

    }


    //HOME PAGE ACTIONS
    if(e.getSource() == newClient){
      System.out.println("New Potential Client");
      PDFViewer.openViewer("/Users/lloydforeman/Downloads/WSR Feb 24 Updates/WSR Client File 2014/pdfs/panel 1/1-Screening & Client Information.pdf");
    }

    if(e.getSource() == blankForms){
      formsList();
    }

    if(e.getSource() == manage){
      manageWindow();
    }

    if(e.getSource() == topHomeButton){
      System.out.println("Return to Home Screen");
    }
    //END HOMEPAGE ACTIONS

    //MANAGE ACTIONS
    if(e.getSource() == createNewUser){
      System.out.println("create new User Window");
    }

    /*This Will be determined Later

      if(e.getSource() == createNewForm){
      System.out.println("create new form TBD");
      }

*/

    if(e.getSource() == resetUserPassword){
      System.out.println("reset user Password");
    }

    if(e.getSource() == backupDatabase){
      System.out.println("backupDataBase");
    }

    //END MANAGE ACTIONS


    //RESET USER PASSWORD ACTIONS

    if(e.getSource() == resetUserPass){
      System.out.println("Reset User Password");
    }

    //END RESETUSER PASSWORD ACTIONS

    //CREATE NEW USER ACTIONS
    if(e.getSource() == createNewUserButton){
      System.out.println("Create New User Account");
    }
    //END CREATE NEW USER ACTIONS

    //FORMS ACTIONS
    if(e.getSource() == form1){
      try {
        TextFields.fillFields("/Users/lloydforeman/Downloads/WSR Feb 24 Updates/WSR Client File 2014/pdfs/panel 1/1-Screening & Client Information.pdf","1-Screening & Client Information.pdf");
      } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      } catch (DocumentException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
      PDFViewer.openViewer("/Users/lloydforeman/Downloads/WSR Feb 24 Updates/WSR Client File 2014/pdfs/panel 1/1-Screening & Client Information.pdf");

    }

    if(e.getSource() == form2){
      System.out.println("show form2");
    }

    if(e.getSource() == form3){
      // System.out.println("show form3");
      try {
        TextFields.fillFields("/Users/lloydforeman/Downloads/WSR Feb 24 Updates/WSR Client File 2014/pdfs/panel 1/2-ASAM.pdf","2-ASAM.pdf");
      } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      } catch (DocumentException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
      PDFViewer.openViewer("/Users/lloydforeman/Downloads/WSR Feb 24 Updates/WSR Client File 2014/pdfs/panel 1/2-ASAM.pdf");
    }

    if(e.getSource() == form4){
      System.out.println("show form4");

    }

    if(e.getSource() == form5){
      System.out.println("show form5");
    }

    if(e.getSource() == form6){
      System.out.println("show form6");
    }

    if(e.getSource() == form7){
      System.out.println("show form7");
    }

    if(e.getSource() == form8){
      System.out.println("show form8");
    }

    if(e.getSource() == form9){
      System.out.println("show form9");
    }

    if(e.getSource() == form10){
      System.out.println("show form10");
    }

    if(e.getSource() == form11){
      System.out.println("show form11");
    }

    if(e.getSource() == form12){
      System.out.println("show form12");
    }

    if(e.getSource() == form13){
      System.out.println("show form13");
    }

    if(e.getSource() == form14){
      System.out.println("show form14");
    }

    if(e.getSource() == form15){
      System.out.println("show form15");
    }

    if(e.getSource() == form16){
      System.out.println("show form16");
    }

    if(e.getSource() == form17){
      System.out.println("show form17");
    }

    if(e.getSource() == form18){
      System.out.println("show form18");
    }

    if(e.getSource() == form19){
      System.out.println("show form19");
    }

    if(e.getSource() == form20){
      System.out.println("show form20");
    }

    if(e.getSource() == form21){
      System.out.println("show form21");
    }

    if(e.getSource() == form22){
      System.out.println("show form22");
    }

    if(e.getSource() == form23){
      System.out.println("show form23");
    }

    if(e.getSource() == form24){
      System.out.println("show form24");
    }
    if(e.getSource() == form25){
      System.out.println("show form25");
    }

    if(e.getSource() == form26){
      System.out.println("show form26");
    }

    if(e.getSource() == form27){
      System.out.println("show form27");
    }

    if(e.getSource() == form28){
      System.out.println("show form28");
    }

    if(e.getSource() == form29){
      System.out.println("show form29");
    }

    if(e.getSource() == form30){
      System.out.println("show form30");
    }

    if(e.getSource() == form31){
      System.out.println("show form31");
    }

    if(e.getSource() == form32){
      System.out.println("show form32");
    }

    if(e.getSource() == form33){
      System.out.println("show form33");
    }

    if(e.getSource() == form34){
      System.out.println("show form34");
    }

    if(e.getSource() == form35){
      System.out.println("show form35");
    }
    //END FORMS ACTIONS
  }
}
