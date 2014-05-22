package wsr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;








import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.AcroFields.Item;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;




public class TextFields {


  //retrieve information from pdf form
  public static void retrieveFields(String path) throws FileNotFoundException, DocumentException, IOException, ClassNotFoundException{

    Client client = new Client(); // client object
    DB_Link link = new DB_Link();//database link object
    PdfReader pdfReader = new PdfReader(path);
    AcroFields acroFields = pdfReader.getAcroFields();
    HashMap<String,AcroFields.Item> fields = (HashMap<String, Item>) acroFields.getFields();
    Set<Entry<String, Item>> entrySet = fields.entrySet(); // stores name of acrofields
    String dob1=null,dob2=null,dob3=null; // temp variables for building DOB
    String phone1=null,phone2=null,phone3=null; // temp variables for building phone number

    //parse acrofields for fillable fields
    for (Entry<String, Item> entry : entrySet) {
      String key = entry.getKey();
      if(key.equalsIgnoreCase("FIRST")) {
        client.SetFirstName(acroFields.getField(key));
      }
      else if(key.equalsIgnoreCase("LAST")){
        client.SetLastName(acroFields.getField(key));
      }
      else if(key.equalsIgnoreCase("ADDRESS")){
        client.SetAddress(acroFields.getField(key));
      }
      else if(key.equalsIgnoreCase("CITY")){
        client.SetCity(acroFields.getField(key));
      }
      else if(key.equalsIgnoreCase("STATE")){
        client.SetState(acroFields.getField(key));
      }
      else if(key.equalsIgnoreCase("ZIP")){
        client.SetZip(acroFields.getField(key));
      }
      else if(key.equalsIgnoreCase("COUNTY")){
        client.SetCounty(acroFields.getField(key));
      }
      else if(key.equalsIgnoreCase("DOB1")){
        dob1 = acroFields.getField(key);
      }
      else if(key.equalsIgnoreCase("DOB2")){
        dob2 = acroFields.getField(key);
      }
      else if(key.equalsIgnoreCase("DOB3")){
        dob3 = acroFields.getField(key);
      }
      else if(key.equalsIgnoreCase("AGE")){
        client.SetAge(acroFields.getField(key));
      }
      else if(key.equalsIgnoreCase("LOG#")){
       client.SetID(acroFields.getField(key));

      }
      else if(key.equalsIgnoreCase("PHONE1")){
        phone1 = acroFields.getField(key);
      }
      else if(key.equalsIgnoreCase("PHONE2")){
        phone2 = acroFields.getField(key);
      }
      else if(key.equalsIgnoreCase("PHONE3")){
        phone3 = acroFields.getField(key);;
      }



    }
    //if DOB is on form build DOB
    if(!dob1.equals(null)&&!dob2.equals(null)&&!dob3.equals(null)) {
      String dob = dob1+"/"+dob2+"/"+dob3;
      client.SetDOB(dob);
    }
    //if Phone# is on form build phone number
    if(!phone1.equals(null)&&!phone2.equals(null)&&!phone3.equals(null)) {
      String phone = phone1+"-"+phone2+"-"+phone3;
      client.SetPhone(phone);
    }
    pdfReader.close();//close reader
    client.SetFilePath("/Users/JC/Documents/workspace/wsr/Users/"+client.GetID());
    client.SetGender("Male");
    client.SetRank("INACTIVE");
    link.insert(client);

  }

