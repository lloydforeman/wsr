package wsr;
/*
 *   FileSystem.java --- Interactive packet manipulation tool
 *
 *   Author: Juan Carlos Torres
 *
 *
 *   $Log:  FileSystem.java
 *
 *   Revision 1.0.0  04/30/2014.
 *   - Creates Folders for new clients, returns the path of the file to enable access to any files
 *     that are saved on this directory
 *
 */

import java.io.File;

public class FileSystem {


  public String AA_PANEL_ONE_TABLE_of_CONTENTS = "PDFs/panel_1/1-AA PANEL ONE TABLE of CONTENTS.pdf";
  public String Screening_Client_Information = "PDFs/panel_1/1-Screening _ Client Information.pdf";
  public String Fire_Response_Plan = "PDFs/panel_1/10-Fire Response Plan.pdf";
  public String ASAM = "PDFs/panel_1/2-ASAM.pdf";
  public String CLIENT_ADMISSION_AGREEMENT_revised = "PDFs/panel_1/4-CLIENT ADMISSION AGREEMENT revised.pdf";
  public String Financial_West_Slope_Recovery = "PDFs/panel_1/5-Financial West Slope Recovery.pdf";
  public String CLIENT_RIGHTS_AND_CONSENT_to_TREATMENT = "PDFs/panel_1/6-CLIENT RIGHTS AND CONSENT to TREATMENT.pdf";
  public String The_Program_and_Resident_Rules = "PDFs/panel_1/7-The Program and Resident Rules.pdf";
  public String Group_Rules = "PDFs/panel_1/8-Group Rules.pdf";
  public String Hygiene_Standards = "PDFs/panel_1/9-Hygiene Standards.pdf";
  public String AA_PANEL_TWO_TABLE_of_CONTENTS = "PDFs/panel_2/1-AA PANEL TWO TABLE of CONTENTS.pdf";
  public String UA = "PDFs/panel_2/1-UA.pdf";
  public String H_Q = "PDFs/panel_2/2-H_Q.pdf";
  public String AA_PANEL_THREE_TABLE_of_CONTENTS = "PDFs/panel_3/1- AA-PANEL THREE TABLE of CONTENTS.pdf";
  public String ADMISSION_BOOKKEEPING_FORM = "PDFs/panel_3/1-ADMISSION BOOKKEEPING FORM.pdf";
  public String CFR_Statement = "PDFs/panel_3/2-CFR Statement.pdf";
  public String Follow_up_and_Consent = "PDFs/panel_3/3-Follow-up and Consent.pdf";
  public String AUTHORIZATION_FOR_RELEASE_OF_PSYCHIATRIC = "PDFs/panel_3/4-AUTHORIZATION FOR RELEASE OF PSYCHIATRIC.pdf";
  public String Consent_Doc1 = "PDFs/panel_3/5-Consent Doc1.pdf";
  public String Consent_Doc2 = "PDFs/panel_3/6-Consent Doc2.pdf";
  public String Criminal_Justice_Release_Doc3 = "PDFs/panel_3/7-Criminal Justice Release Doc3.pdf";
  public String AA_PANEL_FOUR_TABLE_of_CONTENTS = "PDFs/panel_4/1-AA PANEL FOUR TABLE of CONTENTS.pdf";
  public String Awareness_Notice = "PDFs/panel_4/1-Awareness Notice.pdf";
  public String RULES_AND_RIGHTS_VIOLATION = "PDFs/panel_4/2-RULES AND RIGHTS VIOLATION.pdf";
  public String AA_PANEL_FIVE_TABLE_of_CONTENTS = "PDFs/panel_5/1-AA PANEL FIVE TABLE of CONTENTS.pdf";
  public String GROUP_NOTES = "PDFs/panel_5/1-GROUP NOTES.pdf";
  public String One_on1_notes_2 = "PDFs/panel_5/2- 1on1 notes 2.pdf";
  public String TX_Plan = "PDFs/panel_5/3-TX Plan.pdf";
  public String DSM_IV = "PDFs/panel_5/4-DSM IV.pdf";
  public String Phase_Eval = "PDFs/panel_5/6-Phase Eval.pdf";
  public String Phase_II_Info = "PDFs/panel_5/7-Phase II Info.pdf";
  public String AA_PANEL_SIX_TABLE_of_CONTENTS = "PDFs/panel_6/1-AA PANEL SIX TABLE of CONTENTS.pdf";
  public String Exit_Bookkeeping = "PDFs/panel_6/1-Exit Bookkeeping.pdf";
  public String Discharge_Criteria = "PDFs/panel_6/3-Discharge Criteria.pdf";
  public String Discharge_Summary = "PDFs/panel_6/4-Discharge Summary.pdf";
  public String Client_Self_Evaluation_and_Exit_Plan = "PDFs/panel_6/5-Client Self Evaluation and Exit Plan.pdf";
  public String Safekeeping_Agreement = "PDFs/panel_6/6-Safekeeping Agreement.pdf";
  public String LINEN_AGREEMENT = "PDFs/panel_6/7-LINEN AGREEMENT.pdf";

  public FileSystem() {
    //Empty
  }


  public void makefile(String ID){

    String userDir = System.getProperty("user.dir"); 
    File dir = new File(new File(userDir, "Users"), ID);
    if (!dir.exists()){
      dir.mkdirs();
    }

  }

  public String getFileSystemPath(String ID){
    String userDir = System.getProperty("user.dir");
    return userDir +"/Users/" +ID;
  }
}
