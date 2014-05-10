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
  public static void retrieveFields(String path) throws FileNotFoundException, DocumentException, IOException{

    Client client = new Client(); // client object
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
        client.SetFirstName(key);
      }
      else if(key.equalsIgnoreCase("LAST")){
        client.SetLastName(key);
      }
      else if(key.equalsIgnoreCase("ADDRESS")){
        client.SetAddress(key);
      }
      else if(key.equalsIgnoreCase("CITY")){
        client.SetCity(key);
      }
      else if(key.equalsIgnoreCase("STATE")){
        client.SetState(key);
      }
      else if(key.equalsIgnoreCase("ZIP")){
        client.SetZip(key);
      }
      else if(key.equalsIgnoreCase("COUNTY")){
        client.SetCounty(key);
      }
      else if(key.equalsIgnoreCase("DOB1")){
        dob1 = key;
      }
      else if(key.equalsIgnoreCase("DOB2")){
        dob2 = key;
      }
      else if(key.equalsIgnoreCase("DOB3")){
        dob3 = key;
      }
      else if(key.equalsIgnoreCase("AGE")){
        client.SetAge(key);
      }
      else if(key.equalsIgnoreCase("LOG#")){
        //client.SetID(Integer.parseInt(key));

      }
      else if(key.equalsIgnoreCase("PHONE1")){
        phone1 = key;
      }
      else if(key.equalsIgnoreCase("PHONE2")){
        phone2 = key;
      }
      else if(key.equalsIgnoreCase("PHONE3")){
        phone3 = key;
      }



    }
    //if DOB is on form build DOB
    if(!dob1.equals(null)&&!dob2.equals(null)&&!dob3.equals(null)) {
      String dob = dob1+" "+dob2+" "+dob3;
      client.SetDOB(dob);
    }
    //if Phone# is on form build phone number
    if(!phone1.equals(null)&&!phone2.equals(null)&&!phone3.equals(null)) {
      String phone = phone1+"-"+phone2+"-"+phone3;
      client.SetPhone(phone);
    }
    pdfReader.close();//close reader

  }

  //fill fields in pdf
  public static void fillFields(String path,String fileName) throws IOException, DocumentException {
    PdfReader pdfReader = new PdfReader(path);
    PdfStamper filledOut = new PdfStamper(pdfReader, new FileOutputStream(fileName));//stores new filled out pdf in local directory
    AcroFields acroFields = filledOut.getAcroFields();
    HashMap<String,AcroFields.Item> fields = (HashMap<String, Item>) acroFields.getFields();
    Set<Entry<String, Item>> entrySet = fields.entrySet(); //stores name so of acrofields
    Locale locale = Locale.US;
    Calendar now = Calendar.getInstance(locale);


    //parse field names for fillable fields
    for (Entry<String, Item> entry : entrySet) {
      String key = entry.getKey();
      if(key.equalsIgnoreCase("FIRST")) {
        acroFields.setField(key,"Lloyd");
      }
      else if(key.equalsIgnoreCase("LAST")){
        acroFields.setField(key,"Foreman");
      }
      else if(key.equalsIgnoreCase("ADDRESS")){
        acroFields.setField(key,"123 Main St");
      }
      else if(key.equalsIgnoreCase("CITY")){
        acroFields.setField(key,"Sacramento");
      }
      else if(key.equalsIgnoreCase("STATE")){
        acroFields.setField(key,"CA");
      }
      else if(key.equalsIgnoreCase("ZIP")){
        acroFields.setField(key,"12345");
      }
      else if(key.equalsIgnoreCase("COUNTY")){
        acroFields.setField(key,"Yolo");
      }
      else if(key.equalsIgnoreCase("LOG#")){
        acroFields.setField(key,"1234");
      }
      else if(key.equalsIgnoreCase("DOB1")){
        acroFields.setField(key,"03");
      }
      else if(key.equalsIgnoreCase("DOB2")){
        acroFields.setField(key,"27");
      }
      else if(key.equalsIgnoreCase("DOB3")){
        acroFields.setField(key,"1992");
      }
      else if(key.equalsIgnoreCase("AGE")){
        acroFields.setField(key,"22");
      }
      else if(key.equalsIgnoreCase("PHONE1")){
        acroFields.setField(key,"925");
      }
      else if(key.equalsIgnoreCase("PHONE2")){
        acroFields.setField(key,"405");
      }
      else if(key.equalsIgnoreCase("PHONE3")){
        acroFields.setField(key,"7233");
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
        acroFields.setField(key,"Lloyd Foreman");
      }

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
    try {
      fillFields(path,fileName);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      retrieveFields(path);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }


}