  //fill fields in pdf
  public static void fillFields(String path,String fileName, String id) throws IOException, DocumentException, ClassNotFoundException {
    PdfReader pdfReader = new PdfReader(path);
    PdfStamper filledOut = new PdfStamper(pdfReader, new FileOutputStream(fileName));//stores new filled out pdf in local directory
    AcroFields acroFields = filledOut.getAcroFields();
    HashMap<String,AcroFields.Item> fields = (HashMap<String, Item>) acroFields.getFields();
    Set<Entry<String, Item>> entrySet = fields.entrySet(); //stores name so of acrofields
    Locale locale = Locale.US;
    Calendar now = Calendar.getInstance(locale);
    DB_Link link = new DB_Link();//database link object
    Client client = link.searchById(id);
    Boolean ThreeFieldFormatDate = false;
    Boolean ThreeFieldFormatPhone = false;


    //parse field names for fillable fields
    for (Entry<String, Item> entry : entrySet) {
      String key = entry.getKey();
      if(key.equalsIgnoreCase("FIRST")) {
        acroFields.setField(key,client.GetFirstName());
      }
      else if(key.equalsIgnoreCase("LAST")){
        acroFields.setField(key,client.GetLastName());
      }
      else if(key.equalsIgnoreCase("ADDRESS")){
        acroFields.setField(key,client.GetAddress());
      }
      else if(key.equalsIgnoreCase("CITY")){
        acroFields.setField(key,client.GetCity());
      }
      else if(key.equalsIgnoreCase("STATE")){
        acroFields.setField(key,client.GetState());
      }
      else if(key.equalsIgnoreCase("ZIP")){
        acroFields.setField(key,client.GetZip());
      }
      else if(key.equalsIgnoreCase("COUNTY")){
        acroFields.setField(key,client.GetCounty());
      }
      else if(key.equalsIgnoreCase("LOG#")){
        acroFields.setField(key,client.GetID());
      }
      else if(key.equalsIgnoreCase("DOB1")){
    	ThreeFieldFormatDate = true;
      }
      
      else if(key.equalsIgnoreCase("AGE")){
        acroFields.setField(key,client.GetAge());
      }
      else if(key.equalsIgnoreCase("PHONE1")){
        ThreeFieldFormatPhone = true;
      }
      else if(key.equalsIgnoreCase("DATE1")){
        acroFields.setField(key,Integer.toString(now.get(Calendar.MONTH)));
      }
      else if(key.equalsIgnoreCase("DATE2")){
        acroFields.setField(key,Integer.toString(now.get(Calendar.DAY_OF_MONTH)));
      }
      else if(key.equalsIgnoreCase("DATE3")){
        acroFields.setField(key,Integer.toString(now.get(Calendar.YEAR)));
      }
      else if(key.equalsIgnoreCase("NAME")){
    	String first = client.GetFirstName();
    	String last = client.GetLastName();
        acroFields.setField(key,first+" "+last);
      }

    }
    if(ThreeFieldFormatPhone == true){
    	String phone = client.GetPhone();
    	String[] split = phone.split("-");
    	acroFields.setField("PHONE1",split[0]);
    	acroFields.setField("PHONE2",split[1]);
    	acroFields.setField("PHONE3",split[2]);
    }
    if(ThreeFieldFormatDate == true) {
    	String phone = client.GetDOB();
    	String[] split = phone.split("/");
    	acroFields.setField("DOB1",split[0]);
    	acroFields.setField("DOB2",split[1]);
    	acroFields.setField("DOB3",split[2]);
    }
    filledOut.close();//close stamper
    pdfReader.close();//close reader

    FileInputStream inStream = null;
    FileOutputStream outStream = null;

    //copy newly created pdf to original pdf's filepath
    try{
      File src =new File(fileName);
      File dest =new File(path);

      inStream = new FileInputStream(src);
      outStream = new FileOutputStream(dest);

      byte[] buffer = new byte[1024];

      int length;
      while ((length = inStream.read(buffer)) > 0){

        outStream.write(buffer, 0, length);

      }

      inStream.close();
      outStream.close();

      //delete the original file
      src.delete();

    }
    catch(IOException e){
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws Exception {

    String path = "/Users/lloydforeman/Downloads/WSR Feb 24 Updates/WSR Client File 2014/pdfs/panel 1/1-Screening & Client Information.pdf";
    String fileName = "1-Screening & Client Information.pdf";
    String id ="2122";
    try {
        retrieveFields(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      fillFields(path,fileName,id);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    

  }


}
