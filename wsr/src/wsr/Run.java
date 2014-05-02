package wsr;
/*
 *   Run.java --- Interactive packet manipulation tool
 *
 *   Author: Juan Carlos Torres
 *
 *
 *   $Log:  Run.java
 *
 *   Revision 1.0.0  04/30/2014.
 *   -Created to tests functionality of: DataBase.java, DB_Link.java, FileSystem.java, Client.java
 *
 */

import java.util.Scanner;
import java.io.*;

public class Run
{
  public static String field;
  public static String firstName;
  public static String lastName;
  private static String gender;
  private static String filePath;
  private static String id;
  private static String rank;

  public static Scanner input = new Scanner(System.in);
  public static String table = "db_clients";
  public static Client client_test;
   public static FileSystem FS;

  public Run(){
    firstName = "";
    lastName = "";
    gender = "";
    filePath = "";
    id = "";

  }
  public static void main(String[] args) throws ClassNotFoundException {
    DB_Link link = new DB_Link();
    client_test = new Client();
  
    FS = new FileSystem();
    //print table
    link.printTable();

    InputStreamReader input21 = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input21);

    int val = 5;
    while (val != 0) {

      System.out.println("\n\n        MAIN MENU         \n\n");

      System.out.println("    0:  Quit Program");
      System.out.println("    1:  Add Client");
      System.out.println("    2:  Search for Client & Display Info");
      System.out.println("    3:  Update Client");
      System.out.println("    4:  Detele Client");
      System.out.println("    5:  Generate Report");

      System.out.println("\n\n");
      System.out.print("Please make your choice: ");
      try{
        val = input.nextInt();
        input.nextLine();
      }catch(Exception e){
        System.out.println("Bad input data");
      }

      switch (val){

        case 1:
          try{
            System.out.println("   Adding New Client   ");
            System.out.print("Enter New ID: ");
            id = input.nextLine();
            System.out.print("Enter Last Name: ");
            lastName = input.nextLine();
            System.out.print("Enter First Name: ");
            firstName = input.nextLine();
            System.out.print("Enter Gender: ");
            gender = input.nextLine();
          }catch(Exception e){
            System.out.println("Bad input data");
          }

          client_test.SetFirstName(firstName);
          client_test.SetLastName(lastName);
          client_test.SetGender(gender);
          client_test.SetID(id);
          client_test.SetAddress("");
          client_test.SetDOB("");
          client_test.SetAge("");
          client_test.SetCity("");
          client_test.SetState("");
          client_test.SetZip("");
          client_test.SetCounty("");
          client_test.SetPhone("");
          client_test.SetFilePath(FS.getFileSystemPath(id));
          client_test.SetRank("ACTIVE");
          link.insert(client_test);
          break;

        case 2:
          System.out.println("   Seach By ID");
          try{
            System.out.print("Enter ID: ");
            id = reader.readLine();
          }catch(Exception e){
            System.out.println("Bad input data");
          }
          Client temp = link.searchById(id);
          temp.printAll(temp);
          break;

        case 3:
          System.out.println("\n  Updating Client Info  ");
          try{
            System.out.print("Enter ID: ");
            id = input.nextLine();
            System.out.println(" Fields Available: ID, FirstName, LastName, " +
                "Address, DOB, Age, City, State, Zip, " + "County, Phone, Gender, FilePath, Rank)");
            System.out.print("Enter Field To Update: ");
            field = input.nextLine();
            System.out.print("Enter New String: ");
            firstName = input.nextLine();
          }catch(Exception e){
            System.out.println("Bad input data");
          }
          link.update(table, id, firstName, field);
          break;

        case 4:
          System.out.println("Delete by ID");
          try{
            System.out.print("Enter ID: ");
            id = reader.readLine();
          }catch(Exception e){
            System.out.println("Bad input data");
          }
          link.deleteById(id);
          break;

        case 5:
          System.out.println("\n\n   Printing Report     \n\n");
          link.printTable();
          break;

      }
    }
  }
}


